package medium;

import java.util.Stack;

public class BasicCalc {
    public int calculate(String s) {
        s = s.replaceAll("\\(", " ").replaceAll("\\)", " ").replaceAll("\\+", " + ").replaceAll("-", " - ");
        String[] arr = s.split(" ");
        Stack<Integer> stackNum 	= new Stack<Integer> ();
        Stack<Character> stackChar 	= new Stack<Character> ();
        int ans = 0;
        for (String item : arr) {
        	item = item.trim();
        	if (item.length() == 0) continue;
			//System.out.print(item + " ");
			if (item.equals("+") || item.equals("-")) {
        		stackChar.add(item.charAt(0));
        		continue;
        	}
			int num2 = Integer.parseInt(item);
        	if (stackNum.size() == 1) {
        		int num1 = stackNum.pop();
        		char ch  = stackChar.pop();
				if (ch == '-')  ans = num1 - num2;
        		else ans = num1 + num2;
				stackNum.add(ans);
        	} else {
				stackNum.add(num2);
				ans = num2;
			}
        }
		return ans;
    }

	public static void main(String[] args) {
		BasicCalc calc = new BasicCalc();
		int ans = calc.calculate("(1+(4+5+2)-3)+(6+8)");
		System.out.println(ans);
	}
}