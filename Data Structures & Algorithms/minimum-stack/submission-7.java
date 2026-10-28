class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {

        s.push(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            if(minStack.peek() >= val){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        int popped = s.pop();
        if(minStack.peek() == popped){
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
