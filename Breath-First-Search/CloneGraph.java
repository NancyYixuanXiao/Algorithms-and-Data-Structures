/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        List<UndirectedGraphNode> nodes = getNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            if (!map.containsKey(n)) {
                map.put(n, new UndirectedGraphNode(n.label));
            }
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        List<UndirectedGraphNode> res = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            res.add(curr);
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (set.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return res;
    }
}
