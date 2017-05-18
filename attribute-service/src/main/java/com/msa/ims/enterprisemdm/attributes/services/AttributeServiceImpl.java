/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.services;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msa.ims.enterprisemdm.attributes.dao.ClassRepository;
import com.msa.ims.enterprisemdm.attributes.entities.Class;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeMap;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeValueMap;
import com.msa.ims.enterprisemdm.attributes.entities.MasterAttribute;
/**
 * @author AL1165
 *
 */
@Service("attributeService")
@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
public class AttributeServiceImpl implements AttributeService {
	
	@Inject private ClassRepository industryClassDAO;
	/* (non-Javadoc)
	 * @see com.msa.ims.enterprisemdm.attributes.services.AttributeService#getByIndustryClassName(java.lang.String)
	 */
	@Transactional
	@Override
	public List<Class> getByIndustryClassName(String industryClassName) {
		List<Class> clazz = industryClassDAO.findByIndustryClass(industryClassName);
		return clazz;
	}

}
