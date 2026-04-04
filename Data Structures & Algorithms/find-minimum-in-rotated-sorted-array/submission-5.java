class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1 || nums[0]<nums[nums.length-1]) return nums[0];
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=(start+end)/2;
            if(nums[0]<=nums[mid]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return nums[start];
    }
}
