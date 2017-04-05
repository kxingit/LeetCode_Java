/*
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 2:14 - 2:33
        List<int[]> edges = new ArrayList();
        List<int[]> res = new ArrayList();
        for(int[] b : buildings) {
            edges.add(new int[]{b[0], -b[2]});
            edges.add(new int[]{b[1], b[2]});
        }
        
        edges.sort((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(100, (a, b) -> b - a);
        
        pq.offer(0);
        int prev = 0;
        for(int[] h : edges) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != curr) {
                res.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 3:24 - 3:30 - 3:36
        List<int[]> edges = new ArrayList();
        for(int[] b : buildings) {
            edges.add(new int[]{b[0], -b[2]});
            edges.add(new int[]{b[1], b[2]});
        }
        edges.sort((a, b) -> {
           if(a[0] != b[0]) {
               return a[0] - b[0];
           } else {
               return a[1] - b[1];
           }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        List<int[]> res = new ArrayList();
        int prevh = 0;
        pq.add(0); // !!!
        for(int[] edge : edges) {
            int h = edge[1];
            if(h < 0) {
                pq.add(-h);
            } else {
                pq.remove(h);
            }
            
            h = pq.peek();
            if(h != prevh) {
                res.add(new int[]{edge[0], h});
                prevh = h;
            }
        }
        
        return res;
    }
}

// v3
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 3:37 - 3:43 bug - 3:44
        List<int[]> edges = new ArrayList();
        for(int[] b : buildings) {
            edges.add(new int[]{b[0], b[2]});
            edges.add(new int[]{b[1], -b[2]});
        }
        
        edges.sort((a, b) -> {
           if(a[0] != b[0]) {
               return a[0] - b[0];
           } else {
               return b[1] - a[1]; // make sure add first
           }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        pq.add(0);
        int prevh = 0;
        
        List<int[]> res = new ArrayList();
        
        for(int[] edge : edges) {
            int x = edge[0], h = edge[1];
            if(h > 0) {
                pq.add(h);
            } else {
                pq.remove(-h);
            }
            
            h = pq.peek(); // peek() not poll()
            if(h != prevh) {
                res.add(new int[]{x, h});
                prevh = h;
            }
        }
        
        return res;
    }
}

// v4
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // 10:06 - 10:11
        List<int[]> edges = new ArrayList();
        for(int[] b : buildings) {
            edges.add(new int[]{b[0], b[2]});
            edges.add(new int[]{b[1], -b[2]});
        }
        
        edges.sort((a, b) -> {
           if(a[0] != b[0]) {
               return a[0] - b[0];
           } else {
               return b[1] - a[1];
           }
        });
        
        List<int[]> res = new ArrayList();
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        pq.add(0);
        int prevh = 0;
        
        for(int[] e : edges) {
            int h = e[1];
            if(h > 0) {
                pq.add(h);
            } else {
                pq.remove(-h);
            }
            
            h = pq.peek();
            if(prevh != h) {
                res.add(new int[]{e[0], h});
                prevh = h;
            }
        }
        
        return res;
    }
}
