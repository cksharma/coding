package assessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String args[]) throws IOException {
        String s;
        
        String runP1 = "/home/cksharma/data/git/ds-prjs/./groupmessenger2-grading.linux -n 5 -p 1 /home/cksharma/data/git/ds-prjs/GroupMessenger2/app/build/outputs/apk/app-debug.apk";
        String grepCommand = "/usr/bin/adb -s emulator-5554 logcat | grep Group";
        String adbLogClear = "/usr/bin/adb logcat -c";
        File file = new File("/home/cksharma/data/git/ds-prjs/GroupMessenger2/app/build/outputs/apk/logs");
        if (file.exists())
        	file.delete();
        FileWriter writer = new FileWriter(file);
        
        try {
            for (int i = 0; i < 20; i++) {
	        	//Process adbClearProcess = Runtime.getRuntime().exec(adbLogClear);
	        	//adbClearProcess.waitFor();
	        	
	        	Process runP1Process = Runtime.getRuntime().exec(runP1);
	        	runP1Process.waitFor();
	        	System.out.println("Command executed " + (i + 1));
	        	
	        	//Process p = Runtime.getRuntime().exec(grepCommand);
	        	//p.waitFor();
	        	//System.out.println("Grep command executed " + (i + 1));
	        	
	            BufferedReader br = new BufferedReader(
	                new InputStreamReader(runP1Process.getInputStream()));
	            while ((s = br.readLine()) != null) {
	                if (s.contains("ordering score") || s.contains("Ordering score"))
	                	writer.write(s + "\n");
	            }    
	                        
	            
	            System.out.println();System.out.println();
	            //adbClearProcess.destroy();
	            runP1Process.destroy();
	            //p.destroy();
            }     
        } catch (Exception e) {
        	
        }
        writer.close();
    }
}