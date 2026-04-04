class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int[] current=intervals[0];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            int prevLast=current[1];
            int curFirst=intervals[i][0];
            if(prevLast>curFirst){
                ans++;
            }else{
                current=intervals[i];
            }
        }
        return ans;
    }
}