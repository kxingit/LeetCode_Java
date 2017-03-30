/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
// BFS
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 9:45 - 9:48
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        q.add(0);
        visited.add(0);
        
        while(q.size() > 0) {
            int curr = q.poll();
            Set<Integer> neis = graph.get(curr);
            for(Integer nei : neis) {
                if(visited.contains(nei)) return false;
                visited.add(nei);
                q.add(nei);
                graph.get(nei).remove(curr);
            }
        }
        
        return visited.size() == n;
    }
}

// Union-Find
public class Solution {
    // 9:07
    class UnionFind {
        HashMap<Integer, Integer> map = new HashMap();
        UnionFind(int n) {
            for(int i = 0; i < n; i++) {
                map.put(i, i);
            }
        }
        
        public int find(int i) {
            int fa = map.get(i);
            while(fa != map.get(fa)) {
                fa = map.get(fa);
                map.put(i, fa);
            }
            return fa;
        }
        
        public void union(int x, int y) {
            int fax = find(x), fay = find(y);
            if(fax != fay) {
                map.put(fax, fay);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        // int count = 0;
        for(int[] edge : edges) {
            if(uf.find(edge[0]) != uf.find(edge[1])) {
                uf.union(edge[0], edge[1]);
                // count++;
            } else {
                return false;
            }
        }
        return edges.length == n - 1;
    }
}

// v3
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 10:38 - 10:41
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet());
        }
        
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        q.add(0);
        visited.add(0);
        
        while(q.size() > 0) {
            int curr = q.poll();
            Set<Integer> neis = graph.get(curr);
            for(Integer nei : neis) {
                if(visited.contains(nei)) return false;
                visited.add(nei);
                q.add(nei);
                graph.get(nei).remove(curr);
            }
        }
        
        return visited.size() == n;
    }
}

// v4
public class Solution {
    class UnionFind {
        HashMap<Integer, Integer> map = new HashMap();
        
        UnionFind(int n) {
            for(int i = 0; i < n; i++) {
                map.put(i, i);
            }
        }
        
        public int find(int x) {
            int fa = map.get(x);
            while(fa != map.get(fa)) {
                fa = map.get(fa);
                map.put(x, fa);
            }
            return fa;
        }
        
        public void union(int x, int y) {
            if(find(x) != find(y)) {
                map.put(find(x), find(y));
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // 10:42 - 10:47
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges) {
            if(uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        
        return edges.length == n - 1;
    }
}

// v5
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 8:41 - 8:46
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visited = new HashSet();
        q.add(0);
        visited.add(0);
        
        while(q.size() > 0) {
            int curr = q.poll();
            Set<Integer> neis = graph.get(curr);
            for(Integer nei : neis) {
                if(visited.contains(nei)) return false;
                q.add(nei);
                visited.add(nei);
                graph.get(nei).remove(curr);
            }
        }
        
        return visited.size() == n;
    }
}

// v6
public class Solution {
    // 8:49 - 8:54
    class UnionFind {
        HashMap<Integer, Integer> map = new HashMap();
        UnionFind(int n) {
            for(int i = 0; i < n; i++) {
                map.put(i, i);
            }
        }
        
        int find(int x) {
            int fa = map.get(x);
            while(fa != map.get(fa)) {
                fa = map.get(fa);
                map.put(x, fa);
            }
            return fa;
        }
        
        void union(int x, int y) {
            if(find(x) != find(y)) {
                map.put(find(x), find(y));
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            if(uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        return edges.length == n - 1;
    }
}
