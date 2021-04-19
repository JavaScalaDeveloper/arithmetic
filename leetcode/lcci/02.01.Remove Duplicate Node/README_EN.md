# [02.01. Remove Duplicate Node](https://leetcode-cn.com/problems/remove-duplicate-node-lcci)

[中文文档](/lcci/02.01.Remove%20Duplicate%20Node/README.md)

## Description

<p>Write code to remove duplicates from an unsorted linked list.</p>

<p><strong>Example1:</strong></p>

<pre>

<strong> Input</strong>: [1, 2, 3, 3, 2, 1]

<strong> Output</strong>: [1, 2, 3]

</pre>

<p><strong>Example2:</strong></p>

<pre>

<strong> Input</strong>: [1, 1, 1, 1, 2]

<strong> Output</strong>: [1, 2]

</pre>

<p><strong>Note: </strong></p>

<ol>
	<li>The length of the list is within the range[0, 20000].</li>

    <li>The values of the list elements are within the range [0, 20000].</li>

</ol>

<p><strong>Follow Up: </strong></p>

<p>How would you solve this problem if a temporary buffer is not allowed?</p>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeDuplicateNodes(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        cache = set()
        cache.add(head.val)
        cur, p = head, head.next
        while p:
            if p.val not in cache:
                cur.next = p
                cur = cur.next
                cache.add(p.val)
            p = p.next
        cur.next = None
        return head
```

### **Java**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> s = new HashSet<>();
        s.add(head.val);
        ListNode p = head.next, cur = head;
        while (p != null) {
            if (!s.contains(p.val)) {
                cur.next = p;
                cur = cur.next;
                s.add(p.val);
            }
            p = p.next;
        }
        cur.next = null;
        return head;

    }
}
```

### **...**

```

```

<!-- tabs:end -->
