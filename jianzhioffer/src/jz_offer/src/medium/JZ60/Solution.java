package jz_offer.src.medium.JZ60;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;


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

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (pRoot == null) return totalList;
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
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            totalList.add(partList);
        }
        return totalList;
    }
}
