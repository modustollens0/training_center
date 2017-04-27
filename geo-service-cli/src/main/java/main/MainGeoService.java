package main;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import impl.EntityDaoImplConsole;
import impl.ParseString;
import impl.PlaceDaoImplConsole;
import impl.UpdateFileOfPoint;


public class MainGeoService {
		
	@Autowired
    static EntityDaoImplConsole entityDaoConsole;
	
	@Autowired
    static PlaceDaoImplConsole placeDaoConsole;
	
	@Autowired
	static ParseString parseString;
	
	@Autowired
	static UpdateFileOfPoint updateFileOfPoint;
	
	public static void main(String [] args)
	{		
		System.out.println("HELP");
			
		ApplicationContext context = new ClassPathXmlApplicationContext("console-app.xml");
		ParseString parseString = (ParseString)context.getBean("parseString");
		EntityDaoImplConsole entityDaoConsole = (EntityDaoImplConsole)context.getBean("entityDaoImplConsole");
		PlaceDaoImplConsole placeDaoConsole = (PlaceDaoImplConsole)context.getBean("placeDaoImplConsole");
		UpdateFileOfPoint updateFileOfPoint = (UpdateFileOfPoint)context.getBean("updateFileOfPoint");
		
		System.out.println("HELP");
			System.out.println(" Hi! Write the command: "
					+ "\n 0.put the coordinates (Id, name, latitude, longitude, time)"
					+ "\n 1.put the point (Id, name)"
					+ "\n 2.get travel history (Id, time start, time end) "
					+ "\n 3.get coordinates by id "
					+ "\n 4.get all object from base");	
			
			Scanner sc = new Scanner(System.in);
			String choose="";
			
			while(!choose.equals("q"))
			{
				choose = sc.nextLine();
				choose.trim();
				choose = choose.replaceAll(",", "");
				
				ArrayList<String> command = new ArrayList<>();
				command = parseString.parseString(choose);
				
				if(command.get(2).equals("coordinates"))
				{
					placeDaoConsole.put(Integer.valueOf(command.get(3)), Float.valueOf(command.get(4)), 
										 Float.valueOf(command.get(5)), LocalDateTime.parse(command.get(6)));
				}
				if(command.get(2).equals("point"))
				{
					
					updateFileOfPoint.updateFileOfPoint(Integer.valueOf(command.get(3)), command.get(4));
				}
				if(command.get(1).equals("travel"))
				{
					placeDaoConsole.getTravelHistory(Integer.parseInt(command.get(3)), 
													LocalDateTime.parse(command.get(4)), LocalDateTime.parse(command.get(5)));
				}
				if(command.get(1).equals("coordinates"))
				{
					entityDaoConsole.currentCoordinatesById(Integer.parseInt(command.get(4)));
					
				}
				if(command.get(1).equals("all"))
				{
					entityDaoConsole.getAll();
				}
			}
	}
}
