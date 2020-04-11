import java.util.Set;
import java.util.TreeSet;

public class FileWriteTest 
{
	public static void main(String[] args) 
	{
		Set <Integer> tset = new TreeSet <Integer> (new IntegerComparator());
		tset.add(3); tset.add(5); tset.add(8);
		System.out.println(tset);
	}
}
