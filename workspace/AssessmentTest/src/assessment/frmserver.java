package assessment;

import java.io.*;
import java.net.*;

public class frmserver {

	public static void main(String args[]) throws Exception {

		try {

			ServerSocket ss = new ServerSocket(1024);
			System.out.print("\nWaiting for client.....");
			Socket s = ss.accept();
			System.out.print("\nConnected");

			DataInputStream d = new DataInputStream(s.getInputStream());

			int ch = Integer.parseInt(d.readLine());
			int num = Integer.parseInt(d.readLine());
			int result = 0;

			PrintStream ps = new PrintStream(s.getOutputStream());
			switch (ch) {
			case 1:
				result = fact(num);
				ps.println(result);
				break;
			case 2:
				result = sum(num);
				ps.println(result);
				break;
			}

			ss.close();
			s.close();
		} catch (Exception ex) {

		}
	}

	public static int fact(int n) {
		int ans = 1;
		for (int i = n; i > 0; i--) {
			ans = ans * i;
		}
		return ans;
	}

	public static int sum(int n) {
		String str = n + "";
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			int tmp = Integer.parseInt(str.charAt(i) + "");
			ans = ans + tmp;
		}
		return ans;
	}
}
