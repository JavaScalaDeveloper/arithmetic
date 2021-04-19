# [1038. 从二叉搜索树到更大和树](https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree)

[English Version](/solution/1000-1099/1038.Binary%20Search%20Tree%20to%20Greater%20Sum%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给出二叉<strong> 搜索 </strong>树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 <code>node</code>&nbsp;的新值等于原树中大于或等于&nbsp;<code>node.val</code>&nbsp;的值之和。</p>

<p>提醒一下，二叉搜索树满足下列约束条件：</p>

<ul>
	<li>节点的左子树仅包含键<strong> 小于 </strong>节点键的节点。</li>
	<li>节点的右子树仅包含键<strong> 大于</strong> 节点键的节点。</li>
	<li>左右子树也必须是二叉搜索树。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

![](./images/tree.png)

<pre><strong>输入：</strong>[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
<strong>输出：</strong>[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>树中的节点数介于 <code>1</code> 和 <code>100</code> 之间。</li>
	<li>每个节点的值介于&nbsp;<code>0</code> 和&nbsp;<code>100</code>&nbsp;之间。</li>
	<li>给定的树为二叉搜索树。</li>
</ol>

<p>&nbsp;</p>

<p><strong>注意：</strong>该题目与 538:&nbsp;<a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">https://leetcode-cn.com/problems/convert-bst-to-greater-tree/&nbsp; </a>相同</p>

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
    private int max = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return new TreeNode(0);
        int temp = bstToGst(root.right).val;
        root.val += (temp > max ? temp : max);
        max = root.val > max ? root.val : max;
        if (root.left != null) {
            int temp2 = bstToGst(root.left.right).val;
            root.left.val += max > temp2 ? max : temp2;
            max = max > root.left.val ? max : root.left.val;
            bstToGst(root.left.left);
        }
        return root;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
