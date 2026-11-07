class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        backtrack(0, nums, inner, res);
        return res;
    }

    public void backtrack(int start, int[] nums, List<Integer> inner, List<List<Integer>> res){
        res.add(new ArrayList<>(inner));

        for(int i=start; i < nums.length; i++){
            inner.add(nums[i]);
            backtrack(i+1, nums, inner, res);
            inner.remove(inner.size()-1);
        }
    }
}
