/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 */
public class Solution {
    public class TimeType {
        int time, type;
        TimeType(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        // 4:46 - 4:50 - 5:02
        if(intervals.length == 0) return 0;
        List<TimeType> times = new ArrayList<TimeType>();
        for(Interval in : intervals) {
            times.add(new TimeType(in.start, 0)); 
            times.add(new TimeType(in.end, 1));
        }
        
        times.sort((a, b) -> a.time - b.time);
        
        int res = 0, cur = 0;
        for(int i = 0; i < times.size(); i++) {
            if(times.get(i).type != 0) {
                cur--;
            } else {
                cur++;
            }
            if(i + 1 < times.size() && times.get(i + 1).time == times.get(i).time) {
                continue;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}


// v2
public class Solution {
    public class TimeType {
        int time, type;
        TimeType(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        // 4:46 - 4:50 - 5:02 - 5:13
        if(intervals.length == 0) return 0;
        List<TimeType> times = new ArrayList<TimeType>();
        for(Interval in : intervals) {
            times.add(new TimeType(in.start, 0)); 
            times.add(new TimeType(in.end, 1));
        }
        
        times.sort((a, b) -> {
                if(a.time != b.time) {
                    return a.time - b.time;
                } else {
                    return b.type - a.type; // end time first
                }
            });
        
        int res = 0, cur = 0;
        for(int i = 0; i < times.size(); i++) {
            if(times.get(i).type != 0) {
                cur--;
            } else {
                cur++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}


// v3
public class Solution {
    class TimeType {
        int time;
        int type;
        TimeType(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        // 3:37 - 3:43
        List<TimeType> times = new ArrayList();
        for(Interval in : intervals) {
            times.add(new TimeType(in.start, 1));
            times.add(new TimeType(in.end, -1)); // end 
        }
        
        times.sort((a, b) -> {
            if(a.time == b.time) {
                return a.type - b.type;
            } else {
                return a.time - b.time;
            }
        });
        
        int curr = 0, res = 0;
        for(TimeType t : times) {
            curr += t.type;
            res = Math.max(res, curr);
        }
        
        return res;
    }
}
