package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.dao.PilotDAO;
import com.cognizant.dao.PilotDAOImpl;
import com.cognizant.helper.SessionHelper;
import com.cognizant.model.PilotModel;
import com.cognizant.service.PilotServiceImpl;

public class TestPilotService {
	
	private MockMvc mockMvc;
	private PilotModel pilotModel;
	
	@Autowired
	@Spy
	private PilotDAOImpl pilotDAO;

	@Mock
	private SessionHelper mockedSessionHelper;

    @InjectMocks
	private PilotServiceImpl pilotServiceImpl;

	@Before
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pilotServiceImpl)
                .build();
        pilotModel  = new PilotModel();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPersistPilot_positive() {
    	try{
		pilotModel.setPilotLicenseNumber("11");
    	pilotModel.setPilotAddressLine1("address line 1");
    	pilotModel.setPilotAddressLine2("address line 2");
    	pilotModel.setPilotCity("Lucknow");
    	pilotModel.setPilotState("UP");
    	pilotModel.setPilotZipCode(226021);
    	pilotModel.setPilotSsn(11);
		
			boolean actual = pilotServiceImpl.persistPilot(pilotModel);
			boolean expected = true;
			assertEquals(expected, actual);
		}catch(Exception e){
		    fail("Not yet implemented");
		}
	}
		
	@Test
	public void testUpdatePilot_positive() {
		try{
		pilotModel.setPilotLicenseNumber("11");
    	pilotModel.setPilotAddressLine1("address line 1");
    	pilotModel.setPilotAddressLine2("address line 2");
    	pilotModel.setPilotCity("Lucknow");
    	pilotModel.setPilotState("UP");
    	pilotModel.setPilotZipCode(226021);
    	pilotModel.setPilotSsn(11);
    	
		boolean actual = pilotServiceImpl.updatePilot(pilotModel);
		boolean expected = true;
		assertEquals(expected, actual);
			}catch(Exception e){
				fail("wrong user");
			}
		
	}
	
}
