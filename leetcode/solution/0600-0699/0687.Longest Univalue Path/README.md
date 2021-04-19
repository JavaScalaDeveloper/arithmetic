# [687. 最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path)

[English Version](/solution/0600-0699/0687.Longest%20Univalue%20Path/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。</p>

<p><strong>注意</strong>：两个节点之间的路径长度由它们之间的边数表示。</p>

<p><strong>示例 1:</strong></p>

<p>输入:</p>

<pre>
              5
             / \
            4   5
           / \   \
          1   1   5
</pre>

<p>输出:</p>

<pre>
2
</pre>

<p><strong>示例 2:</strong></p>

<p>输入:</p>

<pre>
              1
             / \
            4   5
           / \   \
          4   4   5
</pre>

<p>输出:</p>

<pre>
2
</pre>

<p><strong>注意:</strong> 给定的二叉树不超过10000个结点。&nbsp;树的高度不超过1000。</p>

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
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        left = root.left != null && root.left.val == root.val ? left + 1 : 0;
        right = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }
}

```

### **...**

```

```

<!-- tabs:end -->
