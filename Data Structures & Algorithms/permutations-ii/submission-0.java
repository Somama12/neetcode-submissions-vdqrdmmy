class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> perm = new ArrayList<>();
        dfs(nums, res, perm, new boolean[nums.length]);
        return new ArrayList<>(res);
    }
    public void dfs(int[] nums, Set<List<Integer>> res, List<Integer> perm, boolean[] pick) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i]=true;
                dfs(nums, res, perm, pick);
                perm.remove(perm.size() - 1);
                pick[i]=false;
            }
        }
    }
}