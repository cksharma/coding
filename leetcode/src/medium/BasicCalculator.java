package medium;

import java.util.*;

public class BasicCalculator {

    public int calculate(int left, char sign, int right) {
        switch(sign) {
            case '-':
                return left - right;
            case '+':
                return left + right;
            case '*':
                return left * right;
            case '/':
                return left / right;
        }
        return 0;
    }

    public int calculate(String expr) {
        expr = "(" + expr + ")";
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> intStack = new Stack<Integer>();
        
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch >= '0' && ch <= '9') {
                StringBuilder str = new StringBuilder();
                while (ch >= '0' && ch <= '9' && i < expr.length()) {
                    str.append(ch);
                    ch = expr.charAt(++i);
                }
                intStack.push(Integer.parseInt(str.toString()));
                i--;
            } else if ( ch == ')') {
                char sign = charStack.pop();
                while (sign != '(') {
                    int rt      = intStack.pop();
                    int lt      = intStack.pop();
                    if ( charStack.size() > 0 && charStack.peek() == '-') {
                        lt *= -1;
                        charStack.pop();
                        charStack.push('+');
                    }
                    int ans = calculate(lt, sign, rt);
                    intStack.push(ans);
                    sign = charStack.pop();
                }
            } else {
                if ( ch != ' ')
                    charStack.push(ch);
            }   
        }
        int ans = 0;
        if ( intStack.size() > 1 ) {
            while (intStack.size() > 0) {
                ans += calculate(intStack.pop(), charStack.pop(), intStack.pop());
            }
        } else {
            return intStack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        BasicCalculator calc = new BasicCalculator();
        System.out.println(calc.calculate("((1+(4+5+2)-3)+(6+8))"));
        System.out.println(calc.calculate("12232"));
        System.out.println(calc.calculate("   30"));
        System.out.println(calc.calculate(" 2-1 + 2"));
    }
}
