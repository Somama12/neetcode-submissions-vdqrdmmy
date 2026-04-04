class Solution {
    public int rob(int[] nums) {
        int[] memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums,0, memo);
    }
    public int dp(int[] nums, int i, int[] memo){
        if(i>=nums.length) return 0;
        if(memo[i]!=-1) return memo[i];
        int first=nums[i]+dp(nums,i+2, memo);
        int second=dp(nums,i+1, memo);
        memo[i] = Math.max(first, second);
        return memo[i];
    }
}
