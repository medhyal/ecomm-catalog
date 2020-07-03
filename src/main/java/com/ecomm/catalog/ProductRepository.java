/**
 * 
 */
package com.ecomm.catalog;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rsreenath
 *
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> getByParentCategory(Long parentCategory);
	Product getById(Long id);	

}
