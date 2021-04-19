# [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)

[中文文档](/solution/0100-0199/0154.Find%20Minimum%20in%20Rotated%20Sorted%20Array%20II/README.md)

## Description

<p>Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.</p>

<p>(i.e., &nbsp;<code>[0,1,2,4,5,6,7]</code>&nbsp;might become &nbsp;<code>[4,5,6,7,0,1,2]</code>).</p>

<p>Find the minimum element.</p>

<p>The array may contain duplicates.</p>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input:</strong> [1,3,5]

<strong>Output:</strong> 1</pre>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input:</strong> [2,2,2,0,1]

<strong>Output:</strong> 0</pre>

<p><strong>Note:</strong></p>

<ul>
    <li>This is a follow up problem to&nbsp;<a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">Find Minimum in Rotated Sorted Array</a>.</li>
    <li>Would allow duplicates affect the run-time complexity? How and why?</li>
</ul>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            m = l + ((r - l) >> 1)
            if nums[m] > nums[r]:
                l = m + 1
            elif nums[m] < nums[r]:
                r = m
            else:
                r -= 1
        return nums[l]
```

### **Java**

```java
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                --r;
            }
        }
        return nums[l];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
