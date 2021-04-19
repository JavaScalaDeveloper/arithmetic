# [378. 有序矩阵中第 K 小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix)

[English Version](/solution/0300-0399/0378.Kth%20Smallest%20Element%20in%20a%20Sorted%20Matrix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个&nbsp;<em>n x n&nbsp;</em>矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。<br />
请注意，它是排序后的第k小元素，而不是第k个元素。</p>

<p><strong>示例:</strong></p>

<pre>
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
</pre>

<p><strong>说明: </strong><br />
你可以假设 k 的值永远是有效的, 1 &le; k &le; n<sup>2&nbsp;</sup>。</p>

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
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int min = matrix[0][0], max = matrix[len - 1][len - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (check(matrix, mid, k, len)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        // 从左下角走起
        int i = n - 1;
        int j = 0;
        int num = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return num >= k;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
