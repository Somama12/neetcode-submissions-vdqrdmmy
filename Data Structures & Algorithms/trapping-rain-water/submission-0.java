class Solution {
    public int trap(int[] height) {
        int size=height.length;
        int[] maxLeft=new int[size];
        int[] maxRight=new int[size];

        for(int i=0;i<height.length;i++){
            maxLeft[i]=findMaxLeft(height,i);
            maxRight[i]=findMaxRight(height,i);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            ans+=Math.min(maxLeft[i], maxRight[i])-height[i]>0?Math.min(maxLeft[i], maxRight[i])-height[i]:0;
        }
        return ans;
    }
    static int findMaxLeft(int[] arr, int index){
        int max=0;
        for(int i=0;i<index;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    static int findMaxRight(int[] arr, int index){
        int max=0;
        for(int i=arr.length-1;i>index;i--){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}
