package dao;

import java.util.ArrayList;

public interface InputOutputDAO {

	public void writeFile(String s, int id);
	public ArrayList<String> readFile(int id);
}
