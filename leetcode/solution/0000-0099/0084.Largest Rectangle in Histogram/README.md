# [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)

[English Version](/solution/0000-0099/0084.Largest%20Rectangle%20in%20Histogram/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定 <em>n</em> 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>

<p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>

<p>&nbsp;</p>

![](./images/histogram.png)

<p><small>以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为&nbsp;<code>[2,1,5,6,2,3]</code>。</small></p>

<p>&nbsp;</p>

![](./images/histogram_area.png)

<p><small>图中阴影部分为所能勾勒出的最大矩形面积，其面积为&nbsp;<code>10</code>&nbsp;个单位。</small></p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [2,1,5,6,2,3]
<strong>输出:</strong> 10</pre>

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
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }

        // 创建一个新的数组，数组长度为 n + 1，最后一个元素值赋为 0
        // 确保在后面的遍历中，原数组最后一个元素值能得到计算
        int[] heightss = new int[n + 1];
        heightss[n] = 0;
        for (int i = 0; i < n; ++i) {
            heightss[i] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n;) {
            if (stack.isEmpty() || heightss[i] > heightss[stack.peek()]) {
                stack.push(i++);
            } else {
                int index = stack.pop();
                max = Math.max(max, heightss[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        return max;

    }
}
```

### **...**

```

```

<!-- tabs:end -->
