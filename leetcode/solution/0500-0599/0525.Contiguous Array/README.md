# [525. 连续数组](https://leetcode-cn.com/problems/contiguous-array)

[English Version](/solution/0500-0599/0525.Contiguous%20Array/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [0,1]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] 是具有相同数量0和1的最长连续子数组。</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [0,1,0]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。</pre>

<p>&nbsp;</p>

<p><strong>注意:&nbsp;</strong>给定的二进制数组的长度不会超过50000。</p>

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
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(s)) {
                res = Math.max(res, i - map.get(s));
            } else {
                map.put(s, i);
            }
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
