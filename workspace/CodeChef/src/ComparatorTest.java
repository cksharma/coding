import java.util.Arrays;
import java.util.Comparator;

class Complex {
	String str;
	int value;

	public Complex(String str, int value) {
		super();
		this.str = str;
		this.value = value;
	}
}

class MyComparatorOne implements Comparator<Complex> {
	@Override
	public int compare(Complex o1, Complex o2) {
		return o1.str.compareTo(o2.str);
	}
}

public class ComparatorTest {

	public static void main(String[] args) {
		Complex[] complex = new Complex[4];
		complex[0] = new Complex("ck", 12);
		complex[1] = new Complex("hello", 12);
		complex[2] = new Complex("abcd", 12);
		complex[3] = new Complex("bcdef", 12);
		Arrays.sort(complex, new MyComparatorOne());
		for (Complex comp : complex)
			System.out.println(comp.str);
		int[] firstArray = new int[10];
		Arrays.sort(firstArray);	
	}
}
