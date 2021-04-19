# [4. 寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays)

[English Version](/solution/0000-0099/0004.Median%20of%20Two%20Sorted%20Arrays/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个大小为 m 和 n 的有序数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。</p>

<p>请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为&nbsp;O(log(m + n))。</p>

<p>你可以假设&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;不会同时为空。</p>

<p><strong>示例 1:</strong></p>

<pre>nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
</pre>

<p><strong>示例 2:</strong></p>

<pre>nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
</pre>

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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }

        int min = 0;
        int max = len1;

        int m = (len1 + len2 + 1) / 2;

        while (min <= max) {
            int i = (min + max) / 2;
            int j = m - i;

            if (i > min && nums1[i - 1] > nums2[j]) {
                --max;
            } else if (i < max && nums2[j - 1] > nums1[i]) {
                ++min;
            } else {

                int maxLeft = i == 0 ? nums2[j - 1] : j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);

                if (((len1 + len2) & 1) == 1) {
                    return maxLeft;
                }

                int minRight = i == len1 ? nums2[j] : j == len2 ? nums1[i] : Math.min(nums2[j], nums1[i]);

                return (maxLeft + minRight) / 2.0;

            }

        }

        return 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
