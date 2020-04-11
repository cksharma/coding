package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class NumberServer {

	int guessNumber()
	{
		return (int)(Math.random() * 100.) ;
	}
	
	public static void main(String[] args) {
	
		try {
			ServerSocket serv = new ServerSocket(1222);
			Socket sock = serv.accept();
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
			PrintWriter pw = new PrintWriter(out, true);
			
			int N = new NumberServer().guessNumber();
			
			System.out.println("Number = " + N);

			 int cnt = 0;
			
			while(true)
			{	
				String s = br.readLine();
				//System.out.println("Server = " + s);
				String first = s.charAt(0) + "";
				int number = Integer.parseInt(s.substring(1));
				//System.out.println("first = " + first + "   number = " + number);
				
				if(!first.equals("<") && !first.equals(">") && !first.equals("="))
				{
					break;
				}
				if(first.equals(">"))
				{
					if(number > N) pw.println("false");
					if(number < N) pw.println("true");
				}
				if(first.equals("<"))
				{
					if(number < N) pw.println("false");
					if(number > N) pw.println("true");
				}
				if(first.equals("="))
				{
					if(number > N) pw.println("false");
					if(number < N) pw.println("false");
					if(number == N) 
					{
						pw.println("Congratulations u solved in   " + ++cnt + "  steps ");
						break;
					}
				}
				cnt++;
			}
			sock.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
