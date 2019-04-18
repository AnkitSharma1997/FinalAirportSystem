package com.cognizant.dao;

import java.util.List;
import com.cognizant.entity.Pilot;

public interface PilotDAO {

	List<Pilot> getAllPilots();
    Pilot getPilot(int pilot1);
	boolean insertPilot(Pilot pilot);	
	boolean updatePilot(Pilot pilot);
}
