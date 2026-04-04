class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        int rob0 = recursion(nums, 0, true, dp1);
        
        int rob1 = recursion(nums, 1, false, dp2);
        
        return Math.max(rob0, rob1);
    }
    
    public int recursion(int[] nums, int i, boolean firstRobbed, int[] dp) {
        int n = nums.length;
        
        // Base case: exceeded array bounds
        if (i >= n) return 0;
        
        // Cannot rob last house if first house was robbed
        if (firstRobbed && i == n - 1) return 0;
        
        if (dp[i] != -1) return dp[i];
        
        // Rob current house
        boolean newFlag = firstRobbed || i == 0;
        int rob = nums[i] + recursion(nums, i + 2, newFlag, dp);
        
        // Skip current house
        int skip = recursion(nums, i + 1, firstRobbed, dp);
        
        dp[i] = Math.max(rob, skip);
        return dp[i];
    }
}
