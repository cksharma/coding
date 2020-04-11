package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class RegularExpression {
	
	public void solve() {
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the postfix expression");
		String str = ss.nextLine();
		Stack<Double> stack = new Stack<Double>();
		StringTokenizer stk = new StringTokenizer(str, " ");
		List<String> lst = new ArrayList<String>();
		while (stk.hasMoreTokens()) {
			lst.add(stk.nextToken());
		}
		try {
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).equals("+")) {
					double first = stack.pop();
					double second = stack.pop();
					stack.push(first + second);
				} else if (lst.get(i).equals("-")) {
					double first = stack.pop();
					double second = stack.pop();
					stack.push(second - first);
				} else if (lst.get(i).equals("*")) {
					double first = stack.pop();
					double second = stack.pop();
					stack.push(first * second);
				} else if (lst.get(i).equals("/")) {
					double first = stack.pop();
					double second = stack.pop();
					stack.push(second / first);
				} else {
					stack.push(Double.parseDouble(lst.get(i)));
				}
			}
			if (stack.size() > 1 || stack.size() == 0) {
				System.out.println("Invalid input format..expression cannot be evaluated");
			} else {
				System.out.println("Postfix expression value = " + stack.peek());
			}
		} catch (Exception e) {
			System.out.println("Invalid input format..expression cannot be evaluated");
		}
	}

	public static void main(String[] args) {
		new RegularExpression().solve();
	}
}