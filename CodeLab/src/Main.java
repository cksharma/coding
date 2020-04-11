/**
 * Created by cksharma on 3/27/15.
 */

public class Main {

    public static boolean isPrime(long n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int max = (int) Math.sqrt(n);
        for (int i = 3; i <= max; i += 2) {
            if (n % i == 0) return false;
        }
        return n > 1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        boolean isPrime = isPrime(5915587277L);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000.);
    }
}
