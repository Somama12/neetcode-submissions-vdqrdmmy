class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        backtrack(1, n,  k,result, comb);
        return result;
    }
    public void backtrack(int start, int n, int k,  List<List<Integer>> result, List<Integer> comb ){
        if(comb.size()>=k){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            backtrack(i+1, n, k, result, comb);
            comb.remove(comb.size()-1);
        }
    }
}