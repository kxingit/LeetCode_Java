public class MinStack {
	private Stack<Integer> stack, minstack;

	public MinStack() {
		stack = new Stack();
		minstack = new Stack();
	}

	public void push(int x) {
		if(minstack.empty()) {
			minstack.push(x);
		} else {
			minstack.push(Math.min(x, minstack.peek()));
		}
		stack.push(x);
	}

	public void pop() {
		stack.pop();
		minstack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}
};
