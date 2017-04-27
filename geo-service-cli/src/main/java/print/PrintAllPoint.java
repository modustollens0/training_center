package print;

import java.util.List;

import models.Location;

public class PrintAllPoint {

	public void printAllPoint(List<Location> allPoint) 
	{
		for (int i = 0; i < allPoint.size(); i++) {
			System.out.println("Point with id " + allPoint.get(i).getEntityId());
			System.out.println("latitude" + allPoint.get(i).getLatitude() + " longitude "
					+ allPoint.get(i).getLongitude(allPoint.get(i).getEntityId()));
		}

	}

}
