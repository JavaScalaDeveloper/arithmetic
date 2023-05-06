/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package solution._08;
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
}