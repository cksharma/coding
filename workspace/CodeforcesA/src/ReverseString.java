import java.util.Scanner;

public class ReverseString {
	
	public String solve(int i, String str)
	{
		if(str.length() == 1) return str;
		if(str.length() == 0) return "";
		return solve(i + 1, str.substring(0, i)) + str.charAt(i) + "";
	}
	
	public static void main(String[] args) 
	{
		Scanner ss = new Scanner(System.in);
		String str = ss.nextLine();
		System.out.println(new ReverseString().solve(0, str));
	}
}
