# [556. 下一个更大元素 III](https://leetcode-cn.com/problems/next-greater-element-iii)

[English Version](/solution/0500-0599/0556.Next%20Greater%20Element%20III/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个<strong>32位</strong>正整数&nbsp;<strong>n</strong>，你需要找到最小的<strong>32位</strong>整数，其与&nbsp;<strong>n&nbsp;</strong>中存在的位数完全相同，并且其值大于n。如果不存在这样的<strong>32位</strong>整数，则返回-1。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> 12
<strong>输出:</strong> 21
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> 21
<strong>输出:</strong> -1
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
    public int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }
        char[] cs = String.valueOf(n).toCharArray();
        int i = cs.length - 2;
        while (i >= 0 && cs[i] >= cs[i + 1]) {
            --i;
        }
        if (i < 0) {
            return -1;
        }
        int j = cs.length - 1;
        while (cs[i] >= cs[j]) {
            --j;
        }
        swap(cs, i, j);
        reverse(cs, i + 1, cs.length - 1);
        long res = 0;
        for (char c : cs) {
            res = res * 10 + c - '0';
        }
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            swap(cs, i++, j--);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
