package medium;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int i = 0, n = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        while (i < n) {
        	if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
        		stack.push(i++);
        	} else {
        		int top = stack.pop();
        		int base = stack.isEmpty() ? i : i - stack.peek() - 1;
        		ans = Math.max(ans, base * height[top]);
        	}
        }
        while (!stack.isEmpty()) {
        	int top = stack.pop();
    		
			int base = stack.isEmpty() ? i : i - stack.peek() - 1;
			ans = Math.max(ans, base * height[top]);
		
        }
        return ans;
    }
    public static void main(String[] args) {
    	LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
    	int height[] = {6, 2, 5, 4, 5, 1, 6};
    	System.out.println(sol.largestRectangleArea(height));
    	
	}
}
