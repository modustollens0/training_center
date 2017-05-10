package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.Entity;
import models.Location;

@Repository
public interface EntityDAO {
		
//	public static final String PARAMETERIZED_SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;	
	public Location currentCoordinatesById(int id); 
	public List<Location> getAll();
	public void put(int id, String name);
	
}
