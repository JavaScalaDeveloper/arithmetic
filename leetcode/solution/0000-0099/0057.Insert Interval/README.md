# [57. 插入区间](https://leetcode-cn.com/problems/insert-interval)

[English Version](/solution/0000-0099/0057.Insert%20Interval/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给出一个<em>无重叠的 ，</em>按照区间起始端点排序的区间列表。</p>

<p>在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> intervals = [[1,3],[6,9]], newInterval = [2,5]
<strong>输出:</strong> [[1,5],[6,9]]
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> intervals = <code>[[1,2],[3,5],[6,7],[8,10],[12,16]]</code>, newInterval = <code>[4,8]</code>
<strong>输出:</strong> [[1,2],[3,10],[12,16]]
<strong>解释:</strong> 这是因为新的区间 <code>[4,8]</code> 与 <code>[3,5],[6,7],[8,10]</code>&nbsp;重叠。
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
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<>();
        int i = 0;
        while ((i < intervals.size()) && (intervals.get(i).end < newInterval.start)) list.add(intervals.get(i++));
        while ((i < intervals.size()) && (intervals.get(i).start <= newInterval.end)) {
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            i++;
        }
        list.add(newInterval);
        while (i < intervals.size()) list.add(intervals.get(i++));
        return list;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
