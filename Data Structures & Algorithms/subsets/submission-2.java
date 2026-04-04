class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        backtrack(0,nums, list, subset);
        return list;
    }
    public void backtrack(int i, int[] nums, List<List<Integer>> list,   List<Integer> subset){
        if(i>=nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i+1, nums, list, subset);
        subset.remove(subset.size()-1);
        backtrack(i+1, nums, list, subset);
    }
}
