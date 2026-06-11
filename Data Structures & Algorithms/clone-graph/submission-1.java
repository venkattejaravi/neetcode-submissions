/*
Definition for a Node.
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
    Map<Node, Node> visited = new HashMap<>();
    Deque<Node> q = new ArrayDeque<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        q.offer(node);
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        

        while(! q.isEmpty()) {
            Node n = q.poll();
            if(n.neighbors.size() > 0) {
                for(Node neighbor : n.neighbors) {
                    if(visited.containsKey(neighbor)) {
                        visited.get(n).neighbors.add(visited.get(neighbor));
                    } else {
                        q.offer(neighbor);
                        Node neighborClone = new Node(neighbor.val);
                        visited.get(n).neighbors.add(neighborClone);
                        visited.put(neighbor, neighborClone);
                    }
                }
            }
        }

        return cloneNode;
        

    }
}