class Solution {
    public int climbStairs(int n) {
        return dp(1,n)+dp(2,n);
    }
    public int dp(int i, int n){
        if(i>n) return 0;
        if(i==n){
            return 1;
        }
        return dp(i+1,n)+dp(i+2,n);
    }
}
