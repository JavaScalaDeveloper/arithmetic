# [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii)

[English Version](/solution/0000-0099/0090.Subsets%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个可能包含重复元素的整数数组 <em><strong>nums</strong></em>，返回该数组所有可能的子集（幂集）。</p>

<p><strong>说明：</strong>解集不能包含重复的子集。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> [1,2,2]
<strong>输出:</strong>
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        backTrack(res, nums, 0, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, int index, List<Integer> ls){
        res.add(new ArrayList<>(ls));
        if(index>=nums.length) return;
        for(int i=index;i<nums.length;i++){
            ls.add(nums[i]);
            backTrack(res, nums, i+1, ls);
            ls.remove(ls.size()-1);
            while(i<nums.length-1 && nums[i+1]==nums[i]) i++;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
