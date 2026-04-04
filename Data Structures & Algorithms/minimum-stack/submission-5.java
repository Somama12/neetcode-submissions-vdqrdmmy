class MinStack {
        Stack<Integer> s1;
        Stack<Integer> minStack;
    public MinStack() {
        s1 = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(s1.isEmpty()){
            s1.push(val);
            minStack.push(val);
        }else{
            s1.push(val);
            if(minStack.peek() >= val){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        int popped = s1.pop();
        if(minStack.peek() == popped){
            minStack.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
