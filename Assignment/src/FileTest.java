import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileTest {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskBBB solver = new TaskBBB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskBBB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
				
	}
}
