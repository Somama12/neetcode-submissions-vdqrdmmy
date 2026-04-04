class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=heights.length-1;i>=0;i--){
            if(heights[i]>max){
                list.add(i);
            }
            max=Math.max(max, heights[i]);
        }
        int[] result=new int[list.size()];
        int k=list.size()-1;
        for(int num:list){
            result[k]=num;
            k--;
        }
        return result;
    }
}