package medium;

import java.util.Stack;

/**
 * Created by cksharma on 8/20/15.
 */
public class BasicCalculatorII {

    private int compute(int right, int left, char sign) {
        switch(sign) {
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '+':
                return left + right;
            case '-':
                return left - right;
        }
        return 0;
    }

    public int calculate(String s) {
        int ans = 0;
        Stack<Character> charStack  = new Stack<>();
        Stack<Integer> intStack     = new Stack<>();
        s = " " + s + " ";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (ch >= '0' && ch <= '9') {
                String ss = "";
                while (i < s.length() && ch >= '0' && ch <= '9') {
                    ss = ss + ch;

                    ch = s.charAt(++i);
                }
                i--;
                intStack.push(Integer.parseInt(ss));
                if ( charStack.isEmpty() == false && (charStack.peek() == '*' || charStack.peek() == '/')) {
                    int rt = intStack.pop();
                    int lt = intStack.pop();
                    char c = charStack.pop();
                    intStack.push( compute(rt, lt, c ));
                }
            } else {
                charStack.push(ch);
            }
        }

        if ( charStack.size() > 0) {
            while (charStack.isEmpty() == false) {
                int rt    = intStack.pop();
                int lt    = intStack.pop();
                char sign = charStack.pop();
                if ( charStack.size() > 0 && charStack.peek() == '-') {
                    lt *= -1;
                    charStack.pop();
                    charStack.push('+');
                }
                int res = compute(rt, lt, sign);
                intStack.push(res);
            }
        }
        return intStack.peek();
    }

    public static void main(String[] args) {
        BasicCalculatorII sol = new BasicCalculatorII();
        System.out.println(sol.calculate("3+2*2"));
        System.out.println(sol.calculate(" 3/2 "));
        System.out.println(sol.calculate(" 3+5 / 2 "));
        System.out.println(sol.calculate("0-2147483647"));
        System.out.println(sol.calculate("0/1"));
        System.out.println(sol.calculate("1-1+1"));
    }
}
