class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> getMin;
    public MinStack() {
        s=new Stack<>();
        getMin=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        getMin.push(val);
    }
    
    public void pop() {
        s.pop();
        getMin.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int val:s){
            min=Math.min(min, val);
        }
        return min;
    }
}
