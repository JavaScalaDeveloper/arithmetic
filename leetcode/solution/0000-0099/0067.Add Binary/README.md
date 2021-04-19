# [67. 二进制求和](https://leetcode-cn.com/problems/add-binary)

[English Version](/solution/0000-0099/0067.Add%20Binary/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个二进制字符串，返回他们的和（用二进制表示）。</p>

<p>输入为<strong>非空</strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
<strong>输出:</strong> &quot;100&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
<strong>输出:</strong> &quot;10101&quot;</pre>

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
    public String addBinary(String a, String b) {
        StringBuilder reverseAnswer = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0;i < maxLength;i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - 48 : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - 48 : 0;

            reverseAnswer.append(carry % 2);
            carry /= 2;
        }

        if (carry == 1) {
            reverseAnswer.append(1);
        }
        return reverseAnswer.reverse().toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
