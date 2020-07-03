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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Embedded;

/**
 * @author rsreenath
 *
 */

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String description;

	private Long parentCategory;
	
	private String imageUrl;

	@ElementCollection
	@CollectionTable(name="product_skus",joinColumns=@JoinColumn(name="product_id"))
	private List<Long> skus;

	// private List<ProductAttribute> attributes;
	
	public Product() {
		
	}

	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Product(Long id, String name,String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Product(String name,String description) {
		this.name = name;
		this.description = description;
	}
	
	public Product(String name,String description,Long parentCategory) {
		this.name = name;
		this.description = description;
		this.parentCategory= parentCategory;
	}
	
	public Product(String name,String description,Long parentCategory,List<Long> skus) {
		this.name = name;
		this.description = description;
		this.parentCategory= parentCategory;
		this.skus = new CopyOnWriteArrayList<Long>();
		((CopyOnWriteArrayList<Long>) this.skus).addAllAbsent(skus);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Long parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Long> getSkus() {
		return Collections.unmodifiableList(this.skus);
	}

	public boolean addSku(Long sku) {
		return this.skus.add(sku);
	}

	public boolean removeSku(Long sku) {
		return this.skus.remove(sku);
	}

	public Long getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	// public List<ProductAttribute> getAttributes() {
	// return Collections.unmodifiableList(this.attributes);
	// }

	// public boolean addAttribute(String attributeId, long seqNum) {
	// return this.attributes.add(new ProductAttribute(attributeId, seqNum));
	// }

	// public boolean removeAttribute(String attributeId) {
	// for(ProductAttribute attribute : this.attributes) {
	// if(attribute.getAttributeId().equalsIgnoreCase(attributeId)) {
	// return this.attributes.remove(attribute);
	// }
	// }
	//
	// return false;
	// }

}
