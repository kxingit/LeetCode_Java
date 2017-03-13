/*
   Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
   */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        // 7:52 - 7:58
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        
        int res = 0;
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i + 1].start) {
                res++;
                intervals[i + 1].end = Math.min(intervals[i].end, intervals[i + 1].end); // delete large end, i.e. keep smaller end
            }
        }
        return res;
    }
}
