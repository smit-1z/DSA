/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);

        while (!q.isEmpty()) {
            Node currNode = q.poll();

            if (!map.containsKey(currNode)) {
                map.put(currNode, new Node(currNode.val));
            }

            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    q.offer(neighbor);
                }
            }
        }

        for (Node n : map.keySet()) {
            Node newNode = map.get(n);
            for (Node nei : n.neighbors) {
                newNode.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}