# [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water)

[English Version](/solution/0000-0099/0011.Container%20With%20Most%20Water/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给你 <em>n</em> 个非负整数 <em>a</em><sub>1</sub>，<em>a</em><sub>2，</sub>...，<em>a</em><sub>n，</sub>每个数代表坐标中的一个点&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 。在坐标内画 <em>n</em> 条垂直线，垂直线 <em>i</em>&nbsp;的两个端点分别为&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 和 (<em>i</em>, 0)。找出其中的两条线，使得它们与&nbsp;<em>x</em>&nbsp;轴共同构成的容器可以容纳最多的水。</p>

<p><strong>说明：</strong>你不能倾斜容器，且&nbsp;<em>n</em>&nbsp;的值至少为 2。</p>

<p>&nbsp;</p>

![](./images/question_11.jpg)

<p><small>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为&nbsp;49。</small></p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>[1,8,6,2,5,4,8,3,7]
<strong>输出：</strong>49</pre>

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
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;
        while (start < end) {
            int hs = height[start];
            int he = height[end];
            int l = end - start;
            if (hs > he) {
                maxArea = Math.max(he * l, maxArea);
                end--;
            } else {
                maxArea = Math.max(hs * l, maxArea);
                start++;
            }
        }
        return maxArea;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
