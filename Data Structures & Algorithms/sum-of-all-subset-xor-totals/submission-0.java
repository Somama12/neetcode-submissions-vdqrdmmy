class Solution {
    private int res;
    public int subsetXORSum(int[] nums) {
        res=0;
        int[] ans={0};
        backtrack(0, nums, ans);
        return res;
    }
    public void backtrack(int i, int[] nums, int[] ans){
        if(i>=nums.length){
            res+=ans[0];
            return;
        }
        ans[0]=ans[0]^nums[i];
        backtrack(i+1, nums, ans);
        ans[0]=ans[0]^nums[i];
        backtrack(i+1, nums, ans);
    }
}