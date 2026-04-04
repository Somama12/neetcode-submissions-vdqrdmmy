class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int target=-(nums[i]);
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    List<Integer> inner=Arrays.asList(nums[i],nums[left],nums[right]);
                    set.add(inner);
                    left++;
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
