package impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.EntityDAO;
import dao.LocationDAO;
import models.Location;

public class GeoServiceImpl implements  EntityDAO, LocationDAO{

	@Autowired 
	EntityDaoImplConsole entityDaoImplConsole;
	
	@Autowired 
	PlaceDaoImplConsole placeDaoImplConsole;
	
	public Location currentCoordinatesById(int id) {
		
		return entityDaoImplConsole.currentCoordinatesById(id);
	}

	public List<Location> getAll() {
		
		return entityDaoImplConsole.getAll();
	}

	public void put(int id, String name) {
		entityDaoImplConsole.put(id, name);
		
	}

	public List<Float> getTravelHistory(int id, LocalDateTime start, LocalDateTime end) {
		return placeDaoImplConsole.getTravelHistory(id, start, end);
	}

	public void put(int id, float latitude, float longitude, LocalDateTime time) {
		placeDaoImplConsole.put(id, latitude, longitude, time);
		
	}

}
