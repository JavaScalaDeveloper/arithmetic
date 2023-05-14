package tools.listnode;

import datastructure.ListNode;

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
}
