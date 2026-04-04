class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, target,0);
    }
    public int dp(int[] nums, int target, int i){
        if (i == nums.length) {
             return target == 0 ? 1 : 0;
            }
        return dp(nums, target-nums[i], i+1)+dp(nums, target+nums[i],i+1);
    }
}
