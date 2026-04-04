class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(recursion(cost, 0, dp), recursion(cost,1, dp));
    }
    public int recursion(int[] cost, int i, int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int left= cost[i]+recursion(cost, i+1, dp);
        int right=cost[i]+recursion(cost, i+2, dp);
        dp[i]=Math.min(left, right);
        return dp[i];
    }
}