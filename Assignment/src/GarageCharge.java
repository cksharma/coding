
public class GarageCharge
{
	public static double calculateCharges(int hour)
	{
		double ans = 0;
		if(hour <= 3)
			ans = 2.;
		else 
			ans = 2. + (hour - 3.) * 0.5;
		return Math.min(ans, 10.0);
	}
	
	public static int zeroOneKnapsack()
	{
	    int[] x = {5, 4, 6, 3};
	    int[] v = {10, 40, 30, 50};
	    int W = 10;
	    int[][] C = new int[x.length + 1][W + 1];

	    for(int i = 0; i <= x.length; i++)  C[i][0] = 0;
	    for(int w = 0; w <= W; w++) C[0][w] = 0;

	    for(int i = 1; i <= x.length; i++)
	    {
	        for(int w = 1; w <= W; w++)
	        {
	            if(w < x[i - 1]) C[i][w] = C[i - 1][w];
	            else C[i][w] = Math.max(C[i - 1][w], C[i - 1][w - x[i - 1]] + v[i - 1]);
	        }
	    }
	    return C[x.length][W];
	}
	public static void main(String[] args) 
	{
		System.out.println(zeroOneKnapsack());
	}
}