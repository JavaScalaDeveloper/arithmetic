# [面试题 02.05. 链表求和](https://leetcode-cn.com/problems/sum-lists-lcci)

[English Version](/lcci/02.05.Sum%20Lists/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个用链表表示的整数，每个节点包含一个数位。</p>
<p>这些数位是反向存放的，也就是个位排在链表首部。</p>
<p>编写函数对这两个整数求和，并用链表形式返回结果。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>(7 -&gt; 1 -&gt; 6) + (5 -&gt; 9 -&gt; 2)，即617 + 295
<strong>输出：</strong>2 -&gt; 1 -&gt; 9，即912
</pre>

<p><strong>进阶：</strong>假设这些数位是正向存放的，请再做一遍。</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>(6 -&gt; 1 -&gt; 7) + (2 -&gt; 9 -&gt; 5)，即617 + 295
<strong>输出：</strong>9 -&gt; 1 -&gt; 2，即912
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

同时遍历两链表，求节点的和与进位。

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
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        p = ListNode(-1)
        carry, t = 0, p
        while l1 or l2:
            s = (0 if l1 is None else l1.val) + (0 if l2 is None else l2.val) + carry
            carry = 1 if s > 9 else 0
            t.next = ListNode(s % 10)
            t = t.next
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2
        t.next = None if carry == 0 else ListNode(carry)
        return p.next


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        int carry = 0;
        ListNode t = p;
        while (l1 != null || l2 != null) {
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            t.next = new ListNode(s % 10);
            carry = s > 9 ? 1 : 0;
            t = t.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        t.next = carry == 0 ? null : new ListNode(carry);
        return p.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
