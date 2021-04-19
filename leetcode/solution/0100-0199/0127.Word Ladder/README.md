# [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder)

[English Version](/solution/0100-0199/0127.Word%20Ladder/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个单词（<em>beginWord&nbsp;</em>和 <em>endWord</em>）和一个字典，找到从&nbsp;<em>beginWord</em> 到&nbsp;<em>endWord</em> 的最短转换序列的长度。转换需遵循如下规则：</p>

<ol>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典中的单词。</li>
</ol>

<p><strong>说明:</strong></p>

<ul>
	<li>如果不存在这样的转换序列，返回 0。</li>
	<li>所有单词具有相同的长度。</li>
	<li>所有单词只由小写字母组成。</li>
	<li>字典中不存在重复的单词。</li>
	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
</ul>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;,
endWord = &quot;cog&quot;,
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]

<strong>输出: </strong>5

<strong>解释: </strong>一个最短转换序列是 &quot;hit&quot; -&gt; &quot;hot&quot; -&gt; &quot;dot&quot; -&gt; &quot;dog&quot; -&gt; &quot;cog&quot;,
     返回它的长度 5。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;
endWord = &quot;cog&quot;
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]

<strong>输出:</strong>&nbsp;0

<strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以无法进行转换。</pre>

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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        
        // 需要转hashSet
        Set<String> wordSet = new HashSet<>(wordList);
        queue.offer(beginWord);
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            --curNum;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                char ch = chars[i];
                for (char j = 'a'; j <= 'z'; ++j) {
                    chars[i] = j;
                    String tmp = new String(chars);
                    // 字典中包含生成的中间字符串
                    if (wordSet.contains(tmp)) {
                        // 中间字符串与 endWord 相等
                        if (endWord.equals(tmp)) {
                            return level + 1;
                        }

                        // 中间字符串不是 endWord，则入队
                        queue.offer(tmp);
                        ++nextNum;

                        // 确保之后不会再保存 tmp 字符串
                        wordSet.remove(tmp);
                    }
                }
                chars[i] = ch;
            }

            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                ++level;
            }

        }
        
        return 0;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
