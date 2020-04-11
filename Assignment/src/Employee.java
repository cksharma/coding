//import java.io.InputStream;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//
//public class Employee {
//	public static void main(String[] args) {
//		InputStream inputStream = System.in;
//		PrintStream outputStream = System.out;
//		InputReader in = new InputReader(inputStream);
//		PrintWriter out = new PrintWriter(outputStream);
//		TaskB solver = new TaskB();
//		solver.solve(1, in, out);
//		out.close();
//	}
//}
//
//class TaskB {
//	
//	public String getAnswer (int legs, int duckTails, int viverTails) {
//		int ducks = 0, viver = 0, platypus = 0;
//		for (int dc = 0; dc <= legs / 2; dc++) {
//			for (int vc = 0; vc <=legs / 4; vc++) {
//				for (int pc = 0; pc <= legs / 4; pc++) {					
//					if(dc * 2 + vc * 4 + pc * 4 > legs) {
//						break;
//					}
//					else if(dc * 2 + vc * 4 + pc* 4 == legs && dc + pc == duckTails && vc + pc == viverTails) {
//						ducks = dc;
//						viver = vc;
//						platypus = pc;
//					}					
//				}
//				if(dc * 2 + vc * 4 > legs) {
//					break;
//				}
//			}
//		}
//		if (ducks == 0 && viver == 0 && platypus == 0) {
//			return "Not possible. Input is not the valid case";
//		} else {
//			return "Ducks Count = " + ducks + "\n" + "Vivers count = " + viver + "\n" + "Platypus count = " + platypus + "\n" + "Total count = " + (ducks + viver + platypus);
//		}
//	}
//	
//	public void solve(int testNumber, InputReader in, PrintWriter out) {
//		int legs = in.nextInt();
//		int duckTails = in.nextInt();
//		int viverTails = in.nextInt();
//		out.println(getAnswer(legs, duckTails, viverTails));
//	}
//}
