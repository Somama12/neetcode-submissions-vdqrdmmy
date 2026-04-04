class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> set=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            int find=target-nums[i];
            if(set.containsKey(find)){
                ans[0]=set.get(find);
                ans[1]=i;
            }
            set.put(nums[i],i);
        }
        return ans;
    }
}
