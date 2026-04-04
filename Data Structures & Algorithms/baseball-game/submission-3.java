class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String opr : operations){
            if( opr.equals("+") ){
                int first = stack.pop();
                int second = stack.peek();
                int sum = first + second;
                stack.push(first);
                stack.push(sum);
            }else if( opr.equals("D")){
                stack.push( stack.peek() * 2 );
            }else if( opr.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(opr));
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}