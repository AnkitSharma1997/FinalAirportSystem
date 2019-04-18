package com.cognizant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.PilotDAO;
import com.cognizant.entity.Pilot;
import com.cognizant.exception.PilotNotFound;
import com.cognizant.model.PilotModel;

@Service("PilotServiceImpl")
public class PilotServiceImpl implements PilotService {
	// used to forming computation

	@Autowired
	@Qualifier("PilotDAOImpl")
	private PilotDAO pilotDAO;

	private static final Logger logger = LoggerFactory.getLogger(PilotServiceImpl.class);

	@Override
	public List<Pilot> getAllPilots() {
		logger.info("----Retriving List of all Pilot in Pilot Service----");
		List<Pilot> pilotList=pilotDAO.getAllPilots();
		if(pilotList.isEmpty())
		{
			throw new PilotNotFound("No Pilot in the List");
		}
		else return pilotList;
	}

	@Override
	public boolean persistPilot(PilotModel pilotModel) {
		logger.info("----Register Pilot in Pilot Service----");
		Pilot pilot=new Pilot();
		
		//pilot.setPilotId(pilotModel.getPilotId());
		
		pilot=pilotModel.modelToEntity(pilotModel);		
		return pilotDAO.insertPilot(pilot);
	}

	@Override
	public PilotModel getPilot(int pilot1) {
	logger.info("----Retriving One Pilot using Pilot Id in Pilot Service----");

	Pilot pilot= pilotDAO.getPilot(pilot1);
	PilotModel pilotModel=new PilotModel();
		
	pilotModel=pilotModel.entityToModel(pilot);		
	return pilotModel;

	}

	@Override
	public boolean updatePilot(PilotModel pilotModel) {
		logger.info("----Updating Pilot in Pilot Service----");
		Pilot pilot=new Pilot();		
		pilot=pilotModel.modelToEntity(pilotModel);			
		pilot.setPilotId(pilotModel.getPilotId());
		return pilotDAO.updatePilot(pilot);
	}

}
