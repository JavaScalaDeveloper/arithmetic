# [289. 生命游戏](https://leetcode-cn.com/problems/game-of-life)

[English Version](/solution/0200-0299/0289.Game%20of%20Life/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>根据<a href="https://baike.baidu.com/item/%E7%94%9F%E5%91%BD%E6%B8%B8%E6%88%8F/2926434?fr=aladdin" target="_blank">百度百科</a>，生命游戏，简称为生命，是英国数学家约翰&middot;何顿&middot;康威在1970年发明的细胞自动机。</p>

<p>给定一个包含 m &times; n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 <em>live</em>（1）即为活细胞， 或 <em>dead</em>（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：</p>

<ol>
	<li>如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；</li>
	<li>如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；</li>
	<li>如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；</li>
	<li>如果死细胞周围正好有三个活细胞，则该位置死细胞复活；</li>
</ol>

<p>根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入: 
</strong>[
&nbsp; [0,1,0],
&nbsp; [0,0,1],
&nbsp; [1,1,1],
&nbsp; [0,0,0]
]
<strong>输出: 
</strong>[
&nbsp; [0,0,0],
&nbsp; [1,0,1],
&nbsp; [0,1,1],
&nbsp; [0,1,0]
]</pre>

<p><strong>进阶:</strong></p>

<ul>
	<li>你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。</li>
	<li>本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？</li>
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
    public void gameOfLife(int[][] board) {
		final int m = board.length;
		final int n = board[0].length;
        
        /**
            状态0：死细胞转为死细胞
            状态1：活细胞转为活细胞
            状态2：活细胞转为死细胞
            状态3：死细胞转为活细胞
        **/
        
		// encode
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int live = countLive(board, i, j); // number of live cells
				if (board[i][j] == 0 && live == 3) {
					board[i][j] = 3;
				} else if (board[i][j] == 1 && (live < 2 || live > 3)) {
					board[i][j] = 2;
				}
			}
		}
		// decode
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] %= 2;
			}
		}
	}
	
	private int countLive(int[][] nums, int i, int j) {
        int count = 0;
        int m = nums.length, n = nums[0].length;
        for(int x = i - 1; x <= i + 1; x++) {
            for(int y = j - 1; y <= j + 1; y++) {
                if(x == i && y == j) continue;
                if(x >= 0 && x < m && y >= 0 && y < n && (nums[x][y] == 1 || nums[x][y] == 2)) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
