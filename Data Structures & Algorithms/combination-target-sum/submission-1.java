class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(0, nums, target, comb, res);

        return res;
    }

    public void backtrack(int start, int[] nums, int target, List<Integer> comb, List<List<Integer>> res){
        if(target < 0 || start >= nums.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(comb));
        }

        for(int i=start; i<nums.length; i++){
            comb.add(nums[i]);
            target= target - nums[i];
            backtrack(i, nums, target, comb, res);


            target = target + comb.get(comb.size()-1);
            comb.remove(comb.size()-1);
        }
    }
}
