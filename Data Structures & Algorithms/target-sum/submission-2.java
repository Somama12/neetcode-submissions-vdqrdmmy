class Solution {
    HashMap<String, Integer> map=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
       
        return dp(nums, target,0);
    }
    public int dp(int[] nums, int target, int i){
        if (i == nums.length) {
             return target == 0 ? 1 : 0;
            }
        String key=i+","+target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        map.put(key,dp(nums, target-nums[i], i+1)+dp(nums, target+nums[i],i+1));
        return map.get(key);
    }
}
