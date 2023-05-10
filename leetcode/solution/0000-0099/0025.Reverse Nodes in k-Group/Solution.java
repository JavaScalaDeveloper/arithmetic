/**
 * Definition for singly-linked list.
 * private static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package solution._0025;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) {
            return head;
        }
        int num = 0;
        ListNode pNode = head;
        ListNode lastNode = new ListNode(0);
        ListNode reNode = lastNode;
        lastNode.next = head;
        while (pNode != null) {
            num++;
            if(num >= k) {
                num = 0;
                ListNode tempNode = pNode.next;
                reverse(lastNode.next, k);
				// k 个节点的尾节点指向下一组的头节点
                lastNode.next.next = tempNode;	
				// 上一组的尾节点指向当前 k 个节点的头节点				
                tempNode = lastNode.next;				
                lastNode.next = pNode;
				
                lastNode = tempNode;
                pNode = lastNode.next;
            }
            else {
                pNode = pNode.next;
            }
        }
        return reNode.next;
    }

    private ListNode reverse(ListNode node, int i) {
        if(i <= 1 || node.next == null) {
            return node;
        }
        ListNode lastNode = reverse(node.next, i - 1);
        lastNode.next = node; 
        return node;
    }
    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}