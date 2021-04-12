package jz_offer.all.JZ36;

import java.util.HashMap;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (pHead1 != null) {
            map.put(pHead1, null);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (map.containsKey(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
