# [16.10. Living People](https://leetcode-cn.com/problems/living-people-lcci)

[中文文档](/lcci/16.10.Living%20People/README.md)

## Description

<p>Given a list of people with their birth and death years, implement a method to compute the year with the most number of people alive. You may assume that all people were born between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should be included in that year&#39;s count. For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.</p>

<p>If there are more than one years&nbsp;that have the most number of people alive, return the smallest one.</p>

<p><strong>Example: </strong></p>

<pre>

<strong>Input: </strong>

birth = {1900, 1901, 1950}

death = {1948, 1951, 2000}

<strong>Output: </strong> 1901

</pre>

<p><strong>Note: </strong></p>

<ul>
	<li><code>0 &lt; birth.length == death.length &lt;= 10000</code></li>
	<li><code>birth[i] &lt;= death[i]</code></li>
</ul>

## Solutions

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def maxAliveYear(self, birth: List[int], death: List[int]) -> int:
        years = [0] * 101
        for i in range(len(birth)):
            start = birth[i] - 1900
            end = death[i] - 1900
            for j in range(start, end + 1):
                years[j] += 1
        max_v = years[0]
        res = 0
        for i in range(1, 101):
            if years[i] > max_v:
                max_v = years[i]
                res = i
        return 1900 + res
```

### **Java**

```java
class Solution {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] years = new int[101];
        int n = birth.length;
        for (int i = 0; i < n; ++i) {
            int start = birth[i] - 1900;
            int end = death[i] - 1900;
            for (int j = start; j <= end; ++j) {
                ++years[j];
            }
        }
        int max = years[0];
        int res = 0;
        for (int i = 1; i < 101; ++i) {
            if (years[i] > max) {
                max = years[i];
                res = i;
            }
        }
        return 1900 + res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
