package impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

public class UpdateFileOfPoint {

	@Autowired
	InputOutputImpl readWriteFile;
	
	public static final String PATH = "C:\\Users\\Violett\\workspace_\\geo-service\\geo-service-cli\\file-storage\\";

	public void updateFileOfPoint(int id) {
		String path = PATH + "AllPoints" + ".txt";
		File file = new File(path);
		TreeSet<String> fileString = new TreeSet<>();

		try {
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			
			ArrayList<String> fileString = new ArrayList<String>();
			fileString = readWriteFile.readFile(id);
			
			
			
			bw.write(id);
			bw.newLine();
			bw.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
