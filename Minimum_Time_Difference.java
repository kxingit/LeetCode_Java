/*
   Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
   */
// Weekly contest
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (a, b) -> {
           return a.compareTo(b); 
        });
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size(); i++) {
            if(i == timePoints.size() - 1) {
                res = Math.min(res, findDiff(timePoints.get(i), timePoints.get(0)));
            } else {
                res = Math.min(res, findDiff(timePoints.get(i), timePoints.get(i + 1)));
            }
        }
        return res;
    }
    public int findDiff(String timePoint1, String timePoint2) {
        String[] time1 = timePoint1.split(":");
        String[] time2 = timePoint2.split(":");
        int time1h = Integer.parseInt(time1[0]);
        int time2h = Integer.parseInt(time2[0]);
        int diffh = time1h - time2h;
        int time1m = Integer.parseInt(time1[1]);
        int time2m = Integer.parseInt(time2[1]);
        int diffm = time1m - time2m;
        
        int diffmin = Math.abs(diffm + 60 * diffh);
        
        return Math.min(diffmin, 24 * 60 - diffmin);
    }
}
