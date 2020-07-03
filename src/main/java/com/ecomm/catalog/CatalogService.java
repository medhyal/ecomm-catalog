/**
 * 
 */
package com.ecomm.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author rsreenath
 *
 */

@Service
public class CatalogService {
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductRepository productRepo;
	
	public Category getCategory(Long catId) {
		return categoryRepo.getById(catId);
	}
	
	public Optional<Category> getCategoryById(Long catId) {
		return categoryRepo.findById(catId);
	}
	
	public List<CategoryDTO> getCategoriesByParent(Long parentCatId) {
		Iterable<Category> categories = categoryRepo.getByParentCategoryId(parentCatId);

		List<CategoryDTO> categoriesList = new ArrayList<CategoryDTO>();
		for (Category category : categories) {
			categoriesList.add(new CategoryDTO(category.getId(), category.getName(), category.getParentCategoryId(),
					category.getProducts()));
		}
		return categoriesList;
	}

	public List<ProductDTO> getCategoryProducts(Long catId) {
		List<ProductDTO> prodDtos = new ArrayList<ProductDTO>();
		List<Product> products = productRepo.getByParentCategory(catId);
		
		//TODO - Move this code to api gateway.
		final String uri = "http://ecomm-pricing/api/pricing/pricelist/100";
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<SKUPrice[]> skuPricesRE = restTemplate.getForEntity(uri, SKUPrice[].class);
	    List<SKUPrice> skuPrices = new ArrayList<SKUPrice>(Arrays.asList(skuPricesRE.getBody()));
	    
	    for(Product prodt : products) {
	    	ProductDTO dto = new ProductDTO(prodt.getId(), prodt.getName(), prodt.getDescription(), prodt.getParentCategory(), prodt.getImageUrl()); 
	    	for(SKUPrice skuPrice : skuPrices) {
	    		if(prodt.getSkus().contains(skuPrice.getSku())) {
	    			dto.addSKUPrice(skuPrice.getSku(), skuPrice.getPrice());
	    		}
	    	}
	    	prodDtos.add(dto);
	    }
	    
		return prodDtos;
	}

	public ProductDTO getProduct(Long productid) {
		Product product = productRepo.getById(productid);

		// TODO - Move this code to api gateway and use API composition
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
	
	public Category saveCategory(Category cat) {
		return categoryRepo.save(cat);
	}
	
	@Transactional
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}
	

}
