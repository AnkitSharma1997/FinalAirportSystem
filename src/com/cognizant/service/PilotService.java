package com.cognizant.service;

import java.util.List;
import com.cognizant.entity.Pilot;
import com.cognizant.model.PilotModel;

public interface PilotService {

	List<Pilot> getAllPilots();
	PilotModel getPilot(int pilot1);
	boolean persistPilot(PilotModel pilotModel);
	boolean updatePilot(PilotModel pilotModel);
}
