# [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning)

[English Version](/solution/0100-0199/0131.Palindrome%20Partitioning/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串 <em>s</em>，将<em> s </em>分割成一些子串，使每个子串都是回文串。</p>

<p>返回 <em>s</em> 所有可能的分割方案。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong>&nbsp;&quot;aab&quot;
<strong>输出:</strong>
[
  [&quot;aa&quot;,&quot;b&quot;],
  [&quot;a&quot;,&quot;a&quot;,&quot;b&quot;]
]</pre>

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
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res= new ArrayList<>();
        func(new ArrayList<>(),0,s);
        return res;
    }
    private void func(List<String> temp, int start, String str){
        if(start>=str.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        int ed=str.indexOf(str.charAt(start),start+1);
        while(ed>0){
            int s=start;
            int e=ed;
            boolean flag=false;
            while(s<e){
                if(str.charAt(s)==str.charAt(e)){
                    s++;
                    e--;
                } else{
                    flag=true;
                    break;
                }
            }
            if(!flag){
                temp.add(str.substring(start,ed+1));
                func(temp,ed+1,str);
                temp.remove(temp.size()-1);
            }
            ed=str.indexOf(str.charAt(start),ed+1);
        }
        temp.add(str.substring(start,start+1));
        func(temp,start+1,str);
        temp.remove(temp.size()-1);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
