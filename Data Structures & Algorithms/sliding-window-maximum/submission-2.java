class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int l=0;
        for(int r=k-1;r<nums.length;r++){
            int max=findMax(l,r,nums);
            list.add(max);
            l++;
        }
       int[] arr = new int[list.size()];
for (int i = 0; i < list.size(); i++) {
    arr[i] = list.get(i);
}
return arr;
    }
    public int findMax(int l, int r, int[] nums){
        int max=nums[l];
        for(int i=l;i<=r;i++){
            max=Math.max(max, nums[i]);
        }
        return max;
    }
}
