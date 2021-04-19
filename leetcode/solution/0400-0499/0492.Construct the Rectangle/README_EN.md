# [492. Construct the Rectangle](https://leetcode.com/problems/construct-the-rectangle)

[中文文档](/solution/0400-0499/0492.Construct%20the%20Rectangle/README.md)

## Description

<p>

For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:<pre>

1. The area of the rectangular web page you designed must equal to the given target area.

<br>2. The width W should not be larger than the length L, which means L >= W.

<br>3. The difference between length L and width W should be as small as possible.

</pre>

You need to output the length L and the width W of the web page you designed in sequence.

</p>

<p><b>Example:</b><br />

<pre>

<b>Input:</b> 4

<b>Output:</b> [2, 2]

<b>Explanation:</b> The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 

But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.

</pre>

</p>

<p><b>Note:</b><br>

<ol>

<li>The given area won't exceed 10,000,000 and is a positive integer</li>

<li>The web page's width and length you designed must be positive integers.</li>

</ol>

</p>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def constructRectangle(self, area: int) -> List[int]:
        sr = int(math.sqrt(area))
        l = w = sr
        while l <= area and w >= 1:
            s = l * w
            if s == area:
                break
            if s > area:
                w -= 1
            else:
                l += 1
        return [l, w]
```

### **Java**

```java
class Solution {
    public int[] constructRectangle(int area) {
        int sr = (int) Math.sqrt(area);
        int l = sr, w = sr;
        while (l <= area && w >= 1) {
            int s = l * w;
            if (s == area) break;
            if (s > area) --w;
            else ++l;
        }
        return new int[]{l, w};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
