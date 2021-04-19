# [面试题 01.04. 回文排列](https://leetcode-cn.com/problems/palindrome-permutation-lcci)

[English Version](/lcci/01.04.Palindrome%20Permutation/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。</p>

<p>回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。</p>

<p>回文串不一定是字典当中的单词。</p>

<p>&nbsp;</p>

<p><strong>示例1：</strong></p>

<pre><strong>输入：&quot;</strong>tactcoa&quot;
<strong>输出：</strong>true（排列有&quot;tacocat&quot;、&quot;atcocta&quot;，等等）
</pre>

<p>&nbsp;</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

用哈希表存储每个字符出现的次数。若次数为奇数的字符超过 1 个，则不是回文排列。

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        if s is None or len(s) < 2:
            return True
        cache = {}
        for ch in s:
            cache[ch] = 1 if cache.get(ch) is None else cache[ch] + 1
        cnt = 0
        for k, v in cache.items():
            if (v & 1) == 1:
                cnt += 1
            if cnt > 1:
                return False
        return cnt <= 1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : chars) {
            counter.put(ch, counter.get(ch) == null ? 1 : counter.get(ch) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                ++cnt;
            }
            if (cnt > 1) {
                return false;
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
