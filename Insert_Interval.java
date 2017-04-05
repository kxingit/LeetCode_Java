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

// v2
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 11:10 - 11:16
        int n = intervals.size();
        for(int i = 0; i < n; i++) {
            if(intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if(intervals.size() == n) intervals.add(newInterval);
        List<Interval> res = new ArrayList();
        res.add(intervals.get(0));
        for(int i = 0; i < intervals.size(); i++) {
            Interval curr = res.get(res.size() - 1);
            Interval next = intervals.get(i);
            if(next.start > curr.end) {
                res.add(next);
            } else {
                Interval merged = new Interval(curr.start, Math.max(curr.end, next.end));
                res.remove(res.size() - 1);
                res.add(merged);
            }
        }
        return res;
    }
}

// v3
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 8:57 - 9:04
        int n = intervals.size();
        for(int i = 0; i < n; i++) {
            if(intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if(intervals.size() == n) intervals.add(newInterval);
        
        List<Interval> res = new ArrayList();
        res.add(intervals.get(0));
        for(int i = 0; i < intervals.size(); i++) {
            Interval curr = res.get(res.size() - 1);
            Interval next = intervals.get(i);
            if(curr.end < next.start) {
                res.add(next);
            } else { // need merge
                Interval merged = new Interval(curr.start, Math.max(curr.end, next.end));
                res.remove(res.size() - 1);
                res.add(merged);
            }
        }
        return res;
    }
}

// v4
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 12:44 - 12:48 - 1:02 bug: size changes
        int n = intervals.size();
        
        boolean inserted = false;
        for(int i = 0; i < n; i++) {
            Interval in = intervals.get(i);
            if(in.start >= newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }
        if(!inserted) intervals.add(newInterval); // !!
        
        List<Interval> res = new ArrayList();
        res.add(intervals.get(0));
        for(int i = 1; i < n + 1; i++) { // !!! 'n + 1' not n
            Interval curr = res.get(res.size() - 1);
            Interval next = intervals.get(i);
                System.out.print(curr.end + " " + next.start);
            if(curr.end < next.start) {
                res.add(next);
            } else {
                res.remove(res.size() - 1);
                res.add(new Interval(curr.start, Math.max(curr.end, next.end)));
            }
        }
        
        return res;
    }
}
