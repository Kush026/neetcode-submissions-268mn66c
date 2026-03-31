class MinStack {

    private Deque<Long> stack = new LinkedList<>();
    private long min;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
        }

        stack.push(val - min);

        if(val < min) {
            min = val;
        }
    }

    // value = actual - min

    /**
    actualValue, min, stackValue
    5, 5, 0
    4, 4, -1
    **/
    
    public void pop() {
        long val = stack.pop();

        if (val < 0) {
            min = min - val;
        }
    }
    
    public int top() {
        if (stack.peek() < 0) {
            return (int) min;
        }

        return (int) (stack.peek() + min);
    }
    
    public int getMin() {
        return (int) min;
    }
}
