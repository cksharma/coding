package com.onmobile.training.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.io.InputStream;

public class ClientNumber 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket sock = new Socket("localhost", 1222);
			
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
			PrintWriter pw = new PrintWriter(out, true);
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter the number brother");
				String guess = sc.nextLine();
				System.out.println("client = " + Increment.increment++);
				if(!guess.contains(">") && !guess.contains("<") && !guess.contains("="))
				{
					System.out.println("U didn't enter the valid pattern");
					pw.println(guess);
					break;
				}
				pw.println(guess);
				String str = br.readLine();
				if(str.contains("congratulations".toLowerCase())) break;
				System.out.println(str);
				System.out.println("client = " + Increment.increment++);
			}	
			sock.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
