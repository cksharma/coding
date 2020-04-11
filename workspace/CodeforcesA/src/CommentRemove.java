import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CommentRemove 
{
	public static void main(String[] args) 
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the file name .. complete path for the file name");
		String fileName = ss.nextLine();
		
		try
		{
			FileWriter writerMain = new FileWriter("mainCode.java");
			FileWriter writerComment = new FileWriter("commentCode.txt");
			
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			String str = ""; 
			
			boolean doubleQuote = false;
			
			String comment = "";
			String code = "";
						
			while((str = br.readLine()) != null)
			{
				for(int i = 0; i < str.length(); i++)
				{
					if(i + 1 < str.length() && str.charAt(i) == '/' && str.charAt(i + 1) == '*' && doubleQuote == false)
					{
						comment += "/*";
						int k = i;
						outer:while(true)
						{
							for(int j = k + 2; j < str.length(); j++)
							{
								if(j + 1 < str.length() && str.charAt(j) == '*' && str.charAt(j + 1) == '/')
								{
									comment += "*/";
									i = j + 1;
									break outer;
								}
								comment += str.charAt(j);
								
								if(j == str.length() - 1)
									comment += "\n";
								
							}
							str = br.readLine();
							
							k = -2;
						}
						continue;
					}
					if(i + 1 < str.length() && str.charAt(i) == '/' && str.charAt(i + 1) == '/' && doubleQuote == false)
					{
						comment += "\n";
						comment += str.substring(i); 
						code += "\n";
						break;
					}
					
					if(i - 1 >= 0 && str.charAt(i) == '"' && str.charAt(i - 1) != '\\' && doubleQuote == false)
					{
						doubleQuote = true;
						
					}
					else if(doubleQuote && i - 1 >= 0 && str.charAt(i) == '"' && str.charAt(i - 1) != '\\')
					{
						doubleQuote = false;
					}
					code += str.charAt(i);
					if(i == str.length() - 1) code += "\n";
				}
			}
			//System.out.println(code);
			writerMain.write(code);
			writerComment.write(comment);
			writerMain.close();
			writerComment.close();
			file.close();
			System.out.println("See the file mainCode.java and commentCode.java");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
