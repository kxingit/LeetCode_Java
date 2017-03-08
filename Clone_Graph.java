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
