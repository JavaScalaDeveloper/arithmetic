# [268. Missing Number](https://leetcode.com/problems/missing-number)

[中文文档](/solution/0200-0299/0268.Missing%20Number/README.md)

## Description

<p>Given an array containing <i>n</i> distinct numbers taken from <code>0, 1, 2, ..., n</code>, find the one that is missing from the array.</p>

<p><b>Example 1:</b></p>

<pre>

<b>Input:</b> [3,0,1]

<b>Output:</b> 2

</pre>

<p><b>Example 2:</b></p>

<pre>

<b>Input:</b> [9,6,4,2,3,5,7,0,1]

<b>Output:</b> 8

</pre>

<p><b>Note</b>:<br />

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?</p>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i, v in enumerate(nums):
            res ^= (i ^ v)
        return res
```

### **Java**

- XOR

```java
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; ++i) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}
```

- Math

```java
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; ++i) {
            res += (i - nums[i]);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
