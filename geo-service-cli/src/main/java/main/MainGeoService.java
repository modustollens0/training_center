package main;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import impl.GeoServiceEngine;
import impl.ParseString;

public class MainGeoService {

	@Autowired
	static GeoServiceEngine geoServiceEngine;

	@Autowired
	static ParseString parseString;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("console-app.xml");
		ParseString parseString = (ParseString) context.getBean("parseString");
		GeoServiceEngine geoServiceEngine = (GeoServiceEngine) context.getBean("geoServiceEngine");
		// PrintAllPoint printAllPoint =
		// (PrintAllPoint)context.getBean("printAllPoint");

		System.out.println("HELP");
		System.out.println(" Hi! Write the command: " + "\n 0.put the coordinates (Id, name, latitude, longitude, time)"
				+ "\n 1.put the point (Id, name)" + "\n 2.get travel history (Id, time start, time end) "
				+ "\n 3.get coordinates by id " + "\n 4.get all object from base");

		Scanner sc = new Scanner(System.in);
		String choose = "";

		while (!choose.equals("quit")) {
			choose = sc.nextLine();
			choose.trim();
			choose = choose.replaceAll(",", "");

			ArrayList<String> command = new ArrayList<>();
			command = parseString.parseString(choose);

			if (command.get(2).equals("coordinates")) {
				geoServiceEngine.put(Integer.valueOf(command.get(3)), Float.valueOf(command.get(4)),
						Float.valueOf(command.get(5)), Timestamp.valueOf(command.get(6)));
			}
			if (command.get(2).equals("point")) {
				geoServiceEngine.put(Integer.valueOf(command.get(3)), command.get(4));
			}
			if (command.get(1).equals("travel")) {
				geoServiceEngine.getTravelHistory(Integer.parseInt(command.get(3)), Timestamp.valueOf(command.get(4)),
						Timestamp.valueOf(command.get(5)));
			}
			if (command.get(1).equals("coordinates")) {
				geoServiceEngine.currentCoordinatesById(Integer.parseInt(command.get(4)));

			}
			if (command.get(1).equals("all")) {
				geoServiceEngine.getAll();
			}
			choose = sc.nextLine();
		}
	}
}
