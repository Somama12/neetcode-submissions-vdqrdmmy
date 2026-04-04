class Solution {
    public int[] getConcatenation(int[] nums) {
        int len=2*nums.length;
        int[] ans=new int[len];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
            ans[nums.length+i]=nums[i];
        }
        return ans;
    }
}