/*
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 */
public class MyStack {
    // 12:28 - 12:33
    Queue<Integer> q1, q2;
 
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()) {
            q1.add(x);
            while(q2.size() > 0) {
                q1.add(q2.poll());
            }
        }
        else {
            q2.add(x);
            while(q1.size() > 0) {
                q2.add(q1.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(q1.size() > 0) {
            return q1.poll();
        } else {
            return q2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if(q1.size() > 0) {
            return q1.peek();
        } else {
            return q2.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}


