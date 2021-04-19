# [30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words)

[English Version](/solution/0000-0099/0030.Substring%20with%20Concatenation%20of%20All%20Words/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串&nbsp;<strong>s&nbsp;</strong>和一些长度相同的单词&nbsp;<strong>words。</strong>找出 <strong>s </strong>中恰好可以由&nbsp;<strong>words </strong>中所有单词串联形成的子串的起始位置。</p>

<p>注意子串要与&nbsp;<strong>words </strong>中的单词完全匹配，中间不能有其他字符，但不需要考虑&nbsp;<strong>words&nbsp;</strong>中单词串联的顺序。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：
  s =</strong> &quot;barfoothefoobarman&quot;,
<strong>  words = </strong>[&quot;foo&quot;,&quot;bar&quot;]
<strong>输出：</strong><code>[0,9]</code>
<strong>解释：</strong>
从索引 0 和 9 开始的子串分别是 &quot;barfoo&quot; 和 &quot;foobar&quot; 。
输出的顺序不重要, [9,0] 也是有效答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：
  s =</strong> &quot;wordgoodgoodgoodbestword&quot;,
<strong>  words = </strong>[&quot;word&quot;,&quot;good&quot;,&quot;best&quot;,&quot;word&quot;]
<code><strong>输出：</strong>[]</code>
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
    public List<Integer> findSubstring(String s, String[] words) {
		
        List<Integer> re = new ArrayList<>();

        if(s == null || words == null || words.length == 0 || words[0] == null) {
            return re;
        }
        if(s.length() == 0 || words[0].length() == 0 || s.length() < words.length * words[0].length()) {
            return re;
        }
		// 用< 单词，出现次数 > 来存储 words 中的元素，方便查找
        HashMap<String,Integer> map = new HashMap();
        for (String string : words) {
            map.put(string, map.getOrDefault(string,0) + 1);
        }
        int len = words[0].length();
        int strLen = s.length();
        int lastStart = len * words.length - len;

        for (int i = 0; i < len; i++) {
            for (int j = i; j <= strLen - len - lastStart; j += len) {
                String tempStr = s.substring(j, j + len);
                if(map.containsKey(tempStr)) {                    
                    HashMap<String,Integer> searched = new HashMap<>();
					// 从后向前依次对比
					int tempIndex = j + lastStart;
                    String matchedStr = s.substring(tempIndex, tempIndex + len);
                    while (tempIndex >= j && map.containsKey(matchedStr)) {
                        // 正确匹配到单词
                        if(searched.getOrDefault(matchedStr,0) < map.get(matchedStr)) {
                            searched.put(matchedStr, searched.getOrDefault(matchedStr,0) + 1);
                        }
                        else {
                            break;
                        }
                        tempIndex -= len;
                        if(tempIndex < j) {
                            break;
                        }
                        matchedStr = s.substring(tempIndex, tempIndex + len);
                    }
					// 完全匹配所以单词
                    if(j > tempIndex) {
                        re.add(j);
                    }
					// 从tempIndex 到 tempIndex + len 这个单词不能正确匹配
                    else {
                        j = tempIndex;
                    }
                }
            }
        }
        return re;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
