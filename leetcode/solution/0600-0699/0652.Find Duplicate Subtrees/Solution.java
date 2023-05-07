package solution._0652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }

    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "";
        }
        String s = root.val + "_" + dfs(root.left, map, res) + "_" + dfs(root.right, map, res);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }
    private class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
