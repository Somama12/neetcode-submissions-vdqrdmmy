class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int left=0;
        int right=height.length-1;
        int leftMax=height[left];
        int rightMax=height[right];
        int ans=0;
        while(left<right){
            if(height[left]<height[right]){
                left++;
                leftMax=Math.max(leftMax, height[left]);
                int dif=Math.min(leftMax, rightMax) - height[left];
                if(dif>=0){
                    ans+=dif;
                }
            }else{
                right--;
                rightMax=Math.max(rightMax, height[right]);
                int dif=Math.min(rightMax, leftMax) -  height[right];
                if(dif>=0){
                    ans+=dif;
                }
            }
        }
        return ans;
    }
}
