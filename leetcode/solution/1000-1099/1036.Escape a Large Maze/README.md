# [1036. 逃离大迷宫](https://leetcode-cn.com/problems/escape-a-large-maze)

[English Version](/solution/1000-1099/1036.Escape%20a%20Large%20Maze/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>在一个 10^6 x 10^6 的网格中，每个网格块的坐标为&nbsp;<code>(x, y)</code>，其中&nbsp;<code>0 &lt;= x, y &lt; 10^6</code>。</p>

<p>我们从源方格&nbsp;<code>source</code>&nbsp;开始出发，意图赶往目标方格&nbsp;<code>target</code>。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表&nbsp;<code>blocked</code>&nbsp;上。</p>

<p>只有在可以通过一系列的移动到达目标方格时才返回&nbsp;<code>true</code>。否则，返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
<strong>输出：</strong>false
<strong>解释：</strong>
从源方格无法到达目标方格，因为我们无法在网格中移动。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>blocked = [], source = [0,0], target = [999999,999999]
<strong>输出：</strong>true
<strong>解释：</strong>
因为没有方格被封锁，所以一定可以到达目标方格。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>0 &lt;= blocked.length &lt;= 200</code></li>
	<li><code>blocked[i].length == 2</code></li>
	<li><code>0 &lt;= blocked[i][j] &lt; 10^6</code></li>
	<li><code>source.length == target.length == 2</code></li>
	<li><code>0 &lt;= source[i][j], target[i][j] &lt; 10^6</code></li>
	<li><code>source != target</code></li>
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

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};


    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return Boolean.TRUE;
        }

        return walk(blocked, source, target) && walk(blocked, target, source);
    }

    private Boolean walk(int[][] blocked, int[] source, int[] target) {
        int N = 1000000;

        Set<Pair<Integer, Integer>> visitSet = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        Pair<Integer, Integer> start = new Pair<>(source[0], source[1]);
        queue.add(start);
        visitSet.add(start);

        Set<Pair> blockedSet = Arrays.stream(blocked).map(item -> new Pair(item[0], item[1])).collect(Collectors.toSet());

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            Integer x = top.getKey();
            Integer y = top.getValue();

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                Pair<Integer, Integer> pair = new Pair<>(newX, newY);
                if (newX < 0 || newY < 0 || newX >= N || newY >= N || visitSet.contains(pair) || blockedSet.contains(pair)) {
                    continue;
                }
                queue.add(pair);
                visitSet.add(pair);
                if (queue.size() >= blocked.length || (newX == target[0] && newY == target[1])) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
