# [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group)

[English Version](/solution/0000-0099/0025.Reverse%20Nodes%20in%20k-Group/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给你一个链表，每&nbsp;<em>k&nbsp;</em>个节点一组进行翻转，请你返回翻转后的链表。</p>

<p><em>k&nbsp;</em>是一个正整数，它的值小于或等于链表的长度。</p>

<p>如果节点总数不是&nbsp;<em>k&nbsp;</em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<p>给你这个链表：<code>1-&gt;2-&gt;3-&gt;4-&gt;5</code></p>

<p>当&nbsp;<em>k&nbsp;</em>= 2 时，应当返回: <code>2-&gt;1-&gt;4-&gt;3-&gt;5</code></p>

<p>当&nbsp;<em>k&nbsp;</em>= 3 时，应当返回: <code>3-&gt;2-&gt;1-&gt;4-&gt;5</code></p>

<p>&nbsp;</p>

<p><strong>说明：</strong></p>

<ul>
	<li>你的算法只能使用常数的额外空间。</li>
	<li><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际进行节点交换。</li>
</ul>

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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
```

### **...**

```

```

<!-- tabs:end -->
