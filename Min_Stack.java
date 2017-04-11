/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
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

// v2
public class MinStack {
    // 10:20 - 10:25
 
    /** initialize your data structure here. */
    private Stack<Integer> stack, minstack;
    
    public MinStack() {
        stack = new Stack();
        minstack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.empty()) {
            minstack.push(x);
        } else {
            minstack.push(Math.min(x, minstack.peek()));
        }
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
}

// v3
public class MinStack {
    // 11:34 - 11:37
    Stack<Integer> stack = new Stack();
    Stack<Integer> minstack = new Stack();
 
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        int min = minstack.size() == 0 ? x : Math.min(x, minstack.peek());
        stack.push(x);
        minstack.push(min);
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
}

// v4
public class MinStack {
    // 11:37 - 11:41 minor optimization
    Stack<Integer> stack = new Stack();
    Stack<Integer> minstack = new Stack();
 
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.size() == 0 || minstack.peek() >= x) {
            minstack.push(x);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minstack.peek()) {
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
