package impl;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class Sort {

	@Autowired
	private ParseString parseString;
	
	public ArrayList<String> sorting(ArrayList<String> fileString)
	{
		ArrayList<ArrayList<String>> file = new ArrayList<ArrayList<String>>();
		
		if(fileString.size() == 0 || fileString.size() == 1)
			return fileString;
			
		for(int i=0; i < fileString.size(); i++)
		{
		    file.add(new ArrayList<String>());
			file.set(i, parseString.parseString(fileString.get(i)));
		}
		
		LocalDateTime timeNewCoordinate = LocalDateTime.parse(file.get(file.size()-1).get(4));
		int position = file.size()-1;
		
		for(int i = file.size()-2; i >= 0; i--)
		{
			LocalDateTime timeTemp = LocalDateTime.parse(file.get(i).get(4));
			if(timeNewCoordinate.compareTo(timeTemp) > 0)
				break;
				
			position--;
		}
				
		if(position != file.size() - 1)
		{
			file.add(position, file.get(file.size()-1));
			file.remove(file.size()-1);
		}	
		
		ArrayList <String> sortedList = new ArrayList<String>();
		
		for(int i = 0; i < file.size(); i++)
		{
			StringBuilder str = new StringBuilder();
			for(int j = 0; j < file.get(i).size(); j++)
			{
				str.append(file.get(i).get(j)).append(" ");
			}
			
			sortedList.add(str.toString());
		}
		
		return sortedList;
		
	}	
}
