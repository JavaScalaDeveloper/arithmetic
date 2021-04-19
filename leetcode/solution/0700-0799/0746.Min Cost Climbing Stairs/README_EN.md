# [746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs)

[中文文档](/solution/0700-0799/0746.Min%20Cost%20Climbing%20Stairs/README.md)

## Description

<p>

On a staircase, the <code>i</code>-th step has some non-negative cost <code>cost[i]</code> assigned (0 indexed).

</p><p>

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

</p>

<p><b>Example 1:</b><br />

<pre>

<b>Input:</b> cost = [10, 15, 20]

<b>Output:</b> 15

<b>Explanation:</b> Cheapest is start on cost[1], pay that cost and go to the top.

</pre>

</p>

<p><b>Example 2:</b><br />

<pre>

<b>Input:</b> cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]

<b>Output:</b> 6

<b>Explanation:</b> Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

</pre>

</p>

<p><b>Note:</b><br>

<ol>

<li><code>cost</code> will have a length in the range <code>[2, 1000]</code>.</li>

<li>Every <code>cost[i]</code> will be an integer in the range <code>[0, 999]</code>.</li>

</ol>

</p>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        pre = cur = 0
        n = len(cost)
        for i in range(1, n):
            t = min(cost[i] + cur, cost[i - 1] + pre)
            pre, cur = cur, t
        return cur
```

### **Java**

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, cur = 0;
        for (int i = 1, n = cost.length; i < n; ++i) {
            int t = Math.min(cost[i] + cur, cost[i - 1] + pre);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
