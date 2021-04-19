# [247. 中心对称数 II](https://leetcode-cn.com/problems/strobogrammatic-number-ii)

[English Version](/solution/0200-0299/0247.Strobogrammatic%20Number%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>中心对称数是指一个数字在旋转了&nbsp;180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>

<p>找到所有长度为 n 的中心对称数。</p>

<p><strong>示例</strong> <strong>:</strong></p>

<pre><strong>输入:</strong>  n = 2
<strong>输出:</strong> <code>["11","69","88","96"]</code>
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
    Map<Character, Character> map = new HashMap<>();
    {
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
    }

    public List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> ans = new ArrayList<>();
        dfs(n, ans, "");
        return ans;
    }

    private void dfs(int n, List<String> ans, String tmp) {
        if (tmp.length() == (n + 1) / 2) {
            fillAns(n, ans, tmp);
            return;
        }

        for (char c : map.keySet()) {
            int num = c - '0';
            // 首位不能是0
            if (tmp.length() == 0 && num == 0) {
                continue;
            }
            // 奇数的中间位只能是 0 1 8
            if (n % 2 != 0 && tmp.length() == n / 2 && !(num == 0 || num == 1 || num == 8)) {
                continue;
            }
            dfs(n, ans, tmp + num);
        }
    }

    private void fillAns(int n, List<String> ans, String tmp) {
        char[] a = new char[n];
        for (int i = 0; i < tmp.length(); i++) {
            a[i] = tmp.charAt(i);
            a[n - i - 1] = map.get(tmp.charAt(i));
        }
        if (n % 2 != 0) {
            a[tmp.length() - 1] = tmp.charAt(tmp.length() - 1);
        }
        ans.add(new String(a));
    }
}

```

### **...**

```

```

<!-- tabs:end -->
