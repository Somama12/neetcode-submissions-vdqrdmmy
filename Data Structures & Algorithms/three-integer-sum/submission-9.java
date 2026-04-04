class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        List<Integer> triplet=Arrays.asList(nums[i],nums[j],nums[k]);
                        set.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
