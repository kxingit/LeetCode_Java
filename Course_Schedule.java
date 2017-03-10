/*
   There are a total of n courses you have to take, labeled from 0 to n - 1.

   Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

   Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

   For example:

   2, [[1,0]]
   There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

   2, [[1,0],[0,1]]
   There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
   */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 10:12 - 10:27
        int n = numCourses;
        int[] indegree = new int[n];
        List[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = edges[node];
            for(int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}

// v2
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 10:29 - 10:36
        int n = numCourses;
        int[] indegree = new int[n];
        List[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList();
        }
        
        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            List<Integer> nextlist = edges[node];
            for(int i = 0; i < nextlist.size(); i++) {
                indegree[nextlist.get(i)]--;
                if(indegree[nextlist.get(i)] == 0) {
                    q.add(nextlist.get(i));
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

// v3
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 10:23 - 10:32
        int n = numCourses;
        int[] indegree = new int[n];
        List[] edges = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        while(q.size() > 0) {
            int curr = q.poll();
            count++;
            List<Integer> nexts = edges[curr];
            for(Integer next : nexts) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        return count == n;
    }
}
