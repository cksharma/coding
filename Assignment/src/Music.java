import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Music
{
	public static String filePath = "E:\\study\\Company Study\\Music\\Vodacon TNZ\\Music Scripts - Final-Modified.txt";
	
	public static String operatorNameFirst = "AirtelMalawi";
	
	public static String operatorNameSecond = "AirtelMal";
	
	public static String operatorNameThird = "ATLMAL";
		
	public static String contentType = "Music";
	
	public static String ans = "";
	
	public static String processCreateOrReplace(String str)
	{
		return "";
	}
	
	public static String process(String str)
	{
		if(str.contains("CREATE OR REPLACE"))
		{
			processCreateOrReplace(str);			
		}
		return "";
	}
	
	public static void main(String[] args) 
	{
		File file = new File(filePath);
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String str = null;
			while((str = reader.readLine()) != null && str.length() != 0)
			{
				ans += process(str) + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
