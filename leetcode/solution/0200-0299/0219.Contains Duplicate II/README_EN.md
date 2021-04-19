# [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii)

[中文文档](/solution/0200-0299/0219.Contains%20Duplicate%20II/README.md)

## Description

<p>Given an array of integers and an integer <i>k</i>, find out whether there are two distinct indices <i>i</i> and <i>j</i> in the array such that <b>nums[i] = nums[j]</b> and the <b>absolute</b> difference between <i>i</i> and <i>j</i> is at most <i>k</i>.</p>

<div>

<p><strong>Example 1:</strong></p>

<pre>

<strong>Input: </strong>nums = <span id="example-input-1-1">[1,2,3,1]</span>, k = <span id="example-input-1-2">3</span>

<strong>Output: </strong><span id="example-output-1">true</span>

</pre>

<div>

<p><strong>Example 2:</strong></p>

<pre>

<strong>Input: </strong>nums = <span id="example-input-2-1">[1,0,1,1]</span>, k = <span id="example-input-2-2">1</span>

<strong>Output: </strong><span id="example-output-2">true</span>

</pre>

<div>

<p><strong>Example 3:</strong></p>

<pre>

<strong>Input: </strong>nums = <span id="example-input-3-1">[1,2,3,1,2,3]</span>, k = <span id="example-input-3-2">2</span>

<strong>Output: </strong><span id="example-output-3">false</span>

</pre>

</div>

</div>

</div>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        helper = {}
        for i, v in enumerate(nums):
            if v in helper and i - helper[v] <= k:
                return True
            helper[v] = i
        return False
```

### **Java**

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (helper.containsKey(nums[i])) {
                int j = helper.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            helper.put(nums[i], i);
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
