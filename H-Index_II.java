/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class Solution {
    public int hIndex(int[] citations) {
        // 4:21 - 4:34
        int n = citations.length;
        if(n == 0) return 0;
        int start = 0, end = n - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] < n - mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (citations[start] >= n - start) { // 'start' represents the larger one, check first
            return n - start;
        } else if(citations[end] >= n - end) {
            return n - end;
        } else {
            return 0;
        }
    }
}
