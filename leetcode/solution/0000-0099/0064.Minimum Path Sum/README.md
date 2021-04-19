# [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum)

[English Version](/solution/0000-0099/0064.Minimum%20Path%20Sum/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个包含非负整数的 <em>m</em>&nbsp;x&nbsp;<em>n</em>&nbsp;网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>

<p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
[
&nbsp; [1,3,1],
  [1,5,1],
  [4,2,1]
]
<strong>输出:</strong> 7
<strong>解释:</strong> 因为路径 1&rarr;3&rarr;1&rarr;1&rarr;1 的总和最小。
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
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[grid.length-1][grid[0].length-1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
