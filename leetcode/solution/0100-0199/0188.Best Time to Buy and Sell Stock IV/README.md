# [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv)

[English Version](/solution/0100-0199/0188.Best%20Time%20to%20Buy%20and%20Sell%20Stock%20IV/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个数组，它的第<em> i</em> 个元素是一支给定的股票在第 <em>i </em>天的价格。</p>

<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 <strong>k</strong> 笔交易。</p>

<p><strong>注意:</strong>&nbsp;你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> [2,4,1], k = 2
<strong>输出:</strong> 2
<strong>解释:</strong> 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [3,2,6,5,0,3], k = 2
<strong>输出:</strong> 7
<strong>解释:</strong> 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
&nbsp;    随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
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
    public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
        
        if(k >= prices.length) return maxProfit(prices);
        
		int n = prices.length;
		int[] l = new int[k + 1];
		int[] g = new int[k + 1];

		for (int i = 1; i < n; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j >= 1; j--) {
				l[j] = Math.max(l[j], g[j - 1]) + diff;
				g[j] = Math.max(l[j], g[j]);
			}
		}

		return g[k];
    }
    
    public int maxProfit(int[] prices) {
        // 只要有利润就卖，就是最优解。
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
