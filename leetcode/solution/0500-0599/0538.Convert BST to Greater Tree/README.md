# [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree)

[English Version](/solution/0500-0599/0538.Convert%20BST%20to%20Greater%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。</p>

<p>&nbsp;</p>

<p><strong>例如：</strong></p>

<pre><strong>输入:</strong> 原始二叉搜索树:
              5
            /   \
           2     13

<strong>输出:</strong> 转换为累加树:
             18
            /   \
          20     13
</pre>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题和 1038:&nbsp;<a href="https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/">https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/</a> 相同</p>

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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += add;
            add = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
