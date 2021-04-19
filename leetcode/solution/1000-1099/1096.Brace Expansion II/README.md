# [1096. 花括号展开 II](https://leetcode-cn.com/problems/brace-expansion-ii)

[English Version](/solution/1000-1099/1096.Brace%20Expansion%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->

如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。

花括号展开的表达式可以看作一个由 **花括号**、**逗号** 和 **小写英文字母** 组成的字符串，定义下面几条语法规则：

- 如果只给出单一的元素  `x`，那么表达式表示的字符串就只有  `"x"`。
  - 例如，表达式 `{a}`  表示字符串 `"a"`。
  - 而表达式 `{ab}`  就表示字符串 `"ab"`。
- 当两个或多个表达式并列，以逗号分隔时，我们取这些表达式中元素的并集。
  - 例如，表达式  `{a,b,c}` 表示字符串  `"a","b","c"`。
  - 而表达式 `{a,b},{b,c}`  也可以表示字符串  `"a","b","c"`。
- 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。
  - 例如，表达式 `{a,b}{c,d}` 表示字符串  `"ac","ad","bc","bd"`。
- 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
  - 例如，表达式  `a{b,c,d}` 表示字符串  `"ab","ac","ad"`。

给出表示基于给定语法规则的表达式  `expression`，返回它所表示的所有字符串组成的有序列表。

**示例 1：**

```
输入："{a,b}{c{d,e}}"
输出：["acd","ace","bcd","bce"]
```

**提示：**

1. `1 <= expression.length <= 50`
2. `expression[i]` 由 `'{'`，`'}'`，`','`  或小写英文字母组成
3. 给出的表达式  `expression`  用以表示一组基于题目描述中语法构造的字符串

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

```

### **...**

```

```

<!-- tabs:end -->