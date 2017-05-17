/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.msa.ims.enterprisemdm.attributes.entities.Class;
/**
 * @author AL1165
 *
 */
@Service
public class AttributeServiceImpl implements AttributeService {

	/* (non-Javadoc)
	 * @see com.msa.ims.enterprisemdm.attributes.services.AttributeService#getByIndustryClassName(java.lang.String)
	 */
	@Override
	public Class getByIndustryClassName(String industryClassName) {
		// TODO Auto-generated method stub
		return new Class();
	}

}
