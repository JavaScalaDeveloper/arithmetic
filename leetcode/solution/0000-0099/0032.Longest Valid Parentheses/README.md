# [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses)

[English Version](/solution/0000-0099/0032.Longest%20Valid%20Parentheses/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个只包含 <code>&#39;(&#39;</code>&nbsp;和 <code>&#39;)&#39;</code>&nbsp;的字符串，找出最长的包含有效括号的子串的长度。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> &quot;(()&quot;
<strong>输出:</strong> 2
<strong>解释:</strong> 最长有效括号子串为 <code>&quot;()&quot;</code>
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot;<code>)()())</code>&quot;
<strong>输出:</strong> 4
<strong>解释:</strong> 最长有效括号子串为 <code>&quot;()()&quot;</code>
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
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[n];
        res[0] = 0;
        res[1] = chars[1] == ')' && chars[0] == '(' ? 2 : 0;
        
        int max = res[1];
        
        for (int i = 2; i < n; ++i) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    res[i] = res[i - 2] + 2;
                } else {
                    int index = i - res[i - 1] - 1;
                    if (index >= 0 && chars[index] == '(') {
                        // ()(())
                        res[i] = res[i - 1] + 2 + (index - 1 >= 0 ? res[index - 1] : 0);
                    }
                }
            }
            max = Math.max(max, res[i]);
        }
        
        return max;
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
