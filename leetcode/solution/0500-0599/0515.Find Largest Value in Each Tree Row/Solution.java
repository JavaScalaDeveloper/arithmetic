/**
 * Definition for a binary tree node.
 * private static class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 */
package solution._0515;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    // 深度遍历
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 每深入一层，先把那一层的第一个节点加入返回 list中
        if (list.size() == level) {
            list.add(root.val);
        }
        // 此时 size > level ，那么就是开始遍历每一层 的 其他节点（不包括最左边的节点），
        // 直接比较list的对应下标（index）的值与当前值就好
        else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        // 左右子树，深度要+1
        dfs(list, root.left, level + 1);
        dfs(list, root.right, level + 1);
    }
   private static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

    }

}