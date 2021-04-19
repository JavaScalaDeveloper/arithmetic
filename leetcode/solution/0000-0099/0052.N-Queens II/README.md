# [52. N 皇后 II](https://leetcode-cn.com/problems/n-queens-ii)

[English Version](/solution/0000-0099/0052.N-Queens%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p><em>n&nbsp;</em>皇后问题研究的是如何将 <em>n</em>&nbsp;个皇后放置在 <em>n</em>&times;<em>n</em> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>

![](./images/8-queens.png)

<p><small>上图为 8 皇后问题的一种解法。</small></p>

<p>给定一个整数 <em>n</em>，返回 <em>n</em> 皇后不同的解决方案的数量。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 4
<strong>输出:</strong> 2
<strong>解释:</strong> 4 皇后问题存在如下两个不同的解法。
[
&nbsp;[&quot;.Q..&quot;, &nbsp;// 解法 1
&nbsp; &quot;...Q&quot;,
&nbsp; &quot;Q...&quot;,
&nbsp; &quot;..Q.&quot;],

&nbsp;[&quot;..Q.&quot;, &nbsp;// 解法 2
&nbsp; &quot;Q...&quot;,
&nbsp; &quot;...Q&quot;,
&nbsp; &quot;.Q..&quot;]
]
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

    int count = 0;

    public int totalNQueens(int n) {
        int[] c = new int[n];
        search(0, n, c);
        return count;
    }

    public void search(int cur, int n, int[] c) {
        if (cur == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            c[cur] = i;
            for (int j = 0; j < cur; j++) {
                if ((c[cur] == c[j]) || ((c[cur] - cur) == (c[j] - j)) || ((c[cur] + cur) == (c[j] + j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) search(cur + 1, n, c);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
