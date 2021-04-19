# [260. 只出现一次的数字 III](https://leetcode-cn.com/problems/single-number-iii)

[English Version](/solution/0200-0299/0260.Single%20Number%20III/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数数组&nbsp;<code>nums</code>，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。</p>

<p><strong>示例 :</strong></p>

<pre><strong>输入:</strong> <code>[1,2,1,3,2,5]</code>
<strong>输出:</strong> <code>[3,5]</code></pre>

<p><strong>注意：</strong></p>

<ol>
	<li>结果输出的顺序并不重要，对于上面的例子，&nbsp;<code>[5, 3]</code>&nbsp;也是正确答案。</li>
	<li>你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        xor = 0
        for num in nums:
            xor ^= num
        # x & (-x) 是保留位中最右边 1 ，且将其余的 1 设位 0 的方法
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

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
