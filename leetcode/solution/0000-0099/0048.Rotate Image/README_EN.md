# [48. Rotate Image](https://leetcode.com/problems/rotate-image)

[中文文档](/solution/0000-0099/0048.Rotate%20Image/README.md)

## Description

<p>You are given an <em>n</em> x <em>n</em> 2D matrix representing an image.</p>

<p>Rotate the image by 90 degrees (clockwise).</p>

<p><strong>Note:</strong></p>

<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>

<p><strong>Example 1:</strong></p>

<pre>

Given <strong>input matrix</strong> = 

[

  [1,2,3],

  [4,5,6],

  [7,8,9]

],



rotate the input matrix <strong>in-place</strong> such that it becomes:

[

  [7,4,1],

  [8,5,2],

  [9,6,3]

]

</pre>

<p><strong>Example 2:</strong></p>

<pre>

Given <strong>input matrix</strong> =

[

  [ 5, 1, 9,11],

  [ 2, 4, 8,10],

  [13, 3, 6, 7],

  [15,14,12,16]

], 



rotate the input matrix <strong>in-place</strong> such that it becomes:

[

  [15,13, 2, 5],

  [14, 3, 4, 1],

  [12, 6, 8, 9],

  [16, 7,10,11]

]

</pre>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        s, n = 0, len(matrix)
        while s < (n >> 1):
            e = n - s - 1
            for i in range(s, e):
                t = matrix[i][e]
                matrix[i][e] = matrix[s][i]
                matrix[s][i] = matrix[n - i - 1][s]
                matrix[n - i - 1][s] = matrix[e][n - i - 1]
                matrix[e][n - i - 1] = t
            s += 1
```

### **Java**

```java
class Solution {
    public void rotate(int[][] matrix) {
        int s = 0, n = matrix.length;
        while (s < (n >> 1)) {
            int e = n - s - 1;
            for (int i = s; i < e; ++i) {
                int t = matrix[i][e];
                matrix[i][e] = matrix[s][i];
                matrix[s][i] = matrix[n - i - 1][s];
                matrix[n - i - 1][s] = matrix[e][n - i - 1];
                matrix[e][n - i - 1] = t;
            }
            ++s;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
