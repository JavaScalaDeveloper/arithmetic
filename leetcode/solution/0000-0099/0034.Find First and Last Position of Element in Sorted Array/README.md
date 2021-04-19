# [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array)

[English Version](/solution/0000-0099/0034.Find%20First%20and%20Last%20Position%20of%20Element%20in%20Sorted%20Array/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个按照升序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。找出给定目标值在数组中的开始位置和结束位置。</p>

<p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log <em>n</em>) 级别。</p>

<p>如果数组中不存在目标值，返回&nbsp;<code>[-1, -1]</code>。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 8
<strong>输出:</strong> [3,4]</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 6
<strong>输出:</strong> [-1,-1]</pre>

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
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            if (nums[mid] == target) {
                return new int[]{findFirst(nums, start, mid, target),findEnd(nums, mid, end, target)};
            }
        }
        return new int[]{-1,-1};
    }

    private int findFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int temp = start + (end - start) / 2;
            if (nums[temp] < target) start = temp + 1;
            else if (nums[temp] == target) end = temp;
        }
        return start;
    }

    private int findEnd(int[] nums, int start, int end, int target) {
        while (start < end) {
            int temp = start + (end - start + 1) / 2;
            if (nums[temp] > target) end = temp - 1;
            else if (nums[temp] == target) start = temp;
        }
        return start;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
