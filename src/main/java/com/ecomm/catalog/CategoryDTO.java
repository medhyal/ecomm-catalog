/**
 * 
 */
package com.ecomm.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;

/**
 * @author rsreenath
 *
 */
public class CategoryDTO {
	
	private Long id;
	
	private String name;
		
	private Long parentCategoryId;
	
	private List<CategoryProduct> products;
	
	public CategoryDTO(Long id, String name, Long parentCategoryId, List<CategoryProduct> products) {
		this.id = id;
		this.name = name;		
		this.parentCategoryId = parentCategoryId;
		this.products = new ArrayList<CategoryProduct>(products);
	}
	
	public CategoryDTO(Long id, String name, Long parentCategoryId) {
		this.id = id;
		this.name = name;		
		this.parentCategoryId = parentCategoryId;		
	}
	
	public void addSKUPrice(Long productId, long seqNum) {
		this.products.add(new CategoryProduct(productId, seqNum));
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public List<CategoryProduct> getProducts() {
		return Collections.unmodifiableList(this.products);
	}
	
}
