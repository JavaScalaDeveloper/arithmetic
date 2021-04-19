# [27. Remove Element](https://leetcode.com/problems/remove-element)

[中文文档](/solution/0000-0099/0027.Remove%20Element/README.md)

## Description

<p>Given an array <em>nums</em> and a value <em>val</em>, remove all instances of that value <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> and return the new length.</p>

<p>Do not allocate extra space for another array, you must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>

<p>The order of elements can be changed. It doesn&#39;t matter what you leave beyond the new length.</p>

<p><strong>Example 1:</strong></p>

<pre>

Given <em>nums</em> = <strong>[3,2,2,3]</strong>, <em>val</em> = <strong>3</strong>,



Your function should return length = <strong>2</strong>, with the first two elements of <em>nums</em> being <strong>2</strong>.



It doesn&#39;t matter what you leave beyond the returned length.

</pre>

<p><strong>Example 2:</strong></p>

<pre>

Given <em>nums</em> = <strong>[0,1,2,2,3,0,4,2]</strong>, <em>val</em> = <strong>2</strong>,



Your function should return length = <strong><code>5</code></strong>, with the first five elements of <em><code>nums</code></em> containing&nbsp;<strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>3</code></strong>, <strong><code>0</code></strong>, and&nbsp;<strong>4</strong>.



Note that the order of those five elements can be arbitrary.



It doesn&#39;t matter what values are set beyond&nbsp;the returned length.</pre>

<p><strong>Clarification:</strong></p>

<p>Confused why the returned value is an integer but your answer is an array?</p>

<p>Note that the input array is passed in by <strong>reference</strong>, which means modification to the input array will be known to the caller as well.</p>

<p>Internally you can think of this:</p>

<pre>

// <strong>nums</strong> is passed in by reference. (i.e., without making a copy)

int len = removeElement(nums, val);



// any modification to <strong>nums</strong> in your function would be known by the caller.

// using the length returned by your function, it prints the first <strong>len</strong> elements.

for (int i = 0; i &lt; len; i++) {

&nbsp; &nbsp; print(nums[i]);

}</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cnt, n = 0, len(nums)
        for i in range(n):
            if nums[i] == val:
                cnt += 1
            else:
                nums[i - cnt] = nums[i]
        return n - cnt
```

### **Java**

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return n - cnt;
    }
}
```

### **C++**

```cpp
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int cnt = 0, n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return n - cnt;
    }
};
```

### **...**

```

```

<!-- tabs:end -->
