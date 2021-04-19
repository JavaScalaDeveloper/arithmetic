# [169. 多数元素](https://leetcode-cn.com/problems/majority-element)

[English Version](/solution/0100-0199/0169.Majority%20Element/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个大小为 <em>n </em>的数组，找到其中的多数元素。多数元素是指在数组中出现次数<strong>大于</strong>&nbsp;<code>&lfloor; n/2 &rfloor;</code>&nbsp;的元素。</p>

<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [3,2,3]
<strong>输出:</strong> 3</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [2,2,1,1,1,2,2]
<strong>输出:</strong> 2
</pre>

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
    public int majorityElement(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1; i<nums.length; i++){
            if(res==nums[i])
                count++;
            else{
                count--;
                if(count==0)
                    res=nums[i+1];
            }
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
