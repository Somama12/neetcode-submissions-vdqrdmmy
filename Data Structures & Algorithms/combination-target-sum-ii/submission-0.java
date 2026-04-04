class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        dfs(candidates, 0, target, subset);
        return res;
    }
    public void dfs(int[] nums, int i, int target, List<Integer> subset){
        if(target==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i+1, target-nums[i], subset);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        dfs(nums, i+1, target, subset);
    }
}
