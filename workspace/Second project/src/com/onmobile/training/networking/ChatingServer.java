package com.onmobile.training.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;

class Reads extends Thread
{
	BufferedReader br;
	Reads(BufferedReader br)
	{
		this.br = br;
	}
	public void run()
	{
		try {
			String str = br.readLine();
			System.out.println("client says : " + str);
			if(str.endsWith("bye".toLowerCase())) System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Writes extends Thread
{
	PrintWriter pw;
	Writes(PrintWriter pw)
	{
		this.pw = pw;
	}
	public void run()
	{
		Scanner ss = new Scanner(System.in);
		pw.println("hello brothers");
	}
}

public class ChatingServer {

	public static void main(String[] args) {
		try {

			ServerSocket serv = new ServerSocket(1222);
			Socket sock = serv.accept();
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			
			for(int i = 0; i < 10; i++)
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(in)); 
				PrintWriter pw = new PrintWriter(out, true);
				Reads read = new Reads(br);
				Writes write = new Writes(pw);
				read.start();
				write.start();
			}
			//sock.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
