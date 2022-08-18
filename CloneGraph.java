/*
 * 133. Clone Graph
 */

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
    HashMap<Integer, Node> m = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        return bfs(node);
    }
    
    public Node bfs(Node org) {
        if(m.containsKey(org.val))
            return m.get(org.val);
        else {
            Node copy = new Node(org.val);
            m.put(org.val, copy);
            for(int i = 0; i < org.neighbors.size(); i++) {
                copy.neighbors.add(bfs(org.neighbors.get(i)));
            }
            
            return copy;
        }
    }
}