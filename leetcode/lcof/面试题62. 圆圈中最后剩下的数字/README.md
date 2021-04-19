# [面试题 62. 圆圈中最后剩下的数字](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

## 题目描述

<!-- 这里写题目描述 -->

0,1,,n-1 这 n 个数字排成一个圆圈，从数字 0 开始，每次从这个圆圈里删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4 这 5 个数字组成一个圆圈，从数字 0 开始每次删除第 3 个数字，则删除的前 4 个数字依次是 2、0、4、1，因此最后剩下的数字是 3。

**示例 1：**

```
输入: n = 5, m = 3
输出: 3
```

**示例 2：**

```
输入: n = 10, m = 17
输出: 2
```

**限制：**

- `1 <= n <= 10^5`
- `1 <= m <= 10^6`

## 解法

<!-- 这里可写通用的实现逻辑 -->

设 `f(n, m)` 表示从 n 个数中每次删除第 m 个，最后剩下的数字。

第一次删除第 m 个，剩下 `n-1` 个数，那么 `x = f(n - 1, m)` 就表示从 n-1 个数中每次删除第 m 个，最后剩下的数字。

我们求得 x 之后，便可以知道，`f(n, m)` 应该是从 `m % n` 开始数的第 x 个元素，即 `f(n, m) = ((m % n) + x) % n`。

当 n 为 1 时，最后留下的数字序号一定为 0。

递归求解即可，也可以改成迭代。

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

递归版本：

```python
class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        def f(n, m):
            if n == 1:
                return 0
            x = f(n - 1, m)
            return (m + x) % n
        return f(n, m)
```

迭代版本：

```python
class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        f = 0
        for i in range(2, n + 1):
            f = (f + m) % i
        return f
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i <= n; ++i) {
            f = (f + m) % i;
        }
        return f;
    }
}
```

### **JavaScript**

```js
/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
var lastRemaining = function (n, m) {
  // 约瑟夫环
  let res = 0;
  for (let i = 1; i <= n; i++) {
    res = (res + m) % i;
  }
  return res;
};
```

### **...**

```

```

<!-- tabs:end -->
