# [637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree)

[English Version](/solution/0600-0699/0637.Average%20of%20Levels%20in%20Binary%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
    3
   / \
  9  20
    /  \
   15   7
<strong>输出:</strong> [3, 14.5, 11]
<strong>解释:</strong>
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
</pre>

<p><strong>注意：</strong></p>

<ol>
	<li>节点值的范围在32位有符号整数范围内。</li>
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

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;

        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            double sum = 0, size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
