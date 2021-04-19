# [1081. 不同字符的最小子序列](https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters)

[English Version](/solution/1000-1099/1081.Smallest%20Subsequence%20of%20Distinct%20Characters/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>返回字符串 <code>text</code>&nbsp;中按字典序排列最小的子序列，该子序列包含&nbsp;<code>text</code>&nbsp;中所有不同字符一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;cdadabcc&quot;
<strong>输出：</strong>&quot;adbc&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>&quot;abcd&quot;
<strong>输出：</strong>&quot;abcd&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>&quot;ecbacba&quot;
<strong>输出：</strong>&quot;eacb&quot;
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>&quot;leetcode&quot;
<strong>输出：</strong>&quot;letcod&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= text.length &lt;= 1000</code></li>
	<li><code>text</code>&nbsp;由小写英文字母组成</li>
</ol>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题目与 316 <a href="https://leetcode-cn.com/problems/remove-duplicate-letters/">https://leetcode-cn.com/problems/remove-duplicate-letters/</a> 相同</p>

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
    public String smallestSubsequence(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            ++cnt[c - 'a'];
        }
        boolean[] vis = new boolean[26];
        char[] cs = new char[text.length()];
        int top = -1;
        for (char c : text.toCharArray()) {
            --cnt[c - 'a'];
            if (!vis[c - 'a']) {
                while (top >= 0 && c < cs[top] && cnt[cs[top] - 'a'] > 0) {
                    vis[cs[top--] - 'a'] = false;
                }
                cs[++top] = c;
                vis[c - 'a'] = true;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}

```

### **...**

```

```

<!-- tabs:end -->
