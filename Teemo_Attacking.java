/*
 * In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if(n == 0) return 0;
        int start = timeSeries[0], curr = 0, res = 0;
        for(int i = 1; i < n; i++) {
            if(timeSeries[i] - timeSeries[i - 1] <= duration) {
                res += timeSeries[i] - timeSeries[i - 1];
            } else {
                res += duration;
            }
            start = timeSeries[i];
        }
        return res + duration;
    }
}
