/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 9:09 - 9:25
        int n = nums.length;
        if(k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList();
        for(int i = 0; i < k; i++) {
            while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        int[] res = new int[n - k + 1];
        
        for(int i = 0; i < n - k + 1; i++) {
            res[i] = nums[deque.peekFirst()];
            if(nums[deque.peekFirst()] == nums[i]) {
                deque.pollFirst();
            }
            int j = i + k;
            if(j >= n) break;
            while(deque.size() > 0 && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(j);
        }
        
        return res;
    }
}
