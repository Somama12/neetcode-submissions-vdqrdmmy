class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxArea=0;
        while(left<right){
            int currentArea=0;
            if(heights[left]<heights[right]){
                currentArea=heights[left]*(right-left);
                left++;
            }else{
                currentArea=heights[right]*(right-left);
                right--;
            }
            maxArea=Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
