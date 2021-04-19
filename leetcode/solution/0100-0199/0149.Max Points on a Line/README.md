# [149. 直线上最多的点数](https://leetcode-cn.com/problems/max-points-on-a-line)

[English Version](/solution/0100-0199/0149.Max%20Points%20on%20a%20Line/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个二维平面，平面上有&nbsp;<em>n&nbsp;</em>个点，求最多有多少个点在同一条直线上。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [[1,1],[2,2],[3,3]]
<strong>输出:</strong> 3
<strong>解释:</strong>
^
|
| &nbsp; &nbsp; &nbsp; &nbsp;o
| &nbsp; &nbsp; o
| &nbsp;o &nbsp;
+-------------&gt;
0 &nbsp;1 &nbsp;2 &nbsp;3  4
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
<strong>输出:</strong> 4
<strong>解释:</strong>
^
|
|  o
| &nbsp;&nbsp;&nbsp;&nbsp;o&nbsp;&nbsp;      o
| &nbsp;&nbsp;&nbsp;&nbsp;   o
| &nbsp;o &nbsp;      o
+-------------------&gt;
0 &nbsp;1 &nbsp;2 &nbsp;3 &nbsp;4 &nbsp;5 &nbsp;6</pre>

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
    public int maxPoints(Point[] points) {
        if( points.length <= 2 ) return points.length;
        int max = 2 ;
        for( int i = 0 ; i < points.length ; i++ ){
            int samePosition = 0;
            int sameSlope = 1;
            for( int j = i + 1 ; j < points.length ; j++ ){
                long x1 = points[j].x - points[i].x;
                long y1 = points[j].y - points[i].y;
                if( x1 == 0 && y1 == 0 ){
                    samePosition++;
                } else {
                    sameSlope++;
                    for(int k = j + 1 ; k < points.length ; k++ ){
                        long x2 = points[k].x - points[i].x;
                        long y2 = points[k].y - points[i].y;
                        if ( x1 * y2 == x2 * y1 ) sameSlope++;
                    }
                }
                if(max < (samePosition + sameSlope)) max = samePosition + sameSlope;
                sameSlope = 1;
            }
        }
        return max;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
