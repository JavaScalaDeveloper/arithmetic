# [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii)

[English Version](/solution/0200-0299/0264.Ugly%20Number%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一个程序，找出第 <code>n</code> 个丑数。</p>

<p>丑数就是只包含质因数&nbsp;<code>2, 3, 5</code> 的<strong>正整数</strong>。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> n = 10
<strong>输出:</strong> 12
<strong>解释: </strong><code>1, 2, 3, 4, 5, 6, 8, 9, 10, 12</code> 是前 10 个丑数。</pre>

<p><strong>说明:&nbsp;</strong>&nbsp;</p>

<ol>
	<li><code>1</code>&nbsp;是丑数。</li>
	<li><code>n</code>&nbsp;<strong>不超过</strong>1690。</li>
</ol>

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
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int idx = 1; idx < n; ++idx) {
            int t = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            dp[idx] = t;
            if (dp[i] * 2 == t) ++i;
            if (dp[j] * 3 == t) ++j;
            if (dp[k] * 5 == t) ++k;
        }
        return dp[n - 1];
    }
}

```

### **...**

```

```

<!-- tabs:end -->
