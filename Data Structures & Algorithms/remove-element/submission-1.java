class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]==val){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
            }
            if(nums[left]!=val){
                left++;
            }
        }
        int count=0;
        for(int num:nums){
            if(num!=val){
                count++;
            }
        }
        return count;
    }
}