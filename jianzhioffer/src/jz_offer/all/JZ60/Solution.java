package jz_offer.all.JZ60;

import java.util.ArrayList;
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

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (pRoot == null)
            return totalList;
        ArrayList<Integer> partList;
        TreeNode node;
        //局部变量需要自己初始化，成员变量jvm会帮我们初始化
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            size = queue.size();
            partList = new ArrayList<>();
            while (size > 0) {
                node = queue.poll();
                partList.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            totalList.add(partList);
        }
        return totalList;
    }
}
