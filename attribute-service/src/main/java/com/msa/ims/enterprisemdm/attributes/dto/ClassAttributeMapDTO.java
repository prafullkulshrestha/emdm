/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.dto;

import java.util.ArrayList;
import java.util.List;

import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeMap;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeValueMap;

/**
 * @author AL1165
 *
 */
public class ClassAttributeMapDTO {
	
	private ClassAttributeMap classAttributeMap;
	
	public ClassAttributeMapDTO(ClassAttributeMap classAttributeMap){
		this.classAttributeMap = classAttributeMap;
	}
	
	public int getMasterAttrDisplaySeq(){
		return classAttributeMap.getMasterAttrDisplaySeq();
	}
	
	public int getMasterAttrDescSeq(){
		return classAttributeMap.getMasterAttrDescSeq();
	}
	public String getMasterAttrBusImp(){
		return classAttributeMap.getMasterAttrBusImp();
	}
	
	public String getIndustrySegment(){
		return classAttributeMap.getClassIns().getIndustrySegment();
	}
	
	public String getIndustrySector(){
		return classAttributeMap.getClassIns().getIndustrySector();
	}
	
	public String getIndustryClass(){
		return classAttributeMap.getClassIns().getIndustryClass();
	}
	
	public Long getClassAttrSkey(){
		return classAttributeMap.getClassAttrSkey();
	}
	
	public Long getAttrSkey(){
		return classAttributeMap.getMasterAttribute().getAttrSkey();
	}
	
	public String getMasterAttrName(){
		return classAttributeMap.getMasterAttribute().getMasterAttrName();
	}
	
	public String getMasterAttrType(){
		return classAttributeMap.getMasterAttribute().getMasterAttrType();
	}
	
	public String getMasterAttrDisplayName(){
		return classAttributeMap.getMasterAttribute().getMasterAttrDisplayName();
	}
	
	public List<MasterAttributeChoiceDTO> getMasterAttributeChoices() {
		List<ClassAttributeValueMap> clsAttriValMaps = new ArrayList<>(classAttributeMap.getClassAttributeValueMaps());
		List<MasterAttributeChoiceDTO> macds = new ArrayList<>();

		clsAttriValMaps.forEach(cavm -> {
			macds.add(new MasterAttributeChoiceDTO(cavm));
		});
		return macds;
	}
}
