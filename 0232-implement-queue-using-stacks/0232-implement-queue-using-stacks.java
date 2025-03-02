import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1; // Acts as outputStack
    private Stack<Integer> s2; // Acts as inputStack

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        // Push new element into s2
        s2.push(x);
        
        // Move everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();  // O(1)
    }
    
    public int peek() {
        return s1.peek();  // O(1)
    }
    
    public boolean empty() {
        return s1.isEmpty();  // O(1)
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
