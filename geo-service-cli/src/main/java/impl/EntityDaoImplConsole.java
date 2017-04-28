package impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.EntityDAO;
import models.Entity;
import models.Location;
import print.PrintAllPoint;

public class EntityDaoImplConsole implements EntityDAO {

	public static final String PATH = "C:\\Users\\Violett\\workspace_\\geo-service\\geo-service-cli\\file-storage\\AllPoints.txt";
	@Autowired
	private InputOutputImpl readWriteFile;

	@Autowired
	private ParseString parseString;

	@Autowired
	private UpdateFileOfPoint updateFileOfPoint;
	
	@Autowired
	private PrintAllPoint printAllPoint;

	@Override
	public Location currentCoordinatesById(int id) {

		Location Coordinates = new Location();
		ArrayList<String> file = new ArrayList<String>();
		ArrayList<String> lastCoordinate = new ArrayList<String>();

		file = readWriteFile.readFile(id);
		lastCoordinate = parseString.parseString(file.get(file.size() - 1));

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

		ArrayList<String> fileAllPoint = new ArrayList<String>();
		fileAllPoint = readWriteFile.readFile(PATH);
		
		for (int i = 0; i < fileAllPoint.size(); i++) {
			ArrayList<String> point = new ArrayList<String>();
			point = parseString.parseString(fileAllPoint.get(i));

			ArrayList<String> locationPoint = new ArrayList<String>();
			locationPoint = readWriteFile.readFile(Integer.parseInt(point.get(0)));
			
			point = parseString.parseString(locationPoint.get(locationPoint.size() - 1));
			
			Location location = new Location();
			
			location.setEntityId(Integer.parseInt(point.get(0)));
			location.setLatitude(Integer.parseInt(point.get(0)), Float.parseFloat(point.get(2)));
			location.setLongitude(Integer.parseInt(point.get(0)), Float.parseFloat(point.get(3)));
			location.setTime(Integer.parseInt(point.get(0)), LocalDateTime.parse(point.get(4)));
			
			locationList.add(location);
		}
		printAllPoint.printAllPoint(locationList);
		
		return locationList;
	}

	@Override
	public void put(int id, String name) {
		updateFileOfPoint.updateFileOfPoint(id, name);
	}

}
