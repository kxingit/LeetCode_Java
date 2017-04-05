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

// v2
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 11:15 - 11:16
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num : nums) {
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

// v3
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 11:27 - 11:28
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
