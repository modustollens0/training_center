package impl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class UpdateFileOfPoint {

	@Autowired
	InputOutputImpl readWriteFile;

	@Autowired
	ParseString parseString;

	public static final String PATH = "C:\\Users\\Violett\\workspace_\\geo-service\\geo-service-cli\\file-storage\\";

	public void updateFileOfPoint(int id, String name) {

		System.out.println("updateFile");

		String path = PATH + "AllPoints" + ".txt";
		File file = new File(path);
		Map<Integer, String> uniquePoints = new HashMap<Integer, String>();

		try {
			file.createNewFile();

			ArrayList<String> tmp = new ArrayList<String>();
			tmp = readWriteFile.readFile(path);

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			if (tmp.size() == 0) {

				bw.write(Integer.toString(id) + " " + name);
				bw.newLine();
				bw.flush();
				System.out.println("tmp size == 0");
				return;
			}

			for (int i = 0; i < tmp.size(); i++) {
				ArrayList<String> str = new ArrayList<String>();
				str = parseString.parseString(tmp.get(i));
				uniquePoints.put(Integer.parseInt(str.get(0)), str.get(1));
			}
			uniquePoints.put(id, name);

			for (Iterator it = uniquePoints.entrySet().iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();

				bw.write(entry.getKey().toString() + " " + entry.getValue());
				bw.newLine();
				bw.flush();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
