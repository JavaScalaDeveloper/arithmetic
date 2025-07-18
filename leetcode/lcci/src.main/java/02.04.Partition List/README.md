# [面试题 02.04. 分割链表](https://leetcode-cn.com/problems/partition-list-lcci)

[English Version](/lcci/02.04.Partition%20List/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于&ldquo;右半部分&rdquo;即可，其不需要被置于左右两部分之间。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> head = 3-&gt;5-&gt;8-&gt;5-&gt;10-&gt;2-&gt;1, <em>x</em> = 5
<strong>输出:</strong> 3-&gt;1-&gt;2-&gt;10-&gt;5-&gt;5-&gt;8
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

创建两个链表，一个存放小于 `x` 的节点，另一个存放大于等于 `x` 的节点，之后进行拼接即可。

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if head is None or head.next is None:
            return head
        left, right = ListNode(-1), ListNode(-1)
        p, q = left, right
        while head:
            t = head.next
            head.next = None
            if head.val < x:
                p.next = head
                p = p.next
            else:
                q.next = head
                q = q.next
            head = t
        p.next = right.next
        return left.next
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package src.main.java;
import java.util.*;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode p = left, q = right;
        while (head != null) {
            ListNode t = head.next;
            head.next = null;
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = t;
        }
        p.next = right.next;
        return left.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
