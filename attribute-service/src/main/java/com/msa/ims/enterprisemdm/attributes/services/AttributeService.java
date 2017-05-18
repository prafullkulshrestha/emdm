package com.msa.ims.enterprisemdm.attributes.services;

import java.util.List;

import com.msa.ims.enterprisemdm.attributes.entities.Class;

public interface AttributeService {

	List<Class> getByIndustryClassName(String industryClassName);

}
