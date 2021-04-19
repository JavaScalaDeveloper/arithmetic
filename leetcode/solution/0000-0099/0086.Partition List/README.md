# [86. 分隔链表](https://leetcode-cn.com/problems/partition-list)

[English Version](/solution/0000-0099/0086.Partition%20List/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个链表和一个特定值<em> x</em>，对链表进行分隔，使得所有小于 <em>x</em> 的节点都在大于或等于 <em>x</em> 的节点之前。</p>

<p>你应当保留两个分区中每个节点的初始相对位置。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> head = 1-&gt;4-&gt;3-&gt;2-&gt;5-&gt;2, <em>x</em> = 3
<strong>输出:</strong> 1-&gt;2-&gt;2-&gt;4-&gt;3-&gt;5
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
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode headSmaller(0), headBigger(0) ;
        ListNode *pSmaller = &headSmaller ;
        ListNode *pBigger = &headBigger ;
        ListNode *p = head ;
        while (nullptr != p)
        {
            if (p->val < x)
            {
                pSmaller->next = p ;
                pSmaller = p ;
            }
            else
            {
                pBigger->next = p ;
                pBigger = p ;
            }
            p = p->next ;
        }
        pBigger->next = nullptr ;
        pSmaller->next = headBigger.next ;
        return headSmaller.next ;
    }
};

```

### **...**

```

```

<!-- tabs:end -->
