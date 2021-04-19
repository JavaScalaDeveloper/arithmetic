# [229. 求众数 II](https://leetcode-cn.com/problems/majority-element-ii)

[English Version](/solution/0200-0299/0229.Majority%20Element%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个大小为&nbsp;<em>n&nbsp;</em>的数组，找出其中所有出现超过&nbsp;<code>&lfloor; n/3 &rfloor;</code>&nbsp;次的元素。</p>

<p><strong>说明: </strong>要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [3,2,3]
<strong>输出:</strong> [3]</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [1,1,1,3,3,2,2,2]
<strong>输出:</strong> [1,2]</pre>

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
    public List<Integer> majorityElement(int[] nums) {
        int[] candidate = new int[2];
        int[] cnt = new int[2];
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            } else if (cnt[0] == 0) {
                candidate[0] = num;
                cnt[0] = 1;
            } else if (cnt[1] == 0) {
                candidate[1] = num;
                cnt[1] = 1;
            } else {
                --cnt[0];
                --cnt[1];
            }
        }
        Arrays.fill(cnt, 0);
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cnt[0] > nums.length / 3) {
            res.add(candidate[0]);
        }
        if (cnt[1] > nums.length / 3) {
            res.add(candidate[1]);
        }
        return res;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
