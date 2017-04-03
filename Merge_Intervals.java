/*
Given a collection of intervals, merge all overlapping intervals.
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // 4:13 - 4:15 - 4:20 
        List<Interval> res = new ArrayList();
        intervals.sort((a, b) -> a.start - b.start); // not Arrays.sort()!
        for(int i = 0; i < intervals.size(); i++) {
            if(res.size() == 0) {
                res.add(intervals.get(i));
            } else {
                Interval curr = res.get(res.size() - 1);
                if(curr.end < intervals.get(i).start) {
                    res.add(intervals.get(i));
                } else {
                    res.remove(res.size() - 1);
                    Interval ni = new Interval(curr.start, Math.max(curr.end, intervals.get(i).end));
                    res.add(ni);
                }
            }
        }
        return res;
    }
}
