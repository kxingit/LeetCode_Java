/*
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class Solution {
    public int thirdMax(int[] nums) {
        // 4:25 - 4:40
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(Integer num : nums) {
            pq.offer(num);
        }
        int max = pq.peek(), res = pq.peek() - 1;
        int count = 0;
        while(count < 3 && pq.size() > 0) {
            if(res != pq.peek()) {
                count++;
            }
            res = pq.peek();
            pq.poll();
        }
        if(count < 3) return max;
        return res;
    }
}

// v2
public class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int)first : (int)third;
    }
}
