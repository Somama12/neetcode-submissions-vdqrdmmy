class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int a:asteroids){
            while( !s.isEmpty() && a<0 && s.peek()>0){
                int diff=s.peek()+a;
                if(diff>0){
                    a=0;
                }else if(diff<0){
                    s.pop();
                }else{
                    a=0;
                    s.pop();
                }
            }
            if(a!=0){
                s.push(a);
            }
        }
        int[] res=new int[s.size()];
        int k=s.size()-1;
        while(!s.isEmpty()){
            res[k]=s.pop();
            k--;
        }
        return res;
    }
}