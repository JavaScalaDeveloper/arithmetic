# [1026. 节点与其祖先之间的最大差值](https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor)

[English Version](/solution/1000-1099/1026.Maximum%20Difference%20Between%20Node%20and%20Ancestor/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定二叉树的根节点&nbsp;<code>root</code>，找出存在于不同节点&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;之间的最大值 <code>V</code>，其中&nbsp;<code>V = |A.val - B.val|</code>，且&nbsp;<code>A</code>&nbsp;是&nbsp;<code>B</code>&nbsp;的祖先。</p>

<p>（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

![](./images/2whqcep.jpg)

<pre><strong>输入：</strong>[8,3,10,1,6,null,14,null,null,4,7,13]
<strong>输出：</strong>7
<strong>解释： </strong>
我们有大量的节点与其祖先的差值，其中一些如下：
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>树中的节点数在&nbsp;<code>2</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;之间。</li>
	<li>每个节点的值介于&nbsp;<code>0</code>&nbsp;到&nbsp;<code>100000</code>&nbsp;之间。</li>
</ol>

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
    public int bfs(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        int res = Math.max(max - root.val, root.val - min);
        int mx = Math.max(root.val, max);
        int mn = Math.min(root.val, min);
        res = Math.max(res, bfs(root.left, mx, mn));
        res = Math.max(res, bfs(root.right, mx, mn));
        return res;
    }

    public int maxAncestorDiff(TreeNode root) {
        return bfs(root, root.val, root.val);
    }
}

```

### **...**

```

```

<!-- tabs:end -->
