class Solution {
    public int removeElement(int[] nums, int val) {
        int size=0;
        for(int num:nums){
            if(num!=val){
                nums[size]=num;
                size++;
            }
        }
        return size;
    }
}