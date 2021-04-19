# [576. 出界的路径数](https://leetcode-cn.com/problems/out-of-boundary-paths)

[English Version](/solution/0500-0599/0576.Out%20of%20Boundary%20Paths/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个 <strong>m &times; n </strong>的网格和一个球。球的起始坐标为&nbsp;<strong>(i,j)</strong>&nbsp;，你可以将球移到<strong>相邻</strong>的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你<strong>最多</strong>可以移动&nbsp;<strong>N&nbsp;</strong>次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 10<sup>9</sup>&nbsp;+ 7 的值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入: </strong>m = 2, n = 2, N = 2, i = 0, j = 0

<strong>输出:</strong> 6

<strong>解释:</strong>

</pre>

![](./images/out_of_boundary_paths_1.png)

<p><strong>示例 2：</strong></p>

<pre><strong>输入: </strong>m = 1, n = 3, N = 3, i = 0, j = 1

<strong>输出:</strong> 12

<strong>解释:</strong>

</pre>

![](./images/out_of_boundary_paths_2.png)

<p>&nbsp;</p>

<p><strong>说明:</strong></p>

<ol>
	<li>球一旦出界，就不能再被移动回网格内。</li>
	<li>网格的长度和高度在 [1,50] 的范围内。</li>
	<li>N 在 [0,50] 的范围内。</li>
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
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        final int MOD = (int) (1e9 + 7);
        final int[] dirs = new int[]{-1, 0, 1, 0, -1};
        int[][] f = new int[m][n];
        f[i][j] = 1;
        int res = 0;
        for (int step = 0; step < N; ++step) {
            int[][] temp = new int[m][n];
            for (int x = 0; x < m; ++x) {
                for (int y = 0; y < n; ++y) {
                    for (int k = 0; k < 4; ++k) {
                        int tx = x + dirs[k], ty = y + dirs[k + 1];
                        if (tx >= 0 && tx < m && ty >= 0 && ty < n) {
                            temp[tx][ty] += f[x][y];
                            temp[tx][ty] %= MOD;
                        } else {
                            res += f[x][y];
                            res %= MOD;
                        }
                    }
                }
            }
            f = temp;
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
