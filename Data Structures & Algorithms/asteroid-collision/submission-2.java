class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int a:asteroids){
            while( !stack.isEmpty() && a<0 && stack.peek()>0){
                int diff=stack.peek()+a;
                if(diff>0){
                    a=0;
                }else if(diff<0){
                    stack.pop();
                }else{
                    stack.pop();
                    a=0;
                }
            }
            if(a!=0){
                stack.push(a);
            }
        }
        int[] res=new int[stack.size()];
        int k=stack.size()-1;
        while(!stack.isEmpty()){
            res[k]=stack.pop();
            k--;
        }
        return res;
    }
}