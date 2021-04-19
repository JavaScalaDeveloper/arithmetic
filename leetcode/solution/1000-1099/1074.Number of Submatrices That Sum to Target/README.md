# [1074. 元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target)

[English Version](/solution/1000-1099/1074.Number%20of%20Submatrices%20That%20Sum%20to%20Target/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给出矩阵&nbsp;<code>matrix</code>&nbsp;和目标值&nbsp;<code>target</code>，返回元素总和等于目标值的非空子矩阵的数量。</p>

<p>子矩阵&nbsp;<code>x1, y1, x2, y2</code>&nbsp;是满足 <code>x1 &lt;= x &lt;= x2</code>&nbsp;且&nbsp;<code>y1 &lt;= y &lt;= y2</code>&nbsp;的所有单元&nbsp;<code>matrix[x][y]</code>&nbsp;的集合。</p>

<p>如果&nbsp;<code>(x1, y1, x2, y2)</code> 和&nbsp;<code>(x1&#39;, y1&#39;, x2&#39;, y2&#39;)</code>&nbsp;两个子矩阵中部分坐标不同（如：<code>x1 != x1&#39;</code>），那么这两个子矩阵也不同。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
<strong>输出：</strong>4
<strong>解释：</strong>四个只含 0 的 1x1 子矩阵。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>matrix = [[1,-1],[-1,1]], target = 0
<strong>输出：</strong>5
<strong>解释：</strong>两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
</pre>

<p>&nbsp;</p>

<p><strong><strong>提示：</strong></strong></p>

<ol>
	<li><code>1 &lt;= matrix.length &lt;= 300</code></li>
	<li><code>1 &lt;= matrix[0].length &lt;= 300</code></li>
	<li><code>-1000 &lt;= matrix[i] &lt;= 1000</code></li>
	<li><code>-10^8 &lt;= target &lt;= 10^8</code></li>
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
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int[][] sum = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1];
                } else if (j == 0) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j];
                } else {
                    sum[i][j] = matrix[i][j] - sum[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1];
                }
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        int main = (k != 0 && l != 0) ? sum[k - 1][l - 1] : 0;
                        int left = k != 0 ? sum[k - 1][j] : 0;
                        int up = l != 0 ? sum[i][l - 1] : 0;
                        if (sum[i][j] - left - up + main == target) {
                            ans++;
                        }
                    }
                }
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
