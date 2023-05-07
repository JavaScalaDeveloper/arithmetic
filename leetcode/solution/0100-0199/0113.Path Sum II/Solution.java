/**
 * Definition for a binary tree node.
 *  class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

public class Solution {
    private List<List<Integer>> res;
    private List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}