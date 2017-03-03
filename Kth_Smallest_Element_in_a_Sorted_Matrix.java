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

// v3
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 10:00 - 10;04
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(pq.size() < k) {
                    pq.add(matrix[i][j]);
                    continue;
                }
                if(pq.peek() <= matrix[i][j]) {
                    continue;
                }
                pq.add(matrix[i][j]);
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// v4
public class Solution {
    class ResultType {
        public int num;
        public boolean exists;
        public ResultType(boolean e, int n) {
            exists = e;
            num = n;
        }
    }
    public ResultType check(int value, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean exists = false;
        int num = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (matrix[i][j] == value)
                exists = true;
                
            if (matrix[i][j] <= value) {
                num += i + 1;
                j += 1;
            } else {
                i -= 1;
            }
        }
        
        return new ResultType(exists, num);
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = matrix[0][0];
        int right = matrix[n - 1][m - 1];
        
        // left + 1 < right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            ResultType type = check(mid, matrix);
            if (type.exists && type.num == k) {
                return mid;
            } else if (type.num < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
