# [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate)

[中文文档](/solution/0200-0299/0217.Contains%20Duplicate/README.md)

## Description

<p>Given an array of integers, find if the array contains any duplicates.</p>

<p>Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.</p>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input:</strong> [1,2,3,1]

<strong>Output:</strong> true</pre>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input: </strong>[1,2,3,4]

<strong>Output:</strong> false</pre>

<p><strong>Example 3:</strong></p>

<pre>

<strong>Input: </strong>[1,1,1,3,3,4,3,2,4,2]

<strong>Output:</strong> true</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))
```

### **Java**

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            if (set.contains(e)) return true;
            set.add(e);
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
