package jz_offer.all.JZ16;


public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode(0);
        ListNode moveNode = headNode; //moveNode是headNode的引用,改变moveNode，headNode也会对应改变
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                moveNode.next = list1;
                list1 = list1.next;
            } else {
                moveNode.next = list2;
                list2 = list2.next;
            }
            moveNode = moveNode.next;
        }
        if (list1 == null)
            moveNode.next = list2;
        if (list2 == null)
            moveNode.next = list1;
        return headNode.next;
    }
}
