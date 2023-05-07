package solution._1019;
import java.util.*;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
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
