# [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring)

[English Version](/solution/0000-0099/0005.Longest%20Palindromic%20Substring/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。你可以假设&nbsp;<code>s</code> 的最大长度为 1000。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> &quot;babad&quot;
<strong>输出:</strong> &quot;bab&quot;
<strong>注意:</strong> &quot;aba&quot; 也是一个有效答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> &quot;cbbd&quot;
<strong>输出:</strong> &quot;bb&quot;
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
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String str = "";
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] res = new boolean[len][len];
        int start = 0;
        int max = 1;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {

                res[j][i] = i - j < 2 ? chars[j] == chars[i] : res[j + 1][i - 1] && chars[j] == chars[i];

                if (res[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                }

            }
        }

        return s.substring(start, start + max);

    }
}
```

### **...**

```

```

<!-- tabs:end -->
