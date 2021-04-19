# [1138. 字母板上的路径](https://leetcode-cn.com/problems/alphabet-board-path)

[English Version](/solution/1100-1199/1138.Alphabet%20Board%20Path/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>我们从一块字母板上的位置&nbsp;<code>(0, 0)</code>&nbsp;出发，该坐标对应的字符为&nbsp;<code>board[0][0]</code>。</p>

<p>在本题里，字母板为<code>board = [&quot;abcde&quot;, &quot;fghij&quot;, &quot;klmno&quot;, &quot;pqrst&quot;, &quot;uvwxy&quot;, &quot;z&quot;]</code>.</p>

<p>我们可以按下面的指令规则行动：</p>

<ul>
	<li>如果方格存在，<code>&#39;U&#39;</code>&nbsp;意味着将我们的位置上移一行；</li>
	<li>如果方格存在，<code>&#39;D&#39;</code>&nbsp;意味着将我们的位置下移一行；</li>
	<li>如果方格存在，<code>&#39;L&#39;</code>&nbsp;意味着将我们的位置左移一列；</li>
	<li>如果方格存在，<code>&#39;R&#39;</code>&nbsp;意味着将我们的位置右移一列；</li>
	<li><code>&#39;!&#39;</code>&nbsp;会把在我们当前位置 <code>(r, c)</code> 的字符&nbsp;<code>board[r][c]</code>&nbsp;添加到答案中。</li>
</ul>

<p>返回指令序列，用最小的行动次数让答案和目标&nbsp;<code>target</code>&nbsp;相同。你可以返回任何达成目标的路径。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>target = &quot;leet&quot;
<strong>输出：</strong>&quot;DDR!UURRR!!DDD!&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>target = &quot;code&quot;
<strong>输出：</strong>&quot;RR!DDRR!UUL!R!&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= target.length &lt;= 100</code></li>
	<li><code>target</code>&nbsp;仅含有小写英文字母。</li>
</ul>

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
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int dx = (c - 'a') / 5;
            int dy = (c - 'a') % 5;
            if (dy < y) {
                int n = y - dy;
                while (n-- > 0) {
                    sb.append('L');
                }
            }
            if (dx > x) {
                int n = dx - x;
                while (n-- > 0) {
                    sb.append('D');
                }
            }
            if (dx < x) {
                int n = x - dx;
                while (n-- > 0) {
                    sb.append('U');
                }
            }
            if (dy > y) {
                int n = dy - y;
                while (n-- > 0) {
                    sb.append('R');
                }
            }
            sb.append('!');
            x = dx;
            y = dy;
        }
        return sb.toString();
    }
}

```

### **...**

```

```

<!-- tabs:end -->
