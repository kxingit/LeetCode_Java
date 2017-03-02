/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 5:39 - 5:41
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
            }
        }
        int res = 0;
        for(int i = 0; i < k; i++) {
            res = pq.poll();
        }
        return res;
    }
}

// v2
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 6:17 - 6:21
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(pq.size() < k) {
                    pq.add(matrix[i][j]);
                    continue;
                } 
                if(matrix[i][j] > pq.peek()) continue;
                pq.add(matrix[i][j]);
                pq.poll();
            }
        }
        return pq.peek();
    }
}
