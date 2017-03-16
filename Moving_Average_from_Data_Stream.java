/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public class MovingAverage {
    // 6:23 - 6:26
    Queue<Integer> q;
    int size;
    int sum;
 
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        if(q.size() < size) {
            sum += val;
            q.add(val);
        } else {
            int toRemove = q.poll();
            int toAdd = val;
            q.add(toAdd);
            sum = sum + toAdd - toRemove;
        }
        return (double)sum / q.size();
    }
}
