package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.PlaneDAO;
import com.cognizant.entity.Owner;
import com.cognizant.entity.Plane;
import com.cognizant.exception.PlaneNotFound;
import com.cognizant.model.PlaneModel;

@Service("PlaneServiceImpl")
public class PlaneServiceImpl implements PlaneService {
	

	@Autowired
	@Qualifier("PlaneDAOImpl")
	private PlaneDAO planeDAO;

	private static final Logger logger = LoggerFactory.getLogger(PlaneServiceImpl.class);

	@Override
	public List<Plane> getAllPlanes() {
		logger.info("----Retriving List of all Plane in Plane Service----");
		List<Plane> planeList=planeDAO.getAllPlanes();
		if(planeList.isEmpty())
		{
			throw new PlaneNotFound("No Plane in the List");
		}
		else return planeList;
	}

	@Override
	public boolean persistPlane(PlaneModel planeModel) {
		logger.info("----Register Plane in Plane Service----");

		Plane plane=new Plane();
		Owner owner=new Owner();
		
		
		owner.setOwnerFirstName(planeModel.getOwnerFirstName());
		owner.setOwnerLastName(planeModel.getOwnerLastName());
		owner.setOwnerContactNo(planeModel.getOwnerContactNo());
		owner.setOwnerEmail(planeModel.getOwnerEmail());
		plane.setOwner(owner);
		plane.setPlaneType(planeModel.getPlaneType());
		plane.setPlaneCapacity(planeModel.getPlaneCapacity());
		
		return planeDAO.insertPlane(plane);
	}

	@Override
	public PlaneModel getPlane(int plane1) {
	logger.info("----Retriving One Plane using Plane Id in Plane Service----");

	Plane plane= planeDAO.getPlane(plane1);
	PlaneModel planeModel=new PlaneModel();
		
	planeModel.setPlaneId(plane.getPlaneId());
	
	Owner owner= plane.getOwner();
	
	planeModel.setOwnerId(owner.getOwnerId());
	planeModel.setOwnerFirstName(owner.getOwnerFirstName());
	planeModel.setOwnerLastName(owner.getOwnerLastName());
	planeModel.setOwnerContactNo(owner.getOwnerContactNo());
	planeModel.setOwnerEmail(owner.getOwnerEmail());
	
	planeModel.setPlaneType(plane.getPlaneType());
	planeModel.setPlaneCapacity(plane.getPlaneCapacity());

	return planeModel;

	}

	@Override
	public boolean updatePlane(PlaneModel planeModel) {
		logger.info("----Updating Plane in Plane Service----");
		Plane plane=new Plane();
		Owner owner=new Owner();

		plane.setPlaneId(planeModel.getPlaneId());
		owner.setOwnerFirstName(planeModel.getOwnerFirstName());
		owner.setOwnerLastName(planeModel.getOwnerLastName());
		owner.setOwnerContactNo(planeModel.getOwnerContactNo());
		owner.setOwnerEmail(planeModel.getOwnerEmail());
		plane.setOwner(owner);
		plane.setPlaneType(planeModel.getPlaneType());
		plane.setPlaneCapacity(planeModel.getPlaneCapacity());
		
		return planeDAO.updatePlane(plane);

	}

	public List<Number> getAllPlaneId() 
	{		
		logger.info("----Retriving List of all Plane Id in Plane Service----");
		return planeDAO.getAllPlaneId();
	}

}
