# [216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii)

[English Version](/solution/0200-0299/0216.Combination%20Sum%20III/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>找出所有相加之和为&nbsp;<em><strong>n</strong> </em>的&nbsp;<strong><em>k&nbsp;</em></strong>个数的组合<strong><em>。</em></strong>组合中只允许含有 1 -&nbsp;9 的正整数，并且每种组合中不存在重复的数字。</p>

<p><strong>说明：</strong></p>

<ul>
	<li>所有数字都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 7
<strong>输出:</strong> [[1,2,4]]
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 9
<strong>输出:</strong> [[1,2,6], [1,3,5], [2,3,4]]
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
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();        
        robot(1, k, n, ans, new ArrayList<Integer>());
        return ans;
    }
    
    private void robot(int start, int k, int left, List<List<Integer>> ans, List<Integer> tmp) {
        if(k < 0 || left < 0) return;
        
        if(k == 0 && left == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            if(left >= i && k > 0) {
                tmp.add(i);
                robot(i + 1, k - 1, left - i, ans, tmp);
                tmp.remove(tmp.size() - 1);
            } else {
                return;
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
