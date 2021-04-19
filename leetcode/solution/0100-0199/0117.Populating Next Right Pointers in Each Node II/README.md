# [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii)

[English Version](/solution/0100-0199/0117.Populating%20Next%20Right%20Pointers%20in%20Each%20Node%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二叉树</p>

<pre>struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}</pre>

<p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>

<p>初始状态下，所有&nbsp;next 指针都被设置为 <code>NULL</code>。</p>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul>
	<li>你只能使用常量级额外空间。</li>
	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

![](./images/117_sample.png)

<pre><strong>输入</strong>：root = [1,2,3,4,5,null,7]
<strong>输出：</strong>[1,#,2,3,#,4,5,7,#]
<strong>解释：</strong>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的节点数小于 <code>6000</code></li>
	<li><code>-100&nbsp;&lt;= node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<ul>
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
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode first_node_next_layer = null;
        TreeLinkNode preNode = null;
        for (TreeLinkNode curNode = root; curNode != null; curNode = curNode.next) {
            if (curNode.left != null) {
                if (preNode == null) {
                    preNode = curNode.left;
                    first_node_next_layer = curNode.left;
                } else {
                    preNode.next = curNode.left;
                    preNode = preNode.next;
                }
            }
            if (curNode.right != null) {
                if (preNode == null) {
                    preNode = curNode.right;
                    first_node_next_layer = curNode.right;
                } else {
                    preNode.next = curNode.right;
                    preNode = preNode.next;
                }
            }
        }
        connect(first_node_next_layer);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
