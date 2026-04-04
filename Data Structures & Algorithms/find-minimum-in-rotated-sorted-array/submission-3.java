class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1 || nums[0]<nums[nums.length-1]) return nums[0];
        int min=nums[0];
        for(int num:nums){
            min=Math.min(min,num);
        }
        return min;
    }
}
