package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by cksharma on 1/2/16.
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String str) {
        int n = str.length();
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(')  stk.push(i);

            else {
                stk.pop();
                if (!stk.isEmpty()) result = Math.max(result, i - stk.peek());
                else stk.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestValidParenthesis lval = new LongestValidParenthesis();
        System.out.println(lval.longestValidParentheses(")()())"));
    }
}
