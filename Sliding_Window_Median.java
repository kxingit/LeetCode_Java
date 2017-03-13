/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 2:12 - 3:09
        int n = nums.length;
        double[] res = new double[n - k + 1];
         
        PriorityQueue<Double> pq1 = new PriorityQueue(k, Collections.reverseOrder());
        PriorityQueue<Double> pq2 = new PriorityQueue(k);
         
        for(int i = 0; i < k; i++) {
            pq1.offer((double)nums[i]);
        }
         
        for(int i = 0; i < k / 2; i++) {
            pq2.add(pq1.poll());
        }
 
        for(int i = k - 1; i < n; i++) {
 
            if(i == k - 1) {
                res[0] = pq1.size() > pq2.size() ? pq1.peek() : (pq1.peek() / 2 + pq2.peek() / 2);
                continue;
            }
            double toRemove = (double)nums[i - k];
            double toAdd = (double)nums[i];
             
            if(toRemove <= pq1.peek()) {
                pq1.remove(toRemove);
                if(pq1.size() < pq2.size()) {
                    pq1.add(pq2.poll());
                }
            } else {
                pq2.remove(toRemove);
                if(pq2.size() < pq1.size() - 1) {
                    pq2.add(pq1.poll());
                }
            }
             
            pq1.offer(toAdd);
            pq2.offer(pq1.poll()); // to add to pq2: 1) add to pq1. 2) poll to pq2.
            if(pq2.size() > pq1.size()) {
                pq1.offer(pq2.poll());
            }
 
            res[i - k + 1] = pq1.size() > pq2.size() ? pq1.peek() : (pq1.peek() / 2 + pq2.peek() / 2);
        }
         
        return res;
    }
}

// v2
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 3:20 - 3:28
        int n = nums.length;
        double[] res = new double[n - k + 1];
        
        PriorityQueue<Double> pq1 = new PriorityQueue(k, Collections.reverseOrder());
        PriorityQueue<Double> pq2 = new PriorityQueue(k);
        
        for(int i = 0; i < k; i++) {
            pq2.offer((double)nums[i]);
        }
        
        while(pq2.size() > pq1.size()) {
            pq1.offer(pq2.poll());
        }
        
        for(int i = k - 1; i < n; i++) {
            if(i == k - 1) {
                res[0] = pq1.size() != pq2.size() ? pq1.peek() : pq1.peek() / 2 + pq2.peek() / 2;
                continue;
            }
            
            double toRemove = (double)nums[i - k];
            double toAdd = (double)nums[i];
            
            if(toRemove <= pq1.peek()) {
                pq1.remove(toRemove);
            } else {
                pq2.remove(toRemove);
            }
            
            if(pq1.size() < pq2.size()) {
                pq1.offer(pq2.poll());
            }
            if(pq1.size() > pq2.size() + 1) {
                pq2.offer(pq1.poll());
            }
            
            pq1.add(toAdd);
            pq2.offer(pq1.poll());
            if(pq2.size() > pq1.size()) {
                pq1.offer(pq2.poll());
            }
            
            res[i - k + 1] = pq1.size() != pq2.size() ? pq1.peek() : pq1.peek() / 2 + pq2.peek() / 2;
        }
        
        return res;
    }
}

// v3
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 3:31 - 3:40
        int n = nums.length;
        int m = n - k + 1;
        double[] res = new double[m];
        
        PriorityQueue<Double> pq1 = new PriorityQueue(k, Collections.reverseOrder());
        PriorityQueue<Double> pq2 = new PriorityQueue(k);
        
        for(int i = 0; i < n; i++) {
            pq1.offer((double)nums[i]);
            pq2.offer(pq1.poll());
            if(pq2.size() > pq1.size()) {
                pq1.offer(pq2.poll());
            }
            
            if(i >= k - 1) {
                res[i - k + 1] = pq1.size() == pq2.size() ? pq1.peek() / 2 + pq2.peek() / 2 : pq1.peek();
            
                double toRemove = (double)nums[i - k + 1];
                if(toRemove <= pq1.peek()) {
                    pq1.remove(toRemove);
                } else {
                    pq2.remove(toRemove);
                }
                
                if(pq1.size() < pq2.size()) {
                    pq1.offer(pq2.poll());
                } 
                if(pq1.size() > pq2.size() + 1) {
                    pq2.offer(pq1.poll());
                }
            }
            
        }
        return res;
    }
}

// v4
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 11:58 - 12:04
        int n = nums.length;
        int m = n - k  + 1;
        double[] res = new double[m];
        
        PriorityQueue<Double> maxheap = new PriorityQueue(k, Collections.reverseOrder());
        PriorityQueue<Double> minheap = new PriorityQueue(k);
        
        for(int i = 0; i < n; i++) {
            maxheap.add((double)nums[i]);
            minheap.add(maxheap.poll());
            if(minheap.size() > maxheap.size()) {
                maxheap.add(minheap.poll());
            }
            
            if(i >= k - 1) {
                res[i - k + 1] = maxheap.size() == minheap.size() ? maxheap.peek() / 2 + minheap.peek() / 2 : maxheap.peek();
                double toRemove = (double)nums[i - k + 1];
                if(toRemove <= maxheap.peek()) {
                    maxheap.remove(toRemove);
                } else {
                    minheap.remove(toRemove);
                }
                
                if(maxheap.size() < minheap.size()) {
                    maxheap.add(minheap.poll());
                }
                if(maxheap.size() > minheap.size() + 1) {
                    minheap.add(maxheap.poll());
                }
            }
        }
        return res;
    }
}
