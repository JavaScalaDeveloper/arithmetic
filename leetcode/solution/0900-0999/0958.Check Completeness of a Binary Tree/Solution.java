package solution._0958;
import java.util.*;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
    private class ListNode {
        int val;
        private ListNode next;
    }

    private class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
    }
}
