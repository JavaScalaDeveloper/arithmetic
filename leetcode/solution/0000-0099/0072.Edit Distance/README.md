# [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance)

[English Version](/solution/0000-0099/0072.Edit%20Distance/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个单词&nbsp;<em>word1</em> 和&nbsp;<em>word2</em>，计算出将&nbsp;<em>word1</em>&nbsp;转换成&nbsp;<em>word2 </em>所使用的最少操作数&nbsp;。</p>

<p>你可以对一个单词进行如下三种操作：</p>

<ol>
	<li>插入一个字符</li>
	<li>删除一个字符</li>
	<li>替换一个字符</li>
</ol>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
<strong>输出:</strong> 3
<strong>解释:</strong> 
horse -&gt; rorse (将 &#39;h&#39; 替换为 &#39;r&#39;)
rorse -&gt; rose (删除 &#39;r&#39;)
rose -&gt; ros (删除 &#39;e&#39;)
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
<strong>输出:</strong> 5
<strong>解释:</strong> 
intention -&gt; inention (删除 &#39;t&#39;)
inention -&gt; enention (将 &#39;i&#39; 替换为 &#39;e&#39;)
enention -&gt; exention (将 &#39;n&#39; 替换为 &#39;x&#39;)
exention -&gt; exection (将 &#39;n&#39; 替换为 &#39;c&#39;)
exection -&gt; execution (插入 &#39;u&#39;)
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
    public int minDistance(String word1, String word2) {
        return edit(word1.length(),word2.length(),word1,word2,new int[word1.length()+1][word2.length()+1]);
    }
    private int edit(int l, int r, String w1, String w2, int[][] dp){
        if(l==0) return r;
        if(r==0) return l;
        if(dp[l][r]!=0) return dp[l][r];
        int min = (w1.charAt(l-1)!=w2.charAt(r-1)) ?
                Math.min(edit(l-1,r-1,w1,w2,dp)+1,Math.min(edit(l-1,r,w1,w2,dp)+1,edit(l,r-1,w1,w2,dp)+1))
                : edit(l - 1, r - 1, w1, w2, dp);
        dp[l][r] = min;
        return min;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
