# [77. 组合](https://leetcode-cn.com/problems/combinations)

[English Version](/solution/0000-0099/0077.Combinations/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个整数 <em>n</em> 和 <em>k</em>，返回 1 ... <em>n </em>中所有可能的 <em>k</em> 个数的组合。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>&nbsp;n = 4, k = 2
<strong>输出:</strong>
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
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

    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combine(n-k+1,k,0,1,new Integer[k]);
        return result;
    }

    private void combine(int n, int k, int i, int start, Integer[] list) {
        if (i==k) {
            result.add(new ArrayList<>(Arrays.asList(list)));
            return;
        }
        for (int j = start; j <= n+i; j++) {
            list[i] = j;
            combine(n,k,i+1,j+1,list);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
