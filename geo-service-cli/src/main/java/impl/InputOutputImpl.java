package impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import dao.InputOutputDAO;;

public class InputOutputImpl implements InputOutputDAO {

	@Autowired
	Sort sort;
	
	@Autowired
	UpdateFileOfPoint updateFileOfPoint;

	public static final String PATH = "C:\\Users\\Violett\\workspace_\\geo-service\\geo-service-cli\\file-storage\\";

	public ArrayList<String> readFile(int id) {
		ArrayList<String> file_to_string = new ArrayList<String>();
		String path = PATH + Integer.toString(id) + ".txt";

		File file = new File(path);
		if (!file.exists()) {
			System.out.println("Object is not exist in the base");
			return null;
		}

		try {
			BufferedReader bw = new BufferedReader(new FileReader(file));

			String line;
			while ((line = bw.readLine()) != null) {
				file_to_string.add(line);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return file_to_string;
	}

	public void writeFile(String str, int id) {

		String path = PATH + Integer.toString(id) + ".txt";
		File file = new File(path);

		try {
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // true

			bw.write(str);
			bw.newLine();
			bw.flush();

			ArrayList<String> sortedFile = new ArrayList<String>();
			sortedFile = sort.sorting(readFile(id));

			// file.delete();
			// file.createNewFile();

			BufferedWriter bw1 = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < sortedFile.size(); i++) {
				bw1.write(sortedFile.get(i));
				bw1.newLine();
				bw1.flush();
			}
			updateFileOfPoint.updateFileOfPoint(id);
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}
}
