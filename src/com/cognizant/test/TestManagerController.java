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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.controller.ManagerController;
import com.cognizant.model.ManagerModel;
import com.cognizant.service.ManagerService;
import com.cognizant.validation.ManagerLoginValidator;
import com.cognizant.validation.ManagerRegistrationValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/applicationContext.xml"})
public class TestManagerController {
	
	private MockMvc mockMvc;
	private ManagerModel managerModel;
	
	@Autowired
	@Spy
    private ManagerService managerService;
	
	@Autowired
	@Spy
    private ManagerLoginValidator loginValidator;
	
	@Autowired
	@Spy
    private ManagerRegistrationValidator registerValidator;
	    
    @InjectMocks
    private ManagerController managerController;
    
	@Before
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(managerController)
                .build();
        managerModel =  new ManagerModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testViewRegistrationPage_positive() {
       
		managerModel.setManagerAge(23);
		managerModel.setManagerAltContactNo(5454754);
		managerModel.setManagerContactNo(446456);
		managerModel.setManagerDob("5456565");
		managerModel.setManagerEmailId("fgfrefr");
		managerModel.setManagerFirstName("rakesh");
		managerModel.setManagerGender("dfdfd");
		//managerModel.setManagerId("142");
		managerModel.setManagerLastName("fdfdfd");
		managerModel.setManagerPassword("kira");
		managerModel.setManagerStatus("frd");
		Errors errors = new BeanPropertyBindingResult(managerModel,"managerModel");
		ModelMap map=new ModelMap();
		try{
			ModelAndView mv = managerController.viewRegistrationPage(managerModel, errors); 
			String actual = mv.getViewName();
			String expected = "managerRegister";
			assertEquals(expected, actual);
		}catch(Exception e){
			e.printStackTrace();
			fail("wrong fieldssdsdsdsdsds");
		}
	}
	
	@Test
	public void testViewRegistrationPage_negative() {
		try{
			ModelMap map=new ModelMap();

			Errors errors = new BeanPropertyBindingResult(managerModel,"managerModel");
		ModelAndView mv = managerController.viewRegistrationPage(managerModel, errors);
		assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
			fail("null fields");
		}
	}
	
	@Test
	public void testManagerLogin_positive() {
		MockHttpServletRequest request = new MockHttpServletRequest();		
		managerModel.setManagerId("MANAGERBBF");
		managerModel.setManagerPassword("aaaa");
		Errors errors = new BeanPropertyBindingResult(managerModel,"managerModel");
		try{
			ModelAndView mv = managerController.managerLogin(managerModel, errors, request);
			String actual = mv.getViewName();
			String expected = "welcomeManager";
			assertEquals(expected, actual);
		}catch(Exception e){
			fail("wrong fields");
		}
	}
	
	@Test
	public void testManagerLogin_negative() {
		MockHttpServletRequest request = new MockHttpServletRequest();		
		try{
			Errors errors = new BeanPropertyBindingResult(managerModel,"managerModel");
			ModelAndView mv = managerController.managerLogin(managerModel, errors, request);
			assertTrue(true);
			}catch(Exception e){
				assertTrue(false);
				fail("null fields");
			}
	}
}
