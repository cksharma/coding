package com.onmobile.training.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.io.InputStream;

class Readc extends Thread
{
	BufferedReader br;
	Readc(BufferedReader br)
	{
		this.br = br;
	}
	
	public void run()
	{
		String str;
		
		try {
			str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Writec extends Thread
{
	PrintWriter pwr;
	
	Writec(PrintWriter pwr)
	{
		this.pwr = pwr;
	}
	
	public void run()
	{
		
		Scanner ss = new Scanner(System.in);
		System.out.println("Writec karlo");
		String str = ss.nextLine();
		pwr.println(str);
	}
}

public class ChatingClient {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			int cnt = 0;
			Scanner sc = new Scanner(System.in);
			
			Socket sock = new Socket("localhost", 1222);
			
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
			PrintWriter pw = new PrintWriter(out, true);
			System.out.println("connect huwa");
			
			for(int i = 0; i < 10; i++)
			{
				Readc read = new Readc(br);
				Writec wr = new Writec(pw);
				read.start();
				wr.start();
				try {
					read.join();
					wr.join();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			sock.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
