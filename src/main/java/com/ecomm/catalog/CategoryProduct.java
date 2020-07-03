/**
 * 
 */
package com.ecomm.catalog;

import javax.persistence.Embeddable;


/**
 * @author rsreenath
 *
 */

@Embeddable
public class CategoryProduct {
	
	private Long productId;
	private long seqNum;
	
	public CategoryProduct() {
		
	}
	
	public CategoryProduct(Long productId, long seqNum) {
		this.setProductId(productId);
		this.setSeqNum(seqNum);
	}

	public Long getProductId() {
		return productId;
	}

	public long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
