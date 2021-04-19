# [244. 最短单词距离 II](https://leetcode-cn.com/problems/shortest-word-distance-ii)

[English Version](/solution/0200-0299/0244.Shortest%20Word%20Distance%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 <em>word1</em> 和 <em>word2，</em>并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 <em>多次</em>。</p>

<p><strong>示例:</strong><br>
假设 words = <code>["practice", "makes", "perfect", "coding", "makes"]</code></p>

<pre><strong>输入:</strong> <em>word1</em> = <code>“coding”</code>, <em>word2</em> = <code>“practice”</code>
<strong>输出:</strong> 3
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>"makes"</code>, <em>word2</em> = <code>"coding"</code>
<strong>输出:</strong> 1</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> <strong>不等于</strong> <em>word2</em>, 并且 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>

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
class WordDistance {

    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexList = map.get(words[i]) == null ? new ArrayList<>() : map.get(words[i]);
            indexList.add(i);
            map.put(words[i], indexList);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for (int l1 : list1) {
            for (int l2 : list2) {
                ans = Math.min(ans, Math.abs(l1 - l2));
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
```

### **...**

```

```

<!-- tabs:end -->
