# [938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst)

[English Version](/solution/0900-0999/0938.Range%20Sum%20of%20BST/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定二叉搜索树的根结点&nbsp;<code>root</code>，返回 <code>L</code> 和 <code>R</code>（含）之间的所有结点的值的和。</p>

<p>二叉搜索树保证具有唯一的值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>root = [10,5,15,3,7,null,18], L = 7, R = 15
<strong>输出：</strong>32
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre><strong>输入：</strong>root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>树中的结点数量最多为&nbsp;<code>10000</code>&nbsp;个。</li>
	<li>最终的答案保证小于&nbsp;<code>2^31</code>。</li>
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
    private int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return res;
        }
        
        if (root.val < L) {
            rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            rangeSumBST(root.left, L, R);
        } else {
            res += root.val;
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
        }
        return res;
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
