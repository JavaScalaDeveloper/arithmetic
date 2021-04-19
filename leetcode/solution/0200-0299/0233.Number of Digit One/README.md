# [233. 数字 1 的个数](https://leetcode-cn.com/problems/number-of-digit-one)

[English Version](/solution/0200-0299/0233.Number%20of%20Digit%20One/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> 13
<strong>输出:</strong> 6 
<strong>解释: </strong>数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。</pre>

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
    public int countDigitOne(int n) {
        int index = 1;
        int count = 0;
        int high = n,cur = 0,low = 0;
        while(high > 0){
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            if(cur == 0) count += high * index;
            if(cur == 1) count += high * index + low + 1;
            if(cur > 1) count += (high+1) * index;
            index *= 10;
        }
        return count;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
