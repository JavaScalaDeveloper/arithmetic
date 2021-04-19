# [213. House Robber II](https://leetcode.com/problems/house-robber-ii)

[中文文档](/solution/0200-0299/0213.House%20Robber%20II/README.md)

## Description

<p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are <strong>arranged in a circle.</strong> That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and&nbsp;<b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight <strong>without alerting the police</strong>.</p>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input:</strong> [2,3,2]

<strong>Output:</strong> 3

<strong>Explanation:</strong> You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),

&nbsp;            because they are adjacent houses.

</pre>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input:</strong> [1,2,3,1]

<strong>Output:</strong> 4

<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).

&nbsp;            Total amount you can rob = 1 + 3 = 4.</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def rob(self, nums: List[int]) -> int:
        def _rob(nums):
            n = len(nums)
            if n == 0:
                return 0
            if n == 1:
                return nums[0]
            pre, cur = nums[0], max(nums[0], nums[1])
            for i in range(2, n):
                t = max(pre + nums[i], cur)
                pre, cur = cur, t
            return cur

        n = len(nums)
        if n == 1:
            return nums[0]
        return max(_rob(nums[1:]), _rob(nums[:-1]))
```

### **Java**

```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sub1 = robInternal(Arrays.copyOfRange(nums, 0, n - 1));
        int sub2 = robInternal(Arrays.copyOfRange(nums, 1, n));
        return Math.max(sub1, sub2);
    }

    private int robInternal(int[] nums) {
        int n;
        if ((n = nums.length) == 0) {
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
