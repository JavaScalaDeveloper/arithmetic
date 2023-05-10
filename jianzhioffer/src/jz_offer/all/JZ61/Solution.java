package jz_offer.all.JZ61;

import java.util.LinkedList;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    String Serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1; // 用来记录当前节点及其后面非空节点的个数
        while (!queue.isEmpty() && root != null) {
            TreeNode node = queue.poll();
            if (node == null) {
                ans.append("null");
            } else {
                ans.append(node.val);
                sum--;
                if (node.left != null) {
                    sum++;
                }
                if (node.right != null) {
                    sum++;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (sum != 0) {
                ans.append(",");
            } else {
                break;
            }
        }
        ans.append("]");
        return ans.toString();
    }

    TreeNode Deserialize(String data) {
        String s = data.substring(1, data.length() - 1);
        if ("".equals(s)) {
            return null; // data = "[]"
        }
        String[] a = s.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(change(a[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < a.length) {
            TreeNode node = queue.poll();
            if (!"null".equals(a[index])) {
                node.left = new TreeNode(change(a[index++]));
                queue.add(node.left);
            } else {
                index++;
            }
            if (index < a.length && !"null".equals(a[index])) {
                node.right = new TreeNode(change(a[index++]));
                queue.add(node.right);
            } else {
                index++;
            }
        }
        return root;
    }

    public int change(String s) {
        int res = 0;
        int i = 0;
        int flag = 1;
        if (s.charAt(0) == '-') {
            i++;
            flag = -1;
        }
        for (; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * flag;
    }
}
