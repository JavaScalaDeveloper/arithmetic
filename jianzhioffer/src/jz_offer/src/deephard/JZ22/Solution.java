package jz_offer.src.deephard.JZ22;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0,
                new TreeNode(1, new TreeNode(2, null, null),
                        new TreeNode(3, new TreeNode(4, null, null), null)), null);
        new TreeNode(1, null, null);

        ArrayList<Integer> list = printFromTopToBottom(treeNode);
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        private int val = 0;
        private TreeNode left = null;
        private TreeNode right = null;
    }

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            node = queue.poll();
        }
        return list;
    }
}
