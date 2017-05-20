package com.msa.ims.enterprisemdm.attributes;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.msa.ims.enterprisemdm.attributes.entities.Class;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.msa.ims.enterprisemdm.attributes.services.AttributeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttributeServiceApplicationTests {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
    AttributeServiceImpl attributeService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
    public void testGetByValidIndustryClassName() throws Exception {
		
		String industryClassName = "Cigarettes";
		int numberOfRecordsExpected = 1;

        List<Class> industryClassObjs = attributeService.getByIndustryClassName(industryClassName);


        Assert.isTrue(!CollectionUtils.isEmpty(industryClassObjs),
                String.format("No data found for the industry class with the name: %s", industryClassName));
        Assert.isTrue(industryClassObjs.size() == numberOfRecordsExpected,
                String.format("No of records found for the industry class with the name: %s : is not equal to %d", industryClassName, numberOfRecordsExpected));

          }
	
	@Test
    public void testGetByInvalidIndustryClassName() throws Exception {
		
		String industryClassName = "Cigaretes";
		int numberOfRecordsExpected = 0;

        List<Class> industryClassObjs = attributeService.getByIndustryClassName(industryClassName);


        Assert.isTrue(CollectionUtils.isEmpty(industryClassObjs),
                String.format("Data found for the industry class with the invalid name: %s", industryClassName));
        Assert.isTrue(industryClassObjs.size() == numberOfRecordsExpected,
                String.format("No of records found for the industry class with the name: %s : is not equal to %d", industryClassName, numberOfRecordsExpected));

          }


}
