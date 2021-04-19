# [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii)

[English Version](/solution/0000-0099/0047.Permutations%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个可包含重复数字的序列，返回所有不重复的全排列。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [1,1,2]
<strong>输出:</strong>
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]</pre>

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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }
    
    private void permute(List<List<Integer>> list, int[] nums, int start) {
        int end = nums.length - 1;
        if (start == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int val : nums) {
                tmp.add(val);
            }
            
            list.add(tmp);
            
        }
        
        for (int i = start; i <= end; ++i) {
            if (isSwap(nums, start, i)) {
                swap(nums, i, start);
                permute(list, nums, start + 1);
                swap(nums, i, start);
            }
            
        }
        
    }
    
    private boolean isSwap(int[] nums, int from, int to) {
        for (int i = from; i < to; ++i) {
            if (nums[i] == nums[to]) {
                // 相等，不进行交换
                return false;
            }
        }
        return true;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
