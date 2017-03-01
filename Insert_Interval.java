/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList();
        intervals.add(newInterval);
        intervals.sort((a, b) -> a.start - b.start);
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            Interval curr = result.get(result.size() - 1);
            if(next.start > curr.end) {
                result.add(next);
            } else { // merge
                result.remove(result.size() - 1);
                Interval ni = new Interval(curr.start, Math.max(next.end, curr.end));
                result.add(ni);
            }
        }
        return result;
    }
}
