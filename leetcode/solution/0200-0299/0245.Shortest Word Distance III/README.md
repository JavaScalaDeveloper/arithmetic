# [245. 最短单词距离 III](https://leetcode-cn.com/problems/shortest-word-distance-iii)

[English Version](/solution/0200-0299/0245.Shortest%20Word%20Distance%20III/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个单词列表和两个单词 <em>word1</em> 和 <em>word2</em>，返回列表中这两个单词之间的最短距离。</p>

<p><em>word1</em> 和 <em>word2</em> 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。</p>

<p><strong>示例:</strong><br>
假设 words = <code>["practice", "makes", "perfect", "coding", "makes"]</code>.</p>

<pre><strong>输入:</strong> <em>word1</em> = <code>“makes”</code>, <em>word2</em> = <code>“coding”</code>
<strong>输出:</strong> 1
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>"makes"</code>, <em>word2</em> = <code>"makes"</code>
<strong>输出:</strong> 3
</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>

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
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, ans = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (same) {
                if (Objects.equals(words[i], word1)) {
                    if (w1 == -1) {
                        w1 = i;
                    } else {
                        ans = Math.min(ans, i - w1);
                        w1 = i;
                    }
                }
            } else if (Objects.equals(words[i], word1)) {
                w1 = i;
                if (w2 >= 0) {
                    ans = Math.min(w1 - w2, ans);
                }
            } else if (Objects.equals(words[i], word2)) {
                w2 = i;
                if (w1 >= 0) {
                    ans = Math.min(w2 - w1, ans);
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
