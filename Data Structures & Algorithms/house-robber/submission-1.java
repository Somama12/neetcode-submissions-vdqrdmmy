class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return recursion(nums,0, dp);
    }
    public int recursion(int[] nums, int i, int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int left=nums[i]+recursion(nums, i+2, dp);
        int right=recursion(nums,i+1,dp);
        dp[i]=Math.max(left,right);
        return dp[i];
    }
}
