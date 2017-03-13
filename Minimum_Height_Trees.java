/*
 * Total Accepted: 28823
 * Total Submissions: 100785
 * Difficulty: Medium
 * Contributors: Admin
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 11:19 - 11:52
        if(n <= 1) {
            List<Integer> res = new ArrayList();
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }
        
        HashMap<Integer, Set<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q1 = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                q1.add(i);
            }
        }
        
        while(n > 2) { // note this is not q.size()
            Queue<Integer> q2 = new LinkedList();
            while(q1.size() > 0) {
                int node = q1.poll();
                n--;
                System.out.print(node);
                Set<Integer> neighbors = graph.get(node);
                for(Integer neighbor : neighbors) {
                    graph.get(neighbor).remove(node);
                    graph.get(node).remove(neighbor); 
                    if(graph.get(neighbor).size() == 1) {
                        q2.add(neighbor);
                    }
                }
            }
            q1 = q2;
        }
        
        return new ArrayList(q1);
    }
}

// v2
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 11:54 - 12:12
        List<Integer> res = new ArrayList();
        
        if(n <= 1) {
            for(int i = 0; i < 1; i++) res.add(i);
            return res;
        }
        
        HashMap<Integer, Set<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet());
        }
        
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                res.add(i);
            }
        }
        
        while(n > 2) {
            n = n - res.size();
            List<Integer> newleaves = new ArrayList();
            for(Integer leaf : res) {
                Set<Integer> neighbors = graph.get(leaf);
                for(Integer neighbor : neighbors) {
                    graph.get(neighbor).remove(leaf);
                    // graph.get(leaf).remove(neighbor);
                    if(graph.get(neighbor).size() == 1) {
                        newleaves.add(neighbor);
                    }
                }
            }
            res = newleaves;
        }
        
        return res;
    }
}

// v3
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1:11 - 1:20
        List<Integer> res = new ArrayList();
        if(n <= 1) {
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }
        
        HashMap<Integer, Set<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        
        List<Integer> leaves = new ArrayList();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while(n > 2) {
            n = n - leaves.size();
            List<Integer> newleaves = new ArrayList();
            for(Integer leaf : leaves) {
                Set<Integer> neighbors = graph.get(leaf);
                for(Integer neighbor : neighbors) {
                    graph.get(neighbor).remove(leaf);
                    if(graph.get(neighbor).size() == 1) {
                        newleaves.add(neighbor);
                    }
                }
            }
            leaves = newleaves;
        }
        
        return leaves;
    }
}


// v3
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1:21 - 1:26
        List<Integer> leaves = new ArrayList();
        if(n <= 2) {
            for(int i = 0; i < n; i++) {
                leaves.add(i);
            }
            return leaves;
        }
        
        HashMap<Integer, Set<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while(n > 2) {
            n = n - leaves.size();
            List<Integer> newleaves = new ArrayList();
            for(Integer leaf : leaves) {
                Set<Integer> neighbors = graph.get(leaf);
                for(Integer neighbor : neighbors) {
                    graph.get(neighbor).remove(leaf);
                    if(graph.get(neighbor).size() == 1) {
                        newleaves.add(neighbor);
                    }
                }
            }
            leaves = newleaves;
        }
        
        return leaves;
    }
}
