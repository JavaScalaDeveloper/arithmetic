# [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array)

[English Version](/solution/0900-0999/0912.Sort%20an%20Array/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数数组&nbsp;<code>nums</code>，将该数组升序排列。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[5,2,3,1]
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>[5,1,1,2,0,0]
<strong>输出：</strong>[0,0,1,1,2,5]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
	<li><code>-50000 &lt;= A[i] &lt;= 50000</code></li>
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

    void createHeap(int[] data, int n, int h) {
        int i = h;
        int j = 2 * i + 1;
        int temp = data[i];

        while (j < n) {
            if (j + 1 < n && data[j] < data[j + 1]) j++;
            if (temp > data[j]) {
                break;
            } else {
                data[i] = data[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        data[i] = temp;
    }

    void initHeap(int[] data, int n) {
        for (int i = (n - 2) / 2; i > -1; i--) {
            createHeap(data, n, i);
        }
    }

    void heapSort(int[] data, int n) {
        initHeap(data, n);

        for (int i = n - 1;i > -1;i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            createHeap(data, i, 0);
        }
    }

    public int[] sortArray(int[] nums) {
        heapSort(nums, nums.length);
        return nums;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
