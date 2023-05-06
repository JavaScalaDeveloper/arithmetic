package jz_offer.src.medium.JZ55;

import java.util.*;

public class Solution {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        map.put(pHead, null);
        while (pHead.next != null) {
            pHead = pHead.next;
            if (map.containsKey(pHead)) return pHead;
            else map.put(pHead, null);
        }
        return null;
    }
}

