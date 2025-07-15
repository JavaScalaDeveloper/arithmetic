package jz_offer.src.medium.JZ55;

import datastructure.ListNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tools.listnode.ListNodeUtils;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        构造链表
        ListNode head = new ListNode(1, null);
        ListNode medium = new ListNode(4, new ListNode(5, null));
        ListNode tail = new ListNode(2, new ListNode(3,medium));
        head.next=medium;
        medium.next.next=tail;
        ListNode listNode = solution.entryNodeOfLoop(head);
        ListNode listNode2 = solution.entryNodeOfLoop2(head);
//        System.out.println(ListNodeUtils.getCircularList(listNode));
//        System.out.println(ListNodeUtils.getCircularList(listNode2));
        System.out.println(ListNodeUtils.getCircularList(head));

    }

    public ListNode entryNodeOfLoop(ListNode pHead) {
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

    /**
     * 快慢指针
     * @param head listNode
     * @return result
     */
    public ListNode entryNodeOfLoop2(ListNode head) {
        if (head == null || head.next == null) {
            //链表为空或只有一个元素，无法形成环
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针遍历链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                //相遇点
                ListNode p = head;
                while (p != slow) {
                    //从相遇点和头结点同时开始遍历，直到再次相遇
                    p = p.next;
                    slow = slow.next;
                }
                return p; //返回环的入口
            }
        }
        return null; //链表不存在环
    }

}

