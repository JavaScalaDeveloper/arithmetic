# [342. 4 的幂](https://leetcode-cn.com/problems/power-of-four)

[English Version](/solution/0300-0399/0342.Power%20of%20Four/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4&nbsp;的幂次方。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入: </strong>16
<strong>输出: </strong>true
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入: </strong>5
<strong>输出: </strong>false</pre>

<p><strong>进阶：</strong><br>
你能不使用循环或者递归来完成本题吗？</p>

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
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        return ((n & (n - 1)) == 0) && ((n & 0x55555555) != 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
