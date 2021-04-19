# [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree)

[English Version](/solution/0100-0199/0110.Balanced%20Binary%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二叉树，判断它是否是高度平衡的二叉树。</p>

<p>本题中，一棵高度平衡二叉树定义为：</p>

<blockquote>
<p>一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过1。</p>
</blockquote>

<p><strong>示例 1:</strong></p>

<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code></p>

<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回 <code>true</code> 。<br>
<br>
<strong>示例 2:</strong></p>

<p>给定二叉树 <code>[1,2,2,3,3,null,null,4,4]</code></p>

<pre>       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
</pre>

<p>返回&nbsp;<code>false</code> 。</p>

<p>&nbsp;</p>

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
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
