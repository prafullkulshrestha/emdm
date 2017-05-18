/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeMap;
import com.msa.ims.enterprisemdm.attributes.entities.ClassAttributeValueMap;
import com.msa.ims.enterprisemdm.attributes.entities.MasterAttribute;

/**
 * @author AL1165
 *
 */
public class MasterAttributeMapDTO {

	private ClassAttributeMap cam;

	public MasterAttributeMapDTO(ClassAttributeMap cam) {
		this.cam = cam;
	}

	public String getMasterAttrName() {
		return cam.getMasterAttribute().getMasterAttrName();
	}

	public String getMasterAttrDisplayName() {
		return cam.getMasterAttribute().getMasterAttrDisplayName();
	}

	public String getMasterAttrType() {
		return cam.getMasterAttribute().getMasterAttrType();
	}

	public List<MasterAttributeChoiceDTO> getMasterAttributeChoices() {
		List<ClassAttributeValueMap> clsAttriValMaps = new ArrayList<>(cam.getClassAttributeValueMaps());
		List<MasterAttributeChoiceDTO> macds = new ArrayList<>();

		clsAttriValMaps.forEach(cavm -> {
			macds.add(new MasterAttributeChoiceDTO(cavm));
		});
		return macds;
	}
}
