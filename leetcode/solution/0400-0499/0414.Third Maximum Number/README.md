# [414. 第三大的数](https://leetcode-cn.com/problems/third-maximum-number)

[English Version](/solution/0400-0499/0414.Third%20Maximum%20Number/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [3, 2, 1]

<strong>输出:</strong> 1

<strong>解释:</strong> 第三大的数是 1.
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> [1, 2]

<strong>输出:</strong> 2

<strong>解释:</strong> 第三大的数不存在, 所以返回最大的数 2 .
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> [2, 2, 3, 1]

<strong>输出:</strong> 1

<strong>解释:</strong> 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
</pre>

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
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        for (int x : nums) {
            if (x == m1 || x == m2 || x == m3) {
                continue;
            }
            if (x > m1) {
                m3 = m2;
                m2 = m1;
                m1 = x;
            } else if (x > m2) {
                m3 = m2;
                m2 = x;
            } else if (x > m3) {
                m3 = x;
            }
        }
        return (int) (m3 != Long.MIN_VALUE ? m3 : m1);
    }
}

```

### **...**

```

```

<!-- tabs:end -->
