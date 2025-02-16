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

import java.util.*;

class Solution {

    Map<Integer, Node> map = new HashMap<>();


    public Node cloneGraph(Node node) {
        return deepCopy(node);
    }

    private Node deepCopy(Node node) {
        if(node == null) return null;

        if(!map.containsKey(node.val)) {
            Node n = new Node(node.val);
            map.put(n.val, n);
        }
        
        Node copy = map.get(node.val);

        for(var next : node.neighbors) {
            // exist in the map
            if(map.containsKey(next.val)) {
                copy.neighbors.add(map.get(next.val));
            } else {
                Node nextCopy = deepCopy(next);
                copy.neighbors.add(nextCopy);
            }
            
        }

        return copy;
    }


}