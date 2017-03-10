/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // 10:04 - 10:17 - 10:23
        if(node == null) return null;
        
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        for(UndirectedGraphNode nd : nodes) {
            map.put(nd, new UndirectedGraphNode(nd.label));
        }
        
        for(UndirectedGraphNode n : nodes) {
            for(UndirectedGraphNode neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
        
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> res = new ArrayList();
        Queue<UndirectedGraphNode> q = new LinkedList();
        HashSet<UndirectedGraphNode> set = new HashSet();
        q.add(node);
        set.add(node);
        while(q.size() > 0) {
            UndirectedGraphNode n = q.poll();
            res.add(n);
            for(UndirectedGraphNode neighbor : n.neighbors) {
                if(set.contains(neighbor)) continue;
                q.add(neighbor);
                set.add(neighbor);
            }
        }
        return res;
    }
}

// v2
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // 9:42 - 9:59
        // get nodes
        if(node == null) return null;
        List<UndirectedGraphNode> nodes = getNodes(node);
        int n = nodes.size();
        UndirectedGraphNode res = node;
         
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map_to_clone = new HashMap();
        for(int i = 0; i < n; i++) {
            map_to_clone.put(nodes.get(i), new UndirectedGraphNode(nodes.get(i).label));
        }
         
        for(int i = 0; i < n; i++) {
            node = nodes.get(i);
            List<UndirectedGraphNode> neighbors = node.neighbors;
            for(int ii = 0; ii < neighbors.size(); ii++) {
                map_to_clone.get(node).neighbors.add(map_to_clone.get(neighbors.get(ii)));
            }
        }
        return map_to_clone.get(res);
    }
     
    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        List<UndirectedGraphNode> res = new ArrayList();
        Queue<UndirectedGraphNode> q = new LinkedList();
        Set<UndirectedGraphNode> visited = new HashSet();
        q.add(node);
        visited.add(node);
        while(q.size() > 0) {
            node = q.poll();
            res.add(node);
            List<UndirectedGraphNode> neighbors = node.neighbors;
            for(UndirectedGraphNode neighbor : neighbors) {
                if(visited.contains(neighbor)) continue;
                q.add(neighbor);
                visited.add(neighbor);
            }
        }
        return res;
    }
}
