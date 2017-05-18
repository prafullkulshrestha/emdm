/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.msa.ims.enterprisemdm.attributes.entities.Class;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeMap;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeValueMap;
import com.msa.ims.enterprisemdm.attributes.entities.MasterAttributeValue;
/**
 * @author AL1165
 *
 */
public class PrimaryAttributeByClassDTO {
	
	private Class clazz;
	
	public PrimaryAttributeByClassDTO(Class clazz){
		this.clazz = clazz;
	}
	
	public String getIndustrySegment(){
		return clazz.getIndustrySegment();
	}
	
	public String getIndustrySector(){
		return clazz.getIndustrySector();
	}
	
	public String getIndustryClass(){
		return clazz.getIndustryClass();
	}
	
	public List<ClassAttributeMapDTO> getClassAttributeMaps(){
		Set<ClassAttributeMap> attrMaps = clazz.getClassAttributeMaps();
		List<ClassAttributeMapDTO> sttrMapsDTOs = new ArrayList<>();
		attrMaps.stream().forEach(attr -> {
			sttrMapsDTOs.add(new ClassAttributeMapDTO(attr));
		});
		return sttrMapsDTOs;
	}
	
	public List<MasterAttributeMapDTO> getMasterAttributes(){
		Set<ClassAttributeMap> attrMaps = clazz.getClassAttributeMaps();
		List<MasterAttributeMapDTO> mstAttrDTOs = new ArrayList<>();
		attrMaps.stream().forEach(attr -> {
			mstAttrDTOs.add(new MasterAttributeMapDTO(attr));
		});
		return mstAttrDTOs;
	}
	
	
}
