# [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square)

[English Version](/solution/0200-0299/0221.Maximal%20Square/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入: 
</strong>
1 0 1 0 0
1 0 <strong>1 1</strong> 1
1 1 <strong>1 1 </strong>1
1 0 0 1 0

<strong>输出: </strong>4</pre>

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
public class Solution {
    public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int mx = matrix.length;
		int my = matrix[0].length;

		int[][] dp = new int[mx][my];
		int max = 0;

		// 初始化第0行
		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
				max = 1;
			}
		}

		// 初始化第0列
		for (int i = 1; i < mx; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				max = 1;
			}
		}

		// dp[x][y]=min(dp[x-1][y],dp[x][y-1],dp[x-1][y-1])+1
		for (int x = 1; x < mx; x++) {
			for (int y = 1; y < my; y++) {

				if (matrix[x][y] == '1') {
					dp[x][y] = Math.min(Math.min(dp[x - 1][y], dp[x][y - 1]),
							dp[x - 1][y - 1]) + 1;
					max = Math.max(max, dp[x][y]);
				}

			}
		}

		return max * max;
	
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
