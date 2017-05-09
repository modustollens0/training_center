package impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.EntityDAO;
import dao.LocationDAO;
import models.Location;

public class GeoServiceEngine implements EntityDAO, LocationDAO {

	@Autowired
	private FileDAOImpl fileDAOImpl;

	public Location currentCoordinatesById(int id) {

		return fileDAOImpl.currentCoordinatesById(id);
	}

	public List<Location> getAll() {

		return fileDAOImpl.getAll();
	}

	public void put(int id, String name) {
		fileDAOImpl.put(id, name);

	}

	public List<Float> getTravelHistory(int id, Timestamp start, Timestamp end) {
		return fileDAOImpl.getTravelHistory(id, start, end);
	}

	public void put(int id, float latitude, float longitude, Timestamp time) {
		fileDAOImpl.put(id, latitude, longitude, time);

	}

}
