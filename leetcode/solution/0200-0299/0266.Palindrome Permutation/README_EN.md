# [266. Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation)

[中文文档](/solution/0200-0299/0266.Palindrome%20Permutation/README.md)

## Description

<p>Given a string, determine if a permutation of the string could form a palindrome.</p>

<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> <code>"code"</code>
<strong>Output:</strong> false</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> <code>"aab"</code>
<strong>Output:</strong> true</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> <code>"carerac"</code>
<strong>Output:</strong> true</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        mapper = {}
        for ch in s:
            mapper[ch] = mapper.get(ch, 0) + 1
        cnt = 0
        for _, v in mapper.items():
            if v % 2 != 0:
                cnt += 1
        return cnt <= 1
```

### **Java**

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, n = s.length(); i < n; ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                ++cnt;
            }
        }
        return cnt <= 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
