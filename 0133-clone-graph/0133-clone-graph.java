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
        if(node == null) return node;

        HashMap<Node,Node> nodeMapping = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){
            Node cur = queue.remove();

            if(!nodeMapping.containsKey(cur)){
                Node newNode = new Node(cur.val);
                nodeMapping.put(cur,newNode);
            }

            for(Node neighbor : cur.neighbors){
                if(!nodeMapping.containsKey(neighbor)){
                    queue.add(neighbor);
                }
            }
        }

        for(Node cur: nodeMapping.keySet()){
            Node newNode = nodeMapping.get(cur);
            for(Node neighbor : cur.neighbors){
                newNode.neighbors.add(nodeMapping.get(neighbor));
            }
        }

        return nodeMapping.get(node);
    }
}