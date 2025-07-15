package jz_offer.src.medium.JZ36;

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

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (pHead1 != null) {
            map.put(pHead1, null);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (map.containsKey(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 我们可以分别遍历两个链表，记录它们的长度差diff，然后在较长的链表中先走diff步，使得两个链表剩余长度相等。
     * 之后同时遍历两个链表，比较每个节点是否相同，第一个相同的节点就是它们的第一个公共节点。
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        int len1 = 0;
        int len2 = 0;
        // 分别计算两个链表的长度
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        // 计算长度差diff
        int diff = Math.abs(len1 - len2);
        // 在较长的链表中先走diff步
        if (len1 > len2) {
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }
        // 同时遍历两个链表，比较每个节点是否相同
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null; // 两个链表没有公共节点
    }

}
