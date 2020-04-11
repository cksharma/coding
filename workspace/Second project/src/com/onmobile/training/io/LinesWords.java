package com.onmobile.training.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LinesWords {

	public static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	public static boolean isConsonant(char c) {
		c = Character.toLowerCase(c);
		return c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i'
				&& c != 'o' && c != 'u';
	}
	
	public static boolean isDigit(char c) 
	{
		return c >= '0' && c <= '9';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lines = 0;
		int words = 0;
		int alphabets = 0;
		int vowels = 0;
		int consonants = 0;
		int digits = 0; 
		String fileName = ""; boolean found = true;
		System.out.println("Enter the file Name");
		Scanner ss = new Scanner(System.in);
		try {
			fileName = ss.nextLine();
			File ff = new File(fileName);
			if(ff.exists())
			{	
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				String sf = br.readLine();
				while(sf != null)
				{
					lines++;
					StringTokenizer stk = new StringTokenizer(sf, " ");
					words += stk.countTokens();
					for(int i = 0; i < sf.length(); i++)
					{
						if(isVowel(sf.charAt(i))) vowels++;
						else if(isConsonant(sf.charAt(i))) consonants++;
						else if(isDigit(sf.charAt(i))) digits++;
					}
					sf = br.readLine();
				}
			}
			else
			{
				found = false;
				System.out.println("This file is not found guys");
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		if(found)
		{
			System.out.println("Total number of lines = " + lines);
			System.out.println("Total number of words = " + words);
			System.out.println("Total number of alphabets = " + (vowels + consonants + digits));
			System.out.println("Total number of vowels = " + vowels);
			System.out.println("Total number of consonants = " + consonants);
		}	
	}

}
