# [814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning)

[English Version](/solution/0800-0899/0814.Binary%20Tree%20Pruning/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定二叉树根结点&nbsp;<code>root</code>&nbsp;，此外树的每个结点的值要么是 0，要么是 1。</p>

<p>返回移除了所有不包含 1 的子树的原二叉树。</p>

<p>( 节点 X 的子树为 X 本身，以及所有 X 的后代。)</p>

<pre>
<strong>示例1:</strong>
<strong>输入:</strong> [1,null,0,0,1]
<strong>输出: </strong>[1,null,0,null,1]
 
<strong>解释:</strong> 
只有红色节点满足条件&ldquo;所有不包含 1 的子树&rdquo;。
右图为返回的答案。
</pre>

![](./images/1028_2.png)

<pre>
<strong>示例2:</strong>
<strong>输入:</strong> [1,0,1,0,0,0,1]
<strong>输出: </strong>[1,null,1,null,1]

</pre>

![](./images/1028_1.png)

<pre>
<strong>示例3:</strong>
<strong>输入:</strong> [1,1,0,1,1,0,1,0]
<strong>输出: </strong>[1,1,0,1,1,null,1]

</pre>

![](./images/1028.png)

<p><strong>说明: </strong></p>

<ul>
	<li>给定的二叉树最多有&nbsp;<code>100</code>&nbsp;个节点。</li>
	<li>每个节点的值只会为&nbsp;<code>0</code> 或&nbsp;<code>1</code>&nbsp;。</li>
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
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
