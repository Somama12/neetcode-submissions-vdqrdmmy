class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        
        backtrack(0, nums, res, subset);
        return res;
    }

    public void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> subset){
        res.add(new ArrayList<>(subset));

        for(int i = start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(i+1, nums, res, subset);
            subset.remove(subset.size()-1);
        }
    }
}
