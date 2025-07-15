/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private List<String> res;
    private List<String> path;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }
    private static class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}