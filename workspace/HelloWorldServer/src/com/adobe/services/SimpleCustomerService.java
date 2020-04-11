package com.adobe.services;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import com.server.test.Employee;

public class SimpleCustomerService{
	
	File soundFile;

	JDialog playingDialog;
	  
	Clip clip;
	
	public ArrayList<String> getAllCustomers(Employee name) {
		System.out.println("Server Hi");
		/*
		 * for (Object object : name) { System.out.println(object); }
		 */
		System.out.println(name.getId());
		System.out.println(name.getName());
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("abcd");
		lst.add("wxyz");
		return lst;
	}

	public Employee getEmployeeFromServer() {
		return new Employee("chandra", 2341);
	}
	
	public void sendString(String str)
	{
		
	}
	
	public String sendByteArray( Byte[] B) {
		System.out.println(B.length);
		//getAudio(B);
		return "this is good";
	}

	public void getAudio(Byte[] audio) {
		 try
		 {
		int L = audio.length; 
		Integer[] audioBytes = new Integer[L];
		for(int i = 0; i < L; i++)
		{
			if(audio[i] >= 0) audioBytes[i] = (int)audio[i];
			else audioBytes[i] = (int)(audio[i] + 256);
		}
		System.out.println("Checking");
		for(int i = 450; i <= 500; i++)
		{
			System.out.print(audioBytes[i]+" ");
		}
		
		FileOutputStream fout = new FileOutputStream("E:/sounds/a.txt");
		
		for(int i = 0; i < L; i++)
		{
			fout.write(audioBytes[i]);
		}
		
		fout.close();
		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		float rate = 44100.0f;
		int channels = 1;
		int frameSize = 4;
		int sampleSize = 16;
		boolean bigEndian = true;

		AudioFormat format = new AudioFormat(encoding, rate, sampleSize,
				channels, (sampleSize / 8) * channels, rate, bigEndian);

		int frameSizeInBytes = format.getFrameSize() * 2;
		
		FileInputStream fin = new FileInputStream("E:/sounds/a.txt");
		DataInputStream bais = new DataInputStream(fin);
		AudioInputStream audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);
		
		//AudioInputStream audioStream = new AudioInputStrea
		//long milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / format.getFrameRate());

		try {
			//audioInputStream.reset();
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		
		try {
			
			File outFile = new File("C:/Users/chandrakant.sharma/Desktop/out.wav");
			//InputStream byteArray = new ByteArrayInputStream(audioBytes);
			//AudioInputStream ais = AudioSystem.getAudioInputStream(byteArray);
			 
	      // AudioSystem.write(ais, AudioFileFormat.Type.WAVE, outFile);
			AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
		 
	}
}
