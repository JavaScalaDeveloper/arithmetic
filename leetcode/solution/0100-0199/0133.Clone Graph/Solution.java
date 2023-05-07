package solution._0133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class Solution {
    private Map<Node, Node> cache;
    public Node cloneGraph(Node node) {
        cache = new HashMap<>(16);
        return helper(node);
    }
    private Node helper(Node node) {
        if (node == null) return null;
        else if (cache.containsKey(node)) return cache.get(node);
        Node nodeCopy = new Node(node.val,new ArrayList<>());
        cache.put(node, nodeCopy);
        for (Node neighbor : node.neighbors) nodeCopy.neighbors.add(helper(neighbor));
        return nodeCopy;
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}