package impl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.EntityDAO;
import models.Entity;
import models.Location;

public class EntityDaoImplConsole implements EntityDAO {

	@Autowired
	private InputOutputImpl readWriteFile;
	
	@Autowired
	private ParseString parseString;
	
	@Override
	public Location currentCoordinatesById(int id) {
		
		Location Coordinates = new Location();
		ArrayList<String> file = new ArrayList<String>();
		ArrayList<String> lastCoordinate = new ArrayList<String>();
		
		file = readWriteFile.readFile(id);
		lastCoordinate = parseString.parseString(file.get(file.size()-1));
		
		Coordinates.setEntityId(id);
		Coordinates.setLatitude(id, Float.parseFloat(lastCoordinate.get(2)));
		Coordinates.setLongitude(id, Float.parseFloat(lastCoordinate.get(3)));
		Coordinates.setTime(id, LocalDateTime.parse(lastCoordinate.get(4)));
		
		System.out.println("latitude  " + Coordinates.getLatitude());
		System.out.println("longitude  " + Coordinates.getLongitude(id));
		
		return Coordinates;
	}

	@Override
	public List<Location> getAll() {
			List<Location> locationList = new ArrayList<Location>();
//	for(int k=0 ; k < count)	
		for(int i=0; i < 7; i++)
		{
			ArrayList<String> file = new ArrayList<String>();
			
			file = readWriteFile.readFile(i);
			
			ArrayList<String> lastCoordinates = parseString.parseString(file.get(file.size() - 1));
			Location location = new Location();
			location.setEntityId(Integer.parseInt(lastCoordinates.get(0)));
			location.setLatitude(Integer.parseInt(lastCoordinates.get(0)), Float.parseFloat(lastCoordinates.get(2)));
			location.setLongitude(Integer.parseInt(lastCoordinates.get(0)), Float.parseFloat(lastCoordinates.get(2)));
			locationList.add(location);
		}
		return locationList;
	}

	@Override
	public void put(int id, String name) {
		
	}

	
}
