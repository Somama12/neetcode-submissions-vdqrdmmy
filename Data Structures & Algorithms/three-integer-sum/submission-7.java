class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int target=nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[start]+nums[end];
                if(sum==(-target)){
                    List<Integer> inner=new ArrayList<>();
                    inner.add(nums[i]);
                    inner.add(nums[start]);
                    inner.add(nums[end]);
                    list.add(inner);
                    while(start<end && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }else if(sum<(-target)){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return list;
    }
}
