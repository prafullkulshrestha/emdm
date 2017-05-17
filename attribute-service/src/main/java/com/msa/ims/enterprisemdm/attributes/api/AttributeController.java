/**
 * 
 */
package com.msa.ims.enterprisemdm.attributes.api;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@Inject
	public AttributeController(AttributeService attributeService) {
		this.attributeService = attributeService;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/class/{industryClassName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Class> getProductListBySearchAndSortCriteria(@PathVariable("industryClassName") final String industryClassName) throws Exception {
		Class classIns = attributeService.getByIndustryClassName(industryClassName);
		return new ResponseEntity<Class>(classIns, HttpStatus.OK);
    }
}
