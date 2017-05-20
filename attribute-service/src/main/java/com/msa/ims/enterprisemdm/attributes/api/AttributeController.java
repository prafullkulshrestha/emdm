/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msa.ims.enterprisemdm.attributes.dto.ClassAttributeMapDTO;
import com.msa.ims.enterprisemdm.attributes.entities.Class;
import com.msa.ims.enterprisemdm.attributes.services.AttributeService;

/**
 * @author Prafull
 *
 */
@Controller
@RequestMapping(value = "/attributes")
public class AttributeController {

	private final AttributeService attributeService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	public AttributeController(AttributeService attributeService) {
		this.attributeService = attributeService;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/class/{industryClassName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<List<ClassAttributeMapDTO>>> getProductListBySearchAndSortCriteria(@PathVariable("industryClassName") final String industryClassName) throws Exception {
		logger.debug(String.format("Request received for getting attributes for the industry class with the classname: %s", industryClassName));
		List<Class> classIns = attributeService.getByIndustryClassName(industryClassName);
		List<List<ClassAttributeMapDTO>> classAttributeMapDTOsList = new ArrayList<>();
		classIns.stream().forEach(claaz -> {
			List<ClassAttributeMapDTO> classAttributeMapDTOs = new ArrayList<>();
			claaz.getClassAttributeMaps().stream().forEach(cam -> {classAttributeMapDTOs.add(new ClassAttributeMapDTO(cam));});
			classAttributeMapDTOsList.add(classAttributeMapDTOs);
		});
		
		return new ResponseEntity<List<List<ClassAttributeMapDTO>>>(classAttributeMapDTOsList, HttpStatus.OK);
    }
}
