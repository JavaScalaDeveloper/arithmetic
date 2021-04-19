# [43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings)

[English Version](/solution/0000-0099/0043.Multiply%20Strings/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个以字符串形式表示的非负整数&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>，返回&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的乘积，它们的乘积也表示为字符串形式。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> num1 = &quot;2&quot;, num2 = &quot;3&quot;
<strong>输出:</strong> &quot;6&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> num1 = &quot;123&quot;, num2 = &quot;456&quot;
<strong>输出:</strong> &quot;56088&quot;</pre>

<p><strong>说明：</strong></p>

<ol>
	<li><code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的长度小于110。</li>
	<li><code>num1</code> 和&nbsp;<code>num2</code> 只包含数字&nbsp;<code>0-9</code>。</li>
	<li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;均不以零开头，除非是数字 0 本身。</li>
	<li><strong>不能使用任何标准库的大数类型（比如 BigInteger）</strong>或<strong>直接将输入转换为整数来处理</strong>。</li>
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
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray(),chars2 = num2.toCharArray();
        int[] result = new int[chars1.length+chars2.length];
        int pow = result.length-1;
        for (int i = chars1.length - 1; i >= 0; i--) {
            int a = chars1[i] - '0';
            int j = 0,bit = pow;
            for (int i1 = chars2.length - 1; i1 >= 0; i1--) {
                int b = chars2[i1] -'0';
                j = a*b + j + result[bit];
                result[bit--] = j%10;
                j = j/10;
            }
            while (j!=0){
                j += result[bit];
                result[bit--] = j%10;
                j = j/10;
            }
            pow--;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i < result.length; i++) if (result[i] != 0) break;
        for (; i < result.length; i++) builder.append(result[i]);
        return builder.length()==0? "0" : builder.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
