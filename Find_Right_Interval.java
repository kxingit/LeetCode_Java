/*
   Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

   For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
   */
// TLE: 15 / 17 test cases passed.
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        // 8:03 - 8:16
        int n = intervals.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int nextindex = -1;
            int nextstart = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(intervals[j].start >= intervals[i].end) {
                    if(intervals[j].start < nextstart) {
                        nextstart = intervals[j].start;
                        nextindex = j;
                    }
                }
            }
            res[i] = nextindex;
        }
        return res;
    }
}

// v2
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        // 8:03 - 8:18 - 8:26
        int n = intervals.length;
        int[] res = new int[n];
        HashMap<Interval, Integer> map = new HashMap();
        for(int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        
        Interval[] original_intervals = new Interval[n];
        for(int i = 0; i < n; i++) original_intervals[i] = intervals[i];
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        HashMap<Interval, Integer> map_res = new HashMap();
        for(int i = 0; i < n; i++) {
            int nextindex = -1;
            for(int j = i + 1; j < n; j++) {
                if(intervals[j].start >= intervals[i].end) {
                    nextindex = map.get(intervals[j]);
                    break;
                }
            }
            map_res.put(intervals[i], nextindex);
        }
        
        for(int i = 0; i < n; i++) {
            res[i] = map_res.get(original_intervals[i]);
        }
        
        return res;
    }
}

// v3
public class Solution {
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    public int[] findRightInterval(Interval[] intervals) {
        // 8:03 - 8:18 - 8:26 - 8:29
        int n = intervals.length;
        int[] res = new int[n];
        HashMap<Interval, Integer> map = new HashMap();
        for(int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        
        Interval[] original_intervals = new Interval[n];
        for(int i = 0; i < n; i++) original_intervals[i] = intervals[i];
        
        Arrays.sort(intervals, new IntervalComparator());
        HashMap<Interval, Integer> map_res = new HashMap();
        for(int i = 0; i < n; i++) {
            int nextindex = -1;
            for(int j = i + 1; j < n; j++) {
                if(intervals[j].start >= intervals[i].end) {
                    nextindex = map.get(intervals[j]);
                    break;
                }
            }
            map_res.put(intervals[i], nextindex);
        }
        
        for(int i = 0; i < n; i++) {
            res[i] = map_res.get(original_intervals[i]);
        }
        
        return res;
    }
}
