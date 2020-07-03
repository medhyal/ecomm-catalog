/**
 * 
 */
package com.ecomm.catalog;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * @author rsreenath
 *
 */

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "parentCategoryId")
	private Long parentCategoryId;
	
	@ElementCollection
	@Embedded
	@CollectionTable(name = "category_products",joinColumns=@JoinColumn(name="category_id"))
	private List<CategoryProduct> products; 

	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
		this.products = new CopyOnWriteArrayList<CategoryProduct>();
	}
	
	public Category(Long id, String name, Long parentCategoryId) {
		this.id = id;
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.products = new CopyOnWriteArrayList<CategoryProduct>();
	}
	
	public Category(String name, Long parentCategoryId) {
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.products = new CopyOnWriteArrayList<CategoryProduct>();
	}
	
	public Category(String name, Long parentCategoryId, List<CategoryProduct> products) {
		System.out.println("Inside cat constructor");
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.products = new CopyOnWriteArrayList<CategoryProduct>();
		((CopyOnWriteArrayList<CategoryProduct>) this.products).addAllAbsent(products);
	}
	
	public Category(Long id, String name, Long parentCategoryId, List<CategoryProduct> products) {
		this.id = id;
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.products = new CopyOnWriteArrayList<CategoryProduct>();
		((CopyOnWriteArrayList<CategoryProduct>) this.products).addAllAbsent(products);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<CategoryProduct> getProducts() {
		return Collections.unmodifiableList(this.products);
	}
	
	public boolean addProduct(Long productId, long seqNum) {
		return this.products.add(new CategoryProduct(productId, seqNum));
	}
	
	public boolean removeProduct(Long productId) {
		for(CategoryProduct product : this.products) {
			if(product.getProductId().equals(productId)) {
				return this.products.remove(product);
			}
		}
		
		return false;
	}

	public Long getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
}
