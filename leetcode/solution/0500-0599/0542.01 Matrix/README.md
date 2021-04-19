# [542. 01 矩阵](https://leetcode-cn.com/problems/01-matrix)

[English Version](/solution/0500-0599/0542.01%20Matrix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。</p>

<p>两个相邻元素间的距离为 1 。</p>

<p><strong>示例 1: </strong><br />
输入:</p>

<pre>
0 0 0
0 1 0
0 0 0
</pre>

<p>输出:</p>

<pre>
0 0 0
0 1 0
0 0 0
</pre>

<p><strong>示例 2: </strong><br />
输入:</p>

<pre>
0 0 0
0 1 0
1 1 1
</pre>

<p>输出:</p>

<pre>
0 0 0
0 1 0
1 2 1
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>给定矩阵的元素个数不超过 10000。</li>
	<li>给定矩阵中至少有一个元素是 0。</li>
	<li>矩阵中的元素只在四个方向上相邻: 上、下、左、右。</li>
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
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int[] arr : res) {
            Arrays.fill(arr, -1);
        }
        class Position {
            int x, y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Queue<Position> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new Position(i, j));
                }
            }
        }
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int x = pos.x + dirs[i], y = pos.y + dirs[i + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = res[pos.x][pos.y] + 1;
                    queue.offer(new Position(x, y));
                }
            }
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
