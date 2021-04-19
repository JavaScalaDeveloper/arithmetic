# [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring)

[English Version](/solution/0000-0099/0076.Minimum%20Window%20Substring/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。</p>

<p><strong>示例：</strong></p>

<pre><strong>输入: S</strong> = &quot;ADOBECODEBANC&quot;, <strong>T</strong> = &quot;ABC&quot;
<strong>输出:</strong> &quot;BANC&quot;</pre>

<p><strong>说明：</strong></p>

<ul>
	<li>如果 S 中不存这样的子串，则返回空字符串 <code>&quot;&quot;</code>。</li>
	<li>如果 S 中存在这样的子串，我们保证它是唯一的答案。</li>
</ul>

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
    public String minWindow(String s, String t) {
        int[] count = new int['z' - 'A' + 1];
        int uniq = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (++count[t.charAt(i) - 'A'] == 1) uniq++;
        }
        int found = 0,i = 0,j = 0;
        int minLen = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        while (found < uniq) {
            while (i < s.length()) {
                if (found >= uniq) break;
                if (--count[s.charAt(i) - 'A'] == 0) found++;
                i++;
            }
            if (found < uniq) break;
            while (j < i && count[s.charAt(j) - 'A'] < 0) count[s.charAt(j++) - 'A']++;
            if (i - j < minLen) {
                minLen = i - j;
                minJ = j;
            }
            count[s.charAt(j++) - 'A']++;
            found--;
        }
        return minLen < Integer.MAX_VALUE ? s.substring(minJ, minJ + minLen) : "";
    }
}
```

### **...**

```

```

<!-- tabs:end -->
