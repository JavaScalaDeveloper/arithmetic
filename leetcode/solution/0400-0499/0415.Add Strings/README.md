# [415. 字符串相加](https://leetcode-cn.com/problems/add-strings)

[English Version](/solution/0400-0499/0415.Add%20Strings/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个字符串形式的非负整数&nbsp;<code>num1</code> 和<code>num2</code>&nbsp;，计算它们的和。</p>

<p><strong>注意：</strong></p>

<ol>
	<li><code>num1</code> 和<code>num2</code>&nbsp;的长度都小于 5100.</li>
	<li><code>num1</code> 和<code>num2</code> 都只包含数字&nbsp;<code>0-9</code>.</li>
	<li><code>num1</code> 和<code>num2</code> 都不包含任何前导零。</li>
	<li><strong>你不能使用任何內建 BigInteger 库，&nbsp;也不能直接将输入的字符串转换为整数形式。</strong></li>
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
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += (i >= 0 ? num1.charAt(i--) - '0' : 0) + (j >= 0 ? num2.charAt(j--) - '0' : 0);
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}

```

### **...**

```

```

<!-- tabs:end -->
