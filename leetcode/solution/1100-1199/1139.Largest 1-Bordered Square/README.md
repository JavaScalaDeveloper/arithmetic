# [1139. 最大的以 1 为边界的正方形](https://leetcode-cn.com/problems/largest-1-bordered-square)

[English Version](/solution/1100-1199/1139.Largest%201-Bordered%20Square/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给你一个由若干 <code>0</code> 和 <code>1</code> 组成的二维网格&nbsp;<code>grid</code>，请你找出边界全部由 <code>1</code> 组成的最大 <strong>正方形</strong> 子网格，并返回该子网格中的元素数量。如果不存在，则返回 <code>0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,1],[1,0,1],[1,1,1]]
<strong>输出：</strong>9
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>grid = [[1,1,0,0]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= grid.length &lt;= 100</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 100</code></li>
	<li><code>grid[i][j]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
</ul>

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
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    down[i][j] += i + 1 < m ? down[i + 1][j] + 1 : 1;
                    right[i][j] += j + 1 < n ? right[i][j + 1] + 1 : 1;
                }
            }
        }
        for (int len = Math.min(m, n); len > 0; --len) {
            for (int i = 0; i <= m - len; ++i) {
                for (int j = 0; j <= n - len; ++j) {
                    if (down[i][j] >= len && right[i][j] >= len && right[i + len - 1][j] >= len && down[i][j + len - 1] >= len) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
