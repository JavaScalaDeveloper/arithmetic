# [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator)

[English Version](/solution/0200-0299/0224.Basic%20Calculator/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个基本的计算器来计算一个简单的字符串表达式的值。</p>

<p>字符串表达式可以包含左括号&nbsp;<code>(</code>&nbsp;，右括号&nbsp;<code>)</code>，加号&nbsp;<code>+</code>&nbsp;，减号&nbsp;<code>-</code>，<strong>非负</strong>整数和空格&nbsp;<code>&nbsp;</code>。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> &quot;1 + 1&quot;
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot; 2-1 + 2 &quot;
<strong>输出:</strong> 3</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> &quot;(1+(4+5+2)-3)+(6+8)&quot;
<strong>输出:</strong> 23</pre>

<p><strong>说明：</strong></p>

<ul>
	<li>你可以假设所给定的表达式都是有效的。</li>
	<li>请<strong>不要</strong>使用内置的库函数 <code>eval</code>。</li>
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
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> op = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '(' || cs[i] == '+' || cs[i] == '-') {
                op.push(cs[i]);
            } else if (cs[i] == ')') {
                op.pop();
                if (!op.isEmpty() && op.peek() != '(') {
                    calc(op, num);
                }
            } else if (Character.isDigit(cs[i])) {
                int j = i;
                int k = 0;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    k = k * 10 + cs[j] - '0';
                    ++j;
                }
                num.push(k);
                i = j - 1;
                if (!op.isEmpty() && op.peek() != '(') {
                    calc(op, num);
                }
            }
        }
        return num.peek();
    }

    private void calc(Deque<Character> op, Deque<Integer> num) {
        int y = num.pop();
        int x = num.pop();
        if (op.pop() == '+') {
            num.push(x + y);
        } else {
            num.push(x - y);
        }
    }
}

```

### **...**

```

```

<!-- tabs:end -->
