# [132. 分割回文串 II](https://leetcode-cn.com/problems/palindrome-partitioning-ii)

[English Version](/solution/0100-0199/0132.Palindrome%20Partitioning%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串 <em>s</em>，将 <em>s</em> 分割成一些子串，使每个子串都是回文串。</p>

<p>返回符合要求的最少分割次数。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>&nbsp;&quot;aab&quot;
<strong>输出:</strong> 1
<strong>解释: </strong>进行一次分割就可将&nbsp;<em>s </em>分割成 [&quot;aa&quot;,&quot;b&quot;] 这样两个回文子串。
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
    public int minCut(String s) {
        if(s==null || s.length()<=1)return 0;
        int len = s.length();
        int[] dp = new int[len];
        for(int i=0;i<len;i++) dp[i] = len - 1;
        for(int i=0;i<len;i++){
            mincutHelper(s , i , i , dp);
            mincutHelper(s, i , i+1 , dp);
        }
        return dp[len-1];
    }
    private void mincutHelper(String s, int i, int j, int[] dp){
        int len = s.length();
        while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){
            dp[j] = Math.min(dp[j] , (i==0?-1:dp[i-1])+1);
            i--;
            j++;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
