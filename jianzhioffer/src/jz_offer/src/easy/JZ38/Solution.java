package jz_offer.src.easy.JZ38;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(0, new TreeNode(1, null, null),
                new TreeNode(2, new TreeNode(3, new TreeNode(4, null, null), null), null));
        int result = solution.TreeDepth1(treeNode);
        int result2 = solution.TreeDepth2(treeNode);
        System.out.println(result);
        System.out.println(result2);
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;

    }

    //递归解法
    public int TreeDepth1(TreeNode root) {
        if (root == null) return 0;
        //求出左子树的最大深度
        int left = TreeDepth1(root.left);
        //求出右子树的最大深度
        int right = TreeDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    //借助队列，层次遍历
    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int high = 0;
        int size;
        TreeNode node;
        while (queue.size() != 0) {
            size = queue.size();
            while (size != 0) {
                node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            high++;
        }
        return high;
    }
}
