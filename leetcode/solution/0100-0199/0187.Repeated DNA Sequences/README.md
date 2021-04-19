# [187. 重复的 DNA 序列](https://leetcode-cn.com/problems/repeated-dna-sequences)

[English Version](/solution/0100-0199/0187.Repeated%20DNA%20Sequences/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：&ldquo;ACGAATTCCG&rdquo;。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。</p>

<p>编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>s = &quot;AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT&quot;
<strong>输出：</strong>[&quot;AAAAACCCCC&quot;, &quot;CCCCCAAAAA&quot;]</pre>

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
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); ++i) {
            String sub = s.substring(i - 10, i);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
