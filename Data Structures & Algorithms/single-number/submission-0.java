class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
                continue;
            }else{
                set.add(num);
            }
        }
        int ans=-1;
       for(int s:set){
        ans=s;
       }
       return ans;
    }
}
