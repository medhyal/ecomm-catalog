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
public interface SkuRepository extends CrudRepository<SKU, Long>{

}
