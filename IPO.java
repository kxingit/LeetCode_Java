/*
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 */
public class Solution {
    int n;
    int res;
    
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 10:01 - 10:11
        n = Capital.length;
        boolean[] visited = new boolean[n];
        dfs(k, W, Profits, Capital, visited);
        return res;
    }
    
    public void dfs(int k, int W, int[] P, int[] C, boolean[] visited) {
        if(k >= 0) {
            res = Math.max(res, W);
        }
        if(k < 0) return;
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(C[i] > W) continue;
            visited[i] = true;
            dfs(k - 1, W + P[i], P, C, visited);
            visited[i] = false;
        }
    }
}

// v2
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // Greedy: do the project with most profit first
        // 10:31 -10:55
        
        int n = Profits.length;
        Point[] projects = new Point[n];
        
        for(int i = 0; i < n; i++) {
            projects[i] = new Point(Profits[i], Capital[i]);
        }
        
        Arrays.sort(projects, (a, b) -> a.y - b.y);
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int pos = 0;
        while(pos < n && W >= projects[pos].y) {
            pq.add(projects[pos].x);
            pos++;
        }
        
        for(int i = 0; i < k; i++) {
            if(pq.size() == 0) break;
            W += pq.poll();
            while(pos < n && W >= projects[pos].y) {
                pq.add(projects[pos].x);
                pos++;
            }
        }
        
        return W;
    }
}

// v3
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // Greedy: do the project with most profit first
        // 10:31 -10:55 - 10:56
        
        int n = Profits.length;
        Point[] projects = new Point[n];
        
        for(int i = 0; i < n; i++) {
            projects[i] = new Point(Profits[i], Capital[i]);
        }
        
        Arrays.sort(projects, (a, b) -> a.y - b.y);
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int pos = 0;
 
        for(int i = 0; i < k; i++) {
            while(pos < n && W >= projects[pos].y) {
                pq.add(projects[pos].x);
                pos++;
            }
            if(pq.size() == 0) break;
            W += pq.poll();
        }
        
        return W;
    }
}


// v4
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 10:57 - 11:04
        int n = Profits.length;
        Point[] projects = new Point[n];
        
        for(int i = 0; i < n; i++) {
            projects[i] = new Point(Profits[i], Capital[i]);
        }
        
        Arrays.sort(projects, (a, b) -> a.y - b.y);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int pos = 0;
        for(int times = 0; times < Math.min(n, k); times++) {
            while(pos < n && projects[pos].y <= W) {
                pq.add(projects[pos].x);
                pos++;
            }
            if(pq.size() == 0) break;
            W += pq.poll();
        }
        
        return W;
    }
}


// v5
public class Solution {
    // 11:11 - 11:18
    class Project {
        int profit, capital;
        Project(int p, int c) {
            profit = p;
            capital = c;
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        Project[] projects = new Project[n];
        for(int i = 0; i < n; i++) {
            projects[i] = new Project(Profits[i], Capital[i]);
        }
        
        Arrays.sort(projects, (a ,b) -> a.capital - b.capital);
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        int pos = 0;
        for(int i = 0; i < k && i < n; i++) {
            while(pos < n && W >= projects[pos].capital) {
                pq.add(projects[pos].profit);
                pos++;
            }
            if(pq.size() == 0) break;
            W += pq.poll();
        }
        
        return W;
    }
}
