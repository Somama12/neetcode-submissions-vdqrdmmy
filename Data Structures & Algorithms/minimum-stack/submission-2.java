class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> minStack;
    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int top=s.pop();
        if(minStack.peek()==top){
            minStack.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
