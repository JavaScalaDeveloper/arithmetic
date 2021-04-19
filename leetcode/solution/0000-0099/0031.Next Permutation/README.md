# [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation)

[English Version](/solution/0000-0099/0031.Next%20Permutation/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。</p>

<p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。</p>

<p>必须<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>修改，只允许使用额外常数空间。</p>

<p>以下是一些例子，输入位于左侧列，其相应输出位于右侧列。<br>
<code>1,2,3</code> &rarr; <code>1,3,2</code><br>
<code>3,2,1</code> &rarr; <code>1,2,3</code><br>
<code>1,1,5</code> &rarr; <code>1,5,1</code></p>

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
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                int index = findMinIndex(nums, i, nums[i]);
                swap(nums, i, index);
                reverse(nums, i + 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
        }
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    /**
     * 找出从start开始的比val大的最小元素的下标，如果有多个，选择后者 
     *
     * @param name
     * @param start
     * @param val
     * @return index
     */
    private int findMinIndex(int[] nums, int start, int val) {
        int end = nums.length - 1;
        int i = start;
        for (; i < end; ++i) {
            if (nums[i + 1] <= val) {
                break;
            }
        }
        return i;
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
