# [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray)

[English Version](/solution/0500-0599/0581.Shortest%20Unsorted%20Continuous%20Subarray/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数数组，你需要寻找一个<strong>连续的子数组</strong>，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。</p>

<p>你找到的子数组应是<strong>最短</strong>的，请输出它的长度。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [2, 6, 4, 8, 10, 9, 15]
<strong>输出:</strong> 5
<strong>解释:</strong> 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
</pre>

<p><strong>说明 :</strong></p>

<ol>
	<li>输入的数组长度范围在&nbsp;[1, 10,000]。</li>
	<li>输入的数组可能包含<strong>重复</strong>元素&nbsp;，所以<strong>升序</strong>的意思是<strong>&lt;=。</strong></li>
</ol>

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
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = nums[i];
        }
        Arrays.sort(res);
        int p = 0;
        for (; p < n; ++p) {
            if (res[p] != nums[p]) {
                break;
            }
        }
        int q = n - 1;
        for (; q >= 0; --q) {
            if (res[q] != nums[q]) {
                break;
            }
        }
        return p == n ? 0 : q - p + 1 ;
        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
