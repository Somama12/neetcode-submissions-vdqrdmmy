class Solution {
    public int search(int[] nums, int target) {
        int index = pivot(nums);
        int firstTry = binarySearch(nums, 0, index-1, target);
        if(firstTry !=-1 ) return firstTry;

        int secondTry = binarySearch(nums, index, nums.length-1, target);
        return secondTry;
    }

    public int pivot(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums,int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left)/2;

            if(target ==nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
