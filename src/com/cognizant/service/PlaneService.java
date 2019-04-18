package com.cognizant.service;

import java.util.List;
import com.cognizant.entity.Plane;
import com.cognizant.model.PlaneModel;

public interface PlaneService {

	List<Plane> getAllPlanes();
	PlaneModel getPlane(int plane1);
	boolean persistPlane(PlaneModel planeModel);
	boolean updatePlane(PlaneModel planeModel);

	public List<Number> getAllPlaneId();
}
