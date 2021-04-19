# [面试题 56 - I. 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

## 题目描述

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是 O(n)，空间复杂度是 O(1)。

**示例 1：**

```
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
```

**示例 2：**

```
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
```

**限制：**

- `2 <= nums <= 10000`

## 解法

异或运算求解。

首先明确，两个相同的数异或之后的结果为 0。对该数组所有元素进行异或运算，结果就是**两个只出现一次的数字异或的结果**。找出这个结果中某个二进制位为 1 的位置，之后对数组所有元素进行分类，二进制位为 0 的异或到 a，二进制位为 1 的异或到 b，结果就是 a，b。

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def singleNumbers(self, nums: List[int]) -> List[int]:
        xor_res = 0
        for num in nums:
            xor_res ^= num
        pos = 0
        while (xor_res & 1) == 0:
            pos += 1
            xor_res >>= 1

        a = b = 0
        for num in nums:
            t = num >> pos
            if (t & 1) == 0:
                a ^= num
            else:
                b ^= num
        return [a, b]
```

### **Java**

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int pos = 0;
        while ((xor & 1) == 0) {
            ++pos;
            xor >>= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            int t = num >> pos;
            if ((t & 1) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
```

### **JavaScript**

```js
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumbers = function (nums) {
  let xor = 0;
  let bit = 1;
  let res = [0, 0];
  for (let num of nums) {
    xor ^= num;
  }
  while ((xor & 1) === 0) {
    xor >>= 1;
    bit <<= 1;
  }
  for (let num of nums) {
    if ((num & bit) === 0) {
      res[0] ^= num;
    } else {
      res[1] ^= num;
    }
  }
  return res;
};
```

### **...**

```

```

<!-- tabs:end -->
