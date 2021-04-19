# [37. 解数独](https://leetcode-cn.com/problems/sudoku-solver)

[English Version](/solution/0000-0099/0037.Sudoku%20Solver/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一个程序，通过已填充的空格来解决数独问题。</p>

<p>一个数独的解法需<strong>遵循如下规则</strong>：</p>

<ol>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一行只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一列只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一个以粗实线分隔的&nbsp;<code>3x3</code>&nbsp;宫内只能出现一次。</li>
</ol>

<p>空白格用&nbsp;<code>&#39;.&#39;</code>&nbsp;表示。</p>

<p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png"></p>

<p><small>一个数独。</small></p>

<p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png"></p>

<p><small>答案被标成红色。</small></p>

<p><strong>Note:</strong></p>

<ul>
	<li>给定的数独序列只包含数字&nbsp;<code>1-9</code>&nbsp;和字符&nbsp;<code>&#39;.&#39;</code>&nbsp;。</li>
	<li>你可以假设给定的数独只有唯一解。</li>
	<li>给定数独永远是&nbsp;<code>9x9</code>&nbsp;形式的。</li>
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
    private char[][] board;
    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] subBox;

    public void solveSudoku(char[][] board) {
        this.board = board;
        this.rows = new boolean[9][9];
        this.cols = new boolean[9][9];
        this.subBox = new boolean[9][9];
        int val;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    val = board[i][j] - '0';
                    rows[i][val - 1] = true;
                    cols[j][val - 1] = true;
                    subBox[(i / 3) * 3 + j / 3][val - 1] = true;
                }
            }
        }
        fillSudoku(0, 0);
    }

    private boolean fillSudoku(int i, int j) {
        if (i == 9) return true;
        int x = i, y = j;
        if (y == 8) {
            x++;
            y = 0;
        } else y++;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (!rows[i][k - 1] && !cols[j][k - 1] && !subBox[(i / 3) * 3 + j / 3][k - 1]) {
                    rows[i][k - 1] = true;
                    cols[j][k - 1] = true;
                    subBox[(i / 3) * 3 + j / 3][k - 1] = true;
                    if (fillSudoku(x, y)) {
                        board[i][j] = (char) (k + '0');
                        return true;
                    }
                    rows[i][k - 1] = false;
                    cols[j][k - 1] = false;
                    subBox[(i / 3) * 3 + j / 3][k - 1] = false;
                }
            }
            return false;
        } else return fillSudoku(x, y);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
