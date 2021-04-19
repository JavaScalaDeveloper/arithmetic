# [58. Length of Last Word](https://leetcode.com/problems/length-of-last-word)

[中文文档](/solution/0000-0099/0058.Length%20of%20Last%20Word/README.md)

## Description

<p>Given a string <i>s</i> consists of upper/lower-case alphabets and empty space characters <code>&#39; &#39;</code>, return the length of last word (last word means the last appearing word if we loop from left to right) in the string.</p>

<p>If the last word does not exist, return 0.</p>

<p><b>Note:</b> A word is defined as a <strong>maximal substring</strong> consisting&nbsp;of non-space characters only.</p>

<p><b>Example:</b></p>

<pre>
<b>Input:</b> &quot;Hello World&quot;
<b>Output:</b> 5
</pre>

<p>&nbsp;</p>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        last_word_length = 0
        meet_word = False
        for i in range(len(s) - 1, -1, -1):
            ch = ord(s[i])
            if ch >= 65 and ch <= 122:
                meet_word = True
                last_word_length += 1
            elif meet_word:
                break
        return last_word_length
```

### **Java**

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int lastWordLength = 0;
        boolean meetWord = false;
        for (int i = n - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'z') {
                meetWord = true;
                ++lastWordLength;
            } else if (meetWord) {
                break;
            }
        }
        return lastWordLength;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
