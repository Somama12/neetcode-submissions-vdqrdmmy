class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high){
        if(low<high){
            int pivot=partition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }

    public int partition(int[] nums, int low, int high){
        int pivot=nums[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        i++;
        int temp=nums[i];
        nums[i]=pivot;
        nums[high]=temp;
        return i;
    }
}