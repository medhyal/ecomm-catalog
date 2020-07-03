package com.ecomm.catalog;

public class ProductAttribute {
	
	private String attributeId;
	private long seq;
	
	public ProductAttribute(String attributeId, long seq) {
		this.attributeId = attributeId;
		this.seq = seq;
	}
	
	public String getAttributeId() {
		return attributeId;
	}
	public long getSeq() {
		return seq;
	}
	
	

}
