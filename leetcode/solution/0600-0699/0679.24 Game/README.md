# [679. 24 点游戏](https://leetcode-cn.com/problems/24-game)

[English Version](/solution/0600-0699/0679.24%20Game/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过&nbsp;<code>*</code>，<code>/</code>，<code>+</code>，<code>-</code>，<code>(</code>，<code>)</code>&nbsp;的运算得到 24。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [4, 1, 8, 7]
<strong>输出:</strong> True
<strong>解释:</strong> (8-4) * (7-1) = 24
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [1, 2, 1, 2]
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>除法运算符&nbsp;<code>/</code>&nbsp;表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。</li>
	<li>每个运算符对两个数进行运算。特别是我们不能用&nbsp;<code>-</code>&nbsp;作为一元运算符。例如，<code>[1, 1, 1, 1]</code>&nbsp;作为输入时，表达式&nbsp;<code>-1 - 1 - 1 - 1</code>&nbsp;是不允许的。</li>
	<li>你不能将数字连接在一起。例如，输入为&nbsp;<code>[1, 2, 1, 2]</code>&nbsp;时，不能写成 12 + 12 。</li>
</ol>

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
    public boolean judgePoint24(int[] nums) {
        return dfs(Arrays.stream(nums).boxed().map(Double::new).collect(Collectors.toList()));
    }

    private boolean dfs(List<Double> numList) {
        if (numList.size() == 0) {
            return false;
        }
        if (numList.size() == 1) {
            return Math.abs(Math.abs(numList.get(0) - 24.0)) < 0.000001d;
        }
        for (int i = 0; i < numList.size(); i++) {
            for (int j = i + 1; j < numList.size(); j++) {
                boolean valid = dfs(getList(numList, i, j, 0)) || dfs(getList(numList, i, j, 1))
                        || dfs(getList(numList, i, j, 2)) || dfs(getList(numList, i, j, 3))
                        || dfs(getList(numList, i, j, 4)) || dfs(getList(numList, i, j, 5));
                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Double> getList(List<Double> numList, int i, int j, int operate) {
        List<Double> candidate = new ArrayList<>();
        for (int k = 0; k < numList.size(); k++) {
            if (k == i || k == j) {
                continue;
            }
            candidate.add(numList.get(k));
        }

        switch (operate) {
            // a + b
            case 0:
                candidate.add(numList.get(i) + numList.get(j));
                break;
            // a - b
            case 1:
                candidate.add(numList.get(i) - numList.get(j));
                break;
            // b - a
            case 2:
                candidate.add(numList.get(j) - numList.get(i));
                break;
            // a * b
            case 3:
                candidate.add(numList.get(i) * numList.get(j));
                break;
            // a / b
            case 4:
                if (numList.get(j) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(i) / numList.get(j));
                break;
            // b / a
            case 5:
                if (numList.get(i) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(j) / numList.get(i));
                break;
        }
        return candidate;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
