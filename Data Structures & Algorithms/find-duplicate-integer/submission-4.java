class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        int n = nums.length;

        while(i<n){
            int correctIndex = nums[i] - 1;

            if(nums[i]!=nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }else{
                i++;
            }
        }

        for(int j=0; j<n; j++){
               if (nums[j] != j + 1) return nums[j];
        }
        return -1;
    }
}
