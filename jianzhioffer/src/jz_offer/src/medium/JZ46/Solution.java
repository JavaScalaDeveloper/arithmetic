package jz_offer.src.medium.JZ46;

import datastructure.ListNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solve(5, 3);
        System.out.println(result);
        int result2 = solution.lastRemaining(5, 3);
        System.out.println(result2);
    }
    public int solve(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int p = 0;
        while (list.size() != 1) {
            p = (p + m - 1) % list.size();
            list.remove(p);
        }
        return list.get(0);
    }

    /**
     * 约瑟夫环
     * @param n 总共人数
     * @param m 第m个出列
     * @return 最后一个节点的值
     */
    public int lastRemaining(int n, int m) {
        // 使用循环链表模拟约瑟夫环
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        // 开始报数
        while (cur.next != cur) { // 当只剩下一个节点时结束循环
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next; // 删除需要出圈的节点
        }
        return cur.val;
    }
}
