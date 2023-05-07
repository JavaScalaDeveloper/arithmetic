package solution._0086;
import java.util.*;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);

        ListNode leftCur = leftDummy;
        ListNode rightCur = rightDummy;

        while (head != null) {
            if (head.val < x) {
                leftCur.next = head;
                leftCur = leftCur.next;
            } else {
                rightCur.next = head;
                rightCur = rightCur.next;
            }
            head = head.next;
        }
        leftCur.next = rightDummy.next;
        rightCur.next = null;
        return leftDummy.next;

    }
    private class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}