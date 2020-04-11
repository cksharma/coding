package com.onmobile.training.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

class BroadCast extends Thread
{
	PrintWriter pw = null;
	int number;
	BufferedReader br = null;
	BroadCast(Socket sock, int number)
	{
		try
		{
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			pw = new PrintWriter(out, true);
			this.number = number;
			br = new BufferedReader(new InputStreamReader(in));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		try
		{
			if(pw != null) pw.println("Hello Client " + number + " welcome to my server");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class BroadCast_Server 
{
	public static void main(String[] args) 
	{
		List <Socket> lst = new ArrayList<Socket>();
		int index = 0;
		
		try 
		{
			ServerSocket serv = new ServerSocket(2987);
			
			for(;;)
			{
				Socket sock = serv.accept();
				lst.add(sock);
		
				index++;
				if(index >= 2) break;
			}
		
			for(int i = 0; i < lst.size(); i++)
			{
				BroadCast b = new BroadCast(lst.get(i), i);
				b.run();
			}
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Broadcasting successful");
	}
}
