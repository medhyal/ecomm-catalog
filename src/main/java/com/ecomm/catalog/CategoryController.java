package com.ecomm.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private SkuRepository skuRepo;
	
	@RequestMapping("/category/ping")
	public String getPing() {
		return "hello!!";
	}

	@RequestMapping("/category/{catid}")
	public Category getCategory(@PathVariable(value = "catid") Long catId) {
		return categoryRepo.getById(catId);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/categories/{parentCatId}")
	public List<CategoryDTO> getCategoriesByParent(@PathVariable(value = "parentCatId") Long parentCatId) {
		Iterable<Category> categories = categoryRepo.getByParentCategoryId(parentCatId);

		List categoriesList = new ArrayList<CategoryDTO>();
		for (Category category : categories) {
			categoriesList.add(new CategoryDTO(category.getId(), category.getName(), category.getParentCategoryId(),
					category.getProducts()));
		}
		return categoriesList;
	}

	@RequestMapping("/category/products")
	public List<ProductDTO> getCategoryProducts(@RequestParam Long catId) {
		List<ProductDTO> prodDtos = new ArrayList<ProductDTO>();
		List<Product> products = productRepo.getByParentCategory(catId);

		// TODO - Move this code to api gateway.
		final String uri = "http://ecomm-pricing/api/pricing/pricelist/100";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<SKUPrice[]> skuPricesRE = restTemplate.getForEntity(uri, SKUPrice[].class);
		List<SKUPrice> skuPrices = new ArrayList<SKUPrice>(Arrays.asList(skuPricesRE.getBody()));

		for (Product prodt : products) {
			ProductDTO dto = new ProductDTO(prodt.getId(), prodt.getName(), prodt.getDescription(),
					prodt.getParentCategory(), prodt.getImageUrl());
			for (SKUPrice skuPrice : skuPrices) {
				if (prodt.getSkus().contains(skuPrice.getSku())) {
					dto.addSKUPrice(skuPrice.getSku(), skuPrice.getPrice());
				}
			}
			prodDtos.add(dto);
		}

		return prodDtos;
	}

	@RequestMapping("/category/product/{productid}")
	public ProductDTO getProduct(@PathVariable(value = "productid") Long productid) {
		Product product = productRepo.getById(productid);

		// TODO - Move this code to api gateway.
		final String uri = "http://ecomm-pricing/api/pricing/pricelist/100";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<SKUPrice[]> skuPricesRE = restTemplate.getForEntity(uri, SKUPrice[].class);
		List<SKUPrice> skuPrices = new ArrayList<SKUPrice>(Arrays.asList(skuPricesRE.getBody()));

		ProductDTO dto = new ProductDTO(product.getId(), product.getName(), product.getDescription(),
				product.getParentCategory());
		for (SKUPrice skuPrice : skuPrices) {
			if (product.getSkus().contains(skuPrice.getSku())) {
				dto.addSKUPrice(skuPrice.getSku(), skuPrice.getPrice());
			}
		}

		return dto;
	}

	@PostMapping("/category/create")
	public Category createCategory(@RequestBody CategoryTest catTest) {
		Category category = null;
		if (catTest.getProducts() != null && !catTest.getProducts().isEmpty()) {
			List<CategoryProduct> categoryProducts = new ArrayList<CategoryProduct>();
			long sequence = -1;
			for (String productId : catTest.getProducts()) {
				sequence = sequence + 1;
				CategoryProduct categoryProduct = new CategoryProduct(Long.parseLong(productId), sequence);

				categoryProducts.add(categoryProduct);
			}
			category = new Category(catTest.getName(), catTest.getParentCategoryId(), categoryProducts);
		} else {
			category = new Category(catTest.getName(), catTest.getParentCategoryId());
		}

		return categoryRepo.save(category);
	}
	
	@PostMapping("/product/create")
	public Product createProduct(@RequestBody Product product) {
		// creating sku
		SKU sku = createSku();
		List<Long> skuList = new ArrayList<Long>();
		if (sku != null) {
			skuList.add(sku.getId());
		}
		Product prod = new Product(product.getName(), product.getDescription(), product.getParentCategory(), skuList);
		if (prod != null) {
			prod.setImageUrl(product.getImageUrl());
		}

		return productRepo.save(prod);
	}

	public SKU createSku() {
		SKU sku = new SKU();
		return skuRepo.save(sku);

	}

}
