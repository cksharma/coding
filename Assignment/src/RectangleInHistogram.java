import java.util.Scanner;
import java.util.Stack;

class RectangleInHistogram
{
	static long largestArea(int arr[])
	{
		int len = arr.length;
		long area[] = new long[len]; // initialize it to 0
		int i, t;
		Stack<Integer> St = new Stack<Integer>();

		// include stack for using this #include<stack>
		
		for (i = 0; i < len; i++)
		{
			while (!St.empty())
			{
				if (arr[i] <= arr[St.peek()])
				{
					St.pop();
				} 
				else
					break;
			}
			if (St.empty())
				t = -1;
			else
				t = St.peek();
			// Calculating Li
			area[i] = i - t - 1;
			St.push(i);
		}

		St.clear();

		for (i = len - 1; i >= 0; i--)
		{
			while (!St.empty())
			{
				if (arr[i] <= arr[St.peek()])
				{
					St.pop();
				} else
					break;
			}
			if (St.empty())
				t = len;
			else
				t = St.peek();
			// calculating Ri, after this step area[i] = Li + Ri
			area[i] += t - i - 1;
			St.push(i);
		}

		long max = 0;
		// Calculating Area[i] and find max Area
		for (i = 0; i < len; i++)
		{
			area[i] = arr[i] * (area[i] + 1);
			if (area[i] > max)
				max = area[i];
		}
		return max;
	}
	
	public static void main(String[] args) 
	{
		Scanner si = new Scanner(System.in);
		while(true)
		{
			int N = si.nextInt();
			if(N == 0) break;
			int[] A = new int[N];
			for(int i = 0; i < N; i++) A[i] = si.nextInt();
			long area = largestArea(A);
			System.out.println(area);
		}	
	}
}
