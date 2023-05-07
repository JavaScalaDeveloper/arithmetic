# [508. 出现次数最多的子树元素和](https://leetcode-cn.com/problems/most-frequent-subtree-sum)

[English Version](/solution/0500-0599/0508.Most%20Frequent%20Subtree%20Sum/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。</p>

<p>&nbsp;</p>

<p><strong>示例 1</strong><br>
输入:</p>

<pre>  5
 /  \
2   -3
</pre>

<p>返回&nbsp;[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。</p>

<p><strong>示例&nbsp;2</strong><br>
输入:</p>

<pre>  5
 /  \
2   -5
</pre>

<p>返回&nbsp;[2]，只有 2 出现两次，-5 只出现 1 次。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong>&nbsp;假设任意子树元素和均可以用 32 位有符号整数表示。</p>

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
import java.util.*;

public class Solution {
    // 后续遍历，遍历的同时，找最大值和计算次数
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);
        List<Integer> list = map.entrySet().stream()
                .filter(m -> m.getValue() == max).map(i -> i.getKey()).collect(Collectors.toList());
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        int current = map.getOrDefault(sum, 0) + 1;
        map.put(sum, current);
        max = Math.max(current, max);
        return sum;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
