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

import com.cognizant.dao.PlaneDAO;
import com.cognizant.dao.PlaneDAOImpl;
import com.cognizant.entity.Owner;
import com.cognizant.entity.Plane;
import com.cognizant.helper.SessionHelper;

import static org.junit.Assert.*;

@ContextConfiguration(locations="classpath:/config/applicationContext.xml")
public class TestPlaneDAO {

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
	private List<Plane> mockedPlaneList;

	@Mock
	private Plane plane;
	
	@InjectMocks
	private PlaneDAOImpl planeDAOImpl;

	private PlaneDAO planeDAO;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);

		ApplicationContext ioc= new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
		sessionHelper=(SessionHelper)ioc.getBean("sessionHelper");
		
		planeDAOImpl.setSessionHelper(this.sessionHelper);
		Mockito.when(mockedSessionHelper.createSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
		Mockito.when(mockedSession.createQuery("from Plane")).thenReturn(mockedQuery);
		Mockito.when(mockedQuery.list()).thenReturn(mockedPlaneList);
		planeDAO = Mockito.spy(planeDAOImpl);
		mockedPlaneList=Mockito.spy(planeDAOImpl.getAllPlanes());
		
	}

	@Test
	public void testGetPlaneList_positive() 
	{
		assertEquals(true,mockedPlaneList.size()>0);	
	}
	
	@Test
	public void testPersistPlane_positive() 
	{
		Plane plane = new Plane();
		Owner owner=new Owner();
		owner.setOwnerFirstName("Arushi");
		owner.setOwnerLastName("Rastogi");
		owner.setOwnerContactNo(87878798);
		owner.setOwnerEmail("arushi.rastogi02@gmail.com");
		plane.setOwner(owner);
		plane.setPlaneCapacity(99);
		plane.setPlaneType("dsfa");
    	
		boolean actual = planeDAOImpl.insertPlane(plane);
		boolean expected=true;
		assertEquals(expected,actual);
	}

	@Test
	public void testUpdatePlane_positive() 
	{
		Plane plane = new Plane();
		Owner owner=new Owner();
		owner.setOwnerFirstName("Arushi");
		owner.setOwnerLastName("Rastogi");
		owner.setOwnerContactNo(87878798);
		owner.setOwnerEmail("arushi.rastogi02@gmail.com");
		plane.setOwner(owner);
		plane.setPlaneCapacity(99);
		plane.setPlaneType("dsfa");
    	
		boolean actual = planeDAOImpl.insertPlane(plane);
		boolean expected=true;
		assertEquals(expected,actual);
	}
}