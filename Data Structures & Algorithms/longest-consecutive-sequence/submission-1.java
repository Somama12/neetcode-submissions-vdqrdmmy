class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            int currentCount=0;
            if(!set.contains(nums[i]-1)){
                int currentNum=nums[i];
                currentCount=1;
                while(set.contains(currentNum+1)){
                    currentCount++;
                    currentNum++;
                    // set.remove(currentNum);
                }
            }
            count=Math.max(count, currentCount);
        }
        return count;

    }
}