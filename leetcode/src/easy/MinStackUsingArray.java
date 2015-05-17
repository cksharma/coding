package easy;
public class MinStackUsingArray {
	
	private final int MAX = 1 << 18;
	private int[] stack = new int[MAX];
	private int[] min = new int[MAX];
	{
		initializeArray(stack, min, MAX);		
	}
	
	private int index;
	
	private void initializeArray(int[] stack, int[] min, int size) {
		
		for (int i = 0; i < size; i++) {
			min[i] = Integer.MAX_VALUE;
			stack[i] = -1;
		}
	}
	
	public void push(int x) {
		stack[index] = x;
		if (index == 0 || x < min[index - 1])
			min[index] = x;
		else 
			min[index] = min[index - 1];
		index++;
	}

	public void pop() {
		index--;
	}

	public int top() {
		return stack[index];
	}

	public int getMin() {
		return min[index];
	}

	public static void main(String[] args) {
		MinStackUsingArray minStack = new MinStackUsingArray();
		for (int i = -10000; i <= 10000; i++) {
			minStack.push(i);
		}
		
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
		minStack.pop();System.out.println(minStack.getMin());
	}
}
