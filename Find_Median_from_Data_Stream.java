/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 */
class MedianFinder {
    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
 
    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
;}


// v2
public class MedianFinder {
    public PriorityQueue<Integer> minheap, maxheap;
 
    /** initialize your data structure here. */
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
     
    public void addNum(int num) {
        minheap.add(num);
        maxheap.add(minheap.poll());
        while (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
        while(maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        }
    }
     
    public double findMedian() {
        if(maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
}

// v3
public class MedianFinder {
 
    /** initialize your data structure here. */
    // 4:20 - 4:26
    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if(maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else {
            return (minheap.peek() + maxheap.peek()) * 0.5;
        }
    }
}


// v4
public class MedianFinder {
 
    /** initialize your data structure here. */
    // 4:35 - 4:38
    public PriorityQueue<Integer> maxheap, minheap;
    
    public MedianFinder() {
        maxheap = new PriorityQueue(Collections.reverseOrder());
        minheap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        }
    }
}


// v5
public class MedianFinder {
 
    /** initialize your data structure here. */
    // 9:27 - 9:32
    PriorityQueue<Integer> maxheap, minheap;
    public MedianFinder() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()) {
            return maxheap.peek();
        } else {
            return 0.5 * (maxheap.peek() + minheap.peek());
        }
    }
}


