class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> com=new ArrayList<>();
        dfs(n,1 ,k, res, com);
        return res;
    }
    public void dfs(int n, int i, int k, List<List<Integer>> res, List<Integer> com ){
        if(com.size()==k){
            res.add(new ArrayList<>(com));
            return;
        }
        if(com.size()>k || i>n){
            return;
        }
        com.add(i);
        dfs(n, i+1, k, res, com);
        com.remove(com.size()-1);
        dfs(n, i+1, k, res, com);
    }
}