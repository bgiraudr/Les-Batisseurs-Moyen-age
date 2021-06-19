package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
	public static void printFile(String filePath) {
		if(filePath != null) {
			try {
				BufferedReader title = new BufferedReader(new FileReader(filePath));
				String line;
				while((line = title.readLine()) != null) {
					System.out.println(line);
				}
				title.close();
			} catch(IOException e) {
				System.out.println("printFile : " + filePath + " not found");
			} 
		}
	}
}