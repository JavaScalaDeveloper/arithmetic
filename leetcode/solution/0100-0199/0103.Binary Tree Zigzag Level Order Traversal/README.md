# [103. 二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal)

[English Version](/solution/0100-0199/0103.Binary%20Tree%20Zigzag%20Level%20Order%20Traversal/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>

<p>例如：<br>
给定二叉树&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>

<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回锯齿形层次遍历如下：</p>

<pre>[
  [3],
  [20,9],
  [15,7]
]
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
class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        lever(root, 0);
        for (int i = 1; i < list.size(); i = i + 2) {
            List<Integer> nList = list.get(i);
            List<Integer> nnl = new ArrayList<>();
            for (int j = nList.size() - 1; j >= 0; j--) nnl.add(nList.get(j));
            list.set(i, nnl);
        }
        return list;
    }
    private void lever(TreeNode root, int l) {
        if (root == null) return;
        while (l > list.size() - 1) list.add(new ArrayList<>());
        list.get(l++).add(root.val);
        lever(root.left, l);
        lever(root.right, l);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
