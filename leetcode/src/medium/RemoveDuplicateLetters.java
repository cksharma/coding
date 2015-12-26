package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by cksharma on 12/13/15.
 */
public class RemoveDuplicateLetters {

    //TODO NOT ACCEPTED

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) return s;


        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        int lastIndex = s.length() - 1;
        while (lastIndex >= 0) {
            char ch = s.charAt(lastIndex--);
            if (set.contains(ch) == false) {
                stack.push(ch);
                set.add(ch);
                continue;
            }

            char top = stack.peek();
            if (ch < top) stack.push(ch);
        }
        set.clear();
        StringBuilder sb = new StringBuilder();
        while (stack.isEmpty() == false) {
            char ch = stack.pop();
            if (set.contains(ch)) continue;
            sb.append(ch);
            set.add(ch);
        }

        StringBuilder sb1 = new StringBuilder();
        int firstIndex = 0;
        stack.clear();
        set.clear();
        while (firstIndex < s.length()) {
            char ch = s.charAt(firstIndex++);
            if (set.contains(ch) == false) {
                stack.push(ch);
                set.add(ch);
                continue;
            }

            char top = stack.peek();
            if (ch < top) stack.push(ch);
        }

        set.clear();
        Stack<Character> myStack = new Stack<>();
        while (stack.isEmpty() == false) {
            myStack.push(stack.pop());
        }
        while (myStack.isEmpty() == false) {
            char ch = myStack.pop();
            if (set.contains(ch)) continue;
            sb1.append(ch);
            set.add(ch);
        }

        return sb.toString().compareTo(sb1.toString()) < 0 ? sb.toString() : sb1.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters sol = new RemoveDuplicateLetters();
        String ans = sol.removeDuplicateLetters("bcabc");
        String ans1 = sol.removeDuplicateLetters("cbacdcbc");
        String ans2 = sol.removeDuplicateLetters("abacb");

        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
