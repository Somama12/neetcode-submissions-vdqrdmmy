class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, candidates, target, comb, res);

        return res;
    }

    public void backtrack(int start, int[] candidates, int target, List<Integer> comb, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(start >= candidates.length || target < 0){
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;
            comb.add(candidates[i]);
            backtrack(i+1, candidates, target - candidates[i], comb, res);

            comb.remove(comb.size() - 1);
        }
    }
}
