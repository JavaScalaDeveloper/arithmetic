# [1537. 最大得分](https://leetcode-cn.com/problems/get-the-maximum-score)

[English Version](/solution/1500-1599/1537.Get%20the%20Maximum%20Score/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>你有两个 <strong>有序</strong>&nbsp;且数组内元素互不相同的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;。</p>

<p>一条&nbsp;<strong>合法路径</strong>&nbsp;定义如下：</p>

<ul>
	<li>选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。</li>
	<li>从左到右遍历当前数组。</li>
	<li>如果你遇到了 <code>nums1</code>&nbsp;和 <code>nums2</code>&nbsp;中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。</li>
</ul>

<p>得分定义为合法路径中不同数字的和。</p>

<p>请你返回所有可能合法路径中的最大得分。</p>

<p>由于答案可能很大，请你将它对 10^9 + 7 取余后返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

![](./images/sample_1_1893.png)

<pre><strong>输入：</strong>nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
<strong>输出：</strong>30
<strong>解释：</strong>合法路径包括：
[2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
[4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
最大得分为上图中的绿色路径 <strong>[2,4,6,8,10]</strong>&nbsp;。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums1 = [1,3,5,7,9], nums2 = [3,5,100]
<strong>输出：</strong>109
<strong>解释：</strong>最大得分由路径 <strong>[1,3,5,100]</strong> 得到。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
<strong>输出：</strong>40
<strong>解释：</strong>nums1 和 nums2 之间无相同数字。
最大得分由路径 <strong>[6,7,8,9,10]</strong> 得到。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>nums1 = [1,4,5,8,9,11,19], nums2 = [2,3,4,11,12]
<strong>输出：</strong>61
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= nums2.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10^7</code></li>
	<li><code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;都是严格递增的数组。</li>
</ul>

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

    final int MOD = (int) (1e9 + 7);

    public int maxSum(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        if (set1.isEmpty()) {
            return (int) (Math.max(sum(nums1, 0, nums1.length - 1), sum(nums2, 0, nums2.length - 1))
                    % MOD);
        }
        long res = 0;
        List<Integer> list = set1.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int start1 = 0, start2 = 0, end1 = 0, end2 = 0;
        for (int common : list) {
            // 2 个数组同时到达 set
            while (nums1[end1] != common) {
                end1++;
            }
            while (nums2[end2] != common) {
                end2++;
            }
            // max
            res += Math.max(sum(nums1, start1, end1), sum(nums2, start2, end2));
            start1 = end1 + 1;
            start2 = end2 + 1;
        }

        res += Math.max(sum(nums1, end1 + 1, nums1.length - 1),
                sum(nums2, end2 + 1, nums2.length - 1));
        res %= MOD;
        return (int) res;
    }

    private long sum(int[] n, int l, int r) {
        long res = 0;
        while (l <= r) {
            res += n[l++];
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
