package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.controller.HangarController;
import com.cognizant.controller.PilotController;
import com.cognizant.exception.PilotNotFound;
import com.cognizant.model.PilotModel;
import com.cognizant.service.PilotService;
import com.cognizant.service.PilotServiceImpl;
import com.cognizant.validation.PilotValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestPilotController {
	
	private MockMvc mockMvc;
	
	@Autowired
	@Spy
	private PilotServiceImpl pilotServiceImpl;
	
	 @Autowired
	 @Spy @Qualifier("pilotValidator")
	 private PilotValidator validator; 	
	 
	 @InjectMocks
	 private PilotController pilotController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pilotController)
                .build();
	}
	
	@Test
	public void testPersistPilotMethod_positive() {
		try
		{
		PilotModel pilotModel = new PilotModel();
    	pilotModel.setPilotLicenseNumber("11");
    	pilotModel.setPilotAddressLine1("address line 1");
    	pilotModel.setPilotAddressLine2("address line 2");
    	pilotModel.setPilotCity("Lucknow");
    	pilotModel.setPilotState("UP");
    	pilotModel.setPilotZipCode(226021);
    	pilotModel.setPilotSsn(11);
		
		Errors errors = new BeanPropertyBindingResult(pilotModel, "pilotId");
		
		ModelAndView mv = pilotController.persistPilot(pilotModel, errors);
		
		ModelMap map = mv.getModelMap();
		String actual=map.toString();
		String expected ="{status=Your details are submitted successfully}";
		assertEquals(expected,actual);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}
	}
	
	@Test
public void testUpdatePilot_positive() {
		try
		{
		PilotModel pilotModel = new PilotModel();
    	pilotModel.setPilotLicenseNumber("11");
    	pilotModel.setPilotAddressLine1("address line 1");
    	pilotModel.setPilotAddressLine2("address line 2");
    	pilotModel.setPilotCity("Lucknow");
    	pilotModel.setPilotState("UP");
    	pilotModel.setPilotZipCode(226021);
    	pilotModel.setPilotSsn(11);
		
		Errors errors = new BeanPropertyBindingResult(pilotModel, "pilotId");
		
		ModelAndView mv = pilotController.updatePilot(pilotModel, errors);
		
		ModelMap map = mv.getModelMap();
		String actual=map.toString();
		String expected ="{status=Your details are submitted successfully}";
		assertEquals(expected,actual);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}		
	}
	
	 @Test
	    public void testviewPilots_postive(){
			try{
				ModelMap map = new ModelMap();
				PilotModel pilotModel = new PilotModel();
		    	pilotModel.setPilotLicenseNumber("11");
		    	pilotModel.setPilotAddressLine1("address line 1");
		    	pilotModel.setPilotAddressLine2("address line 2");
		    	pilotModel.setPilotCity("Lucknow");
		    	pilotModel.setPilotState("UP");
		    	pilotModel.setPilotZipCode(226021);
		    	pilotModel.setPilotSsn(11);
				
				Errors errors = new BeanPropertyBindingResult(pilotModel, "pilotId");
				
				ModelAndView mv = pilotController.viewPilots();
				String actual = mv.getViewName();
				String expected ="viewPilots";
				assertEquals(expected,actual);
			}		catch(Exception e){
				e.printStackTrace();
				fail("never Fails");
			}
	    }

	 @Test
	    public void testviewPilots_negative(){
	    	try{
	    	ModelAndView mv=pilotController.viewPilots();
	        assertTrue(true);
	    	}catch(PilotNotFound e){
	    		assertTrue(false);
	    		assertEquals("No Pilot in the List",e.getMessage());
	    	}
	    }
	
	@Test
	public void testViewPilot_positive() {
		try{
			ModelMap map = new ModelMap();
			PilotModel pilotModel = new PilotModel();
	    	pilotModel.setPilotLicenseNumber("11");
	    	pilotModel.setPilotAddressLine1("address line 1");
	    	pilotModel.setPilotAddressLine2("address line 2");
	    	pilotModel.setPilotCity("Lucknow");
	    	pilotModel.setPilotState("UP");
	    	pilotModel.setPilotZipCode(226021);
	    	pilotModel.setPilotSsn(11);
			
			Errors errors = new BeanPropertyBindingResult(pilotModel, "pilotId");
			
			ModelAndView mv = pilotController.viewPilot(map, pilotModel, 2);
			String actual = mv.getViewName();
			String expected ="viewOnePilot";
			assertEquals(expected,actual);
		}		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}
		}
}
