package com.msa.ims.enterprisemdm.attributes.dto;

import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeValueMap;

public class MasterAttributeChoiceDTO {

	private ClassAttributeValueMap classAttributeValueMap;

	public MasterAttributeChoiceDTO(ClassAttributeValueMap cavm) {
		this.classAttributeValueMap = cavm;
	}

	public Long getClassAttrValSkey() {
		return classAttributeValueMap.getClassAttrValSkey();
	}

	public String getMasterAttrValCode() {
		return this.classAttributeValueMap.getMasterAttributeValue().getMasterAttrValCode();
	}
	
	public String getMasterAttrValShortName() {
		return this.classAttributeValueMap.getMasterAttributeValue().getMasterAttrValShortName();
	}
	
	public String getMasterAttrValLongName() {
		return this.classAttributeValueMap.getMasterAttributeValue().getMasterAttrValLongName();
	}
	public Long getClassAttrSkey() {
		return this.classAttributeValueMap.getClassAttributeMap().getClassAttrSkey();
	}
	public Long getMasterAttrValSkey() {
		return this.classAttributeValueMap.getMasterAttributeValue().getMasterAttrValSkey();
	}
	public boolean isIsDefaultVal() {
        return this.classAttributeValueMap.isIsDefaultVal();
    }
}
