/**
 * 
 */
package com.ecomm.catalog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * @author rsreenath
 *
 */

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Category getById(Long id);	
	
	Iterable<Category> getByParentCategoryId(Long parentCategoryId);
	
		
}
