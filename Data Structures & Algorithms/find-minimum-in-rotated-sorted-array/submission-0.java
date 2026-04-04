class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1]) return nums[0];
        return nums[findPivot(nums)];

    }
    static int findPivot(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[nums.length-1]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}
