# [91. 解码方法](https://leetcode-cn.com/problems/decode-ways)

[English Version](/solution/0000-0099/0091.Decode%20Ways/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>一条包含字母&nbsp;<code>A-Z</code> 的消息通过以下方式进行了编码：</p>

<pre>&#39;A&#39; -&gt; 1
&#39;B&#39; -&gt; 2
...
&#39;Z&#39; -&gt; 26
</pre>

<p>给定一个只包含数字的<strong>非空</strong>字符串，请计算解码方法的总数。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;12&quot;
<strong>输出:</strong> 2
<strong>解释:</strong>&nbsp;它可以解码为 &quot;AB&quot;（1 2）或者 &quot;L&quot;（12）。
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> &quot;226&quot;
<strong>输出:</strong> 3
<strong>解释:</strong>&nbsp;它可以解码为 &quot;BZ&quot; (2 26), &quot;VF&quot; (22 6), 或者 &quot;BBF&quot; (2 2 6) 。
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
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int current = s.charAt(0) == '0' ? 0 : 1;
        int last = 1;
        for (int i = 1; i < len; i++) {
            int tmp = current;
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') current = last;
                else return 0;
            }else if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                current += last;
            }
            last = tmp;
        }
        return current;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
