class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String opr: operations){
            if(opr.equals("+")){
                int top=stack.pop();
                int peek=stack.peek();
                stack.push(top);
                stack.push(top+peek);
            }else if(opr.equals("D")){
                int top=stack.peek();
                stack.push(top*2);
            }else if(opr.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(opr));
            }
        }
        int sum=0;
        for(int num:stack){
            sum+=num;
        }
        return sum;
    }
}