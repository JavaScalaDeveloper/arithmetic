# [999. Available Captures for Rook](https://leetcode.com/problems/available-captures-for-rook)

[中文文档](/solution/0900-0999/0999.Available%20Captures%20for%20Rook/README.md)

## Description

<p>On an 8 x 8 chessboard, there is one white rook.&nbsp; There also may be empty squares, white bishops, and black pawns.&nbsp; These are given as characters &#39;R&#39;, &#39;.&#39;, &#39;B&#39;, and &#39;p&#39; respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.</p>

<p>The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.&nbsp; Also, rooks cannot move into the same square as other friendly bishops.</p>

<p>Return the number of pawns the rook can capture in one move.</p>

<p>&nbsp;</p>

<p><strong>Example 1:</strong></p>

![](./images/1253_example_1_improved.png)

<pre>

<strong>Input: </strong><span id="example-input-1-1">[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;R&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]</span>

<strong>Output: </strong><span id="example-output-1">3</span>

<strong>Explanation: </strong>

In this example the rook is able to capture all the pawns.

</pre>

<p><strong>Example 2:</strong></p>

![](./images/1253_example_2_improved.png)

<pre>

<strong>Input: </strong><span id="example-input-2-1">[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;B&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;B&quot;,&quot;R&quot;,&quot;B&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;B&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]</span>

<strong>Output: </strong><span id="example-output-2">0</span>

<strong>Explanation: </strong>

Bishops are blocking the rook to capture any pawn.

</pre>

<p><strong>Example 3:</strong></p>

![](./images/1253_example_3_improved.png)

<pre>

<strong>Input: </strong><span id="example-input-3-1">[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;R&quot;,&quot;.&quot;,&quot;p&quot;,&quot;B&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;B&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]</span>

<strong>Output: </strong><span id="example-output-3">3</span>

<strong>Explanation: </strong>

The rook can capture the pawns at positions b5, d6 and f5.

</pre>

<p>&nbsp;</p>

<p><strong>Note:</strong></p>

1. `board.length == board[i].length == 8`
2. `board[i][j]` is either `'R'`, `'.'`, `'B'` or `'p'`
3. There is exactly one cell with `board[i][j] == 'R'`

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:

        def search(board, i, j, direction):
            while i >= 0 and i < 8 and j >= 0 and j < 8:
                if board[i][j] == 'B': return 0
                if board[i][j] == 'p': return 1
                i += direction[0]
                j += direction[1]
            return 0
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        res = 0;
        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    for direction in directions:
                        res += search(board, i, j, direction)
                    return res
```

### **Java**

```java
class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int res = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    for (int[] direction : directions) {
                        res += search(board, i, j, direction);
                    }
                    return res;
                }
            }
        }
        return res;
    }

    private int search(char[][] board, int i, int j, int[] direction) {
        while (i >= 0 && i < 8 && j >= 0 && j < 8) {
            if (board[i][j] == 'B') return 0;
            if (board[i][j] == 'p') return 1;
            i += direction[0];
            j += direction[1];
        }
        return 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
