package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();
        Set <String> set = new HashSet<>(Arrays.asList("*", "/", "+", "-"));
        for (String item : tokens) {
        	if (set.contains(item)) {
        		int first = stack.pop();
        		int secon = stack.pop();
        		int result = 1;
        		switch(item) {
        			case "*":
        				result = first * secon;
        				break;
        			case "/":
        				result = secon / first;
        				break;
        			case "-":
        				result = secon - first;
        				break;
        			case "+":
        				result = first + secon;
        				break;
        		}
        		stack.push(result);
        	} else {
        		stack.push(Integer.valueOf(item));
        	}
        }
        return stack.peek();
    }
    public static void main(String[] args) {
		EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
		System.out.println(sol.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(sol.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
}
