class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> perm=new ArrayList<>();
        boolean[] pick=new boolean[nums.length];
        backtrack(nums, pick, list, perm);
        return list;
    }
    public void backtrack(int[] nums, boolean[] pick, List<List<Integer>> list, List<Integer> perm){
        if(perm.size()>=nums.length){
            list.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                perm.add(nums[i]);
                pick[i]=true;
                backtrack(nums, pick, list, perm);
                pick[i]=false;
                perm.remove(perm.size()-1);
            }
        }
    }
}
