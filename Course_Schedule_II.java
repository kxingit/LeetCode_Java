/*
   There are a total of n courses you have to take, labeled from 0 to n - 1.

   Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

   Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

   There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
   */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 10:40 - 10:47
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
        
        int count = 0;
        int[] res = new int[n];
        while(!q.isEmpty()) {
            int node = q.poll();
            res[count] = node;
            count++;
            List<Integer> nextlist = edges[node];
            for(Integer next : nextlist) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if(count < n) return new int[0]; // empty array
        else return res;
    }
}
