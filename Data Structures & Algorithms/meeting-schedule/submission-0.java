/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()==0) return true;
        if(intervals.size()==1) return true;
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));
        Interval current=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            int prevLast=current.end;
            int curFirst=intervals.get(i).start;
            if(prevLast>curFirst){
                return false;
            }
            current=intervals.get(i);
        }
        return true;
    }
}
