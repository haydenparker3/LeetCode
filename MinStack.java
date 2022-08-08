class MinStack {
    Stack<Pair<Integer, Integer>> s = new Stack<>();
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s.isEmpty()) {
            s.push(new Pair<>(val, val));
        } else {
            int prevMin = s.peek().getValue();
            if(val < prevMin) {
                s.push(new Pair<>(val, val));
            } else
                s.push(new Pair<>(val, prevMin));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().getKey();
    }
    
    public int getMin() {
        return s.peek().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */