# [166. 分数到小数](https://leetcode-cn.com/problems/fraction-to-recurring-decimal)

[English Version](/solution/0100-0199/0166.Fraction%20to%20Recurring%20Decimal/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个整数，分别表示分数的分子&nbsp;numerator 和分母 denominator，以字符串形式返回小数。</p>

<p>如果小数部分为循环小数，则将循环的部分括在括号内。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> numerator = 1, denominator = 2
<strong>输出:</strong> &quot;0.5&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> numerator = 2, denominator = 1
<strong>输出:</strong> &quot;2&quot;</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入:</strong> numerator = 2, denominator = 3
<strong>输出: </strong>&quot;0.(6)&quot;
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
    public String fractionToDecimal(int numerator, int denominator) {
        boolean minus = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;
        HashMap<Long, Integer> remains = new HashMap<>(16);
        List<Long> resList = new ArrayList<>();
        long n;
        if(numerator > 0) n = numerator;
        else if(numerator > Integer.MIN_VALUE) n = -numerator;
        else n = Integer.MAX_VALUE + 1L;
        long d;
        if(denominator > 0) d = denominator;
        else if(denominator > Integer.MIN_VALUE) d = -denominator;
        else d = Integer.MAX_VALUE + 1L;
        long r = n % d;
        int index = 0 , loopPos = -1;
        while(r != 0){
            if(remains.containsKey(r)){
                loopPos = remains.get(r);
                break;
            }
            remains.put(r, ++index);
            resList.add(Math.abs(n / d));
            n = r;
            n *= 10;
            r = n % d;
        }
        resList.add(Math.abs(n / d));
        StringBuilder res = new StringBuilder();
        if(minus) res.append("-");
        for(int i = 0; i < resList.size(); i++){
            if(i == 1) res.append(".");
            if(loopPos == i) res.append("(");
            res.append(resList.get(i));
        }
        if(loopPos != -1) res.append(")");
        return res.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
