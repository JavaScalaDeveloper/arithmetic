# [135. 分发糖果](https://leetcode-cn.com/problems/candy)

[English Version](/solution/0100-0199/0135.Candy/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>老师想给孩子们分发糖果，有 <em>N</em>&nbsp;个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。</p>

<p>你需要按照以下要求，帮助老师给这些孩子分发糖果：</p>

<ul>
	<li>每个孩子至少分配到 1 个糖果。</li>
	<li>相邻的孩子中，评分高的孩子必须获得更多的糖果。</li>
</ul>

<p>那么这样下来，老师至少需要准备多少颗糖果呢？</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [1,0,2]
<strong>输出:</strong> 5
<strong>解释:</strong> 你可以分别给这三个孩子分发 2、1、2 颗糖果。
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [1,2,2]
<strong>输出:</strong> 4
<strong>解释:</strong> 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。</pre>

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
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        else if (ratings.length == 1) return 1;
        int base = 1 ,cur = base ,sum = cur ,smallNum = 0 ,lastBigCur = cur;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                smallNum = 0;
                cur += base;
                lastBigCur = cur;
                sum += cur;
            } else if (ratings[i - 1] == ratings[i]) {
                smallNum = 0;
                cur = base;
                lastBigCur = cur;
                sum += base;
            } else {
                if (cur == base) {
                    smallNum++;
                    sum = sum + cur + smallNum;
                    if (lastBigCur - 1 == smallNum) {
                        lastBigCur += base;
                        sum += base;
                    }
                } else {
                    cur = base;
                    sum += cur;
                }
            }
        }
        return sum;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
