package jz_offer.src.hard.JZ24;

import java.util.*;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
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
