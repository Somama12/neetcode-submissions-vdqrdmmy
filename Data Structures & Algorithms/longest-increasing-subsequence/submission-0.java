class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] memo=new int[n][n+1];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
       return dp(nums, 0, -1, memo);
    }

    public int dp(int[] nums, int i, int j, int[][] memo){
        if(i==nums.length){
            return 0;
        }
        if(memo[i][j+1]!=-1) return memo[i][j+1];
        int LIS=dp(nums,i+1,j, memo);
        if(j==-1 || nums[j]<nums[i]){
            LIS=Math.max(LIS, 1+dp(nums, i+1, i, memo));
        }
        memo[i][j+1]=LIS;
        return LIS;
    }
}