class Solution {
    public int search(int[] nums, int target) {
    int pivotIndex=pivot(nums);
    int firstTry=binarySearch(nums,0,pivotIndex-1,target);
    if(firstTry!=-1){
        return firstTry;
    }
    return binarySearch(nums,pivotIndex,nums.length-1,target);
    }
    static int pivot(int[] nums){
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
    static int binarySearch(int[] nums, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
