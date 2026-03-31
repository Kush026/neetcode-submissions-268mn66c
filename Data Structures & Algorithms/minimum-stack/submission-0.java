class MinStack {

    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        int m = val;

        if(!minStack.isEmpty() && minStack.peek() < val) {
            m = minStack.peek();
        }
        minStack.push(m);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
