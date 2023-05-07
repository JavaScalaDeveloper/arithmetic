package solution._0095;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = generateTrees(left, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, right);
                for (TreeNode l : leftTrees) {
                    for (TreeNode r : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
    private class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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