package solution._0099;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private TreeNode first,second,pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre != null) {
            if (first == null && pre.val > root.val) first = pre;
            if (first != null && pre.val > root.val) second = root;
        }
        pre = root;
        traverse(root.right);
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