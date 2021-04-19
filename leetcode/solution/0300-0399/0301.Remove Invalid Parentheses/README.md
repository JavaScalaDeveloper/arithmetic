# [301. 删除无效的括号](https://leetcode-cn.com/problems/remove-invalid-parentheses)

[English Version](/solution/0300-0399/0301.Remove%20Invalid%20Parentheses/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。</p>

<p><strong>说明:</strong> 输入可能包含了除&nbsp;<code>(</code>&nbsp;和&nbsp;<code>)</code>&nbsp;以外的字符。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;()())()&quot;
<strong>输出:</strong> [&quot;()()()&quot;, &quot;(())()&quot;]
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot;(a)())()&quot;
<strong>输出:</strong> [&quot;(a)()()&quot;, &quot;(a())()&quot;]
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> &quot;)(&quot;
<strong>输出: </strong>[&quot;&quot;]</pre>

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
    public List<String> removeInvalidParentheses(String s) {
        // 最终结果去重
        HashSet<String> set = new HashSet<>();
        // 先遍历一遍，比对，找出需要删除的"（"和"）"的个数
        // 当前处理字符的位置
        int index = 0;
        // 需要删除"（"的个数
        int leftToDelete = 0;
        // 需要删除"）"的个数
        int rightToDelete = 0;
        // 剩余几个"（"没有匹配到"）"
        int leftCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                    leftToDelete++;
                    break;
                case ')':
                    if (leftToDelete > 0) {
                        // 抵消
                        leftToDelete--;
                    } else {
                        rightToDelete++;
                    }
                    break;
                default:
            }
        }
        dfs(s, index, leftCount, leftToDelete, rightToDelete, set, new StringBuilder());
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }


    private void dfs(String s, int index, int leftCount, int leftToDelete, int rightToDelete, HashSet<String> set, StringBuilder sb) {
        if (index == s.length()) {
            if (leftToDelete == 0 && rightToDelete == 0 && leftCount == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            // 如果是'(',那么要么删除,要么保留.
            // 如果删除
            if (leftToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete - 1, rightToDelete, set, tmp);
            }
            // 不删,或者没有可以删除的
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount + 1, leftToDelete, rightToDelete, set, tmp);
        } else if (c == ')') {
            // 删除
            if (rightToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete, rightToDelete - 1, set, tmp);
            }
            // 在前面有'('的时候保留.
            if (leftCount > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(c);
                dfs(s, index + 1, leftCount - 1, leftToDelete, rightToDelete, set, tmp);
            } else {
                // "）"这个没有"（"和他对应，结束
                return;
            }
        } else {
            // 其他字符
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount, leftToDelete, rightToDelete, set, tmp);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
