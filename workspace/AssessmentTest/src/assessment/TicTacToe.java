package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TicTacToe implements Runnable {
	
	private void show(int[][] A, boolean[][] B)
	{
		int N = A.length;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(B[i][j] == false) System.out.print("---   ");
				else System.out.print(A[i][j] + "     ");
			}
			System.out.println(); System.out.println();	
		}
	}
	
	private boolean allFilled(boolean[][] B)
	{
		for(int i = 0; i < B.length; i++)
		{
			for(int j = 0; j < B[i].length; j++)
			{
				if(B[i][j] == false) return false;
			}
		}
		return true;
	}
	
	private boolean checkWinner(int choice, int[][] A)
	{
		boolean check = false;
		for(int i = 0; i < A.length; i++)
		{
			boolean flag = true;
			for(int j = 0; j < A[0].length; j++)
			{
				if(A[i][j] != choice) flag = false;
			}
			if(flag) check = flag;
		}
		for(int i = 0; i < A[0].length; i++)
		{
			boolean flag = true;
			for(int j = 0; j < A.length; j++)
			{
				if(A[j][i] != choice) flag = false;
			}
			if(flag) check = flag;
		}
		boolean flag = true;
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[0].length; j++)
			{
				if(i == j && A[i][j] != choice) flag = false;
			}
		}
		if(flag) check = flag;
		
		flag = true;
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[i].length; j++)
			{
				if(i + j == A.length - 1 && A[i][j] != choice) flag = false; 
			}
		}
		if(flag) check = flag;
		return check;
	}
	
	private void solve() throws IOException {
		System.out.println("First player will enter  1 and second player will enter 2");
			
		System.out.println("Enter the size of TIC TAC TOE's dimension u wanna play");
		
		int N = nextInt();
		boolean[][] B = new boolean[N][N];
		int[][] A = new int[N][N];
		int x = 0, y = 0;
		
		int turn = 1;
		
		while(true)
		{
			System.out.println();
			show(A, B);
			
			if(turn % 2 == 1) System.out.println("First Player's turn");
			else System.out.println("Second Player's turn");
			
			System.out.println();
			System.out.println("Enter the row number u wanna insert");
			x = nextInt();
			System.out.println("Enter the column number u wanna insert");
			y = nextInt();
			
			if(x >= N || y >= N) 
			{
				System.out.println("Grid's dimension selected is invalid");
				continue;
			}
			if(B[x][y]) 
			{
				System.out.println("This grid is already filled .. so choose next grid again");
				continue;
			}
			String ans = turn == 1 ? "First" : "Second";
			
			B[x][y] = true;
			A[x][y] = turn;
								
			if(checkWinner(turn, A))
			{
				System.out.println("WINNER IS " + ans.toUpperCase() + " player".toUpperCase());
				System.out.println();
				show(A, B);
				break;
			}
			else if(allFilled(B))
			{
				System.out.println("The game is darw".toUpperCase());
				System.out.println();
				show(A, B);
				break;
			}
			
			turn = (turn == 1) ? 2 : 1;
		}	
	}

	public static void main(String[] args) {
		new TicTacToe().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}
