package solution._0199;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans, 0);
        return ans;
    }

    private void robot(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(root.val);
        }
        ans.set(level, root.val);
        robot(root.left, ans, level + 1);
        robot(root.right, ans, level + 1);
    }
    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
