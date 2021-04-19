# [541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii)

[English Version](/solution/0500-0599/0541.Reverse%20String%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
<strong>输出:</strong> &quot;bacdfeg&quot;
</pre>

<p><strong>要求:</strong></p>

<ol>
	<li>该字符串只包含小写的英文字母。</li>
	<li>给定字符串的长度和 k 在[1, 10000]范围内。</li>
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
    public String reverseStr(String s, int k) {
        if (k < 2) return s;
        StringBuilder sb = new StringBuilder();
        int length = s.length(), index = 0;
        while (index < length) {
            if (index + 2 * k <= length) {
                sb.append(reverse(s, index, index + k));
                sb.append(s.substring(index + k, index + 2 * k));
                index += 2 * k;
            } else if (index + k <= length){
                sb.append(reverse(s, index, index + k));
                sb.append(s.substring(index + k));
                break;
            } else {
                sb.append(reverse(s, index, length));
                break;
            }
        }
        return sb.toString();
    }

    private StringBuffer reverse(String s, int index, int end) {
        return new StringBuffer(s.substring(index, end)).reverse();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
