/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package solution._0501;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    int max = 0;
    int cur = 0;
    TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        findMode(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void findMode(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        findMode(root.left, list);
        if (preNode != null && root.val == preNode.val) {
            cur++;
        } else {
            cur = 1;
        }
        if (max < cur) {
            max = cur;
            list.clear();
            list.add(root.val);
        } else if (max == cur) {
            list.add(root.val);
        }
        preNode = root;
        findMode(root.right, list);
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }
}
