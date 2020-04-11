import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Second {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		Map <Integer, Map <Integer, Boolean> > playerSolution = new HashMap <> ();
		Map <Integer, List <Integer> > playerList = new HashMap <>();
		
		for (int i = 0; i < n; i++) {
			int solutionNumber = in.nextInt();
			int playerNumber   = in.nextInt(); 
			
			if (playerSolution.containsKey(playerNumber)) {
				Map <Integer, Boolean> map = playerSolution.get(playerNumber);
				if (map.containsKey(solutionNumber)) {
					continue;
				} else {
					map.put(solutionNumber, true);
					playerSolution.put(playerNumber, map);
					
					List <Integer> list = playerList.get(playerNumber);
					if (list == null) { 
						list = new ArrayList <> ();
						playerList.put(playerNumber, list);
					}	
					list.add(solutionNumber);
				}
			} else {
				HashMap <Integer, Boolean> map = new HashMap<>();
				map.put(solutionNumber, true);
				playerSolution.put(playerNumber, map);
				
				List <Integer> list = new ArrayList <>();
				list.add(solutionNumber);
				playerList.put(playerNumber, list);
			}
		}
		
		String ans = "YES";
		
		for (int player : playerList.keySet()) {
			List <Integer> ll = playerList.get(player);
			int sum = 0;
			for (int i = 0; i < ll.size(); i++) {
				if (ll.get(i) > sum) {
					ans = "NO";
					break;		
				}
				sum = sum + 1;
			}
		}		
		out.println(ans);
	}
}

/*class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public String nextLine() {
		String inputLine = "";
		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputLine;
	}
}*/