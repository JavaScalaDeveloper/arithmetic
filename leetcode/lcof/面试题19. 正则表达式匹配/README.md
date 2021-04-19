# [面试题 19. 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

## 题目描述

请实现一个函数用来匹配包含`'. '`和`'*'`的正则表达式。模式中的字符`'.'`表示任意一个字符，而`'*'`表示它前面的字符可以出现任意次（含 0 次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串`"aaa"`与模式`"a.a"`和`"ab*ac*a"`匹配，但与`"aa.a"`和`"ab*a"`均不匹配。

**示例 1:**

```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```

**示例 2:**

```
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```

**示例  3:**

```
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```

**示例 4:**

```
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
```

**示例 5:**

```
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```

- `s`  可能为空，且只包含从  `a-z`  的小写字母。
- `p`  可能为空，且只包含从  `a-z`  的小写字母，以及字符  `.`  和  `*`。

## 解法

动态规划法，`dp[i][j]` 表示 s 的前 i 项和 p 的前 j 项是否匹配。

现在如果已知了 `dp[i-1][j-1]` 的状态，我们该如何确定 `dp[i][j]` 的状态呢？我们可以分三种情况讨论，其中，前两种情况考虑了所有能匹配的情况，剩下的就是不能匹配的情况了：

1. `s[i] == p[j]` or `p[j] == '.'`：比如 ab**b** 和 ab**b**，或者 ab**b** 和 ab. ，很容易得到 `dp[i][j]` = `dp[i-1][j-1]` = True。因为 ab 和 ab 是匹配的，如果后面分别加一个 b，或者 s 加一个 b 而 p 加一个 `.` ，仍然是匹配的。
2. `p[j] == '*'`：当 `p[j] == '*'` 时，由于 `*` 与前面的字符相关，因此我们比较 `*` 前面的字符 `p[j-1]` 和 `s[i]` 的关系。根据 `*` 前面的字符与 s[i] 是否相等，又可分为以下两种情况：
   - `p[j-1] != s[i]`：如果 `*` 前一个字符匹配不上，`*` 匹配了 0 次，应忽略这两个字符，看 `p[j-2]` 和 `s[i]` 是否匹配。 这时 `dp[i][j] = dp[i][j-2]`。
   - `p[j-1] == s[i]` or `p[j-1] == '.'`：`*` 前面的字符可以与 s[i] 匹配，这种情况下，`*` 可能匹配了前面的字符的 0 个，也可能匹配了前面字符的多个，当匹配 0 个时，如 `ab` 和 `abb*`，或者 `ab` 和 `ab.*` ，这时我们需要去掉 p 中的 `b*` 或 `.*` 后进行比较，即 `dp[i][j] = dp[i][j-2]`；当匹配多个时，如 `abbb` 和 `ab*`，或者 `abbb` 和 `a.*`，我们需要将 s[i] 前面的与 p 重新比较，即 `dp[i][j] = dp[i-1][j]`。
3. 其他情况：以上两种情况把能匹配的都考虑全面了，所以其他情况为不匹配，即 `dp[i][j] = False`。

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s) + 1, len(p) + 1
        if n == 1:
            return m == 1
        dp = [[False for _ in range(n)] for _ in range(m)]
        dp[0][0], dp[0][1] = True, False
        for j in range(2, n):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]
        for i in range(1, m):
            for j in range(1, n):
                if s[i - 1] == p[j - 1] or p[j - 1] == '.':
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    if p[j - 2] == '.' or p[j - 2] == s[i - 1]:
                        dp[i][j] = dp[i][j - 2] or dp[i - 1][j]
                    else:
                        dp[i][j] = dp[i][j - 2]
                else:
                    dp[i][j] = False
        return dp[m - 1][n - 1]

```

### **Java**

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        if (n == 1) {
            return m == 1;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        dp[0][1] = false;
        for (int j = 1; j < n; ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

### **JavaScript**

```js
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
  // 回溯大法好
  let memo = {};
  function recursive(i, j) {
    if (memo[[i, j]] !== undefined) return memo[[i, j]];
    if (j === p.length) return i === s.length;
    let tmp = i < s.length && (s[i] === p[j] || p[j] === ".");
    let ans = false;
    if (p[j + 1] === "*") {
      ans = recursive(i, j + 2) || (tmp && recursive(i + 1, j));
    } else {
      ans = tmp && recursive(i + 1, j + 1);
    }
    memo[[i, j]] = ans;
    return ans;
  }
  return recursive(0, 0);
};
```

### **C++**

```cpp
class Solution {
public:
    bool match(string s, string p, int sl, int pl) {
        /* 说明：sl指的是s的len，pl指的是p的len。
           使用这种写法，在牛客上是能ac的。在leetcode上会显示特定的用例超时。
           写在这里，给大家提供一种新的思路吧。
           二维动态规划应该更适合做这一题的题解（参考java版本答案） */
        if (sl == s.size() && pl == p.size()) {
            return true;
        }

        if (sl < s.size() && pl == p.size()) {
            return false;
        }

        if (p[pl+1] != '*') {
            // 如果p的下一个不是*的情况
            if ((s[sl] == p[pl]) || (sl<s.size() && p[pl] == '.')) {
                return match(s, p, sl+1, pl+1);
            } else {
                return false;
            }
        } else {
            if ((s[sl] == p[pl]) || (sl<s.size() && p[pl] == '.')) {
                return match(s, p, sl, pl+2) || match(s, p, sl+1, pl);
            } else {
                return match(s, p, sl, pl+2);
            }
        }
    }

    bool isMatch(string s, string p) {
        return match(s, p, 0, 0);
    }
};
```

### **...**

```

```

<!-- tabs:end -->
