class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the first index (pivot) from right where nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i>0){
        int minIndex = findMin(nums,i, i+1, n-1);
        swap(nums, i, minIndex);
        }
        reverse(nums, i+1, n-1);
    }
public int findMin(int[] nums, int i, int l, int r) {
    int index = -1;
    int pivot = nums[i];
    int nextGreater = Integer.MAX_VALUE;

    for (int j = l; j <= r; j++) {
        if (nums[j] > pivot && nums[j] < nextGreater) {
            nextGreater = nums[j];
            index = j;
        }
    }
    return index;
}

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
