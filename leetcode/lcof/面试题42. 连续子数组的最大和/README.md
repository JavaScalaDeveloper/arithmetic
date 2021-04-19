# [面试题 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

## 题目描述

输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为 O(n)。

**示例 1:**

```
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

**提示：**

- `1 <= arr.length <= 10^5`
- `-100 <= arr[i] <= 100`

<p>注意：本题与主站 53 题相同：<a href="https://leetcode-cn.com/problems/maximum-subarray/">https://leetcode-cn.com/problems/maximum-subarray/</a></p>

## 解法

设 dp[i] 表示 `[0..i]` 中，以 `nums[i]` 结尾的最大子数组和，状态转移方程 `dp[i] = nums[i] + max(dp[i - 1], 0)`。

由于 `dp[i]` 只与子问题 `dp[i-1]` 有关，故可以用一个变量 f 来表示。

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        res = f = nums[0]
        for i in range(1, n):
            f = nums[i] + max(f, 0)
            res = max(res, f)
        return res
```

### **Java**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], f = nums[0];
        for (int i = 1, n = nums.length; i < n; ++i) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }
}
```

### **JavaScript**

```js
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
  if (!nums || !nums.length) return null;
  let len = nums.length;
  let dp = new Array(len);
  dp[0] = nums[0];
  for (let i = 1; i < len; i++) {
    dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
  }
  return Math.max(...dp);
};
```

### **...**

```

```

<!-- tabs:end -->
