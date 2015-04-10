package com.onmobile.atlantis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

public class FileComparator {
	
	private static Set <String> jbossRequestLogset = new HashSet <String> ();
	
	private static Logger logger = FileUtility.logger;
	
	public void trimStringArray(String[] ans) {
		for (int i = 0; i < ans.length; i++) ans[i] = ans[i].trim();
	}
	
	public int[] getHourMinute(String line) {
		int[] arr = new int[2];
		Arrays.fill(arr, -1);
		String[] tt = line.substring(11, 16).split("[:]");
		arr[0] = Integer.parseInt(tt[0]);
		arr[1] = Integer.parseInt(tt[1]);
		return arr;
	}
	
	public void checkForTheRequestStatus(String apacheLog) {
		try {
			FileReader fread = new FileReader(apacheLog);
			BufferedReader reader = new BufferedReader(fread);
			String str = "";
			while( (str = reader.readLine()) != null) {
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readJbossLogFileAndPutInMap(File file) throws IOException {
		FileReader fReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fReader);
		String line = "";
		while((line = reader.readLine()) != null) {
			String uniqueKeyRequest = "";
			if(line.contains("INFO  [onmobile.atlantis.central.controller.CentralDistributor]")) {
				int index = line.indexOf("request");
				if (index == -1) continue;
				String temp = line.substring(index);
				String[] ans = temp.split("[=,]+");
				if(ans.length == 0) continue;
				trimStringArray(ans);
				int[] hourMin = getHourMinute(line);
				if(hourMin[0] == -1 || hourMin[1] == -1) {
					logger.debug("Chandra Kant");
					continue;
				}
				
				uniqueKeyRequest = ans[1] + " " + ans[3] + " " + ans[9] + " " + hourMin[0] + " " + hourMin[1];
								
				jbossRequestLogset.add(uniqueKeyRequest);
				logger.debug(uniqueKeyRequest + "  added in Set");
			}
		}
		System.out.println(jbossRequestLogset.size());
	}
	
	public void compareTheFiles(String apacheLogFile, String jbossLogFile) {
		File file = new File(jbossLogFile);
		if(file.exists() == false) {
			logger.warn(jbossLogFile + "  File not found");
			return;
		}
		try {
			readJbossLogFileAndPutInMap(file);
			checkForTheRequestStatus(apacheLogFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
