# [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle)

[English Version](/solution/0100-0199/0120.Triangle/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。</p>

<p>例如，给定三角形：</p>

<pre>[
     [<strong>2</strong>],
    [<strong>3</strong>,4],
   [6,<strong>5</strong>,7],
  [4,<strong>1</strong>,8,3]
]
</pre>

<p>自顶向下的最小路径和为&nbsp;<code>11</code>（即，<strong>2&nbsp;</strong>+&nbsp;<strong>3</strong>&nbsp;+&nbsp;<strong>5&nbsp;</strong>+&nbsp;<strong>1</strong>&nbsp;= 11）。</p>

<p><strong>说明：</strong></p>

<p>如果你可以只使用 <em>O</em>(<em>n</em>)&nbsp;的额外空间（<em>n</em> 为三角形的总行数）来解决这个问题，那么你的算法会很加分。</p>

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
    private int[][] cache = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        cache = new int[n][triangle.get(n - 1).size()];
        for (int[] row : cache) Arrays.fill(row, -1);
        return dfs(triangle,0,0);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) return 0;
        if (cache[row][col] != -1) return cache[row][col];
        int l = dfs(triangle,row+1,col);
        int r = dfs(triangle,row+1,col+1);
        int res = Math.min(l,r)+triangle.get(row).get(col);
        cache[row][col] = res;
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
