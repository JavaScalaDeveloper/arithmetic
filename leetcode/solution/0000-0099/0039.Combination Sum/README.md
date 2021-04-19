# [39. 组合总和](https://leetcode-cn.com/problems/combination-sum)

[English Version](/solution/0000-0099/0039.Combination%20Sum/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个<strong>无重复元素</strong>的数组&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>

<p><code>candidates</code>&nbsp;中的数字可以无限制重复被选取。</p>

<p><strong>说明：</strong></p>

<ul>
	<li>所有数字（包括&nbsp;<code>target</code>）都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> candidates = <code>[2,3,6,7], </code>target = <code>7</code>,
<strong>所求解集为:</strong>
[
  [7],
  [2,2,3]
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> candidates = [2,3,5]<code>, </code>target = 8,
<strong>所求解集为:</strong>
[
&nbsp; [2,2,2,2],
&nbsp; [2,3,3],
&nbsp; [3,5]
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates,target,candidates.length-1, new ArrayList<>(),result);
        return result;
    }

    private void combinationSum(int[] candidates, int target,int length, List<Integer> integers,
                                List<List<Integer>> result) {
        List<Integer> list;
        for (int i = length; i >= 0; i--) {
            int nc = candidates[i];
            if (nc>target) continue;
            list = new ArrayList<>(integers);
            list.add(nc);
            if (nc==target) result.add(list);
            else combinationSum(candidates, target - nc, i, list,result);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
