package easy;
import java.util.Stack;

public class MinStackUsingStack {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int x) {
		stack.push(x);

		if (min.isEmpty() || x <= min.peek()) {
			min.push(x);
		}
	}

	public void pop() {
		int r = stack.pop();
		if (r == min.peek())
			min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}

	public static void main(String[] args) {
		MinStackUsingStack minStack = new MinStackUsingStack();
		minStack.push(5);
		minStack.push(7);
		minStack.push(2);
		minStack.push(6);
		minStack.push(3);
		minStack.push(1);
		minStack.push(8);
		minStack.push(5);

		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		// minStack.pop();System.out.println(minStack.getMin());
	}
}
