# [406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height)

[English Version](/solution/0400-0499/0406.Queue%20Reconstruction%20by%20Height/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对<code>(h, k)</code>表示，其中<code>h</code>是这个人的身高，<code>k</code>是排在这个人前面且身高大于或等于<code>h</code>的人数。 编写一个算法来重建这个队列。</p>

<p><strong>注意：</strong><br />
总人数少于1100人。</p>

<p><strong>示例</strong></p>

<pre>
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
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
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }
}

```

### **...**

```

```

<!-- tabs:end -->
