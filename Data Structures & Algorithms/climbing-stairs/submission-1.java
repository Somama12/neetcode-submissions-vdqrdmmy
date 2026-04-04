class Solution {
    public int climbStairs(int n) {
        int[] d=new int[n];
        Arrays.fill(d,-1);
        return dp(1,n, d)+dp(2,n, d);
    }
    public int dp(int i, int n, int[] d){
        if(i>n) return 0;
        if(i==n){
            return 1;
        }
        if(d[i]!=-1){
            return d[i];
        }
        d[i]=dp(i+1,n,d)+dp(i+2,n,d);
        return d[i];
    }
}
