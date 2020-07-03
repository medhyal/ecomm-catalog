/**
 * 
 */
package com.ecomm.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rsreenath
 *
 */
public class ProductDTO {
	
	private Long id;

	private String name;

	private String description;

	private Long parentCategory;
	
	private List<SKUPrice> skus;
	
	private String imageUrl;
	
	public ProductDTO(Long id, String name, String description, Long parentCategory, String imageUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentCategory = parentCategory;
		this.skus = new ArrayList<SKUPrice>();
		this.imageUrl = imageUrl;
	}
	
	public ProductDTO(Long id, String name, String description, Long parentCategory) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentCategory = parentCategory;
		this.skus = new ArrayList<SKUPrice>();
	}
	
	public void addSKUPrice(Long skuId, BigDecimal price) {
		this.skus.add(new SKUPrice(skuId, price));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getParentCategory() {
		return parentCategory;
	}

	public List<SKUPrice> getSkus() {
		return Collections.unmodifiableList(this.skus);
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
}
