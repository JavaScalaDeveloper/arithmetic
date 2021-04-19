# [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii)

[English Version](/solution/0400-0499/0445.Add%20Two%20Numbers%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个<strong>非空</strong>链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。</p>

<p>&nbsp;</p>

<p>你可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>

<p><strong>进阶:</strong></p>

<p>如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> (7 -&gt; 2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
<strong>输出:</strong> 7 -&gt; 8 -&gt; 0 -&gt; 7
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        for (; l1 != null; l1 = l1.next) {
            s1.push(l1.val);
        }
        for (; l2 != null; l2 = l2.next) {
            s2.push(l2.val);
        }
        ListNode head = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            carry += (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop());
            ListNode h = new ListNode(carry % 10);
            h.next = head;
            head = h;
            carry /= 10;
        }
        return head;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
