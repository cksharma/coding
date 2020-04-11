package com.onmobile.atlantis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileReadingAppendingUtility {
	
	private String baseFilePath;
	private int fileStartCounter;
	private int fileEndCounter;
	private String outputFile;
	
	private static Logger logger = FileUtility.logger;
	
	public FileReadingAppendingUtility(String baseFilePath, int fileStartCounter, int fileEndCounter, String outputFile) {
		super();
		this.baseFilePath = baseFilePath;
		this.fileStartCounter = fileStartCounter;
		this.fileEndCounter = fileEndCounter;
		this.outputFile = outputFile;
	}	
	
	public void readFileAndAppendAllFiles() throws IOException {
		FileWriter writer = new FileWriter(new File(outputFile));
		for (int i = fileEndCounter; i >= fileStartCounter; i--) {
			File file = new File(baseFilePath + "server.log." + i);
			if(file.exists() == false) {
				logger.warn(baseFilePath + "server.log." + i + " file not found");
				continue;
			}
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String fileLine = "";
			while ((fileLine = reader.readLine()) != null) {
				writer.write(fileLine + "\n");
			}
			fileReader.close();
		}
		writer.write("\n");
		writer.close();
	}
}
