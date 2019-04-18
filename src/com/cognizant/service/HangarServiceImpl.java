package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.HangarDAO;
import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.exception.HangarNotFound;
import com.cognizant.exception.PilotNotFound;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;

@Service("HangarServiceImpl")
public class HangarServiceImpl implements HangarService {
	// used to forming computation

	@Autowired
	@Qualifier("HangarDAOImpl")
	private HangarDAO hangarDAO;

	private static final Logger logger = LoggerFactory.getLogger(HangarServiceImpl.class);

	@Override
	public List<Hangar> getAllHangars() {
		logger.info("----Retriving List of all Hangars in Hangar Service----");
		List<Hangar> hangarList= hangarDAO.getAllHangars();
		if(hangarList.isEmpty())
		{
			throw new HangarNotFound("No Hangar in the List");
		}
		else return hangarList;
	}

	@Override
	public boolean persistHangar(HangarModel hangarModel) {
		logger.info("----Register Hangar in Hangar Service----");
		Hangar hangar=new Hangar();	
		//hangar.setHangarId(hangarModel.getHangarId());
		hangar=hangarModel.modelToEntity(hangarModel);			
		return hangarDAO.insertHangar(hangar);
	}

	@Override
	public HangarModel getHangar(int hangar1) {
	logger.info("----Retriving One Hangar using Hangar Id in Hangar Service----");

	Hangar hangar= hangarDAO.getHangar(hangar1);
	HangarModel hangarModel=new HangarModel();
		
	hangarModel=hangarModel.entityToModel(hangar);			
	return hangarModel;
	}

	@Override
	public boolean updateHangar(HangarModel hangarModel) {
		logger.info("----Updating Hangars in Hangar Service----");
		Hangar hangar=new Hangar();
		hangar=hangarModel.modelToEntity(hangarModel);	
		hangar.setHangarId(hangarModel.getHangarId());
		return hangarDAO.updateHangar(hangar);
	}

	@Override
	public List<HangarStatus> getAllHangarStatus() {
		logger.info("----Retriving List of all Hangar Status in Hangar Service----");
		return hangarDAO.getAllHangarStatus();
	}

	@Override
	public boolean allocatePlane(HangarStatusModel hangarStatusModel) {
			
		logger.info("----Allocating Plane to Hangar in Hangar Service----");
	
		HangarStatus hangarStatus = new HangarStatus();
		hangarStatus=hangarStatusModel.modelToEntity(hangarStatusModel);	
		hangarStatus.setStatus("O");			
		return hangarDAO.allocatePlane(hangarStatus);
	}

	@Override
	public HangarStatusModel getHangarIdManagerId() {
		logger.info("----Retriving Hangar Id and Manager Id in Hangar Service----");
		HangarStatus hangarStatus = hangarDAO.getHangerIdManagerId(); 
		HangarStatusModel hangarStatusModel = new HangarStatusModel();

		hangarStatus.setAvailableFromDate("0");
		hangarStatus.setAvailableTillDate("0");
		hangarStatus.setOccupancyFromDate("0");
		hangarStatus.setOccupancyTillDate("0");
		hangarStatus.setStatus("A");
		
		hangarStatusModel=hangarStatusModel.entityToModel(hangarStatus);	
		logger.info("----Register Hangar Status in Hangar Service----");
		hangarDAO.persistHangarStatus(hangarStatus);
		return hangarStatusModel;
	}
	
	@Override
	public HangarStatusModel getHangarStatus(int hangar1) {

	logger.info("----Retriving One Hangar Status using Hangar Id in Hangar Service----");
	HangarStatus hangarStatus= hangarDAO.getHangarStatus(hangar1);
	HangarStatusModel hangarStatusModel=new HangarStatusModel();
		
	hangarStatusModel=hangarStatusModel.entityToModel(hangarStatus);
	return hangarStatusModel;

	}

	@Override
	public List<String> getStatus() {
		logger.info("----Retriving Status for Drop Down in Hangar Service----");
		return hangarDAO.getStatus();
	}
	
	@Override
	public boolean updateHangarStatus(HangarStatusModel hangarStatusModel) {

		logger.info("----Updating Hangar Status in Hangar Service----");
		HangarStatus hangarStatus=new HangarStatus();		
		hangarStatus=hangarStatusModel.modelToEntity(hangarStatusModel);			
		hangarStatus.setStatus(hangarStatusModel.getStatus());
		return hangarDAO.updateHangarStatus(hangarStatus);
	}

	@Override
	public String getStatusCondition(int hangarId) {
		logger.info("----Retriving Hangar Status From Database in Hangar Service----");		
		return hangarDAO.getStatusConditionDAO(hangarId);
	}
}
