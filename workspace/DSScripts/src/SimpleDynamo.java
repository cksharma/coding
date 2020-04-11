import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleDynamo {

	public static void main(String args[]) throws IOException {
		String s;

		String runP1 = "/home/cksharma/data/git/ds-prjs/./simpledynamo-grading.linux /home/cksharma/data/git/ds-prjs/SimpleDynamo/app/build/outputs/apk/app-debug.apk";
		// runP1 =
		// "/home/cksharma/data/git/ds-prjs/./groupmessenger2-grading.linux -v -n 5 -p 1 /home/cksharma/Downloads/app-debug.apk";
		// String runP2 =
		// "/home/cksharma/data/git/ds-prjs/./groupmessenger2-grading.linux -v -n 5 -p 2 /home/cksharma/data/git/ds-prjs/GroupMessenger2/app/build/outputs/apk/app-debug.apk";
		// String grepCommand =
		// "/usr/bin/adb -s emulator-5554 logcat | grep Group";
		// String adbLogClear = "/usr/bin/adb logcat -c";
		File file = new File("/home/cksharma/Socres");
		if (file.exists())
			file.delete();
		FileWriter writer = new FileWriter(file);
		
		for (int i = 0; i < 10; i++) {

			try {
				// Process adbClearProcess =
				// Runtime.getRuntime().exec(adbLogClear);
				// adbClearProcess.waitFor();

				Process runP1Process = Runtime.getRuntime().exec(runP1);
				runP1Process.waitFor();
				System.out.println("Command executed " + (i + 1));

				// Process p = Runtime.getRuntime().exec(grepCommand);
				// p.waitFor();
				// System.out.println("Grep command executed " + (i + 1));

				BufferedReader br = new BufferedReader(new InputStreamReader(runP1Process.getInputStream()));
				while ((s = br.readLine()) != null) {
					if (s.contains("Total score") || s.contains("so far")) {
						// writer.write(s + "\n");
						System.out.println(s);
						writer.write(s + "\n");
					}					
				}
				writer.write("\n\n");
				System.out.println();
				System.out.println();
				// adbClearProcess.destroy();
				runP1Process.destroy();
				writer.flush();
				// p.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		writer.close();
	}
}