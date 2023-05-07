/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package solution._1171;
import java.util.*;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        boolean isZeroSum = true; 
        
        while (isZeroSum) {
        	isZeroSum = false;
        	int sum = 0;
        	ListNode temp = head;
        	
        	while (temp != null) {
        		sum += temp.val;
        		
        		if (sum == 0) {
        			head = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		} else if (map.containsKey(sum)) {
        			map.get(sum).next = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		}
        		
        		map.put(sum, temp);
        		temp = temp.next;
        	}
        }
        return head;
    }
	private class ListNode {
		int val;
		private ListNode next;
	}

	private class TreeNode {
		int val;
		private TreeNode left;
		private TreeNode right;
	}
}