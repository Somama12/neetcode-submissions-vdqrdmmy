class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            int diff=target-sum;
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(sum, i);
        }
        return new int[]{-1,-1};
    }
}
