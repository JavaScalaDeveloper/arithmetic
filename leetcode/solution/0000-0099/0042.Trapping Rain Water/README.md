# [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water)

[English Version](/solution/0000-0099/0042.Trapping%20Rain%20Water/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定&nbsp;<em>n</em> 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

![](./images/rainwatertrap.png)

<p><small>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。&nbsp;<strong>感谢 Marcos</strong> 贡献此图。</small></p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [0,1,0,2,1,0,1,3,2,1,2,1]
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
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lx = 0, rx = height.length - 1, l = height[lx], r = height[rx], re = 0;
        while (lx < rx) {
            if (l < r) {
                lx++;
                if (height[lx] < l) re += l - height[lx];
                else l = height[lx];
            } else {
                rx--;
                if (height[rx] < r) re += r - height[rx];
                else r = height[rx];
            }
        }
        return re;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
