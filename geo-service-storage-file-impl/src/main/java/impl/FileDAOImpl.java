package impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.EntityDAO;
import dao.LocationDAO;
import models.Entity;
import models.Location;
import print.PrintAllPoint;

public class FileDAOImpl implements EntityDAO, LocationDAO {

	public static final String PATH = "C:\\Users\\Violett\\workspace_\\geo-service\\geo-service-cli\\file-storage\\AllPoints.txt";
	@Autowired
	private InputOutputImpl readWriteFile;

	@Autowired
	private ParseString parseString;

	@Autowired
	private UpdateFileOfPoint updateFileOfPoint;

	@Autowired
	private PrintAllPoint printAllPoint;

	
	public Location currentCoordinatesById(int id) {

		Location Coordinates = new Location();
		ArrayList<String> file = new ArrayList<String>();
		ArrayList<String> lastCoordinate = new ArrayList<String>();

		file = readWriteFile.readFile(id);
		lastCoordinate = parseString.parseString(file.get(file.size() - 1));

		Coordinates.setEntityId(id);
		Coordinates.setLatitude(id, Float.parseFloat(lastCoordinate.get(2)));
		Coordinates.setLongitude(id, Float.parseFloat(lastCoordinate.get(3)));
		Coordinates.setTime(id, Timestamp.valueOf(lastCoordinate.get(4)));

		System.out.println("latitude  " + Coordinates.getLatitude());
		System.out.println("longitude  " + Coordinates.getLongitude(id));

		return Coordinates;
	}

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
			location.setTime(Integer.parseInt(point.get(0)), Timestamp.valueOf(point.get(4)));

			locationList.add(location);
		}
		printAllPoint.printAllPoint(locationList);

		return locationList;
	}

	public void put(int id, String name) {
		updateFileOfPoint.updateFileOfPoint(id, name);
	}

	public List<Float> getTravelHistory(int id, Timestamp start, Timestamp end) {

		List<Float> travelHistory = new ArrayList<Float>();
		ArrayList<String> file = new ArrayList<String>();
		ArrayList<String> lastCoordinate = new ArrayList<String>();

		file = readWriteFile.readFile(id);

		for (int i = 0; i < file.size(); i++) {
			lastCoordinate = parseString.parseString(file.get(i));
			if (Timestamp.valueOf(lastCoordinate.get(4)).compareTo(start) >= 0
					&& Timestamp.valueOf(lastCoordinate.get(4)).compareTo(end) <= 0) {
				travelHistory.add(Float.parseFloat(lastCoordinate.get(2)));
				travelHistory.add(Float.parseFloat(lastCoordinate.get(3)));
			}
		}

		for (int i = 0; i < travelHistory.size() - 1; i += 2) {
			System.out.println(travelHistory.get(i) + " " + travelHistory.get(i + 1));
		}

		return travelHistory;
	}

	public void put(int id, float latitude, float longitude, Timestamp time) {
		StringBuilder str = new StringBuilder();
		str.append(id).append(" ").append(latitude).append(" ").append(longitude).append(" ").append(time);

		readWriteFile.writeFile(str.toString(), id);
	}
}
