package jz_offer.src.hard.JZ59;

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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> tmp = new Stack<>();
        Stack<TreeNode> tmp1 = new Stack<>();
        tmp.push(pRoot);
        while (tmp.size() > 0 || tmp1.size() > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            if (tmp.size() > 0) {
                int size = tmp.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = tmp.pop();
                    if (node.left != null) tmp1.push(node.left);
                    if (node.right != null) tmp1.push(node.right);
                    list.add(node.val);
                }
                result.add(list);
                continue;
            }
            int size = tmp1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tmp1.pop();
                if (node.right != null) tmp.push(node.right);
                if (node.left != null) tmp.push(node.left);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}
