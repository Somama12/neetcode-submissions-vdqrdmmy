class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, res, perm, visited);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> perm, boolean[] visited){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                perm.add(nums[i]);
                visited[i] = true;
                backtrack(nums, res, perm, visited);

                visited[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
