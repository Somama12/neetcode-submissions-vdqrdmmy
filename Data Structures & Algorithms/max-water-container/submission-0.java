class Solution {
    public int maxArea(int[] heights) {
        int maxArea=0;
        int left=0;
        int right=heights.length-1;
        while(left<right){
            if(heights[left]<heights[right]){
                maxArea=Math.max(maxArea,(right-left)*heights[left]);
                left++;
            }else{
                maxArea=Math.max(maxArea,(right-left)*heights[right]);
                right--;
            }
        }
        return maxArea;
    }
}
