# [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions)

[English Version](/solution/0100-0199/0130.Surrounded%20Regions/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二维的矩阵，包含&nbsp;<code>&#39;X&#39;</code>&nbsp;和&nbsp;<code>&#39;O&#39;</code>（<strong>字母 O</strong>）。</p>

<p>找到所有被 <code>&#39;X&#39;</code> 围绕的区域，并将这些区域里所有的&nbsp;<code>&#39;O&#39;</code> 用 <code>&#39;X&#39;</code> 填充。</p>

<p><strong>示例:</strong></p>

<pre>X X X X
X O O X
X X O X
X O X X
</pre>

<p>运行你的函数后，矩阵变为：</p>

<pre>X X X X
X X X X
X X X X
X O X X
</pre>

<p><strong>解释:</strong></p>

<p>被围绕的区间不会存在于边界上，换句话说，任何边界上的&nbsp;<code>&#39;O&#39;</code>&nbsp;都不会被填充为&nbsp;<code>&#39;X&#39;</code>。 任何不在边界上，或不与边界上的&nbsp;<code>&#39;O&#39;</code>&nbsp;相连的&nbsp;<code>&#39;O&#39;</code>&nbsp;最终都会被填充为&nbsp;<code>&#39;X&#39;</code>。如果两个元素在水平或垂直方向相邻，则称它们是&ldquo;相连&rdquo;的。</p>

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

    /**
     * 坐标点
     */
    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // top & bottom
        for (int i = 0; i < n; ++i) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }

        // left & right
        for (int i = 1; i < m - 1; ++i) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 广度优先搜索
     * @param board
     * @param i
     * @param j
     */
    private void bfs(char[][] board, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        if (isValid(board, i, j)) {
            // 遇到'O'，修改为'Y'
            board[i][j] = 'Y';
            queue.offer(new Point(i, j));
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            // 获取下一层所有有效坐标点，并加入队列
            List<Point> points = getNextLevelValidPoints(board, p.x, p.y);
            for (Point point : points) {
                queue.offer(point);
            }
        }

    }

    /**
     * 获取下一层所有有效坐标点，将这些坐标点修改为 'Y' 并返回
     * @param board
     * @param i
     * @param j
     * @return list
     */
    private List<Point> getNextLevelValidPoints(char[][] board, int i, int j) {
        List<Point> points = new ArrayList<>();
        Point[] arr = new Point[] { new Point(i - 1, j), new Point(i + 1, j), new Point(i, j - 1),
                new Point(i, j + 1) };
        for (Point point : arr) {
            if (isValid(board, point.x, point.y)) {
                board[point.x][point.y] = 'Y';
                points.add(point);
            }
        }
        return points;
    }

    /**
     * 判断坐标是否有效
     * @param board
     * @param i
     * @param j
     * @return boolean
     */
    private boolean isValid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        // 当前坐标对应的值是'O'，才算有效
        return i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1 && board[i][j] == 'O';
    }

}
```

### **...**

```

```

<!-- tabs:end -->
