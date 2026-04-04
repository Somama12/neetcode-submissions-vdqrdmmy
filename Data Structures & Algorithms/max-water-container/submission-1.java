class Solution {
    public int maxArea(int[] heights) {
        int maxWater=0;
        int left=0;
        int right=heights.length-1;
        while(left<right){
            int currentWater=0;
            if(heights[left]<heights[right]){
                currentWater=heights[left]*(right-left);
                left++;
            }else{
               currentWater=heights[right]*(right-left);
               right--; 
            }
            maxWater=Math.max(maxWater, currentWater);
            
        }
        return maxWater;
    }
}
