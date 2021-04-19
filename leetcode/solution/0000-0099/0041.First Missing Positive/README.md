# [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive)

[English Version](/solution/0000-0099/0041.First%20Missing%20Positive/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个未排序的整数数组，找出其中没有出现的最小的正整数。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>输入: [1,2,0]
输出: 3
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>输入: [3,4,-1,1]
输出: 2
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>输入: [7,8,9,11,12]
输出: 1
</pre>

<p><strong>说明:</strong></p>

<p>你的算法的时间复杂度应为O(<em>n</em>)，并且只能使用常数级别的空间。</p>

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
public class Solution {
    public int firstMissingPositive(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0 && num[i] < num.length && num[num[i] - 1] != num[i]) {
                swap(num, i, num[i] - 1);
                i--;
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (i + 1 != num[i]) {
                return i + 1;
            }
        }
        
        return num.length + 1;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
