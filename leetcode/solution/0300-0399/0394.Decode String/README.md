# [394. 字符串解码](https://leetcode-cn.com/problems/decode-string)

[English Version](/solution/0300-0399/0394.Decode%20String/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个经过编码的字符串，返回它解码后的字符串。</p>

<p>编码规则为: <code>k[encoded_string]</code>，表示其中方括号内部的 <em>encoded_string</em> 正好重复 <em>k</em> 次。注意 <em>k</em> 保证为正整数。</p>

<p>你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。</p>

<p>此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 <em>k</em> ，例如不会出现像&nbsp;<code>3a</code>&nbsp;或&nbsp;<code>2[4]</code>&nbsp;的输入。</p>

<p><strong>示例:</strong></p>

<pre>
s = &quot;3[a]2[bc]&quot;, 返回 &quot;aaabcbc&quot;.
s = &quot;3[a2[c]]&quot;, 返回 &quot;accaccacc&quot;.
s = &quot;2[abc]3[cd]ef&quot;, 返回 &quot;abcabccdcdcdef&quot;.
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
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ']') {
                stack.push(chars[i]);
            } else {
                // 找[]内的内容
                String t = "";
                while (stack.peek() != '[') {
                    t = stack.pop() + t;
                }
                // 弹出[
                stack.pop();
                // 找前面的数字
                String n = "";
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    n = stack.pop() + n;
                }
                int c = Integer.valueOf(n);

                String tmpCombine = "";
                // 把字母重复c次
                for (int j = 0; j < c; j++) {
                    tmpCombine += t;
                }

                // 放回stack
                char[] tmp = tmpCombine.toCharArray();
                for (int j = 0; j < tmp.length; j++) {
                    stack.push(tmp[j]);
                }
            }
        }

        // stack即为结果
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
