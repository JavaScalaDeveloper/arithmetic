# [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix)

[English Version](/solution/0000-0099/0014.Longest%20Common%20Prefix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>

<p>如果不存在公共前缀，返回空字符串&nbsp;<code>&quot;&quot;</code>。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入: </strong>[&quot;flower&quot;,&quot;flow&quot;,&quot;flight&quot;]
<strong>输出:</strong> &quot;fl&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入: </strong>[&quot;dog&quot;,&quot;racecar&quot;,&quot;car&quot;]
<strong>输出:</strong> &quot;&quot;
<strong>解释:</strong> 输入不存在公共前缀。
</pre>

<p><strong>说明:</strong></p>

<p>所有输入只包含小写字母&nbsp;<code>a-z</code>&nbsp;。</p>

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
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        char[] chars = strs[0].toCharArray();
        int i = 0;
        boolean flag = true;
        for (; i < chars.length; ++i) {
            char ch = chars[i];
            
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() <= i) {
                    flag = false;
                    break;
                }
                if (strs[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
                
            }
            if (!flag) {
                break;
            }
        }
        return strs[0].substring(0, i);
        
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
