package solution._0876;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode low = head, first = head;
        while (first != null && first.next != null) {
            low = low.next;
            first = first.next.next;
        }
        return low;
    }

    private static class ListNode {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}