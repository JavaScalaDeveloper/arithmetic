package jz_offer.all.JZ22;

import java.util.ArrayList;
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

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            node = queue.poll();
        }
        return list;
    }
}
