package solution._0590;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import java.util.*;

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(0, node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }

    private class Node {
        int val;
        private List<Node> children;
    }
}
