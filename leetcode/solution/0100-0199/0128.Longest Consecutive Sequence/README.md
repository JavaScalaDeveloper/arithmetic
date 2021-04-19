# [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence)

[English Version](/solution/0100-0199/0128.Longest%20Consecutive%20Sequence/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个未排序的整数数组，找出最长连续序列的长度。</p>

<p>要求算法的时间复杂度为&nbsp;<em>O(n)</em>。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>&nbsp;[100, 4, 200, 1, 3, 2]
<strong>输出:</strong> 4
<strong>解释:</strong> 最长连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>

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
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int start = 0, casch = nums[0], longest = 0;
        for (int i = 1; i < nums.length; i++) {
            int nc = nums[i] , con = nc - casch;
            if (con == 0) {
                start++;
            } else if (con != 1) {
                longest = Math.max(i - start, longest);
                start = i;
            }
            casch = nc;
        }
        return Math.max(nums.length - start, longest);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
