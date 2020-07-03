/**
 * 
 */
package com.ecomm.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rsreenath
 *
 */

@Entity
public class SKU {

	@Id
	@GeneratedValue
	private Long id;

	public SKU() {
	}
	
	public Long getId() {
		return id;
	}

}
