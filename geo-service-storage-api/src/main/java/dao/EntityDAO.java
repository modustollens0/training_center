package dao;

import java.util.List;
import models.Entity;
import models.Location;

public interface EntityDAO {
		
//	public static final String PARAMETERIZED_SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;	
	public Location currentCoordinatesById(int id); 
	public List<Location> getAll();
	public void put(int id, String name);
	
}
