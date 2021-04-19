# [151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string)

[English Version](/solution/0100-0199/0151.Reverse%20Words%20in%20a%20String/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串，逐个翻转字符串中的每个单词。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> &quot;<code>the sky is blue</code>&quot;
<strong>输出:&nbsp;</strong>&quot;<code>blue is sky the</code>&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> &quot; &nbsp;hello world! &nbsp;&quot;
<strong>输出:&nbsp;</strong>&quot;world! hello&quot;
<strong>解释: </strong>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入:</strong> &quot;a good &nbsp; example&quot;
<strong>输出:&nbsp;</strong>&quot;example good a&quot;
<strong>解释: </strong>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
</pre>

<p>&nbsp;</p>

<p><strong>说明：</strong></p>

<ul>
	<li>无空格字符构成一个单词。</li>
	<li>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。</li>
	<li>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<p>请选用 C 语言的用户尝试使用&nbsp;<em>O</em>(1) 额外空间复杂度的原地解法。</p>

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
    public String reverseWords(String s) {
        int length = s.length();
        if(length ==0)return s;
        char[] res=new char[length];
        int len=helper(s.toCharArray(), length -1,res,0,0);
        return new String(res,0,len);
    }
    private int helper(char[] ch,int r,char[] res,int l,int len){
        while(r>=0&&ch[r]==' ') r--;
        if(r<0)return Math.max(0,len-1);
        int rigth=r;
        while(r>=0&&ch[r]!=' ') r--;
        len+=rigth-r+1;
        for(int left=r+1;left<=rigth;left++,l++) res[l] = ch[left];
        if(l<res.length) res[l++] = ' ';
        return helper(ch,r,res,l,len);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
