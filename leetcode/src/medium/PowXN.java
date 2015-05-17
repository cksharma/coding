package medium;

public class PowXN {
	public double powCKS(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0)
        	return powCKS(x * x, n / 2);	
        else 
        	return x * powCKS(x, n  - 1);
    }
	public double pow(double x, int n) {
        double ans = powCKS(x, Math.abs((long)n));
        if (n < 0) return 1 / ans;
        return ans;
    }
    public static void main(String[] args) {
		PowXN sol = new PowXN();
		System.out.println(sol.pow(10, 5));
		System.out.println(sol.pow(2, 10));
		System.out.println(sol.pow(3, 4));
		System.out.println(sol.pow(10, 7));
		System.out.println(sol.pow(34.00515, -3));
		System.out.println(sol.pow(1, Integer.MIN_VALUE));
	}
}
