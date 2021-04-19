# [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses)

[English Version](/solution/0000-0099/0022.Generate%20Parentheses/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给出&nbsp;<em>n</em>&nbsp;代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且<strong>有效的</strong>括号组合。</p>

<p>例如，给出&nbsp;<em>n </em>=<em> </em>3，生成结果为：</p>

<pre>[
  &quot;((()))&quot;,
  &quot;(()())&quot;,
  &quot;(())()&quot;,
  &quot;()(())&quot;,
  &quot;()()()&quot;
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
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String ans, int l, int r, int length) {
        if (ans.length() == length * 2) {
            res.add(ans);
            return;
        }
        if (l < length) {
            dfs(res, ans + "(", l + 1, r, length);
        }
        if (r < l) {
            dfs(res, ans + ")", l, r + 1, length);
        }
    }
}

```

### **...**

```

```

<!-- tabs:end -->
