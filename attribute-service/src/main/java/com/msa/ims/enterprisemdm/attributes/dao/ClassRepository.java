/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.msa.ims.enterprisemdm.attributes.entities.Class;

/**
 * @author AL1165
 *
 */
public interface ClassRepository extends CrudRepository<Class, Long>{

	List<Class> findByIndustryClass(String industryClass);

}