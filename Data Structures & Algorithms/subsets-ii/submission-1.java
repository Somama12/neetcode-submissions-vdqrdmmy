class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        backtrack(0,nums, list, subset);
        return list;
    }
    public void backtrack(int i, int[] nums, List<List<Integer>> list, List<Integer> subset ){
        if(i>=nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
       
        subset.add(nums[i]);
        backtrack(i+1, nums, list,subset);
        subset.remove(subset.size()-1);
         while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
         backtrack(i+1, nums, list,subset);
        

    }
}
