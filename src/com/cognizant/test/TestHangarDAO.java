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

import com.cognizant.dao.HangarDAO;
import com.cognizant.dao.HangarDAOImpl;
import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.helper.SessionHelper;
import com.cognizant.model.HangarStatusModel;

import static org.junit.Assert.*;

@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestHangarDAO {

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
	private List<Hangar> mockedHangarList;

	@Mock
	private List<HangarStatus> mockedHangarStatusList;

	@Mock
	private Hangar hangar;
	
	@Mock
	private HangarStatus hangarStatus;

	@InjectMocks
	private HangarDAOImpl hangarDAOImpl;

	private HangarDAO hangarDAO;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
		sessionHelper=(SessionHelper)ioc.getBean("sessionHelper");
		
		hangarDAOImpl.setSessionHelper(this.sessionHelper);
		Mockito.when(mockedSessionHelper.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Hangar")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedHangarList);
		hangarDAO = Mockito.spy(hangarDAOImpl);
		mockedHangarList=Mockito.spy(hangarDAOImpl.getAllHangars());		
	}

	@Test
	public void testGetHangarList_positive() 
	{
		assertEquals(true,mockedHangarList.size()>0);	
	}
	
	@Test
	public void testGetHangarStatusList_positive() 
	{
		Mockito.when(mockedSession.createQuery("from HangarStatus")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedHangarStatusList);
		hangarDAO = Mockito.spy(hangarDAOImpl);
		mockedHangarStatusList=Mockito.spy(hangarDAOImpl.getAllHangarStatus());		

		assertEquals(true,mockedHangarStatusList.size()>0);	
	}

	@Test
	public void testPersistHangar_positive() 
	{
		Hangar hangar = new Hangar();
		hangar.setManagerId("slfihd");		
		hangar.setManagerAddressLine1("sdkfjagkjsab");
		hangar.setManagerAddressLine2("dffuh");
		hangar.setHangarCity("gsddg");
		hangar.setHangarState("ufgsd");
		hangar.setHangarZipCode(34321);
    	
		boolean actual = hangarDAOImpl.insertHangar(hangar);
		boolean expected=true;
		assertEquals(expected,actual);
	}

	@Test
	public void testUpdateHangarStatus_positive() 
	{
		HangarStatus hangarStatus = new HangarStatus();
		hangarStatus.setManagerId("MANAGERBBF");		
		hangarStatus.setPlaneId(2);		
		hangarStatus.setStatus("O");
		hangarStatus.setOccupancyFromDate("04/18/2019");
		hangarStatus.setOccupancyTillDate("04/20/2019");
		hangarStatus.setAvailableFromDate("04/21/2019");
		hangarStatus.setAvailableTillDate("04/24/2019");
    	
		boolean actual = hangarDAOImpl.updateHangarStatus(hangarStatus);
		boolean expected=true;
		assertEquals(expected,actual);
	}

	@Test
	public void testAllocatePlane_positive() 
	{
		HangarStatus hangarStatus = new HangarStatus();
		hangarStatus.setManagerId("MANAGERBBF");		
		hangarStatus.setPlaneId(2);		
		hangarStatus.setStatus("O");
		hangarStatus.setOccupancyFromDate("04/18/2019");
		hangarStatus.setOccupancyTillDate("04/20/2019");
		hangarStatus.setAvailableFromDate("04/21/2019");
		hangarStatus.setAvailableTillDate("04/24/2019");
    	
		boolean actual = hangarDAOImpl.allocatePlane(hangarStatus);
		boolean expected=true;
		assertEquals(expected,actual);
	}

	@Test
	public void testUpdateHangar_positive() 
	{
		Hangar hangar = new Hangar();
		hangar.setManagerId("slfihd");		
		hangar.setManagerAddressLine1("sdkfjagkjsab");
		hangar.setManagerAddressLine2("dffuh");
		hangar.setHangarCity("gsddg");
		hangar.setHangarState("ufgsd");
		hangar.setHangarZipCode(34321);
    	
		boolean actual = hangarDAOImpl.insertHangar(hangar);
		boolean expected=true;
		assertEquals(expected,actual);
	}
}