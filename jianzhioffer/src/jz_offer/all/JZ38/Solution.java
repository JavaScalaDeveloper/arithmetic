package jz_offer.all.JZ38;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //递归解法
    public int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        //求出左子树的最大深度
        int left = TreeDepth1(root.left);
        //求出右子树的最大深度
        int right = TreeDepth1(root.right);
        return Math.max(left, right) + 1;
    }

    //借助队列，层次遍历
    public int TreeDepth2(TreeNode root) {
        if (root == null)
            return 0;
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
