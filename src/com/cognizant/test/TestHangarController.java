package com.cognizant.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.controller.AdminController;
import com.cognizant.controller.HangarController;
import com.cognizant.controller.PilotController;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;
import com.cognizant.model.PilotModel;
import com.cognizant.service.HangarService;
import com.cognizant.service.HangarServiceImpl;
import com.cognizant.service.PilotService;
import com.cognizant.service.PilotServiceImpl;
import com.cognizant.service.PlaneService;
import com.cognizant.service.PlaneServiceImpl;
import com.cognizant.validation.HangarValidator;
import com.cognizant.validation.PilotValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestHangarController {
	
	private MockMvc mockMvc;

	@Autowired
	@Spy
	HangarServiceImpl hangarService;
	
	@Autowired
	@Spy @Qualifier("hangarValidator")
	private HangarValidator validator;
	
	@Autowired
	@Spy
	private PlaneServiceImpl planeService;
		
	@InjectMocks
	private HangarController hangarController;

	@Before
	public void init() {
		
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(hangarController)
	                .build();
	}

	@Test
	public void testAllocatePlane_positive() {
		
	try{
			HangarStatusModel hangarStatusModel = new HangarStatusModel();
			
			hangarStatusModel.setAvailableFromDate("uisgacf");
			hangarStatusModel.setAvailableTillDate("ugkdab");
			hangarStatusModel.setHangarId(67);
			hangarStatusModel.setManagerId("sakgd");
			hangarStatusModel.setOccupancyFromDate("slgahd");
			hangarStatusModel.setOccupancyTillDate("sagd");
			hangarStatusModel.setPlaneId(67);
			hangarStatusModel.setStatus("O");
			
			ModelAndView mv = hangarController.allocatePlane(hangarStatusModel);
			
			String actual = mv.getViewName();
			String expected ="hangarAllocationForm";
			assertEquals(expected, actual);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	
	@Test
	public void testPersistHangar_positive(){		
		try{		
		HangarModel hangarModel = new HangarModel();		
		hangarModel.setManagerId("slfihd");		
		hangarModel.setManagerAddressLine1("sdkfjagkjsab");
		hangarModel.setManagerAddressLine2("dffuh");
		hangarModel.setHangarCity("gsddg");
		hangarModel.setHangarState("ufgsd");
		hangarModel.setHangarZipCode(34321);
		Errors errors = new BeanPropertyBindingResult(hangarModel,"HangarId");		
		ModelAndView mv = hangarController.persistHangar(hangarModel,errors);	
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
	public void testSetAllocationView_positive(){
		try{
		MockHttpServletRequest request=new MockHttpServletRequest();
		MockHttpSession session=new MockHttpSession();
		request.setSession(session);
		session.setAttribute("managerId", "MANAGERBBF");
		ModelAndView mv = hangarController.setAllocationView(request);
		String actual = mv.getViewName();
		String expected ="viewHangerAllocation";
		assertEquals(expected,actual);
	}		catch(Exception e){
		e.printStackTrace();
		fail("never Fails");
	}	
	}
	
	@Test
	public void testUpadateHangar_postive(){
		try
		{
			HangarModel hangarModel = new HangarModel();
			hangarModel.setManagerId("slfihd");		
			hangarModel.setManagerAddressLine1("sdkfjagkjsab");
			hangarModel.setManagerAddressLine2("dffuh");
			hangarModel.setHangarCity("gsddg");
			hangarModel.setHangarState("ufgsd");
			hangarModel.setHangarZipCode(34321);
			Errors errors = new BeanPropertyBindingResult(hangarModel,"HangarId");
			ModelAndView mv = hangarController.updateHangar(hangarModel,errors);
			ModelMap map = mv.getModelMap();
			String actual=map.toString();
			String expected ="{status=Your details are submitted successfully}";
			assertEquals(expected, actual);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}
	}
	
	@Test
	public void testUpadateHangarStatus_postive(){
		try
		{
			HangarStatusModel hangarStatusModel = new HangarStatusModel();
			hangarStatusModel.setManagerId("MANAGERBBF");		
			hangarStatusModel.setPlaneId(2);		
			hangarStatusModel.setStatus("O");
			hangarStatusModel.setOccupancyFromDate("04/18/2019");
			hangarStatusModel.setOccupancyTillDate("04/20/2019");
			hangarStatusModel.setAvailableFromDate("04/21/2019");
			hangarStatusModel.setAvailableTillDate("04/24/2019");
			Errors errors = new BeanPropertyBindingResult(hangarStatusModel,"HangarId");
			ModelAndView mv = hangarController.updateHangarStatus(hangarStatusModel,errors);
			ModelMap map = mv.getModelMap();
			String actual=map.toString();
			String expected ="{status=Your details are submitted successfully}";
			assertEquals(expected, actual);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}
	}

	@Test
	public void testViewAllocationForm_positive(){
		try{
			ModelMap map = new ModelMap();
		ModelAndView mv = hangarController.viewAllocationForm(map,87,"dsg");
		String actual = mv.getViewName();
		String expected ="hangarAllocationForm";
		assertEquals(expected,actual);
		}catch(Exception e ){}
		
	}
	
	@Test
	public void testViewHangar_positive(){
		
		ModelMap map = new ModelMap();
		HangarModel hangarModel = new HangarModel();
		hangarModel.setHangarCity("gsddg");
		hangarModel.setHangarId(5445);
		hangarModel.setHangarState("ufgsd");
		hangarModel.setHangarZipCode(34321);
		hangarModel.setManagerAddressLine1("sdkfjagkjsab");
		hangarModel.setManagerAddressLine2("dffuh");
		hangarModel.setManagerId("slfihd");
		try{
			
			ModelAndView mv = hangarController.viewHangar(map, hangarModel, 34);
			
			String actual = mv.getViewName();
			String expected ="viewOneHangar";
			assertEquals(expected, actual);
		}catch(Exception e){}
		
	}
	
	 @Test
	    public void testviewHangars_postive(){
			try{
				ModelMap map = new ModelMap();
				HangarModel hangarModel = new HangarModel();
				hangarModel.setHangarCity("gsddg");
				hangarModel.setHangarId(5445);
				hangarModel.setHangarState("ufgsd");
				hangarModel.setHangarZipCode(34321);
				hangarModel.setManagerAddressLine1("sdkfjagkjsab");
				hangarModel.setManagerAddressLine2("dffuh");
				hangarModel.setManagerId("slfihd");
				
				Errors errors = new BeanPropertyBindingResult(hangarModel, "hangarId");
				
				ModelAndView mv = hangarController.viewHangars();
				String actual = mv.getViewName();
				String expected ="viewHangars";
				assertEquals(expected,actual);
			}		catch(Exception e){
				e.printStackTrace();
				fail("never Fails");
			}
	    }

	 @Test
	    public void testviewHangars_negative(){
	    	try{
				ModelAndView mv = hangarController.viewHangars();
	        assertTrue(true);
	    	}catch(Exception e){
	    		assertTrue(false);
	    		assertEquals("No Pilot in the List",e.getMessage());
	    	}
	    }

}
