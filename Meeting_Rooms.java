/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
*/
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // 3:16 - 3:18
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}

// v2
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // 10:13 - 10;17
        Arrays.sort(intervals, (a, b) -> a.start - b.start); // "Arrays.sort()", not "sort(list)"
        
        if(intervals.length <= 1) return true;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        
        return true;
    }
}
