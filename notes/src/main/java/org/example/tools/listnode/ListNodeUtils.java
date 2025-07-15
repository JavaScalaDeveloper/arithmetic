package org.example.tools.listnode;


import org.example.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表工具类
 */
public class ListNodeUtils {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        List<Integer> values = ListNodeUtils.getValues(listNode);
        System.out.println(values);


//        构造链表
        ListNode head = new ListNode(1, null);
        ListNode medium = new ListNode(4, new ListNode(5, head));
        ListNode tail = new ListNode(2, new ListNode(3, medium));
        head.next = medium;
        List<Integer> circularList = ListNodeUtils.getCircularList(tail);
        System.out.println(circularList);
    }

    public static List<Integer> getValues(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        list.add(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            list.add(listNode.val);
        }
        return list;
    }

    /**
     * 获取环状链表的值
     *
     * @param head 环状链表
     * @return 值
     */
    public static List<Integer> getCircularList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        //快慢指针遍历链表，判断是否存在环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                //相遇点，存在环
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            //慢指针从相遇点继续往前走一圈回到相遇点
            slow = head;
            while (slow != fast) {
                list.add(slow.val);
                slow = slow.next;
                fast = fast.next;
            }
            //输出环入口和后续结点
            list.add(fast.val);
        }
        return list;
    }

}
