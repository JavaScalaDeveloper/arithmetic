# [329. 矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix)

[English Version](/solution/0300-0399/0329.Longest%20Increasing%20Path%20in%20a%20Matrix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数矩阵，找出最长递增路径的长度。</p>

<p>对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入: </strong>nums = 
[
  [<strong>9</strong>,9,4],
  [<strong>6</strong>,6,8],
  [<strong>2</strong>,<strong>1</strong>,1]
] 
<strong>输出:</strong> 4 
<strong>解释:</strong> 最长递增路径为&nbsp;<code>[1, 2, 6, 9]</code>。</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> nums = 
[
  [<strong>3</strong>,<strong>4</strong>,<strong>5</strong>],
  [3,2,<strong>6</strong>],
  [2,2,1]
] 
<strong>输出: </strong>4 
<strong>解释: </strong>最长递增路径是&nbsp;<code>[3, 4, 5, 6]</code>。注意不允许在对角线方向上移动。
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
import java.util.*;

public class Solution {
    
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int robot(int x, int y, int[][] m, int[][] cache) {
        if(cache[x][y] != 0) return cache[x][y];
        int max = 1;
        for(int[] dir : dirs) {
            int dx = dir[0], dy = dir[1];
            if(x + dx < 0 || x + dx >= m.length || y + dy < 0 || y + dy >= m[0].length || m[x][y] <= m[x + dx][y + dy]) {
                continue;
            }
            max = Math.max(max, robot(x + dx, y + dy, m, cache) + 1);
        }
        cache[x][y] = max;
        return max;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 1;
        // 枚举每一个点，计算每个点的最大升序
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, robot(i, j, matrix, cache));
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
