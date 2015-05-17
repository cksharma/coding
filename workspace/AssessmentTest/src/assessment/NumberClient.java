package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NumberClient {
	public static void main(String[] args) {
		try {
			Socket sock = new Socket("localhost", 1222);

			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(out, true);
			Scanner sc = new Scanner(System.in);
			sc.close();
			while (true) {
				System.out.println("Enter the number which u guessed");
				String guess = sc.nextLine();

				if (!guess.contains(">") && !guess.contains("<")
						&& !guess.contains("=")) {
					System.out.println("U didn't enter the valid pattern");
					pw.println(guess);
					break;
				}
				pw.println(guess);
				String str = br.readLine();
				System.out.println(str);
				if (str.contains("Congratulations") || str.contains("steps")
						|| str.contains("tries"))
					break;
			}
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
