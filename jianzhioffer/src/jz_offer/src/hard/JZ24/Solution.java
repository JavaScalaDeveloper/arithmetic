package jz_offer.src.hard.JZ24;

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

    public void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        //递归终止条件
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        //一个path往左子树，一个path往右子树，所以要new一个ArrayList
        find(root.left, target, result, new ArrayList<>(path));
        find(root.right, target, result, new ArrayList<>(path));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<Integer> path = new ArrayList<>();
        find(root, target, result, path);
        return result;
    }
}
