# [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii)

[English Version](/solution/0000-0099/0063.Unique%20Paths%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>一个机器人位于一个 <em>m x n </em>网格的左上角 （起始点在下图中标记为&ldquo;Start&rdquo; ）。</p>

<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为&ldquo;Finish&rdquo;）。</p>

<p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>

![](./images/robot_maze.png)

<p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>

<p><strong>说明：</strong><em>m</em>&nbsp;和 <em>n </em>的值均不超过 100。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:
</strong>[
&nbsp; [0,0,0],
&nbsp; [0,1,0],
&nbsp; [0,0,0]
]
<strong>输出:</strong> 2
<strong>解释:</strong>
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 <code>2</code> 条不同的路径：
1. 向右 -&gt; 向右 -&gt; 向下 -&gt; 向下
2. 向下 -&gt; 向下 -&gt; 向右 -&gt; 向右
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### **Go**

````go
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    m,n := len(obstacleGrid),len(obstacleGrid[0])
    dp := make([][]int,m)
    for i:=0; i < m;i++ {
        dp[i] = make([]int,n)
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if obstacleGrid[i][j] == 0 {
                if i == 0 && j == 0 {
                    dp[i][j] = 1
                } else if i > 0 && j >0 {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j]
                } else if i > 0 {
                    dp[i][j] = dp[i-1][j]
                } else {
                    dp[i][j] = dp[i][j-1]
                }
            }
        }
    }
    return dp[m-1][n-1]
}


<!-- tabs:start -->

### **Python3**
<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

````

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int column = obstacleGrid[0].length, row = obstacleGrid.length;
        int[][] dp = new int[row][column];
        // 第一行
        for (int i = 0; i < column; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        // 第一列
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        // dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row - 1][column - 1];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
