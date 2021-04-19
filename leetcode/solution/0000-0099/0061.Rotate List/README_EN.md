# [61. Rotate List](https://leetcode.com/problems/rotate-list)

[中文文档](/solution/0000-0099/0061.Rotate%20List/README.md)

## Description

<p>Given a linked&nbsp;list, rotate the list to the right by <em>k</em> places, where <em>k</em> is non-negative.</p>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, k = 2

<strong>Output:</strong> 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL

<strong>Explanation:</strong>

rotate 1 steps to the right: 5-&gt;1-&gt;2-&gt;3-&gt;4-&gt;NULL

rotate 2 steps to the right: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL

</pre>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input:</strong> 0-&gt;1-&gt;2-&gt;NULL, k = 4

<strong>Output:</strong> <code>2-&gt;0-&gt;1-&gt;NULL</code>

<strong>Explanation:</strong>

rotate 1 steps to the right: 2-&gt;0-&gt;1-&gt;NULL

rotate 2 steps to the right: 1-&gt;2-&gt;0-&gt;NULL

rotate 3 steps to the right:&nbsp;<code>0-&gt;1-&gt;2-&gt;NULL</code>

rotate 4 steps to the right:&nbsp;<code>2-&gt;0-&gt;1-&gt;NULL</code></pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None or k == 0:
            return head
        n = 0
        cur = head
        while cur:
            n += 1
            cur = cur.next
        k %= n
        if k == 0:
            return head
        p = q = head
        for i in range(k):
            q = q.next
        while q.next:
            p, q = p.next, q.next
        start = p.next
        p.next = None
        q.next = head
        return start
```

### **Java**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode p = head, q = head;
        for (int i = 0; i < k; ++i) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode start = p.next;
        p.next = null;
        q.next = head;
        return start;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
