# [522. 最长特殊序列 II](https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii)

[English Version](/solution/0500-0599/0522.Longest%20Uncommon%20Subsequence%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。</p>

<p><strong>子序列</strong>可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。</p>

<p>输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入:</strong> &quot;aba&quot;, &quot;cdc&quot;, &quot;eae&quot;
<strong>输出:</strong> 3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li>所有给定的字符串长度不会超过 10 。</li>
	<li>给定字符串列表的长度将在 [2, 50 ] 之间。</li>
</ol>

<p>&nbsp;</p>

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
    public int findLUSlength(String[] strs) {
        int res = -1;
        if (strs == null || strs.length == 0) {
            return res;
        }
        if (strs.length == 1) {
            return strs[0].length();
        }
        // 两两比较
        // 1、存在子串,直接不比较后面的字符串
        // 2、不存在子串,判断当前字符串是否是最长的字符串
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                // 根据题意，子串 可以 不是 原字符串中 连续的子字符串
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i))
                j++;
        }
        return j == x.length();
    }
}

```

### **...**

```

```

<!-- tabs:end -->
