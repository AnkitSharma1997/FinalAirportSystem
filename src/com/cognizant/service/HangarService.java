package com.cognizant.service;

import java.util.List;
import com.cognizant.entity.Hangar;
import com.cognizant.entity.HangarStatus;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;

public interface HangarService {

	List<Hangar> getAllHangars();
	HangarModel getHangar(int hangar1);
	boolean persistHangar(HangarModel hangarModel);
	boolean updateHangar(HangarModel hangarModel);

	List<HangarStatus> getAllHangarStatus();
	public boolean allocatePlane(HangarStatusModel hangerStatusModel);
	
	HangarStatusModel getHangarIdManagerId();

	HangarStatusModel getHangarStatus(int hangar1);
	public List<String> getStatus();
	
	boolean updateHangarStatus(HangarStatusModel hangerStatusModel);
	
	public String getStatusCondition(int hangarId);
}
