package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;

public interface HangarDAO {

	List<Hangar> getAllHangars();
    Hangar getHangar(int hangar1);
	boolean insertHangar(Hangar hangar);	
	boolean updateHangar(Hangar hangar);

	List<HangarStatus> getAllHangarStatus();
	public boolean allocatePlane(HangarStatus hangerStatus);
		
	HangarStatus getHangerIdManagerId();
	boolean persistHangarStatus(HangarStatus hangarStatus);
	
	HangarStatus getHangarStatus(int hangar1);
	public List<String> getStatus();

	boolean updateHangarStatus(HangarStatus hangerStatus);
	
	public String getStatusConditionDAO(int hangarId);
}
