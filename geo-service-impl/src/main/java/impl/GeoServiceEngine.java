package impl;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.EntityDAO;
import dao.LocationDAO;
import models.Location;

public class GeoServiceEngine implements EntityDAO, LocationDAO {

	@Autowired
	private FileDAOImpl storage;

	@Override
	public Location currentCoordinatesById(int id) {

		return storage.currentCoordinatesById(id);
	}
	@Override
	public List<Location> getAll() {

		return storage.getAll();
	}
	@Override
	public void put(int id, String name) {
		storage.put(id, name);
	}
	@Override
	public List<Float> getTravelHistory(int id, Timestamp start, Timestamp end) {
		return storage.getTravelHistory(id, start, end);
	}
	@Override
	public void put(int id, float latitude, float longitude, Timestamp time) {
		storage.put(id, latitude, longitude, time);
	}

}
