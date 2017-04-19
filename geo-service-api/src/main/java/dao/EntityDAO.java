package dao;
import java.time.LocalDateTime;
import java.util.List;

import models.Entity;

public interface EntityDAO {
		
//	public static final String PARAMETERIZED_SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Warehouse.ID_COLUMN + " = :" + ID_PARAMETER;	
	public Entity getById(int id); 
	public List<Entity> getAll();
	public void put(int id, String name, float latitude, float longitude, LocalDateTime time);
	
}
