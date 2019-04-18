package com.cognizant.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.dao.PilotDAO;
import com.cognizant.dao.PilotDAOImpl;
import com.cognizant.entity.Pilot;
import com.cognizant.helper.SessionHelper;

import static org.junit.Assert.*;

@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestPilotDAO {

	private SessionHelper sessionHelper;
	
	@Mock
	private ApplicationContext ioc;
	
	@Mock
	private SessionHelper mockedSessionHelper;
	
	@Mock
	private Session mockedSession;
	@Mock
	private Transaction mockedTransaction;
	@Mock
	private Query mockedQuery;
	
	@Mock
	private List<Pilot> mockedPilotList;

	@Mock
	private Pilot pilot;
	
	@InjectMocks
	private PilotDAOImpl pilotDAOImpl;

	private PilotDAO pilotDAO;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
		sessionHelper=(SessionHelper)ioc.getBean("sessionHelper");
		
		pilotDAOImpl.setSessionHelper(this.sessionHelper);
		Mockito.when(mockedSessionHelper.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Pilot")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedPilotList);
		pilotDAO = Mockito.spy(pilotDAOImpl);
		mockedPilotList=Mockito.spy(pilotDAOImpl.getAllPilots());
		
	}

	@Test
	public void testGetPilotList_positive() 
	{
		assertEquals(true,mockedPilotList.size()>0);	
	}
	
	@Test
	public void testPersistPilot_positive() 
	{
		Pilot pilot = new Pilot();
    	pilot.setPilotLicenseNumber("11");
    	pilot.setPilotAddressLine1("address line 1");
    	pilot.setPilotAddressLine2("address line 2");
    	pilot.setPilotCity("Lucknow");
    	pilot.setPilotState("UP");
    	pilot.setPilotZipCode(226021);
    	pilot.setPilotSsn(11);
    	
		boolean actual = pilotDAOImpl.insertPilot(pilot);
		boolean expected=true;
		assertEquals(expected,actual);
	}

	@Test
	public void testUpdatePilot_positive() 
	{
		Pilot pilot = new Pilot();
    	pilot.setPilotLicenseNumber("11");
    	pilot.setPilotAddressLine1("address line 1");
    	pilot.setPilotAddressLine2("address line 2");
    	pilot.setPilotCity("Lucknow");
    	pilot.setPilotState("UP");
    	pilot.setPilotZipCode(226021);
    	pilot.setPilotSsn(11);
    	
		boolean actual = pilotDAOImpl.insertPilot(pilot);
		boolean expected=true;
		assertEquals(expected,actual);
	}
}