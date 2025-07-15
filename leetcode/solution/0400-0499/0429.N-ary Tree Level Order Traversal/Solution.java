package solution._0429;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level++).add(root.val);
//        for (Node child : root.children) {
//            dfs(child, level, res);
//        }
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node children;

        public void setChildren(Node children) {
            this.children = children;
        }

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public Node(int val, Node left, Node right, Node children) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.children = children;
        }
    };

}
