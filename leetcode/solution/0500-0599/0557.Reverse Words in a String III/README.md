# [557. 反转字符串中的单词 III](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii)

[English Version](/solution/0500-0599/0557.Reverse%20Words%20in%20a%20String%20III/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
输入: &quot;Let&#39;s take LeetCode contest&quot;
输出: &quot;s&#39;teL ekat edoCteeL tsetnoc&quot;<strong><strong><strong>&nbsp;</strong></strong></strong>
</pre>

<p><strong><strong><strong><strong>注意：</strong></strong></strong></strong>在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。</p>

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
    public String reverseWords(String s) {
        String flag = " ";
        StringBuilder result = new StringBuilder();
        for (String temp : s.split(flag)) {
            for (int i = temp.length() - 1; i >= 0; i--) {
                result.append(temp.charAt(i));
            }
            result.append(flag);
        }
        return result.toString().substring(0, s.length());
    }
}
```

### **...**

```

```

<!-- tabs:end -->
