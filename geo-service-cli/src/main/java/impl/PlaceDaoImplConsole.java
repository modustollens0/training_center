package impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.LocationDAO;

public class PlaceDaoImplConsole implements LocationDAO {

	@Autowired
	private InputOutputImpl readWriteFile;

	@Autowired
	private ParseString parseString;

	public List<Float> getTravelHistory(int id, LocalDateTime start, LocalDateTime end) {

		List<Float> travelHistory = new ArrayList<Float>();
		ArrayList<String> file = new ArrayList<String>();
		ArrayList<String> lastCoordinate = new ArrayList<String>();

		file = readWriteFile.readFile(id);

		for (int i = 0; i < file.size(); i++) {
			lastCoordinate = parseString.parseString(file.get(i));
			if (LocalDateTime.parse(lastCoordinate.get(4)).compareTo(start) >= 0
					&& LocalDateTime.parse(lastCoordinate.get(4)).compareTo(end) <= 0) {
				travelHistory.add(Float.parseFloat(lastCoordinate.get(2)));
				travelHistory.add(Float.parseFloat(lastCoordinate.get(3)));
			}
		}

		for (int i = 0; i < travelHistory.size() - 1; i += 2) {
			System.out.println(travelHistory.get(i) + " " + travelHistory.get(i + 1));
		}

		return travelHistory;
	}

	public void put(int Id, float latitude, float longitude, LocalDateTime time) {
		// TODO Auto-generated method stub

	}

}
