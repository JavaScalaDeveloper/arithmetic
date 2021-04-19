# [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii)

[English Version](/solution/0100-0199/0126.Word%20Ladder%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个单词（<em>beginWord</em> 和 <em>endWord</em>）和一个字典 <em>wordList</em>，找出所有从 <em>beginWord </em>到 <em>endWord </em>的最短转换序列。转换需遵循如下规则：</p>

<ol>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典中的单词。</li>
</ol>

<p><strong>说明:</strong></p>

<ul>
	<li>如果不存在这样的转换序列，返回一个空列表。</li>
	<li>所有单词具有相同的长度。</li>
	<li>所有单词只由小写字母组成。</li>
	<li>字典中不存在重复的单词。</li>
	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
</ul>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;,
endWord = &quot;cog&quot;,
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]

<strong>输出:</strong>
[
  [&quot;hit&quot;,&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;cog&quot;],
&nbsp; [&quot;hit&quot;,&quot;hot&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
]
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;
endWord = &quot;cog&quot;
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]

<strong>输出: </strong>[]

<strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以不存在符合要求的转换序列。</pre>

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
    private boolean isConnected = false;
    private Map<String, List<String>> hs;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        hs = new HashMap<>(16);
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord))
            return result;
        HashSet<String> dict = new HashSet<>(wordList);
        Set<String> fwd = new HashSet<>();
        fwd.add(beginWord);
        Set<String> bwd = new HashSet<>();
        bwd.add(endWord);
        bfs(fwd, bwd, dict, false);
        if(!isConnected) return result;
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(result, temp, beginWord, endWord);
        return result;
    }
    private void bfs(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap){
        if(forward.isEmpty() || backward.isEmpty()) return;
        if(forward.size() > backward.size()){
            bfs(backward, forward, dict, !swap);
            return;
        }
        dict.removeAll(forward);
        dict.removeAll(backward);
        Set<String> set3 = new HashSet<>();
        for(String str : forward)
            for (int i = 0; i < str.length(); i++) {
                char[] ary = str.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ary[i] = j;
                    String temp = new String(ary);
                    if (!backward.contains(temp) && !dict.contains(temp)) continue;
                    String key = !swap ? str : temp;
                    String val = !swap ? temp : str;
                    if (!hs.containsKey(key)) hs.put(key, new ArrayList<>());
                    if (backward.contains(temp)) {
                        hs.get(key).add(val);
                        isConnected = true;
                    }
                    if (!isConnected && dict.contains(temp)) {
                        hs.get(key).add(val);
                        set3.add(temp);
                    }
                }
            }
        if(!isConnected) bfs(set3, backward, dict, swap);
    }
    private void dfs(List<List<String>> result, List<String> temp, String start, String end){
        if(start.equals(end)){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(!hs.containsKey(start)) return;
        for(String s : hs.get(start)){
            temp.add(s);
            dfs(result, temp, s, end);
            temp.remove(temp.size()-1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
