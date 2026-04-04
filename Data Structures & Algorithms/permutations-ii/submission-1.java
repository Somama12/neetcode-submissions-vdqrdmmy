class Solution {
    private Map<Integer, Integer> count;
    private List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        count=new HashMap<>();
        res=new ArrayList<>();
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        List<Integer> perm=new ArrayList<>();
        dfs(nums, perm);
        return res;
    }
    public void dfs(int[] nums, List<Integer> perm){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int num: count.keySet()){
            if(count.get(num)>0){
                perm.add(num);
                count.put(num, count.get(num)-1);
                dfs(nums, perm);
                perm.remove(perm.size()-1);
                count.put(num, count.get(num)+1);
            }
        }
    }
}