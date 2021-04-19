# [171. Excel 表列序号](https://leetcode-cn.com/problems/excel-sheet-column-number)

[English Version](/solution/0100-0199/0171.Excel%20Sheet%20Column%20Number/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个Excel表格中的列名称，返回其相应的列序号。</p>

<p>例如，</p>

<pre>    A -&gt; 1
    B -&gt; 2
    C -&gt; 3
    ...
    Z -&gt; 26
    AA -&gt; 27
    AB -&gt; 28 
    ...
</pre>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;A&quot;
<strong>输出:</strong> 1
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入: </strong>&quot;AB&quot;
<strong>输出:</strong> 28
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入: </strong>&quot;ZY&quot;
<strong>输出:</strong> 701</pre>

<p><strong>致谢：</strong><br>
特别感谢&nbsp;<a href="http://leetcode.com/discuss/user/ts">@ts</a>&nbsp;添加此问题并创建所有测试用例。</p>

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
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int n = 0;
        int p = 1;
        for (int i = cs.length-1; i >= 0; i--) {
            n += (cs[i]-'A'+1)*p;
            p *= 26;
        }
        return n;
    }
}
```

### **...**

```

```

<!-- tabs:end -->