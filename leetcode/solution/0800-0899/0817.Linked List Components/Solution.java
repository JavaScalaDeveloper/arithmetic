/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package solution._0817;

import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Solution {
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : G) {
            set.add(val);
        }
        int n = G.length;
        ListNode cur = head;
        int cnt = 0;
        boolean flag = false;
        while (cur != null) {
            while (cur != null && set.contains(cur.val)) {
                flag = true;
                cur = cur.next;
            }
            if (flag) {
                ++cnt;
                flag = false;
            }
            
            if (cur != null) {
                cur = cur.next;
            }
        }
        return cnt;
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