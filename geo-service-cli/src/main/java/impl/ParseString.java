package impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ParseString {

	public ArrayList<String> parseString(String str)
	{
		Pattern pattern = Pattern.compile(" ");
		String[] parseStr = pattern.split(str);
		ArrayList<String> parseStrin = new ArrayList<String>(Arrays.asList(parseStr));
				
		return parseStrin;
	}
}
