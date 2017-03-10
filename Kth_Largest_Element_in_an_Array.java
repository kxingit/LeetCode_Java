/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 4:41 - 4:42
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(Integer num : nums) {
            if(pq.size() < k) {
                pq.add(num);
            } else {
                if(num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();
    }
}
