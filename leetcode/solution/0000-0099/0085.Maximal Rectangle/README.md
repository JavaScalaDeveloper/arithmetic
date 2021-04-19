# [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle)

[English Version](/solution/0000-0099/0085.Maximal%20Rectangle/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个仅包含&nbsp;0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>
[
  [&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;0&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;],
  [&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;]
]
<strong>输出:</strong> 6</pre>

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
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int result = 0;
        int[] row = new int[matrix[0].length];
        for(char[] line : matrix){
            update(line,row);
            result = Math.max(result, largestRectangleArea(row));
        }
        return result;
    }
    private int largestRectangleArea(int[] heights) {
        int[] stack = new int[1 << 10];
        int length = heights.length;
        int j, stackSize= 0, ma = 0, a;
        for (int i = 0; i <= length; i++) {
            while (stackSize > 0 &&( i==length || heights[i] < heights[stack[stackSize - 1]])) {
                j = stack[--stackSize];
                a = (i - (stackSize == 0 ? 0 : stack[stackSize - 1] + 1)) * (heights[j]);
                if (a > ma) ma = a;
            }
            stack[stackSize++] = i;
        }
        return ma;
    }
    private void update(char[] line, int[] row){
        for (int i = 0; i < row.length; i++) {
            if (line[i] == '0') row[i] = 0;
            else row[i]++;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
