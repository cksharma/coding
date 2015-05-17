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

public class Server {

	public static void main(String[] args) {
		try {
			
			ServerSocket serv = new ServerSocket(1222);
			Socket sock = serv.accept();
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); // byte type stream is sent to InputStream.
			// from bufferedreader server is reading whatever the client has sent to server.
			//inf. sent is byte type, to convert to charcater we used bufferedreader
			// we use BufferedReader coz we want one line at a time. 
			for(;;)
			{
			PrintWriter pw = new PrintWriter(out, true);// for writing the character type output we use pwr.
			// we have byte type output from OutputStream, .. to write one line at a time we convert it to character type stream , which is done by pwr.
			// true parameter means that the data is automatically flushed. only after doing flush(), the data is sent to  file 
			// from buffer.
			Scanner ss = new Scanner(System.in);
			String str = ss.nextLine();
			pw.println(str);
			
			String s = br.readLine();
			System.out.println("Clinet = " + s);
			if(str.endsWith("Bye")) break;
			if(s.equals("bye")) break;
			}
			sock.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
