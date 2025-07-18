package jz_offer.all.JZ55;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private static class ListNode {
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

