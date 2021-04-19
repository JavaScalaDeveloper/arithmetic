# [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement)

[English Version](/solution/0400-0499/0424.Longest%20Repeating%20Character%20Replacement/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换&nbsp;<em>k&nbsp;</em>次。在执行上述操作后，找到包含重复字母的最长子串的长度。</p>

<p><strong>注意:</strong><br>
字符串长度 和 <em>k </em>不会超过&nbsp;10<sup>4</sup>。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
s = &quot;ABAB&quot;, k = 2

<strong>输出:</strong>
4

<strong>解释:</strong>
用两个&#39;A&#39;替换为两个&#39;B&#39;,反之亦然。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
s = &quot;AABABBA&quot;, k = 1

<strong>输出:</strong>
4

<strong>解释:</strong>
将中间的一个&#39;A&#39;替换为&#39;B&#39;,字符串变为 &quot;AABBBBA&quot;。
子串 &quot;BBBB&quot; 有最长重复字母, 答案为 4。
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
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] map = new int[26];
        int res = 0;
        int max = 0;
        for (int l = 0, r = 0; r < cs.length; ) {
            max = Math.max(max, ++map[cs[r++] - 'A']);
            while (r - l - max > k) {
                --map[cs[l++] - 'A'];
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
