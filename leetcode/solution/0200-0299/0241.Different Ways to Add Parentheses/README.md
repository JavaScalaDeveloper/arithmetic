# [241. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses)

[English Version](/solution/0200-0299/0241.Different%20Ways%20to%20Add%20Parentheses/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 <code>+</code>,&nbsp;<code>-</code>&nbsp;以及&nbsp;<code>*</code>&nbsp;。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> <code>&quot;2-1-1&quot;</code>
<strong>输出:</strong> <code>[0, 2]</code>
<strong>解释: </strong>
((2-1)-1) = 0 
(2-(1-1)) = 2</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入: </strong><code>&quot;2*3-4*5&quot;</code>
<strong>输出:</strong> <code>[-34, -14, -10, -10, 10]</code>
<strong>解释: 
</strong>(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10</pre>

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
import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {

		List<Integer> rt = new LinkedList<Integer>();
		int len = input.length();

		for (int i = 0; i < len; i++) {

			if (input.charAt(i) == '-' || input.charAt(i) == '*'
					|| input.charAt(i) == '+') {

				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);

				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);

				for (Integer p1 : part1Ret) {
					for (Integer p2 : part2Ret) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '*':
							c = p1 * p2;
						}
						rt.add(c);
					}
				}
			}
		}

		if (rt.size() == 0) {
			rt.add(Integer.valueOf(input));
		}

		return rt;
	
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
