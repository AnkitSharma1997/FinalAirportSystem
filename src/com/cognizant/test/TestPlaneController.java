package com.cognizant.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.controller.PlaneController;
import com.cognizant.exception.PlaneNotFound;
import com.cognizant.model.PlaneModel;
import com.cognizant.model.PlaneModel;
import com.cognizant.service.PlaneServiceImpl;
import com.cognizant.validation.PlaneValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestPlaneController {
	
	private MockMvc mockMvc;
	
	@Autowired
	@Spy
	private PlaneServiceImpl planeServiceImpl;
	
	 @Autowired
	 @Spy @Qualifier("planeValidator")
	 private PlaneValidator validator; 	
	 
	 @InjectMocks
	 private PlaneController planeController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(planeController)
                .build();
	}
	
	@Test
	public void testPersistPlaneMethod_positive() {
		try
		{
		PlaneModel planeModel = new PlaneModel();
		planeModel.setOwnerFirstName("Arushi");
		planeModel.setOwnerLastName("Rastogi");
		planeModel.setOwnerContactNo(87878798);
		planeModel.setOwnerEmail("arushi.rastogi02@gmail.com");
		planeModel.setPlaneCapacity(99);
		planeModel.setPlaneType("dsfa");
		
		Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
		
		ModelAndView mv = planeController.persistPlane(planeModel, errors);
		
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
public void testUpdatePlane_positive() {
		try
		{
		PlaneModel planeModel = new PlaneModel();
		planeModel.setPlaneId(12);
		planeModel.setOwnerId(32423);
		planeModel.setOwnerFirstName("Arushi");
		planeModel.setOwnerLastName("Rastogi");
		planeModel.setOwnerContactNo(87878798);
		planeModel.setOwnerEmail("arushi.rastogi02@gmail.com");
		planeModel.setPlaneCapacity(99);
		planeModel.setPlaneType("dsfa");
		
		Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
		
		ModelAndView mv = planeController.updatePlane(planeModel, errors);
		
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
	    public void testviewPlanes_postive(){
			try{
				ModelMap map = new ModelMap();
				PlaneModel planeModel = new PlaneModel();
				planeModel.setPlaneId(12);
				planeModel.setOwnerId(32423);
				planeModel.setOwnerFirstName("Arushi");
				planeModel.setOwnerLastName("Rastogi");
				planeModel.setOwnerContactNo(87878798);
				planeModel.setOwnerEmail("arushi.rastogi02@gmail.com");
				planeModel.setPlaneCapacity(99);
				planeModel.setPlaneType("dsfa");
				
				Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
				
				ModelAndView mv = planeController.viewPlanes();
				String actual = mv.getViewName();
				String expected ="viewPlanes";
				assertEquals(expected,actual);
			}		catch(Exception e){
				e.printStackTrace();
				fail("never Fails");
			}
	    }
	
	 @Test
	    public void testviewPlanes_negative(){
	    	try{
	    	ModelAndView mv=planeController.viewPlanes();
	        assertTrue(true);
	    	}catch(PlaneNotFound e){
	    		assertTrue(true);
	    		assertEquals("No Plane in the List",e.getMessage());
	    	}
	    }
	
	
	@Test
	public void testViewPlane_positive() {
		try{
			ModelMap map = new ModelMap();
			PlaneModel planeModel = new PlaneModel();
			planeModel.setPlaneId(12);
			planeModel.setOwnerId(32423);
			planeModel.setOwnerFirstName("Arushi");
			planeModel.setOwnerLastName("Rastogi");
			planeModel.setOwnerContactNo(87878798);
			planeModel.setOwnerEmail("arushi.rastogi02@gmail.com");
			planeModel.setPlaneCapacity(99);
			planeModel.setPlaneType("dsfa");
			
			Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
			
			ModelAndView mv = planeController.viewPlane(map, planeModel, 5);
			String actual = mv.getViewName();
			String expected ="viewOnePlane";
			assertEquals(expected,actual);
		}		catch(Exception e){
			e.printStackTrace();
			fail("never Fails");
		}
		}
}
