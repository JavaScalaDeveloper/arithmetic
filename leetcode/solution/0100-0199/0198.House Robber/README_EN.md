# [198. House Robber](https://leetcode.com/problems/house-robber)

[中文文档](/solution/0100-0199/0198.House%20Robber/README.md)

## Description

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight <b>without alerting the police</b>.</p>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input:</strong> [1,2,3,1]

<strong>Output:</strong> 4

<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).

&nbsp;            Total amount you can rob = 1 + 3 = 4.</pre>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input:</strong> [2,7,9,3,1]

<strong>Output:</strong> 12

<strong>Explanation:</strong> Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).

&nbsp;            Total amount you can rob = 2 + 9 + 1 = 12.

</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        if n == 1:
            return nums[0]
        pre, cur = nums[0], max(nums[0], nums[1])
        for i in range(2, n):
            t = max(pre + nums[i], cur)
            pre, cur = cur, t
        return cur
```

### **Java**

```java
class Solution {
    public int rob(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int t = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
