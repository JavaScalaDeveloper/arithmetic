# [502. IPO](https://leetcode-cn.com/problems/ipo)

[English Version](/solution/0500-0599/0502.IPO/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 <strong>k</strong> 个不同的项目。帮助 力扣 设计完成最多 <strong>k</strong> 个不同项目后得到最大总资本的方式。</p>

<p>给定若干个项目。对于每个项目 <strong>i</strong>，它都有一个纯利润 <strong>P<sub>i</sub></strong>，并且需要最小的资本 <strong>C<sub>i</sub></strong> 来启动相应的项目。最初，你有 <strong>W</strong> 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。</p>

<p>总而言之，从给定项目中选择最多 <strong>k</strong> 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

<strong>输出:</strong> 4

<strong>解释:
</strong>由于你的初始资本为 0，你尽可以从 0 号项目开始。
在完成后，你将获得 1 的利润，你的总资本将变为 1。
此时你可以选择开始 1 号或 2 号项目。
由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
</pre>

<p>&nbsp;</p>

<p><strong>注意:</strong></p>

<ol>
	<li>假设所有输入数字都是非负整数。</li>
	<li>表示利润和资本的数组的长度不超过 50000。</li>
	<li>答案保证在 32 位有符号整数范围内。</li>
</ol>

<p>&nbsp;</p>

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
    /**
     * 贪心算法
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 首先检查是否存在所有项目都可投资且初始资本 W >= max(Capital) 的情况。如果是，返回利润中前 k 个最大元素的和。
        boolean speedUp = true;
        for (int c : Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h : heap) W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        for (int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // 找到获取利润最多的项目
            for (int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // 找不到合适的项目
            if (idx == -1) break;
            // 累计当前项目的利润到总利润中，并把当前项目标记为"不可用"（设置成最大整数）
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return W;
    }
} 

```

### **...**

```

```

<!-- tabs:end -->
