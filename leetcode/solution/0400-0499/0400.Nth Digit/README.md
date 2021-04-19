# [400. 第 N 个数字](https://leetcode-cn.com/problems/nth-digit)

[English Version](/solution/0400-0499/0400.Nth%20Digit/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>在无限的整数序列&nbsp;1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第&nbsp;<em>n&nbsp;</em>个数字。</p>

<p><strong>注意:</strong><br />
<em>n&nbsp;</em>是正数且在32为整形范围内&nbsp;(&nbsp;<em>n</em> &lt; 2<sup>31</sup>)。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong>
3

<strong>输出:</strong>
3
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong>
11

<strong>输出:</strong>
0

<strong>说明:</strong>
第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是<strong>0</strong>，它是10的一部分。
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
    /***
     * 12345678910111213
     * 规律个位数9个数一共有9*1,两位数90个数 一共有90*2个数字,三位数有900个数一共有900*3个数字,以此类推
     * 举例15,15-9=6,6/2=3...0,余数是0,那么这个数值value=10*(2-1)+(3-1)=12,整除取最后一位  12%10=2
     * 举例14,14-9=5,5/2=2...1,余数不为0,那么这个数值value=10*(2-1)+2=12,则为这个数的第余数个 12/(10*(2-1))%10=1
     */
    public int findNthDigit(int n) {
        long max = 9;
        long num = n;
        long digits = 1;
        while (n > 0) {
            if (num - max * digits > 0) {
                num = num - max * digits;
                digits++;
                max = max * 10;
            } else {
                long count = num / digits;
                long childDigits = num % digits;
                if (childDigits == 0) {
                    return (int) (((long) Math.pow(10, digits - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, digits - 1) + count) / ((long) Math.pow(10, (digits - childDigits))) % 10);
                }
            }
        }
        return 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
