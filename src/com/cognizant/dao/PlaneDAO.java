package com.cognizant.dao;

import java.util.List;
import com.cognizant.entity.Plane;

public interface PlaneDAO {

	List<Plane> getAllPlanes();
    Plane getPlane(int plane1);
	boolean insertPlane(Plane plane);	
	boolean updatePlane(Plane plane);

	public List<Number> getAllPlaneId(); 
}
