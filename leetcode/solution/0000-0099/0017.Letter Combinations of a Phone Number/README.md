# [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number)

[English Version](/solution/0000-0099/0017.Letter%20Combinations%20of%20a%20Phone%20Number/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

![](./images/17_telephone_keypad.png)

<p><strong>示例:</strong></p>

<pre><strong>输入：</strong>&quot;23&quot;
<strong>输出：</strong>[&quot;ad&quot;, &quot;ae&quot;, &quot;af&quot;, &quot;bd&quot;, &quot;be&quot;, &quot;bf&quot;, &quot;cd&quot;, &quot;ce&quot;, &quot;cf&quot;].
</pre>

<p><strong>说明:</strong><br>
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。</p>

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
    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        List<String> result = new ArrayList<>();
        for (char a : cs) {
            char[] charArray;
            switch (a) {
                case '2': charArray = new char[]{'a','b','c'}; break;
                case '3': charArray = new char[]{'d','e','f'}; break;
                case '4': charArray = new char[]{'g','h','i'}; break;
                case '5': charArray = new char[]{'j','k','l'}; break;
                case '6': charArray = new char[]{'m','n','o'}; break;
                case '7': charArray = new char[]{'p','q','r','s'}; break;
                case '8': charArray = new char[]{'t','u','v'}; break;
                case '9': charArray = new char[]{'w','x','y','z'}; break;
                default: return null;
            }
            if (result.size() == 0) {
                for (char aCharArray : charArray) result.add(String.valueOf(aCharArray));
            } else {
                List<String> cache = new ArrayList<>();
                for (String string : result) {
                    for (char aCharArray : charArray) cache.add(string + aCharArray);
                }
                result = cache;
            }
        }
        return result;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
