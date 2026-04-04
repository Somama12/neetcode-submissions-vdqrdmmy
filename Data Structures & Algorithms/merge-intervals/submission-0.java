class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]) );
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        for(int[] interval:intervals){
            int first=interval[0];
            int last=interval[1];
            int seenLast=res.get(res.size()-1)[1];
            if(first<=seenLast){
                res.get(res.size()-1)[1]=Math.max(seenLast, last);
            }else{
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
