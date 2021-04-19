# [260. Single Number III](https://leetcode.com/problems/single-number-iii)

[中文文档](/solution/0200-0299/0260.Single%20Number%20III/README.md)

## Description

<p>Given an array of numbers <code>nums</code>, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.</p>

<p><strong>Example:</strong></p>

<pre>

<strong>Input:</strong>  <code>[1,2,1,3,2,5]</code>

<strong>Output:</strong> <code>[3,5]</code></pre>

<p><b>Note</b>:</p>

<ol>
    <li>The order of the result is not important. So in the above example, <code>[5, 3]</code> is also correct.</li>
    <li>Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?</li>
</ol>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        xor = 0
        for num in nums:
            xor ^= num
        diff = xor & (-xor)
        a = b = 0
        for num in nums:
            if (num & diff) == 0:
                a ^= num
            else:
                b ^= num
        return [a, b]

```

### **Java**

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & (-xor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diff) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
