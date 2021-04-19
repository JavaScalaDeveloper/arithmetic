# [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row)

[English Version](/solution/0500-0599/0515.Find%20Largest%20Value%20in%20Each%20Tree%20Row/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>您需要在二叉树的每一行中找到最大的值。</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入:</strong> 

          1
         / \
        3   2
       / \   \  
      5   3   9 

<strong>输出:</strong> [1, 3, 9]
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
 * Definition for a binary tree node.
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 深度遍历
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 每深入一层，先把那一层的第一个节点加入返回 list中
        if (list.size() == level) {
            list.add(root.val);
        }
        // 此时 size > level ，那么就是开始遍历每一层 的 其他节点（不包括最左边的节点），
        // 直接比较list的对应下标（index）的值与当前值就好
        else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        // 左右子树，深度要+1
        dfs(list, root.left, level + 1);
        dfs(list, root.right, level + 1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
