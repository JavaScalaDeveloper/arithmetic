# [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii)

[English Version](/solution/0200-0299/0227.Basic%20Calculator%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个基本的计算器来计算一个简单的字符串表达式的值。</p>

<p>字符串表达式仅包含非负整数，<code>+</code>， <code>-</code> ，<code>*</code>，<code>/</code> 四种运算符和空格&nbsp;<code>&nbsp;</code>。 整数除法仅保留整数部分。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入: </strong>&quot;3+2*2&quot;
<strong>输出:</strong> 7
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> &quot; 3/2 &quot;
<strong>输出:</strong> 1</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> &quot; 3+5 / 2 &quot;
<strong>输出:</strong> 5
</pre>

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
            if (cs[i] == '*' || cs[i] == '/') {
                op.push(cs[i]);
            } else if (cs[i] == '+' || cs[i] == '-') {
                if (!op.isEmpty()) {
                    calc(op, num);
                }
                op.push(cs[i]);
            } else if (Character.isDigit(cs[i])) {
                int j = i;
                int k = 0;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    k = k * 10 + cs[j] - '0';
                    ++j;
                }
                i = j - 1;
                num.push(k);
                if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    calc(op, num);
                }
            }
        }
        if (!op.isEmpty()) {
            calc(op, num);
        }
        return num.peek();
    }

    private void calc(Deque<Character> op, Deque<Integer> num) {
        int y = num.pop();
        int x = num.pop();
        switch (op.pop()) {
            case '*':
                num.push(x * y);
                break;
            case '/':
                num.push(x / y);
                break;
            case '+':
                num.push(x + y);
                break;
            default:
                num.push(x - y);
                break;
        }
    }
}

```

### **...**

```

```

<!-- tabs:end -->
