# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)

[English Version](/solution/0000-0099/0003.Longest%20Substring%20Without%20Repeating%20Characters/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入: </strong>&quot;abcabcbb&quot;
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入: </strong>&quot;bbbbb&quot;
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>&quot;b&quot;</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入: </strong>&quot;pwwkew&quot;
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
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
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int fast = 0, slow = 0; fast < s.length(); fast ++) {
            if (map.containsKey(s.charAt(fast))) {
                int target = map.get(s.charAt(fast)) + 1;
                slow = target < slow ? slow : target;
            }
            map.put(s.charAt(fast), fast);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
