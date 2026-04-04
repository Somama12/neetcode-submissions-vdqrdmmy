class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];

        int[] dp1=new int[nums.length];
        Arrays.fill(dp1,-1);

        int[] dp2=new int[nums.length];
        Arrays.fill(dp2,-1);

        return Math.max( dp(nums, 0, true, dp1), dp(nums, 1, false, dp2));
    }
    public int dp(int[] nums, int i, boolean flag, int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(flag && i==nums.length-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=nums[i]+dp(nums,i+2, flag || i==0,dp);
        int skip=dp(nums, i+1, flag,dp);
        dp[i]= Math.max(rob,skip);
        return dp[i];
    }
}
