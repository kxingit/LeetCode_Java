/*
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 */
public class SummaryRanges {
    // 5:32 - 5:57
    /** Initialize your data structure here. */
    List<Interval> list;
    public SummaryRanges() {
        list = new ArrayList();
    }
    
    public void addNum(int val) {
        list.add(new Interval(val, val));
        list.sort((a, b) -> (a.start - b.start));
        List<Interval> newlist = new ArrayList();
        newlist.add(list.get(0));
        for(int i = 1; i < list.size(); i++) {
            Interval curr = newlist.get(newlist.size() - 1);
            Interval next = list.get(i);
            if(next.start - 1 > curr.end) {
                newlist.add(next);
            } else {
                Interval newInterval = new Interval(curr.start, Math.max(next.end, curr.end));
                System.out.print(newInterval.start + "" + newInterval.end + " ");
                newlist.remove(newlist.size() - 1);
                newlist.add(newInterval);
            }
        }
        list = newlist;
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

// v2
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // 10:09 - 10:23
        int n = intervals.size();
        boolean isInserted = false;
        for(int i = 0; i < n; i++) {
            if(intervals.get(i).start > newInterval.start) {
                intervals.add(i, newInterval);
                isInserted = true;
                break;
            }
        }
        if(!isInserted) {
            intervals.add(newInterval);
        }
        List<Interval> res = new ArrayList();
        if(intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = res.get(res.size() - 1);
            Interval next = intervals.get(i);
            if(curr.end < next.start) {
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
