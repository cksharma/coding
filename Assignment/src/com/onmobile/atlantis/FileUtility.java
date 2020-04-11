package com.onmobile.atlantis;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class FileUtility {

	private static int fileStartCounter;
	private static int fileEndCounter;

	private static String baseFilePath = null;
	private static ResourceBundle bundle = null;
	private static String outputFile = null;
	public static Logger logger = Logger.getLogger(FileUtility.class);

	private static String apacheLogFile = null;
	private static String jbossLogFile = null;
	//static initialization of properties file
	static {
		bundle = ResourceBundle.getBundle("basefile");
		baseFilePath = bundle.getString("BASE_FILE_PATH");
		fileStartCounter = Integer.parseInt(bundle.getString("INT_FILE_LOG_START"));
		fileEndCounter = Integer.parseInt(bundle.getString("INT_FILE_LOG_END"));
		outputFile = bundle.getString("OUTPUT_FILE_PATH");
		apacheLogFile = bundle.getString("FIRST_FILE_PATH");
		jbossLogFile = bundle.getString("SECOND_FILE_PATH");
	}

	public static void processFileReadingAndAppend() {
		logger.info("Going to process file Reading and Appending");
		FileReadingAppendingUtility fileReadApp = new FileReadingAppendingUtility(baseFilePath, fileStartCounter, fileEndCounter, outputFile);
		try {
			fileReadApp.readFileAndAppendAllFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("processed file Reading and Appending");
	}

	public static void main(String[] args) {
		//processFileReadingAndAppend();
		FileComparator fileComp = new FileComparator();
		fileComp.compareTheFiles(apacheLogFile, jbossLogFile);
	}
}
