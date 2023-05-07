
# [1. 两数之和](https://leetcode-cn.com/problems/two-sum)
## 题目描述

<p>给定一个整数数组 <code>nums</code>&nbsp;和一个目标值 <code>target</code>，请你在该数组中找出和为目标值的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回他们的数组下标。</p>
<p>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。</p>
<p><strong>示例:</strong></p>
<pre>给定 nums = [2, 7, 11, 15], target = 9
因为 nums[<strong>0</strong>] + nums[<strong>1</strong>] = 2 + 7 = 9
所以返回 [<strong>0, 1</strong>]
</pre>


## 解法
用哈希表（字典）存放数组值以及对应的下标。
遍历数组，当发现 `target - nums[i]` 在哈希表中，说明找到了目标值。

### **Java**
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
```

# [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers)
## 题目描述

<p>给出两个&nbsp;<strong>非空</strong> 的链表用来表示两个非负的整数。其中，它们各自的位数是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且它们的每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>
<p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。</p>
<p>您可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>(2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
<strong>输出：</strong>7 -&gt; 0 -&gt; 8
<strong>原因：</strong>342 + 465 = 807
</pre>



## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int t = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = t / 10;
            cur.next = new ListNode(t % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
```

# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)
## 题目描述

<p>给定一个字符串，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>&quot;abcabcbb&quot;
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>&quot;bbbbb&quot;
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>&quot;b&quot;</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入: </strong>&quot;pwwkew&quot;
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>



## 解法

### **Java**
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int fast = 0, slow = 0; fast < s.length(); fast ++) {
            if (map.containsKey(s.charAt(fast))) {
                int target = map.get(s.charAt(fast)) + 1;
                slow = target < slow ? slow : target;
            }
            map.put(s.charAt(fast), fast);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
```


# [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring)
## 题目描述

<p>给定一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。你可以假设&nbsp;<code>s</code> 的最大长度为 1000。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> &quot;babad&quot;
<strong>输出:</strong> &quot;bab&quot;
<strong>注意:</strong> &quot;aba&quot; 也是一个有效答案。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入:</strong> &quot;cbbd&quot;
<strong>输出:</strong> &quot;bb&quot;
</pre>


## 解法

### **Java**
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String str = "";
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] res = new boolean[len][len];
        int start = 0;
        int max = 1;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {
                res[j][i] = i - j < 2 ? chars[j] == chars[i] : res[j + 1][i - 1] && chars[j] == chars[i];
                if (res[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
```

# [6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion)
## 题目描述

<p>将一个给定字符串根据给定的行数，以从上往下、从左到右进行&nbsp;Z 字形排列。</p>
<p>比如输入字符串为 <code>&quot;LEETCODEISHIRING&quot;</code>&nbsp;行数为 3 时，排列如下：</p>
<pre>L   C   I   R
E T O E S I I G
E   D   H   N
</pre>

<p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>&quot;LCIRETOESIIGEDHN&quot;</code>。</p>
<p>请你实现这个将字符串进行指定行数变换的函数：</p>
<pre>string convert(string s, int numRows);</pre>

<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows = 3
<strong>输出:</strong> &quot;LCIRETOESIIGEDHN&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> s = &quot;LEETCODEISHIRING&quot;, numRows =&nbsp;4
<strong>输出:</strong>&nbsp;&quot;LDREOEIIECIHNTSG&quot;
<strong>解释:</strong>
L     D     R
E   O E   I I
E C   I H   N
T     S     G</pre>


## 解法

### **Java**
```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int group = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            int interval = 2 * numRows - 2 * i;
            if (i == numRows) interval = 2 * numRows - 2;
            int index = i;
            while (index <= s.length()) {
                result.append(s.charAt(index - 1));
                index += interval;
                interval = group - interval;
                if (interval == 0) interval = group;
            }
        }
        return result.toString();
    }
}
```

# [7. 整数反转](https://leetcode-cn.com/problems/reverse-integer)
## 题目描述

<p>给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 123
<strong>输出:</strong> 321
</pre>

<p><strong>&nbsp;示例 2:</strong></p>
<pre><strong>输入:</strong> -123
<strong>输出:</strong> -321
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> 120
<strong>输出:</strong> 21
</pre>

<p><strong>注意:</strong></p>
<p>假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为&nbsp;[&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。</p>

## 解法

### **Java**
```java
/*
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
       
        long tmp = x;
        boolean isPositive = true;
        if (tmp < 0) {
            isPositive = false;
            tmp = -tmp;
        }
       
        long val = Long.parseLong(new StringBuilder(String.valueOf(tmp)).reverse().toString());
       
        return isPositive ? (val > Integer.MAX_VALUE ? 0 : (int) val) : (-val < Integer.MIN_VALUE ? 0 : (int) (-val)); 
        
    }
}
*/
class Solution {
    public int reverse(int x) {
        long res = 0;
        // 考虑负数情况，所以这里条件为: x != 0
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) 
            ? 0
            : (int) res;
            
    }
}
```

# [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi)
## 题目描述

<p>请你来实现一个&nbsp;<code>atoi</code>&nbsp;函数，使其能将字符串转换成整数。</p>
<p>首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。</p>
<p>当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。</p>
<p>该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。</p>
<p>注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。</p>
<p>在任何情况下，若函数不能进行有效的转换时，请返回 0。</p>
<p><strong>说明：</strong></p>
<p>假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为&nbsp;[&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。如果数值超过这个范围，请返回 &nbsp;INT_MAX (2<sup>31&nbsp;</sup>&minus; 1) 或&nbsp;INT_MIN (&minus;2<sup>31</sup>) 。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> &quot;42&quot;
<strong>输出:</strong> 42
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> &quot;   -42&quot;
<strong>输出:</strong> -42
<strong>解释: </strong>第一个非空白字符为 &#39;-&#39;, 它是一个负号。
&nbsp;    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> &quot;4193 with words&quot;
<strong>输出:</strong> 4193
<strong>解释:</strong> 转换截止于数字 &#39;3&#39; ，因为它的下一个字符不为数字。
</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong> &quot;words and 987&quot;
<strong>输出:</strong> 0
<strong>解释:</strong> 第一个非空字符是 &#39;w&#39;, 但它不是数字或正、负号。
     因此无法执行有效的转换。</pre>

<p><strong>示例&nbsp;5:</strong></p>
<pre><strong>输入:</strong> &quot;-91283472332&quot;
<strong>输出:</strong> -2147483648
<strong>解释:</strong> 数字 &quot;-91283472332&quot; 超过 32 位有符号整数范围。 
&nbsp;    因此返回 INT_MIN (&minus;2<sup>31</sup>) 。
</pre>


## 解法
遍历字符串，注意做溢出处理。
同[面试题 67. 把字符串转换成整数](/lcof/面试题67.%20把字符串转换成整数/README.md)。

### **Java**
```java
class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            // 仅包含空格
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            // 非数字，跳出循环体
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            // 溢出判断
            if (res > flag || (res == flag && s.charAt(i) > '7')) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
}
```

# [9. 回文数](https://leetcode-cn.com/problems/palindrome-number)
## 题目描述

<p>判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 121
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> -121
<strong>输出:</strong> false
<strong>解释:</strong> 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> 10
<strong>输出:</strong> false
<strong>解释:</strong> 从右向左读, 为 01 。因此它不是一个回文数。
</pre>

<p><strong>进阶:</strong></p>
<p>你能不将整数转为字符串来解决这个问题吗？</p>

## 解法

### **Java**
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0, t = x;
        while (t != 0) {
            y = y * 10 + t % 10;
            t /= 10;
        }
        return x == y;
    }
}
```


# [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water)
## 题目描述

<p>给你 <em>n</em> 个非负整数 <em>a</em><sub>1</sub>，<em>a</em><sub>2，</sub>...，<em>a</em><sub>n，</sub>每个数代表坐标中的一个点&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 。在坐标内画 <em>n</em> 条垂直线，垂直线 <em>i</em>&nbsp;的两个端点分别为&nbsp;(<em>i</em>,&nbsp;<em>a<sub>i</sub></em>) 和 (<em>i</em>, 0)。找出其中的两条线，使得它们与&nbsp;<em>x</em>&nbsp;轴共同构成的容器可以容纳最多的水。</p>
<p><strong>说明：</strong>你不能倾斜容器，且&nbsp;<em>n</em>&nbsp;的值至少为 2。</p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210307160021127.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><small>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为&nbsp;49。</small></p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[1,8,6,2,5,4,8,3,7]
<strong>输出：</strong>49</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;
        while (start < end) {
            int hs = height[start];
            int he = height[end];
            int l = end - start;
            if (hs > he) {
                maxArea = Math.max(he * l, maxArea);
                end--;
            } else {
                maxArea = Math.max(hs * l, maxArea);
                start++;
            }
        }
        return maxArea;
    }
}
```

# [12. 整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman)
## 题目描述

<p>罗马数字包含以下七种字符：&nbsp;<code>I</code>，&nbsp;<code>V</code>，&nbsp;<code>X</code>，&nbsp;<code>L</code>，<code>C</code>，<code>D</code>&nbsp;和&nbsp;<code>M</code>。</p>
<pre><strong>字符</strong>          <strong>数值</strong>
I             1
V             5
X             10
L             50
C             100
D             500
M             1000</pre>

<p>例如， 罗马数字 2 写做&nbsp;<code>II</code>&nbsp;，即为两个并列的 1。12 写做&nbsp;<code>XII</code>&nbsp;，即为&nbsp;<code>X</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。 27 写做&nbsp;&nbsp;<code>XXVII</code>, 即为&nbsp;<code>XX</code>&nbsp;+&nbsp;<code>V</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。</p>
<p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做&nbsp;<code>IIII</code>，而是&nbsp;<code>IV</code>。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为&nbsp;<code>IX</code>。这个特殊的规则只适用于以下六种情况：</p>
<ul>
	<li><code>I</code>&nbsp;可以放在&nbsp;<code>V</code>&nbsp;(5) 和&nbsp;<code>X</code>&nbsp;(10) 的左边，来表示 4 和 9。</li>
	<li><code>X</code>&nbsp;可以放在&nbsp;<code>L</code>&nbsp;(50) 和&nbsp;<code>C</code>&nbsp;(100) 的左边，来表示 40 和&nbsp;90。&nbsp;</li>
	<li><code>C</code>&nbsp;可以放在&nbsp;<code>D</code>&nbsp;(500) 和&nbsp;<code>M</code>&nbsp;(1000) 的左边，来表示&nbsp;400 和&nbsp;900。</li>
</ul>
<p>给定一个整数，将其转为罗马数字。输入确保在 1&nbsp;到 3999 的范围内。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>&nbsp;3
<strong>输出:</strong> &quot;III&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>&nbsp;4
<strong>输出:</strong> &quot;IV&quot;</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>&nbsp;9
<strong>输出:</strong> &quot;IX&quot;</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong>&nbsp;58
<strong>输出:</strong> &quot;LVIII&quot;
<strong>解释:</strong> L = 50, V = 5, III = 3.
</pre>

<p><strong>示例&nbsp;5:</strong></p>
<pre><strong>输入:</strong>&nbsp;1994
<strong>输出:</strong> &quot;MCMXCIV&quot;
<strong>解释:</strong> M = 1000, CM = 900, XC = 90, IV = 4.</pre>


## 解法

### **Java**
```java
class Solution {
    private final String[] M = {"", "M", "MM", "MMM"};
    private final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String intToRoman(int num) {
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
```

# [13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer)
## 题目描述

<p>罗马数字包含以下七种字符:&nbsp;<code>I</code>，&nbsp;<code>V</code>，&nbsp;<code>X</code>，&nbsp;<code>L</code>，<code>C</code>，<code>D</code>&nbsp;和&nbsp;<code>M</code>。</p>
<pre><strong>字符</strong>          <strong>数值</strong>
I             1
V             5
X             10
L             50
C             100
D             500
M             1000</pre>

<p>例如， 罗马数字 2 写做&nbsp;<code>II</code>&nbsp;，即为两个并列的 1。12 写做&nbsp;<code>XII</code>&nbsp;，即为&nbsp;<code>X</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。 27 写做&nbsp;&nbsp;<code>XXVII</code>, 即为&nbsp;<code>XX</code>&nbsp;+&nbsp;<code>V</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。</p>
<p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做&nbsp;<code>IIII</code>，而是&nbsp;<code>IV</code>。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为&nbsp;<code>IX</code>。这个特殊的规则只适用于以下六种情况：</p>
<ul>
	<li><code>I</code>&nbsp;可以放在&nbsp;<code>V</code>&nbsp;(5) 和&nbsp;<code>X</code>&nbsp;(10) 的左边，来表示 4 和 9。</li>
	<li><code>X</code>&nbsp;可以放在&nbsp;<code>L</code>&nbsp;(50) 和&nbsp;<code>C</code>&nbsp;(100) 的左边，来表示 40 和&nbsp;90。&nbsp;</li>
	<li><code>C</code>&nbsp;可以放在&nbsp;<code>D</code>&nbsp;(500) 和&nbsp;<code>M</code>&nbsp;(1000) 的左边，来表示&nbsp;400 和&nbsp;900。</li>
</ul>
<p>给定一个罗马数字，将其转换成整数。输入确保在 1&nbsp;到 3999 的范围内。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;III&quot;
<strong>输出:</strong> 3</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;IV&quot;
<strong>输出:</strong> 4</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;IX&quot;
<strong>输出:</strong> 9</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;LVIII&quot;
<strong>输出:</strong> 58
<strong>解释:</strong> L = 50, V= 5, III = 3.
</pre>

<p><strong>示例&nbsp;5:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;MCMXCIV&quot;
<strong>输出:</strong> 1994
<strong>解释:</strong> M = 1000, CM = 900, XC = 90, IV = 4.</pre>


## 解法

### **Java**
```java
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String str = "IVXLCDM";
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int ans = 0;
        int i = 0;
        int pre = 999, cur = 0;
        while (i < s.length()) {
            cur = str.indexOf(s.charAt(i++));
            if (pre < cur) {
                ans = ans + num[cur] - 2 * num[pre];
            } else {
                ans += num[cur];
            }
            pre = cur;
        }
        return ans;
    }
}
```

# [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix)
## 题目描述

<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>
<p>如果不存在公共前缀，返回空字符串&nbsp;<code>&quot;&quot;</code>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>[&quot;flower&quot;,&quot;flow&quot;,&quot;flight&quot;]
<strong>输出:</strong> &quot;fl&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong>[&quot;dog&quot;,&quot;racecar&quot;,&quot;car&quot;]
<strong>输出:</strong> &quot;&quot;
<strong>解释:</strong> 输入不存在公共前缀。
</pre>

<p><strong>说明:</strong></p>
<p>所有输入只包含小写字母&nbsp;<code>a-z</code>&nbsp;。</p>

## 解法

### **Java**
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        char[] chars = strs[0].toCharArray();
        int i = 0;
        boolean flag = true;
        for (; i < chars.length; ++i) {
            char ch = chars[i];
            
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() <= i) {
                    flag = false;
                    break;
                }
                if (strs[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
                
            }
            if (!flag) {
                break;
            }
        }
        return strs[0].substring(0, i);
        
        
    }
}
```

# [15. 三数之和](https://leetcode-cn.com/problems/3sum)
## 题目描述

<p>给你一个包含 <em>n</em> 个整数的数组&nbsp;<code>nums</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在三个元素 <em>a，b，c ，</em>使得&nbsp;<em>a + b + c = </em>0 ？请你找出所有满足条件且不重复的三元组。</p>
<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre>给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
</pre>


## 解法
“排序 + 双指针”实现。

### **Java**
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1, q = n - 1;
            while (p < q) {
                if (p > i + 1 && nums[p] == nums[p - 1]) {
                    ++p;
                    continue;
                }
                if (q < n - 1 && nums[q] == nums[q + 1]) {
                    --q;
                    continue;
                }
                if (nums[p] + nums[q] + nums[i] < 0) {
                    ++p;
                } else if (nums[p] + nums[q] + nums[i] > 0) {
                    --q;
                } else {
                    res.add(Arrays.asList(nums[p], nums[q], nums[i]));
                    ++p;
                    --q;
                }
            }
        }
        return res;
    }
}
```

# [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number)
## 题目描述

<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。</p>
<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210307160924586.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例:</strong></p>
<pre><strong>输入：</strong>&quot;23&quot;
<strong>输出：</strong>[&quot;ad&quot;, &quot;ae&quot;, &quot;af&quot;, &quot;bd&quot;, &quot;be&quot;, &quot;bf&quot;, &quot;cd&quot;, &quot;ce&quot;, &quot;cf&quot;].
</pre>

<p><strong>说明:</strong><br>
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。</p>

## 解法

### **Java**
```java
class Solution {
    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        List<String> result = new ArrayList<>();
        for (char a : cs) {
            char[] charArray;
            switch (a) {
                case '2': charArray = new char[]{'a','b','c'}; break;
                case '3': charArray = new char[]{'d','e','f'}; break;
                case '4': charArray = new char[]{'g','h','i'}; break;
                case '5': charArray = new char[]{'j','k','l'}; break;
                case '6': charArray = new char[]{'m','n','o'}; break;
                case '7': charArray = new char[]{'p','q','r','s'}; break;
                case '8': charArray = new char[]{'t','u','v'}; break;
                case '9': charArray = new char[]{'w','x','y','z'}; break;
                default: return null;
            }
            if (result.size() == 0) {
                for (char aCharArray : charArray) result.add(String.valueOf(aCharArray));
            } else {
                List<String> cache = new ArrayList<>();
                for (String string : result) {
                    for (char aCharArray : charArray) cache.add(string + aCharArray);
                }
                result = cache;
            }
        }
        return result;
    }
}
```

# [18. 四数之和](https://leetcode-cn.com/problems/4sum)
## 题目描述

<p>给定一个包含&nbsp;<em>n</em> 个整数的数组&nbsp;<code>nums</code>&nbsp;和一个目标值&nbsp;<code>target</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在四个元素 <em>a，</em><em>b，c</em>&nbsp;和 <em>d</em>&nbsp;，使得&nbsp;<em>a</em> + <em>b</em> + <em>c</em> + <em>d</em>&nbsp;的值与&nbsp;<code>target</code>&nbsp;相等？找出所有满足条件且不重复的四元组。</p>
<p><strong>注意：</strong></p>
<p>答案中不可以包含重复的四元组。</p>
<p><strong>示例：</strong></p>
<pre>给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
</pre>


## 解法
“排序 + 双指针”实现。

### **Java**
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n;
        if (nums == null || (n = (nums.length)) < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1, q = n - 1;
                while (p < q) {
                    if (p > j + 1 && nums[p] == nums[p - 1]) {
                        ++p;
                        continue;
                    }
                    if (q < n - 1 && nums[q] == nums[q + 1]) {
                        --q;
                        continue;
                    }
                    int t = nums[i] + nums[j] + nums[p] + nums[q];
                    if (t == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        ++p;
                        --q;
                    } else if (t < target) {
                        ++p;
                    } else {
                        --q;
                    }
                }
            }
        }
        return res;
    }
}
```

# [19. 删除链表的倒数第 N 个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list)
## 题目描述

<p>给定一个链表，删除链表的倒数第&nbsp;<em>n&nbsp;</em>个节点，并且返回链表的头结点。</p>
<p><strong>示例：</strong></p>
<pre>给定一个链表: <strong>1-&gt;2-&gt;3-&gt;4-&gt;5</strong>, 和 <strong><em>n</em> = 2</strong>.
当删除了倒数第二个节点后，链表变为 <strong>1-&gt;2-&gt;3-&gt;5</strong>.
</pre>

<p><strong>说明：</strong></p>
<p>给定的 <em>n</em>&nbsp;保证是有效的。</p>
<p><strong>进阶：</strong></p>
<p>你能尝试使用一趟扫描实现吗？</p>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy, q = dummy;
        while (n-- > 0) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }
}
```

# [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses)
## 题目描述

<p>给定一个只包括 <code>&#39;(&#39;</code>，<code>&#39;)&#39;</code>，<code>&#39;{&#39;</code>，<code>&#39;}&#39;</code>，<code>&#39;[&#39;</code>，<code>&#39;]&#39;</code>&nbsp;的字符串，判断字符串是否有效。</p>
<p>有效字符串需满足：</p>
<ol>
	<li>左括号必须用相同类型的右括号闭合。</li>
	<li>左括号必须以正确的顺序闭合。</li>
</ol>
<p>注意空字符串可被认为是有效字符串。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;()&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> &quot;()[]{}&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> &quot;(]&quot;
<strong>输出:</strong> false
</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong> &quot;([)]&quot;
<strong>输出:</strong> false
</pre>

<p><strong>示例&nbsp;5:</strong></p>
<pre><strong>输入:</strong> &quot;{[]}&quot;
<strong>输出:</strong> true</pre>


## 解法
栈实现。
遍历括号字符串，遇到左括号时，将左括号压入栈中；遇到右括号时，弹出栈顶元素（栈若为空，直接返回 false），判断是否是相同类型的括号。若不匹配，直接返回 false。
遍历结束，栈若为空，说明括号字符串有效。

### **Java**
```java
class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> q = new ArrayDeque<>();
        for (char ch : chars) {
            boolean left = ch == '(' || ch == '[' || ch == '{';
            if (left) q.push(ch);
            else if (q.isEmpty() || !match(q.pop(), ch)) return false;
        }
        return q.isEmpty();
    }
    private boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }
}
```

# [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists)
## 题目描述

<p>将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>1-&gt;2-&gt;4, 1-&gt;3-&gt;4
<strong>输出：</strong>1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4
</pre>


## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
```

# [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses)
## 题目描述

<p>给出&nbsp;<em>n</em>&nbsp;代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且<strong>有效的</strong>括号组合。</p>
<p>例如，给出&nbsp;<em>n </em>=<em> </em>3，生成结果为：</p>
<pre>[
  &quot;((()))&quot;,
  &quot;(()())&quot;,
  &quot;(())()&quot;,
  &quot;()(())&quot;,
  &quot;()()()&quot;
]
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }
    private void dfs(List<String> res, String ans, int l, int r, int length) {
        if (ans.length() == length * 2) {
            res.add(ans);
            return;
        }
        if (l < length) {
            dfs(res, ans + "(", l + 1, r, length);
        }
        if (r < l) {
            dfs(res, ans + ")", l, r + 1, length);
        }
    }
}
```


# [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs)
## 题目描述

<p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。</p>
<p><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际的进行节点交换。</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre>给定 <code>1-&gt;2-&gt;3-&gt;4</code>, 你应该返回 <code>2-&gt;1-&gt;4-&gt;3</code>.
</pre>


## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = cur;
            pre.next = t;
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
```

# [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array)
## 题目描述

<p>给定一个排序数组，你需要在<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。</p>
<p>不要使用额外的数组空间，你必须在 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组 </strong>并在使用 O(1) 额外空间的条件下完成。</p>
<p>&nbsp;</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>给定数组 <em>nums</em> = <strong>[1,1,2]</strong>, 
函数应该返回新的长度 <strong>2</strong>, 并且原数组 <em>nums </em>的前两个元素被修改为 <strong><code>1</code></strong>, <strong><code>2</code></strong>。 
你不需要考虑数组中超出新长度后面的元素。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>给定<em> nums </em>= <strong>[0,0,1,1,1,2,2,3,3,4]</strong>,
函数应该返回新的长度 <strong>5</strong>, 并且原数组 <em>nums </em>的前五个元素被修改为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>2</code></strong>, <strong><code>3</code></strong>, <strong><code>4</code></strong>。
你不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<p>为什么返回数值是整数，但输出的答案是数组呢?</p>
<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>
<p>你可以想象内部操作如下:</p>
<pre>// <strong>nums</strong> 是以&ldquo;引用&rdquo;方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong>该长度范围内</strong>的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}
</pre>


## 解法

### **Java**
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0, n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) ++cnt;
            else nums[i - cnt] = nums[i];
        }
        return n - cnt;
    }
}
```

# [27. 移除元素](https://leetcode-cn.com/problems/remove-element)
## 题目描述

<p>给你一个数组 <em>nums&nbsp;</em>和一个值 <em>val</em>，你需要 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong> 移除所有数值等于&nbsp;<em>val&nbsp;</em>的元素，并返回移除后数组的新长度。</p>
<p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组</strong>。</p>
<p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>给定 <em>nums</em> = <strong>[3,2,2,3]</strong>, <em>val</em> = <strong>3</strong>,
函数应该返回新的长度 <strong>2</strong>, 并且 <em>nums </em>中的前两个元素均为 <strong>2</strong>。
你不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>给定 <em>nums</em> = <strong>[0,1,2,2,3,0,4,2]</strong>, <em>val</em> = <strong>2</strong>,
函数应该返回新的长度 <strong><code>5</code></strong>, 并且 <em>nums </em>中的前五个元素为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>3</code></strong>, <strong><code>0</code></strong>, <strong>4</strong>。
注意这五个元素可为任意顺序。
你不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<p>为什么返回数值是整数，但输出的答案是数组呢?</p>
<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>
<p>你可以想象内部操作如下:</p>
<pre>// <strong>nums</strong> 是以&ldquo;引用&rdquo;方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}
</pre>


## 解法

### **Java**
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++cnt;
            } else {
                nums[i - cnt] = nums[i];
            }
        }
        return n - cnt;
    }
}
```

# [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr)
## 题目描述

<p>实现&nbsp;<a href="https://baike.baidu.com/item/strstr/811469" target="_blank">strStr()</a>&nbsp;函数。</p>
<p>给定一个&nbsp;haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回&nbsp; <strong>-1</strong>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> haystack = &quot;hello&quot;, needle = &quot;ll&quot;
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> haystack = &quot;aaaaa&quot;, needle = &quot;bba&quot;
<strong>输出:</strong> -1
</pre>

<p><strong>说明:</strong></p>
<p>当&nbsp;<code>needle</code>&nbsp;是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。</p>
<p>对于本题而言，当&nbsp;<code>needle</code>&nbsp;是空字符串时我们应当返回 0 。这与C语言的&nbsp;<a href="https://baike.baidu.com/item/strstr/811469" target="_blank">strstr()</a>&nbsp;以及 Java的&nbsp;<a href="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)" target="_blank">indexOf()</a>&nbsp;定义相符。</p>

## 解法

### **Java**
```java
class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        int p = 0;
        int q = 0;
        while (p < len1) {
            if (haystack.charAt(p) == needle.charAt(q)) {
                if (len2 == 1) {
                    return p;
                }
                ++p;
                ++q;
            } else {
                p -= q - 1;
                q = 0;
            }
            if (q == len2) {
                return p - q;
            }
        }
        return -1;
    }
}
```

# [29. 两数相除](https://leetcode-cn.com/problems/divide-two-integers)
## 题目描述

<p>给定两个整数，被除数&nbsp;<code>dividend</code>&nbsp;和除数&nbsp;<code>divisor</code>。将两数相除，要求不使用乘法、除法和 mod 运算符。</p>
<p>返回被除数&nbsp;<code>dividend</code>&nbsp;除以除数&nbsp;<code>divisor</code>&nbsp;得到的商。</p>
<p>整数除法的结果应当截去（<code>truncate</code>）其小数部分，例如：<code>truncate(8.345) = 8</code> 以及 <code>truncate(-2.7335) = -2</code></p>
<p>&nbsp;</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> dividend = 10, divisor = 3
<strong>输出:</strong> 3
<strong>解释: </strong>10/3 = truncate(3.33333..) = truncate(3) = 3</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> dividend = 7, divisor = -3
<strong>输出:</strong> -2
<strong>解释:</strong> 7/-3 = truncate(-2.33333..) = truncate(-2) = 3</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>被除数和除数均为 32 位有符号整数。</li>
	<li>除数不为&nbsp;0。</li>
	<li>假设我们的环境只能存储 32 位有符号整数，其数值范围是 [&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。本题中，如果除法结果溢出，则返回 2<sup>31&nbsp;</sup>&minus; 1。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 1) {
            return dividend;
        }
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // 商的符号，true 为正，false 为负
        boolean flag = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);
        int re = 0;
        long factor = 0x1;
        while (dividendLong >= (divisorLong << 1)) {
            divisorLong <<= 1;
            factor <<= 1;
        }
        while (factor > 0 && dividendLong > 0) {
            if(dividendLong >= divisorLong) {
                dividendLong -= divisorLong;
                re += factor;
            }
            factor >>>= 1;
            divisorLong >>>= 1;
        }
        return flag ? re : -re;
    }
}
```

# [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation)
## 题目描述

<p>实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。</p>
<p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。</p>
<p>必须<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>修改，只允许使用额外常数空间。</p>
<p>以下是一些例子，输入位于左侧列，其相应输出位于右侧列。<br>
<code>1,2,3</code> &rarr; <code>1,3,2</code><br>
<code>3,2,1</code> &rarr; <code>1,2,3</code><br>
<code>1,1,5</code> &rarr; <code>1,5,1</code></p>

## 解法

### **Java**
```java
class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                int index = findMinIndex(nums, i, nums[i]);
                swap(nums, i, index);
                reverse(nums, i + 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
        }
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    /**
     * 找出从start开始的比val大的最小元素的下标，如果有多个，选择后者
     */
    private int findMinIndex(int[] nums, int start, int val) {
        int end = nums.length - 1;
        int i = start;
        for (; i < end; ++i) {
            if (nums[i + 1] <= val) {
                break;
            }
        }
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

# [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array)
## 题目描述

<p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
<p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code>&nbsp;可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
<p>搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回&nbsp;<code>-1</code>&nbsp;。</p>
<p>你可以假设数组中不存在重复的元素。</p>
<p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log&nbsp;<em>n</em>) 级别。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> nums = [<code>4,5,6,7,0,1,2]</code>, target = 0
<strong>输出:</strong> 4
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> nums = [<code>4,5,6,7,0,1,2]</code>, target = 3
<strong>输出:</strong> -1</pre>


## 解法

### **Java**
```java
class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int low = 0,high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < A[mid]) {
                if (A[mid] >= A[high] && target < A[low]) low = mid + 1;
                else high = mid - 1;
            } else if (target > A[mid]) {
                if (A[low] >= A[mid] && target > A[high]) high = mid - 1;
                else low = mid + 1;
            } else return mid;
        }
        return -1;
    }
}
```

# [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array)
## 题目描述

<p>给定一个按照升序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。找出给定目标值在数组中的开始位置和结束位置。</p>
<p>你的算法时间复杂度必须是&nbsp;<em>O</em>(log <em>n</em>) 级别。</p>
<p>如果数组中不存在目标值，返回&nbsp;<code>[-1, -1]</code>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 8
<strong>输出:</strong> [3,4]</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> nums = [<code>5,7,7,8,8,10]</code>, target = 6
<strong>输出:</strong> [-1,-1]</pre>


## 解法

### **Java**
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            if (nums[mid] == target) {
                return new int[]{findFirst(nums, start, mid, target),findEnd(nums, mid, end, target)};
            }
        }
        return new int[]{-1,-1};
    }
    private int findFirst(int[] nums, int start, int end, int target) {
        while (start < end) {
            int temp = start + (end - start) / 2;
            if (nums[temp] < target) start = temp + 1;
            else if (nums[temp] == target) end = temp;
        }
        return start;
    }
    private int findEnd(int[] nums, int start, int end, int target) {
        while (start < end) {
            int temp = start + (end - start + 1) / 2;
            if (nums[temp] > target) end = temp - 1;
            else if (nums[temp] == target) start = temp;
        }
        return start;
    }
}
```

# [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position)
## 题目描述

<p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>
<p>你可以假设数组中无重复元素。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [1,3,5,6], 5
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [1,3,5,6], 2
<strong>输出:</strong> 1
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> [1,3,5,6], 7
<strong>输出:</strong> 4
</pre>

<p><strong>示例 4:</strong></p>
<pre><strong>输入:</strong> [1,3,5,6], 0
<strong>输出:</strong> 0
</pre>


## 解法
二分查找。

### **Java**
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + ((h - l) >> 1);
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m + 1;
            else h = m - 1;
        }
        return l;
    }
}
```

# [36. 有效的数独](https://leetcode-cn.com/problems/valid-sudoku)
## 题目描述

<p>判断一个&nbsp;9x9 的数独是否有效。只需要<strong>根据以下规则</strong>，验证已经填入的数字是否有效即可。</p>
<ol>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一行只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一列只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一个以粗实线分隔的&nbsp;<code>3x3</code>&nbsp;宫内只能出现一次。</li>
</ol>
<p><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height: 250px; width: 250px;"></p>
<p><small>上图是一个部分填充的有效的数独。</small></p>
<p>数独部分空格内已填入了数字，空白格用&nbsp;<code>&#39;.&#39;</code>&nbsp;表示。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
[
  [&quot;5&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],
  [&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],
  [&quot;.&quot;,&quot;9&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;],
  [&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;3&quot;],
  [&quot;4&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;],
  [&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;],
  [&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;8&quot;,&quot;.&quot;],
  [&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;.&quot;,&quot;.&quot;,&quot;5&quot;],
  [&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;9&quot;]
]
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
[
&nbsp; [&quot;8&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],
&nbsp; [&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],
&nbsp; [&quot;.&quot;,&quot;9&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;],
&nbsp; [&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;3&quot;],
&nbsp; [&quot;4&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;],
&nbsp; [&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;],
&nbsp; [&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;8&quot;,&quot;.&quot;],
&nbsp; [&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;.&quot;,&quot;.&quot;,&quot;5&quot;],
&nbsp; [&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;9&quot;]
]
<strong>输出:</strong> false
<strong>解释:</strong> 除了第一行的第一个数字从<strong> 5</strong> 改为 <strong>8 </strong>以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>一个有效的数独（部分已被填充）不一定是可解的。</li>
	<li>只需要根据以上规则，验证已经填入的数字是否有效即可。</li>
	<li>给定数独序列只包含数字&nbsp;<code>1-9</code>&nbsp;和字符&nbsp;<code>&#39;.&#39;</code>&nbsp;。</li>
	<li>给定数独永远是&nbsp;<code>9x9</code>&nbsp;形式的。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> col = new HashSet<>() , row = new HashSet<>() , cube = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int colIndex = i/3*3+j/3 , rowIndex = i%3*3+j%3;
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) return false;
            }
        }
        return true;
    }
}
```

# [38. 外观数列](https://leetcode-cn.com/problems/count-and-say)
## 题目描述

<p>「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：</p>
<pre>1.     1
2.     11
3.     21
4.     1211
5.     111221
</pre>

<p><code>1</code>&nbsp;被读作&nbsp;&nbsp;<code>&quot;one 1&quot;</code>&nbsp;&nbsp;(<code>&quot;一个一&quot;</code>) , 即&nbsp;<code>11</code>。<br>
<code>11</code> 被读作&nbsp;<code>&quot;two 1s&quot;</code>&nbsp;(<code>&quot;两个一&quot;</code>）, 即&nbsp;<code>21</code>。<br>
<code>21</code> 被读作&nbsp;<code>&quot;one 2&quot;</code>, &nbsp;&quot;<code>one 1&quot;</code>&nbsp;（<code>&quot;一个二&quot;</code>&nbsp;,&nbsp;&nbsp;<code>&quot;一个一&quot;</code>)&nbsp;, 即&nbsp;<code>1211</code>。</p>
<p>给定一个正整数 <em>n</em>（1 &le;&nbsp;<em>n</em>&nbsp;&le; 30），输出外观数列的第 <em>n</em> 项。</p>
<p>注意：整数序列中的每一项将表示为一个字符串。</p>
<p>&nbsp;</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 1
<strong>输出:</strong> &quot;1&quot;
<strong>解释：</strong>这是一个基本样例。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 4
<strong>输出:</strong> &quot;1211&quot;
<strong>解释：</strong>当 n = 3 时，序列是 &quot;21&quot;，其中我们有 &quot;2&quot; 和 &quot;1&quot; 两组，&quot;2&quot; 可以读作 &quot;12&quot;，也就是出现频次 = 1 而 值 = 2；类似 &quot;1&quot; 可以读作 &quot;11&quot;。所以答案是 &quot;12&quot; 和 &quot;11&quot; 组合在一起，也就是 &quot;1211&quot;。</pre>


## 解法

### **Java**
```java
class Solution {
    public String countAndSay(int n) {
        String one = "1";
        while (n > 1) {
            one = say(one);
            n--;
        }
        return one;
    }
    private String say(String las) {
        StringBuilder sBuilder = new StringBuilder();
        int l = 1;
        for (int i = 0; i < las.length(); i++) {
            if (i < las.length() - 1 && las.charAt(i) == las.charAt(i + 1)) l++;
            else {
                sBuilder.append(l).append(las.charAt(i));
                l = 1;
            }
        }
        return sBuilder.toString();
    }
}
```

# [39. 组合总和](https://leetcode-cn.com/problems/combination-sum)
## 题目描述

<p>给定一个<strong>无重复元素</strong>的数组&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>
<p><code>candidates</code>&nbsp;中的数字可以无限制重复被选取。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>所有数字（包括&nbsp;<code>target</code>）都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> candidates = <code>[2,3,6,7], </code>target = <code>7</code>,
<strong>所求解集为:</strong>
[
  [7],
  [2,2,3]
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> candidates = [2,3,5]<code>, </code>target = 8,
<strong>所求解集为:</strong>
[
&nbsp; [2,2,2,2],
&nbsp; [2,3,3],
&nbsp; [3,5]
]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates,target,candidates.length-1, new ArrayList<>(),result);
        return result;
    }
    private void combinationSum(int[] candidates, int target,int length, List<Integer> integers,
                                List<List<Integer>> result) {
        List<Integer> list;
        for (int i = length; i >= 0; i--) {
            int nc = candidates[i];
            if (nc>target) continue;
            list = new ArrayList<>(integers);
            list.add(nc);
            if (nc==target) result.add(list);
            else combinationSum(candidates, target - nc, i, list,result);
        }
    }
}
```

# [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii)
## 题目描述

<p>给定一个数组&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>
<p><code>candidates</code>&nbsp;中的每个数字在每个组合中只能使用一次。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>所有数字（包括目标数）都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> candidates =&nbsp;<code>[10,1,2,7,6,1,5]</code>, target =&nbsp;<code>8</code>,
<strong>所求解集为:</strong>
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> candidates =&nbsp;[2,5,2,1,2], target =&nbsp;5,
<strong>所求解集为:</strong>
[
&nbsp; [1,2,2],
&nbsp; [5]
]</pre>


## 解法

### **Java**
```java
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates,target,candidates.length-1, new ArrayList<>());
        return result;
    }
    private void combinationSum(int[] candidates, int target,int length, List<Integer> integers) {
        List<Integer> list;
        for (int i = length; i >= 0; i--) {
            int nc = candidates[i];
            if (nc>target || i<length && nc==candidates[i+1]) continue;
            list = new ArrayList<>(integers);
            list.add(nc);
            if (nc==target) result.add(list);
            else combinationSum(candidates, target - nc, i-1, list);
        }
    }
}
```

# [43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings)
## 题目描述

<p>给定两个以字符串形式表示的非负整数&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>，返回&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的乘积，它们的乘积也表示为字符串形式。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> num1 = &quot;2&quot;, num2 = &quot;3&quot;
<strong>输出:</strong> &quot;6&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> num1 = &quot;123&quot;, num2 = &quot;456&quot;
<strong>输出:</strong> &quot;56088&quot;</pre>

<p><strong>说明：</strong></p>
<ol>
	<li><code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的长度小于110。</li>
	<li><code>num1</code> 和&nbsp;<code>num2</code> 只包含数字&nbsp;<code>0-9</code>。</li>
	<li><code>num1</code> 和&nbsp;<code>num2</code>&nbsp;均不以零开头，除非是数字 0 本身。</li>
	<li><strong>不能使用任何标准库的大数类型（比如 BigInteger）</strong>或<strong>直接将输入转换为整数来处理</strong>。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray(),chars2 = num2.toCharArray();
        int[] result = new int[chars1.length+chars2.length];
        int pow = result.length-1;
        for (int i = chars1.length - 1; i >= 0; i--) {
            int a = chars1[i] - '0';
            int j = 0,bit = pow;
            for (int i1 = chars2.length - 1; i1 >= 0; i1--) {
                int b = chars2[i1] -'0';
                j = a*b + j + result[bit];
                result[bit--] = j%10;
                j = j/10;
            }
            while (j!=0){
                j += result[bit];
                result[bit--] = j%10;
                j = j/10;
            }
            pow--;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i < result.length; i++) if (result[i] != 0) break;
        for (; i < result.length; i++) builder.append(result[i]);
        return builder.length()==0? "0" : builder.toString();
    }
}
```

# [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii)
## 题目描述

<p>给定一个非负整数数组，你最初位于数组的第一个位置。</p>
<p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>
<p>你的目标是使用最少的跳跃次数到达数组的最后一个位置。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [2,3,1,1,4]
<strong>输出:</strong> 2
<strong>解释:</strong> 跳到最后一个位置的最小跳跃数是 <code>2</code>。
&nbsp;    从下标为 0 跳到下标为 1 的位置，跳&nbsp;<code>1</code>&nbsp;步，然后跳&nbsp;<code>3</code>&nbsp;步到达数组的最后一个位置。
</pre>

<p><strong>说明:</strong></p>
<p>假设你总是可以到达数组的最后一个位置。</p>

## 解法

### **Java**
```java
class Solution {
    public int jump(int[] nums) {
        int cnt = 0,last = 0, next = 1;
        for (;next < nums.length;cnt++){
            int i = last;
            last = next;
            for (; i < last; ++i) if (i + nums[i] >= next) next = i + nums[i] + 1;
        }
        return cnt;
    }
}
```

# [46. 全排列](https://leetcode-cn.com/problems/permutations)
## 题目描述

<p>给定一个<strong>没有重复</strong>数字的序列，返回其所有可能的全排列。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,2,3]
<strong>输出:</strong>
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }
    
    private void permute(List<List<Integer>> list, int[] nums, int start) {
        int end = nums.length - 1;
        if (start == end) {
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        
        for (int i = start; i <= end; ++i) {
            swap(nums, i, start);
            permute(list, nums, start + 1);
            swap(nums, i, start);
        }
        
        
    }
    
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

# [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii)
## 题目描述

<p>给定一个可包含重复数字的序列，返回所有不重复的全排列。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,1,2]
<strong>输出:</strong>
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, nums, 0);
        return list;
    }
    
    private void permute(List<List<Integer>> list, int[] nums, int start) {
        int end = nums.length - 1;
        if (start == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int val : nums) {
                tmp.add(val);
            }
            
            list.add(tmp);
            
        }
        
        for (int i = start; i <= end; ++i) {
            if (isSwap(nums, start, i)) {
                swap(nums, i, start);
                permute(list, nums, start + 1);
                swap(nums, i, start);
            }
            
        }
        
    }
    
    private boolean isSwap(int[] nums, int from, int to) {
        for (int i = from; i < to; ++i) {
            if (nums[i] == nums[to]) {
                // 相等，不进行交换
                return false;
            }
        }
        return true;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

# [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image)
## 题目描述

<p>给定一个 <em>n&nbsp;</em>&times;&nbsp;<em>n</em> 的二维矩阵表示一个图像。</p>
<p>将图像顺时针旋转 90 度。</p>
<p><strong>说明：</strong></p>
<p>你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>旋转图像，这意味着你需要直接修改输入的二维矩阵。<strong>请不要</strong>使用另一个矩阵来旋转图像。</p>
<p><strong>示例 1:</strong></p>
<pre>给定 <strong>matrix</strong> = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
<strong>原地</strong>旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
</pre>

<p><strong>示例 2:</strong></p>
<pre>给定 <strong>matrix</strong> =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
<strong>原地</strong>旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
</pre>


## 解法

### **Java**
```java
class Solution {
    public void rotate(int[][] matrix) {
        int s = 0, n = matrix.length;
        while (s < (n >> 1)) {
            int e = n - s - 1;
            for (int i = s; i < e; ++i) {
                int t = matrix[i][e];
                matrix[i][e] = matrix[s][i];
                matrix[s][i] = matrix[n - i - 1][s];
                matrix[n - i - 1][s] = matrix[e][n - i - 1];
                matrix[e][n - i - 1] = t;
            }
            ++s;
        }
    }
}
```

# [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams)
## 题目描述

<p>给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>[&quot;eat&quot;, &quot;tea&quot;, &quot;tan&quot;, &quot;ate&quot;, &quot;nat&quot;, &quot;bat&quot;]</code>,
<strong>输出:</strong>
[
  [&quot;ate&quot;,&quot;eat&quot;,&quot;tea&quot;],
  [&quot;nat&quot;,&quot;tan&quot;],
  [&quot;bat&quot;]
]</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>所有输入均为小写字母。</li>
	<li>不考虑答案输出的顺序。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```

# [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n)
## 题目描述

<p>实现&nbsp;<a href="https://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(<em>x</em>, <em>n</em>)</a>&nbsp;，即计算 x 的 n 次幂函数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 2.00000, 10
<strong>输出:</strong> 1024.00000
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 2.10000, 3
<strong>输出:</strong> 9.26100
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> 2.00000, -2
<strong>输出:</strong> 0.25000
<strong>解释:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>-100.0 &lt;&nbsp;<em>x</em>&nbsp;&lt; 100.0</li>
	<li><em>n</em>&nbsp;是 32 位有符号整数，其数值范围是&nbsp;[&minus;2<sup>31</sup>,&nbsp;2<sup>31&nbsp;</sup>&minus; 1] 。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public double myPow(double x, int n) {
        if(n < 0) return sum(1.0 / x,0 - n);
        return sum(x,n);
    }
    public double sum(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if( n % 2 == 0) return sum(x * x, n / 2);
        else return x * sum(x * x, n / 2);
    }
}
```



# [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray)
## 题目描述

<p>给定一个整数数组 <code>nums</code>&nbsp;，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [-2,1,-3,4,-1,2,1,-5,4],
<strong>输出:</strong> 6
<strong>解释:</strong>&nbsp;连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6。
</pre>

<p><strong>进阶:</strong></p>
<p>如果你已经实现复杂度为 O(<em>n</em>) 的解法，尝试使用更为精妙的分治法求解。</p>

## 解法
设 dp[i] 表示 `[0..i]` 中，以 `nums[i]` 结尾的最大子数组和，状态转移方程 `dp[i] = nums[i] + max(dp[i - 1], 0)`。
由于 `dp[i]` 只与子问题 `dp[i-1]` 有关，故可以用一个变量 f 来表示。

### **Java**
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int f = nums[0], res = nums[0];
        for (int i = 1, n = nums.length; i < n; ++i) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }
}
```

# [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix)
## 题目描述

<p>给定一个包含&nbsp;<em>m</em> x <em>n</em>&nbsp;个元素的矩阵（<em>m</em> 行, <em>n</em> 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
<strong>输出:</strong> [1,2,3,6,9,8,7,4,5]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
<strong>输出:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

**提示**：
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 10
- -100 <= matrix[i][j] <= 100

## 解法
从外往里一圈一圈遍历并存储矩阵元素即可。

### **Java**
```java
class Solution {
    private List<Integer> res;
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        res = new ArrayList<>();
        int i1 = 0, i2 = m - 1;
        int j1 = 0, j2 = n - 1;
        while (i1 <= i2 && j1 <= j2) {
            add(matrix, i1++, j1++, i2--, j2--);
        }
        return res;
    }
    private void add(int[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            for (int j = j1; j <= j2; ++j) {
                res.add(matrix[i1][j]);
            }
            return;
        }
        if (j1 == j2) {
            for (int i = i1; i <= i2; ++i) {
                res.add(matrix[i][j1]);
            }
            return;
        }
        for (int j = j1; j < j2; ++j) {
            res.add(matrix[i1][j]);
        }
        for (int i = i1; i < i2; ++i) {
            res.add(matrix[i][j2]);
        }
        for (int j = j2; j > j1; --j) {
            res.add(matrix[i2][j]);
        }
        for (int i = i2; i > i1; --i) {
            res.add(matrix[i][j1]);
        }
    }
}
```

# [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game)
## 题目描述

<p>给定一个非负整数数组，你最初位于数组的第一个位置。</p>
<p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>
<p>判断你是否能够到达最后一个位置。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [2,3,1,1,4]
<strong>输出:</strong> true
<strong>解释:</strong> 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [3,2,1,0,4]
<strong>输出:</strong> false
<strong>解释:</strong> 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean canJump(int[] nums) {
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i --) {
            count = nums[i] > count ? 0 : count + 1;
        }
        return count == 0;
    }
}
```

# [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals)
## 题目描述

<p>给出一个区间的集合，请合并所有重叠的区间。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [[1,3],[2,6],[8,10],[15,18]]
<strong>输出:</strong> [[1,6],[8,10],[15,18]]
<strong>解释:</strong> 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [[1,4],[4,5]]
<strong>输出:</strong> [[1,5]]
<strong>解释:</strong> 区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>


## 解法

### **Java**
```java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n=intervals.size();
        int[] starts=new int[n],ends=new int[n];
        for(int i=0;i<n;i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res= new ArrayList<>();
        for(int i=0,j=0;i<n;i++){
            if((i == (n - 1)) || (starts[i + 1] > ends[i])){
                res.add(new Interval(starts[j],ends[i]));
                j=i+1;
            }
        }
        return res;
    }
}
```

# [57. 插入区间](https://leetcode-cn.com/problems/insert-interval)
## 题目描述

<p>给出一个<em>无重叠的 ，</em>按照区间起始端点排序的区间列表。</p>
<p>在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> intervals = [[1,3],[6,9]], newInterval = [2,5]
<strong>输出:</strong> [[1,5],[6,9]]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> intervals = <code>[[1,2],[3,5],[6,7],[8,10],[12,16]]</code>, newInterval = <code>[4,8]</code>
<strong>输出:</strong> [[1,2],[3,10],[12,16]]
<strong>解释:</strong> 这是因为新的区间 <code>[4,8]</code> 与 <code>[3,5],[6,7],[8,10]</code>&nbsp;重叠。
</pre>


## 解法

### **Java**
```java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<>();
        int i = 0;
        while ((i < intervals.size()) && (intervals.get(i).end < newInterval.start)) list.add(intervals.get(i++));
        while ((i < intervals.size()) && (intervals.get(i).start <= newInterval.end)) {
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            i++;
        }
        list.add(newInterval);
        while (i < intervals.size()) list.add(intervals.get(i++));
        return list;
    }
}
```

# [58. 最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word)
## 题目描述

<p>给定一个仅包含大小写字母和空格&nbsp;<code>&#39; &#39;</code>&nbsp;的字符串 <code>s</code>，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。</p>
<p>如果不存在最后一个单词，请返回 0&nbsp;。</p>
<p><strong>说明：</strong>一个单词是指仅由字母组成、不包含任何空格字符的 <strong>最大子字符串</strong>。</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> &quot;Hello World&quot;
<strong>输出:</strong> 5
</pre>


## 解法

### **Java**
```java
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int lastWordLength = 0;
        boolean meetWord = false;
        for (int i = n - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'z') {
                meetWord = true;
                ++lastWordLength;
            } else if (meetWord) {
                break;
            }
        }
        return lastWordLength;
    }
}
```

# [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii)
## 题目描述

<p>给定一个正整数&nbsp;<em>n</em>，生成一个包含 1 到&nbsp;<em>n</em><sup>2</sup>&nbsp;所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 3
<strong>输出:</strong>
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]</pre>


## 解法

### **Java**
```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int m1 = 0, m2 = n - 1;
        while (m1 < m2) {
            for (int j = m1; j < m2; ++j) {
                res[m1][j] = num++;
            }
            for (int i = m1; i < m2; ++i) {
                res[i][m2] = num++;
            }
            for (int j = m2; j > m1; --j) {
                res[m2][j] = num++;
            }
            for (int i = m2; i > m1; --i) {
                res[i][m1] = num++;
            }
            ++m1;
            --m2;
        }
        if (m1 == m2) {
            res[m1][m1] = num;
        }
        return res;
    }
}
```


# [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list)
## 题目描述

<p>给定一个链表，旋转链表，将链表每个节点向右移动&nbsp;<em>k&nbsp;</em>个位置，其中&nbsp;<em>k&nbsp;</em>是非负数。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, k = 2
<strong>输出:</strong> 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
<strong>解释:</strong>
向右旋转 1 步: 5-&gt;1-&gt;2-&gt;3-&gt;4-&gt;NULL
向右旋转 2 步: 4-&gt;5-&gt;1-&gt;2-&gt;3-&gt;NULL
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 0-&gt;1-&gt;2-&gt;NULL, k = 4
<strong>输出:</strong> <code>2-&gt;0-&gt;1-&gt;NULL</code>
<strong>解释:</strong>
向右旋转 1 步: 2-&gt;0-&gt;1-&gt;NULL
向右旋转 2 步: 1-&gt;2-&gt;0-&gt;NULL
向右旋转 3 步:&nbsp;<code>0-&gt;1-&gt;2-&gt;NULL</code>
向右旋转 4 步:&nbsp;<code>2-&gt;0-&gt;1-&gt;NULL</code></pre>


## 解法
将链表右半部分的 k 的节点拼接到 head 即可。
注：k 对链表长度 n 取余，即 `k %= n`。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode p = head, q = head;
        for (int i = 0; i < k; ++i) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode start = p.next;
        p.next = null;
        q.next = head;
        return start;
    }
}
```

# [62. 不同路径](https://leetcode-cn.com/problems/unique-paths)
## 题目描述

<p>一个机器人位于一个 <em>m x n </em>网格的左上角 （起始点在下图中标记为&ldquo;Start&rdquo; ）。</p>
<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为&ldquo;Finish&rdquo;）。</p>
<p>问总共有多少条不同的路径？</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215535743.png)
<p><small>例如，上图是一个7 x 3 的网格。有多少可能的路径？</small></p>
<p>&nbsp;</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> m = 3, n = 2
<strong>输出:</strong> 3
<strong>解释:</strong>
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -&gt; 向右 -&gt; 向下
2. 向右 -&gt; 向下 -&gt; 向右
3. 向下 -&gt; 向右 -&gt; 向右
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> m = 7, n = 3
<strong>输出:</strong> 28</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li>题目数据保证答案小于等于 <code>2 * 10 ^ 9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[n][m];
        for (int i = 0; i < m; ++i) {
            res[0][i] = 1;
        }
        for (int i = 1; i < n; ++i) {
            res[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[n - 1][m - 1];
    }
}
```

# [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii)
## 题目描述

<p>一个机器人位于一个 <em>m x n </em>网格的左上角 （起始点在下图中标记为&ldquo;Start&rdquo; ）。</p>
<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为&ldquo;Finish&rdquo;）。</p>
<p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215553641.png)
<p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>
<p><strong>说明：</strong><em>m</em>&nbsp;和 <em>n </em>的值均不超过 100。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:
</strong>[
&nbsp; [0,0,0],
&nbsp; [0,1,0],
&nbsp; [0,0,0]
]
<strong>输出:</strong> 2
<strong>解释:</strong>
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 <code>2</code> 条不同的路径：
1. 向右 -&gt; 向右 -&gt; 向下 -&gt; 向下
2. 向下 -&gt; 向下 -&gt; 向右 -&gt; 向右
</pre>


## 解法
# [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum)
## 题目描述

<p>给定一个包含非负整数的 <em>m</em>&nbsp;x&nbsp;<em>n</em>&nbsp;网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>
<p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
[
&nbsp; [1,3,1],
  [1,5,1],
  [4,2,1]
]
<strong>输出:</strong> 7
<strong>解释:</strong> 因为路径 1&rarr;3&rarr;1&rarr;1&rarr;1 的总和最小。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[grid.length-1][grid[0].length-1];
    }
}
```


# [66. 加一](https://leetcode-cn.com/problems/plus-one)
## 题目描述

<p>给定一个由<strong>整数</strong>组成的<strong>非空</strong>数组所表示的非负整数，在该数的基础上加一。</p>
<p>最高位数字存放在数组的首位， 数组中每个元素只存储<strong>单个</strong>数字。</p>
<p>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [1,2,3]
<strong>输出:</strong> [1,2,4]
<strong>解释:</strong> 输入数组表示数字 123。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [4,3,2,1]
<strong>输出:</strong> [4,3,2,2]
<strong>解释:</strong> 输入数组表示数字 4321。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```

# [67. 二进制求和](https://leetcode-cn.com/problems/add-binary)
## 题目描述

<p>给定两个二进制字符串，返回他们的和（用二进制表示）。</p>
<p>输入为<strong>非空</strong>字符串且只包含数字&nbsp;<code>1</code>&nbsp;和&nbsp;<code>0</code>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> a = &quot;11&quot;, b = &quot;1&quot;
<strong>输出:</strong> &quot;100&quot;</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> a = &quot;1010&quot;, b = &quot;1011&quot;
<strong>输出:</strong> &quot;10101&quot;</pre>


## 解法

### **Java**
```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder reverseAnswer = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0;i < maxLength;i++) {
            carry += i < a.length() ? a.charAt(a.length() - 1 - i) - 48 : 0;
            carry += i < b.length() ? b.charAt(b.length() - 1 - i) - 48 : 0;
            reverseAnswer.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) {
            reverseAnswer.append(1);
        }
        return reverseAnswer.reverse().toString();
    }
}
```


# [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx)
## 题目描述

<p>实现&nbsp;<code>int sqrt(int x)</code>&nbsp;函数。</p>
<p>计算并返回&nbsp;<em>x</em>&nbsp;的平方根，其中&nbsp;<em>x </em>是非负整数。</p>
<p>由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 4
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 8
<strong>输出:</strong> 2
<strong>说明:</strong> 8 的平方根是 2.82842..., 
&nbsp;    由于返回类型是整数，小数部分将被舍去。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int mySqrt(int x) {
        if(x==0)return 0;
        long i=x;
        while(i>x/i) i = (i + x / i) / 2;
        return (int)i;
    }
}
```

# [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs)
## 题目描述

<p>假设你正在爬楼梯。需要 <em>n</em>&nbsp;阶你才能到达楼顶。</p>
<p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
<p><strong>注意：</strong>给定 <em>n</em> 是一个正整数。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong> 2
<strong>输出：</strong> 2
<strong>解释：</strong> 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong> 3
<strong>输出：</strong> 3
<strong>解释：</strong> 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
</pre>


## 解法

### **Java**
```java
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
```

# [71. 简化路径](https://leetcode-cn.com/problems/simplify-path)
## 题目描述

<p>以 Unix 风格给出一个文件的<strong>绝对路径</strong>，你需要简化它。或者换句话说，将其转换为规范路径。</p>
<p>在 Unix 风格的文件系统中，一个点（<code>.</code>）表示当前目录本身；此外，两个点 （<code>..</code>）&nbsp;表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：<a href="https://blog.csdn.net/u011327334/article/details/50355600" target="_blank">Linux / Unix中的绝对路径 vs 相对路径</a></p>
<p>请注意，返回的规范路径必须始终以斜杠 <code>/</code> 开头，并且两个目录名之间必须只有一个斜杠 <code>/</code>。最后一个目录名（如果存在）<strong>不能</strong>以 <code>/</code> 结尾。此外，规范路径必须是表示绝对路径的<strong>最短</strong>字符串。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：&quot;</strong>/home/&quot;
<strong>输出：&quot;</strong>/home&quot;
<strong>解释：</strong>注意，最后一个目录名后面没有斜杠。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：&quot;</strong>/../&quot;
<strong>输出：&quot;</strong>/&quot;
<strong>解释：</strong>从根目录向上一级是不可行的，因为根是你可以到达的最高级。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：&quot;</strong>/home//foo/&quot;
<strong>输出：&quot;</strong>/home/foo&quot;
<strong>解释：</strong>在规范路径中，多个连续斜杠需要用一个斜杠替换。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：&quot;</strong>/a/./b/../../c/&quot;
<strong>输出：&quot;</strong>/c&quot;
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：&quot;</strong>/a/../../b/../c//.//&quot;
<strong>输出：&quot;</strong>/c&quot;
</pre>

<p><strong>示例 6：</strong></p>
<pre><strong>输入：&quot;</strong>/a//b////c/d//././/..&quot;
<strong>输出：&quot;</strong>/a/b/c&quot;</pre>


## 解法

### **Java**
```java
class Solution {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();
        int dirStart = 0, len = path.length();
        while (dirStart < len) {
            while (dirStart < len && path.charAt(dirStart) == '/') dirStart++;
            int dirEnd = dirStart;
            while (dirEnd < len && path.charAt(dirEnd) != '/') dirEnd++;
            String dir = path.substring(dirStart, dirEnd);
            if (!".".equals(dir)) {
                if ("..".equals(dir)) {
                    if (! dirs.isEmpty()) dirs.remove(dirs.size() - 1);
                } else if (dir.length() > 0) {
                    dirs.add(dir);
                }
            }
            dirStart = ++dirEnd;
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < dirs.size(); i++) {
            if (i == dirs.size() - 1) sb.append(dirs.get(i));
            else sb.append(dirs.get(i)).append("/");
        }
        return sb.toString();
    }
}
```


# [73. 矩阵置零](https://leetcode-cn.com/problems/set-matrix-zeroes)
## 题目描述

<p>给定一个&nbsp;<em>m</em> x <em>n</em> 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>算法<strong>。</strong></p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 
[
&nbsp; [1,1,1],
&nbsp; [1,0,1],
&nbsp; [1,1,1]
]
<strong>输出:</strong> 
[
&nbsp; [1,0,1],
&nbsp; [0,0,0],
&nbsp; [1,0,1]
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 
[
&nbsp; [0,1,2,0],
&nbsp; [3,4,5,2],
&nbsp; [1,3,1,5]
]
<strong>输出:</strong> 
[
&nbsp; [0,0,0,0],
&nbsp; [0,4,5,0],
&nbsp; [0,3,1,0]
]</pre>

<p><strong>进阶:</strong></p>
<ul>
	<li>一个直接的解决方案是使用 &nbsp;O(<em>m</em><em>n</em>)&nbsp;的额外空间，但这并不是一个好的解决方案。</li>
	<li>一个简单的改进方案是使用 O(<em>m</em>&nbsp;+&nbsp;<em>n</em>) 的额外空间，但这仍然不是最好的解决方案。</li>
	<li>你能想出一个常数空间的解决方案吗？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int matrixRow = matrix.length, matrixCol = matrix[0].length;
        boolean[] row = new boolean[matrixRow], col = new boolean[matrixCol];
        for (int i = 0; i < matrixRow; i++) {
            for (int j = 0; j < matrixCol; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrixRow; i++) {
            if (row[i]) for (int k = 0; k < matrixCol; k++) matrix[i][k] = 0;
        }
        for (int j = 0; j < matrixCol; j++) {
            if (col[j]) for (int k = 0; k < matrixRow; k++) matrix[k][j] = 0;
        }
    }
}
```

# [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix)
## 题目描述

<p>编写一个高效的算法来判断&nbsp;<em>m</em> x <em>n</em>&nbsp;矩阵中，是否存在一个目标值。该矩阵具有如下特性：</p>
<ul>
	<li>每行中的整数从左到右按升序排列。</li>
	<li>每行的第一个整数大于前一行的最后一个整数。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0,y = matrix.length-1;
        if(y<0) return false;
        int maxX = matrix[0].length-1;
        while ((x <= maxX) && (y >= 0)) {
            int cur = matrix[y][x];
            if (cur == target) return false;
            if (cur < target) x++;
            else y--;
        }
        return false;
    }
}
```

# [75. 颜色分类](https://leetcode-cn.com/problems/sort-colors)
## 题目描述

<p>给定一个包含红色、白色和蓝色，一共&nbsp;<em>n </em>个元素的数组，<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>
<p>此题中，我们使用整数 0、&nbsp;1 和 2 分别表示红色、白色和蓝色。</p>
<p><strong>注意:</strong><br>
不能使用代码库中的排序函数来解决这道题。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [2,0,2,1,1,0]
<strong>输出:</strong> [0,0,1,1,2,2]</pre>

<p><strong>进阶：</strong></p>
<ul>
	<li>一个直观的解决方案是使用计数排序的两趟扫描算法。<br>
	首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。</li>
	<li>你能想出一个仅使用常数空间的一趟扫描算法吗？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public void sortColors(int[] nums) {
        int p = -1;
        int q = nums.length;
        int cur = 0;
        while (cur < q) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++p);
            } else if (nums[cur] == 1) {
                ++cur;
            } else {
                swap(nums, --q, cur);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```


# [77. 组合](https://leetcode-cn.com/problems/combinations)
## 题目描述

<p>给定两个整数 <em>n</em> 和 <em>k</em>，返回 1 ... <em>n </em>中所有可能的 <em>k</em> 个数的组合。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>&nbsp;n = 4, k = 2
<strong>输出:</strong>
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]</pre>


## 解法

### **Java**
```java
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        combine(n-k+1,k,0,1,new Integer[k]);
        return result;
    }
    private void combine(int n, int k, int i, int start, Integer[] list) {
        if (i==k) {
            result.add(new ArrayList<>(Arrays.asList(list)));
            return;
        }
        for (int j = start; j <= n+i; j++) {
            list[i] = j;
            combine(n,k,i+1,j+1,list);
        }
    }
}
```

# [78. 子集](https://leetcode-cn.com/problems/subsets)
## 题目描述

<p>给定一组<strong>不含重复元素</strong>的整数数组&nbsp;<em>nums</em>，返回该数组所有可能的子集（幂集）。</p>
<p><strong>说明：</strong>解集不能包含重复的子集。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> nums = [1,2,3]
<strong>输出:</strong>
[
  [3],
&nbsp; [1],
&nbsp; [2],
&nbsp; [1,2,3],
&nbsp; [1,3],
&nbsp; [2,3],
&nbsp; [1,2],
&nbsp; []
]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(num);
                list.add(temp);
            }
            List<Integer> one = new ArrayList<>();
            one.add(num);
            list.add(one);
        }
        list.add(new ArrayList<>());
        return list;
    }
}
```

# [80. 删除排序数组中的重复项 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii)
## 题目描述

<p>给定一个排序数组，你需要在<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。</p>
<p>不要使用额外的数组空间，你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a>修改输入数组</strong>并在使用 O(1) 额外空间的条件下完成。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>给定 <em>nums</em> = <strong>[1,1,1,2,2,3]</strong>,
函数应返回新长度 length = <strong><code>5</code></strong>, 并且原数组的前五个元素被修改为 <strong><code>1, 1, 2, 2,</code></strong> <strong>3 </strong>。
你不需要考虑数组中超出新长度后面的元素。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>给定 <em>nums</em> = <strong>[0,0,1,1,1,1,2,3,3]</strong>,
函数应返回新长度 length = <strong><code>7</code></strong>, 并且原数组的前五个元素被修改为&nbsp;<strong><code>0</code></strong>, <strong>0</strong>, <strong>1</strong>, <strong>1</strong>, <strong>2</strong>, <strong>3</strong>, <strong>3 。</strong>
你不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong>说明:</strong></p>
<p>为什么返回数值是整数，但输出的答案是数组呢?</p>
<p>请注意，输入数组是以<strong>&ldquo;引用&rdquo;</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>
<p>你可以想象内部操作如下:</p>
<pre>// <strong>nums</strong> 是以&ldquo;引用&rdquo;方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong>该长度范围内</strong>的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}</pre>


## 解法

### **Java**
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length<3) return nums.length;
        int pos = 1,flag = 1,last = nums[0];
        for(int i = 1;i<nums.length;i++){
            if (nums[i] == last) flag++;
            else {
                flag = 1;
                last = nums[i];
            }
            if (flag <= 2) nums[pos++] = last;
        }
        return pos;
    }
}
```

# [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii)
## 题目描述

<p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
<p>( 例如，数组&nbsp;<code>[0,0,1,2,2,5,6]</code>&nbsp;可能变为&nbsp;<code>[2,5,6,0,0,1,2]</code>&nbsp;)。</p>
<p>编写一个函数来判断给定的目标值是否存在于数组中。若存在返回&nbsp;<code>true</code>，否则返回&nbsp;<code>false</code>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> nums = [2<code>,5,6,0,0,1,2]</code>, target = 0
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> nums = [2<code>,5,6,0,0,1,2]</code>, target = 3
<strong>输出:</strong> false</pre>

<p><strong>进阶:</strong></p>
<ul>
	<li>这是 <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/">搜索旋转排序数组</a>&nbsp;的延伸题目，本题中的&nbsp;<code>nums</code>&nbsp; 可能包含重复元素。</li>
	<li>这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
            } else end--;
        }
        return false;
    }
}
```

# [82. 删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii)
## 题目描述

<p>给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中&nbsp;<em>没有重复出现&nbsp;</em>的数字。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;3-&gt;4-&gt;4-&gt;5
<strong>输出:</strong> 1-&gt;2-&gt;5
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 1-&gt;1-&gt;1-&gt;2-&gt;3
<strong>输出:</strong> 2-&gt;3</pre>


## 解法

### **Java**
```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        if (head.val == head.next.val) {
            if (head.next.next == null) {
                return null;
            }
            if (head.val == head.next.next.val) {
                return deleteDuplicates(head.next);
            }
            return deleteDuplicates(head.next.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
```

# [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list)
## 题目描述

<p>给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 1-&gt;1-&gt;2
<strong>输出:</strong> 1-&gt;2
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 1-&gt;1-&gt;2-&gt;3-&gt;3
<strong>输出:</strong> 1-&gt;2-&gt;3</pre>


## 解法

### **Java**
```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
        
    }
}
```

# [86. 分隔链表](https://leetcode-cn.com/problems/partition-list)
## 题目描述

<p>给定一个链表和一个特定值<em> x</em>，对链表进行分隔，使得所有小于 <em>x</em> 的节点都在大于或等于 <em>x</em> 的节点之前。</p>
<p>你应当保留两个分区中每个节点的初始相对位置。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> head = 1-&gt;4-&gt;3-&gt;2-&gt;5-&gt;2, <em>x</em> = 3
<strong>输出:</strong> 1-&gt;2-&gt;2-&gt;4-&gt;3-&gt;5
</pre>


## 解法

### **Java**
```java
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode leftCur = leftDummy;
        ListNode rightCur = rightDummy;
        while (head != null) {
            if (head.val < x) {
                leftCur.next = head;
                leftCur = leftCur.next;
            } else {
                rightCur.next = head;
                rightCur = rightCur.next;
            }
            head = head.next;
        }
        leftCur.next = rightDummy.next;
        rightCur.next = null;
        return leftDummy.next;
    }
}
```


# [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array)
## 题目描述

<p>给你两个有序整数数组&nbsp;<em>nums1 </em>和 <em>nums2</em>，请你将 <em>nums2 </em>合并到&nbsp;<em>nums1&nbsp;</em>中<em>，</em>使 <em>num1 </em>成为一个有序数组。</p>
<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ul>
	<li>初始化&nbsp;<em>nums1</em> 和 <em>nums2</em> 的元素数量分别为&nbsp;<em>m</em> 和 <em>n </em>。</li>
	<li>你可以假设&nbsp;<em>nums1&nbsp;</em>有足够的空间（空间大小大于或等于&nbsp;<em>m + n</em>）来保存 <em>nums2</em> 中的元素。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
<strong>输出:</strong>&nbsp;[1,2,2,3,5,6]</pre>


## 解法
双指针解决。

### **Java**
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
```

# [89. 格雷编码](https://leetcode-cn.com/problems/gray-code)
## 题目描述

<p>格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。</p>
<p>给定一个代表编码总位数的非负整数<em> n</em>，打印其格雷编码序列。格雷编码序列必须以 0 开头。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>&nbsp;2
<strong>输出:</strong>&nbsp;<code>[0,1,3,2]</code>
<strong>解释:</strong>
00 - 0
01 - 1
11 - 3
10 - 2
对于给定的&nbsp;<em>n</em>，其格雷编码序列并不唯一。
例如，<code>[0,2,3,1]</code>&nbsp;也是一个有效的格雷编码序列。
00 - 0
10 - 2
11 - 3
01 - 1</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>&nbsp;0
<strong>输出:</strong>&nbsp;<code>[0]
<strong>解释:</strong> 我们定义</code>格雷编码序列必须以 0 开头。<code>
&nbsp;    给定</code>编码总位数为<code> <em>n</em> 的格雷编码序列，其长度为 2<sup>n</sup></code>。<code>当 <em>n</em> = 0 时，长度为 2<sup>0</sup> = 1。
&nbsp;    因此，当 <em>n</em> = 0 时，其格雷编码序列为 [0]。</code>
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) re.add(i ^ (i >> 1));
        return re;
    }
}
```

# [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii)
## 题目描述

<p>给定一个可能包含重复元素的整数数组 <em><strong>nums</strong></em>，返回该数组所有可能的子集（幂集）。</p>
<p><strong>说明：</strong>解集不能包含重复的子集。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,2,2]
<strong>输出:</strong>
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        backTrack(res, nums, 0, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, int index, List<Integer> ls){
        res.add(new ArrayList<>(ls));
        if(index>=nums.length) return;
        for(int i=index;i<nums.length;i++){
            ls.add(nums[i]);
            backTrack(res, nums, i+1, ls);
            ls.remove(ls.size()-1);
            while(i<nums.length-1 && nums[i+1]==nums[i]) i++;
        }
    }
}
```

# [91. 解码方法](https://leetcode-cn.com/problems/decode-ways)
## 题目描述

<p>一条包含字母&nbsp;<code>A-Z</code> 的消息通过以下方式进行了编码：</p>
<pre>&#39;A&#39; -&gt; 1
&#39;B&#39; -&gt; 2
...
&#39;Z&#39; -&gt; 26
</pre>

<p>给定一个只包含数字的<strong>非空</strong>字符串，请计算解码方法的总数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;12&quot;
<strong>输出:</strong> 2
<strong>解释:</strong>&nbsp;它可以解码为 &quot;AB&quot;（1 2）或者 &quot;L&quot;（12）。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> &quot;226&quot;
<strong>输出:</strong> 3
<strong>解释:</strong>&nbsp;它可以解码为 &quot;BZ&quot; (2 26), &quot;VF&quot; (22 6), 或者 &quot;BBF&quot; (2 2 6) 。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int current = s.charAt(0) == '0' ? 0 : 1;
        int last = 1;
        for (int i = 1; i < len; i++) {
            int tmp = current;
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') current = last;
                else return 0;
            }else if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                current += last;
            }
            last = tmp;
        }
        return current;
    }
}
```

# [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii)
## 题目描述

<p>反转从位置 <em>m</em> 到 <em>n</em> 的链表。请使用一趟扫描完成反转。</p>
<p><strong>说明:</strong><br>
1 &le;&nbsp;<em>m</em>&nbsp;&le;&nbsp;<em>n</em>&nbsp;&le; 链表长度。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL, <em>m</em> = 2, <em>n</em> = 4
<strong>输出:</strong> 1-&gt;4-&gt;3-&gt;2-&gt;5-&gt;NULL</pre>


## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        for (int i = 0; i < m - 1; ++i) {
            pre = cur;
            cur = cur.next;
        }
        ListNode p = pre, q = cur;
        for (int i = 0; i < n - m + 1; ++i) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        p.next = pre;
        q.next = cur;
        return dummy.next;
    }
}
```

# [93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses)
## 题目描述

<p>给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> &quot;25525511135&quot;
<strong>输出:</strong> <code>[&quot;255.255.11.135&quot;, &quot;255.255.111.35&quot;]</code></pre>


## 解法

### **Java**
```java
class Solution {
    private List<String> result;
    private int length;
    public List<String> restoreIpAddresses(String s) {
        result  = new ArrayList<>();
        length = s.length();
        int[] ip = new int[4];
        restoreIpAddresses(s,0,ip,0);
        return result;
    }
    private void restoreIpAddresses(String s, int si, int[] ip, int pi) {
        int sl = length - si , pl = 3 - pi , i = -1;
        String pfx = null;
        while (si< length){
            int num = s.charAt(si++) - '1' + 1;
            if (i==0) break;
            i = i == -1 ? num : i * 10 + num;
            sl--;
            if (i>255) break;
            if (sl < pl || sl > pl * 3) continue;
            if (pi==3){
                if (pfx==null){
                    StringBuilder pfxBuilder = new StringBuilder();
                    for (int j = 0; j < ip.length-1; j++) pfxBuilder.append(ip[j]).append('.');
                    pfx = pfxBuilder.toString();
                }
                result.add(pfx + i);
            }
            ip[pi] = i;
            restoreIpAddresses(s,si,ip,pi+1);
        }
    }
}
```

# [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)
## 题目描述

<p>给定一个二叉树，返回它的<em>中序&nbsp;</em>遍历。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,null,2,3]
   1
    \
     2
    /
   3
<strong>输出:</strong> [1,3,2]</pre>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>

## 解法

### **Java**
```java
// 递归版本
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
    
}
*/
// 非递归版本
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
        
    }
    
}
```

# [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii)
## 题目描述

<p>给定一个整数 <em>n</em>，生成所有由 1 ...&nbsp;<em>n</em> 为节点所组成的<strong>二叉搜索树</strong>。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 3
<strong>输出:</strong>
[
&nbsp; [1,null,3,2],
&nbsp; [3,2,null,1],
&nbsp; [3,1,null,null,2],
&nbsp; [2,1,3],
&nbsp; [1,null,2,null,3]
]
<strong>解释:</strong>
以上的输出对应以下 5 种不同结构的二叉搜索树：
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = generateTrees(left, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, right);
                for (TreeNode l : leftTrees) {
                    for (TreeNode r : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
```

# [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees)
## 题目描述

<p>给定一个整数 <em>n</em>，求以&nbsp;1 ...&nbsp;<em>n</em>&nbsp;为节点组成的二叉搜索树有多少种？</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 3
<strong>输出:</strong> 5
<strong>解释:
</strong>给定 <em>n</em> = 3, 一共有 5 种不同结构的二叉搜索树:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3</pre>


## 解法

### **Java**
```java
class Solution {
    public int numTrees(int n) {
        // res[n] 表示整数n组成的二叉搜索树个数
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
```

# [97. 交错字符串](https://leetcode-cn.com/problems/interleaving-string)
## 题目描述

<p>给定三个字符串&nbsp;<em>s1</em>, <em>s2</em>, <em>s3</em>, 验证&nbsp;<em>s3</em>&nbsp;是否是由&nbsp;<em>s1</em>&nbsp;和&nbsp;<em>s2 </em>交错组成的。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, <em>s3</em> = &quot;aadbbcbcac&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> s1 = &quot;aabcc&quot;, s2 = &quot;dbbca&quot;, <em>s3</em> = &quot;aadbbbaccc&quot;
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }
    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid = i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }
}
```

# [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree)
## 题目描述

<p>给定一个二叉树，判断其是否是一个有效的二叉搜索树。</p>
<p>假设一个二叉搜索树具有如下特征：</p>
<ul>
	<li>节点的左子树只包含<strong>小于</strong>当前节点的数。</li>
	<li>节点的右子树只包含<strong>大于</strong>当前节点的数。</li>
	<li>所有左子树和右子树自身必须也是二叉搜索树。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
    2
   / \
  1   3
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:
</strong>    5
   / \
  1   4
&nbsp;    / \
&nbsp;   3   6
<strong>输出:</strong> false
<strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。
&nbsp;    根节点的值为 5 ，但是其右子节点值为 4 。
</pre>


## 解法

### **Java**
```java
class Solution {
    private long current = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left) && current < root.val) {
            current = root.val;
            return isValidBST(root.right);
        }
        return false;
    }
}
```

# [99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree)
## 题目描述

<p>二叉搜索树中的两个节点被错误地交换。</p>
<p>请在不改变其结构的情况下，恢复这棵树。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [1,3,null,null,2]
&nbsp;  1
&nbsp; /
&nbsp;3
&nbsp; \
&nbsp;  2
<strong>输出:</strong> [3,1,null,null,2]
&nbsp;  3
&nbsp; /
&nbsp;1
&nbsp; \
&nbsp;  2
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [3,1,4,null,null,2]
  3
 / \
1   4
&nbsp;  /
&nbsp; 2
<strong>输出:</strong> [2,1,4,null,null,3]
  2
 / \
1   4
&nbsp;  /
 &nbsp;3</pre>

<p><strong>进阶:</strong></p>
<ul>
	<li>使用 O(<em>n</em>) 空间复杂度的解法很容易实现。</li>
	<li>你能想出一个只使用常数空间的解决方案吗？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    private TreeNode first,second,pre;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (pre != null) {
            if (first == null && pre.val > root.val) first = pre;
            if (first != null && pre.val > root.val) second = root;
        }
        pre = root;
        traverse(root.right);
    }
}
```

# [100. 相同的树](https://leetcode-cn.com/problems/same-tree)
## 题目描述

<p>给定两个二叉树，编写一个函数来检验它们是否相同。</p>
<p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>      1         1
          / \       / \
         2   3     2   3
        [1,2,3],   [1,2,3]
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:  </strong>    1          1
          /           \
         2             2
        [1,2],     [1,null,2]
<strong>输出:</strong> false
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>       1         1
          / \       / \
         2   1     1   2
        [1,2,1],   [1,1,2]
<strong>输出:</strong> false
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

# [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree)
## 题目描述

<p>给定一个二叉树，检查它是否是镜像对称的。</p>
<p>例如，二叉树&nbsp;<code>[1,2,2,3,4,4,3]</code> 是对称的。</p>
<pre>    1
   / \
  2   2
 / \ / \
3  4 4  3
</pre>

<p>但是下面这个&nbsp;<code>[1,2,2,null,3,null,3]</code> 则不是镜像对称的:</p>
<pre>    1
   / \
  2   2
   \   \
   3    3
</pre>

<p><strong>说明:</strong></p>
<p>如果你可以运用递归和迭代两种方法解决这个问题，会很加分。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
```

# [102. 二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)
## 题目描述

<p>给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。</p>
<p>例如:<br>
给定二叉树:&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回其层次遍历结果：</p>
<pre>[
  [3],
  [9,20],
  [15,7]
]
</pre>


## 解法
队列实现。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(t);
        }
        return res;
    }
}
```

# [103. 二叉树的锯齿形层次遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal)
## 题目描述

<p>给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>
<p>例如：<br>
给定二叉树&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回锯齿形层次遍历如下：</p>
<pre>[
  [3],
  [20,9],
  [15,7]
]
</pre>


## 解法

### **Java**
```java
class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        lever(root, 0);
        for (int i = 1; i < list.size(); i = i + 2) {
            List<Integer> nList = list.get(i);
            List<Integer> nnl = new ArrayList<>();
            for (int j = nList.size() - 1; j >= 0; j--) nnl.add(nList.get(j));
            list.set(i, nnl);
        }
        return list;
    }
    private void lever(TreeNode root, int l) {
        if (root == null) return;
        while (l > list.size() - 1) list.add(new ArrayList<>());
        list.get(l++).add(root.val);
        lever(root.left, l);
        lever(root.right, l);
    }
}
```

# [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
## 题目描述

<p>给定一个二叉树，找出其最大深度。</p>
<p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例：</strong><br>
给定二叉树 <code>[3,9,20,null,null,15,7]</code>，</p>
<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回它的最大深度&nbsp;3 。</p>

## 解法
递归遍历左右子树，求左右子树的最大深度 +1 即可。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }
}
```
# [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
## 题目描述

<p>根据一棵树的前序遍历与中序遍历构造二叉树。</p>
<p><strong>注意:</strong><br>
你可以假设树中没有重复的元素。</p>
<p>例如，给出</p>
<pre>前序遍历 preorder =&nbsp;[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]</pre>

<p>返回如下的二叉树：</p>
<pre>    3
   / \
  9  20
    /  \
   15   7</pre>


## 解法
先遍历前序节点，对于前序的根节点，在中序节点 `[i1, i2]` 中找到根节点的位置 pos，就可以将中序节点分成：左子树 `[i1, pos - 1]`、右子树 `[pos + 1, i2]`。
通过左右子树的区间，可以计算出左、右子树节点的个数，假设为 m、n。然后在前序节点中，从根节点往后的 m 个节点为左子树，再往后的 n 个节点为右子树。
递归求解即可。
> 前序遍历：先遍历根节点，再遍历左右子树；中序遍历：先遍历左子树，再遍历根节点，最后遍历右子树。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            indexes.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2 || i1 > i2) return null;
        int rootVal = preorder[p1];
        int pos = indexes.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        // pos==i1，说明只有右子树，左子树为空
        node.left = pos == i1 ? null : build(preorder, inorder, p1 + 1, pos - i1 + p1, i1, pos - 1);
        // pos==i2，说明只有左子树，右子树为空
        node.right = pos == i2 ? null : build(preorder, inorder, pos - i1 + p1 + 1, p2, pos + 1, i2);
        return node;
    }
}
```

# [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)
## 题目描述

<p>根据一棵树的中序遍历与后序遍历构造二叉树。</p>
<p><strong>注意:</strong><br>
你可以假设树中没有重复的元素。</p>
<p>例如，给出</p>
<pre>中序遍历 inorder =&nbsp;[9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]</pre>

<p>返回如下的二叉树：</p>
<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>


## 解法
思路同 [105](/solution/0100-0199/0105.Construct%20Binary%20Tree%20from%20Preorder%20and%20Inorder%20Traversal/README.md)。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            indexes.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int i1, int i2, int p1, int p2) {
        if (i1 > i2 || p1 > p2) return null;
        int rootVal = postorder[p2];
        int pos = indexes.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = pos == i1 ? null : build(inorder, postorder, i1, pos - 1, p1, p1 - i1 + pos - 1);
        root.right = pos == i2 ? null : build(inorder, postorder, pos + 1, i2, p1 - i1 + pos, p2 - 1);
        return root;
    }
}
```

# [107. 二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii)
## 题目描述

<p>给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）</p>
<p>例如：<br>
给定二叉树 <code>[3,9,20,null,null,15,7]</code>,</p>
<pre>    3
   / \
  9  20
    /  \
   15   7
</pre>

<p>返回其自底向上的层次遍历为：</p>
<pre>[
  [15,7],
  [9,20],
  [3]
]
</pre>


## 解法
同 [102](/solution/0100-0199/0102.Binary%20Tree%20Level%20Order%20Traversal/README.md)，最后反转一下结果即可。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(0, t);
        }
        return res;
    }
}
```

# [108. 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree)
## 题目描述

<p>将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。</p>
<p>本题中，一个高度平衡二叉树是指一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过 1。</p>
<p><strong>示例:</strong></p>
<pre>给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }
}
```

# [109. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree)
## 题目描述

<p>给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。</p>
<p>本题中，一个高度平衡二叉树是指一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过 1。</p>
<p><strong>示例:</strong></p>
<pre>给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
</pre>


## 解法

### **Java**
```java
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root = new TreeNode(Objects.requireNonNull(prev).next.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
```

# [110. 平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree)
## 题目描述

<p>给定一个二叉树，判断它是否是高度平衡的二叉树。</p>
<p>本题中，一棵高度平衡二叉树定义为：</p>
<blockquote>
<p>一个二叉树<em>每个节点&nbsp;</em>的左右两个子树的高度差的绝对值不超过1。</p>
</blockquote>
<p><strong>示例 1:</strong></p>
<p>给定二叉树 <code>[3,9,20,null,null,15,7]</code></p>
<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回 <code>true</code> 。<br>
<br>
<strong>示例 2:</strong></p>
<p>给定二叉树 <code>[1,2,2,3,3,null,null,4,4]</code></p>
<pre>       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
</pre>

<p>返回&nbsp;<code>false</code> 。</p>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
```

# [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree)
## 题目描述

<p>给定一个二叉树，找出其最小深度。</p>
<p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例:</strong></p>
<p>给定二叉树&nbsp;<code>[3,9,20,null,null,15,7]</code>,</p>
<pre>    3
   / \
  9  20
    /  \
   15   7</pre>

<p>返回它的最小深度 &nbsp;2.</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null || root.right == null) return l + r + 1;
        return Math.min(l, r) + 1;
    }
}
```

# [112. 路径总和](https://leetcode-cn.com/problems/path-sum)
## 题目描述

<p>给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例:</strong>&nbsp;<br>
给定如下二叉树，以及目标和 <code>sum = 22</code>，</p>
<pre>              <strong>5</strong>
             / \
            <strong>4 </strong>  8
           /   / \
          <strong>11 </strong> 13  4
         /  \      \
        7    <strong>2</strong>      1
</pre>

<p>返回 <code>true</code>, 因为存在目标和为 22 的根节点到叶子节点的路径 <code>5-&gt;4-&gt;11-&gt;2</code>。</p>

## 解法
递归求解，递归地询问它的子节点是否能满足条件即可。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }
    private boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}
```

# [113. 路径总和 II](https://leetcode-cn.com/problems/path-sum-ii)
## 题目描述

<p>给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例:</strong><br>
给定如下二叉树，以及目标和&nbsp;<code>sum = 22</code>，</p>
<pre>              <strong>5</strong>
             / \
            <strong>4</strong>   <strong>8</strong>
           /   / \
          <strong>11</strong>  13  <strong>4</strong>
         /  \    / \
        7    <strong>2</strong>  <strong>5</strong>   1
</pre>

<p>返回:</p>
<pre>[
   [5,4,11,2],
   [5,8,4,5]
]
</pre>


## 解法
深度优先搜索+路径记录。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> res;
    private List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, sum);
        return res;
    }
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
```

# [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list)
## 题目描述

<p>给定一个二叉树，<a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95/8010757" target="_blank">原地</a>将它展开为链表。</p>
<p>例如，给定二叉树</p>
<pre>    1
   / \
  2   5
 / \   \
3   4   6</pre>

<p>将其展开为：</p>
<pre>1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6</pre>


## 解法

### **Java**
```java
class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        TreeNode right = root.right;
        flatten(right);
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        TreeNode cache = root;
        while (cache.right!=null) cache = cache.right;
        cache.right = right;
    }
}
```


# [116. 填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node)
## 题目描述

<p>给定一个<strong>完美二叉树</strong>，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：</p>
<pre>struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}</pre>

<p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>
<p>初始状态下，所有&nbsp;next 指针都被设置为 <code>NULL</code>。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224220914970.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>{&quot;$id&quot;:&quot;1&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;2&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;3&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:4},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;4&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:5},&quot;val&quot;:2},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;5&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;6&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:6},&quot;next&quot;:null,&quot;right&quot;:{&quot;$id&quot;:&quot;7&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:7},&quot;val&quot;:3},&quot;val&quot;:1}
<strong>输出：</strong>{&quot;$id&quot;:&quot;1&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;2&quot;,&quot;left&quot;:{&quot;$id&quot;:&quot;3&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;4&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;5&quot;,&quot;left&quot;:null,&quot;next&quot;:{&quot;$id&quot;:&quot;6&quot;,&quot;left&quot;:null,&quot;next&quot;:null,&quot;right&quot;:null,&quot;val&quot;:7},&quot;right&quot;:null,&quot;val&quot;:6},&quot;right&quot;:null,&quot;val&quot;:5},&quot;right&quot;:null,&quot;val&quot;:4},&quot;next&quot;:{&quot;$id&quot;:&quot;7&quot;,&quot;left&quot;:{&quot;$ref&quot;:&quot;5&quot;},&quot;next&quot;:null,&quot;right&quot;:{&quot;$ref&quot;:&quot;6&quot;},&quot;val&quot;:3},&quot;right&quot;:{&quot;$ref&quot;:&quot;4&quot;},&quot;val&quot;:2},&quot;next&quot;:null,&quot;right&quot;:{&quot;$ref&quot;:&quot;7&quot;},&quot;val&quot;:1}
<strong>解释：</strong>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>你只能使用常量级额外空间。</li>
	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        if (root.next == null) root.right.next = null;
        else root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
```

# [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii)
## 题目描述

<p>给定一个二叉树</p>
<pre>struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}</pre>

<p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 <code>NULL</code>。</p>
<p>初始状态下，所有&nbsp;next 指针都被设置为 <code>NULL</code>。</p>
<p>&nbsp;</p>
<p><strong>进阶：</strong></p>
<ul>
	<li>你只能使用常量级额外空间。</li>
	<li>使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224220937326.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入</strong>：root = [1,2,3,4,5,null,7]
<strong>输出：</strong>[1,#,2,3,#,4,5,7,#]
<strong>解释：</strong>给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>树中的节点数小于 <code>6000</code></li>
	<li><code>-100&nbsp;&lt;= node.val &lt;= 100</code></li>
</ul>
<p>&nbsp;</p>
<ul>
</ul>

## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode first_node_next_layer = null;
        TreeLinkNode preNode = null;
        for (TreeLinkNode curNode = root; curNode != null; curNode = curNode.next) {
            if (curNode.left != null) {
                if (preNode == null) {
                    preNode = curNode.left;
                    first_node_next_layer = curNode.left;
                } else {
                    preNode.next = curNode.left;
                    preNode = preNode.next;
                }
            }
            if (curNode.right != null) {
                if (preNode == null) {
                    preNode = curNode.right;
                    first_node_next_layer = curNode.right;
                } else {
                    preNode.next = curNode.right;
                    preNode = preNode.next;
                }
            }
        }
        connect(first_node_next_layer);
    }
}
```

# [118. 杨辉三角](https://leetcode-cn.com/problems/pascals-triangle)
## 题目描述

<p>给定一个非负整数&nbsp;<em>numRows，</em>生成杨辉三角的前&nbsp;<em>numRows&nbsp;</em>行。</p>
<p><img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif"></p>
<p><small>在杨辉三角中，每个数是它左上方和右上方的数的和。</small></p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 5
<strong>输出:</strong>
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]</pre>


## 解法
先设置每一行首尾元素为 1，其它元素为 0。然后根据杨辉三角，设置每一行其它元素即可。

### **Java**
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; ++i) {
            // 每一行
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < i + 1; ++j) {
                boolean firstOrLast = j == 0 || j == i;
                // 设置每一行首尾元素为1，其它元素为0
                t.add(firstOrLast ? 1 : 0);
            }
            for (int j = 1; j < i; ++j) {
                int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                t.set(j, val);
            }
            res.add(t);
        }
        return res;
    }
}
```

# [119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii)
## 题目描述

<p>给定一个非负索引&nbsp;<em>k</em>，其中 <em>k</em>&nbsp;&le;&nbsp;33，返回杨辉三角的第 <em>k </em>行。</p>
<p><img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif"></p>
<p><small>在杨辉三角中，每个数是它左上方和右上方的数的和。</small></p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 3
<strong>输出:</strong> [1,3,3,1]
</pre>

<p><strong>进阶：</strong></p>
<p>你可以优化你的算法到 <em>O</em>(<em>k</em>) 空间复杂度吗？</p>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new LinkedList<>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ret.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return ret;
    }
}
```

# [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle)
## 题目描述

<p>给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。</p>
<p>例如，给定三角形：</p>
<pre>[
     [<strong>2</strong>],
    [<strong>3</strong>,4],
   [6,<strong>5</strong>,7],
  [4,<strong>1</strong>,8,3]
]
</pre>

<p>自顶向下的最小路径和为&nbsp;<code>11</code>（即，<strong>2&nbsp;</strong>+&nbsp;<strong>3</strong>&nbsp;+&nbsp;<strong>5&nbsp;</strong>+&nbsp;<strong>1</strong>&nbsp;= 11）。</p>
<p><strong>说明：</strong></p>
<p>如果你可以只使用 <em>O</em>(<em>n</em>)&nbsp;的额外空间（<em>n</em> 为三角形的总行数）来解决这个问题，那么你的算法会很加分。</p>

## 解法

### **Java**
```java
class Solution {
    private int[][] cache = null;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        cache = new int[n][triangle.get(n - 1).size()];
        for (int[] row : cache) Arrays.fill(row, -1);
        return dfs(triangle,0,0);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) return 0;
        if (cache[row][col] != -1) return cache[row][col];
        int l = dfs(triangle,row+1,col);
        int r = dfs(triangle,row+1,col+1);
        int res = Math.min(l,r)+triangle.get(row).get(col);
        cache[row][col] = res;
        return res;
    }
}
```

# [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)
## 题目描述

<p>给定一个数组，它的第&nbsp;<em>i</em> 个元素是一支给定股票第 <em>i</em> 天的价格。</p>
<p>如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。</p>
<p>注意你不能在买入股票前卖出股票。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [7,1,5,3,6,4]
<strong>输出:</strong> 5
<strong>解释: </strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [7,6,4,3,1]
<strong>输出:</strong> 0
<strong>解释: </strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }
        return res;
    }
}
```

# [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii)
## 题目描述

<p>给定一个数组，它的第&nbsp;<em>i</em> 个元素是一支给定股票第 <em>i</em> 天的价格。</p>
<p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。</p>
<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [7,1,5,3,6,4]
<strong>输出:</strong> 7
<strong>解释:</strong> 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
&nbsp;    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> 4
<strong>解释:</strong> 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
&nbsp;    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
&nbsp;    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> [7,6,4,3,1]
<strong>输出:</strong> 0
<strong>解释:</strong> 在这种情况下, 没有交易完成, 所以最大利润为 0。</pre>


## 解法
所有上涨交易日都做买卖，所有下跌交易日都不做买卖，这样便能实现利润最大化。

### **Java**
```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int res = 0;
        for (int i = 1, n = prices.length; i < n; ++i) {
            // 策略是所有上涨交易日都做买卖，所以下跌交易日都不做买卖
            int t = prices[i] - prices[i - 1];
            res += Math.max(t, 0);
        }
        return res;
    }
}
```



# [125. 验证回文串](https://leetcode-cn.com/problems/valid-palindrome)
## 题目描述

<p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。</p>
<p><strong>说明：</strong>本题中，我们将空字符串定义为有效的回文串。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;A man, a plan, a canal: Panama&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> &quot;race a car&quot;
<strong>输出:</strong> false
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```



# [128. 最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence)
## 题目描述

<p>给定一个未排序的整数数组，找出最长连续序列的长度。</p>
<p>要求算法的时间复杂度为&nbsp;<em>O(n)</em>。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>&nbsp;[100, 4, 200, 1, 3, 2]
<strong>输出:</strong> 4
<strong>解释:</strong> 最长连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>


## 解法

### **Java**
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int start = 0, casch = nums[0], longest = 0;
        for (int i = 1; i < nums.length; i++) {
            int nc = nums[i] , con = nc - casch;
            if (con == 0) {
                start++;
            } else if (con != 1) {
                longest = Math.max(i - start, longest);
                start = i;
            }
            casch = nc;
        }
        return Math.max(nums.length - start, longest);
    }
}
```

# [129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers)
## 题目描述

<p>给定一个二叉树，它的每个结点都存放一个&nbsp;<code>0-9</code>&nbsp;的数字，每条从根到叶子节点的路径都代表一个数字。</p>
<p>例如，从根到叶子节点路径 <code>1-&gt;2-&gt;3</code> 代表数字 <code>123</code>。</p>
<p>计算从根到叶子节点生成的所有数字之和。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [1,2,3]
    1
   / \
  2   3
<strong>输出:</strong> 25
<strong>解释:</strong>
从根到叶子节点路径 <code>1-&gt;2</code> 代表数字 <code>12</code>.
从根到叶子节点路径 <code>1-&gt;3</code> 代表数字 <code>13</code>.
因此，数字总和 = 12 + 13 = <code>25</code>.</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [4,9,0,5,1]
    4
   / \
  9   0
&nbsp;/ \
5   1
<strong>输出:</strong> 1026
<strong>解释:</strong>
从根到叶子节点路径 <code>4-&gt;9-&gt;5</code> 代表数字 495.
从根到叶子节点路径 <code>4-&gt;9-&gt;1</code> 代表数字 491.
从根到叶子节点路径 <code>4-&gt;0</code> 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = <code>1026</code>.</pre>


## 解法

### **Java**
```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int sum) {
        if (root==null) return 0;
        sum = sum *10 + root.val;
        if (root.left==null && root.right==null) return sum;
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    }
}
```

# [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions)
## 题目描述

<p>给定一个二维的矩阵，包含&nbsp;<code>&#39;X&#39;</code>&nbsp;和&nbsp;<code>&#39;O&#39;</code>（<strong>字母 O</strong>）。</p>
<p>找到所有被 <code>&#39;X&#39;</code> 围绕的区域，并将这些区域里所有的&nbsp;<code>&#39;O&#39;</code> 用 <code>&#39;X&#39;</code> 填充。</p>
<p><strong>示例:</strong></p>
<pre>X X X X
X O O X
X X O X
X O X X
</pre>

<p>运行你的函数后，矩阵变为：</p>
<pre>X X X X
X X X X
X X X X
X O X X
</pre>

<p><strong>解释:</strong></p>
<p>被围绕的区间不会存在于边界上，换句话说，任何边界上的&nbsp;<code>&#39;O&#39;</code>&nbsp;都不会被填充为&nbsp;<code>&#39;X&#39;</code>。 任何不在边界上，或不与边界上的&nbsp;<code>&#39;O&#39;</code>&nbsp;相连的&nbsp;<code>&#39;O&#39;</code>&nbsp;最终都会被填充为&nbsp;<code>&#39;X&#39;</code>。如果两个元素在水平或垂直方向相邻，则称它们是&ldquo;相连&rdquo;的。</p>

## 解法

### **Java**
```java
class Solution {
    /**
     * 坐标点
     */
    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // top & bottom
        for (int i = 0; i < n; ++i) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }
        // left & right
        for (int i = 1; i < m - 1; ++i) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    /**
     * 广度优先搜索
     * @param board
     * @param i
     * @param j
     */
    private void bfs(char[][] board, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        if (isValid(board, i, j)) {
            // 遇到'O'，修改为'Y'
            board[i][j] = 'Y';
            queue.offer(new Point(i, j));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            // 获取下一层所有有效坐标点，并加入队列
            List<Point> points = getNextLevelValidPoints(board, p.x, p.y);
            for (Point point : points) {
                queue.offer(point);
            }
        }
    }
    /**
     * 获取下一层所有有效坐标点，将这些坐标点修改为 'Y' 并返回
     * @param board
     * @param i
     * @param j
     * @return list
     */
    private List<Point> getNextLevelValidPoints(char[][] board, int i, int j) {
        List<Point> points = new ArrayList<>();
        Point[] arr = new Point[] { new Point(i - 1, j), new Point(i + 1, j), new Point(i, j - 1),
                new Point(i, j + 1) };
        for (Point point : arr) {
            if (isValid(board, point.x, point.y)) {
                board[point.x][point.y] = 'Y';
                points.add(point);
            }
        }
        return points;
    }
    /**
     * 判断坐标是否有效
     * @param board
     * @param i
     * @param j
     * @return boolean
     */
    private boolean isValid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        // 当前坐标对应的值是'O'，才算有效
        return i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1 && board[i][j] == 'O';
    }
}
```

# [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning)
## 题目描述

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

### **Java**
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


# [133. 克隆图](https://leetcode-cn.com/problems/clone-graph)
## 题目描述

<p>给你无向&nbsp;<strong><a href="https://baike.baidu.com/item/连通图/6460995?fr=aladdin" target="_blank">连通</a>&nbsp;</strong>图中一个节点的引用，请你返回该图的&nbsp;<a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank"><strong>深拷贝</strong></a>（克隆）。</p>
<p>图中的每个节点都包含它的值 <code>val</code>（<code>int</code>） 和其邻居的列表（<code>list[Node]</code>）。</p>
<pre>class Node {
    public int val;
    public List&lt;Node&gt; neighbors;
}</pre>

<p>&nbsp;</p>
<p><strong>测试用例格式：</strong></p>
<p>简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1，第二个节点值为 2，以此类推。该图在测试用例中使用邻接列表表示。</p>
<p>邻接列表是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。</p>
<p>给定节点将始终是图中的第一个节点（值为 1）。你必须将&nbsp;<strong>给定节点的拷贝&nbsp;</strong>作为对克隆图的引用返回。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224220956106.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>adjList = [[2,4],[1,3],[2,4],[1,3]]
<strong>输出：</strong>[[2,4],[1,3],[2,4],[1,3]]
<strong>解释：
</strong>图中有 4 个节点。
节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221230256.png)
<pre><strong>输入：</strong>adjList = [[]]
<strong>输出：</strong>[[]]
<strong>解释：</strong>输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>adjList = []
<strong>输出：</strong>[]
<strong>解释：</strong>这个图是空的，它不含任何节点。
</pre>

<p><strong>示例 4：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221247262.png)
<pre><strong>输入：</strong>adjList = [[2],[1]]
<strong>输出：</strong>[[2],[1]]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>节点数介于 1 到 100 之间。</li>
	<li>每个节点值都是唯一的。</li>
	<li>无向图是一个<a href="https://baike.baidu.com/item/简单图/1680528?fr=aladdin" target="_blank">简单图</a>，这意味着图中没有重复的边，也没有自环。</li>
	<li>由于图是无向的，如果节点 <em>p</em> 是节点 <em>q</em> 的邻居，那么节点 <em>q</em> 也必须是节点 <em>p</em>&nbsp;的邻居。</li>
	<li>图是连通图，你可以从给定节点访问到所有节点。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    private Map<Node, Node> cache;
    public Node cloneGraph(Node node) {
        cache = new HashMap<>(16);
        return helper(node);
    }
    private Node helper(Node node) {
        if (node == null) return null;
        else if (cache.containsKey(node)) return cache.get(node);
        Node nodeCopy = new Node(node.val,new ArrayList<>());
        cache.put(node, nodeCopy);
        for (Node neighbor : node.neighbors) nodeCopy.neighbors.add(helper(neighbor));
        return nodeCopy;
    }
}
```

# [134. 加油站](https://leetcode-cn.com/problems/gas-station)
## 题目描述

<p>在一条环路上有&nbsp;<em>N</em>&nbsp;个加油站，其中第&nbsp;<em>i</em>&nbsp;个加油站有汽油&nbsp;<code>gas[i]</code><em>&nbsp;</em>升。</p>
<p>你有一辆油箱容量无限的的汽车，从第<em> i </em>个加油站开往第<em> i+1&nbsp;</em>个加油站需要消耗汽油&nbsp;<code>cost[i]</code><em>&nbsp;</em>升。你从其中的一个加油站出发，开始时油箱为空。</p>
<p>如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。</p>
<p><strong>说明:</strong>&nbsp;</p>
<ul>
	<li>如果题目有解，该答案即为唯一答案。</li>
	<li>输入数组均为非空数组，且长度相同。</li>
	<li>输入数组中的元素均为非负数。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
<strong>输出:</strong> 3
<strong>解释:
</strong>从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 
gas  = [2,3,4]
cost = [3,4,3]
<strong>输出:</strong> -1
<strong>解释:
</strong>你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。</pre>


## 解法

### **Java**
```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length!=cost.length) return -1;
        int sum=0,total=0,index=0;
        for(int i=0;i<gas.length;i++){
            int sy = gas[i] - cost[i];
            sum+= sy;
            total+= sy;
            if(sum<0){
                index=i+1;
                sum=0;
            }
        }
        if(total<0) return -1;
        return index;
    }
}
```


# [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number)
## 题目描述

<p>给定一个<strong>非空</strong>整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。</p>
<p><strong>说明：</strong></p>
<p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [2,2,1]
<strong>输出:</strong> 1
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [4,1,2,1,2]
<strong>输出:</strong> 4</pre>


## 解法
异或运算求解。
首先明确，两个相同的数异或之后的结果为 0。对该数组所有元素进行异或运算，结果就是那个只出现一次的数字。

### **Java**
```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
```

# [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii)
## 题目描述

<p>给定一个<strong>非空</strong>整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。</p>
<p><strong>说明：</strong></p>
<p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [2,2,3,2]
<strong>输出:</strong> 3
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [0,1,0,1,0,1,99]
<strong>输出:</strong> 99</pre>


## 解法
统计所有数字每个位中 1 出现的次数，对于某个位，1 出现的次数一定是 3 的倍数 +1 或 0。对这个数 %3 得到的结果就是那个出现一次的数字在该位上的值。

### **Java**
```java
class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                bits[i] += (num & 1);
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (bits[i] % 3 == 1) {
                res += (1 << i);
            }
        }
        return res;
    }
}
```

# [138. 复制带随机指针的链表](https://leetcode-cn.com/problems/copy-list-with-random-pointer)
## 题目描述

<p>给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。</p>
<p>要求返回这个链表的&nbsp;<strong><a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank">深拷贝</a></strong>。&nbsp;</p>
<p>我们用一个由&nbsp;<code>n</code>&nbsp;个节点组成的链表来表示输入/输出中的链表。每个节点用一个&nbsp;<code>[val, random_index]</code>&nbsp;表示：</p>
<ul>
	<li><code>val</code>：一个表示&nbsp;<code>Node.val</code>&nbsp;的整数。</li>
	<li><code>random_index</code>：随机指针指向的节点索引（范围从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n-1</code>）；如果不指向任何节点，则为&nbsp;&nbsp;<code>null</code>&nbsp;。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221347879.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
<strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022422135947.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>head = [[1,1],[2,1]]
<strong>输出：</strong>[[1,1],[2,1]]
</pre>

<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221407684.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
<strong>输出：</strong>[[3,null],[3,0],[3,null]]
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>head = []
<strong>输出：</strong>[]
<strong>解释：</strong>给定的链表为空（空指针），因此返回 null。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>-10000 &lt;= Node.val &lt;= 10000</code></li>
	<li><code>Node.random</code>&nbsp;为空（null）或指向链表中的节点。</li>
	<li>节点数目不超过 1000 。</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        // step1
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        
        // step2
        cur = head;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;   
            }
            cur = clone.next;
        }
        
        // step3
        cur = head;
        RandomListNode cloneHead = head.next;
        while (cur.next != null) {
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            cur = clone;
        }
        
        return cloneHead;
    }
}
```

# [139. 单词拆分](https://leetcode-cn.com/problems/word-break)
## 题目描述

<p>给定一个<strong>非空</strong>字符串 <em>s</em> 和一个包含<strong>非空</strong>单词列表的字典 <em>wordDict</em>，判定&nbsp;<em>s</em> 是否可以被空格拆分为一个或多个在字典中出现的单词。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>拆分时可以重复使用字典中的单词。</li>
	<li>你可以假设字典中没有重复的单词。</li>
</ul>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;, &quot;code&quot;]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 &quot;leetcode&quot; 可以被拆分成 &quot;leet code&quot;。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入:</strong> s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;, &quot;pen&quot;]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 <code>&quot;</code>applepenapple<code>&quot;</code> 可以被拆分成 <code>&quot;</code>apple pen apple<code>&quot;</code>。
&nbsp;    注意你可以重复使用字典中的单词。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入:</strong> s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;, &quot;dog&quot;, &quot;sand&quot;, &quot;and&quot;, &quot;cat&quot;]
<strong>输出:</strong> false
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j > -1; j--) {
                dp[i] = dp[j] && words.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
```


# [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle)
## 题目描述

<p>给定一个链表，判断链表中是否有环。</p>
<p>为了表示给定链表中的环，我们使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221433650.png)
<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221440878.png)
<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>false
<strong>解释：</strong>链表中没有环。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221457303.png)
<p>&nbsp;</p>
<p><strong>进阶：</strong></p>
<p>你能用 <em>O(1)</em>（即，常量）内存解决此问题吗？</p>

## 解法
定义快慢指针 `slow`、`fast`，初始指向 `head`。
快指针每次走两步，慢指针每次走一步，不断循环。当相遇时，说明链表存在环。如果循环结束依然没有相遇，说明链表不存在环。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
```

# [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii)
## 题目描述

<p>给定一个链表，返回链表开始入环的第一个节点。&nbsp;如果链表无环，则返回&nbsp;<code>null</code>。</p>
<p>为了表示给定链表中的环，我们使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。</p>
<p><strong>说明：</strong>不允许修改给定的链表。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>tail connects to node index 1
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221531386.png)
<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>tail connects to node index 0
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221601853.png)
<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>no cycle
<strong>解释：</strong>链表中没有环。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221614736.png)
<p>&nbsp;</p>
<p><strong>进阶：</strong><br>
你是否可以不用额外空间解决此题？</p>

## 解法
先利用快慢指针判断链表是否有环，没有环则直接返回 `null`。
若链表有环，我们分析快慢相遇时走过的距离。
对于慢指针，走过的距离为 `S=X+Y` ①；快指针走过的距离为 `2S=X+Y+N(Y+Z)` ②。如下图所示，其中 `N` 表示快指针与慢指针相遇时在环中所走过的圈数，而我们要求的环入口，也即是 `X` 的距离：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221634155.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
我们根据式子 ①②，得出 `X+Y=N(Y+Z)` => `X=(N-1)(Y+Z)+Z`。
当 `N=1`(快指针在环中走了一圈与慢指针相遇) 时，`X=(1-1)(Y+Z)+Z`，即 `X=Z`。此时只要定义一个 `p` 指针指向头节点，然后慢指针与 `p` 开始同时走，当慢指针与 `p` 相遇时，也就到达了环入口，直接返回 `p` 即可。
当 `N>1`时，也是同样的，说明慢指针除了走 `Z` 步，还需要绕 `N-1` 圈才能与 `p` 相遇。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
```

# [143. 重排链表](https://leetcode-cn.com/problems/reorder-list)
## 题目描述

<p>给定一个单链表&nbsp;<em>L</em>：<em>L</em><sub>0</sub>&rarr;<em>L</em><sub>1</sub>&rarr;&hellip;&rarr;<em>L</em><sub><em>n</em>-1</sub>&rarr;<em>L</em><sub>n ，</sub><br>
将其重新排列后变为： <em>L</em><sub>0</sub>&rarr;<em>L</em><sub><em>n</em></sub>&rarr;<em>L</em><sub>1</sub>&rarr;<em>L</em><sub><em>n</em>-1</sub>&rarr;<em>L</em><sub>2</sub>&rarr;<em>L</em><sub><em>n</em>-2</sub>&rarr;&hellip;</p>
<p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>给定链表 1-&gt;2-&gt;3-&gt;4, 重新排列为 1-&gt;4-&gt;2-&gt;3.</pre>

<p><strong>示例 2:</strong></p>
<pre>给定链表 1-&gt;2-&gt;3-&gt;4-&gt;5, 重新排列为 1-&gt;5-&gt;2-&gt;4-&gt;3.</pre>


## 解法
先通过快慢指针找到链表中点，将链表划分为左右两部分。之后反转右半部分的链表，然后将左右两个链接依次连接即可。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        cur = head;
        while (pre != null) {
            ListNode t1 = cur.next;
            cur.next = pre;
            cur = t1;
            ListNode t2 = pre.next;
            pre.next = cur;
            pre = t2;
        }
    }
}
```

# [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal)
## 题目描述

<p>给定一个二叉树，返回它的&nbsp;<em>前序&nbsp;</em>遍历。</p>
<p>&nbsp;<strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,null,2,3]  
   1
    \
     2
    /
   3 
<strong>输出:</strong> [1,2,3]
</pre>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>

## 解法

### **Java**
```java
// 递归版本
/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
*/
// 非递归版本
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
        
        return list;
    }
}
```

# [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal)
## 题目描述

<p>给定一个二叉树，返回它的 <em>后序&nbsp;</em>遍历。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,null,2,3]  
   1
    \
     2
    /
   3 
<strong>输出:</strong> [3,2,1]</pre>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>

## 解法

### **Java**
```java
// 递归版本
/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
*/
// 非递归版本
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            } else {
                break;
            }
        }
        
        return list;
    }
}
```

# [146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache)
## 题目描述

<p>运用你所掌握的数据结构，设计和实现一个&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (最近最少使用) 缓存机制</a>。它应该支持以下操作： 获取数据 <code>get</code> 和 写入数据 <code>put</code> 。</p>
<p>获取数据 <code>get(key)</code> - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。<br>
写入数据 <code>put(key, value)</code> - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</p>
<p><strong>进阶:</strong></p>
<p>你是否可以在&nbsp;<strong>O(1)</strong> 时间复杂度内完成这两种操作？</p>
<p><strong>示例:</strong></p>
<pre>LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
</pre>


## 解法

### **Java**
```java
//双向链表的节点
class Node{
    public int key;
    public int val;
    public Node pre;//指向前面的指针
    public Node next;//指向后面的指针
    public Node(int key,int value){
        this.val = value;
        this.key = key;
    }
}
class LRUCache {
    int capacity;//容量
    Node head;//双向链表的头，维护这个指针，因为set,get时需要在头部操作
    Node end;//双向链表的尾，set时，要是满了，需要将链表的最后一个节点remove
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();//hash表
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    //添加，删除尾部，插入头部的操作
    public void remove(Node node){
        Node cur = node;
        Node pre = node.pre;
        Node post = node.next;
        if(pre == null){//说明cur是头部节点
            head = post;
        }
        else pre.next = post;//更新指针，删除
        if(post == null){//说明cur是最后的节点
            end = pre;
        }
        else post.pre = pre;
    }
    public void setHead(Node node){
        //直接插入
        node.next = head;
        node.pre = null;
        if(head != null) head.pre = node;//防止第一次插入时为空
        head = node;
        if(end==null) end = node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            //需要把对应的节点调整到头部
            Node latest = map.get(key);
            remove(latest);
            setHead(latest);
            //返回value
            return latest.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){//这个key原来存在
            //只需要把key对应的node提到最前面，更新value
            Node oldNode = map.get(key);
            oldNode.val = value;
            remove(oldNode);
            setHead(oldNode);
        }
        else{
            //这个key原来不存在，需要重新new出来
            Node newNode = new Node(key,value);
            //接下来要考虑容量
            if(map.size() < capacity){
                setHead(newNode);
                map.put(key, newNode);
            }
            else{
                //容量不够，需要先将map中,最不常使用的那个删除了删除
                map.remove(end.key);
                //接下来更新双向链表
                remove(end);
                setHead(newNode);
                //放入新的
                map.put(key, newNode);
            }
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

# [147. 对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list)
## 题目描述

<p>对链表进行插入排序。</p>
<p><img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif"><br>
<small>插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。<br>
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。</small></p>
<p>&nbsp;</p>
<p><strong>插入排序算法：</strong></p>
<ol>
	<li>插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。</li>
	<li>每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。</li>
	<li>重复直到所有输入数据插入完为止。</li>
</ol>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> 4-&gt;2-&gt;1-&gt;3
<strong>输出:</strong> 1-&gt;2-&gt;3-&gt;4
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入:</strong> -1-&gt;5-&gt;3-&gt;4-&gt;0
<strong>输出:</strong> -1-&gt;0-&gt;3-&gt;4-&gt;5
</pre>


## 解法
遍历链表，每次将遍历到的结点 cur 与前一个结点 pre 进行值比较：
- 若结点 cur 的值比 pre 的大，说明当前 cur 已在正确的位置，直接往下遍历。
- 否则，从链表第一个结点开始遍历，将结点 cur 插入到正确的位置。
  依次遍历，直至 cur 指向空，遍历结束。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode p = dummy;
            while (p.next.val <= cur.val) {
                p = p.next;
            }
            ListNode t = cur.next;
            cur.next = p.next;
            p.next = cur;
            pre.next = t;
            cur = t;
        }
        return dummy.next;
    }
}
```

# [148. 排序链表](https://leetcode-cn.com/problems/sort-list)
## 题目描述

<p>在&nbsp;<em>O</em>(<em>n</em>&nbsp;log&nbsp;<em>n</em>) 时间复杂度和常数级空间复杂度下，对链表进行排序。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 4-&gt;2-&gt;1-&gt;3
<strong>输出:</strong> 1-&gt;2-&gt;3-&gt;4
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> -1-&gt;5-&gt;3-&gt;4-&gt;0
<strong>输出:</strong> -1-&gt;0-&gt;3-&gt;4-&gt;5</pre>


## 解法
先用快慢指针找到链表中点，然后分成左右两个链表，递归排序左右链表。最后合并两个排序的链表即可。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(t);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
```


# [150. 逆波兰表达式求值](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation)
## 题目描述

<p>根据<a href="https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437" target="_blank">逆波兰表示法</a>，求表达式的值。</p>
<p>有效的运算符包括&nbsp;<code>+</code>,&nbsp;<code>-</code>,&nbsp;<code>*</code>,&nbsp;<code>/</code>&nbsp;。每个运算对象可以是整数，也可以是另一个逆波兰表达式。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>整数除法只保留整数部分。</li>
	<li>给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。</li>
</ul>
<p><strong>示例&nbsp;1：</strong></p>
<pre><strong>输入:</strong> [&quot;2&quot;, &quot;1&quot;, &quot;+&quot;, &quot;3&quot;, &quot;*&quot;]
<strong>输出:</strong> 9
<strong>解释:</strong> ((2 + 1) * 3) = 9
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入:</strong> [&quot;4&quot;, &quot;13&quot;, &quot;5&quot;, &quot;/&quot;, &quot;+&quot;]
<strong>输出:</strong> 6
<strong>解释:</strong> (4 + (13 / 5)) = 6
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入:</strong> [&quot;10&quot;, &quot;6&quot;, &quot;9&quot;, &quot;3&quot;, &quot;+&quot;, &quot;-11&quot;, &quot;*&quot;, &quot;/&quot;, &quot;*&quot;, &quot;17&quot;, &quot;+&quot;, &quot;5&quot;, &quot;+&quot;]
<strong>输出:</strong> 22
<strong>解释:</strong> 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22</pre>


## 解法
栈实现。
遍历数组，遇到数字则压入栈中，遇到运算符号，则从栈中弹出右、左操作数，运算过后，将结果压入栈中。
遍历结束后，返回栈中的唯一元素。

### **Java**
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        int left, right;
        for (String token : tokens) {
            switch(token) {
            case "+":
                right = s.pop();
                left = s.pop();
                s.push(left + right);
                break;
            case "-":
                right = s.pop();
                left = s.pop();
                s.push(left - right);
                break;
            case "*":
                right = s.pop();
                left = s.pop();
                s.push(left * right);
                break;
            case "/":
                right = s.pop();
                left = s.pop();
                s.push(left / right);
                break;
            default:
                s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }
}
```

# [151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string)
## 题目描述

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

### **Java**
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

# [152. 乘积最大子序列](https://leetcode-cn.com/problems/maximum-product-subarray)
## 题目描述

<p>给定一个整数数组 <code>nums</code>&nbsp;，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [2,3,-2,4]
<strong>输出:</strong> <code>6</code>
<strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [-2,0,-1]
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>


## 解法
考虑当前位置 i：
- 如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。
- 如果是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
  因此，分别维护 fmax 和 fmin。
- `fmax(i) = max(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])`
- `fmin(i) = min(nums[i], fmax(i - 1) * nums[i], fmin(i - 1) * nums[i])`
- `res = max(fmax(i)), i∈[0, n)`

### **Java**
```java
class Solution {
    public int maxProduct(int[] nums) {
        int maxf = nums[0], minf = nums[0];
        int res = nums[0], n = nums.length;
        for (int i = 1; i < n; ++i) {
            int p = maxf, q = minf;
            maxf = Math.max(nums[i], Math.max(p * nums[i], q * nums[i]));
            minf = Math.min(nums[i], Math.min(p * nums[i], q * nums[i]));
            res = Math.max(res, maxf);
        }
        return res;
    }
}
```

# [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array)
## 题目描述

<p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
<p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code> <strong> </strong>可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
<p>请找出其中最小的元素。</p>
<p>你可以假设数组中不存在重复元素。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [3,4,5,1,2]
<strong>输出:</strong> 1</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [4,5,6,7,0,1,2]
<strong>输出:</strong> 0</pre>


## 解法
二分查找。
若 `nums[m] > nums[r]`，说明最小值在 m 的右边，否则说明最小值在 m 的左边（包括 m）。

### **Java**
```java
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
```


# [155. 最小栈](https://leetcode-cn.com/problems/min-stack)
## 题目描述

<p>设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。</p>
<ul>
	<li>push(x)&nbsp;-- 将元素 x 推入栈中。</li>
	<li>pop()&nbsp;-- 删除栈顶的元素。</li>
	<li>top()&nbsp;-- 获取栈顶元素。</li>
	<li>getMin() -- 检索栈中的最小元素。</li>
</ul>
<p><strong>示例:</strong></p>
<pre>MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --&gt; 返回 -3.
minStack.pop();
minStack.top();      --&gt; 返回 0.
minStack.getMin();   --&gt; 返回 -2.
</pre>


## 解法

### **Java**
```java
class MinStack {
    private Deque<Integer> s;
    private Deque<Integer> helper;
    /** initialize your data structure here. */
    public MinStack() {
        s = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }
    public void push(int x) {
        s.push(x);
        int element = helper.isEmpty() || x < helper.peek() ? x : helper.peek();
        helper.push(element);
    }
    public void pop() {
        s.pop();
        helper.pop();
    }
    public int top() {
        return s.peek();
    }
    public int getMin() {
        return helper.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

# [160. 相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists)
## 题目描述

<p>编写一个程序，找到两个单链表相交的起始节点。</p>
<p>如下面的两个链表<strong>：</strong></p>
![\[外链图片转存失败,源](https://img-blog.csdnimg.cn/2021022422170395.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>在节点 c1 开始相交。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221715285.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
<strong>输出：</strong>Reference of the node with value = 8
<strong>输入解释：</strong>相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
</pre>

<p>&nbsp;</p>
<p><strong>示例&nbsp;2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221724839.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>intersectVal&nbsp;= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>输出：</strong>Reference of the node with value = 2
<strong>输入解释：</strong>相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
</pre>

<p>&nbsp;</p>
<p><strong>示例&nbsp;3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221749247.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>输出：</strong>null
<strong>输入解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
<strong>解释：</strong>这两个链表不相交，因此返回 null。
</pre>

<p>&nbsp;</p>
<p><strong>注意：</strong></p>
<ul>
	<li>如果两个链表没有交点，返回 <code>null</code>.</li>
	<li>在返回结果后，两个链表仍须保持原有的结构。</li>
	<li>可假定整个链表结构中没有循环。</li>
	<li>程序尽量满足 O(<em>n</em>) 时间复杂度，且仅用 O(<em>1</em>) 内存。</li>
</ul>

## 解法
定义两个指针，遍历时，当两个指针到达末尾的节点指向另一个链表的头部继续遍历，最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)。
两个指针等于移动了相同的距离，有交点就返回，无交点就是各走了两条指针的长度。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
```

# [162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element)
## 题目描述

<p>峰值元素是指其值大于左右相邻值的元素。</p>
<p>给定一个输入数组&nbsp;<code>nums</code>，其中 <code>nums[i] &ne; nums[i+1]</code>，找到峰值元素并返回其索引。</p>
<p>数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。</p>
<p>你可以假设&nbsp;<code>nums[-1] = nums[n] = -&infin;</code>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <strong>nums</strong> = <code>[1,2,3,1]</code>
<strong>输出:</strong> 2
<strong>解释: </strong>3 是峰值元素，你的函数应该返回其索引 2。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <strong>nums</strong> = <code>[</code>1,2,1,3,5,6,4]
<strong>输出:</strong> 1 或 5 
<strong>解释:</strong> 你的函数可以返回索引 1，其峰值元素为 2；
&nbsp;    或者返回索引 5， 其峰值元素为 6。
</pre>

<p><strong>说明:</strong></p>
<p>你的解法应该是&nbsp;<em>O</em>(<em>logN</em>)<em>&nbsp;</em>时间复杂度的。</p>

## 解法

### **Java**
```java
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
```


# [165. 比较版本号](https://leetcode-cn.com/problems/compare-version-numbers)
## 题目描述

<p>比较两个版本号 <em>version1&nbsp;</em>和 <em>version2</em>。<br>
如果&nbsp;<code><em>version1&nbsp;</em>&gt;&nbsp;<em>version2</em></code>&nbsp;返回&nbsp;<code>1</code>，如果&nbsp;<code><em>version1&nbsp;</em>&lt;&nbsp;<em>version2</em></code> 返回 <code>-1</code>， 除此之外返回 <code>0</code>。</p>
<p>你可以假设版本字符串非空，并且只包含数字和&nbsp;<code>.</code> 字符。</p>
<p>&nbsp;<code>.</code> 字符不代表小数点，而是用于分隔数字序列。</p>
<p>例如，<code>2.5</code> 不是&ldquo;两个半&rdquo;，也不是&ldquo;差一半到三&rdquo;，而是第二版中的第五个小版本。</p>
<p>你可以假设版本号的每一级的默认修订版号为 <code>0</code>。例如，版本号 <code>3.4</code> 的第一级（大版本）和第二级（小版本）修订号分别为 <code>3</code> 和 <code>4</code>。其第三级和第四级修订号均为 <code>0</code>。<br>
&nbsp;</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> <code><em>version1</em></code> = &quot;0.1&quot;, <code><em>version2</em></code> = &quot;1.1&quot;
<strong>输出:</strong> -1</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong><code><em>version1</em></code> = &quot;1.0.1&quot;, <code><em>version2</em></code> = &quot;1&quot;
<strong>输出:</strong> 1</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> <code><em>version1</em></code> = &quot;7.5.2.4&quot;, <code><em>version2</em></code> = &quot;7.5.3&quot;
<strong>输出:</strong> -1</pre>

<p><strong>示例&nbsp;4：</strong></p>
<pre><code><strong>输入：</strong><em>version1</em></code> = &quot;1.01&quot;, <code><em>version2</em></code> = &quot;1.001&quot;
<strong>输出：</strong>0
<strong>解释：</strong>忽略前导零，&ldquo;01&rdquo; 和 &ldquo;001&rdquo; 表示相同的数字 &ldquo;1&rdquo;。</pre>

<p><strong>示例 5：</strong></p>
<pre><code><strong>输入：</strong><em>version1</em></code> = &quot;1.0&quot;, <code><em>version2</em></code> = &quot;1.0.0&quot;
<strong>输出：</strong>0
<strong>解释：</strong><code><em>version1 </em></code>没有第三级修订号，这意味着它的第三级修订号默认为 &ldquo;0&rdquo;。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>版本字符串由以点&nbsp;（<code>.</code>）&nbsp;分隔的数字字符串组成。这个数字字符串<strong>可能</strong>有前导零。</li>
	<li>版本字符串不以点开始或结束，并且其中不会有两个连续的点。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) return 0;
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        for (int i = 0,j = 0;i < v1.length || j < v2.length;i++,j++){
            int ver1 = 0, ver2 = 0;
            for (;i<v1.length && v1[i]!='.';i++) ver1 = ver1 * 10 + v1[i] - '0';
            for (;j<v2.length && v2[j]!='.';j++) ver2 = ver2 * 10 + v2[j] - '0';
            if(ver1 < ver2) return -1;
            else if(ver1 > ver2) return 1;
        }
        return 0;
    }
}
```

# [166. 分数到小数](https://leetcode-cn.com/problems/fraction-to-recurring-decimal)
## 题目描述

<p>给定两个整数，分别表示分数的分子&nbsp;numerator 和分母 denominator，以字符串形式返回小数。</p>
<p>如果小数部分为循环小数，则将循环的部分括在括号内。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> numerator = 1, denominator = 2
<strong>输出:</strong> &quot;0.5&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> numerator = 2, denominator = 1
<strong>输出:</strong> &quot;2&quot;</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> numerator = 2, denominator = 3
<strong>输出: </strong>&quot;0.(6)&quot;
</pre>


## 解法

### **Java**
```java
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean minus = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;
        HashMap<Long, Integer> remains = new HashMap<>(16);
        List<Long> resList = new ArrayList<>();
        long n;
        if(numerator > 0) n = numerator;
        else if(numerator > Integer.MIN_VALUE) n = -numerator;
        else n = Integer.MAX_VALUE + 1L;
        long d;
        if(denominator > 0) d = denominator;
        else if(denominator > Integer.MIN_VALUE) d = -denominator;
        else d = Integer.MAX_VALUE + 1L;
        long r = n % d;
        int index = 0 , loopPos = -1;
        while(r != 0){
            if(remains.containsKey(r)){
                loopPos = remains.get(r);
                break;
            }
            remains.put(r, ++index);
            resList.add(Math.abs(n / d));
            n = r;
            n *= 10;
            r = n % d;
        }
        resList.add(Math.abs(n / d));
        StringBuilder res = new StringBuilder();
        if(minus) res.append("-");
        for(int i = 0; i < resList.size(); i++){
            if(i == 1) res.append(".");
            if(loopPos == i) res.append("(");
            res.append(resList.get(i));
        }
        if(loopPos != -1) res.append(")");
        return res.toString();
    }
}
```

# [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted)
## 题目描述

<p>给定一个已按照<strong><em>升序排列</em>&nbsp;</strong>的有序数组，找到两个数使得它们相加之和等于目标数。</p>
<p>函数应该返回这两个下标值<em> </em>index1 和 index2，其中 index1&nbsp;必须小于&nbsp;index2<em>。</em></p>
<p><strong>说明:</strong></p>
<ul>
	<li>返回的下标值（index1 和 index2）不是从零开始的。</li>
	<li>你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。</li>
</ul>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> numbers = [2, 7, 11, 15], target = 9
<strong>输出:</strong> [1,2]
<strong>解释:</strong> 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。</pre>


## 解法

### **Java**
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while(numbers[l]+numbers[r] != target) {
            while(numbers[l] + numbers[r] > target) r --;
            while(numbers[l] + numbers[r] < target) l ++;
        }
        return new int[] {l + 1, r + 1};
    }
}
```

# [168. Excel 表列名称](https://leetcode-cn.com/problems/excel-sheet-column-title)
## 题目描述

<p>给定一个正整数，返回它在 Excel 表中相对应的列名称。</p>
<p>例如，</p>
<pre>    1 -&gt; A
    2 -&gt; B
    3 -&gt; C
    ...
    26 -&gt; Z
    27 -&gt; AA
    28 -&gt; AB 
    ...
</pre>

<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 1
<strong>输出:</strong> &quot;A&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 28
<strong>输出:</strong> &quot;AB&quot;
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> 701
<strong>输出:</strong> &quot;ZY&quot;
</pre>


## 解法

### **Java**
```java
class Solution {
    public String convertToTitle(int n) {
        if (n < 0) {
            return "";
        }        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int temp = n % 26;
            sb.insert(0,(char)(temp + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
```

# [169. 多数元素](https://leetcode-cn.com/problems/majority-element)
## 题目描述

<p>给定一个大小为 <em>n </em>的数组，找到其中的多数元素。多数元素是指在数组中出现次数<strong>大于</strong>&nbsp;<code>&lfloor; n/2 &rfloor;</code>&nbsp;的元素。</p>
<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [3,2,3]
<strong>输出:</strong> 3</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [2,2,1,1,1,2,2]
<strong>输出:</strong> 2
</pre>


## 解法

### **Java**
```java
class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1; i<nums.length; i++){
            if(res==nums[i])
                count++;
            else{
                count--;
                if(count==0)
                    res=nums[i+1];
            }
        }
        return res;
    }
}
```

# [171. Excel 表列序号](https://leetcode-cn.com/problems/excel-sheet-column-number)
## 题目描述

<p>给定一个Excel表格中的列名称，返回其相应的列序号。</p>
<p>例如，</p>
<pre>    A -&gt; 1
    B -&gt; 2
    C -&gt; 3
    ...
    Z -&gt; 26
    AA -&gt; 27
    AB -&gt; 28 
    ...
</pre>

<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;A&quot;
<strong>输出:</strong> 1
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong>&quot;AB&quot;
<strong>输出:</strong> 28
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入: </strong>&quot;ZY&quot;
<strong>输出:</strong> 701</pre>

<p><strong>致谢：</strong><br>
特别感谢&nbsp;<a href="http://leetcode.com/discuss/user/ts">@ts</a>&nbsp;添加此问题并创建所有测试用例。</p>

## 解法

### **Java**
```java
class Solution {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int n = 0;
        int p = 1;
        for (int i = cs.length-1; i >= 0; i--) {
            n += (cs[i]-'A'+1)*p;
            p *= 26;
        }
        return n;
    }
}
```

# [172. 阶乘后的零](https://leetcode-cn.com/problems/factorial-trailing-zeroes)
## 题目描述

<p>给定一个整数 <em>n</em>，返回 <em>n</em>! 结果尾数中零的数量。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 3
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;3! = 6, 尾数中没有零。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 5
<strong>输出:</strong> 1
<strong>解释:</strong>&nbsp;5! = 120, 尾数中有 1 个零.</pre>

<p><strong>说明: </strong>你算法的时间复杂度应为&nbsp;<em>O</em>(log&nbsp;<em>n</em>)<em>&nbsp;</em>。</p>

## 解法

### **Java**
```java
class Solution {
    public int trailingZeroes(int n) {
        int t = 0;
        while (n >= 5) {
            t += n / 5;
            n /= 5;
        }
        return t;
    }
}
```

# [173. 二叉搜索树迭代器](https://leetcode-cn.com/problems/binary-search-tree-iterator)
## 题目描述

<p>实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。</p>
<p>调用 <code>next()</code> 将返回二叉搜索树中的下一个最小的数。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224221805461.png)
<pre>BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>next()</code>&nbsp;和&nbsp;<code>hasNext()</code>&nbsp;操作的时间复杂度是&nbsp;O(1)，并使用&nbsp;O(<em>h</em>) 内存，其中&nbsp;<em>h&nbsp;</em>是树的高度。</li>
	<li>你可以假设&nbsp;<code>next()</code>&nbsp;调用总是有效的，也就是说，当调用 <code>next()</code>&nbsp;时，BST 中至少存在一个下一个最小的数。</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Stack<TreeNode> vector = new Stack<>();
    TreeNode current;
    public BSTIterator(TreeNode root) {
        current = root;
        // 一直放入左儿子（左）
        while (current != null) {
            vector.push(current);
            current = current.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !vector.isEmpty() || current != null;
    }
    /** @return the next smallest number */
    public int next() {
        // 一直放入左儿子（左）
        while (current != null) {
            vector.push(current);
            current = current.left;
        }
        int ans = 0;
        // 访问当前元素（中），把右儿子入栈（右）
        if (!vector.isEmpty()) {
            current = vector.pop();
            ans = current.val;
            current = current.right;
        }
        return ans;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
```


# [179. 最大数](https://leetcode-cn.com/problems/largest-number)
## 题目描述

<p>给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>[10,2]</code>
<strong>输出:</strong> <code>210</code></pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <code>[3,30,34,5,9]</code>
<strong>输出:</strong> <code>9534330</code></pre>

<p><strong>说明: </strong>输出结果可能非常大，所以你需要返回一个字符串而不是整数。</p>

## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = nums[i] + "";
		}
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String x, String y) {
				return (y + x).compareTo(x + y);
			}
		});
		if ("0".equals(strs[0])) {
			return "0";
		}
		return String.join("", strs);
	}
}
```

# [187. 重复的 DNA 序列](https://leetcode-cn.com/problems/repeated-dna-sequences)
## 题目描述

<p>所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：&ldquo;ACGAATTCCG&rdquo;。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。</p>
<p>编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>s = &quot;AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT&quot;
<strong>输出：</strong>[&quot;AAAAACCCCC&quot;, &quot;CCCCCAAAAA&quot;]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); ++i) {
            String sub = s.substring(i - 10, i);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
```


# [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array)
## 题目描述

<p>给定一个数组，将数组中的元素向右移动&nbsp;<em>k&nbsp;</em>个位置，其中&nbsp;<em>k&nbsp;</em>是非负数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>[1,2,3,4,5,6,7]</code> 和 <em>k</em> = 3
<strong>输出:</strong> <code>[5,6,7,1,2,3,4]</code>
<strong>解释:</strong>
向右旋转 1 步: <code>[7,1,2,3,4,5,6]</code>
向右旋转 2 步: <code>[6,7,1,2,3,4,5]
</code>向右旋转 3 步: <code>[5,6,7,1,2,3,4]</code>
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <code>[-1,-100,3,99]</code> 和 <em>k</em> = 2
<strong>输出:</strong> [3,99,-1,-100]
<strong>解释:</strong> 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。</li>
	<li>要求使用空间复杂度为&nbsp;O(1) 的&nbsp;<strong>原地&nbsp;</strong>算法。</li>
</ul>

## 解法
若 `k=3`，`nums=[1,2,3,4,5,6,7]`。
先将 `nums` 整体翻转：`[1,2,3,4,5,6,7]` -> `[7,6,5,4,3,2,1]`
再翻转 `0~k-1` 范围内的元素：`[7,6,5,4,3,2,1]` -> `[5,6,7,4,3,2,1]`
最后翻转 `k~n-1` 范围内的元素，即可得到最终结果：`[5,6,7,4,3,2,1]` -> `[5,6,7,1,2,3,4]`

### **Java**
```java
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        k %= n;
        if (n < 2 || k == 0) {
            return;
        }
        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
    }
    private void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            ++i;
            --j;
        }
    }
}
```

# [190. 颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits)
## 题目描述

<p>颠倒给定的 32 位无符号整数的二进制位。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> 00000010100101000001111010011100
<strong>输出:</strong> 00111001011110000010100101000000
<strong>解释: </strong>输入的二进制串 <strong>00000010100101000001111010011100 </strong>表示无符号整数<strong> 43261596</strong><strong>，
</strong>      因此返回 964176192，其二进制表示形式为 <strong>00111001011110000010100101000000</strong>。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>11111111111111111111111111111101
<strong>输出：</strong>10111111111111111111111111111111
<strong>解释：</strong>输入的二进制串 <strong>11111111111111111111111111111101</strong> 表示无符号整数 4294967293，
&nbsp;     因此返回 3221225471 其二进制表示形式为 <strong>10101111110010110010011101101001。</strong></pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。</li>
	<li>在 Java 中，编译器使用<a href="https://baike.baidu.com/item/二进制补码/5295284" target="_blank">二进制补码</a>记法来表示有符号整数。因此，在上面的&nbsp;<strong>示例 2</strong>&nbsp;中，输入表示有符号整数 <code>-3</code>，输出表示有符号整数 <code>-1073741825</code>。</li>
</ul>
<p>&nbsp;</p>
<p><strong>进阶</strong>:<br>
如果多次调用这个函数，你将如何优化你的算法？</p>

## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 31; i++, n>>=1, res<<=1) {
            res |= (n&1);
        }
        res |= (n&1);
        return res;
    }
}
```

# [191. 位 1 的个数](https://leetcode-cn.com/problems/number-of-1-bits)
## 题目描述

<p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 &lsquo;1&rsquo;&nbsp;的个数（也被称为<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F" target="_blank">汉明重量</a>）。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>00000000000000000000000000001011
<strong>输出：</strong>3
<strong>解释：</strong>输入的二进制串 <code><strong>00000000000000000000000000001011</strong>&nbsp;中，共有三位为 &#39;1&#39;。</code>
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>00000000000000000000000010000000
<strong>输出：</strong>1
<strong>解释：</strong>输入的二进制串 <strong>00000000000000000000000010000000</strong>&nbsp;中，共有一位为 &#39;1&#39;。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>11111111111111111111111111111101
<strong>输出：</strong>31
<strong>解释：</strong>输入的二进制串 <strong>11111111111111111111111111111101</strong> 中，共有 31 位为 &#39;1&#39;。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。</li>
	<li>在 Java 中，编译器使用<a href="https://baike.baidu.com/item/二进制补码/5295284" target="_blank">二进制补码</a>记法来表示有符号整数。因此，在上面的&nbsp;<strong>示例 3</strong>&nbsp;中，输入表示有符号整数 <code>-3</code>。</li>
</ul>
<p>&nbsp;</p>
<p><strong>进阶</strong>:<br>
如果多次调用这个函数，你将如何优化你的算法？</p>

## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
```

# [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber)
## 题目描述

<p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong>。</p>
<p>给定一个代表每个房屋存放金额的非负整数数组，计算你<strong>在不触动警报装置的情况下，</strong>能够偷窃到的最高金额。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [1,2,3,1]
<strong>输出:</strong> 4
<strong>解释:</strong> 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [2,7,9,3,1]
<strong>输出:</strong> 12
<strong>解释:</strong> 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
&nbsp;    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int rob(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int t = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}
```

# [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view)
## 题目描述

<p>给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>&nbsp;[1,2,3,null,5,null,4]
<strong>输出:</strong>&nbsp;[1, 3, 4]
<strong>解释:
</strong>
   1            &lt;---
 /   \
2     3         &lt;---
 \     \
  5     4       &lt;---
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans, 0);
        return ans;
    }
    private void robot(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(root.val);
        }
        ans.set(level, root.val);
        robot(root.left, ans, level + 1);
        robot(root.right, ans, level + 1);
    }
}
```

# [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands)
## 题目描述

<p>给定一个由&nbsp;<code>&#39;1&#39;</code>（陆地）和 <code>&#39;0&#39;</code>（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>
11110
11010
11000
00000
<strong>输出:</strong>&nbsp;1
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
11000
11000
00100
00011
<strong>输出: </strong>3
</pre>


## 解法

### **Java**
```java
class Solution {
    public int numIslands(char[][] grid) {
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    islandNum ++;
                }
            }
        }
        return islandNum;
    }
    public void infect(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }
}
```

# [201. 数字范围按位与](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range)
## 题目描述

<p>给定范围 [m, n]，其中 0 &lt;= m &lt;= n &lt;= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。</p>
<p><strong>示例 1:&nbsp;</strong></p>
<pre><strong>输入:</strong> [5,7]
<strong>输出:</strong> 4</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [0,1]
<strong>输出:</strong> 0</pre>


## 解法

### **Java**
```java
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
```

# [202. 快乐数](https://leetcode-cn.com/problems/happy-number)
## 题目描述

<p>编写一个算法来判断一个数是不是&ldquo;快乐数&rdquo;。</p>
<p>一个&ldquo;快乐数&rdquo;定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。</p>
<p><strong>示例:&nbsp;</strong></p>
<pre><strong>输入:</strong> 19
<strong>输出:</strong> true
<strong>解释: 
</strong>1<sup>2</sup> + 9<sup>2</sup> = 82
8<sup>2</sup> + 2<sup>2</sup> = 68
6<sup>2</sup> + 8<sup>2</sup> = 100
1<sup>2</sup> + 0<sup>2</sup> + 0<sup>2</sup> = 1
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n) {
        int s = 0;
        while (n > 0) {
            int digit = n % 10;
            s += digit * digit;
            n /= 10;
        }
        return s;
    }
}
```

# [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements)
## 题目描述

<p>删除链表中等于给定值&nbsp;<strong><em>val&nbsp;</em></strong>的所有节点。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;6-&gt;3-&gt;4-&gt;5-&gt;6, <em><strong>val</strong></em> = 6
<strong>输出:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5
</pre>


## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (pre != null && pre.next != null) {
            if (pre.next.val != val) pre = pre.next;
            else pre.next = pre.next.next;
        }
        return dummy.next;
    }
}
```

# [204. 计数质数](https://leetcode-cn.com/problems/count-primes)
## 题目描述

<p>统计所有小于非负整数&nbsp;<em>n&nbsp;</em>的质数的数量。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 10
<strong>输出:</strong> 4
<strong>解释:</strong> 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
</pre>


## 解法
如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数，因此我们可以从这里入手。
我们设 `primes[i]` 表示数 i 是不是质数，如果是质数则为 true，否则为 false。从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 false，这样在运行结束的时候我们即能知道质数的个数。
对于一个质数 x，我们从 2x 开始标记其实是冗余的，应该直接从 x⋅x 开始标记，因为 2x,3x,… 这些数一定在 x 之前就被其他数的倍数标记过了，例如 2 的所有倍数，3 的所有倍数等。

### **Java**
```java
class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (primes[i]) {
                ++res;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
        return res;
    }
}
```

# [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings)
## 题目描述

<p>给定两个字符串&nbsp;<em><strong>s&nbsp;</strong></em>和&nbsp;<strong><em>t</em></strong>，判断它们是否是同构的。</p>
<p>如果&nbsp;<em><strong>s&nbsp;</strong></em>中的字符可以被替换得到&nbsp;<strong><em>t&nbsp;</em></strong>，那么这两个字符串是同构的。</p>
<p>所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;egg&quot;, </code><strong><em>t = </em></strong><code>&quot;add&quot;</code>
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;foo&quot;, </code><strong><em>t = </em></strong><code>&quot;bar&quot;</code>
<strong>输出:</strong> false</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> <strong><em>s</em></strong> = <code>&quot;paper&quot;, </code><strong><em>t = </em></strong><code>&quot;title&quot;</code>
<strong>输出:</strong> true</pre>

<p><strong>说明:</strong><br>
你可以假设&nbsp;<em><strong>s&nbsp;</strong></em>和 <strong><em>t </em></strong>具有相同的长度。</p>

## 解法

### **Java**
```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> a2b = new HashMap<>();
        Map<Character, Character> b2a = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);
            if ((a2b.containsKey(a) && a2b.get(a) != b) || (b2a.containsKey(b) && b2a.get(b) != a)) return false;
            a2b.put(a, b);
            b2a.put(b, a);
        }
        return true;
    }
}
```

# [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list)
## 题目描述

<p>反转一个单链表。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
<strong>输出:</strong> 5-&gt;4-&gt;3-&gt;2-&gt;1-&gt;NULL</pre>

<p><strong>进阶:</strong><br>
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？</p>

## 解法
定义指针 `p`、`q` 分别指向头节点和下一个节点，`pre` 指向头节点的前一个节点。
遍历链表，改变指针 `p` 指向的节点的指向，将其指向 `pre` 指针指向的节点，即 `p.next = pre`。然后 `pre` 指针指向 `p`，`p`、`q` 指针往前走。
当遍历结束后，返回 `pre` 指针即可。

### **Java**
迭代版本：
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        return pre;
    }
}
```
递归版本：
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
```
# [207. 课程表](https://leetcode-cn.com/problems/course-schedule)
## 题目描述

<p>你这个学期必须选修 <code>numCourse</code> 门课程，记为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>numCourse-1</code> 。</p>
<p>在选修某些课程之前需要一些先修课程。&nbsp;例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：<code>[0,1]</code></p>
<p>给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 2, [[1,0]] 
<strong>输出: </strong>true
<strong>解释:</strong>&nbsp;总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 2, [[1,0],[0,1]]
<strong>输出: </strong>false
<strong>解释:</strong>&nbsp;总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>输入的先决条件是由 <strong>边缘列表</strong> 表示的图形，而不是 邻接矩阵 。详情请参见<a href="http://blog.csdn.net/woaidapaopao/article/details/51732947" target="_blank">图的表示法</a>。</li>
	<li>你可以假定输入的先决条件中没有重复的边。</li>
	<li><code>1 &lt;=&nbsp;numCourses &lt;= 10^5</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] g = new int[numCourses][numCourses];
        for (int[] e : prerequisites) {
            int cur = e[0];
            int pre = e[1];
            if (g[pre][cur] == 0) {
                ++indegree[cur];
                g[pre][cur] = 1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ++cnt;
            for (int j = 0; j < numCourses; ++j) {
                if (g[i][j] == 1) {
                    g[i][j] = 0;
                    --indegree[j];
                    if (indegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}
```

# [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree)
## 题目描述

<p>实现一个 Trie (前缀树)，包含&nbsp;<code>insert</code>,&nbsp;<code>search</code>, 和&nbsp;<code>startsWith</code>&nbsp;这三个操作。</p>
<p><strong>示例:</strong></p>
<pre>Trie trie = new Trie();
trie.insert(&quot;apple&quot;);
trie.search(&quot;apple&quot;);   // 返回 true
trie.search(&quot;app&quot;);     // 返回 false
trie.startsWith(&quot;app&quot;); // 返回 true
trie.insert(&quot;app&quot;);   
trie.search(&quot;app&quot;);     // 返回 true</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>你可以假设所有的输入都是由小写字母&nbsp;<code>a-z</code>&nbsp;构成的。</li>
	<li>保证所有输入均为非空字符串。</li>
</ul>

## 解法

### **Java**
```java
class Trie {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public TrieNode() {
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
```

# [209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum)
## 题目描述

<p>给定一个含有&nbsp;<strong>n&nbsp;</strong>个正整数的数组和一个正整数&nbsp;<strong>s ，</strong>找出该数组中满足其和<strong> &ge; s </strong>的长度最小的连续子数组<strong>。</strong>如果不存在符合条件的连续子数组，返回 0。</p>
<p><strong>示例:&nbsp;</strong></p>
<pre><strong>输入:</strong> <code>s = 7, nums = [2,3,1,2,4,3]</code>
<strong>输出:</strong> 2
<strong>解释: </strong>子数组&nbsp;<code>[4,3]</code>&nbsp;是该条件下的长度最小的连续子数组。
</pre>

<p><strong>进阶:</strong></p>
<p>如果你已经完成了<em>O</em>(<em>n</em>) 时间复杂度的解法, 请尝试&nbsp;<em>O</em>(<em>n</em> log <em>n</em>) 时间复杂度的解法。</p>

## 解法

### **Java**
```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (start < n) {
            while (end < n && sum < s) {
                sum += nums[end];
                end++;
            }
            if (sum >= s) {
                ans = Math.min(ans, end - start);
            }
            sum -= nums[start];
            start++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

# [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii)
## 题目描述

<p>现在你总共有 <em>n</em> 门课需要选，记为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n-1</code>。</p>
<p>在选修某些课程之前需要一些先修课程。&nbsp;例如，想要学习课程 0 ，你需要先完成课程&nbsp;1 ，我们用一个匹配来表示他们: <code>[0,1]</code></p>
<p>给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。</p>
<p>可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 2, [[1,0]] 
<strong>输出: </strong><code>[0,1]</code>
<strong>解释:</strong>&nbsp;总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 <code>[0,1] 。</code></pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> 4, [[1,0],[2,0],[3,1],[3,2]]
<strong>输出: </strong><code>[0,1,2,3] or [0,2,1,3]</code>
<strong>解释:</strong>&nbsp;总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
&nbsp;    因此，一个正确的课程顺序是&nbsp;<code>[0,1,2,3]</code> 。另一个正确的排序是&nbsp;<code>[0,2,1,3]</code> 。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>输入的先决条件是由<strong>边缘列表</strong>表示的图形，而不是邻接矩阵。详情请参见<a href="http://blog.csdn.net/woaidapaopao/article/details/51732947" target="_blank">图的表示法</a>。</li>
	<li>你可以假定输入的先决条件中没有重复的边。</li>
</ol>
<p><strong>提示:</strong></p>
<ol>
	<li>这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。</li>
	<li><a href="https://www.coursera.org/specializations/algorithms" target="_blank">通过 DFS 进行拓扑排序</a> - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。</li>
	<li>
	<p>拓扑排序也可以通过&nbsp;<a href="https://baike.baidu.com/item/%E5%AE%BD%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2/5224802?fr=aladdin&amp;fromid=2148012&amp;fromtitle=%E5%B9%BF%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2" target="_blank">BFS</a>&nbsp;完成。</p>
	</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
    	// key 课程id，value 前置课程id
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < pre.length; i++) {
			if (map.containsKey(pre[i][0])) {
				map.get(pre[i][0]).add(pre[i][1]);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(pre[i][1]);
				map.put(pre[i][0], set);
			}
		}
		int[] visit = new int[numCourses];
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, visit, map, ans)) {
				return new int[0];
			}
		}
		
		int[] result = new int[numCourses];
		for(int i = 0; i < numCourses; i++){
            result[i] = ans.get(i);
        }
		
		return result;
    }
	private boolean dfs(int i, int[] visit, Map<Integer, Set<Integer>> map, List<Integer> ans) {
		if (visit[i] == -1) {
			return false;
		}
		if (visit[i] == 1) {
			return true;
		}
		visit[i] = -1;
		if (map.containsKey(i)) {
			for (int pre : map.get(i)) {
				if (!dfs(pre, visit, map,ans)) {
					return false;
				}
			}
		}
		visit[i] = 1;
		ans.add(i);
		return true;
	}
}
```

# [211. 添加与搜索单词 - 数据结构设计](https://leetcode-cn.com/problems/design-add-and-search-words-data-structure)
## 题目描述

<p>如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点&ldquo;。&rdquo; 点可以与任何字母匹配的地方。</p>
<p>请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。</p>
<p>实现词典类 <code>WordDictionary</code> ：</p>
<ul>
	<li><code>WordDictionary()</code> 初始化词典对象</li>
	<li><code>void addWord(word)</code> 将 <code>word</code> 添加到数据结构中，之后可以对它进行匹配</li>
	<li><code>bool search(word)</code> 如果数据结构中存在字符串与&nbsp;<code>word</code> 匹配，则返回 <code>true</code> ；否则，返回&nbsp; <code>false</code> 。<code>word</code> 中可能包含一些 <code>&#39;.&#39;</code> ，每个&nbsp;<code>.</code> 都可以表示任何一个字母。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>
[&quot;WordDictionary&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;addWord&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;,&quot;search&quot;]
[[],[&quot;bad&quot;],[&quot;dad&quot;],[&quot;mad&quot;],[&quot;pad&quot;],[&quot;bad&quot;],[&quot;.ad&quot;],[&quot;b..&quot;]]
<strong>输出：</strong>
[null,null,null,null,false,true,true,true]
<strong>解释：</strong>
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord(&quot;bad&quot;);
wordDictionary.addWord(&quot;dad&quot;);
wordDictionary.addWord(&quot;mad&quot;);
wordDictionary.search(&quot;pad&quot;); // return False
wordDictionary.search(&quot;bad&quot;); // return True
wordDictionary.search(&quot;.ad&quot;); // return True
wordDictionary.search(&quot;b..&quot;); // return True
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= word.length &lt;= 500</code></li>
	<li><code>addWord</code> 中的 <code>word</code> 由小写英文字母组成</li>
	<li><code>search</code> 中的 <code>word</code> 由 &#39;.&#39; 或小写英文字母组成</li>
	<li>最调用多 <code>50000</code> 次 <code>addWord</code> 和 <code>search</code></li>
</ul>

## 解法

### **Java**
```java
class WordDictionary {
    class TrieNode {
        private TrieNode[] links;
        private boolean end;
        public TrieNode() {
            this.links = new TrieNode[26];
        }
        public boolean contains(char c) {
            return links[c - 'a'] != null;
        }
        public void put(char c, TrieNode trieNode) {
            links[c - 'a'] = trieNode;
        }
        public TrieNode get(char c) {
            return links[c - 'a'];
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.end = true;
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelp(word, root);
    }
    private boolean searchHelp(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ('.' == c) {
                for (int j = 0; j < node.links.length; j++) {
                    if (node.links[j] != null && searchHelp(word.substring(i + 1), node.links[j])) {
                        return true;
                    }
                }
                return false;
            }
            if (!node.contains(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node != null && node.end;
    }
}
```


# [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii)
## 题目描述

<p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都<strong>围成一圈，</strong>这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，<strong>如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警</strong>。</p>
<p>给定一个代表每个房屋存放金额的非负整数数组，计算你<strong>在不触动警报装置的情况下，</strong>能够偷窃到的最高金额。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [2,3,2]
<strong>输出:</strong> 3
<strong>解释:</strong> 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [1,2,3,1]
<strong>输出:</strong> 4
<strong>解释:</strong> 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
&nbsp;    偷窃到的最高金额 = 1 + 3 = 4 。</pre>


## 解法
环状排列意味着第一个房屋和最后一个房屋中最多只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房屋子问题。
- 不偷第一个房屋（那么最后一个房屋能偷），即求：`_rob(nums[1:])`
- 偷第一个房屋（那么最后一个房屋不能偷），即求：`_rob(nums[:-1])`
  即 `res = max(_rob(nums[1:]), _rob(nums[:-1]))`

### **Java**
```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sub1 = robInternal(Arrays.copyOfRange(nums, 0, n - 1));
        int sub2 = robInternal(Arrays.copyOfRange(nums, 1, n));
        return Math.max(sub1, sub2);
    }
    private int robInternal(int[] nums) {
        int n;
        if ((n = nums.length) == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int t = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}
```


# [215. 数组中的第 K 个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array)
## 题目描述

<p>在未排序的数组中找到第 <strong>k</strong> 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>[3,2,1,5,6,4] 和</code> k = 2
<strong>输出:</strong> 5
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6] 和</code> k = 4
<strong>输出:</strong> 4</pre>

<p><strong>说明: </strong></p>
<p>你可以假设 k 总是有效的，且 1 &le; k &le; 数组的长度。</p>

## 解法

### **Java**
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int findKthLargest(int[] nums, int l, int r, int k) {
        int i = l, j = r;
        int temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = temp;
        if (i == k) {
            return nums[i];
        } else if (i < k) {
            return findKthLargest(nums, i + 1, r, k);
        } else {
            return findKthLargest(nums, l, i - 1, k);
        }
    }
}
```

# [216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii)
## 题目描述

<p>找出所有相加之和为&nbsp;<em><strong>n</strong> </em>的&nbsp;<strong><em>k&nbsp;</em></strong>个数的组合<strong><em>。</em></strong>组合中只允许含有 1 -&nbsp;9 的正整数，并且每种组合中不存在重复的数字。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>所有数字都是正整数。</li>
	<li>解集不能包含重复的组合。&nbsp;</li>
</ul>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 7
<strong>输出:</strong> [[1,2,4]]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> <em><strong>k</strong></em> = 3, <em><strong>n</strong></em> = 9
<strong>输出:</strong> [[1,2,6], [1,3,5], [2,3,4]]
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();        
        robot(1, k, n, ans, new ArrayList<Integer>());
        return ans;
    }
    
    private void robot(int start, int k, int left, List<List<Integer>> ans, List<Integer> tmp) {
        if(k < 0 || left < 0) return;
        
        if(k == 0 && left == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            if(left >= i && k > 0) {
                tmp.add(i);
                robot(i + 1, k - 1, left - i, ans, tmp);
                tmp.remove(tmp.size() - 1);
            } else {
                return;
            }
        }
    }
}
```

# [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate)
## 题目描述

<p>给定一个整数数组，判断是否存在重复元素。</p>
<p>如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [1,2,3,1]
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>[1,2,3,4]
<strong>输出:</strong> false</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入: </strong>[1,1,1,3,3,4,3,2,4,2]
<strong>输出:</strong> true</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int e : nums) {
            if (set.contains(e)) return true;
            set.add(e);
        }
        return false;
    }
}
```

# [219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii)
## 题目描述

<p>给定一个整数数组和一个整数&nbsp;<em>k</em>，判断数组中是否存在两个不同的索引<em>&nbsp;i</em>&nbsp;和<em>&nbsp;j</em>，使得&nbsp;<strong>nums [i] = nums [j]</strong>，并且 <em>i</em> 和 <em>j</em>&nbsp;的差的绝对值最大为 <em>k</em>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> nums = [1,2,3,1], k<em> </em>= 3
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1
<strong>输出:</strong> true</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入: </strong>nums = [1,2,3,1,2,3], k<em> </em>=<em> </em>2
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (helper.containsKey(nums[i])) {
                int j = helper.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            helper.put(nums[i], i);
        }
        return false;
    }
}
```

# [220. 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii)
## 题目描述

<p>给定一个整数数组，判断数组中是否有两个不同的索引 <em>i</em> 和 <em>j</em>，使得&nbsp;<strong>nums [i]</strong> 和&nbsp;<strong>nums [j]</strong>&nbsp;的差的绝对值最大为 <em>t</em>，并且 <em>i</em> 和 <em>j</em> 之间的差的绝对值最大为 <em>ķ</em>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> nums = [1,2,3,1], k<em> </em>= 3, t = 0
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
<strong>输出:</strong> true</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入: </strong>nums = [1,5,9,1,5,9], k = 2, t = 3
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0 || nums == null || nums.length < 2) {
			return false;
		}
		SortedSet<Long> set = new TreeSet<Long>();
		for (int j = 0; j < nums.length; j++) {
			SortedSet<Long> subSet = set.subSet((long) nums[j] - t,
					(long) nums[j] + t + 1);
			if (!subSet.isEmpty()) {
				return true;
			}
			if (j >= k) {
				set.remove((long) nums[j - k]);
			}
			set.add((long) nums[j]);
		}
		return false;
	}
}
```

# [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square)
## 题目描述

<p>在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入: 
</strong>
1 0 1 0 0
1 0 <strong>1 1</strong> 1
1 1 <strong>1 1 </strong>1
1 0 0 1 0
<strong>输出: </strong>4</pre>


## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int mx = matrix.length;
		int my = matrix[0].length;
		int[][] dp = new int[mx][my];
		int max = 0;
		// 初始化第0行
		for (int i = 0; i < my; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
				max = 1;
			}
		}
		// 初始化第0列
		for (int i = 1; i < mx; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				max = 1;
			}
		}
		// dp[x][y]=min(dp[x-1][y],dp[x][y-1],dp[x-1][y-1])+1
		for (int x = 1; x < mx; x++) {
			for (int y = 1; y < my; y++) {
				if (matrix[x][y] == '1') {
					dp[x][y] = Math.min(Math.min(dp[x - 1][y], dp[x][y - 1]),
							dp[x - 1][y - 1]) + 1;
					max = Math.max(max, dp[x][y]);
				}
			}
		}
		return max * max;
	
        
    }
}
```

# [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes)
## 题目描述

<p>给出一个<strong>完全二叉树</strong>，求出该树的节点个数。</p>
<p><strong>说明：</strong></p>
<p><a href="https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91/7773232?fr=aladdin">完全二叉树</a>的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~&nbsp;2<sup>h</sup>&nbsp;个节点。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 
    1
   / \
  2   3
 / \  /
4  5 6
<strong>输出:</strong> 6</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
           return 0;
        } 
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
```

# [223. 矩形面积](https://leetcode-cn.com/problems/rectangle-area)
## 题目描述

<p>在<strong>二维</strong>平面上计算出两个<strong>由直线构成的</strong>矩形重叠后形成的总面积。</p>
<p>每个矩形由其左下顶点和右上顶点坐标表示，如图所示。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224223342670.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> -3, 0, 3, 4, 0, -1, 9, 2
<strong>输出:</strong> 45</pre>

<p><strong>说明:</strong> 假设矩形面积不会超出&nbsp;<strong>int&nbsp;</strong>的范围。</p>

## 解法

### **Java**
```java
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = (long) Math.min(C, G) - Math.max(A, E);
        long y = (long) Math.min(D, H) - Math.max(B, F);
        int intersection = x > 0 && y > 0 ? (int) (x * y) : 0;
        return (C - A) * (D - B) + (G - E) * (H - F) - intersection;
    }
}
```


# [225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues)
## 题目描述

<p>使用队列实现栈的下列操作：</p>
<ul>
	<li>push(x) -- 元素 x 入栈</li>
	<li>pop() -- 移除栈顶元素</li>
	<li>top() -- 获取栈顶元素</li>
	<li>empty() -- 返回栈是否为空</li>
</ul>
<p><strong>注意:</strong></p>
<ul>
	<li>你只能使用队列的基本操作-- 也就是&nbsp;<code>push to back</code>, <code>peek/pop from front</code>, <code>size</code>, 和&nbsp;<code>is empty</code>&nbsp;这些操作是合法的。</li>
	<li>你所使用的语言也许不支持队列。&nbsp;你可以使用 list 或者 deque（双端队列）来模拟一个队列&nbsp;, 只要是标准的队列操作即可。</li>
	<li>你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。</li>
</ul>

## 解法

### **Java**
```java
class MyStack {
    private Deque<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new ArrayDeque<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        q.offerLast(x);
        int n = q.size();
        while (n-- > 1) {
            q.offerLast(q.pollFirst());
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.pollFirst();
    }
    /** Get the top element. */
    public int top() {
        return q.peekFirst();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```

# [226. 翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree)
## 题目描述

<p>翻转一棵二叉树。</p>
<p><strong>示例：</strong></p>
<p>输入：</p>
<pre>     4
   /   \
  2     7
 / \   / \
1   3 6   9</pre>

<p>输出：</p>
<pre>     4
   /   \
  7     2
 / \   / \
9   6 3   1</pre>

<p><strong>备注:</strong><br>
这个问题是受到 <a href="https://twitter.com/mxcl" target="_blank">Max Howell </a>的 <a href="https://twitter.com/mxcl/status/608682016205344768" target="_blank">原问题</a> 启发的 ：</p>
<blockquote>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。</blockquote>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```

# [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii)
## 题目描述

<p>实现一个基本的计算器来计算一个简单的字符串表达式的值。</p>
<p>字符串表达式仅包含非负整数，<code>+</code>， <code>-</code> ，<code>*</code>，<code>/</code> 四种运算符和空格&nbsp;<code>&nbsp;</code>。 整数除法仅保留整数部分。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>&quot;3+2*2&quot;
<strong>输出:</strong> 7
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> &quot; 3/2 &quot;
<strong>输出:</strong> 1</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> &quot; 3+5 / 2 &quot;
<strong>输出:</strong> 5
</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>你可以假设所给定的表达式都是有效的。</li>
	<li>请<strong>不要</strong>使用内置的库函数 <code>eval</code>。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> op = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '*' || cs[i] == '/') {
                op.push(cs[i]);
            } else if (cs[i] == '+' || cs[i] == '-') {
                if (!op.isEmpty()) {
                    calc(op, num);
                }
                op.push(cs[i]);
            } else if (Character.isDigit(cs[i])) {
                int j = i;
                int k = 0;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    k = k * 10 + cs[j] - '0';
                    ++j;
                }
                i = j - 1;
                num.push(k);
                if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    calc(op, num);
                }
            }
        }
        if (!op.isEmpty()) {
            calc(op, num);
        }
        return num.peek();
    }
    private void calc(Deque<Character> op, Deque<Integer> num) {
        int y = num.pop();
        int x = num.pop();
        switch (op.pop()) {
            case '*':
                num.push(x * y);
                break;
            case '/':
                num.push(x / y);
                break;
            case '+':
                num.push(x + y);
                break;
            default:
                num.push(x - y);
                break;
        }
    }
}
```

# [228. 汇总区间](https://leetcode-cn.com/problems/summary-ranges)
## 题目描述

<p>给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [0,1,2,4,5,7]
<strong>输出:</strong> [&quot;0-&gt;2&quot;,&quot;4-&gt;5&quot;,&quot;7&quot;]
<strong>解释: </strong>0,1,2 可组成一个连续的区间;&nbsp;4,5 可组成一个连续的区间。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [0,2,3,4,6,8,9]
<strong>输出:</strong> [&quot;0&quot;,&quot;2-&gt;4&quot;,&quot;6&quot;,&quot;8-&gt;9&quot;]
<strong>解释: </strong>2,3,4 可组成一个连续的区间;&nbsp;8,9 可组成一个连续的区间。</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 1; i < nums.length; i = j++) {
            while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                ++j;
            }
            if (j - i == 1) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(nums[i] + "->" + nums[j - 1]);
            }
        }
        return res;
    }
}
```

# [229. 求众数 II](https://leetcode-cn.com/problems/majority-element-ii)
## 题目描述

<p>给定一个大小为&nbsp;<em>n&nbsp;</em>的数组，找出其中所有出现超过&nbsp;<code>&lfloor; n/3 &rfloor;</code>&nbsp;次的元素。</p>
<p><strong>说明: </strong>要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [3,2,3]
<strong>输出:</strong> [3]</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [1,1,1,3,3,2,2,2]
<strong>输出:</strong> [1,2]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] candidate = new int[2];
        int[] cnt = new int[2];
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            } else if (cnt[0] == 0) {
                candidate[0] = num;
                cnt[0] = 1;
            } else if (cnt[1] == 0) {
                candidate[1] = num;
                cnt[1] = 1;
            } else {
                --cnt[0];
                --cnt[1];
            }
        }
        Arrays.fill(cnt, 0);
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            }
        }
        List<Integer> res = new ArrayList<>();
        if (cnt[0] > nums.length / 3) {
            res.add(candidate[0]);
        }
        if (cnt[1] > nums.length / 3) {
            res.add(candidate[1]);
        }
        return res;
    }
}
```

# [230. 二叉搜索树中第 K 小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst)
## 题目描述

<p>给定一个二叉搜索树，编写一个函数&nbsp;<code>kthSmallest</code>&nbsp;来查找其中第&nbsp;<strong>k&nbsp;</strong>个最小的元素。</p>
<p><strong>说明：</strong><br>
你可以假设 k 总是有效的，1 &le; k &le; 二叉搜索树元素个数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
&nbsp;  2
<strong>输出:</strong> 1</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
<strong>输出:</strong> 3</pre>

<p><strong>进阶：</strong><br>
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化&nbsp;<code>kthSmallest</code>&nbsp;函数？</p>

## 解法

### **Java**
```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }
}
```

# [231. 2 的幂](https://leetcode-cn.com/problems/power-of-two)
## 题目描述

<p>给定一个整数，编写一个函数来判断它是否是 2 的幂次方。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 1
<strong>输出:</strong> true
<strong>解释: </strong>2<sup>0</sup>&nbsp;= 1</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 16
<strong>输出:</strong> true
<strong>解释: </strong>2<sup>4</sup>&nbsp;= 16</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> 218
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}
```

# [232. 用栈实现队列](https://leetcode-cn.com/problems/implement-queue-using-stacks)
## 题目描述

<p>使用栈实现队列的下列操作：</p>
<ul>
	<li>push(x) -- 将一个元素放入队列的尾部。</li>
	<li>pop() -- 从队列首部移除元素。</li>
	<li>peek() -- 返回队列首部的元素。</li>
	<li>empty() -- 返回队列是否为空。</li>
</ul>
<p><strong>示例:</strong></p>
<pre>MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);  
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>你只能使用标准的栈操作 -- 也就是只有&nbsp;<code>push to top</code>,&nbsp;<code>peek/pop from top</code>,&nbsp;<code>size</code>, 和&nbsp;<code>is empty</code>&nbsp;操作是合法的。</li>
	<li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li>
	<li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li>
</ul>

## 解法

### **Java**
```java
class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return s2.pop();
    }
    /** Get the front element. */
    public int peek() {
        move();
        return s2.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    /** Move elements from s1 to s2. */
    private void move() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```


# [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list)
## 题目描述

<p>请判断一个链表是否为回文链表。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2
<strong>输出:</strong> false</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;2-&gt;1
<strong>输出:</strong> true
</pre>

<p><strong>进阶：</strong><br>
你能否用&nbsp;O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>

## 解法
先用快慢指针找到链表的中点，接着反转右半部分的链表。然后同时遍历前后两段链表，若前后两段链表节点对应的值不等，说明不是回文链表，否则说明是回文链表。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
```

# [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree)
## 题目描述

<p>给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。</p>
<p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：&ldquo;对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。&rdquo;</p>
<p>例如，给定如下二叉搜索树:&nbsp; root =&nbsp;[6,2,8,0,4,7,9,null,null,3,5]</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224223403135.png)
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
<strong>输出:</strong> 6 
<strong>解释: </strong>节点 <code>2 </code>和节点 <code>8 </code>的最近公共祖先是 <code>6。</code>
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
<strong>输出:</strong> 2
<strong>解释: </strong>节点 <code>2</code> 和节点 <code>4</code> 的最近公共祖先是 <code>2</code>, 因为根据定义最近公共祖先节点可以为节点本身。</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ul>
	<li>所有节点的值都是唯一的。</li>
	<li>p、q 为不同节点且均存在于给定的二叉搜索树中。</li>
</ul>

## 解法
从上到下搜索，找到第一个值位于 `[p, q]` 之间的结点即可。既可以用迭代实现，也可以用递归实现。

### **Java**
迭代：
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            else if (root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
        return root;
    }
}
```
递归：
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
```
# [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree)
## 题目描述

<p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>
<p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：&ldquo;对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。&rdquo;</p>
<p>例如，给定如下二叉树:&nbsp; root =&nbsp;[3,5,1,6,2,0,8,null,null,7,4]</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022422342342.png)
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>输出:</strong> 3
<strong>解释: </strong>节点 <code>5 </code>和节点 <code>1 </code>的最近公共祖先是节点 <code>3。</code>
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>输出:</strong> 5
<strong>解释: </strong>节点 <code>5 </code>和节点 <code>4 </code>的最近公共祖先是节点 <code>5。</code>因为根据定义最近公共祖先节点可以为节点本身。
</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ul>
	<li>所有节点的值都是唯一的。</li>
	<li>p、q 为不同节点且均存在于给定的二叉树中。</li>
</ul>

## 解法
根据“**最近公共祖先**”的定义，若 root 是 p, q 的最近公共祖先 ，则只可能为以下情况之一：
- 如果 p 和 q 分别是 root 的左右节点，那么 root 就是我们要找的最近公共祖先；
- 如果 p 和 q 都是 root 的左节点，那么返回 `lowestCommonAncestor(root.left, p, q)`；
- 如果 p 和 q 都是 root 的右节点，那么返回 `lowestCommonAncestor(root.right, p, q)`。
  **边界条件讨论**：
- 如果 root 为 null，则说明我们已经找到最底了，返回 null 表示没找到；
- 如果 root 与 p 相等或者与 q 相等，则返回 root；
- 如果左子树没找到，递归函数返回 null，证明 p 和 q 同在 root 的右侧，那么最终的公共祖先就是右子树找到的结点；
- 如果右子树没找到，递归函数返回 null，证明 p 和 q 同在 root 的左侧，那么最终的公共祖先就是左子树找到的结点。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
```
# [237. 删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)
## 题目描述

<p>请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。</p>
<p>现有一个链表 --&nbsp;head =&nbsp;[4,5,1,9]，它可以表示为:</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224223447303.png)
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> head = [4,5,1,9], node = 5
<strong>输出:</strong> [4,1,9]
<strong>解释: </strong>给定你链表中值为&nbsp;5&nbsp;的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 1 -&gt; 9.
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> head = [4,5,1,9], node = 1
<strong>输出:</strong> [4,5,9]
<strong>解释: </strong>给定你链表中值为&nbsp;1&nbsp;的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -&gt; 5 -&gt; 9.
</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ul>
	<li>链表至少包含两个节点。</li>
	<li>链表中所有节点的值都是唯一的。</li>
	<li>给定的节点为非末尾节点并且一定是链表中的一个有效节点。</li>
	<li>不要从你的函数中返回任何结果。</li>
</ul>

## 解法
将 `node.next` 节点的值赋给 `node`，然后将 `node.next` 指向 `node.next` 的下一个节点。

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
# [238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self)
## 题目描述

<p>给你一个长度为&nbsp;<em>n</em>&nbsp;的整数数组&nbsp;<code>nums</code>，其中&nbsp;<em>n</em> &gt; 1，返回输出数组&nbsp;<code>output</code>&nbsp;，其中 <code>output[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;<code>nums[i]</code>&nbsp;之外其余各元素的乘积。</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>[1,2,3,4]</code>
<strong>输出:</strong> <code>[24,12,8,6]</code></pre>

<p>&nbsp;</p>
<p><strong>提示：</strong>题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。</p>
<p><strong>说明: </strong>请<strong>不要使用除法，</strong>且在&nbsp;O(<em>n</em>) 时间复杂度内完成此题。</p>
<p><strong>进阶：</strong><br>
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组<strong>不被视为</strong>额外空间。）</p>

## 解法

### **Java**
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        for (int i = 0, left = 1; i < n; ++i) {
            output[i] = left;
            left *= nums[i];
        }
        for (int i = n - 1, right = 1; i >= 0; --i) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }
}
```

# [240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii)
## 题目描述

<p>编写一个高效的算法来搜索&nbsp;<em>m</em>&nbsp;x&nbsp;<em>n</em>&nbsp;矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：</p>
<ul>
	<li>每行的元素从左到右升序排列。</li>
	<li>每列的元素从上到下升序排列。</li>
</ul>
<p><strong>示例:</strong></p>
<p>现有矩阵 matrix 如下：</p>
<pre>[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
</pre>

<p>给定 target&nbsp;=&nbsp;<code>5</code>，返回&nbsp;<code>true</code>。</p>
<p>给定&nbsp;target&nbsp;=&nbsp;<code>20</code>，返回&nbsp;<code>false</code>。</p>

## 解法

### **Java**
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                ++j;
            } else if (matrix[i][j] > target) {
                --i;
            } else {
                return true;
            }
        }
        return false;
    }
}
```

# [241. 为运算表达式设计优先级](https://leetcode-cn.com/problems/different-ways-to-add-parentheses)
## 题目描述

<p>给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 <code>+</code>,&nbsp;<code>-</code>&nbsp;以及&nbsp;<code>*</code>&nbsp;。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> <code>&quot;2-1-1&quot;</code>
<strong>输出:</strong> <code>[0, 2]</code>
<strong>解释: </strong>
((2-1)-1) = 0 
(2-(1-1)) = 2</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong><code>&quot;2*3-4*5&quot;</code>
<strong>输出:</strong> <code>[-34, -14, -10, -10, 10]</code>
<strong>解释: 
</strong>(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10</pre>


## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
		List<Integer> rt = new LinkedList<Integer>();
		int len = input.length();
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*'
					|| input.charAt(i) == '+') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for (Integer p1 : part1Ret) {
					for (Integer p2 : part2Ret) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '*':
							c = p1 * p2;
						}
						rt.add(c);
					}
				}
			}
		}
		if (rt.size() == 0) {
			rt.add(Integer.valueOf(input));
		}
		return rt;
	
        
    }
}
```

# [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram)
## 题目描述

<p>给定两个字符串 <em>s</em> 和 <em>t</em> ，编写一个函数来判断 <em>t</em> 是否是 <em>s</em> 的字母异位词。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> <em>s</em> = &quot;anagram&quot;, <em>t</em> = &quot;nagaram&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> <em>s</em> = &quot;rat&quot;, <em>t</em> = &quot;car&quot;
<strong>输出: </strong>false</pre>

<p><strong>说明:</strong><br>
你可以假设字符串只包含小写字母。</p>
<p><strong>进阶:</strong><br>
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

## 解法

### **Java**
```java
class Solution {
	public boolean isAnagram(String s, String t) {
		char[] val1 = s.toCharArray();
		char[] val2 = t.toCharArray();
		Arrays.sort(val1);
		Arrays.sort(val2);
		String s1 = new String(val1);
		String s2 = new String(val2);
		return s1.equals(s2);
	}
}
```

# [243. 最短单词距离](https://leetcode-cn.com/problems/shortest-word-distance)
## 题目描述

<p>给定一个单词列表和两个单词 <em>word1</em> 和 <em>word2</em>，返回列表中这两个单词之间的最短距离。</p>
<p><strong>示例:</strong><br>
假设 words = <code>["practice", "makes", "perfect", "coding", "makes"]</code></p>
<pre><strong>输入:</strong> <em>word1</em> = <code>“coding”</code>, <em>word2</em> = <code>“practice”</code>
<strong>输出:</strong> 3
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>"makes"</code>, <em>word2</em> = <code>"coding"</code>
<strong>输出:</strong> 1
</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> 不等于 <em>word2</em>, 并且 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>

## 解法

### **Java**
```java
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[i], word1)) {
                w1 = i;
                if (w2 >= 0) {
                    ans = Math.min(w1 - w2, ans);
                }
            } else if (Objects.equals(words[i], word2)) {
                w2 = i;
                if (w1 >= 0) {
                    ans = Math.min(w2 - w1, ans);
                }
            }
        }
        return ans;
    }
}
```

# [244. 最短单词距离 II](https://leetcode-cn.com/problems/shortest-word-distance-ii)
## 题目描述

<p>请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 <em>word1</em> 和 <em>word2，</em>并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 <em>多次</em>。</p>
<p><strong>示例:</strong><br>
假设 words = <code>["practice", "makes", "perfect", "coding", "makes"]</code></p>
<pre><strong>输入:</strong> <em>word1</em> = <code>“coding”</code>, <em>word2</em> = <code>“practice”</code>
<strong>输出:</strong> 3
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>"makes"</code>, <em>word2</em> = <code>"coding"</code>
<strong>输出:</strong> 1</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> <strong>不等于</strong> <em>word2</em>, 并且 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>

## 解法

### **Java**
```java
class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexList = map.get(words[i]) == null ? new ArrayList<>() : map.get(words[i]);
            indexList.add(i);
            map.put(words[i], indexList);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for (int l1 : list1) {
            for (int l2 : list2) {
                ans = Math.min(ans, Math.abs(l1 - l2));
            }
        }
        return ans;
    }
}
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
```

# [245. 最短单词距离 III](https://leetcode-cn.com/problems/shortest-word-distance-iii)
## 题目描述

<p>给定一个单词列表和两个单词 <em>word1</em> 和 <em>word2</em>，返回列表中这两个单词之间的最短距离。</p>
<p><em>word1</em> 和 <em>word2</em> 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。</p>
<p><strong>示例:</strong><br>
假设 words = <code>["practice", "makes", "perfect", "coding", "makes"]</code>.</p>
<pre><strong>输入:</strong> <em>word1</em> = <code>“makes”</code>, <em>word2</em> = <code>“coding”</code>
<strong>输出:</strong> 1
</pre>

<pre><strong>输入:</strong> <em>word1</em> = <code>"makes"</code>, <em>word2</em> = <code>"makes"</code>
<strong>输出:</strong> 3
</pre>

<p><strong>注意:</strong><br>
你可以假设 <em>word1</em> 和 <em>word2</em> 都在列表里。</p>

## 解法

### **Java**
```java
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, ans = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (same) {
                if (Objects.equals(words[i], word1)) {
                    if (w1 == -1) {
                        w1 = i;
                    } else {
                        ans = Math.min(ans, i - w1);
                        w1 = i;
                    }
                }
            } else if (Objects.equals(words[i], word1)) {
                w1 = i;
                if (w2 >= 0) {
                    ans = Math.min(w1 - w2, ans);
                }
            } else if (Objects.equals(words[i], word2)) {
                w2 = i;
                if (w1 >= 0) {
                    ans = Math.min(w2 - w1, ans);
                }
            }
        }
        return ans;
    }
}
```

# [246. 中心对称数](https://leetcode-cn.com/problems/strobogrammatic-number)
## 题目描述

<p>中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>
<p>请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。</p>
<p> </p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> num = "69"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> num = "88"
<strong>输出:</strong> true</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> num = "962"
<strong>输出:</strong> false</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>num = "1"
<strong>输出：</strong>true
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        for (int i = 0, j = n - 1; i <= j; ++i, --j) {
            if (!match(num.charAt(i), num.charAt(j))) return false;
        }
        return true;
    }
    private boolean match(char a, char b) {
        switch (a) {
            case '0':
            case '1':
            case '8':
                return a == b;
            case '6':
                return b == '9';
            case '9':
                return b == '6';
            default:
                return false;
        }
    }
}
```

# [247. 中心对称数 II](https://leetcode-cn.com/problems/strobogrammatic-number-ii)
## 题目描述

<p>中心对称数是指一个数字在旋转了&nbsp;180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>
<p>找到所有长度为 n 的中心对称数。</p>
<p><strong>示例</strong> <strong>:</strong></p>
<pre><strong>输入:</strong>  n = 2
<strong>输出:</strong> <code>["11","69","88","96"]</code>
</pre>


## 解法

### **Java**
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

# [252. 会议室](https://leetcode-cn.com/problems/meeting-rooms)
## 题目描述

<p>给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 <code>[[s1,e1],[s2,e2],...]</code> (s<sub>i</sub> < e<sub>i</sub>)，请你判断一个人是否能够参加这里面的全部会议。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>[[0,30],[5,10],[15,20]]</code>
<strong>输出:</strong> false
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [[7,10],[2,4]]
<strong>输出:</strong> true
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0, n = intervals.length; i < n - 1; ++i) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
```

# [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths)
## 题目描述

<p>给定一个二叉树，返回所有从根节点到叶子节点的路径。</p>
<p><strong>说明:</strong>&nbsp;叶子节点是指没有子节点的节点。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
   1
 /   \
2     3
 \
  5
<strong>输出:</strong> [&quot;1-&gt;2-&gt;5&quot;, &quot;1-&gt;3&quot;]
<strong>解释:</strong> 所有根节点到叶子节点的路径为: 1-&gt;2-&gt;5, 1-&gt;3</pre>


## 解法
深度优先搜索+路径记录。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<String> res;
    private List<String> path;
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.emptyList();
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }
}
```

# [258. 各位相加](https://leetcode-cn.com/problems/add-digits)
## 题目描述

<p>给定一个非负整数 <code>num</code>，反复将各个位上的数字相加，直到结果为一位数。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>38</code>
<strong>输出:</strong> 2 
<strong>解释: </strong>各位相加的过程为<strong>：</strong><code>3 + 8 = 11</code>, <code>1 + 1 = 2</code>。 由于&nbsp;<code>2</code> 是一位数，所以返回 2。
</pre>

<p><strong>进阶:</strong><br>
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？</p>

## 解法
题目要求的数叫做“数根”，我们把 1~30 的数根列出来：
```
原数: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
数根: 1 2 3 4 5 6 7 8 9  1  2  3  4  5  6  7  8  9  1  2  3  4  5  6  7  8  9  1  2  3
```
可以看到，数根 9 个为一组，循环出现。我们可以得出下面的规律：
- n = 0：数根是 0
- n 是 9 的倍数：数根是 9
- n 不是 9 的倍数：数根是 n % 9
  将上面的规律用式子：`(n - 1) % 9 + 1` 统一表达。

### **Java**
```java
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
```
# [260. 只出现一次的数字 III](https://leetcode-cn.com/problems/single-number-iii)
## 题目描述

<p>给定一个整数数组&nbsp;<code>nums</code>，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。</p>
<p><strong>示例 :</strong></p>
<pre><strong>输入:</strong> <code>[1,2,1,3,2,5]</code>
<strong>输出:</strong> <code>[3,5]</code></pre>

<p><strong>注意：</strong></p>
<ol>
	<li>结果输出的顺序并不重要，对于上面的例子，&nbsp;<code>[5, 3]</code>&nbsp;也是正确答案。</li>
	<li>你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int diff = xor & (-xor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & diff) == 0) a ^= num;
            else b ^= num;
        }
        return new int[]{a, b};
    }
}
```

# [263. 丑数](https://leetcode-cn.com/problems/ugly-number)
## 题目描述

<p>编写一个程序判断给定的数是否为丑数。</p>
<p>丑数就是只包含质因数&nbsp;<code>2, 3, 5</code>&nbsp;的<strong>正整数</strong>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 6
<strong>输出:</strong> true
<strong>解释: </strong>6 = 2 &times;&nbsp;3</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 8
<strong>输出:</strong> true
<strong>解释: </strong>8 = 2 &times; 2 &times;&nbsp;2
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong> 14
<strong>输出:</strong> false 
<strong>解释: </strong><code>14</code> 不是丑数，因为它包含了另外一个质因数&nbsp;<code>7</code>。</pre>

<p><strong>说明：</strong></p>
<ol>
	<li><code>1</code>&nbsp;是丑数。</li>
	<li>输入不会超过 32 位有符号整数的范围:&nbsp;[&minus;2<sup>31</sup>,&nbsp; 2<sup>31&nbsp;</sup>&minus; 1]。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
```

# [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii)
## 题目描述

<p>编写一个程序，找出第 <code>n</code> 个丑数。</p>
<p>丑数就是只包含质因数&nbsp;<code>2, 3, 5</code> 的<strong>正整数</strong>。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> n = 10
<strong>输出:</strong> 12
<strong>解释: </strong><code>1, 2, 3, 4, 5, 6, 8, 9, 10, 12</code> 是前 10 个丑数。</pre>

<p><strong>说明:&nbsp;</strong>&nbsp;</p>
<ol>
	<li><code>1</code>&nbsp;是丑数。</li>
	<li><code>n</code>&nbsp;<strong>不超过</strong>1690。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int idx = 1; idx < n; ++idx) {
            int t = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            dp[idx] = t;
            if (dp[i] * 2 == t) ++i;
            if (dp[j] * 3 == t) ++j;
            if (dp[k] * 5 == t) ++k;
        }
        return dp[n - 1];
    }
}
```

# [266. 回文排列](https://leetcode-cn.com/problems/palindrome-permutation)
## 题目描述

<p>给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> <code>"code"</code>
<strong>输出:</strong> false</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入:</strong> <code>"aab"</code>
<strong>输出:</strong> true</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入:</strong> <code>"carerac"</code>
<strong>输出:</strong> true</pre>


## 解法
利用 HashMap（字典表）统计每个字符出现的频率，至多有一个字符出现奇数次数即可。

### **Java**
```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, n = s.length(); i < n; ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                ++cnt;
            }
        }
        return cnt <= 1;
    }
}
```

# [268. 缺失数字](https://leetcode-cn.com/problems/missing-number)
## 题目描述

<p>给定一个包含 <code>0, 1, 2, ..., n</code>&nbsp;中&nbsp;<em>n</em>&nbsp;个数的序列，找出 0 .. <em>n</em>&nbsp;中没有出现在序列中的那个数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [3,0,1]
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [9,6,4,2,3,5,7,0,1]
<strong>输出:</strong> 8
</pre>

<p><strong>说明:</strong><br>
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?</p>

## 解法
异或求解。两个相同的数异或的结果为 0。
也可以用数学求解。求出 `[0..n]` 的和，减去数组中所有数的和，就得到了缺失的数字。

### **Java**
- 异或
```java
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; ++i) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}
```
- 数学
```java
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; ++i) {
            res += (i - nums[i]);
        }
        return res;
    }
}
```


# [274. H 指数](https://leetcode-cn.com/problems/h-index)
## 题目描述

<p>给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 <em>h&nbsp;</em>指数。</p>
<p><a href="https://baike.baidu.com/item/h-index/3991452?fr=aladdin" target="_blank">h 指数的定义</a>: &ldquo;h 代表&ldquo;高引用次数&rdquo;（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）<strong>至多</strong>有 h 篇论文分别被引用了<strong>至少</strong> h 次。（其余的&nbsp;<em>N - h&nbsp;</em>篇论文每篇被引用次数<strong>不多于 </strong><em>h </em>次。）&rdquo;</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>citations = [3,0,6,1,5]</code>
<strong>输出:</strong> 3 
<strong>解释: </strong>给定数组表示研究者总共有 <code>5</code> 篇论文，每篇论文相应的被引用了 <code>3, 0, 6, 1, 5</code> 次。
&nbsp;    由于研究者有 <code>3 </code>篇论文每篇<strong>至少</strong>被引用了 <code>3</code> 次，其余两篇论文每篇被引用<strong>不多于</strong> <code>3</code> 次，所以她的 <em>h </em>指数是 <code>3</code>。</pre>

<p>&nbsp;</p>
<p><strong>说明:&nbsp;</strong>如果 <em>h </em>有多种可能的值，<em>h</em> 指数是其中最大的那个。</p>

## 解法

### **Java**
```java
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int c : citations) {
            if (c <= n) {
                ++cnt[c];
            } else {
                ++cnt[n];
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += cnt[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
```

# [275. H 指数 II](https://leetcode-cn.com/problems/h-index-ii)
## 题目描述

<p>给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照<strong>升序排列</strong>。编写一个方法，计算出研究者的 <em>h</em> 指数。</p>
<p><a href="https://baike.baidu.com/item/h-index/3991452?fr=aladdin">h 指数的定义</a>: &ldquo;h 代表&ldquo;高引用次数&rdquo;（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）<strong>至多</strong>有 h 篇论文分别被引用了<strong>至少</strong> h 次。（其余的&nbsp;<em>N - h&nbsp;</em>篇论文每篇被引用次数<strong>不多于 </strong><em>h </em>次。）&quot;</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>citations = [0,1,3,5,6]</code>
<strong>输出:</strong> 3 
<strong>解释: </strong>给定数组表示研究者总共有 <code>5</code> 篇论文，每篇论文相应的被引用了 0<code>, 1, 3, 5, 6</code> 次。
&nbsp;    由于研究者有 <code>3 </code>篇论文每篇<strong>至少</strong>被引用了 <code>3</code> 次，其余两篇论文每篇被引用<strong>不多于</strong> <code>3</code> 次，所以她的<em> h </em>指数是 <code>3</code>。</pre>

<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<p>如果 <em>h </em>有多有种可能的值 ，<em>h</em> 指数是其中最大的那个。</p>
<p>&nbsp;</p>
<p><strong>进阶：</strong></p>
<ul>
	<li>这是&nbsp;<a href="/problems/h-index/description/">H指数</a>&nbsp;的延伸题目，本题中的&nbsp;<code>citations</code>&nbsp;数组是保证有序的。</li>
	<li>你可以优化你的算法到对数时间复杂度吗？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (citations[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }
} 
```

# [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version)
## 题目描述

<p>你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。</p>
<p>假设你有 <code>n</code> 个版本 <code>[1, 2, ..., n]</code>，你想找出导致之后所有版本出错的第一个错误的版本。</p>
<p>你可以通过调用&nbsp;<code>bool isBadVersion(version)</code>&nbsp;接口来判断版本号 <code>version</code> 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。</p>
<p><strong>示例:</strong></p>
<pre>给定 n = 5，并且 version = 4 是第一个错误的版本。
<code>调用 isBadVersion(3) -&gt; false
调用 isBadVersion(5)&nbsp;-&gt; true
调用 isBadVersion(4)&nbsp;-&gt; true
所以，4 是第一个错误的版本。&nbsp;</code></pre>


## 解法
二分查找。

### **Java**
```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
```
# [279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares)
## 题目描述

<p>给定正整数&nbsp;<em>n</em>，找到若干个完全平方数（比如&nbsp;<code>1, 4, 9, 16, ...</code>）使得它们的和等于<em> n</em>。你需要让组成和的完全平方数的个数最少。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> <em>n</em> = <code>12</code>
<strong>输出:</strong> 3 
<strong>解释: </strong><code>12 = 4 + 4 + 4.</code></pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> <em>n</em> = <code>13</code>
<strong>输出:</strong> 2
<strong>解释: </strong><code>13 = 4 + 9.</code></pre>


## 解法

### **Java**
```java
class Solution {
	public int numSquares(int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(0);
		while (ans.size() <= n) {
			int m = ans.size(), val = Integer.MAX_VALUE;
			for (int i = 1; i * i <= m; i++) {
				val = Math.min(val, ans.get(m - i * i) + 1);
			}
			ans.add(val);
		}
		return ans.get(n);
	}
}
```

# [283. 移动零](https://leetcode-cn.com/problems/move-zeroes)
## 题目描述

<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>[0,1,0,3,12]</code>
<strong>输出:</strong> <code>[1,3,12,0,0]</code></pre>

<p><strong>说明</strong>:</p>
<ol>
	<li>必须在原数组上操作，不能拷贝额外的数组。</li>
	<li>尽量减少操作次数。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 1) {
            return;
        }
        int zeroCount = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                ++zeroCount;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }
        while (zeroCount > 0) {
            nums[n - zeroCount--] = 0;
        }
    }
}
```

# [284. 顶端迭代器](https://leetcode-cn.com/problems/peeking-iterator)
## 题目描述

<p>给定一个迭代器类的接口，接口包含两个方法：&nbsp;<code>next()</code>&nbsp;和&nbsp;<code>hasNext()</code>。设计并实现一个支持&nbsp;<code>peek()</code>&nbsp;操作的顶端迭代器 -- 其本质就是把原本应由&nbsp;<code>next()</code>&nbsp;方法返回的元素&nbsp;<code>peek()</code>&nbsp;出来。</p>
<p><strong>示例:</strong></p>
<pre>假设迭代器被初始化为列表&nbsp;<strong><code>[1,2,3]</code></strong>。
调用&nbsp;<strong><code>next() </code></strong>返回 <strong>1</strong>，得到列表中的第一个元素。
现在调用&nbsp;<strong><code>peek()</code></strong>&nbsp;返回 <strong>2</strong>，下一个元素。在此之后调用&nbsp;<strong><code>next() </code></strong>仍然返回 <strong>2</strong>。
最后一次调用&nbsp;<strong><code>next()</code></strong>&nbsp;返回 <strong>3</strong>，末尾元素。在此之后调用&nbsp;<strong><code>hasNext()</code></strong>&nbsp;应该返回 <strong>false</strong>。
</pre>

<p><strong>进阶：</strong>你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？</p>

## 解法

### **Java**
```java
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private boolean hasPeeked;
	private Integer peekedElement;
	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator = iterator;
	}
	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!hasPeeked) {
			peekedElement = iterator.next();
			hasPeeked = true;
		}
		return peekedElement;
	}
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		if (!hasPeeked) {
			return iterator.next();
		}
		Integer result = peekedElement;
		hasPeeked = false;
		peekedElement = null;
		return result;
	}
	public boolean hasNext() {
		return hasPeeked || iterator.hasNext();
	}
}
```

# [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number)
## 题目描述

<p>给定一个包含&nbsp;<em>n</em> + 1 个整数的数组&nbsp;<em>nums</em>，其数字都在 1 到 <em>n&nbsp;</em>之间（包括 1 和 <em>n</em>），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>[1,3,4,2,2]</code>
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [3,1,3,4,2]
<strong>输出:</strong> 3
</pre>

<p><strong>说明：</strong></p>
<ol>
	<li><strong>不能</strong>更改原数组（假设数组是只读的）。</li>
	<li>只能使用额外的 <em>O</em>(1) 的空间。</li>
	<li>时间复杂度小于 <em>O</em>(<em>n</em><sup>2</sup>) 。</li>
	<li>数组中只有一个重复的数字，但它可能不止重复出现一次。</li>
</ol>

## 解法

### **Java**
```java
public class Solution {
    // https://segmentfault.com/a/1190000003817671
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
```

# [289. 生命游戏](https://leetcode-cn.com/problems/game-of-life)
## 题目描述

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

### **Java**
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

# [290. 单词规律](https://leetcode-cn.com/problems/word-pattern)
## 题目描述

<p>给定一种规律 <code>pattern</code>&nbsp;和一个字符串&nbsp;<code>str</code>&nbsp;，判断 <code>str</code> 是否遵循相同的规律。</p>
<p>这里的&nbsp;<strong>遵循&nbsp;</strong>指完全匹配，例如，&nbsp;<code>pattern</code>&nbsp;里的每个字母和字符串&nbsp;<code>str</code><strong>&nbsp;</strong>中的每个非空单词之间存在着双向连接的对应规律。</p>
<p><strong>示例1:</strong></p>
<pre><strong>输入:</strong> pattern = <code>&quot;abba&quot;</code>, str = <code>&quot;dog cat cat dog&quot;</code>
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>pattern = <code>&quot;abba&quot;</code>, str = <code>&quot;dog cat cat fish&quot;</code>
<strong>输出:</strong> false</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> pattern = <code>&quot;aaaa&quot;</code>, str = <code>&quot;dog cat cat dog&quot;</code>
<strong>输出:</strong> false</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong> pattern = <code>&quot;abba&quot;</code>, str = <code>&quot;dog dog dog dog&quot;</code>
<strong>输出:</strong> false</pre>

<p><strong>说明:</strong><br>
你可以假设&nbsp;<code>pattern</code>&nbsp;只包含小写字母，&nbsp;<code>str</code>&nbsp;包含了由单个空格分隔的小写字母。&nbsp; &nbsp;&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2str = new HashMap<>();
        Map<String, Character> str2ch = new HashMap<>();
        String[] ss = s.split(" ");
        int n = pattern.length();
        if (n != ss.length) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            char ch = pattern.charAt(i);
            if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(ss[i])) {
                return false;
            }
            if (str2ch.containsKey(ss[i]) && !str2ch.get(ss[i]).equals(ch)) {
                return false;
            }
            ch2str.put(ch, ss[i]);
            str2ch.put(ss[i], ch);
        }
        return true;
    }
}
```

# [292. Nim 游戏](https://leetcode-cn.com/problems/nim-game)
## 题目描述

<p>你和你的朋友，两个人一起玩&nbsp;<a href="https://baike.baidu.com/item/Nim游戏/6737105" target="_blank">Nim 游戏</a>：桌子上有一堆石头，每次你们轮流拿掉&nbsp;1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。</p>
<p>你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>4</code>
<strong>输出:</strong> false 
<strong>解释: </strong>如果堆中有 4 块石头，那么你永远不会赢得比赛；
&nbsp;    因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;// n%4 != 0
    }
}
```

# [293. 翻转游戏](https://leetcode-cn.com/problems/flip-game)
## 题目描述

<p>你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 <code>+</code> 和 <code>-</code> 的字符串。你和朋友轮流将 <strong>连续 </strong>的两个 <code>"++"</code> 反转成 <code>"--"</code>。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。</p>
<p>请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。</p>
<p> </p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> <code>s = "++++"</code>
<strong>输出:</strong> 
[
  "--++",
  "+--+",
  "++--"
]
</pre>

<p><strong>注意：</strong>如果不存在可能的有效操作，请返回一个空列表 <code>[]</code>。</p>

## 解法

### **Java**
```java
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int n;
        if (s == null || (n = s.length()) < 2) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i, i + 2, "--");
                res.add(sb.toString());
            }
        }
        return res;
    }
}
```


# [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence)
## 题目描述

<p>给定一个无序的整数数组，找到其中最长上升子序列的长度。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>[10,9,2,5,3,7,101,18]
</code><strong>输出: </strong>4 
<strong>解释: </strong>最长的上升子序列是&nbsp;<code>[2,3,7,101]，</code>它的长度是 <code>4</code>。</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。</li>
	<li>你算法的时间复杂度应该为&nbsp;O(<em>n<sup>2</sup></em>) 。</li>
</ul>
<p><strong>进阶:</strong> 你能将算法的时间复杂度降低到&nbsp;O(<em>n</em> log <em>n</em>) 吗?</p>

## 解法
动态规划求解。
定义 `dp[i]` 为以 `nums[i]` 结尾的最长子序列的长度。即题目求的是 `dp[i]` （`i ∈[0, n-1]`）的最大值。
状态转移方程为：
`dp[i] = max(dp[j]) + 1`，其中 `0≤j<i` 且 `nums[j]<nums[i]`。

### **Java**
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```


# [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable)
## 题目描述

<p>给定一个整数数组 &nbsp;<em>nums</em>，求出数组从索引&nbsp;<em>i&nbsp;</em>到&nbsp;<em>j&nbsp;&nbsp;</em>(<em>i</em>&nbsp;&le;&nbsp;<em>j</em>) 范围内元素的总和，包含&nbsp;<em>i,&nbsp; j&nbsp;</em>两点。</p>
<p><strong>示例：</strong></p>
<pre>给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
sumRange(0, 2) -&gt; 1
sumRange(2, 5) -&gt; -1
sumRange(0, 5) -&gt; -3</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>你可以假设数组不可变。</li>
	<li>会多次调用&nbsp;<em>sumRange</em>&nbsp;方法。</li>
</ol>

## 解法

### **Java**
```java
class NumArray {
	private int[] nums;
	private int[] sums;
	public NumArray(int[] tmp) {
		this.nums = Arrays.copyOf(tmp, tmp.length);
		sums = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] += nums[i] + sums[i];
		}
	}
	public int sumRange(int i, int j) {
		if (i < 0 || j > nums.length || i > j) {
			return 0;
		}
		return sums[j + 1] - sums[i];
	}
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
```

# [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable)
## 题目描述

<p>给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (<em>row</em>1,&nbsp;<em>col</em>1) ，右下角为 (<em>row</em>2,&nbsp;<em>col</em>2)。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224223509772.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<small>上图子矩阵左上角&nbsp;(row1, col1) = <strong>(2, 1)</strong>&nbsp;，右下角(row2, col2) = <strong>(4, 3)，</strong>该子矩形内元素的总和为 8。</small></p>
<p><strong>示例:</strong></p>
<pre>给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -&gt; 8
sumRegion(1, 1, 2, 2) -&gt; 11
sumRegion(1, 2, 2, 4) -&gt; 12
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>你可以假设矩阵不可变。</li>
	<li>会多次调用&nbsp;<em>sumRegion&nbsp;</em>方法<em>。</em></li>
	<li>你可以假设&nbsp;<em>row</em>1 &le; <em>row</em>2 且&nbsp;<em>col</em>1 &le; <em>col</em>2。</li>
</ol>

## 解法

### **Java**
```java
public class NumMatrix {
	public long[][] sumMatrix;
	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		sumMatrix = new long[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				sumMatrix[i][j + 1] = sumMatrix[i][j] + matrix[i][j];
			}
		}
	}
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (sumMatrix == null || row1 < 0 || row2 < 0 || col1 < 0
				|| col2 < 0 || row1 >= sumMatrix.length - 1
				|| row2 >= sumMatrix.length - 1
				|| col1 >= sumMatrix[0].length - 1
				|| col2 >= sumMatrix[0].length - 1 || row1 > row2
				|| col1 > col2) {
			return Integer.MIN_VALUE;
		}
		long rt = 0;
		for (int i = row1; i <= row2; i++) {
			rt += sumMatrix[i][col2 + 1] - sumMatrix[i][col1];
		}
		return (int) rt;
	}
}
// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
```

# [306. 累加数](https://leetcode-cn.com/problems/additive-number)
## 题目描述

<p>累加数是一个字符串，组成它的数字可以形成累加序列。</p>
<p>一个有效的累加序列必须<strong>至少</strong>包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。</p>
<p>给定一个只包含数字&nbsp;<code>&#39;0&#39;-&#39;9&#39;</code>&nbsp;的字符串，编写一个算法来判断给定输入是否是累加数。</p>
<p><strong>说明:&nbsp;</strong>累加序列里的数不会以 0 开头，所以不会出现&nbsp;<code>1, 2, 03</code> 或者&nbsp;<code>1, 02, 3</code>&nbsp;的情况。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>&quot;112358&quot;</code>
<strong>输出:</strong> true 
<strong>解释: </strong>累加序列为: <code>1, 1, 2, 3, 5, 8 </code>。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <code>&quot;199100199&quot;</code>
<strong>输出:</strong> true 
<strong>解释: </strong>累加序列为: <code>1, 99, 100, 199。</code>1 + 99 = 100, 99 + 100 = 199</pre>

<p><strong>进阶:</strong><br>
你如何处理一个溢出的过大的整数输入?</p>

## 解法

### **Java**
```java
public class Solution {
	public boolean isAdditiveNumber(String num) {
		int n = num.length();
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
				if (isValid(i, j, num)) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean isValid(int i, int j, String num) {
		if (num.charAt(0) == '0' && i > 1) {
			return false;
		}
		if (num.charAt(i) == '0' && j > 1) {
			return false;
		}
		String sum;
		Long x1 = Long.parseLong(num.substring(0, i));
		Long x2 = Long.parseLong(num.substring(i, i + j));
		for (int start = i + j; start < num.length(); start += sum.length()) {
			x2 = x1 + x2;
			x1 = x2 - x1;
			sum = x2.toString();
			if (!num.startsWith(sum, start)) {
				return false;
			}
		}
		return true;
	}
}
```

# [307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable)
## 题目描述

<p>给定一个整数数组 &nbsp;<em>nums</em>，求出数组从索引&nbsp;<em>i&nbsp;</em>到&nbsp;<em>j&nbsp;&nbsp;</em>(<em>i</em>&nbsp;&le;&nbsp;<em>j</em>) 范围内元素的总和，包含&nbsp;<em>i,&nbsp; j&nbsp;</em>两点。</p>
<p><em>update(i, val)</em> 函数可以通过将下标为&nbsp;<em>i&nbsp;</em>的数值更新为&nbsp;<em>val</em>，从而对数列进行修改。</p>
<p><strong>示例:</strong></p>
<pre>Given nums = [1, 3, 5]
sumRange(0, 2) -&gt; 9
update(1, 2)
sumRange(0, 2) -&gt; 8
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>数组仅可以在&nbsp;<em>update&nbsp;</em>函数下进行修改。</li>
	<li>你可以假设 <em>update</em> 函数与 <em>sumRange</em> 函数的调用次数是均匀分布的。</li>
</ol>

## 解法

### **Java**
```java
public class NumArray {	int[] array, helper;
	public NumArray(int[] nums) {
		array = new int[nums.length];
		helper = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			array[i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			add(i + 1, nums[i]);
		}
	}
	private void add(int pos, int value) {
		while (pos < helper.length) {
			helper[pos] += value;
			pos += lowBit(pos);
		}
	}
	private int lowBit(int pos) {
		return pos & (-pos);
	}
	private int sum(int pos) {
		int rt = 0;
		while (pos > 0) {
			rt += helper[pos];
			pos -= lowBit(pos);
		}
		return rt;
	}
	void update(int i, int val) {
		int delta = val - array[i];
		array[i] = val;
		add(i + 1, delta);
	}
	public int sumRange(int i, int j) {
		return sum(j + 1) - sum(i);
	}}
// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
```

# [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown)
## 题目描述

<p>给定一个整数数组，其中第<em>&nbsp;i</em>&nbsp;个元素代表了第&nbsp;<em>i</em>&nbsp;天的股票价格 。</p>
<p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>
<ul>
	<li>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</li>
	<li>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</li>
</ul>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [1,2,3,0,2]
<strong>输出: </strong>3 
<strong>解释:</strong> 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        // buy[i] 表示第i天持有股票，最大利润
        int[] buy = new int[n];
        // sell[i] 表示第i天为持股，最大利润
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        
        for(int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        
        return sell[n - 1];
    }
}
```


# [319. 灯泡开关](https://leetcode-cn.com/problems/bulb-switcher)
## 题目描述

<p>初始时有&nbsp;<em>n&nbsp;</em>个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第&nbsp;<em>i</em> 轮，每&nbsp;<em>i&nbsp;</em>个灯泡切换一次开关。 对于第&nbsp;<em>n&nbsp;</em>轮，你只切换最后一个灯泡的开关。 找出&nbsp;<em>n&nbsp;</em>轮后有多少个亮着的灯泡。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入: </strong>3
<strong>输出:</strong> 1 
<strong>解释:</strong> 
初始时, 灯泡状态 <strong>[关闭, 关闭, 关闭]</strong>.
第一轮后, 灯泡状态 <strong>[开启, 开启, 开启]</strong>.
第二轮后, 灯泡状态 <strong>[开启, 关闭, 开启]</strong>.
第三轮后, 灯泡状态 <strong>[开启, 关闭, 关闭]</strong>. 
你应该返回 1，因为只有一个灯泡还亮着。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
```

# [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change)
## 题目描述

<p>给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回&nbsp;<code>-1</code>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>coins = <code>[1, 2, 5]</code>, amount = <code>11</code>
<strong>输出: </strong><code>3</code> 
<strong>解释:</strong> 11 = 5 + 5 + 1</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>coins = <code>[2]</code>, amount = <code>3</code>
<strong>输出: </strong>-1</pre>

<p><strong>说明</strong>:<br>
你可以认为每种硬币的数量是无限的。</p>

## 解法

### **Java**
```java
```
# [328. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list)
## 题目描述

<p>给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。</p>
<p>请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5-&gt;NULL
<strong>输出:</strong> 1-&gt;3-&gt;5-&gt;2-&gt;4-&gt;NULL
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 2-&gt;1-&gt;3-&gt;5-&gt;6-&gt;4-&gt;7-&gt;NULL 
<strong>输出:</strong> 2-&gt;3-&gt;6-&gt;7-&gt;1-&gt;5-&gt;4-&gt;NULL</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>应当保持奇数节点和偶数节点的相对顺序。</li>
	<li>链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
```


# [331. 验证二叉树的前序序列化](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree)
## 题目描述

<p>序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 <code>#</code>。</p>
<pre>     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
</pre>

<p>例如，上面的二叉树可以被序列化为字符串 <code>&quot;9,3,4,#,#,1,#,#,2,#,6,#,#&quot;</code>，其中 <code>#</code> 代表一个空节点。</p>
<p>给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。</p>
<p>每个以逗号分隔的字符或为一个整数或为一个表示 <code>null</code> 指针的 <code>&#39;#&#39;</code> 。</p>
<p>你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如&nbsp;<code>&quot;1,,3&quot;</code> 。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong><code>&quot;9,3,4,#,#,1,#,#,2,#,6,#,#&quot;</code>
<strong>输出: </strong><code>true</code></pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong><code>&quot;1,#&quot;</code>
<strong>输出: </strong><code>false</code>
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入: </strong><code>&quot;9,#,#,1&quot;</code>
<strong>输出: </strong><code>false</code></pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int diff = 1;
        for (String s : strs) {
            if (--diff < 0) {
                return false;
            }
            if (!s.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
```

# [337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii)
## 题目描述

<p>在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为&ldquo;根&rdquo;。 除了&ldquo;根&rdquo;之外，每栋房子有且只有一个&ldquo;父&ldquo;房子与之相连。一番侦察之后，聪明的小偷意识到&ldquo;这个地方的所有房屋的排列类似于一棵二叉树&rdquo;。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。</p>
<p>计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>[3,2,3,null,3,null,1]
     <strong>3</strong>
    / \
   2   3
    \   \ 
     <strong>3</strong>   <strong>1</strong>
<strong>输出:</strong> 7 
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = <strong>7</strong>.</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>[3,4,5,1,3,null,1]
&nbsp;    3
    / \
   <strong>4</strong>   <strong>5</strong>
  / \   \ 
 1   3   1
<strong>输出:</strong> 9
<strong>解释:</strong>&nbsp;小偷一晚能够盗取的最高金额&nbsp;= <strong>4</strong> + <strong>5</strong> = <strong>9</strong>.
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int do_it = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
```

# [342. 4 的幂](https://leetcode-cn.com/problems/power-of-four)
## 题目描述

<p>给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4&nbsp;的幂次方。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>16
<strong>输出: </strong>true
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>5
<strong>输出: </strong>false</pre>

<p><strong>进阶：</strong><br>
你能不使用循环或者递归来完成本题吗？</p>

## 解法

### **Java**
```java
public class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        return ((n & (n - 1)) == 0) && ((n & 0x55555555) != 0);
    }
}
```

# [343. 整数拆分](https://leetcode-cn.com/problems/integer-break)
## 题目描述

<p>给定一个正整数&nbsp;<em>n</em>，将其拆分为<strong>至少</strong>两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>2
<strong>输出: </strong>1
<strong>解释: </strong>2 = 1 + 1, 1 &times; 1 = 1。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong>10
<strong>输出: </strong>36
<strong>解释: </strong>10 = 3 + 3 + 4, 3 &times;&nbsp;3 &times;&nbsp;4 = 36。</pre>

<p><strong>说明: </strong>你可以假设&nbsp;<em>n&nbsp;</em>不小于 2 且不大于 58。</p>

## 解法

### **Java**
```java
class Solution {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n < 4) {
            return n - 1;
        }
        int timesOf3 = n / 3;
        if (n % 3 == 1) {
            --timesOf3;
        }
        int timesOf2 = (n - timesOf3 * 3) >> 1;
        return (int) (Math.pow(2, timesOf2) * Math.pow(3, timesOf3));
    }
}
```

# [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string)
## 题目描述

<p>编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 <code>char[]</code> 的形式给出。</p>
<p>不要给另外的数组分配额外的空间，你必须<strong><a href="https://baike.baidu.com/item/原地算法" target="_blank">原地</a>修改输入数组</strong>、使用 O(1) 的额外空间解决这一问题。</p>
<p>你可以假设数组中的所有字符都是 <a href="https://baike.baidu.com/item/ASCII" target="_blank">ASCII</a> 码表中的可打印字符。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[&quot;h&quot;,&quot;e&quot;,&quot;l&quot;,&quot;l&quot;,&quot;o&quot;]
<strong>输出：</strong>[&quot;o&quot;,&quot;l&quot;,&quot;l&quot;,&quot;e&quot;,&quot;h&quot;]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[&quot;H&quot;,&quot;a&quot;,&quot;n&quot;,&quot;n&quot;,&quot;a&quot;,&quot;h&quot;]
<strong>输出：</strong>[&quot;h&quot;,&quot;a&quot;,&quot;n&quot;,&quot;n&quot;,&quot;a&quot;,&quot;H&quot;]</pre>


## 解法

### **Java**
```java
class Solution {
    public void reverseString(char[] s) {
        int n;
        if (s == null || (n = s.length) < 2) return;
        int i = 0, j = n - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            ++i;
            --j;
        }
    }
}
```

# [345. 反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string)
## 题目描述

<p>编写一个函数，以字符串作为输入，反转该字符串中的元音字母。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>&quot;hello&quot;
<strong>输出: </strong>&quot;holle&quot;
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>&quot;leetcode&quot;
<strong>输出: </strong>&quot;leotcede&quot;</pre>

<p><strong>说明:</strong><br>
元音字母不包含字母&quot;y&quot;。</p>

## 解法
将字符串转为字符数组（或列表），定义双指针 p、q，分别指向数组（列表）头部和尾部，当 p、q 指向的字符均为元音字母时，进行交换。
依次遍历，当 `p >= q` 时，遍历结束。将字符数组（列表）转为字符串返回即可。

### **Java**
```java
class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        int p = 0, q = chars.length - 1;
        while (p < q) {
            if (!isVowel(chars[p])) {
                ++p;
                continue;
            }
            if (!isVowel(chars[q])) {
                --q;
                continue;
            }
            swap(chars, p++, q--);
        }
        return String.valueOf(chars);
    }
    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
    private boolean isVowel(char c) {
        switch(c) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            return true;
        default:
            return false;
        }
    }
}
```

# [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements)
## 题目描述

<p>给定一个非空的整数数组，返回其中出现频率前&nbsp;<strong><em>k&nbsp;</em></strong>高的元素。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
<strong>输出: </strong>[1,2]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>nums = [1], k = 1
<strong>输出: </strong>[1]</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>你可以假设给定的&nbsp;<em>k&nbsp;</em>总是合理的，且 1 &le; k &le; 数组中不相同的元素的个数。</li>
	<li>你的算法的时间复杂度<strong>必须</strong>优于 O(<em>n</em> log <em>n</em>) ,&nbsp;<em>n&nbsp;</em>是数组的大小。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        List<Integer> topK = new ArrayList<>(k);
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; --i) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }
        return topK;
    }
}
```

# [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays)
## 题目描述

<p>给定两个数组，编写一个函数来计算它们的交集。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>nums1 = [1,2,2,1], nums2 = [2,2]
<strong>输出: </strong>[2]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>输出: </strong>[9,4]</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>输出结果中的每个元素一定是唯一的。</li>
	<li>我们可以不考虑输出结果的顺序。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = transfer(nums1);
        Set<Integer> s2 = transfer(nums2);
        s1.retainAll(s2);
        int[] output = new int[s1.size()];
        int i = 0;
        for (Integer e : s1) {
            output[i++] = e;
        }
        return output;
    }
    private Set<Integer> transfer(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int e : nums) {
            s.add(e);
        }
        return s;
    }
}
```

# [350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii)
## 题目描述

<p>给定两个数组，编写一个函数来计算它们的交集。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>nums1 = [1,2,2,1], nums2 = [2,2]
<strong>输出: </strong>[2,2]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>输出: </strong>[4,9]</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。</li>
	<li>我们可以不考虑输出结果的顺序。</li>
</ul>
<p><strong><strong>进阶:</strong></strong></p>
<ul>
	<li>如果给定的数组已经排好序呢？你将如何优化你的算法？</li>
	<li>如果&nbsp;<em>nums1&nbsp;</em>的大小比&nbsp;<em>nums2&nbsp;</em>小很多，哪种方法更优？</li>
	<li>如果&nbsp;<em>nums2&nbsp;</em>的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int val = map.getOrDefault(num, 0);
            if (val > 0) {
                list.add(num);
                map.put(num, val - 1);
            }
        }
        int i = 0;
        int[] res = new int[list.size()];
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }
}
```


# [355. 设计推特](https://leetcode-cn.com/problems/design-twitter)
## 题目描述

<p>设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：</p>
<ol>
	<li><strong>postTweet(userId, tweetId)</strong>: 创建一条新的推文</li>
	<li><strong>getNewsFeed(userId)</strong>: 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。</li>
	<li><strong>follow(followerId, followeeId)</strong>: 关注一个用户</li>
	<li><strong>unfollow(followerId, followeeId)</strong>: 取消关注一个用户</li>
</ol>
<p><strong>示例:</strong></p>
<pre>
Twitter twitter = new Twitter();
// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);
// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);
// 用户1关注了用户2.
twitter.follow(1, 2);
// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);
// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -&gt; [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);
// 用户1取消关注了用户2.
twitter.unfollow(1, 2);
// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);
</pre>


## 解法

### **Java**
```java
class Twitter {
    class Data {
        int id, tweetId;
        public Data(int id, int tweetId) {
            this.id = id;
            this.tweetId = tweetId;
        }
    }
    private Map<Integer, List<Data>> posts;
    private Map<Integer, Set<Integer>> follows;
    private int id;
    /** Initialize your data structure here. */
    public Twitter() {
        posts = new HashMap<>();
        follows = new HashMap<>();
        id = 0;
    }
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>());
        }
        posts.get(userId).add(new Data(id++, tweetId));
    }
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Data> queue = new PriorityQueue<>(10, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        List<Data> ps = posts.get(userId);
        if (ps != null) {
            for (Data data : ps) {
                queue.offer(data);
            }
        }
        Set<Integer> fs = follows.get(userId);
        if (fs != null) {
            for (int f : fs) {
                ps = posts.get(f);
                if (ps != null) {
                    for (Data data : ps) {
                        queue.offer(data);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10 && !queue.isEmpty(); ++i) {
            res.add(queue.poll().tweetId);
        }
        return res;
    }
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, intg followeeId) {
        if (followerId != followeeId) {
            if (!follows.containsKey(followerId)) {
                follows.put(followerId, new HashSet<>());
            }
            follows.get(followerId).add(followeeId);
        }
    }
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
```

# [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square)
## 题目描述

<p>给定一个正整数 <em>num</em>，编写一个函数，如果 <em>num</em> 是一个完全平方数，则返回 True，否则返回 False。</p>
<p><strong>说明：</strong>不要使用任何内置的库函数，如&nbsp; <code>sqrt</code>。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>16
<strong>输出：</strong>True</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>14
<strong>输出：</strong>False
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
}
```

# [371. 两整数之和](https://leetcode-cn.com/problems/sum-of-two-integers)
## 题目描述

<p><strong>不使用</strong>运算符&nbsp;<code>+</code> 和&nbsp;<code>-</code>&nbsp;，计算两整数&nbsp;<code>a</code>&nbsp;、<code>b</code>&nbsp;之和。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>a = 1, b = 2
<strong>输出: </strong>3
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>a = -2, b = 3
<strong>输出: </strong>1</pre>


## 解法

### **Java**
```java
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
```

# [374. 猜数字大小](https://leetcode-cn.com/problems/guess-number-higher-or-lower)
## 题目描述

<p>我们正在玩一个猜数字游戏。 游戏规则如下：<br>
我从&nbsp;<strong>1</strong>&nbsp;到&nbsp;<em><strong>n</strong></em>&nbsp;选择一个数字。 你需要猜我选择了哪个数字。<br>
每次你猜错了，我会告诉你这个数字是大了还是小了。<br>
你调用一个预先定义好的接口&nbsp;<code>guess(int num)</code>，它会返回 3 个可能的结果（<code>-1</code>，<code>1</code>&nbsp;或 <code>0</code>）：</p>
<pre>-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！
</pre>

<p><strong>示例 :</strong></p>
<pre><strong>输入: </strong>n = 10, pick = 6
<strong>输出: </strong>6</pre>


## 解法

### **Java**
```java
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r >>> 1;
            if (guess(mid) <= 0) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
```

# [376. 摆动序列](https://leetcode-cn.com/problems/wiggle-subsequence)
## 题目描述

<p>如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为<strong>摆动序列。</strong>第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。</p>
<p>例如，&nbsp;<code>[1,7,4,9,2,5]</code> 是一个摆动序列，因为差值 <code>(6,-3,5,-7,3)</code>&nbsp;是正负交替出现的。相反, <code>[1,4,7,2,5]</code>&nbsp;和&nbsp;<code>[1,7,4,5,5]</code> 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。</p>
<p>给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>[1,7,4,9,2,5]
<strong>输出: </strong>6 
<strong>解释: </strong>整个序列均为摆动序列。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong>[1,17,5,10,13,15,10,5,16,8]
<strong>输出: </strong>7
<strong>解释: </strong>这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入: </strong>[1,2,3,4,5,6,7,8,9]
<strong>输出: </strong>2</pre>

<p><strong>进阶:</strong><br>
你能否用&nbsp;O(<em>n</em>) 时间复杂度完成此题?</p>

## 解法

### **Java**
```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
```

# [377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv)
## 题目描述

<p>给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。</p>
<p><strong>示例:</strong></p>
<pre>
<em><strong>nums</strong></em> = [1, 2, 3]
<em><strong>target</strong></em> = 4
所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
请注意，顺序不同的序列被视作不同的组合。
因此输出为 <strong>7</strong>。
</pre>

<p><strong>进阶：</strong><br />
如果给定的数组中含有负数会怎么样？<br />
问题会产生什么变化？<br />
我们需要在题目中添加什么限制来允许负数的出现？</p>
<p><strong>致谢：</strong><br />
特别感谢&nbsp;<a href="https://leetcode.com/pbrother/">@pbrother</a>&nbsp;添加此问题并创建所有测试用例。</p>


## 解法

### **Java**
```java
class Solution {
        public int combinationSum4(int[] n, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return combinationSum4Dfs(n, dp, target);
    }
    private int combinationSum4Dfs(int[] n, int[] dp, int target) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int rt = 0;
        for (int v : n) {
            rt += combinationSum4Dfs(n, dp, target - v);
        }
        dp[target] = rt;
        return dp[target];
    }
}
```

# [378. 有序矩阵中第 K 小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix)
## 题目描述

<p>给定一个&nbsp;<em>n x n&nbsp;</em>矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。<br />
请注意，它是排序后的第k小元素，而不是第k个元素。</p>
<p><strong>示例:</strong></p>
<pre>
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
返回 13。
</pre>

<p><strong>说明: </strong><br />
你可以假设 k 的值永远是有效的, 1 &le; k &le; n<sup>2&nbsp;</sup>。</p>


## 解法

### **Java**
```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int min = matrix[0][0], max = matrix[len - 1][len - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if (check(matrix, mid, k, len)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean check(int[][] matrix, int mid, int k, int n) {
        // 从左下角走起
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
```

# [380. 常数时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1)
## 题目描述

<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构。</p>
<ol>
	<li><code>insert(val)</code>：当元素 val 不存在时，向集合中插入该项。</li>
	<li><code>remove(val)</code>：元素 val 存在时，从集合中移除该项。</li>
	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有<strong>相同的概率</strong>被返回。</li>
</ol>
<p><strong>示例 :</strong></p>
<pre>
// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();
// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);
// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);
// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);
// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();
// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);
// 2 已在集合中，所以返回 false 。
randomSet.insert(2);
// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
</pre>


## 解法

### **Java**
```java
class RandomizedSet {
	private List<Integer> list;
	private Map<Integer, Integer> map;
	private Random random;
	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		random = new Random();
	}
	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}
	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		list.set(index, list.get(list.size() - 1));
		map.put(list.get(index), index);
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}
	/** Get a random element from the set. */
	public int getRandom() {
		if (list.size() == 0) {
			return 0;
		}
		return list.get(random.nextInt(list.size()));
	}
}
```


# [383. 赎金信](https://leetcode-cn.com/problems/ransom-note)
## 题目描述

<p>给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。</p>
<p>(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)</p>
<p><strong>注意：</strong></p>
<p>你可以假设两个字符串均只含有小写字母。</p>
<pre>
canConstruct(&quot;a&quot;, &quot;b&quot;) -&gt; false
canConstruct(&quot;aa&quot;, &quot;ab&quot;) -&gt; false
canConstruct(&quot;aa&quot;, &quot;aab&quot;) -&gt; true
</pre>


## 解法
用一个数组或字典 chars 存放 magazine 中每个字母出现的次数。遍历 ransomNote 中每个字母，判断 chars 是否包含即可。

### **Java**
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0, n = magazine.length(); i < n; ++i) {
            int idx = magazine.charAt(i) - 'a';
            ++chars[idx];
        }
        for (int i = 0, n = ransomNote.length(); i < n; ++i) {
            int idx = ransomNote.charAt(i) - 'a';
            if (chars[idx] == 0) return false;
            --chars[idx];
        }
        return true;
    }
}
```

# [384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array)
## 题目描述

<p>打乱一个没有重复元素的数组。</p>
<p><strong>示例:</strong></p>
<pre>
// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);
// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();
// 重设数组到它的初始状态[1,2,3]。
solution.reset();
// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
</pre>


## 解法

### **Java**
```java
class Solution {
    private int[] src;
    private int[] arr;
    private Random random;
    public Solution(int[] nums) {
        src = nums;
        arr = Arrays.copyOf(src, src.length);
        random = new Random();
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return src;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = arr.length - 1; i >= 0; --i) {
            swap(i, random.nextInt(i + 1));
        }
        return arr;
    }
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

# [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string)
## 题目描述

<p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。</p>
<p><strong>案例:</strong></p>
<pre>
s = &quot;leetcode&quot;
返回 0.
s = &quot;loveleetcode&quot;,
返回 2.
</pre>

<p>&nbsp;</p>
<p><strong>注意事项：</strong>您可以假定该字符串只包含小写字母。</p>

## 解法
遍历字符串，用一个 map 或者字典存放字符串中每个字符出现的次数。然后再次遍历字符串，取出对应字符出现的次数，若次数为 1，直接返回当前字符串的下标。遍历结束，返回 -1。

### **Java**
```java
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> chars = new HashMap<>(26);
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (chars.get(ch) == 1) return i;
        }
        return -1;
    }
}
```

# [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence)
## 题目描述

<p>给定字符串 <strong>s</strong> 和 <strong>t</strong> ，判断 <strong>s</strong> 是否为 <strong>t</strong> 的子序列。</p>
<p>你可以认为 <strong>s</strong> 和 <strong>t</strong> 中仅包含英文小写字母。字符串 <strong>t</strong> 可能会很长（长度 ~= 500,000），而 <strong>s</strong> 是个短字符串（长度 &lt;=100）。</p>
<p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，<code>&quot;ace&quot;</code>是<code>&quot;abcde&quot;</code>的一个子序列，而<code>&quot;aec&quot;</code>不是）。</p>
<p><strong>示例&nbsp;1:</strong><br />
<strong>s</strong> = <code>&quot;abc&quot;</code>, <strong>t</strong> = <code>&quot;ahbgdc&quot;</code></p>
<p>返回&nbsp;<code>true</code>.</p>
<p><strong>示例&nbsp;2:</strong><br />
<strong>s</strong> = <code>&quot;axc&quot;</code>, <strong>t</strong> = <code>&quot;ahbgdc&quot;</code></p>
<p>返回&nbsp;<code>false</code>.</p>
<p><strong>后续挑战</strong> <strong>:</strong></p>
<p>如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k &gt;= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？</p>
<p><strong>致谢:</strong></p>
<p>特别感谢<strong> </strong><a href="https://leetcode.com/pbrother/">@pbrother&nbsp;</a>添加此问题并且创建所有测试用例。</p>

## 解法
双指针遍历即可。

### **Java**
```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == m;
    }
}
```

# [394. 字符串解码](https://leetcode-cn.com/problems/decode-string)
## 题目描述

<p>给定一个经过编码的字符串，返回它解码后的字符串。</p>
<p>编码规则为: <code>k[encoded_string]</code>，表示其中方括号内部的 <em>encoded_string</em> 正好重复 <em>k</em> 次。注意 <em>k</em> 保证为正整数。</p>
<p>你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。</p>
<p>此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 <em>k</em> ，例如不会出现像&nbsp;<code>3a</code>&nbsp;或&nbsp;<code>2[4]</code>&nbsp;的输入。</p>
<p><strong>示例:</strong></p>
<pre>
s = &quot;3[a]2[bc]&quot;, 返回 &quot;aaabcbc&quot;.
s = &quot;3[a2[c]]&quot;, 返回 &quot;accaccacc&quot;.
s = &quot;2[abc]3[cd]ef&quot;, 返回 &quot;abcabccdcdcdef&quot;.
</pre>


## 解法

### **Java**
```java
class Solution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ']') {
                stack.push(chars[i]);
            } else {
                // 找[]内的内容
                String t = "";
                while (stack.peek() != '[') {
                    t = stack.pop() + t;
                }
                // 弹出[
                stack.pop();
                // 找前面的数字
                String n = "";
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    n = stack.pop() + n;
                }
                int c = Integer.valueOf(n);
                String tmpCombine = "";
                // 把字母重复c次
                for (int j = 0; j < c; j++) {
                    tmpCombine += t;
                }
                // 放回stack
                char[] tmp = tmpCombine.toCharArray();
                for (int j = 0; j < tmp.length; j++) {
                    stack.push(tmp[j]);
                }
            }
        }
        // stack即为结果
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
```

# [397. 整数替换](https://leetcode-cn.com/problems/integer-replacement)
## 题目描述

<p>给定一个正整数&nbsp;<em>n</em>，你可以做如下操作：</p>
<p>1. 如果&nbsp;<em>n&nbsp;</em>是偶数，则用&nbsp;<code>n / 2</code>替换&nbsp;<em>n</em>。<br />
2. 如果&nbsp;<em>n&nbsp;</em>是奇数，则可以用&nbsp;<code>n + 1</code>或<code>n - 1</code>替换&nbsp;<em>n</em>。<br />
<em>n&nbsp;</em>变为 1 所需的最小替换次数是多少？</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong>
8
<strong>输出:</strong>
3
<strong>解释:</strong>
8 -&gt; 4 -&gt; 2 -&gt; 1
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong>
7
<strong>输出:</strong>
4
<strong>解释:</strong>
7 -&gt; 8 -&gt; 4 -&gt; 2 -&gt; 1
或
7 -&gt; 6 -&gt; 3 -&gt; 2 -&gt; 1
</pre>


## 解法

### **Java**
```java
class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n != 3 && (n & 3) == 3) {
                ++n;
            } else {
                --n;
            }
            ++res;
        }
        return res;
    }
}
```

# [400. 第 N 个数字](https://leetcode-cn.com/problems/nth-digit)
## 题目描述

<p>在无限的整数序列&nbsp;1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第&nbsp;<em>n&nbsp;</em>个数字。</p>
<p><strong>注意:</strong><br />
<em>n&nbsp;</em>是正数且在32为整形范围内&nbsp;(&nbsp;<em>n</em> &lt; 2<sup>31</sup>)。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong>
3
<strong>输出:</strong>
3
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong>
11
<strong>输出:</strong>
0
<strong>说明:</strong>
第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是<strong>0</strong>，它是10的一部分。
</pre>


## 解法

### **Java**
```java
class Solution {
    /***
     * 12345678910111213
     * 规律个位数9个数一共有9*1,两位数90个数 一共有90*2个数字,三位数有900个数一共有900*3个数字,以此类推
     * 举例15,15-9=6,6/2=3...0,余数是0,那么这个数值value=10*(2-1)+(3-1)=12,整除取最后一位  12%10=2
     * 举例14,14-9=5,5/2=2...1,余数不为0,那么这个数值value=10*(2-1)+2=12,则为这个数的第余数个 12/(10*(2-1))%10=1
     */
    public int findNthDigit(int n) {
        long max = 9;
        long num = n;
        long digits = 1;
        while (n > 0) {
            if (num - max * digits > 0) {
                num = num - max * digits;
                digits++;
                max = max * 10;
            } else {
                long count = num / digits;
                long childDigits = num % digits;
                if (childDigits == 0) {
                    return (int) (((long) Math.pow(10, digits - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, digits - 1) + count) / ((long) Math.pow(10, (digits - childDigits))) % 10);
                }
            }
        }
        return 0;
    }
}
```

# [401. 二进制手表](https://leetcode-cn.com/problems/binary-watch)
## 题目描述

<p>二进制手表顶部有 4 个 LED 代表<strong>小时（0-11）</strong>，底部的 6 个 LED 代表<strong>分钟（0-59）</strong>。</p>
<p>每个 LED 代表一个 0 或 1，最低位在右侧。</p>
<p><img src="https://upload.wikimedia.org/wikipedia/commons/8/8b/Binary_clock_samui_moon.jpg" style="height:300px" /></p>
<p>例如，上面的二进制手表读取 &ldquo;3:25&rdquo;。</p>
<p>给定一个非负整数 <em>n&nbsp;</em>代表当前 LED 亮着的数量，返回所有可能的时间。</p>
<p><strong>案例:</strong></p>
<pre>
输入: n = 1
返回: [&quot;1:00&quot;, &quot;2:00&quot;, &quot;4:00&quot;, &quot;8:00&quot;, &quot;0:01&quot;, &quot;0:02&quot;, &quot;0:04&quot;, &quot;0:08&quot;, &quot;0:16&quot;, &quot;0:32&quot;]</pre>

<p>&nbsp;</p>
<p><strong>注意事项:</strong></p>
<ul>
	<li>输出的顺序没有要求。</li>
	<li>小时不会以零开头，比如 &ldquo;01:00&rdquo;&nbsp;是不允许的，应为 &ldquo;1:00&rdquo;。</li>
	<li>分钟必须由两位数组成，可能会以零开头，比如 &ldquo;10:2&rdquo;&nbsp;是无效的，应为 &ldquo;10:02&rdquo;。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }
}
```

# [402. 移掉 K 位数字](https://leetcode-cn.com/problems/remove-k-digits)
## 题目描述

<p>给定一个以字符串表示的非负整数&nbsp;<em>num</em>，移除这个数中的 <em>k </em>位数字，使得剩下的数字最小。</p>
<p><strong>注意:</strong></p>
<ul>
	<li><em>num</em> 的长度小于 10002 且&nbsp;&ge; <em>k。</em></li>
	<li><em>num</em> 不会包含任何前导零。</li>
</ul>
<p><strong>示例 1 :</strong></p>
<pre>
输入: num = &quot;1432219&quot;, k = 3
输出: &quot;1219&quot;
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
</pre>

<p><strong>示例 2 :</strong></p>
<pre>
输入: num = &quot;10200&quot;, k = 1
输出: &quot;200&quot;
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
</pre>

<p>示例<strong> 3 :</strong></p>
<pre>
输入: num = &quot;10&quot;, k = 2
输出: &quot;0&quot;
解释: 从原数字移除所有的数字，剩余为空就是0。
</pre>


## 解法

### **Java**
```java
class Solution {
    public String removeKdigits(String num, int k) {
        if (k <= 0) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }
        int len = num.length() - k;
        char[] cs = new char[num.length()];
        int top = -1;
        for (char c : num.toCharArray()) {
            while (top >= 0 && cs[top] > c && k > 0) {
                --top;
                --k;
            }
            cs[++top] = c;
        }
        int offset = 0;
        while (offset <= top && cs[offset] == '0') {
            ++offset;
        }
        return offset > top ? "0" : new String(cs, offset, len - offset);
    }
}
```

# [404. 左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves)
## 题目描述

<p>计算给定二叉树的所有左叶子之和。</p>
<p><strong>示例：</strong></p>
<pre>
    3
   / \
  9  20
    /  \
   15   7
在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24</pre>

<p>&nbsp;</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
```

# [405. 数字转换为十六进制数](https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal)
## 题目描述

<p>给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用&nbsp;<a href="https://baike.baidu.com/item/%E8%A1%A5%E7%A0%81/6854613?fr=aladdin">补码运算</a>&nbsp;方法。</p>
<p><strong>注意:</strong></p>
<ol>
	<li>十六进制中所有字母(<code>a-f</code>)都必须是小写。</li>
	<li>十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符<code>&#39;0&#39;</code>来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。&nbsp;</li>
	<li>给定的数确保在32位有符号整数范围内。</li>
	<li><strong>不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。</strong></li>
</ol>
<p><strong>示例 1：</strong></p>
<pre>
输入:
26
输出:
&quot;1a&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre>
输入:
-1
输出:
&quot;ffffffff&quot;
</pre>


## 解法

### **Java**
```java
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int x = num & 15;
            if (x < 10) {
                sb.append(x);
            } else {
                sb.append((char) (x - 10 + 'a'));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
```

# [406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height)
## 题目描述

<p>假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对<code>(h, k)</code>表示，其中<code>h</code>是这个人的身高，<code>k</code>是排在这个人前面且身高大于或等于<code>h</code>的人数。 编写一个算法来重建这个队列。</p>
<p><strong>注意：</strong><br />
总人数少于1100人。</p>
<p><strong>示例</strong></p>
<pre>
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
</pre>


## 解法

### **Java**
```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }
}
```

# [409. 最长回文串](https://leetcode-cn.com/problems/longest-palindrome)
## 题目描述

<p>给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。</p>
<p>在构造过程中，请注意区分大小写。比如&nbsp;<code>&quot;Aa&quot;</code>&nbsp;不能当做一个回文字符串。</p>
<p><strong>注意:</strong><br />
假设字符串的长度不会超过 1010。</p>
<p><strong>示例 1: </strong></p>
<pre>
输入:
&quot;abccccdd&quot;
输出:
7
解释:
我们可以构造的最长的回文串是&quot;dccaccd&quot;, 它的长度是 7。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int longestPalindrome(String s) {
        int[] res = new int[128];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            res[s.charAt(i)]++;
        }
        int oddCnt = 0;
        for (int e : res) {
            oddCnt += (e % 2);
        }
        return oddCnt == 0 ? n : n - oddCnt + 1;
    }
}
```


# [414. 第三大的数](https://leetcode-cn.com/problems/third-maximum-number)
## 题目描述

<p>给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [3, 2, 1]
<strong>输出:</strong> 1
<strong>解释:</strong> 第三大的数是 1.
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [1, 2]
<strong>输出:</strong> 2
<strong>解释:</strong> 第三大的数不存在, 所以返回最大的数 2 .
</pre>

<p><strong>示例 3:</strong></p>
<pre>
<strong>输入:</strong> [2, 2, 3, 1]
<strong>输出:</strong> 1
<strong>解释:</strong> 注意，要求返回第三大的数，是指第三大且唯一出现的数。
存在两个值为2的数，它们都排第二。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;
        for (int x : nums) {
            if (x == m1 || x == m2 || x == m3) {
                continue;
            }
            if (x > m1) {
                m3 = m2;
                m2 = m1;
                m1 = x;
            } else if (x > m2) {
                m3 = m2;
                m2 = x;
            } else if (x > m3) {
                m3 = x;
            }
        }
        return (int) (m3 != Long.MIN_VALUE ? m3 : m1);
    }
}
```

# [415. 字符串相加](https://leetcode-cn.com/problems/add-strings)
## 题目描述

<p>给定两个字符串形式的非负整数&nbsp;<code>num1</code> 和<code>num2</code>&nbsp;，计算它们的和。</p>
<p><strong>注意：</strong></p>
<ol>
	<li><code>num1</code> 和<code>num2</code>&nbsp;的长度都小于 5100.</li>
	<li><code>num1</code> 和<code>num2</code> 都只包含数字&nbsp;<code>0-9</code>.</li>
	<li><code>num1</code> 和<code>num2</code> 都不包含任何前导零。</li>
	<li><strong>你不能使用任何內建 BigInteger 库，&nbsp;也不能直接将输入的字符串转换为整数形式。</strong></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += (i >= 0 ? num1.charAt(i--) - '0' : 0) + (j >= 0 ? num2.charAt(j--) - '0' : 0);
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}
```

# [421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array)
## 题目描述

<p>给定一个非空数组，数组中元素为 a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, &hellip; , a<sub>n-1</sub>，其中 0 &le; a<sub>i</sub> &lt; 2<sup>31&nbsp;</sup>。</p>
<p>找到 a<sub>i</sub> 和a<sub>j&nbsp;</sub>最大的异或 (XOR) 运算结果，其中0 &le; <em>i</em>,&nbsp;&nbsp;<em>j</em> &lt; <em>n&nbsp;</em>。</p>
<p>你能在O(<em>n</em>)的时间解决这个问题吗？</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> [3, 10, 5, 25, 2, 8]
<strong>输出:</strong> 28
<strong>解释:</strong> 最大的结果是 <strong>5</strong> ^ <strong>25</strong> = 28.
</pre>


## 解法

### **Java**
```java
class Solution {
    public int findMaximumXOR(int[] numbers) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            int current = 1 << i;
            // 期望的二进制前缀
            mask = mask ^ current;
            // 在当前前缀下, 数组内的前缀位数所有情况集合
            Set<Integer> set = new HashSet<>();
            for (int j = 0, k = numbers.length; j < k; j++) {
                set.add(mask & numbers[j]);
            }
            // 期望最终异或值的从右数第i位为1, 再根据异或运算的特性推算假设是否成立
            int flag = max | current;
            for (Integer prefix : set) {
                if (set.contains(prefix ^ flag)) {
                    max = flag;
                    break;
                }
            }
        }
        return max;
    }
}
```

# [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement)
## 题目描述

<p>给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换&nbsp;<em>k&nbsp;</em>次。在执行上述操作后，找到包含重复字母的最长子串的长度。</p>
<p><strong>注意:</strong><br>
字符串长度 和 <em>k </em>不会超过&nbsp;10<sup>4</sup>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>
s = &quot;ABAB&quot;, k = 2
<strong>输出:</strong>
4
<strong>解释:</strong>
用两个&#39;A&#39;替换为两个&#39;B&#39;,反之亦然。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>
s = &quot;AABABBA&quot;, k = 1
<strong>输出:</strong>
4
<strong>解释:</strong>
将中间的一个&#39;A&#39;替换为&#39;B&#39;,字符串变为 &quot;AABBBBA&quot;。
子串 &quot;BBBB&quot; 有最长重复字母, 答案为 4。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] map = new int[26];
        int res = 0;
        int max = 0;
        for (int l = 0, r = 0; r < cs.length; ) {
            max = Math.max(max, ++map[cs[r++] - 'A']);
            while (r - l - max > k) {
                --map[cs[l++] - 'A'];
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
```

# [426. 将二叉搜索树转化为排序的双向链表](https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list)
## 题目描述

<p>将一个 <strong>二叉搜索树</strong> 就地转化为一个 <strong>已排序的双向循环链表</strong> 。</p>
<p>对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。</p>
<p>特别地，我们希望可以 <strong>就地</strong> 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。</p>
<p> </p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>root = [4,2,5,1,3] </pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235117485.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre>
<strong>输出：</strong>[1,2,3,4,5]
<strong>解释：</strong>下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235146686.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>root = [2,1,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>root = []
<strong>输出：</strong>[]
<strong>解释：</strong>输入是空树，所以输出也是空链表。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p> </p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>-1000 <= Node.val <= 1000</code></li>
	<li><code>Node.left.val < Node.val < Node.right.val</code></li>
	<li><code>Node.val</code> 的所有值都是独一无二的</li>
	<li><code>0 <= Number of Nodes <= 2000</code></li>
</ul>

## 解法
- 排序链表：二叉搜索树中序遍历得到有序序列
- 循环链表：头节点指向链表尾节点，尾节点指向链表头节点
- 双向链表：`pre.right = cur`、`cur.left = pre`、`pre = cur`

### **Java**
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head;
    private Node pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre == null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
```
# [430. 扁平化多级双向链表](https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list)
## 题目描述

<p>您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。</p>
<p>扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
<strong>输出:</strong>
1-2-3-7-8-11-12-9-10-4-5-6-NULL
</pre>

<p>&nbsp;</p>
<p><strong>以上示例的说明:</strong></p>
<p>给出以下多级双向链表:</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235330472.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p>我们应该返回如下所示的扁平双向链表:</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235347546.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)

## 解法

### **Java**
```java
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        head.prev = null;
        return head;
    }
    private Node dfs(Node head) {
        Node cur = head;
        while (cur != null) {
            head.prev = cur;
            Node next = cur.next;
            if (cur.child != null) {
                Node h = dfs(cur.child);
                cur.child = null;
                Node t = h.prev;
                cur.next = h;
                h.prev = cur;
                t.next = next;
                if (next != null) {
                    next.prev = t;
                }
                head.prev = t;
            }
            cur = next;
        }
        return head;
    }
}
```

# [437. 路径总和 III](https://leetcode-cn.com/problems/path-sum-iii)
## 题目描述

<p>给定一个二叉树，它的每个结点都存放着一个整数值。</p>
<p>找出路径和等于给定数值的路径总数。</p>
<p>路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>
<p>二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。</p>
<p><strong>示例：</strong></p>
<pre>root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    <strong>5</strong>   <strong>-3</strong>
   <strong>/</strong> <strong>\</strong>    <strong>\</strong>
  <strong>3</strong>   <strong>2</strong>   <strong>11</strong>
 / \   <strong>\</strong>
3  -2   <strong>1</strong>
返回 3。和等于 8 的路径有:
1.  5 -&gt; 3
2.  5 -&gt; 2 -&gt; 1
3.  -3 -&gt; 11
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param prefixSumCount 前缀和Map
     * @param target 目标值
     * @param currSum 当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}
```

# [441. 排列硬币](https://leetcode-cn.com/problems/arranging-coins)
## 题目描述

<p>你总共有&nbsp;<em>n&nbsp;</em>枚硬币，你需要将它们摆成一个阶梯形状，第&nbsp;<em>k&nbsp;</em>行就必须正好有&nbsp;<em>k&nbsp;</em>枚硬币。</p>
<p>给定一个数字&nbsp;<em>n</em>，找出可形成完整阶梯行的总行数。</p>
<p><em>n&nbsp;</em>是一个非负整数，并且在32位有符号整型的范围内。</p>
<p><strong>示例 1:</strong></p>
<pre>
n = 5
硬币可排列成以下几行:
&curren;
&curren; &curren;
&curren; &curren;
因为第三行不完整，所以返回2.
</pre>

<p><strong>示例 2:</strong></p>
<pre>
n = 8
硬币可排列成以下几行:
&curren;
&curren; &curren;
&curren; &curren; &curren;
&curren; &curren;
因为第四行不完整，所以返回3.
</pre>


## 解法
`(1 + x) * x / 2 <= n`，求解 x。
`(x + 1/2)² <= 2n + 1/4`，即 `x <= sqrt(2n + 1/4) - 1/2`。
由于 2n 可能溢出，故转换为 `x <= sqrt(2) * sqrt(n + 1/8) - 1/2`。

### **Java**
```java
class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
```

# [442. 数组中重复的数据](https://leetcode-cn.com/problems/find-all-duplicates-in-an-array)
## 题目描述

<p>给定一个整数数组 a，其中1 &le; a[i] &le; <em>n</em> （<em>n</em>为数组长度）, 其中有些元素出现<strong>两次</strong>而其他元素出现<strong>一次</strong>。</p>
<p>找到所有出现<strong>两次</strong>的元素。</p>
<p>你可以不用到任何额外空间并在O(<em>n</em>)时间复杂度内解决这个问题吗？</p>
<p><strong>示例：</strong></p>
<pre>
<strong>输入:</strong>
[4,3,2,7,8,2,3,1]
<strong>输出:</strong>
[2,3]
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
```

# [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii)
## 题目描述

<p>给定两个<strong>非空</strong>链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。</p>
<p>&nbsp;</p>
<p>你可以假设除了数字 0 之外，这两个数字都不会以零开头。</p>
<p><strong>进阶:</strong></p>
<p>如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> (7 -&gt; 2 -&gt; 4 -&gt; 3) + (5 -&gt; 6 -&gt; 4)
<strong>输出:</strong> 7 -&gt; 8 -&gt; 0 -&gt; 7
</pre>


## 解法

### **Java**
```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        for (; l1 != null; l1 = l1.next) {
            s1.push(l1.val);
        }
        for (; l2 != null; l2 = l2.next) {
            s2.push(l2.val);
        }
        ListNode head = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            carry += (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop());
            ListNode h = new ListNode(carry % 10);
            h.next = head;
            head = h;
            carry /= 10;
        }
        return head;
    }
}
```

# [448. 找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array)
## 题目描述

<p>给定一个范围在&nbsp; 1 &le; a[i] &le; <em>n</em> (&nbsp;<em>n</em> = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。</p>
<p>找到所有在 [1, <em>n</em>] 范围之间没有出现在数组中的数字。</p>
<p>您能在不使用额外空间且时间复杂度为<em>O(n)</em>的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong>
[4,3,2,7,8,2,3,1]
<strong>输出:</strong>
[5,6]
</pre>


## 解法
- 遍历输入数组的每个元素一次。
- 把 `|nums[i]|-1` 索引位置的元素标记为负数。即 `nums[|nums[i]|-1]` \* -1。
- 然后遍历数组，若当前数组元素 `nums[i]` 为负数，说明我们在数组中存在数字 `i+1`。否则，说明数组不存在数字 `i+1`，添加到结果列表中。

### **Java**
```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
```

# [449. 序列化和反序列化二叉搜索树](https://leetcode-cn.com/problems/serialize-and-deserialize-bst)
## 题目描述

<p>序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。</p>
<p>设计一个算法来序列化和反序列化<strong>二叉搜索树</strong>。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。</p>
<p><strong>编码的字符串应尽可能紧凑。</strong></p>
<p><strong>注意</strong>：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            robot(root, sb);
            return sb.substring(0, sb.length() - 1);
        }
        private void robot(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val).append(",");
            robot(root.left, sb);
            robot(root.right, sb);
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || Objects.equals(data, "")) {
                return null;
            }
            String[] pre = data.split(",");
            return build(pre, 0, pre.length - 1);
        }
        private TreeNode build(String[] pre, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(pre[start]));
            int index = end + 1;
            for (int i = start + 1; i <= end; i++) {
                if (Integer.valueOf(pre[i]) > root.val) {
                    index = i;
                    break;
                }
            }
            root.left = build(pre, start + 1, index - 1);
            root.right = build(pre, index, end);
            return root;
        }
    }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```

# [450. 删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst)
## 题目描述

<p>给定一个二叉搜索树的根节点 <strong>root </strong>和一个值 <strong>key</strong>，删除二叉搜索树中的&nbsp;<strong>key&nbsp;</strong>对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。</p>
<p>一般来说，删除节点可分为两个步骤：</p>
<ol>
	<li>首先找到需要删除的节点；</li>
	<li>如果找到了，删除它。</li>
</ol>
<p><strong>说明：</strong> 要求算法时间复杂度为&nbsp;O(h)，h 为树的高度。</p>
<p><strong>示例:</strong></p>
<pre>
root = [5,3,6,2,4,null,7]
key = 3
    5
   / \
  3   6
 / \   \
2   4   7
给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    5
   / \
  4   6
 /     \
2       7
另一个正确答案是 [5,2,6,null,4,null,7]。
    5
   / \
  2   6
   \   \
    4   7
</pre>


## 解法

### **Java**
```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode newRoot = root.right;
            TreeNode parent = null;
            while (newRoot.left != null) {
                parent = newRoot;
                newRoot = newRoot.left;
            }
            if (parent != null) {
                parent.left = newRoot.right;
                newRoot.right = root.right;
            }
            newRoot.left = root.left;
            return newRoot;
        }
    }
}
```

# [452. 用最少数量的箭引爆气球](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons)
## 题目描述

<p>在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在10<sup>4</sup>个气球。</p>
<p>一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 x<sub>start，</sub>x<sub>end，</sub> 且满足 &nbsp;x<sub>start</sub>&nbsp;&le; x &le; x<sub>end，</sub>则该气球会被引爆<sub>。</sub>可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。</p>
<p><strong>Example:</strong></p>
<pre>
<strong>输入:</strong>
[[10,16], [2,8], [1,6], [7,12]]
<strong>输出:</strong>
2
<strong>解释:</strong>
对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > pre) {
                ++res;
                pre = points[i][1];
            }
        }
        return res;
    }
}
```

# [453. 最小移动次数使数组元素相等](https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements)
## 题目描述

<p>给定一个长度为 <em>n</em> 的<strong>非空</strong>整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 <em>n</em> - 1 个元素增加 1。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong>
[1,2,3]
<strong>输出:</strong>
3
<strong>解释:</strong>
只需要3次移动（注意每次移动会增加两个元素的值）：
[1,2,3]  =&gt;  [2,3,3]  =&gt;  [3,4,3]  =&gt;  [4,4,4]
</pre>


## 解法

### **Java**
```java
class Solution {
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.length;
    }
}
```

# [454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii)
## 题目描述

<p>给定四个包含整数的数组列表&nbsp;A , B , C , D ,计算有多少个元组 <code>(i, j, k, l)</code>&nbsp;，使得&nbsp;<code>A[i] + B[j] + C[k] + D[l] = 0</code>。</p>
<p>为了使问题简单化，所有的 A, B, C, D 具有相同的长度&nbsp;N，且 0 &le; N &le; 500 。所有整数的范围在 -2<sup>28</sup> 到 2<sup>28</sup> - 1 之间，最终结果不会超过&nbsp;2<sup>31</sup> - 1 。</p>
<p><strong>例如:</strong></p>
<pre>
<strong>输入:</strong>
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
<strong>输出:</strong>
2
<strong>解释:</strong>
两个元组如下:
1. (0, 0, 0, 1) -&gt; A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -&gt; A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
</pre>


## 解法

### **Java**
```java
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }
}
```

# [456. 132 模式](https://leetcode-cn.com/problems/132-pattern)
## 题目描述

<p>给定一个整数序列：a<sub>1</sub>, a<sub>2</sub>, ..., a<sub>n</sub>，一个132模式的子序列&nbsp;a<sub><strong>i</strong></sub>, a<sub><strong>j</strong></sub>, a<sub><strong>k</strong></sub>&nbsp;被定义为：当 <strong>i</strong> &lt; <strong>j</strong> &lt; <strong>k</strong> 时，a<sub><strong>i</strong></sub> &lt; a<sub><strong>k</strong></sub> &lt; a<sub><strong>j</strong></sub>。设计一个算法，当给定有&nbsp;n 个数字的序列时，验证这个序列中是否含有132模式的子序列。</p>
<p><strong>注意：</strong>n 的值小于15000。</p>
<p><strong>示例1:</strong></p>
<pre>
<strong>输入:</strong> [1, 2, 3, 4]
<strong>输出:</strong> False
<strong>解释:</strong> 序列中不存在132模式的子序列。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [3, 1, 4, 2]
<strong>输出:</strong> True
<strong>解释:</strong> 序列中有 1 个132模式的子序列： [1, 4, 2].
</pre>

<p><strong>示例 3:</strong></p>
<pre>
<strong>输入:</strong> [-1, 3, 2, 0]
<strong>输出:</strong> True
<strong>解释:</strong> 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean find132pattern(int[] nums) {
        int ak = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < ak) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                ak = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
```


# [459. 重复的子字符串](https://leetcode-cn.com/problems/repeated-substring-pattern)
## 题目描述

<p>给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> &quot;abab&quot;
<strong>输出:</strong> True
<strong>解释:</strong> 可由子字符串 &quot;ab&quot; 重复两次构成。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> &quot;aba&quot;
<strong>输出:</strong> False
</pre>

<p><strong>示例 3:</strong></p>
<pre>
<strong>输入:</strong> &quot;abcabcabcabc&quot;
<strong>输出:</strong> True
<strong>解释:</strong> 可由子字符串 &quot;abc&quot; 重复四次构成。 (或者子字符串 &quot;abcabc&quot; 重复两次构成。)
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
```

# [461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance)
## 题目描述

<p>两个整数之间的<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E8%B7%9D%E7%A6%BB">汉明距离</a>指的是这两个数字对应二进制位不同的位置的数目。</p>
<p>给出两个整数 <code>x</code> 和 <code>y</code>，计算它们之间的汉明距离。</p>
<p><strong>注意：</strong><br />
0 &le; <code>x</code>, <code>y</code> &lt; 2<sup>31</sup>.</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> x = 1, y = 4
<strong>输出:</strong> 2
<strong>解释:</strong>
1   (0 0 0 1)
4   (0 1 0 0)
       &uarr;   &uarr;
上面的箭头指出了对应二进制位不同的位置。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0, sum = x ^ y;
        while (sum != 0) {
            sum &= (sum - 1);
            count++;
        }
        return count;
    }
}
```

# [462. 最少移动次数使数组元素相等 II](https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii)
## 题目描述

<p>给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。</p>
<p><strong>例如:</strong></p>
<pre>
<strong>输入:</strong>
[1,2,3]
<strong>输出:</strong>
2
<strong>说明：
</strong>只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 
[1,2,3]  =&gt;  [2,2,3]  =&gt;  [2,2,2]
</pre>


## 解法

### **Java**
```java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int k = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - k);
        }
        return res;
    }
}
```

# [473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square)
## 题目描述

<p>还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。</p>
<p>输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>
<strong>输入:</strong> [1,1,2,2,2]
<strong>输出:</strong> true
<strong>解释:</strong> 能拼成一个边长为2的正方形，每边两根火柴。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>
<strong>输入:</strong> [3,3,3,3,4]
<strong>输出:</strong> false
<strong>解释:</strong> 不能用所有火柴拼成一个正方形。
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>给定的火柴长度和在&nbsp;<code>0</code>&nbsp;到&nbsp;<code>10^9</code>之间。</li>
	<li>火柴数组的长度不超过15。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] lens = new int[4];
        return dfs(nums, nums.length - 1, lens, sum / 4);
    }
    private boolean dfs(int[] nums, int index, int[] lens, int len) {
        if (lens[0] == len && lens[1] == len && lens[2] == len) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            if (lens[i] + nums[index] <= len) {
                lens[i] += nums[index];
                if (dfs(nums, index - 1, lens, len)) {
                    return true;
                }
                lens[i] -= nums[index];
            }
        }
        return false;
    }
}
```

# [475. 供暖器](https://leetcode-cn.com/problems/heaters)
## 题目描述

<p>冬季已经来临。&nbsp;你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。</p>
<p>现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。</p>
<p>所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。</p>
<p><strong>说明:</strong></p>
<ol>
	<li>给出的房屋和供暖器的数目是非负数且不会超过 25000。</li>
	<li>给出的房屋和供暖器的位置均是非负数且不会超过10^9。</li>
	<li>只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。</li>
	<li>所有供暖器都遵循你的半径标准，加热的半径也一样。</li>
</ol>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,2,3],[2]
<strong>输出:</strong> 1
<strong>解释:</strong> 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [1,2,3,4],[1,4]
<strong>输出:</strong> 1
<strong>解释:</strong> 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int x : houses) {
            int i = Arrays.binarySearch(heaters, x);
            if (i < 0) {
                i = ~i;
            }
            int dis1 = i > 0 ? x - heaters[i - 1] : Integer.MAX_VALUE;
            int dis2 = i < heaters.length ? heaters[i] - x : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dis1, dis2));
        }
        return res;
    }
}
```

# [477. 汉明距离总和](https://leetcode-cn.com/problems/total-hamming-distance)
## 题目描述

<p>两个整数的&nbsp;<a href="https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E8%B7%9D%E7%A6%BB/475174?fr=aladdin">汉明距离</a> 指的是这两个数字的二进制数对应位不同的数量。</p>
<p>计算一个数组中，任意两个数之间汉明距离的总和。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> 4, 14, 2
<strong>输出:</strong> 6
<strong>解释:</strong> 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>数组中元素的范围为从&nbsp;<code>0</code>到&nbsp;<code>10^9</code>。</li>
	<li>数组的长度不超过&nbsp;<code>10^4</code>。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        
        if (nums == null || nums.length < 2) {
			return 0;
		}
        
        int[] m = new int[31];// 存储对应位数，有多少个0
        for(int num : nums) {
        	for(int i = 0; i < 31; i++) {
        		if ((num & (1 << i)) == 0) {
					m[i]++;
				}
        	}
        }
        
        int result = 0;
        for(int i = 0; i < 31; i++) {
        	result += m[i] * (nums.length - m[i]);
        }
        
        return result;
    
    }
}
```

# [483. 最小好进制](https://leetcode-cn.com/problems/smallest-good-base)
## 题目描述

<p>对于给定的整数 n, 如果n的k（k&gt;=2）进制数的所有数位全为1，则称&nbsp;k（k&gt;=2）是 n 的一个<em><strong>好进制</strong></em>。</p>
<p>以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre>
<strong>输入：</strong>&quot;13&quot;
<strong>输出：</strong>&quot;3&quot;
<strong>解释：</strong>13 的 3 进制是 111。
</pre>

<p><strong>示例 2：</strong></p>
<pre>
<strong>输入：</strong>&quot;4681&quot;
<strong>输出：</strong>&quot;8&quot;
<strong>解释：</strong>4681 的 8 进制是 11111。
</pre>

<p><strong>示例 3：</strong></p>
<pre>
<strong>输入：</strong>&quot;1000000000000000000&quot;
<strong>输出：</strong>&quot;999999999999999999&quot;
<strong>解释：</strong>1000000000000000000 的 999999999999999999 进制是 11。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>n的取值范围是&nbsp;[3, 10^18]。</li>
	<li>输入总是有效且没有前导 0。</li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int len = 63; len >= 2; --len) {
            long radix = getRadix(len, num);
            if (radix != -1) {
                return String.valueOf(radix);
            }
        }
        return String.valueOf(num - 1);
    }
    private long getRadix(int len, long num) {
        long l = 2, r = num - 1;
        while (l < r) {
            long mid = l + r >>> 1;
            if (calc(mid, len) >= num) r = mid;
            else l = mid + 1;
        }
        return calc(r, len) == num ? r : -1;
    }
    private long calc(long radix, int len) {
        long p = 1;
        long sum = 0;
        for (int i = 0; i < len; ++i) {
            if (Long.MAX_VALUE - sum < p) {
                return Long.MAX_VALUE;
            }
            sum += p;
            if (Long.MAX_VALUE / p < radix) {
                p = Long.MAX_VALUE;
            } else {
                p *= radix;
            }
        }
        return sum;
    }
}
```

# [485. 最大连续 1 的个数](https://leetcode-cn.com/problems/max-consecutive-ones)
## 题目描述

<p>给定一个二进制数组， 计算其中最大连续1的个数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,1,0,1,1,1]
<strong>输出:</strong> 3
<strong>解释:</strong> 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
</pre>

<p><strong>注意：</strong></p>
<ul>
	<li>输入的数组只包含&nbsp;<code>0</code> 和<code>1</code>。</li>
	<li>输入数组的长度是正整数，且不超过 10,000。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, t = 0;
        for (int num : nums) {
            if (num == 1) {
                ++t;
            } else {
                res = Math.max(res, t);
                t = 0;
            }
        }
        return Math.max(res, t);
    }
}
```
# [486. 预测赢家](https://leetcode-cn.com/problems/predict-the-winner)
## 题目描述

<p>给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，&hellip;&hellip;。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。</p>
<p>给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1, 5, 2]
<strong>输出:</strong> False
<strong>解释:</strong> 一开始，玩家1可以从1和2中进行选择。
如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
因此，玩家1永远不会成为赢家，返回 False。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [1, 5, 233, 7]
<strong>输出:</strong> True
<strong>解释:</strong> 玩家1一开始选择1。然后玩家2必须从5和7中进行选择。无论玩家2选择了哪个，玩家1都可以选择233。
最终，玩家1（234分）比玩家2（12分）获得更多的分数，所以返回 True，表示玩家1可以成为赢家。
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>1 &lt;= 给定的数组长度&nbsp;&lt;= 20.</li>
	<li>数组里所有分数都为非负数且不会大于10000000。</li>
	<li>如果最终两个玩家的分数相等，那么玩家1仍为赢家。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = nums[i];
            for (int j = i + 1; j < n; ++j) {
                f[j] = Math.max(nums[i] - f[j], nums[j] - f[j - 1]);
            }
        }
        return f[n - 1] >= 0;
    }
}
```

# [487. 最大连续 1 的个数 II](https://leetcode-cn.com/problems/max-consecutive-ones-ii)
## 题目描述

<p>给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,0,1,1,0]
<strong>输出：</strong>4
<strong>解释：</strong>翻转第一个 0 可以得到最长的连续 1。
     当翻转以后，最大连续 1 的个数为 4。
</pre>

<p> </p>
<p><strong>注：</strong></p>
<ul>
	<li>输入数组只包含 <code>0</code> 和 <code>1</code>.</li>
	<li>输入数组的长度为正整数，且不超过 10,000</li>
</ul>
<p> </p>
<p><strong>进阶：</strong><br>
如果输入的数字是作为<strong> 无限流 </strong>逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？</p>

## 解法
用 `prefix[i]` 数组表示以 i 结尾往前累计的最大连续 1 的个数，`suffix[i]` 数组表示以 i 开头往后累计的最大连续 1 的个数。
遍历 `nums` 数组每个为 0 的位置，则位置 i 的最大连续 1 的个数为 `1 + prefix[i-1] + suffix[i+1]`。
当然，如果 `nums` 数组没有 0，即所有元素都是 1，那么结果即为 `nums` 数组的长度。

### **Java**
- 双指针，时间复杂度 O(n²)，空间复杂度 O(1)
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 1;
            int j = i;
            while (j < n && (cnt > 0 || nums[j] == 1)) {
                if (nums[j] == 0) --cnt;
                ++j;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
```
- 辅助数组，时间复杂度 O(n)，空间复杂度 O(n)
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0) prefix[0] = nums[0];
            else prefix[i] = nums[i] == 0 ? 0 : prefix[i - 1] + 1;
            res = Math.max(res, prefix[i]);
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) suffix[n - 1] = nums[n - 1];
            else suffix[i] = nums[i] == 0 ? 0 : suffix[i + 1] + 1;
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int t = 1;
                if (i > 0) t += prefix[i - 1];
                if (i < n - 1) t += suffix[i + 1];
                res = Math.max(res, t);
            }
        }
        return res;
    }
}
```

# [490. 迷宫](https://leetcode-cn.com/problems/the-maze)
## 题目描述

<p>由空地和墙组成的迷宫中有一个<strong>球</strong>。球可以向<strong>上下左右</strong>四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。</p>
<p>给定球的<strong>起始位置，目的地</strong>和<strong>迷宫</strong>，判断球能否在目的地停下。</p>
<p>迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。</p>
<p> </p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入 1:</strong> 迷宫由以下二维数组表示
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
<strong>输入 2:</strong> 起始位置坐标 (rowStart, colStart) = (0, 4)
<strong>输入 3:</strong> 目的地坐标 (rowDest, colDest) = (4, 4)
<strong>输出:</strong> true
<strong>解析:</strong> 一个可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235425122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例 2:</strong></p>
<pre><strong>输入 1:</strong> 迷宫由以下二维数组表示
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
<strong>输入 2:</strong> 起始位置坐标 (rowStart, colStart) = (0, 4)
<strong>输入 3:</strong> 目的地坐标 (rowDest, colDest) = (3, 2)
<strong>输出:</strong> false
<strong>解析:</strong> 没有能够使球停在目的地的路径。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235511983.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p> </p>
<p><strong>注意:</strong></p>
<ol>
	<li>迷宫中只有一个球和一个目的地。</li>
	<li>球和目的地都在空地上，且初始时它们不在同一位置。</li>
	<li>给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。</li>
	<li>迷宫至少包括2块空地，行数和列数均不超过100。</li>
</ol>

## 解法
深度优先搜索或广度优先搜索实现。

深度优先搜索。
### **Java**
```java
class Solution {
    private boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        visited = new boolean[m][n];
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        if (visited[start[0]][start[1]]) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        visited[start[0]][start[1]] = true;
        int l = start[1] - 1, r = start[1] + 1, u = start[0] - 1, d = start[0] + 1;
        while (l >= 0 && maze[start[0]][l] == 0) --l;
        if (dfs(maze, new int[]{start[0], l + 1}, destination)) return true;
        while (r < maze[0].length && maze[start[0]][r] == 0) ++r;
        if (dfs(maze, new int[]{start[0], r - 1}, destination)) return true;
        while (u >= 0 && maze[u][start[1]] == 0) --u;
        if (dfs(maze, new int[]{u + 1, start[1]}, destination)) return true;
        while (d < maze.length && maze[d][start[1]] == 0) ++d;
        if (dfs(maze, new int[]{d - 1, start[1]}, destination)) return true;
        return false;
    }
}
```

# [492. 构造矩形](https://leetcode-cn.com/problems/construct-the-rectangle)
## 题目描述

<p>作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：</p>
<pre>
1. 你设计的矩形页面必须等于给定的目标面积。
2. 宽度 W 不应大于长度 L，换言之，要求 L &gt;= W 。
3. 长度 L 和宽度 W 之间的差距应当尽可能小。
</pre>

<p>你需要按顺序输出你设计的页面的长度 L 和宽度 W。</p>
<p><strong>示例：</strong></p>
<pre>
<strong>输入:</strong> 4
<strong>输出:</strong> [2, 2]
<strong>解释:</strong> 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>给定的面积不大于 10,000,000 且为正整数。</li>
	<li>你设计的页面的长度和宽度必须都是正整数。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] constructRectangle(int area) {
        int sr = (int) Math.sqrt(area);
        int l = sr, w = sr;
        while (l <= area && w >= 1) {
            int s = l * w;
            if (s == area) break;
            if (s > area) --w;
            else ++l;
        }
        return new int[]{l, w};
    }
}
```

# [494. 目标和](https://leetcode-cn.com/problems/target-sum)
## 题目描述

<p>给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号&nbsp;<code>+</code>&nbsp;和&nbsp;<code>-</code>。对于数组中的任意一个整数，你都可以从&nbsp;<code>+</code>&nbsp;或&nbsp;<code>-</code>中选择一个符号添加在前面。</p>
<p>返回可以使最终数组和为目标数 S 的所有添加符号的方法数。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> nums: [1, 1, 1, 1, 1], S: 3
<strong>输出:</strong> 5
<strong>解释:</strong> 
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
一共有5种方法让最终目标和为3。
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>数组非空，且长度不会超过20。</li>
	<li>初始的数组的和不会超过1000。</li>
	<li>保证返回的最终结果能被32位整数存下。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] ans = new int[1];
        wayDfs(nums, 0, S, ans);
        return ans[0];
    }
    private void wayDfs(int[] nums, int start, int left, int[] ans) {
        if (start == nums.length) {
            if (left == 0) ans[0]++;
            return;
        }
        wayDfs(nums, start + 1, left + nums[start], ans);
        wayDfs(nums, start + 1, left - nums[start], ans);
    }
}
```

# [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i)
## 题目描述

<p>给定两个<strong>没有重复元素</strong>的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;，其中<code>nums1</code>&nbsp;是&nbsp;<code>nums2</code>&nbsp;的子集。找到&nbsp;<code>nums1</code>&nbsp;中每个元素在&nbsp;<code>nums2</code>&nbsp;中的下一个比其大的值。</p>
<p><code>nums1</code>&nbsp;中数字&nbsp;<strong>x</strong>&nbsp;的下一个更大元素是指&nbsp;<strong>x</strong>&nbsp;在&nbsp;<code>nums2</code>&nbsp;中对应位置的右边的第一个比&nbsp;<strong>x&nbsp;</strong>大的元素。如果不存在，对应位置输出-1。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> <strong>nums1</strong> = [4,1,2], <strong>nums2</strong> = [1,3,4,2].
<strong>输出:</strong> [-1,3,-1]
<strong>解释:</strong>
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> <strong>nums1</strong> = [2,4], <strong>nums2</strong> = [1,2,3,4].
<strong>输出:</strong> [3,-1]
<strong>解释:</strong>
&nbsp;   对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li><code>nums1</code>和<code>nums2</code>中所有元素是唯一的。</li>
	<li><code>nums1</code>和<code>nums2</code>&nbsp;的数组大小都不超过1000。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
```

# [500. 键盘行](https://leetcode-cn.com/problems/keyboard-row)
## 题目描述

<p>给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。</p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235535274.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> [&quot;Hello&quot;, &quot;Alaska&quot;, &quot;Dad&quot;, &quot;Peace&quot;]
<strong>输出:</strong> [&quot;Alaska&quot;, &quot;Dad&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>注意：</strong></p>
<ol>
	<li>你可以重复使用键盘上同一字符。</li>
	<li>你可以假设输入的字符串将只包含字母。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String[] findWords(String[] words) {
        if (words == null) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        String[] keyboards = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            for (int j = 0; j < keyboards.length; j++) {
                // 先用word首字符确定属于哪一行
                if (keyboards[j].indexOf(word.charAt(0)) > -1) {
                    // 判断word字符串所有字符是否都属于同一行
                    boolean match = match(keyboards[j], word, list);
                    if (match) {
                        list.add(words[i]);
                    }
                    break;
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
    private boolean match(String keyboard, String word, ArrayList<String> list) {
        for (int i = 1; i < word.length(); i++) {
            if (keyboard.indexOf(word.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
```

# [501. 二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree)
## 题目描述

<p>给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。</p>
<p>假定 BST 有如下定义：</p>
<ul>
	<li>结点左子树中所含结点的值小于等于当前结点的值</li>
	<li>结点右子树中所含结点的值大于等于当前结点的值</li>
	<li>左子树和右子树都是二叉搜索树</li>
</ul>
<p>例如：<br>
给定 BST <code>[1,null,2,2]</code>,</p>
<pre>   1
    \
     2
    /
   2
</pre>

<p><code>返回[2]</code>.</p>
<p><strong>提示</strong>：如果众数超过1个，不需考虑输出顺序</p>
<p><strong>进阶：</strong>你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    int cur = 0;
    TreeNode preNode = null;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        findMode(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void findMode(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        findMode(root.left, list);
        if (preNode != null && root.val == preNode.val) {
            cur++;
        } else {
            cur = 1;
        }
        if (max < cur) {
            max = cur;
            list.clear();
            list.add(root.val);
        } else if (max == cur) {
            list.add(root.val);
        }
        preNode = root;
        findMode(root.right, list);
    }
}
```


# [503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii)
## 题目描述

<p>给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,2,1]
<strong>输出:</strong> [2,-1,2]
<strong>解释:</strong> 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
</pre>

<p><strong>注意:</strong> 输入数组的长度不会超过 10000。</p>

## 解法

### **Java**
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int len = (n << 1) - 1;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; ++i) {
            int x = nums[i < n ? i : i - n];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                res[stack.pop()] = x;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
}
```

# [504. 七进制数](https://leetcode-cn.com/problems/base-7)
## 题目描述

<p>给定一个整数，将其转化为7进制，并以字符串形式输出。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 100
<strong>输出:</strong> &quot;202&quot;
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> -7
<strong>输出:</strong> &quot;-10&quot;
</pre>

<p><strong>注意:</strong> 输入范围是&nbsp;[-1e7, 1e7] 。</p>

## 解法

### **Java**
```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return sb.reverse().toString();
    }
}
```

# [506. 相对名次](https://leetcode-cn.com/problems/relative-ranks)
## 题目描述

<p>给出&nbsp;<strong>N</strong> 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 &ldquo;金牌&rdquo;，&ldquo;银牌&rdquo; 和&ldquo; 铜牌&rdquo;（&quot;Gold Medal&quot;, &quot;Silver Medal&quot;, &quot;Bronze Medal&quot;）。</p>
<p>(注：分数越高的选手，排名越靠前。)</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [5, 4, 3, 2, 1]
<strong>输出:</strong> [&quot;Gold Medal&quot;, &quot;Silver Medal&quot;, &quot;Bronze Medal&quot;, &quot;4&quot;, &quot;5&quot;]
<strong>解释:</strong> 前三名运动员的成绩为前三高的，因此将会分别被授予 &ldquo;金牌&rdquo;，&ldquo;银牌&rdquo;和&ldquo;铜牌&rdquo; (&quot;Gold Medal&quot;, &quot;Silver Medal&quot; and &quot;Bronze Medal&quot;).
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。</pre>

<p><strong>提示:</strong></p>
<ol>
	<li>N 是一个正整数并且不会超过&nbsp;10000。</li>
	<li>所有运动员的成绩都不相同。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        Arrays.sort(index, (o1, o2) -> Integer.compare(nums[o2], nums[o1]));
        String[] res = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                res[index[i]] = "Gold Medal";
            } else if (i == 1) {
                res[index[i]] = "Silver Medal";
            } else if (i == 2) {
                res[index[i]] = "Bronze Medal";
            } else {
                res[index[i]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
```

# [507. 完美数](https://leetcode-cn.com/problems/perfect-number)
## 题目描述

<p>对于一个&nbsp;<strong>正整数</strong>，如果它和除了它自身以外的所有正因子之和相等，我们称它为&ldquo;完美数&rdquo;。</p>
<p>给定一个&nbsp;<strong>整数&nbsp;</strong><code>n</code>，&nbsp;如果他是完美数，返回&nbsp;<code>True</code>，否则返回&nbsp;<code>False</code></p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> 28
<strong>输出:</strong> True
<strong>解释:</strong> 28 = 1 + 2 + 4 + 7 + 14
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<p>输入的数字&nbsp;<strong><code>n</code></strong> 不会超过 100,000,000. (1e8)</p>

## 解法

### **Java**
```java
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum = sum + i + num / i;
            }
        }
        return num == sum;
    }
}
```

# [508. 出现次数最多的子树元素和](https://leetcode-cn.com/problems/most-frequent-subtree-sum)
## 题目描述

<p>给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。</p>
<p>&nbsp;</p>
<p><strong>示例 1</strong><br>
输入:</p>
<pre>  5
 /  \
2   -3
</pre>

<p>返回&nbsp;[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。</p>
<p><strong>示例&nbsp;2</strong><br>
输入:</p>
<pre>  5
 /  \
2   -5
</pre>

<p>返回&nbsp;[2]，只有 2 出现两次，-5 只出现 1 次。</p>
<p>&nbsp;</p>
<p><strong>提示：</strong>&nbsp;假设任意子树元素和均可以用 32 位有符号整数表示。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 后续遍历，遍历的同时，找最大值和计算次数
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);
        List<Integer> list = map.entrySet().stream()
                .filter(m -> m.getValue() == max).map(i -> i.getKey()).collect(Collectors.toList());
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        int current = map.getOrDefault(sum, 0) + 1;
        map.put(sum, current);
        max = Math.max(current, max);
        return sum;
    }
}
```

# [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number)
## 题目描述

<p><strong>斐波那契数</strong>，通常用&nbsp;<code>F(n)</code> 表示，形成的序列称为<strong>斐波那契数列</strong>。该数列由&nbsp;<code>0</code> 和 <code>1</code> 开始，后面的每一项数字都是前面两项数字的和。也就是：</p>
<pre>F(0) = 0,&nbsp; &nbsp;F(1)&nbsp;= 1
F(N) = F(N - 1) + F(N - 2), 其中 N &gt; 1.
</pre>

<p>给定&nbsp;<code>N</code>，计算&nbsp;<code>F(N)</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>2
<strong>输出：</strong>1
<strong>解释：</strong>F(2) = F(1) + F(0) = 1 + 0 = 1.
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>3
<strong>输出：</strong>2
<strong>解释：</strong>F(3) = F(2) + F(1) = 1 + 1 = 2.
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>4
<strong>输出：</strong>3
<strong>解释：</strong>F(4) = F(3) + F(2) = 2 + 1 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>0 &le; <code>N</code> &le; 30</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int a = 0, b = 1;
        int res = 0;
        for (int i = 2; i <= N; ++i) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
```

# [513. 找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value)
## 题目描述

<p>给定一个二叉树，在树的最后一行找到最左边的值。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong>
    2
   / \
  1   3
<strong>输出:</strong>
1
</pre>

<p>&nbsp;</p>
<p><strong>示例 2: </strong></p>
<pre>
<strong>输入:</strong>
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
<strong>输出:</strong>
7
</pre>

<p>&nbsp;</p>
<p><strong>注意:</strong> 您可以假设树（即给定的根节点）不为 <strong>NULL</strong>。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = -1;
    int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return value;
    }
    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        d++;
        if (max < d) {
            max = d;
            value = root.val;
        }
        dfs(root.left, d);
        dfs(root.right, d);
    }
}
```

# [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row)
## 题目描述

<p>您需要在二叉树的每一行中找到最大的值。</p>
<p><strong>示例：</strong></p>
<pre>
<strong>输入:</strong> 
          1
         / \
        3   2
       / \   \  
      5   3   9 
<strong>输出:</strong> [1, 3, 9]
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 深度遍历
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }
    private void dfs(List<Integer> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 每深入一层，先把那一层的第一个节点加入返回 list中
        if (list.size() == level) {
            list.add(root.val);
        }
        // 此时 size > level ，那么就是开始遍历每一层 的 其他节点（不包括最左边的节点），
        // 直接比较list的对应下标（index）的值与当前值就好
        else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        // 左右子树，深度要+1
        dfs(list, root.left, level + 1);
        dfs(list, root.right, level + 1);
    }
}
```

# [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2)
## 题目描述

<p>给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。&nbsp;</p>
<p>&nbsp;</p>
<ul>
</ul>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> amount = 5, coins = [1, 2, 5]
<strong>输出:</strong> 4
<strong>解释:</strong> 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> amount = 3, coins = [2]
<strong>输出:</strong> 0
<strong>解释:</strong> 只用面额2的硬币不能凑成总金额3。
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> amount = 10, coins = [10] 
<strong>输出:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>注意</strong><strong>:</strong></p>
<p>你可以假设：</p>
<ul>
	<li>0 &lt;= amount (总金额) &lt;= 5000</li>
	<li>1 &lt;= coin (硬币面额)&nbsp;&lt;= 5000</li>
	<li>硬币种类不超过 500 种</li>
	<li>结果符合 32 位符号整数</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                f[i] += f[i - coin];
            }
        }
        return f[amount];
    }
}
```

# [520. 检测大写字母](https://leetcode-cn.com/problems/detect-capital)
## 题目描述

<p>给定一个单词，你需要判断单词的大写使用是否正确。</p>
<p>我们定义，在以下情况时，单词的大写用法是正确的：</p>
<ol>
	<li>全部字母都是大写，比如&quot;USA&quot;。</li>
	<li>单词中所有字母都不是大写，比如&quot;leetcode&quot;。</li>
	<li>如果单词不只含有一个字母，只有首字母大写，&nbsp;比如&nbsp;&quot;Google&quot;。</li>
</ol>
<p>否则，我们定义这个单词没有正确使用大写字母。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> &quot;USA&quot;
<strong>输出:</strong> True
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> &quot;FlaG&quot;
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong> 输入是由大写和小写拉丁字母组成的非空单词。</p>

## 解法

### **Java**
```java
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] cs = word.toCharArray();
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }
        if (upper == cs.length) {
            return true;
        }
        if (lower == cs.length) {
            return true;
        }
        if (upper == 1 && cs[0] < 'a') {
            return true;
        }
        return false;
    }
}
```

# [521. 最长特殊序列 Ⅰ](https://leetcode-cn.com/problems/longest-uncommon-subsequence-i)
## 题目描述

<p>给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。</p>
<p><strong>子序列</strong>可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。</p>
<p>输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。</p>
<p><strong>示例 :</strong></p>
<pre><strong>输入:</strong> &quot;aba&quot;, &quot;cdc&quot;
<strong>输出:</strong> 3
<strong>解析:</strong> 最长特殊序列可为 &quot;aba&quot; (或 &quot;cdc&quot;)
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>两个字符串长度均小于100。</li>
	<li>字符串中的字符仅含有&nbsp;&#39;a&#39;~&#39;z&#39;。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
```

# [522. 最长特殊序列 II](https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii)
## 题目描述

<p>给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。</p>
<p><strong>子序列</strong>可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。</p>
<p>输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> &quot;aba&quot;, &quot;cdc&quot;, &quot;eae&quot;
<strong>输出:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>所有给定的字符串长度不会超过 10 。</li>
	<li>给定字符串列表的长度将在 [2, 50 ] 之间。</li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public int findLUSlength(String[] strs) {
        int res = -1;
        if (strs == null || strs.length == 0) {
            return res;
        }
        if (strs.length == 1) {
            return strs[0].length();
        }
        // 两两比较
        // 1、存在子串,直接不比较后面的字符串
        // 2、不存在子串,判断当前字符串是否是最长的字符串
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                // 根据题意，子串 可以 不是 原字符串中 连续的子字符串
                if (isSubsequence(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i))
                j++;
        }
        return j == x.length();
    }
}
```

# [523. 连续的子数组和](https://leetcode-cn.com/problems/continuous-subarray-sum)
## 题目描述

<p>给定一个包含<strong>非负数</strong>的数组和一个目标<strong>整数</strong>&nbsp;k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 <strong>k</strong> 的倍数，即总和为 n*k，其中 n 也是一个<strong>整数</strong>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [23,2,4,6,7], k = 6
<strong>输出:</strong> True
<strong>解释:</strong> [2,4] 是一个大小为 2 的子数组，并且和为 6。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [23,2,6,4,7], k = 6
<strong>输出:</strong> True
<strong>解释:</strong> [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>数组的长度不会超过10,000。</li>
	<li>你可以认为所有数字总和在 32 位有符号整数范围内。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
		for (int start = 0; start < nums.length; start++) {
        	int check = 0;
        	for (int i = start; i < nums.length; i++) {
        		check += nums[i];
                if (i > start) {
                	if (k != 0) {
            			if (check % k == 0) {
                    		return true;
                    	}
            		} else {
            			if (check == k) {
            				return true;
            			}
            		}
        		}
        	}
        }
        
        return false;
    }
}
```

# [525. 连续数组](https://leetcode-cn.com/problems/contiguous-array)
## 题目描述

<p>给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [0,1]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] 是具有相同数量0和1的最长连续子数组。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [0,1,0]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。</pre>

<p>&nbsp;</p>
<p><strong>注意:&nbsp;</strong>给定的二进制数组的长度不会超过50000。</p>

## 解法

### **Java**
```java
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(s)) {
                res = Math.max(res, i - map.get(s));
            } else {
                map.put(s, i);
            }
        }
        return res;
    }
}
```

# [526. 优美的排列](https://leetcode-cn.com/problems/beautiful-arrangement)
## 题目描述

<p>假设有从 1 到 N 的&nbsp;<strong>N&nbsp;</strong>个整数，如果从这&nbsp;<strong>N&nbsp;</strong>个数字中成功构造出一个数组，使得数组的第 <strong>i</strong>&nbsp;位 (1 &lt;= i &lt;= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：</p>
<ol>
	<li>第&nbsp;<strong>i&nbsp;</strong>位的数字能被&nbsp;<strong>i&nbsp;</strong>整除</li>
	<li><strong>i</strong> 能被第 <strong>i</strong> 位上的数字整除</li>
</ol>
<p>现在给定一个整数 N，请问可以构造多少个优美的排列？</p>
<p><strong>示例1:</strong></p>
<pre>
<strong>输入:</strong> 2
<strong>输出:</strong> 2
<strong>解释:</strong> 
第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li><strong>N</strong> 是一个正整数，并且不会超过15。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int countArrangement(int N) {
        int maxn = 1 << N;
        int[] f = new int[maxn];
        f[0] = 1;
        for (int i = 0; i < maxn; ++i) {
            int s = 1;
            for (int j = 0; j < N; ++j) {
                s += (i >> j) & 1;
            }
            for (int j = 1; j <= N; ++j) {
                if (((i >> (j - 1) & 1) == 0) && (s % j == 0 || j % s == 0)) {
                    f[i | (1 << (j - 1))] += f[i];
                }
            }
        }
        return f[maxn - 1];
    }
}
```

# [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst)
## 题目描述

<p>给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>
   1
    \
     3
    /
   2
<strong>输出：</strong>
1
<strong>解释：
</strong>最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>树中至少有 2 个节点。</li>
	<li>本题与 783 <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/</a> 相同</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        Integer res = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            res = Math.min(res, Math.abs(node.val - prev));
            prev = node.val;
            root = node.right;
        }
        return res;
    }
}
```
# [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree)
## 题目描述

<p>给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。</p>
<p>&nbsp;</p>
<p><strong>例如：</strong></p>
<pre><strong>输入:</strong> 原始二叉搜索树:
              5
            /   \
           2     13
<strong>输出:</strong> 转换为累加树:
             18
            /   \
          20     13
</pre>

<p>&nbsp;</p>
<p><strong>注意：</strong>本题和 1038:&nbsp;<a href="https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/">https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/</a> 相同</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += add;
            add = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
```

# [541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii)
## 题目描述

<p>给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> s = &quot;abcdefg&quot;, k = 2
<strong>输出:</strong> &quot;bacdfeg&quot;
</pre>

<p><strong>要求:</strong></p>
<ol>
	<li>该字符串只包含小写的英文字母。</li>
	<li>给定字符串的长度和 k 在[1, 10000]范围内。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String reverseStr(String s, int k) {
        if (k < 2) return s;
        StringBuilder sb = new StringBuilder();
        int length = s.length(), index = 0;
        while (index < length) {
            if (index + 2 * k <= length) {
                sb.append(reverse(s, index, index + k));
                sb.append(s.substring(index + k, index + 2 * k));
                index += 2 * k;
            } else if (index + k <= length){
                sb.append(reverse(s, index, index + k));
                sb.append(s.substring(index + k));
                break;
            } else {
                sb.append(reverse(s, index, length));
                break;
            }
        }
        return sb.toString();
    }
    private StringBuffer reverse(String s, int index, int end) {
        return new StringBuffer(s.substring(index, end)).reverse();
    }
}
```

# [542. 01 矩阵](https://leetcode-cn.com/problems/01-matrix)
## 题目描述

<p>给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。</p>
<p>两个相邻元素间的距离为 1 。</p>
<p><strong>示例 1: </strong><br />
输入:</p>
<pre>
0 0 0
0 1 0
0 0 0
</pre>

<p>输出:</p>
<pre>
0 0 0
0 1 0
0 0 0
</pre>

<p><strong>示例 2: </strong><br />
输入:</p>
<pre>
0 0 0
0 1 0
1 1 1
</pre>

<p>输出:</p>
<pre>
0 0 0
0 1 0
1 2 1
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>给定矩阵的元素个数不超过 10000。</li>
	<li>给定矩阵中至少有一个元素是 0。</li>
	<li>矩阵中的元素只在四个方向上相邻: 上、下、左、右。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int[] arr : res) {
            Arrays.fill(arr, -1);
        }
        class Position {
            int x, y;
            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Queue<Position> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(new Position(i, j));
                }
            }
        }
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int x = pos.x + dirs[i], y = pos.y + dirs[i + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = res[pos.x][pos.y] + 1;
                    queue.offer(new Position(x, y));
                }
            }
        }
        return res;
    }
}
```

# [543. 二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree)
## 题目描述

<p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。</p>
<p>&nbsp;</p>
<p><strong>示例 :</strong><br>
给定二叉树</p>
<pre>          1
         / \
        2   3
       / \     
      4   5    
</pre>

<p>返回&nbsp;<strong>3</strong>, 它的长度是路径 [4,2,1,3] 或者&nbsp;[5,2,1,3]。</p>
<p>&nbsp;</p>
<p><strong>注意：</strong>两结点之间的路径长度是以它们之间边的数目表示。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
```

# [554. 砖墙](https://leetcode-cn.com/problems/brick-wall)
## 题目描述

<p>你的面前有一堵方形的、由多行砖块组成的砖墙。&nbsp;这些砖块高度相同但是宽度不同。你现在要画一条<strong>自顶向下</strong>的、穿过<strong>最少</strong>砖块的垂线。</p>
<p>砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。</p>
<p>如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。</p>
<p><strong>你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。</strong></p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> [[1,2,2,1],
      [3,1,2],
      [1,3,2],
      [2,4],
      [3,1,2],
      [1,3,1,1]]
<strong>输出:</strong> 2
<strong>解释:</strong> 
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235552211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>每一行砖块的宽度之和应该相等，并且不能超过 INT_MAX。</li>
	<li>每一行砖块的数量在&nbsp;[1,10,000] 范围内，&nbsp;墙的高度在&nbsp;[1,10,000] 范围内，&nbsp;总的砖块数量不超过 20,000。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int s = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                s += list.get(i);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max = map.values().stream().max(Integer::compare).orElse(0);
        return wall.size() - max;
    }
}
```

# [556. 下一个更大元素 III](https://leetcode-cn.com/problems/next-greater-element-iii)
## 题目描述

<p>给定一个<strong>32位</strong>正整数&nbsp;<strong>n</strong>，你需要找到最小的<strong>32位</strong>整数，其与&nbsp;<strong>n&nbsp;</strong>中存在的位数完全相同，并且其值大于n。如果不存在这样的<strong>32位</strong>整数，则返回-1。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 12
<strong>输出:</strong> 21
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 21
<strong>输出:</strong> -1
</pre>


## 解法

### **Java**
```java
class Solution {
    public int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }
        char[] cs = String.valueOf(n).toCharArray();
        int i = cs.length - 2;
        while (i >= 0 && cs[i] >= cs[i + 1]) {
            --i;
        }
        if (i < 0) {
            return -1;
        }
        int j = cs.length - 1;
        while (cs[i] >= cs[j]) {
            --j;
        }
        swap(cs, i, j);
        reverse(cs, i + 1, cs.length - 1);
        long res = 0;
        for (char c : cs) {
            res = res * 10 + c - '0';
        }
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }
    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            swap(cs, i++, j--);
        }
    }
    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
```

# [557. 反转字符串中的单词 III](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii)
## 题目描述

<p>给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>
输入: &quot;Let&#39;s take LeetCode contest&quot;
输出: &quot;s&#39;teL ekat edoCteeL tsetnoc&quot;<strong><strong><strong>&nbsp;</strong></strong></strong>
</pre>

<p><strong><strong><strong><strong>注意：</strong></strong></strong></strong>在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。</p>

## 解法

### **Java**
```java
class Solution {
    public String reverseWords(String s) {
        String flag = " ";
        StringBuilder result = new StringBuilder();
        for (String temp : s.split(flag)) {
            for (int i = temp.length() - 1; i >= 0; i--) {
                result.append(temp.charAt(i));
            }
            result.append(flag);
        }
        return result.toString().substring(0, s.length());
    }
}
```

# [560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k)
## 题目描述

<p>给定一个整数数组和一个整数&nbsp;<strong>k，</strong>你需要找到该数组中和为&nbsp;<strong>k&nbsp;</strong>的连续的子数组的个数。</p>
<p><strong>示例 1 :</strong></p>
<pre>
<strong>输入:</strong>nums = [1,1,1], k = 2
<strong>输出:</strong> 2 , [1,1] 与 [1,1] 为两种不同的情况。
</pre>

<p><strong>说明 :</strong></p>
<ol>
	<li>数组的长度为 [1, 20,000]。</li>
	<li>数组中元素的范围是 [-1000, 1000] ，且整数&nbsp;<strong>k&nbsp;</strong>的范围是&nbsp;[-1e7, 1e7]。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            res += map.getOrDefault(s - k, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
```

# [561. 数组拆分 I](https://leetcode-cn.com/problems/array-partition-i)
## 题目描述

<p>给定长度为&nbsp;<strong>2n&nbsp;</strong>的数组, 你的任务是将这些数分成&nbsp;<strong>n </strong>对, 例如 (a<sub>1</sub>, b<sub>1</sub>), (a<sub>2</sub>, b<sub>2</sub>), ..., (a<sub>n</sub>, b<sub>n</sub>) ，使得从1 到&nbsp;n 的 min(a<sub>i</sub>, b<sub>i</sub>) 总和最大。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,4,3,2]
<strong>输出:</strong> 4
<strong>解释:</strong> n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
</pre>

<p><strong>提示:</strong></p>
<ol>
	<li><strong>n</strong>&nbsp;是正整数,范围在 [1, 10000].</li>
	<li>数组中的元素范围在 [-10000, 10000].</li>
</ol>

## 解法
先排序，然后求相邻的两个元素的最小值，得到的总和即为结果。

### **Java**
```java
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, n = nums.length; i < n; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
```
# [563. 二叉树的坡度](https://leetcode-cn.com/problems/binary-tree-tilt)
## 题目描述

<p>给定一个二叉树，计算<strong>整个树</strong>的坡度。</p>
<p>一个树的<strong>节点的坡度</strong>定义即为，该节点左子树的结点之和和右子树结点之和的<strong>差的绝对值</strong>。空结点的的坡度是0。</p>
<p><strong>整个树</strong>的坡度就是其所有节点的坡度之和。</p>
<p><strong>示例:</strong></p>
<pre>
<strong>输入:</strong> 
         1
       /   \
      2     3
<strong>输出:</strong> 1
<strong>解释:</strong> 
结点的坡度 2 : 0
结点的坡度 3 : 0
结点的坡度 1 : |2-3| = 1
树的坡度 : 0 + 0 + 1 = 1
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>任何子树的结点的和不会超过32位整数的范围。</li>
	<li>坡度的值不会超过32位整数的范围。</li>
</ol>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int sum = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return sum;
    }
    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }
}
```

# [566. 重塑矩阵](https://leetcode-cn.com/problems/reshape-the-matrix)
## 题目描述

<p>在MATLAB中，有一个非常有用的函数 <code>reshape</code>，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。</p>
<p>给出一个由二维数组表示的矩阵，以及两个正整数<code>r</code>和<code>c</code>，分别表示想要的重构的矩阵的行数和列数。</p>
<p>重构后的矩阵需要将原始矩阵的所有元素以相同的<strong>行遍历顺序</strong>填充。</p>
<p>如果具有给定参数的<code>reshape</code>操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
<strong>输出:</strong> 
[[1,2,3,4]]
<strong>解释:</strong>
行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
<strong>输出:</strong> 
[[1,2],
 [3,4]]
<strong>解释:</strong>
没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
</pre>

<p><strong>注意：</strong></p>
<ol>
	<li>给定矩阵的宽和高范围在 [1, 100]。</li>
	<li>给定的 r 和 c 都是正数。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}
```

# [572. 另一个树的子树](https://leetcode-cn.com/problems/subtree-of-another-tree)
## 题目描述

<p>给定两个非空二叉树 <strong>s</strong> 和 <strong>t</strong>，检验&nbsp;<strong>s</strong> 中是否包含和 <strong>t</strong> 具有相同结构和节点值的子树。<strong>s</strong> 的一个子树包括 <strong>s</strong> 的一个节点和这个节点的所有子孙。<strong>s</strong> 也可以看做它自身的一棵子树。</p>
<p><strong>示例 1:</strong><br />
给定的树 s:</p>
<pre>
     3
    / \
   4   5
  / \
 1   2
</pre>

<p>给定的树 t：</p>
<pre>
   4 
  / \
 1   2
</pre>

<p>返回 <strong>true</strong>，因为 t 与 s 的一个子树拥有相同的结构和节点值。</p>
<p><strong>示例 2:</strong><br />
给定的树 s：</p>
<pre>
     3
    / \
   4   5
  / \
 1   2
    /
   0
</pre>

<p>给定的树 t：</p>
<pre>
   4
  / \
 1   2
</pre>

<p>返回 <strong>false</strong>。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val != t.val){
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
```

# [576. 出界的路径数](https://leetcode-cn.com/problems/out-of-boundary-paths)
## 题目描述

<p>给定一个 <strong>m &times; n </strong>的网格和一个球。球的起始坐标为&nbsp;<strong>(i,j)</strong>&nbsp;，你可以将球移到<strong>相邻</strong>的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你<strong>最多</strong>可以移动&nbsp;<strong>N&nbsp;</strong>次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 10<sup>9</sup>&nbsp;+ 7 的值。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入: </strong>m = 2, n = 2, N = 2, i = 0, j = 0
<strong>输出:</strong> 6
<strong>解释:</strong>
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235611997.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例 2：</strong></p>
<pre><strong>输入: </strong>m = 1, n = 3, N = 3, i = 0, j = 1
<strong>输出:</strong> 12
<strong>解释:</strong>
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235629529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ol>
	<li>球一旦出界，就不能再被移动回网格内。</li>
	<li>网格的长度和高度在 [1,50] 的范围内。</li>
	<li>N 在 [0,50] 的范围内。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        final int MOD = (int) (1e9 + 7);
        final int[] dirs = new int[]{-1, 0, 1, 0, -1};
        int[][] f = new int[m][n];
        f[i][j] = 1;
        int res = 0;
        for (int step = 0; step < N; ++step) {
            int[][] temp = new int[m][n];
            for (int x = 0; x < m; ++x) {
                for (int y = 0; y < n; ++y) {
                    for (int k = 0; k < 4; ++k) {
                        int tx = x + dirs[k], ty = y + dirs[k + 1];
                        if (tx >= 0 && tx < m && ty >= 0 && ty < n) {
                            temp[tx][ty] += f[x][y];
                            temp[tx][ty] %= MOD;
                        } else {
                            res += f[x][y];
                            res %= MOD;
                        }
                    }
                }
            }
            f = temp;
        }
        return res;
    }
}
```

# [581. 最短无序连续子数组](https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray)
## 题目描述

<p>给定一个整数数组，你需要寻找一个<strong>连续的子数组</strong>，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。</p>
<p>你找到的子数组应是<strong>最短</strong>的，请输出它的长度。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [2, 6, 4, 8, 10, 9, 15]
<strong>输出:</strong> 5
<strong>解释:</strong> 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
</pre>

<p><strong>说明 :</strong></p>
<ol>
	<li>输入的数组长度范围在&nbsp;[1, 10,000]。</li>
	<li>输入的数组可能包含<strong>重复</strong>元素&nbsp;，所以<strong>升序</strong>的意思是<strong>&lt;=。</strong></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = nums[i];
        }
        Arrays.sort(res);
        int p = 0;
        for (; p < n; ++p) {
            if (res[p] != nums[p]) {
                break;
            }
        }
        int q = n - 1;
        for (; q >= 0; --q) {
            if (res[q] != nums[q]) {
                break;
            }
        }
        return p == n ? 0 : q - p + 1 ;
        
    }
}
```

# [589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal)
## 题目描述

<p>给定一个 N 叉树，返回其节点值的<em>前序遍历</em>。</p>
<p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235658406.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p>返回其前序遍历: <code>[1,3,5,6,2,4]</code>。</p>
<p>&nbsp;</p>
<p><strong>说明:&nbsp;</strong>递归法很简单，你可以使用迭代法完成此题吗?</p>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; --i) {
                stack.push(children.get(i));
            }
        }
        return res;
    }
}
```

# [590. N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal)
## 题目描述

<p>给定一个 N 叉树，返回其节点值的<em>后序遍历</em>。</p>
<p>例如，给定一个&nbsp;<code>3叉树</code>&nbsp;:</p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235731193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p>返回其后序遍历: <code>[5,6,3,2,4,1]</code>.</p>
<p>&nbsp;</p>
<p><strong>说明:</strong>&nbsp;递归法很简单，你可以使用迭代法完成此题吗?</p>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(0, node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }
}
```

# [605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers)
## 题目描述

<p>假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。</p>
<p>给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数&nbsp;<strong>n&nbsp;</strong>。能否在不打破种植规则的情况下种入&nbsp;<strong>n&nbsp;</strong>朵花？能则返回True，不能则返回False。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> flowerbed = [1,0,0,0,1], n = 1
<strong>输出:</strong> True
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> flowerbed = [1,0,0,0,1], n = 2
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>数组内已种好的花不会违反种植规则。</li>
	<li>输入的数组长度范围为 [1, 20000]。</li>
	<li><strong>n</strong> 是非负整数，且不会超过输入数组的大小。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                ++cnt;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
```

# [606. 根据二叉树创建字符串](https://leetcode-cn.com/problems/construct-string-from-binary-tree)
## 题目描述

<p>你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。</p>
<p>空节点则用一对空括号 &quot;()&quot; 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     
<strong>输出:</strong> &quot;1(2(4))(3)&quot;
<strong>解释:</strong> 原本将是&ldquo;1(2(4)())(3())&rdquo;，
在你省略所有不必要的空括号对之后，
它将是&ldquo;1(2(4))(3)&rdquo;。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 
<strong>输出:</strong> &quot;1(2()(4))(3)&quot;
<strong>解释:</strong> 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
</pre>


## 解法

### **Java**
```java
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.right != null) {
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
        if (t.left != null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "";
    }
}
```

# [611. 有效三角形的个数](https://leetcode-cn.com/problems/valid-triangle-number)
## 题目描述

<p>给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [2,2,3,4]
<strong>输出:</strong> 3
<strong>解释:</strong>
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>数组长度不超过1000。</li>
	<li>数组里整数的范围为 [0, 1000]。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }
}
```

# [617. 合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees)
## 题目描述

<p>给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。</p>
<p>你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则<strong>不为&nbsp;</strong>NULL 的节点将直接作为新二叉树的节点。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>
<strong>输入:</strong> 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
<strong>输出:</strong> 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
</pre>

<p><strong>注意:</strong>&nbsp;合并必须从两个树的根节点开始。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
```

# [622. 设计循环队列](https://leetcode-cn.com/problems/design-circular-queue)
## 题目描述

<p>设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为&ldquo;环形缓冲器&rdquo;。</p>
<p>循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。</p>
<p>你的实现应该支持如下操作：</p>
<ul>
	<li><code>MyCircularQueue(k)</code>: 构造器，设置队列长度为 k 。</li>
	<li><code>Front</code>: 从队首获取元素。如果队列为空，返回 -1 。</li>
	<li><code>Rear</code>: 获取队尾元素。如果队列为空，返回 -1 。</li>
	<li><code>enQueue(value)</code>: 向循环队列插入一个元素。如果成功插入则返回真。</li>
	<li><code>deQueue()</code>: 从循环队列中删除一个元素。如果成功删除则返回真。</li>
	<li><code>isEmpty()</code>: 检查循环队列是否为空。</li>
	<li><code>isFull()</code>: 检查循环队列是否已满。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre>MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3
circularQueue.enQueue(1); &nbsp;// 返回 true
circularQueue.enQueue(2); &nbsp;// 返回 true
circularQueue.enQueue(3); &nbsp;// 返回 true
circularQueue.enQueue(4); &nbsp;// 返回 false，队列已满
circularQueue.Rear(); &nbsp;// 返回 3
circularQueue.isFull(); &nbsp;// 返回 true
circularQueue.deQueue(); &nbsp;// 返回 true
circularQueue.enQueue(4); &nbsp;// 返回 true
circularQueue.Rear(); &nbsp;// 返回 4
&nbsp;</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>所有的值都在 0&nbsp;至 1000 的范围内；</li>
	<li>操作数将在 1 至 1000 的范围内；</li>
	<li>请不要使用内置的队列库。</li>
</ul>

## 解法

### **Java**
```java
class MyCircularQueue {
 private Integer[] nums;
    private int head;
    private int tail;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.nums = new Integer[k];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if(this.head == this.tail && this.tail == -1){
            this.head++;
            this.tail++;
            nums[this.tail] = value;
        } else {
            this.tail = (this.tail + 1) % nums.length;
            this.nums[this.tail] = value;
        }
        this.size++;
        return true;
    }
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.nums.length;
        }
        this.size--;
        return true;
    }
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.nums[this.head];
        }
    }
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.nums[this.tail];
        }
    }
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (this.size == this.nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
```

# [633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers)
## 题目描述

<p>给定一个非负整数&nbsp;<code>c</code>&nbsp;，你要判断是否存在两个整数 <code>a</code> 和 <code>b</code>，使得&nbsp;a<sup>2</sup> + b<sup>2</sup> = c。</p>
<p><strong>示例1:</strong></p>
<pre>
<strong>输入:</strong> 5
<strong>输出:</strong> True
<strong>解释:</strong> 1 * 1 + 2 * 2 = 5
</pre>

<p>&nbsp;</p>
<p><strong>示例2:</strong></p>
<pre>
<strong>输入:</strong> 3
<strong>输出:</strong> False
</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int s = i * i + j * j;
            if (s < c) {
                ++i;
            } else if (s > c) {
                --j;
            } else {
                return true;
            }
        }
        return false;
    }
}
```

# [637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree)
## 题目描述

<p>给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>
    3
   / \
  9  20
    /  \
   15   7
<strong>输出:</strong> [3, 14.5, 11]
<strong>解释:</strong>
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
</pre>

<p><strong>注意：</strong></p>
<ol>
	<li>节点值的范围在32位有符号整数范围内。</li>
</ol>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return null;
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0, size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
```

# [645. 错误的集合](https://leetcode-cn.com/problems/set-mismatch)
## 题目描述

<p>集合 <code>S</code> 包含从1到&nbsp;<code>n</code>&nbsp;的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。</p>
<p>给定一个数组 <code>nums</code> 代表了集合 <code>S</code> 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> nums = [1,2,2,4]
<strong>输出:</strong> [2,3]
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>给定数组的长度范围是&nbsp;[2, 10000]。</li>
	<li>给定的数组是无序的。</li>
</ol>

## 解法
首先使用 1 到 n 的所有数字做异或运算，然后再与数组中的所有数字异或，得到的值就是缺失数字与重复的数字异或的结果。
接着计算中这个值中其中一个非零的位 pos。然后 pos 位是否为 1，将 nums 数组的元素分成两部分，分别异或；接着将 `1~n` 的元素也分成两部分，分别异或。得到的两部分结果分别为 a,b，即是缺失数字与重复数字。
最后判断数组中是否存在 a 或 b，若存在 a，说明重复数字是 a，返回 `[a,b]`，否则返回 `[b,a]`。

### **Java**
```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        for (int i = 1, n = nums.length; i < n + 1; ++i) {
            res ^= i;
        }
        int pos = 0;
        while ((res & 1) == 0) {
            res >>= 1;
            ++pos;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if (((num >> pos) & 1) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1, n = nums.length; i < n + 1; ++i) {
            if (((i >> pos) & 1) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        for (int num : nums) {
            if (num == a) {
                return new int[]{a, b};
            }
        }
        return new int[]{b, a};
    }
}
```

# [650. 只有两个键的键盘](https://leetcode-cn.com/problems/2-keys-keyboard)
## 题目描述

<p>最初在一个记事本上只有一个字符 &#39;A&#39;。你每次可以对这个记事本进行两种操作：</p>
<ol>
	<li><code>Copy All</code> (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。</li>
	<li><code>Paste</code> (粘贴) : 你可以粘贴你<strong>上一次</strong>复制的字符。</li>
</ol>
<p>给定一个数字&nbsp;<code>n</code>&nbsp;。你需要使用最少的操作次数，在记事本中打印出<strong>恰好</strong>&nbsp;<code>n</code>&nbsp;个 &#39;A&#39;。输出能够打印出&nbsp;<code>n</code>&nbsp;个 &#39;A&#39; 的最少操作次数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 3
<strong>输出:</strong> 3
<strong>解释:</strong>
最初, 我们只有一个字符 &#39;A&#39;。
第 1 步, 我们使用 <strong>Copy All</strong> 操作。
第 2 步, 我们使用 <strong>Paste </strong>操作来获得 &#39;AA&#39;。
第 3 步, 我们使用 <strong>Paste</strong> 操作来获得 &#39;AAA&#39;。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li><code>n</code>&nbsp;的取值范围是 [1, 1000] 。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; n > 1; ++i) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
```

# [652. 寻找重复的子树](https://leetcode-cn.com/problems/find-duplicate-subtrees)
## 题目描述

<p>给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意<strong>一棵</strong>的根结点即可。</p>
<p>两棵树重复是指它们具有相同的结构以及相同的结点值。</p>
<p><strong>示例 1：</strong></p>
<pre>        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
</pre>

<p>下面是两个重复的子树：</p>
<pre>      2
     /
    4
</pre>

<p>和</p>
<pre>    4
</pre>

<p>因此，你需要以列表的形式返回上述重复子树的根结点。</p>

## 解法

### **Java**
```java
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<>(), res);
        return res;
    }
    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "";
        }
        String s = root.val + "_" + dfs(root.left, map, res) + "_" + dfs(root.right, map, res);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }
}
```


# [669. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree)
## 题目描述

<p>给定一个二叉搜索树，同时给定最小边界<code>L</code>&nbsp;和最大边界&nbsp;<code>R</code>。通过修剪二叉搜索树，使得所有节点的值在<code>[L, R]</code>中 (R&gt;=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 
    1
   / \
  0   2
  L = 1
  R = 2
<strong>输出:</strong> 
    1
      \
       2
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 
    3
   / \
  0   4
   \
    2
   /
  1
  L = 1
  R = 3
<strong>输出:</strong> 
      3
     / 
   2   
  /
 1
</pre>


## 解法

### **Java**
```java
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
```

# [671. 二叉树中第二小的节点](https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree)
## 题目描述

<p>给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为&nbsp;<code>2</code>&nbsp;或&nbsp;<code>0</code>。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。&nbsp;</p>
<p>给出这样的一个二叉树，你需要输出所有节点中的<strong>第二小的值。</strong>如果第二小的值不存在的话，输出 -1 <strong>。</strong></p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 
    2
   / \
  2   5
     / \
    5   7
<strong>输出:</strong> 5
<strong>说明:</strong> 最小的值是 2 ，第二小的值是 5 。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 
    2
   / \
  2   2
<strong>输出:</strong> -1
<strong>说明:</strong> 最小的值是 2, 但是不存在第二小的值。
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int limit = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val != root.val) {
                limit = Math.min(limit, node.val - root.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return limit == Integer.MAX_VALUE ? -1 : root.val + limit;
    }
}
```

# [673. 最长递增子序列的个数](https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence)
## 题目描述

<p>给定一个未排序的整数数组，找到最长递增子序列的个数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,3,5,4,7]
<strong>输出:</strong> 2
<strong>解释:</strong> 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [2,2,2,2,2]
<strong>输出:</strong> 5
<strong>解释:</strong> 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
</pre>

<p><strong>注意:</strong>&nbsp;给定的数组长度不超过 2000 并且结果一定是32位有符号整数。</p>

## 解法

### **Java**
```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] f = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(f, 1);
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        f[i] = f[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        f[i] += f[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == max) {
                res += f[i];
            }
        }
        return res;
    }
}
```

# [674. 最长连续递增序列](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence)
## 题目描述

<p>给定一个未经排序的整数数组，找到最长且<strong>连续</strong>的的递增序列。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,3,5,4,7]
<strong>输出:</strong> 3
<strong>解释:</strong> 最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [2,2,2,2,2]
<strong>输出:</strong> 1
<strong>解释:</strong> 最长连续递增序列是 [2], 长度为1。
</pre>

<p><strong>注意：</strong>数组长度不会超过10000。</p>

## 解法
设 f(i) 表示将数组第 i 项作为最长连续递增子序列的最后一项时，子序列的长度。
那么，当 `nums[i - 1] < nums[i]`，即 `f(i) = f(i - 1)` + 1，否则 `f(i) = 1`。问题转换为求 f(i) (`i ∈ [0 ,n - 1]`) 的最大值。
由于 f(i) 只与前一项 f(i - 1) 有关联，故不需要用一个数组存储。

### **Java**
```java
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n;
        if ((n = nums.length) < 2) return n;
        int res = 1, f = 1;
        for (int i = 1; i < n; ++i) {
            f = 1 + (nums[i - 1] < nums[i] ? f : 0);
            res = Math.max(res, f);
        }
        return res;
    }
}
```


# [682. 棒球比赛](https://leetcode-cn.com/problems/baseball-game)
## 题目描述

<p>你现在是棒球比赛记录员。<br>
给定一个字符串列表，每个字符串可以是以下四种类型之一：<br>
1.<code>整数</code>（一轮的得分）：直接表示您在本轮中获得的积分数。<br>
2. <code>&quot;+&quot;</code>（一轮的得分）：表示本轮获得的得分是前两轮<code>有效</code>&nbsp;回合得分的总和。<br>
3. <code>&quot;D&quot;</code>（一轮的得分）：表示本轮获得的得分是前一轮<code>有效</code>&nbsp;回合得分的两倍。<br>
4. <code>&quot;C&quot;</code>（一个操作，这不是一个回合的分数）：表示您获得的最后一个<code>有效</code>&nbsp;回合的分数是无效的，应该被移除。<br>
<br>
每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。<br>
你需要返回你在所有回合中得分的总和。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [&quot;5&quot;,&quot;2&quot;,&quot;C&quot;,&quot;D&quot;,&quot;+&quot;]
<strong>输出:</strong> 30
<strong>解释:</strong> 
第1轮：你可以得到5分。总和是：5。
第2轮：你可以得到2分。总和是：7。
操作1：第2轮的数据无效。总和是：5。
第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
第4轮：你可以得到5 + 10 = 15分。总数是：30。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [&quot;5&quot;,&quot;-2&quot;,&quot;4&quot;,&quot;C&quot;,&quot;D&quot;,&quot;9&quot;,&quot;+&quot;,&quot;+&quot;]
<strong>输出:</strong> 27
<strong>解释:</strong> 
第1轮：你可以得到5分。总和是：5。
第2轮：你可以得到-2分。总数是：3。
第3轮：你可以得到4分。总和是：7。
操作1：第3轮的数据无效。总数是：3。
第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
第5轮：你可以得到9分。总数是：8。
第6轮：你可以得到-4 + 9 = 5分。总数是13。
第7轮：你可以得到9 + 5 = 14分。总数是27。
</pre>

<p><strong>注意：</strong></p>
<ul>
	<li>输入列表的大小将介于1和1000之间。</li>
	<li>列表中的每个整数都将介于-30000和30000之间。</li>
</ul>

## 解法
栈实现。

### **Java**
```java
class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek() << 1);
            } else if ("+".equals(op)) {
                Integer a = stack.pop();
                Integer b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        for (Integer score : stack) {
            res += score;
        }
        return res;
    }
}
```

# [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection)
## 题目描述

<p>在本问题中, 树指的是一个连通且无环的<strong>无向</strong>图。</p>
<p>输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。</p>
<p>结果图是一个以<code>边</code>组成的二维数组。每一个<code>边</code>的元素是一对<code>[u, v]</code>&nbsp;，满足&nbsp;<code>u &lt; v</code>，表示连接顶点<code>u</code>&nbsp;和<code>v</code>的<strong>无向</strong>图的边。</p>
<p>返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边&nbsp;<code>[u, v]</code> 应满足相同的格式&nbsp;<code>u &lt; v</code>。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> [[1,2], [1,3], [2,3]]
<strong>输出:</strong> [2,3]
<strong>解释:</strong> 给定的无向图为:
  1
 / \
2 - 3
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入:</strong> [[1,2], [2,3], [3,4], [1,4], [1,5]]
<strong>输出:</strong> [1,4]
<strong>解释:</strong> 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
</pre>

<p><strong>注意:</strong></p>
<ul>
	<li>输入的二维数组大小在 3 到 1000。</li>
	<li>二维数组中的整数在1到N之间，其中N是输入数组的大小。</li>
</ul>
<p><strong>更新(2017-09-26):</strong><br>
我们已经重新检查了问题描述及测试用例，明确图是<em><strong>无向&nbsp;</strong></em>图。对于有向图详见<strong><a href="https://leetcodechina.com/problems/redundant-connection-ii/description/">冗余连接II</a>。</strong>对于造成任何不便，我们深感歉意。</p>

## 解法

### **Java**
```java
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = i;
        }
        for (int[] edge : edges) {
            int p = find(edge[0], f);
            int q = find(edge[1], f);
            if (p == q) {
                return edge;
            }
            f[p] = q;
        }
        return null;
    }
    private int find(int x, int[] f) {
        if (f[x] != x) {
            f[x] = find(f[x], f);
        }
        return f[x];
    }
}
```

# [687. 最长同值路径](https://leetcode-cn.com/problems/longest-univalue-path)
## 题目描述

<p>给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。</p>
<p><strong>注意</strong>：两个节点之间的路径长度由它们之间的边数表示。</p>
<p><strong>示例 1:</strong></p>
<p>输入:</p>
<pre>
              5
             / \
            4   5
           / \   \
          1   1   5
</pre>

<p>输出:</p>
<pre>
2
</pre>

<p><strong>示例 2:</strong></p>
<p>输入:</p>
<pre>
              1
             / \
            4   5
           / \   \
          4   4   5
</pre>

<p>输出:</p>
<pre>
2
</pre>

<p><strong>注意:</strong> 给定的二叉树不超过10000个结点。&nbsp;树的高度不超过1000。</p>

## 解法

### **Java**
```java
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        left = root.left != null && root.left.val == root.val ? left + 1 : 0;
        right = root.right != null && root.right.val == root.val ? right + 1 : 0;
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }
}
```

# [690. 员工的重要性](https://leetcode-cn.com/problems/employee-importance)
## 题目描述

<p>给定一个保存员工信息的数据结构，它包含了员工<strong>唯一的id</strong>，<strong>重要度&nbsp;</strong>和 <strong>直系下属的id</strong>。</p>
<p>比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于<strong>并不是直系</strong>下属，因此没有体现在员工1的数据结构中。</p>
<p>现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
<strong>输出:</strong> 11
<strong>解释:</strong>
员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>一个员工最多有一个<strong>直系</strong>领导，但是可以有多个<strong>直系</strong>下属</li>
	<li>员工数量不超过2000。</li>
</ol>

## 解法

### **Java**
```java
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
import java.util.*;
class Solution {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		return dfs(map, id);
	}
	private int dfs(Map<Integer, Employee> map, int id) {
		Employee employee = map.get(id);
		int ans = employee.importance;
		for (Integer subordinate : employee.subordinates) {
			ans += dfs(map, subordinate);
		}
		return ans;
	}
}
```

# [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island)
## 题目描述

<p>给定一个包含了一些 <code>0</code> 和 <code>1</code> 的非空二维数组&nbsp;<code>grid</code> 。</p>
<p>一个&nbsp;<strong>岛屿</strong>&nbsp;是由一些相邻的&nbsp;<code>1</code>&nbsp;(代表土地) 构成的组合，这里的「相邻」要求两个 <code>1</code> 必须在水平或者竖直方向上相邻。你可以假设&nbsp;<code>grid</code> 的四个边缘都被 <code>0</code>（代表水）包围着。</p>
<p>找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 <code>0</code> 。)</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,<strong>1</strong>,0,<strong>1</strong>,0,0],
 [0,1,0,0,1,1,0,0,<strong>1</strong>,<strong>1</strong>,<strong>1</strong>,0,0],
 [0,0,0,0,0,0,0,0,0,0,<strong>1</strong>,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
</pre>

<p>对于上面这个给定矩阵应返回&nbsp;<code>6</code>。注意答案不应该是 <code>11</code> ，因为岛屿只能包含水平或垂直的四个方向的 <code>1</code> 。</p>
<p><strong>示例 2:</strong></p>
<pre>[[0,0,0,0,0,0,0,0]]</pre>

<p>对于上面这个给定的矩阵, 返回&nbsp;<code>0</code>。</p>
<p>&nbsp;</p>
<p><strong>注意:&nbsp;</strong>给定的矩阵<code>grid</code>&nbsp;的长度和宽度都不超过 50。</p>

## 解法

### **Java**
```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(grid, i, j, m, n));
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 
            + dfs(grid, i - 1, j, m, n)
            + dfs(grid, i + 1, j, m, n)
            + dfs(grid, i, j - 1, m, n)
            + dfs(grid, i, j + 1, m, n);
    }
}
```

# [696. 计数二进制子串](https://leetcode-cn.com/problems/count-binary-substrings)
## 题目描述

<p>给定一个字符串&nbsp;<code>s</code>，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。</p>
<p>重复出现的子串要计算它们出现的次数。</p>
<p><strong>示例 1 :</strong></p>
<pre>
<strong>输入:</strong> &quot;00110011&quot;
<strong>输出:</strong> 6
<strong>解释:</strong> 有6个子串具有相同数量的连续1和0：&ldquo;0011&rdquo;，&ldquo;01&rdquo;，&ldquo;1100&rdquo;，&ldquo;10&rdquo;，&ldquo;0011&rdquo; 和 &ldquo;01&rdquo;。
请注意，一些重复出现的子串要计算它们出现的次数。
另外，&ldquo;00110011&rdquo;不是有效的子串，因为所有的0（和1）没有组合在一起。
</pre>

<p><strong>示例 2 :</strong></p>
<pre>
<strong>输入:</strong> &quot;10101&quot;
<strong>输出:</strong> 4
<strong>解释:</strong> 有4个子串：&ldquo;10&rdquo;，&ldquo;01&rdquo;，&ldquo;10&rdquo;，&ldquo;01&rdquo;，它们具有相同数量的连续1和0。
</pre>

<p><strong>注意：</strong></p>
<ul>
	<li><code>s.length</code>&nbsp;在1到50,000之间。</li>
	<li><code>s</code>&nbsp;只包含&ldquo;0&rdquo;或&ldquo;1&rdquo;字符。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int countBinarySubstrings(String s) {
		     int[] group = new int[s.length()];
		     int k = 0;
		     Arrays.fill(group , 0);
		     group[0] = 1;
		     for(int i = 1;i < s.length();i++) {
		    	   if(s.charAt(i) == s.charAt(i-1))
		    		   group[k]++;
		    	   else
		    		   group[++k] = 1;
		     }
		     int ans = 0;
		     for(int i = 1;i < s.length() && group[i] != 0;i++) {
		    	   ans += Math.min(group[i-1], group[i]);
		     }
		     return ans;
    }
}
```

# [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array)
## 题目描述

<p>给定一个非空且只包含非负数的整数数组&nbsp;<code>nums</code>, 数组的度的定义是指数组里任一元素出现频数的最大值。</p>
<p>你的任务是找到与&nbsp;<code>nums</code>&nbsp;拥有相同大小的度的最短连续子数组，返回其长度。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1, 2, 2, 3, 1]
<strong>输出:</strong> 2
<strong>解释:</strong> 
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [1,2,2,3,1,4,2]
<strong>输出:</strong> 6
</pre>

<p><strong>注意:</strong></p>
<ul>
	<li><code>nums.length</code>&nbsp;在1到50,000区间范围内。</li>
	<li><code>nums[i]</code>&nbsp;是一个在0到49,999范围内的整数。</li>
</ul>

## 解法
遍历数组，用哈希表记录数组每个元素出现的次数，以及首次、末次出现的位置。然后遍历哈希表，获取元素出现次数最多（可能有多个）且首末位置差最小的数。

### **Java**
```java
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> mapper = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (mapper.containsKey(nums[i])) {
                int[] arr = mapper.get(nums[i]);
                ++arr[0];
                arr[2] = i;
            } else {
                int[] arr = new int[]{1, i, i};
                mapper.put(nums[i], arr);
            }
        }
        int maxDegree = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : mapper.entrySet()) {
            int[] arr = entry.getValue();
            if (maxDegree < arr[0]) {
                maxDegree = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxDegree == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }
}
```

# [700. 二叉搜索树中的搜索](https://leetcode-cn.com/problems/search-in-a-binary-search-tree)
## 题目描述

<p>给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。</p>
<p>例如，</p>
<pre>
给定二叉搜索树:
        4
       / \
      2   7
     / \
    1   3
和值: 2
</pre>

<p>你应该返回如下子树:</p>
<pre>
      2     
     / \   
    1   3
</pre>

<p>在上述示例中，如果要找的值是 <code>5</code>，但因为没有节点值为 <code>5</code>，我们应该返回 <code>NULL</code>。</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
```

# [701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree)
## 题目描述

<p>给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。</p>
<p>注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。</p>
<p>例如,&nbsp;</p>
<pre>
给定二叉搜索树:
        4
       / \
      2   7
     / \
    1   3
和 插入的值: 5
</pre>

<p>你可以返回这个二叉搜索树:</p>
<pre>
         4
       /   \
      2     7
     / \   /
    1   3 5
</pre>

<p>或者这个树也是有效的:</p>
<pre>
         5
       /   \
      2     7
     / \   
    1   3
         \
          4
</pre>


## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
      }
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        // return the unchanged pointer
        return root;
    }
}
```

# [703. 数据流中的第 K 大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream)
## 题目描述

<p>设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。</p>
<p>你的&nbsp;<code>KthLargest</code>&nbsp;类需要一个同时接收整数&nbsp;<code>k</code> 和整数数组<code>nums</code>&nbsp;的构造器，它包含数据流中的初始元素。每次调用&nbsp;<code>KthLargest.add</code>，返回当前数据流中第K大的元素。</p>
<p><strong>示例:</strong></p>
<pre>
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);&nbsp; &nbsp;// returns 4
kthLargest.add(5);&nbsp; &nbsp;// returns 5
kthLargest.add(10);&nbsp; // returns 5
kthLargest.add(9);&nbsp; &nbsp;// returns 8
kthLargest.add(4);&nbsp; &nbsp;// returns 8
</pre>

<p><strong>说明: </strong><br />
你可以假设&nbsp;<code>nums</code>&nbsp;的长度&ge;&nbsp;<code>k-1</code>&nbsp;且<code>k</code> &ge;&nbsp;1。</p>

## 解法

### **Java**
```java
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int size;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        size = k;
        for (int e : nums) {
            add(e);
        }
    }
    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.add(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
```

# [704. 二分查找](https://leetcode-cn.com/problems/binary-search)
## 题目描述

<p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的 <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>
<p><br>
<strong>示例 1:</strong></p>
<pre><strong>输入:</strong> <code>nums</code> = [-1,0,3,5,9,12], <code>target</code> = 9
<strong>输出:</strong> 4
<strong>解释:</strong> 9 出现在 <code>nums</code> 中并且下标为 4
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> <code>nums</code> = [-1,0,3,5,9,12], <code>target</code> = 2
<strong>输出:</strong> -1
<strong>解释:</strong> 2 不存在 <code>nums</code> 中因此返回 -1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li>
	<li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li>
	<li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >>> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
```

# [707. 设计链表](https://leetcode-cn.com/problems/design-linked-list)
## 题目描述

<p>设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：<code>val</code>&nbsp;和&nbsp;<code>next</code>。<code>val</code>&nbsp;是当前节点的值，<code>next</code>&nbsp;是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性&nbsp;<code>prev</code>&nbsp;以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。</p>
<p>在链表类中实现这些功能：</p>
<ul>
	<li>get(index)：获取链表中第&nbsp;<code>index</code>&nbsp;个节点的值。如果索引无效，则返回<code>-1</code>。</li>
	<li>addAtHead(val)：在链表的第一个元素之前添加一个值为&nbsp;<code>val</code>&nbsp;的节点。插入后，新节点将成为链表的第一个节点。</li>
	<li>addAtTail(val)：将值为&nbsp;<code>val</code> 的节点追加到链表的最后一个元素。</li>
	<li>addAtIndex(index,val)：在链表中的第&nbsp;<code>index</code>&nbsp;个节点之前添加值为&nbsp;<code>val</code>&nbsp; 的节点。如果&nbsp;<code>index</code>&nbsp;等于链表的长度，则该节点将附加到链表的末尾。如果 <code>index</code> 大于链表长度，则不会插入节点。如果<code>index</code>小于0，则在头部插入节点。</li>
	<li>deleteAtIndex(index)：如果索引&nbsp;<code>index</code> 有效，则删除链表中的第&nbsp;<code>index</code> 个节点。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre>MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-&gt; 2-&gt; 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-&gt; 3
linkedList.get(1);            //返回3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>所有<code>val</code>值都在&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
	<li>操作次数将在&nbsp;&nbsp;<code>[1, 1000]</code>&nbsp;之内。</li>
	<li>请不要使用内置的 LinkedList 库。</li>
</ul>

## 解法
定义虚拟头结点 dummy，count 记录当前链表结点个数。

### **Java**
```java
class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this(val, null);
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private ListNode dummy;
    private int count;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy = new ListNode(0);
        count = 0;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        ListNode cur = dummy.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(count, val);
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > count) {
            return;
        }
        ListNode pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = new ListNode(val, pre.next);
        ++count;
    }
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }
        ListNode pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        ListNode t = pre.next;
        pre.next = t.next;
        t.next = null;
        --count;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

# [718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray)
## 题目描述

<p>给两个整数数组&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;，返回两个数组中公共的、长度最长的子数组的长度。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong>
A: [1,2,3,2,1]
B: [3,2,1,4,7]
<strong>输出:</strong> 3
<strong>解释:</strong> 
长度最长的公共子数组是 [3, 2, 1]。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>1 &lt;= len(A), len(B) &lt;= 1000</li>
	<li>0 &lt;= A[i], B[i] &lt; 100</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1;i <= A.length;i++) {
            for (int j = 1;j <= B.length;j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
```

# [724. 寻找数组的中心索引](https://leetcode-cn.com/problems/find-pivot-index)
## 题目描述

<p>给定一个整数类型的数组&nbsp;<code>nums</code>，请编写一个能够返回数组<strong>&ldquo;中心索引&rdquo;</strong>的方法。</p>
<p>我们是这样定义数组<strong>中心索引</strong>的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。</p>
<p>如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> 
nums = [1, 7, 3, 6, 5, 6]
<strong>输出:</strong> 3
<strong>解释:</strong> 
索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
同时, 3 也是第一个符合要求的中心索引。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> 
nums = [1, 2, 3]
<strong>输出:</strong> -1
<strong>解释:</strong> 
数组中不存在满足此条件的中心索引。</pre>

<p><strong>说明:</strong></p>
<ul>
	<li><code>nums</code> 的长度范围为&nbsp;<code>[0, 10000]</code>。</li>
	<li>任何一个&nbsp;<code>nums[i]</code> 将会是一个范围在&nbsp;<code>[-1000, 1000]</code>的整数。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (s << 1 == sum - nums[i]) {
                return i;
            }
            s += nums[i];
        }
        return -1;
    }
}
```

# [725. 分隔链表](https://leetcode-cn.com/problems/split-linked-list-in-parts)
## 题目描述

<p>给定一个头结点为 <code>root</code> 的链表, 编写一个函数以将链表分隔为 <code>k</code> 个连续的部分。</p>
<p>每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。</p>
<p>这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。</p>
<p>返回一个符合上述规则的链表的列表。</p>
<p>举例： 1-&gt;2-&gt;3-&gt;4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]</p>
<p><strong>示例 1：</strong></p>
<pre>
<strong>输入:</strong> 
root = [1, 2, 3], k = 5
<strong>输出:</strong> [[1],[2],[3],[],[]]
<strong>解释:</strong>
输入输出各部分都应该是链表，而不是数组。
例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
</pre>

<p><strong>示例 2：</strong></p>
<pre>
<strong>输入:</strong> 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
<strong>输出:</strong> [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
<strong>解释:</strong>
输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
</pre>

<p>&nbsp;</p>
<p><strong>提示:</strong></p>
<ul>
	<li><code>root</code> 的长度范围：&nbsp;<code>[0, 1000]</code>.</li>
	<li>输入的每个节点的大小范围：<code>[0, 999]</code>.</li>
	<li><code>k</code>&nbsp;的取值范围：&nbsp;<code>[1, 50]</code>.</li>
</ul>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int n = getLength(root);
        int len = n / k, left = n % k;
        ListNode pre = null;    // 记录链尾
        for (int i = 0; i < k && root != null; ++i) {
            res[i] = root;
            int step = len;
            if (left > 0) {
                --left;
                ++step;
            }
            for (int j = 0; j < step; ++j) {
                pre = root;
                root = root.next;
            }
            pre.next = null;    // 断链
        }
        return res;
    }
    private int getLength(ListNode root) {
        int res = 0;
        while (root != null) {
            ++res;
            root = root.next;
        }
        return res;
    }
}
```

# [739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures)
## 题目描述

<p>根据每日 <code>气温</code> 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用&nbsp;<code>0</code> 来代替。</p>
<p>例如，给定一个列表&nbsp;<code>temperatures = [73, 74, 75, 71, 69, 72, 76, 73]</code>，你的输出应该是&nbsp;<code>[1, 1, 4, 2, 1, 1, 0, 0]</code>。</p>
<p><strong>提示：</strong><code>气温</code> 列表长度的范围是&nbsp;<code>[1, 30000]</code>。每个气温的值的均为华氏度，都是在&nbsp;<code>[30, 100]</code>&nbsp;范围内的整数。</p>

## 解法
栈实现，栈存放 T 中元素的的下标 i，结果用数组 res 存储。
遍历 T，遍历到 `T[i]` 时：
- 若栈不为空，并且栈顶元素小于 `T[i]` 时，弹出栈顶元素 j，并且 `res[j]` 赋值为 `i - j`。
- 然后将 i 压入栈中。
  最后返回结果数组 res 即可。

### **Java**
```java
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && T[s.peek()] < T[i]) {
                int j = s.pop();
                res[j] = i - j;
            }
            s.push(i);
        }
        return res;
    }
}
```

# [740. 删除与获得点数](https://leetcode-cn.com/problems/delete-and-earn)
## 题目描述

<p>给定一个整数数组&nbsp;<code>nums</code>&nbsp;，你可以对它进行一些操作。</p>
<p>每次操作中，选择任意一个&nbsp;<code>nums[i]</code>&nbsp;，删除它并获得&nbsp;<code>nums[i]</code>&nbsp;的点数。之后，你必须删除<strong>每个</strong>等于&nbsp;<code>nums[i] - 1</code>&nbsp;或&nbsp;<code>nums[i] + 1</code>&nbsp;的元素。</p>
<p>开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> nums = [3, 4, 2]
<strong>输出:</strong> 6
<strong>解释:</strong> 
删除 4 来获得 4 个点数，因此 3 也被删除。
之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>
<strong>输入:</strong> nums = [2, 2, 3, 3, 3, 4]
<strong>输出:</strong> 9
<strong>解释:</strong> 
删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
总共获得 9 个点数。
</pre>

<p><strong>注意:</strong></p>
<ul>
	<li><code>nums</code>的长度最大为<code>20000</code>。</li>
	<li>每个整数<code>nums[i]</code>的大小都在<code>[1, 10000]</code>范围内。</li>
</ul>

## 解法

核心思路: **一个数字要么不选，要么全选**
首先计算出每个数字的总和 sums，并维护两个 dp 数组：select 和 nonSelect
- sums[i] 代表值为 i 的元素总和
- select[i] 代表如果选数字 i，从 0 处理到 i 的最大和
- nonSelect[i] 代表如果不选数字 i，从 0 处理到 i 的最大和
  那么我们有以下逻辑：
- 如果选 i，那么 i-1 肯定不能选；
- 如果不选 i，那么 i-1 选不选都可以，因此我们选择其中较大的选法
```
select[i] = nonSelect[i-1] + sums[i];
nonSelect[i] = Math.max(select[i-1], nonSelect[i-1]);
```
### **Java**
```java
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sums = new int[10010];
        int[] select = new int[10010];
        int[] nonSelect = new int[10010];
        int maxV = 0;
        for (int x : nums) {
            sums[x] += x;
            maxV = Math.max(maxV, x);
        }
        for (int i = 1; i <= maxV; i++) {
            select[i] = nonSelect[i - 1] + sums[i];
            nonSelect[i] = Math.max(select[i - 1], nonSelect[i - 1]);
        }
        return Math.max(select[maxV], nonSelect[maxV]);
    }
}
```

# [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs)
## 题目描述

<p>数组的每个索引做为一个阶梯，第&nbsp;<code>i</code>个阶梯对应着一个非负数的体力花费值&nbsp;<code>cost[i]</code>(索引从0开始)。</p>
<p>每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。</p>
<p>您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>
<strong>输入:</strong> cost = [10, 15, 20]
<strong>输出:</strong> 15
<strong>解释:</strong> 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>
<pre>
<strong>输入:</strong> cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
<strong>输出:</strong> 6
<strong>解释:</strong> 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
</pre>

<p><strong>注意：</strong></p>
<ol>
	<li><code>cost</code>&nbsp;的长度将会在&nbsp;<code>[2, 1000]</code>。</li>
	<li>每一个&nbsp;<code>cost[i]</code> 将会是一个Integer类型，范围为&nbsp;<code>[0, 999]</code>。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, cur = 0;
        for (int i = 1, n = cost.length; i < n; ++i) {
            int t = Math.min(cost[i] + cur, cost[i - 1] + pre);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}
```

# [752. 打开转盘锁](https://leetcode-cn.com/problems/open-the-lock)
## 题目描述

<p>你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： <code>&#39;0&#39;, &#39;1&#39;, &#39;2&#39;, &#39;3&#39;, &#39;4&#39;, &#39;5&#39;, &#39;6&#39;, &#39;7&#39;, &#39;8&#39;, &#39;9&#39;</code> 。每个拨轮可以自由旋转：例如把 <code>&#39;9&#39;</code> 变为&nbsp; <code>&#39;0&#39;</code><font color="#333333" face="Helvetica Neue, Helvetica, Arial, sans-serif"><span style="background-color:#ffffff; font-size:14px">，</span></font><code>&#39;0&#39;</code> 变为 <code>&#39;9&#39;</code> 。每次旋转都只能旋转一个拨轮的一位数字。</p>
<p>锁的初始数字为 <code>&#39;0000&#39;</code> ，一个代表四个拨轮的数字的字符串。</p>
<p>列表 <code>deadends</code> 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。</p>
<p>字符串 <code>target</code> 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入：</strong>deadends = [&quot;0201&quot;,&quot;0101&quot;,&quot;0102&quot;,&quot;1212&quot;,&quot;2002&quot;], target = &quot;0202&quot;
<strong>输出：</strong>6
<strong>解释：</strong>
可能的移动序列为 &quot;0000&quot; -&gt; &quot;1000&quot; -&gt; &quot;1100&quot; -&gt; &quot;1200&quot; -&gt; &quot;1201&quot; -&gt; &quot;1202&quot; -&gt; &quot;0202&quot;。
注意 &quot;0000&quot; -&gt; &quot;0001&quot; -&gt; &quot;0002&quot; -&gt; &quot;0102&quot; -&gt; &quot;0202&quot; 这样的序列是不能解锁的，
因为当拨动到 &quot;0102&quot; 时这个锁就会被锁定。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> deadends = [&quot;8888&quot;], target = &quot;0009&quot;
<strong>输出：</strong>1
<strong>解释：</strong>
把最后一位反向旋转一次即可 &quot;0000&quot; -&gt; &quot;0009&quot;。
</pre>

<p><strong>示例 3:</strong></p>
<pre>
<strong>输入:</strong> deadends = [&quot;8887&quot;,&quot;8889&quot;,&quot;8878&quot;,&quot;8898&quot;,&quot;8788&quot;,&quot;8988&quot;,&quot;7888&quot;,&quot;9888&quot;], target = &quot;8888&quot;
<strong>输出：</strong>-1
<strong>解释：
</strong>无法旋转到目标数字且不被锁定。
</pre>

<p><strong>示例 4:</strong></p>
<pre>
<strong>输入:</strong> deadends = [&quot;0000&quot;], target = &quot;8888&quot;
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>死亡列表 <code>deadends</code> 的长度范围为 <code>[1, 500]</code>。</li>
	<li>目标数字 <code>target</code> 不会在 <code>deadends</code> 之中。</li>
	<li>每个 <code>deadends</code> 和 <code>target</code> 中的字符串的数字会在 10,000 个可能的情况 <code>&#39;0000&#39;</code> 到 <code>&#39;9999&#39;</code> 中产生。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> begins = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        int step = 0;
        begins.add("0000");
        if (begins.contains(target)) {
            return step;
        }
        while (!begins.isEmpty()) {
            if (begins.contains(target)) {
                return step;
            }
            Set<String> temp = new HashSet<>();
            for (String cur : begins) {
                if (deads.contains(cur)) {
                    continue;
                }
                deads.add(cur);
                StringBuffer s = new StringBuffer(cur);
                for (int i = 0; i < 4; i++) {
                    char c = s.charAt(i);
                    String s1 = s.substring(0, i) + (char)(c == '9' ? '0' : c + 1) + s.substring(i + 1, 4);
                    String s2 = s.substring(0, i) + (char)(c == '0' ? '9' : c - 1) + s.substring(i + 1, 4);
                    if (!deads.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!deads.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            step ++;
            begins = temp;
        }
        return -1;
    }
}
```

# [760. 找出变位映射](https://leetcode-cn.com/problems/find-anagram-mappings)
## 题目描述

<p>给定两个列表 <code>A</code>and <code>B</code>，并且 <code>B</code> 是 <code>A</code> 的变位（即 <code>B</code> 是由 <code>A</code> 中的元素随机排列后组成的新列表）。</p>
<p>我们希望找出一个从 <code>A</code> 到 <code>B</code> 的索引映射 <code>P</code> 。一个映射 <code>P[i] = j</code> 指的是列表 <code>A</code> 中的第 <code>i</code> 个元素出现于列表 <code>B</code> 中的第 <code>j</code> 个元素上。</p>
<p>列表 <code>A</code> 和 <code>B</code> 可能出现重复元素。如果有多于一种答案，输出任意一种。</p>
<p>例如，给定</p>
<pre>A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
</pre>

<p> </p>
<p>需要返回</p>
<pre>[1, 4, 3, 2, 0]
</pre>

<p><code>P[0] = 1</code> ，因为 <code>A</code> 中的第 <code>0</code> 个元素出现于 <code>B[1]</code>，而且 <code>P[1] = 4</code> 因为 <code>A</code> 中第 <code>1</code> 个元素出现于 <code>B[4]</code>，以此类推。</p>
<p> </p>
<p><strong>注：</strong></p>
<ol>
	<li><code>A, B</code> 有相同的长度，范围为 <code>[1, 100]</code>。</li>
	<li><code>A[i], B[i]</code> 都是范围在 <code>[0, 10^5]</code> 的整数。</li>
</ol>
<p> </p>

## 解法

### **Java**
```java
import java.util.*;
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] res = new int[B.length];
        int j = 0;
        for (int k : A) {
            res[j++] = map.get(k);
        }
        return res;
    }
}
```

# [766. 托普利茨矩阵](https://leetcode-cn.com/problems/toeplitz-matrix)
## 题目描述

<p>如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是<em>托普利茨矩阵</em>。</p>
<p>给定一个&nbsp;<code>M x N</code>&nbsp;的矩阵，当且仅当它是<em>托普利茨矩阵</em>时返回&nbsp;<code>True</code>。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> 
matrix = [
&nbsp; [1,2,3,4],
&nbsp; [5,1,2,3],
&nbsp; [9,5,1,2]
]
<strong>输出:</strong> True
<strong>解释:</strong>
在上述矩阵中, 其对角线为:
&quot;[9]&quot;, &quot;[5, 5]&quot;, &quot;[1, 1, 1]&quot;, &quot;[2, 2, 2]&quot;, &quot;[3, 3]&quot;, &quot;[4]&quot;。
各条对角线上的所有元素均相同, 因此答案是True。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>
matrix = [
&nbsp; [1,2],
&nbsp; [2,2]
]
<strong>输出:</strong> False
<strong>解释: 
</strong>对角线&quot;[1, 2]&quot;上的元素不同。
</pre>

<p><strong>说明:</strong></p>
<ol>
	<li>&nbsp;<code>matrix</code>&nbsp;是一个包含整数的二维数组。</li>
	<li><code>matrix</code>&nbsp;的行数和列数均在&nbsp;<code>[1, 20]</code>范围内。</li>
	<li><code>matrix[i][j]</code>&nbsp;包含的整数在&nbsp;<code>[0, 99]</code>范围内。</li>
</ol>
<p><strong>进阶:</strong></p>
<ol>
	<li>如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？</li>
	<li>如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？</li>
</ol>

## 解法
遍历矩阵，若出现元素与其左上角的元素不等的情况，返回 `false`。

### **Java**
```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

# [771. 宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones)
## 题目描述

<p>&nbsp;给定字符串<code>J</code>&nbsp;代表石头中宝石的类型，和字符串&nbsp;<code>S</code>代表你拥有的石头。&nbsp;<code>S</code>&nbsp;中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。</p>
<p><code>J</code>&nbsp;中的字母不重复，<code>J</code>&nbsp;和&nbsp;<code>S</code>中的所有字符都是字母。字母区分大小写，因此<code>&quot;a&quot;</code>和<code>&quot;A&quot;</code>是不同类型的石头。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> J = &quot;aA&quot;, S = &quot;aAAbbbb&quot;
<strong>输出:</strong> 3
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> J = &quot;z&quot;, S = &quot;ZZ&quot;
<strong>输出:</strong> 0
</pre>

<p><strong>注意:</strong></p>
<ul>
	<li><code>S</code>&nbsp;和&nbsp;<code>J</code>&nbsp;最多含有50个字母。</li>
	<li>&nbsp;<code>J</code>&nbsp;中的字符不重复。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        int res = 0;
        for (char ch : S.toCharArray()) {
            res += (set.contains(ch) ? 1 : 0);
        }
        return res;
    }
}
```

# [777. 在 LR 字符串中交换相邻字符](https://leetcode-cn.com/problems/swap-adjacent-in-lr-string)
## 题目描述

<p>在一个由 <code>&#39;L&#39;</code> , <code>&#39;R&#39;</code> 和 <code>&#39;X&#39;</code> 三个字符组成的字符串（例如<code>&quot;RXXLRXRXL&quot;</code>）中进行移动操作。一次移动操作指用一个<code>&quot;LX&quot;</code>替换一个<code>&quot;XL&quot;</code>，或者用一个<code>&quot;XR&quot;</code>替换一个<code>&quot;RX&quot;</code>。现给定起始字符串<code>start</code>和结束字符串<code>end</code>，请编写代码，当且仅当存在一系列移动操作使得<code>start</code>可以转换成<code>end</code>时， 返回<code>True</code>。</p>
<p><strong>示例 :</strong></p>
<pre>
<strong>输入:</strong> start = &quot;RXXLRXRXL&quot;, end = &quot;XRLXXRRLX&quot;
<strong>输出:</strong> True
<strong>解释:</strong>
我们可以通过以下几步将start转换成end:
RXXLRXRXL -&gt;
XRXLRXRXL -&gt;
XRLXRXRXL -&gt;
XRLXXRRXL -&gt;
XRLXXRRLX
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li><code>1 &lt;= len(start) = len(end) &lt;= 10000</code>。</li>
	<li><code>start</code>和<code>end</code>中的字符串仅限于<code>&#39;L&#39;</code>, <code>&#39;R&#39;</code>和<code>&#39;X&#39;</code>。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (true) {
            while (i < start.length() && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                ++j;
            }
            if (i == start.length() && j == start.length()) {
                return true;
            }
            if (i == start.length() || j == start.length() || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R'  && i > j) {
                return false;
            }
            ++i;
            ++j;
        }
    }
}
```

# [783. 二叉搜索树结点最小距离](https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes)
## 题目描述

<p>给定一个二叉搜索树的根结点&nbsp;<code>root</code>，返回树中任意两节点的差的最小值。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> root = [4,2,6,1,3,null,null]
<strong>输出:</strong> 1
<strong>解释:</strong>
注意，root是树结点对象(TreeNode object)，而不是数组。
给定的树 [4,2,6,1,3,null,null] 可表示为下图:
          4
        /   \
      2      6
     / \    
    1   3  
最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。</pre>

<p>&nbsp;</p>
<p><strong>注意：</strong></p>
<ol>
	<li>二叉树的大小范围在 <code>2</code> 到&nbsp;<code>100</code>。</li>
	<li>二叉树总是有效的，每个节点的值都是整数，且不重复。</li>
	<li>本题与 530：<a href="https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/">https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/</a> 相同</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int minDiffInBST(TreeNode root) {
        TreeNode[] pre = new TreeNode[1];
        int[] res = new int[]{Integer.MAX_VALUE};
        dfs(root, pre, res);
        return res[0];
    }
    private void dfs(TreeNode root, TreeNode[] pre, int[] res) {
        if (root == null) {
            return;
        }
        dfs(root.left, pre, res);
        if (pre[0] != null) {
            res[0] = Math.min(res[0], root.val - pre[0].val);
        }
        pre[0] = root;
        dfs(root.right, pre, res);
    }
}
```

# [784. 字母大小写全排列](https://leetcode-cn.com/problems/letter-case-permutation)
## 题目描述

<p>给定一个字符串<code>S</code>，通过将字符串<code>S</code>中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。</p>
<pre>
<strong>示例:</strong>
<strong>输入:</strong> S = &quot;a1b2&quot;
<strong>输出:</strong> [&quot;a1b2&quot;, &quot;a1B2&quot;, &quot;A1b2&quot;, &quot;A1B2&quot;]
<strong>输入:</strong> S = &quot;3z4&quot;
<strong>输出:</strong> [&quot;3z4&quot;, &quot;3Z4&quot;]
<strong>输入:</strong> S = &quot;12345&quot;
<strong>输出:</strong> [&quot;12345&quot;]
</pre>

<p><strong>注意：</strong></p>
<ul>
	<li><code>S</code>&nbsp;的长度不超过<code>12</code>。</li>
	<li><code>S</code>&nbsp;仅由数字和字母组成。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] cs = S.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(cs, 0, res);
        return res;
    }
    private void dfs(char[] cs, int i, List<String> res) {
        if (i == cs.length) {
            res.add(String.valueOf(cs));
            return;
        }
        dfs(cs, i + 1, res);
        if (cs[i] >= 'A') {
            cs[i] ^= 32;
            dfs(cs, i + 1, res);
        }
    }
}
```

# [814. 二叉树剪枝](https://leetcode-cn.com/problems/binary-tree-pruning)
## 题目描述

<p>给定二叉树根结点&nbsp;<code>root</code>&nbsp;，此外树的每个结点的值要么是 0，要么是 1。</p>
<p>返回移除了所有不包含 1 的子树的原二叉树。</p>
<p>( 节点 X 的子树为 X 本身，以及所有 X 的后代。)</p>
<pre>
<strong>示例1:</strong>
<strong>输入:</strong> [1,null,0,0,1]
<strong>输出: </strong>[1,null,0,null,1]

<strong>解释:</strong>
只有红色节点满足条件&ldquo;所有不包含 1 的子树&rdquo;。
右图为返回的答案。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235750282.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre>
<strong>示例2:</strong>
<strong>输入:</strong> [1,0,1,0,0,0,1]
<strong>输出: </strong>[1,null,1,null,1]
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235810938.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre>
<strong>示例3:</strong>
<strong>输入:</strong> [1,1,0,1,1,0,1,0]
<strong>输出: </strong>[1,1,0,1,1,null,1]
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235833197.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>说明: </strong></p>
<ul>
	<li>给定的二叉树最多有&nbsp;<code>100</code>&nbsp;个节点。</li>
	<li>每个节点的值只会为&nbsp;<code>0</code> 或&nbsp;<code>1</code>&nbsp;。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }
}
```

# [817. 链表组件](https://leetcode-cn.com/problems/linked-list-components)
## 题目描述

<p>给定一个链表（链表结点包含一个整型值）的头结点&nbsp;<code>head</code>。</p>
<p>同时给定列表&nbsp;<code>G</code>，该列表是上述链表中整型值的一个子集。</p>
<p>返回列表&nbsp;<code>G</code>&nbsp;中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表&nbsp;<code>G</code>&nbsp;中）构成的集合。</p>
<p><strong>示例&nbsp;1：</strong></p>
<pre>
<strong>输入:</strong> 
head: 0-&gt;1-&gt;2-&gt;3
G = [0, 1, 3]
<strong>输出:</strong> 2
<strong>解释:</strong> 
链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。</pre>

<p><strong>示例 2：</strong></p>
<pre>
<strong>输入:</strong> 
head: 0-&gt;1-&gt;2-&gt;3-&gt;4
G = [0, 3, 1, 4]
<strong>输出:</strong> 2
<strong>解释:</strong> 
链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。</pre>

<p><strong>注意:</strong></p>
<ul>
	<li>如果&nbsp;<code>N</code>&nbsp;是给定链表&nbsp;<code>head</code>&nbsp;的长度，<code>1 &lt;= N &lt;= 10000</code>。</li>
	<li>链表中每个结点的值所在范围为&nbsp;<code>[0, N - 1]</code>。</li>
	<li><code>1 &lt;= G.length &lt;= 10000</code></li>
	<li><code>G</code> 是链表中所有结点的值的一个子集.</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : G) {
            set.add(val);
        }
        int n = G.length;
        ListNode cur = head;
        int cnt = 0;
        boolean flag = false;
        while (cur != null) {
            while (cur != null && set.contains(cur.val)) {
                flag = true;
                cur = cur.next;
            }
            if (flag) {
                ++cnt;
                flag = false;
            }
            
            if (cur != null) {
                cur = cur.next;
            }
        }
        return cnt;
    }
}
```


# [832. 翻转图像](https://leetcode-cn.com/problems/flipping-an-image)
## 题目描述

<p>给定一个二进制矩阵&nbsp;<code>A</code>，我们想先水平翻转图像，然后反转图像并返回结果。</p>
<p>水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转&nbsp;<code>[1, 1, 0]</code>&nbsp;的结果是&nbsp;<code>[0, 1, 1]</code>。</p>
<p>反转图片的意思是图片中的&nbsp;<code>0</code>&nbsp;全部被&nbsp;<code>1</code>&nbsp;替换，&nbsp;<code>1</code>&nbsp;全部被&nbsp;<code>0</code>&nbsp;替换。例如，反转&nbsp;<code>[0, 1, 1]</code>&nbsp;的结果是&nbsp;<code>[1, 0, 0]</code>。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入: </strong>[[1,1,0],[1,0,1],[0,0,0]]
<strong>输出: </strong>[[1,0,0],[0,1,0],[1,1,1]]
<strong>解释:</strong> 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入: </strong>[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
<strong>输出: </strong>[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
<strong>解释:</strong> 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
</pre>

<p><strong>说明:</strong></p>
<ul>
	<li><code>1 &lt;= A.length = A[0].length &lt;= 20</code></li>
	<li><code>0 &lt;= A[i][j]&nbsp;&lt;=&nbsp;1</code></li>
</ul>

## 解法
遍历矩阵每一行，利用双指针 p, q 进行水平交换翻转，顺便反转图像（1 变 0，0 变 1：`1 ^ 1` = 0，`0 ^ 1` = 1）。

### **Java**
```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; ++i) {
            int p = 0, q = n - 1;
            while (p < q) {
                int t = A[i][p] ^ 1;
                A[i][p] = A[i][q] ^ 1;
                A[i][q] = t;
                ++p;
                --q;
            }
            if (p == q) {
                A[i][p] ^= 1;
            }
        }
        return A;
    }
}
```

# [852. 山脉数组的峰顶索引](https://leetcode-cn.com/problems/peak-index-in-a-mountain-array)
## 题目描述

<p>我们把符合下列属性的数组&nbsp;<code>A</code>&nbsp;称作山脉：</p>
<ul>
	<li><code>A.length &gt;= 3</code></li>
	<li>存在 <code>0 &lt; i&nbsp;&lt; A.length - 1</code> 使得<code>A[0] &lt; A[1] &lt; ... A[i-1] &lt; A[i] &gt; A[i+1] &gt; ... &gt; A[A.length - 1]</code></li>
</ul>
<p>给定一个确定为山脉的数组，返回任何满足&nbsp;<code>A[0] &lt; A[1] &lt; ... A[i-1] &lt; A[i] &gt; A[i+1] &gt; ... &gt; A[A.length - 1]</code>&nbsp;的 <code>i</code>&nbsp;的值。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[0,1,0]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[0,2,1,0]
<strong>输出：</strong>1</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>3 &lt;= A.length &lt;= 10000</code></li>
	<li>0 &lt;= A[i] &lt;= 10^6</li>
	<li>A 是如上定义的山脉</li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (A[mid] > A[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
```

# [856. 括号的分数](https://leetcode-cn.com/problems/score-of-parentheses)
## 题目描述

<p>给定一个平衡括号字符串&nbsp;<code>S</code>，按下述规则计算该字符串的分数：</p>
<ul>
	<li><code>()</code> 得 1 分。</li>
	<li><code>AB</code> 得&nbsp;<code>A + B</code>&nbsp;分，其中 A 和 B 是平衡括号字符串。</li>
	<li><code>(A)</code> 得&nbsp;<code>2 * A</code>&nbsp;分，其中 A 是平衡括号字符串。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入： </strong>&quot;()&quot;
<strong>输出： </strong>1
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入： </strong>&quot;(())&quot;
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入： </strong>&quot;()()&quot;
<strong>输出： </strong>2
</pre>

<p><strong>示例&nbsp;4：</strong></p>
<pre><strong>输入： </strong>&quot;(()(()))&quot;
<strong>输出： </strong>6
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>S</code>&nbsp;是平衡括号字符串，且只含有&nbsp;<code>(</code>&nbsp;和&nbsp;<code>)</code>&nbsp;。</li>
	<li><code>2 &lt;= S.length &lt;= 50</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int scoreOfParentheses(String S) {
        int res = 0;
        for (int i = 0, d = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                ++d;
            } else {
                --d;
                if (S.charAt(i - 1) == '(') {
                    res += 1 << d;
                }
            }
        }
        return res;
    }
}
```


# [860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change)
## 题目描述

<p>在柠檬水摊上，每一杯柠檬水的售价为&nbsp;<code>5</code>&nbsp;美元。</p>
<p>顾客排队购买你的产品，（按账单 <code>bills</code> 支付的顺序）一次购买一杯。</p>
<p>每位顾客只买一杯柠檬水，然后向你付 <code>5</code> 美元、<code>10</code> 美元或 <code>20</code> 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 <code>5</code> 美元。</p>
<p>注意，一开始你手头没有任何零钱。</p>
<p>如果你能给每位顾客正确找零，返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code>&nbsp;。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[5,5,5,10,20]
<strong>输出：</strong>true
<strong>解释：
</strong>前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[5,5,10]
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[10,10]
<strong>输出：</strong>false
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>[5,5,10,10,20]
<strong>输出：</strong>false
<strong>解释：</strong>
前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
由于不是每位顾客都得到了正确的找零，所以答案是 false。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>0 &lt;= bills.length &lt;= 10000</code></li>
	<li><code>bills[i]</code>&nbsp;不是&nbsp;<code>5</code>&nbsp;就是&nbsp;<code>10</code>&nbsp;或是&nbsp;<code>20</code>&nbsp;</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                ++fives;
            } else if (bill == 10) {
                ++tens;
                if (--fives < 0) {
                    return false;
                }
            } else {
                if (tens >= 1 && fives >= 1) {
                    --tens;
                    --fives;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
```


# [872. 叶子相似的树](https://leetcode-cn.com/problems/leaf-similar-trees)
## 题目描述

<p>请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个&nbsp;<em>叶值序列</em> 。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235922403.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>举个例子，如上图所示，给定一颗叶值序列为&nbsp;<code>(6, 7, 4, 9, 8)</code>&nbsp;的树。</p>
<p>如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是&nbsp;<em>叶相似&nbsp;</em>的。</p>
<p>如果给定的两个头结点分别为&nbsp;<code>root1</code> 和&nbsp;<code>root2</code>&nbsp;的树是叶相似的，则返回&nbsp;<code>true</code>；否则返回 <code>false</code> 。</p>
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给定的两颗树可能会有&nbsp;<code>1</code>&nbsp;到&nbsp;<code>100</code>&nbsp;个结点。</li>
</ul>

## 解法
深度优先搜索。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        return l1.equals(l2);
    }
    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }
}
```

# [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas)
## 题目描述

<p>珂珂喜欢吃香蕉。这里有&nbsp;<code>N</code>&nbsp;堆香蕉，第 <code>i</code> 堆中有&nbsp;<code>piles[i]</code>&nbsp;根香蕉。警卫已经离开了，将在&nbsp;<code>H</code>&nbsp;小时后回来。</p>
<p>珂珂可以决定她吃香蕉的速度&nbsp;<code>K</code>&nbsp;（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 <code>K</code> 根。如果这堆香蕉少于 <code>K</code> 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。&nbsp;&nbsp;</p>
<p>珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。</p>
<p>返回她可以在 <code>H</code> 小时内吃掉所有香蕉的最小速度 <code>K</code>（<code>K</code> 为整数）。</p>
<p>&nbsp;</p>
<ul>
</ul>
<p><strong>示例 1：</strong></p>
<pre><strong>输入: </strong>piles = [3,6,7,11], H = 8
<strong>输出: </strong>4
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入: </strong>piles = [30,11,23,4,20], H = 5
<strong>输出: </strong>30
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入: </strong>piles = [30,11,23,4,20], H = 6
<strong>输出: </strong>23
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= piles.length &lt;= 10^4</code></li>
	<li><code>piles.length &lt;= H &lt;= 10^9</code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10^9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int mid = l + r >>> 1;
            if (check(piles, H, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    private boolean check(int[] piles, int h, int k) {
        int cnt = 0;
        for (int pile : piles) {
            cnt += (pile - 1) / k + 1;
        }
        return cnt <= h;
    }
}
```

# [876. 链表的中间结点](https://leetcode-cn.com/problems/middle-of-the-linked-list)
## 题目描述

<p>给定一个带有头结点&nbsp;<code>head</code>&nbsp;的非空单链表，返回链表的中间结点。</p>
<p>如果有两个中间结点，则返回第二个中间结点。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,2,3,4,5]
<strong>输出：</strong>此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入：</strong>[1,2,3,4,5,6]
<strong>输出：</strong>此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给定链表的结点数介于&nbsp;<code>1</code>&nbsp;和&nbsp;<code>100</code>&nbsp;之间。</li>
</ul>

## 解法

### **Java**
```java
public ListNode middleNode(ListNode head) {
    ListNode low = head, first = head;
    while (first != null && first.next != null) {
        low = low.next;
        first = first.next.next;
    }
    return low;
}
```


# [883. 三维形体投影面积](https://leetcode-cn.com/problems/projection-area-of-3d-shapes)
## 题目描述

<p>在&nbsp;<code>N&nbsp;*&nbsp;N</code>&nbsp;的网格中，我们放置了一些与 x，y，z 三轴对齐的&nbsp;<code>1 * 1 * 1</code>&nbsp;立方体。</p>
<p>每个值&nbsp;<code>v = grid[i][j]</code>&nbsp;表示 <code>v</code>&nbsp;个正方体叠放在单元格&nbsp;<code>(i, j)</code>&nbsp;上。</p>
<p>现在，我们查看这些立方体在 xy、yz&nbsp;和 zx&nbsp;平面上的<em>投影</em>。</p>
<p>投影就像影子，将三维形体映射到一个二维平面上。</p>
<p>在这里，从顶部、前面和侧面看立方体时，我们会看到&ldquo;影子&rdquo;。</p>
<p>返回所有三个投影的总面积。</p>
<p>&nbsp;</p>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[[2]]
<strong>输出：</strong>5
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[[1,2],[3,4]]
<strong>输出：</strong>17
<strong>解释：</strong>
这里有该形体在三个轴对齐平面上的三个投影(&ldquo;阴影部分&rdquo;)。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224235942953.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[[1,0],[0,2]]
<strong>输出：</strong>8
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>[[1,1,1],[1,0,1],[1,1,1]]
<strong>输出：</strong>14
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>[[2,2,2],[2,1,2],[2,2,2]]
<strong>输出：</strong>21
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= grid.length = grid[0].length&nbsp;&lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 50</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res += grid[i][j] > 0 ? 1 : 0;
            }
        }
        for (int i = 0; i < n; ++i) {
            int max = 0;
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        for (int j = 0; j < n; ++j) {
            int max = 0;
            for (int i = 0; i < n; ++i) {
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        return res;
    }
}
```



# [892. 三维形体的表面积](https://leetcode-cn.com/problems/surface-area-of-3d-shapes)
## 题目描述

<p>在&nbsp;<code>N&nbsp;*&nbsp;N</code>&nbsp;的网格上，我们放置一些&nbsp;<code>1 * 1 * 1&nbsp;</code>&nbsp;的立方体。</p>
<p>每个值&nbsp;<code>v = grid[i][j]</code>&nbsp;表示&nbsp;<code>v</code>&nbsp;个正方体叠放在对应单元格&nbsp;<code>(i, j)</code>&nbsp;上。</p>
<p>请你返回最终形体的表面积。</p>
<p>&nbsp;</p>
<ul>
</ul>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[[2]]
<strong>输出：</strong>10
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[[1,2],[3,4]]
<strong>输出：</strong>34
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[[1,0],[0,2]]
<strong>输出：</strong>16
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>[[1,1,1],[1,0,1],[1,1,1]]
<strong>输出：</strong>32
</pre>

<p><strong>示例&nbsp;5：</strong></p>
<pre><strong>输入：</strong>[[2,2,2],[2,1,2],[2,2,2]]
<strong>输出：</strong>46
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= N &lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 50</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res += 2 + grid[i][j] * 4;
                    if (i > 0) {
                        res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return res;
    }
}
```

# [897. 递增顺序查找树](https://leetcode-cn.com/problems/increasing-order-search-tree)
## 题目描述

<p>给你一个树，请你 <strong>按中序遍历</strong> 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。</p>
<p>&nbsp;</p>
<p><strong>示例 ：</strong></p>
<pre><strong>输入：</strong>[5,3,6,2,4,null,8,1,null,null,null,7,9]
       5
      / \
    3    6
   / \    \
  2   4    8
&nbsp;/        / \ 
1        7   9
<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 1
&nbsp; \
&nbsp;  2
&nbsp;   \
&nbsp;    3
&nbsp;     \
&nbsp;      4
&nbsp;       \
&nbsp;        5
&nbsp;         \
&nbsp;          6
&nbsp;           \
&nbsp;            7
&nbsp;             \
&nbsp;              8
&nbsp;               \
                 9  </pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>给定树中的结点数介于 <code>1</code> 和&nbsp;<code>100</code> 之间。</li>
	<li>每个结点都有一个从 <code>0</code> 到 <code>1000</code> 范围内的唯一整数值。</li>
</ol>

## 解法
递归将左子树、右子树转换为左、右链表 left 和 right。然后将左链表 left 的最后一个结点的 right 指针指向 root，root 的 right 指针指向右链表 right，并将 root 的 left 指针值为空。
同[面试题 17.12. BiNode](/lcci/17.12.BiNode/README.md)。

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);
        if (left == null) {
            root.right = right;
            return root;
        }
        TreeNode res = left;
        while (left != null && left.right != null) left = left.right;
        left.right = root;
        root.right = right;
        root.left = null;
        return res;
    }
}
```

# [898. 子数组按位或操作](https://leetcode-cn.com/problems/bitwise-ors-of-subarrays)
## 题目描述

<p>我们有一个非负整数数组&nbsp;<code>A</code>。</p>
<p>对于每个（连续的）子数组&nbsp;<code>B =&nbsp;[A[i], A[i+1], ..., A[j]]</code> （&nbsp;<code>i &lt;= j</code>），我们对&nbsp;<code>B</code>&nbsp;中的每个元素进行按位或操作，获得结果&nbsp;<code>A[i] | A[i+1] | ... | A[j]</code>。</p>
<p>返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[0]
<strong>输出：</strong>1
<strong>解释：</strong>
只有一个可能的结果 0 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[1,1,2]
<strong>输出：</strong>3
<strong>解释：</strong>
可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
产生的结果为 1，1，2，1，3，3 。
有三个唯一值，所以答案是 3 。
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入：</strong>[1,2,4]
<strong>输出：</strong>6
<strong>解释：</strong>
可能的结果是 1，2，3，4，6，以及 7 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 50000</code></li>
	<li><code>0 &lt;= A[i] &lt;= 10^9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int subarrayBitwiseORs(int[] A) {
        int maxVal = Arrays.stream(A).max().getAsInt();
        int mask = (Integer.highestOneBit(maxVal) << 1) - 1;
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < A.length; ++i) {
            int val = A[i];
            res.add(val);
            for (int j = i - 1; j >= 0 && val != mask; --j) {
                val |= A[j];
                res.add(val);
            }
        }
        return res.size();
    }
}
```

# [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array)
## 题目描述

<p>给定一个整数数组&nbsp;<code>nums</code>，将该数组升序排列。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre>
<strong>输入：</strong>[5,2,3,1]
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>
<pre>
<strong>输入：</strong>[5,1,1,2,0,0]
<strong>输出：</strong>[0,0,1,1,2,5]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
	<li><code>-50000 &lt;= A[i] &lt;= 50000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    void createHeap(int[] data, int n, int h) {
        int i = h;
        int j = 2 * i + 1;
        int temp = data[i];
        while (j < n) {
            if (j + 1 < n && data[j] < data[j + 1]) j++;
            if (temp > data[j]) {
                break;
            } else {
                data[i] = data[j];
                i = j;
                j = 2 * i + 1;
            }
        }
        data[i] = temp;
    }
    void initHeap(int[] data, int n) {
        for (int i = (n - 2) / 2; i > -1; i--) {
            createHeap(data, n, i);
        }
    }
    void heapSort(int[] data, int n) {
        initHeap(data, n);
        for (int i = n - 1;i > -1;i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            createHeap(data, i, 0);
        }
    }
    public int[] sortArray(int[] nums) {
        heapSort(nums, nums.length);
        return nums;
    }
}
```

# [918. 环形子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-circular-subarray)
## 题目描述

<p>给定一个由整数数组 <code>A</code>&nbsp;表示的<strong>环形数组 <code>C</code></strong>，求 <code><strong>C</strong></code>&nbsp;的非空子数组的最大可能和。</p>
<p>在此处，<em>环形数组</em>意味着数组的末端将会与开头相连呈环状。（形式上，当<code>0 &lt;= i &lt; A.length</code>&nbsp;时&nbsp;<code>C[i] = A[i]</code>，而当&nbsp;<code>i &gt;= 0</code>&nbsp;时&nbsp;<code>C[i+A.length] = C[i]</code>）</p>
<p>此外，子数组最多只能包含固定缓冲区 <code>A</code>&nbsp;中的每个元素一次。（形式上，对于子数组&nbsp;<code>C[i], C[i+1], ..., C[j]</code>，不存在&nbsp;<code>i &lt;= k1, k2 &lt;= j</code>&nbsp;其中&nbsp;<code>k1 % A.length&nbsp;= k2 % A.length</code>）</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,-2,3,-2]
<strong>输出：</strong>3
<strong>解释：</strong>从子数组 [3] 得到最大和 3
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[5,-3,5]
<strong>输出：</strong>10
<strong>解释：</strong>从子数组 [5,5] 得到最大和 5 + 5 = 10
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[3,-1,2,-1]
<strong>输出：</strong>4
<strong>解释：</strong>从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>[3,-2,2,-3]
<strong>输出：</strong>3
<strong>解释：</strong>从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>[-2,-3,-1]
<strong>输出：</strong>-1
<strong>解释：</strong>从子数组 [-1] 得到最大和 -1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>-30000 &lt;= A[i] &lt;= 30000</code></li>
	<li><code>1 &lt;= A.length &lt;= 30000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int tot = 0;
        int curMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int curMin = 0;
        int minSum = Integer.MAX_VALUE;
        for (int x : A) {
            tot += x;
            curMax = Math.max(curMax + x, x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + x, x);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, tot - minSum) : maxSum;
    }
}
```

# [922. 按奇偶排序数组 II](https://leetcode-cn.com/problems/sort-array-by-parity-ii)
## 题目描述

<p>给定一个非负整数数组&nbsp;<code>A</code>， A 中一半整数是奇数，一半整数是偶数。</p>
<p>对数组进行排序，以便当&nbsp;<code>A[i]</code> 为奇数时，<code>i</code>&nbsp;也是奇数；当&nbsp;<code>A[i]</code>&nbsp;为偶数时， <code>i</code> 也是偶数。</p>
<p>你可以返回任何满足上述条件的数组作为答案。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[4,2,5,7]
<strong>输出：</strong>[4,5,2,7]
<strong>解释：</strong>[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>2 &lt;= A.length &lt;= 20000</code></li>
	<li><code>A.length % 2 == 0</code></li>
	<li><code>0 &lt;= A[i] &lt;= 1000</code></li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1, length = A.length;
        for (int i = 0; i < length; i += 2) {
            if ((A[i] & 1) != 0) {
                while ((A[j] & 1) != 0)  j += 2;
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
```

# [929. 独特的电子邮件地址](https://leetcode-cn.com/problems/unique-email-addresses)
## 题目描述

<p>每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。</p>
<p>例如，在&nbsp;<code>alice@leetcode.com</code>中，&nbsp;<code>alice</code>&nbsp;是本地名称，而&nbsp;<code>leetcode.com</code>&nbsp;是域名。</p>
<p>除了小写字母，这些电子邮件还可能包含 <code>&#39;.&#39;</code> 或 <code>&#39;+&#39;</code>。</p>
<p>如果在电子邮件地址的<strong>本地名称</strong>部分中的某些字符之间添加句点（<code>&#39;.&#39;</code>），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，<code>&quot;alice.z@leetcode.com&rdquo;</code> 和 <code>&ldquo;alicez@leetcode.com&rdquo;</code>&nbsp;会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）</p>
<p>如果在<strong>本地名称</strong>中添加加号（<code>&#39;+&#39;</code>），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 <code>m.y+name@email.com</code> 将转发到 <code>my@email.com</code>。 （同样，此规则不适用于域名。）</p>
<p>可以同时使用这两个规则。</p>
<p>给定电子邮件列表 <code>emails</code>，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[&quot;test.email+alex@leetcode.com&quot;,&quot;test.e.mail+bob.cathy@leetcode.com&quot;,&quot;testemail+david@lee.tcode.com&quot;]
<strong>输出：</strong>2
<strong>解释：</strong>实际收到邮件的是 &quot;testemail@leetcode.com&quot; 和 &quot;testemail@lee.tcode.com&quot;。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= emails[i].length&nbsp;&lt;= 100</code></li>
	<li><code>1 &lt;= emails.length &lt;= 100</code></li>
	<li>每封 <code>emails[i]</code> 都包含有且仅有一个 <code>&#39;@&#39;</code> 字符。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf('@');
            String local = email.substring(0, index);
            String domain = email.substring(index);
            index = local.indexOf('+');
            if (index != -1) {
                local = local.substring(0, index);
            }
            local = local.replace(".", "");
            set.add(local + domain);
        }
        return set.size();
    }
}
```

# [930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum)
## 题目描述

<p>在由若干&nbsp;<code>0</code>&nbsp;和&nbsp;<code>1</code>&nbsp; 组成的数组&nbsp;<code>A</code>&nbsp;中，有多少个和为 <code>S</code>&nbsp;的<strong>非空</strong>子数组。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>A = [1,0,1,0,1], S = 2
<strong>输出：</strong>4
<strong>解释：</strong>
如下面黑体所示，有 4 个满足题目要求的子数组：
[<strong>1,0,1</strong>,0,1]
[<strong>1,0,1,0</strong>,1]
[1,<strong>0,1,0,1</strong>]
[1,0,<strong>1,0,1</strong>]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>A.length &lt;= 30000</code></li>
	<li><code>0 &lt;= S &lt;= A.length</code></li>
	<li><code>A[i]</code>&nbsp;为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] map = new int[A.length + 1];
        map[0] = 1;
        int res = 0;
        int s = 0;
        for (int a : A) {
            s += a;
            if (s >= S) {
                res += map[s - S];
            }
            ++map[s];
        }
        return res;
    }
}
```

# [931. 下降路径最小和](https://leetcode-cn.com/problems/minimum-falling-path-sum)
## 题目描述

<p>给定一个<strong>方形</strong>整数数组&nbsp;<code>A</code>，我们想要得到通过 <code>A</code> 的<em>下降路径</em>的<strong>最小</strong>和。</p>
<p>下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>12
<strong>解释：</strong>
可能的下降路径有：
</pre>

<ul>
	<li><code>[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]</code></li>
	<li><code>[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]</code></li>
	<li><code>[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]</code></li>
</ul>
<p>和最小的下降路径是&nbsp;<code>[1,4,7]</code>，所以答案是&nbsp;<code>12</code>。</p>
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length == A[0].length &lt;= 100</code></li>
	<li><code>-100 &lt;= A[i][j] &lt;= 100</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int min = A[i - 1][j];
                if (j > 0) min = Math.min(min, A[i - 1][j - 1]);
                if (j < n - 1) min = Math.min(min, A[i - 1][j + 1]);
                A[i][j] += min;
            }
        }
        return Arrays.stream(A[m - 1]).min().getAsInt();
    }
}
```

# [933. 最近的请求次数](https://leetcode-cn.com/problems/number-of-recent-calls)
## 题目描述

<p>写一个&nbsp;<code>RecentCounter</code>&nbsp;类来计算最近的请求。</p>
<p>它只有一个方法：<code>ping(int t)</code>，其中&nbsp;<code>t</code>&nbsp;代表以毫秒为单位的某个时间。</p>
<p>返回从 3000 毫秒前到现在的&nbsp;<code>ping</code>&nbsp;数。</p>
<p>任何处于&nbsp;<code>[t - 3000, t]</code>&nbsp;时间范围之内的 <code>ping</code>&nbsp;都将会被计算在内，包括当前（指 <code>t</code>&nbsp;时刻）的 <code>ping</code>。</p>
<p>保证每次对 <code>ping</code> 的调用都使用比之前更大的 <code>t</code> 值。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>inputs = [&quot;RecentCounter&quot;,&quot;ping&quot;,&quot;ping&quot;,&quot;ping&quot;,&quot;ping&quot;], inputs = [[],[1],[100],[3001],[3002]]
<strong>输出：</strong>[null,1,2,3,3]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>每个测试用例最多调用&nbsp;<code>10000</code>&nbsp;次&nbsp;<code>ping</code>。</li>
	<li>每个测试用例会使用严格递增的 <code>t</code> 值来调用&nbsp;<code>ping</code>。</li>
	<li>每次调用 <code>ping</code>&nbsp;都有&nbsp;<code>1 &lt;= t &lt;= 10^9</code>。</li>
</ol>
<p>&nbsp;</p>

## 解法
在第 1、100、3001、3002 这四个时间点分别进行了 ping 请求， 在 3001 秒的时候， 它前面的 3000 秒指的是区间 `[1,3001]`， 所以一共是有 `1、100、3001` 三个请求， t = 3002 的前 3000 秒指的是区间 `[2,3002]`, 所以有 `100、3001、3002` 三次请求。
可以用队列实现。每次将 t 进入队尾，同时从队头开始依次移除小于 `t-3000` 的元素。然后返回队列的大小 `q.size()` 即可。

### **Java**
```java
class RecentCounter {
    private Deque<Integer> q;
    public RecentCounter() {
        q = new ArrayDeque<>();
    }
    public int ping(int t) {
        q.offerLast(t);
        while (q.peekFirst() < t - 3000) {
            q.pollFirst();
        }
        return q.size();
    }
}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```

# [938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst)
## 题目描述

<p>给定二叉搜索树的根结点&nbsp;<code>root</code>，返回 <code>L</code> 和 <code>R</code>（含）之间的所有结点的值的和。</p>
<p>二叉搜索树保证具有唯一的值。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>root = [10,5,15,3,7,null,18], L = 7, R = 15
<strong>输出：</strong>32
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入：</strong>root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树中的结点数量最多为&nbsp;<code>10000</code>&nbsp;个。</li>
	<li>最终的答案保证小于&nbsp;<code>2^31</code>。</li>
</ol>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int res = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return res;
        }
        
        if (root.val < L) {
            rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            rangeSumBST(root.left, L, R);
        } else {
            res += root.val;
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
        }
        return res;
        
    }
}
```

# [946. 验证栈序列](https://leetcode-cn.com/problems/validate-stack-sequences)
## 题目描述

<p>给定&nbsp;<code>pushed</code>&nbsp;和&nbsp;<code>popped</code>&nbsp;两个序列，每个序列中的 <strong>值都不重复</strong>，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 <code>true</code>；否则，返回 <code>false</code>&nbsp;。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
<strong>输出：</strong>true
<strong>解释：</strong>我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -&gt; 4,
push(5), pop() -&gt; 5, pop() -&gt; 3, pop() -&gt; 2, pop() -&gt; 1
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
<strong>输出：</strong>false
<strong>解释：</strong>1 不能在 2 之前弹出。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>0 &lt;= pushed.length == popped.length &lt;= 1000</code></li>
	<li><code>0 &lt;= pushed[i], popped[i] &lt; 1000</code></li>
	<li><code>pushed</code>&nbsp;是&nbsp;<code>popped</code>&nbsp;的排列。</li>
</ol>

## 解法

### **Java**
```java
import java.util.*;
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, k = 0;
        while (i < popped.length) {
            if (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i ++;
            } else {
                if (k < pushed.length) {
                    stack.push(pushed[k ++]);
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}
```


# [955. 删列造序 II](https://leetcode-cn.com/problems/delete-columns-to-make-sorted-ii)
## 题目描述

<p>给定由&nbsp;<code>N</code>&nbsp;个小写字母字符串组成的数组&nbsp;<code>A</code>，其中每个字符串长度相等。</p>
<p>选取一个删除索引序列，对于&nbsp;<code>A</code>&nbsp;中的每个字符串，删除对应每个索引处的字符。</p>
<p>比如，有&nbsp;<code>A = [&quot;abcdef&quot;, &quot;uvwxyz&quot;]</code>，删除索引序列&nbsp;<code>{0, 2, 3}</code>，删除后&nbsp;<code>A</code>&nbsp;为<code>[&quot;bef&quot;, &quot;vyz&quot;]</code>。</p>
<p>假设，我们选择了一组删除索引&nbsp;<code>D</code>，那么在执行删除操作之后，最终得到的数组的元素是按 <strong>字典序</strong>（<code>A[0] &lt;= A[1] &lt;= A[2] ... &lt;= A[A.length - 1]</code>）排列的，然后请你返回&nbsp;<code>D.length</code>&nbsp;的最小可能值。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[&quot;ca&quot;,&quot;bb&quot;,&quot;ac&quot;]
<strong>输出：</strong>1
<strong>解释： </strong>
删除第一列后，A = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;]。
现在 A 中元素是按字典排列的 (即，A[0] &lt;= A[1] &lt;= A[2])。
我们至少需要进行 1 次删除，因为最初 A 不是按字典序排列的，所以答案是 1。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[&quot;xc&quot;,&quot;yb&quot;,&quot;za&quot;]
<strong>输出：</strong>0
<strong>解释：</strong>
A 的列已经是按字典序排列了，所以我们不需要删除任何东西。
注意 A 的行不需要按字典序排列。
也就是说，A[0][0] &lt;= A[0][1] &lt;= ... 不一定成立。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[&quot;zyx&quot;,&quot;wvu&quot;,&quot;tsr&quot;]
<strong>输出：</strong>3
<strong>解释：</strong>
我们必须删掉每一列。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 100</code></li>
	<li><code>1 &lt;= A[i].length &lt;= 100</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int len = A.length, wordLen = A[0].length(), res = 0;
        boolean[] cut = new boolean[len];
        search: for (int j = 0; j < wordLen; j++) {
            // 判断第 j 列是否应当保留
            for (int i = 0; i < len - 1; i++) {
                if (!cut[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res += 1;
                    continue search;
                }
            }
            // 更新 cut 的信息
            for (int i = 0; i < len - 1; i++) {
                if (A[i].charAt(j) < A[i + 1].charAt(j)) {
                    cut[i] = true;
                }
            }
        }
        return res;
    }
}
```

# [958. 二叉树的完全性检验](https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree)
## 题目描述

<p>给定一个二叉树，确定它是否是一个<em>完全二叉树</em>。</p>
<p><strong><a href="https://baike.baidu.com/item/完全二叉树/7773232?fr=aladdin" target="_blank">百度百科</a>中对完全二叉树的定义如下：</strong></p>
<p>若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~&nbsp;2<sup>h</sup>&nbsp;个节点。）</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000319679.png)
<pre><strong>输入：</strong>[1,2,3,4,5,6]
<strong>输出：</strong>true
<strong>解释：</strong>最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000333772.png)
<pre><strong>输入：</strong>[1,2,3,4,5,null,7]
<strong>输出：</strong>false
<strong>解释：</strong>值为 7 的结点没有尽可能靠向左侧。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树中将会有 1 到 100 个结点。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
```

# [961. 重复 N 次的元素](https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array)
## 题目描述

<p>在大小为 <code>2N</code>&nbsp;的数组 <code>A</code>&nbsp;中有 <code>N+1</code> 个不同的元素，其中有一个元素重复了 <code>N</code> 次。</p>
<p>返回重复了 <code>N</code>&nbsp;次的那个元素。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,2,3,3]
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[2,1,2,5,3,2]
<strong>输出：</strong>2
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入：</strong>[5,1,5,2,5,3,5,4]
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>4 &lt;= A.length &lt;= 10000</code></li>
	<li><code>0 &lt;= A[i] &lt; 10000</code></li>
	<li><code>A.length</code>&nbsp;为偶数</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            if (set.contains(e)) {
                return e;
            }
            set.add(e);
        }
        return 0;
    }
}
```

# [973. 最接近原点的 K 个点](https://leetcode-cn.com/problems/k-closest-points-to-origin)
## 题目描述

<p>我们有一个由平面上的点组成的列表 <code>points</code>。需要从中找出 <code>K</code> 个距离原点 <code>(0, 0)</code> 最近的点。</p>
<p>（这里，平面上两点之间的距离是欧几里德距离。）</p>
<p>你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>points = [[1,3],[-2,2]], K = 1
<strong>输出：</strong>[[-2,2]]
<strong>解释： </strong>
(1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) &lt; sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>points = [[3,3],[5,-1],[-2,4]], K = 2
<strong>输出：</strong>[[3,3],[-2,4]]
（答案 [[-2,4],[3,3]] 也会被接受。）
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= K &lt;= points.length &lt;= 10000</code></li>
	<li><code>-10000 &lt; points[i][0] &lt; 10000</code></li>
	<li><code>-10000 &lt; points[i][1] &lt; 10000</code></li>
</ol>

## 解法

### **Java**
```java
import java.util.*;
/**
 * @author Furaha Damien
 */
class Solution {
    // Helper inner class
    public class Point {
        int x;
        int y;
        int distance;
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> que = new PriorityQueue<Point>((a, b) -> (a.distance - b.distance));
        int[][] res = new int[K][2];
        for (int[] temp : points) {
            int dist = (temp[0] * temp[0] + temp[1] * temp[1]);
            que.offer(new Point(temp[0], temp[1], dist));
        }
        for (int i = 0; i < K; i++) {
            Point curr = que.poll();
            res[i][0] = curr.x;
            res[i][1] = curr.y;
        }
        return res;
    }
}
```

# [977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array)
## 题目描述

<p>给定一个按非递减顺序排序的整数数组 <code>A</code>，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[-4,-1,0,3,10]
<strong>输出：</strong>[0,1,9,16,100]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[-7,-3,2,3,11]
<strong>输出：</strong>[4,9,9,49,121]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
	<li><code>-10000 &lt;= A[i] &lt;= 10000</code></li>
	<li><code>A</code>&nbsp;已按非递减顺序排序。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0, n = A.length; i < n; ++i) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
```

# [978. 最长湍流子数组](https://leetcode-cn.com/problems/longest-turbulent-subarray)
## 题目描述

<p>当 <code>A</code>&nbsp;的子数组&nbsp;<code>A[i], A[i+1], ..., A[j]</code>&nbsp;满足下列条件时，我们称其为<em>湍流子数组</em>：</p>
<ul>
	<li>若&nbsp;<code>i &lt;= k &lt; j</code>，当 <code>k</code>&nbsp;为奇数时，&nbsp;<code>A[k] &gt; A[k+1]</code>，且当 <code>k</code> 为偶数时，<code>A[k] &lt; A[k+1]</code>；</li>
	<li><strong>或 </strong>若&nbsp;<code>i &lt;= k &lt; j</code>，当 <code>k</code> 为偶数时，<code>A[k] &gt; A[k+1]</code>&nbsp;，且当 <code>k</code>&nbsp;为奇数时，&nbsp;<code>A[k] &lt; A[k+1]</code>。</li>
</ul>
<p>也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。</p>
<p>返回 <code>A</code> 的最大湍流子数组的<strong>长度</strong>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[9,4,2,10,7,8,8,1,9]
<strong>输出：</strong>5
<strong>解释：</strong>(A[1] &gt; A[2] &lt; A[3] &gt; A[4] &lt; A[5])
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[4,8,12,16]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[100]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 40000</code></li>
	<li><code>0 &lt;= A[i] &lt;= 10^9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int up = 1, down = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) {
                up = down + 1;
                down = 1;
                res = Math.max(res, up);
            } else if (A[i] < A[i - 1]) {
                down = up + 1;
                up = 1;
                res = Math.max(res, down);
            } else {
                up = 1;
                down = 1;
            }
        }
        return res;
    }
}
```


# [989. 数组形式的整数加法](https://leetcode-cn.com/problems/add-to-array-form-of-integer)
## 题目描述

<p>对于非负整数&nbsp;<code>X</code>&nbsp;而言，<em><code>X</code></em>&nbsp;的<em>数组形式</em>是每位数字按从左到右的顺序形成的数组。例如，如果&nbsp;<code>X = 1231</code>，那么其数组形式为&nbsp;<code>[1,2,3,1]</code>。</p>
<p>给定非负整数 <code>X</code> 的数组形式&nbsp;<code>A</code>，返回整数&nbsp;<code>X+K</code>&nbsp;的数组形式。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>A = [1,2,0,0], K = 34
<strong>输出：</strong>[1,2,3,4]
<strong>解释：</strong>1200 + 34 = 1234
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>A = [2,7,4], K = 181
<strong>输出：</strong>[4,5,5]
<strong>解释：</strong>274 + 181 = 455
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>A = [2,1,5], K = 806
<strong>输出：</strong>[1,0,2,1]
<strong>解释：</strong>215 + 806 = 1021
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>A = [9,9,9,9,9,9,9,9,9,9], K = 1
<strong>输出：</strong>[1,0,0,0,0,0,0,0,0,0,0]
<strong>解释：</strong>9999999999 + 1 = 10000000000
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
	<li><code>0 &lt;= A[i] &lt;= 9</code></li>
	<li><code>0 &lt;= K &lt;= 10000</code></li>
	<li>如果&nbsp;<code>A.length &gt; 1</code>，那么&nbsp;<code>A[0] != 0</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        for (int i = A.length - 1; i >= 0 && K != 0; --i) {
            K += A[i];
            A[i] = K % 10;
            K /= 10;
        }
        List<Integer> res = new ArrayList<>();
        while (K != 0) {
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        for (int a : A) {
            res.add(a);
        }
        return res;
    }
}
```

# [999. 车的可用捕获量](https://leetcode-cn.com/problems/available-captures-for-rook)
## 题目描述

<p>在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 &ldquo;R&rdquo;，&ldquo;.&rdquo;，&ldquo;B&rdquo; 和 &ldquo;p&rdquo; 给出。大写字符表示白棋，小写字符表示黑棋。</p>
<p>车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。</p>
<p>返回车能够在一次移动中捕获到的卒的数量。<br>
&nbsp;</p>
<p><strong>示例 1：</strong></p>
![\[外链图片转存失败,源](https://img-blog.csdnimg.cn/20210225000503746.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;R&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]
<strong>输出：</strong>3
<strong>解释：
</strong>在本例中，车能够捕获所有的卒。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000520282.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;B&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;B&quot;,&quot;R&quot;,&quot;B&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;B&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]
<strong>输出：</strong>0
<strong>解释：
</strong>象阻止了车捕获任何卒。
</pre>

<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000537456.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;p&quot;,&quot;p&quot;,&quot;.&quot;,&quot;R&quot;,&quot;.&quot;,&quot;p&quot;,&quot;B&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;B&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;p&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;]]
<strong>输出：</strong>3
<strong>解释： </strong>
车可以捕获位置 b5，d6 和 f5 的卒。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>board.length == board[i].length == 8</code></li>
	<li><code>board[i][j]</code> 可以是&nbsp;<code>&#39;R&#39;</code>，<code>&#39;.&#39;</code>，<code>&#39;B&#39;</code>&nbsp;或&nbsp;<code>&#39;p&#39;</code></li>
	<li>只有一个格子上存在&nbsp;<code>board[i][j] == &#39;R&#39;</code></li>
</ol>

## 解法
先找到 R 的位置，之后向“上、下、左、右”四个方向查找，累加结果。

### **Java**
```java
class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int res = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    for (int[] direction : directions) {
                        res += search(board, i, j, direction);
                    }
                    return res;
                }
            }
        }
        return res;
    }
    private int search(char[][] board, int i, int j, int[] direction) {
        while (i >= 0 && i < 8 && j >= 0 && j < 8) {
            if (board[i][j] == 'B') return 0;
            if (board[i][j] == 'p') return 1;
            i += direction[0];
            j += direction[1];
        }
        return 0;
    }
}
```

# [1004. 最大连续 1 的个数 III](https://leetcode-cn.com/problems/max-consecutive-ones-iii)
## 题目描述

<p>给定一个由若干 <code>0</code> 和 <code>1</code> 组成的数组&nbsp;<code>A</code>，我们最多可以将&nbsp;<code>K</code>&nbsp;个值从 0 变成 1 。</p>
<p>返回仅包含 1 的最长（连续）子数组的长度。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
<strong>输出：</strong>6
<strong>解释： </strong>
[1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
<strong>输出：</strong>10
<strong>解释：</strong>
[0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
	<li><code>0 &lt;= K &lt;= A.length</code></li>
	<li><code>A[i]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code>&nbsp;</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) --K;
            if (K < 0 && A[l++] == 0) ++K;
        }
        return r - l;
    }
}
```

# [1008. 先序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal)
## 题目描述

<p>返回与给定先序遍历&nbsp;<code>preorder</code> 相匹配的二叉搜索树（binary <strong>search</strong> tree）的根结点。</p>
<p><em>(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于&nbsp;<code>node.left</code>&nbsp;的任何后代，值总 <code>&lt;</code> <code>node.val</code>，而 <code>node.right</code> 的任何后代，值总 <code>&gt;</code> <code>node.val</code>。此外，先序遍历首先显示节点的值，然后遍历 <code>node.left</code>，接着遍历 <code>node.right</code>。）</em></p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[8,5,1,7,10,12]
<strong>输出：</strong>[8,5,10,1,7,null,12]
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000646851.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= preorder.length &lt;= 100</code></li>
	<li>先序&nbsp;<code>preorder</code>&nbsp;中的值是不同的。</li>
</ol>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 进入分治法的递归
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        // System.out.println("start: " + start + " end: " + end);
        // 确认递归结束的标志，当 start == end 时，表示该区间只剩下一个 subRoot 节点
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(preorder[start]);
        }
        // 前序遍历，首先遍历到的为根
        TreeNode root = new TreeNode(preorder[start]);
        int leftEnd = start;
        while (leftEnd <= end) {
            if (preorder[leftEnd] > preorder[start]) {
                break;
            }
            leftEnd++;
        }
        // System.out.println("leftEnd:" + leftEnd + " num: " + preorder[leftEnd]);
        root.left = helper(preorder, start + 1, leftEnd - 1);
        root.right = helper(preorder, leftEnd, end);
        return root;
    }
}
```

# [1009. 十进制整数的反码](https://leetcode-cn.com/problems/complement-of-base-10-integer)
## 题目描述

<p>每个非负整数&nbsp;<code>N</code>&nbsp;都有其二进制表示。例如，&nbsp;<code>5</code>&nbsp;可以被表示为二进制&nbsp;<code>&quot;101&quot;</code>，<code>11</code> 可以用二进制&nbsp;<code>&quot;1011&quot;</code>&nbsp;表示，依此类推。注意，除&nbsp;<code>N = 0</code>&nbsp;外，任何二进制表示中都不含前导零。</p>
<p>二进制的反码表示是将每个&nbsp;<code>1</code>&nbsp;改为&nbsp;<code>0</code>&nbsp;且每个&nbsp;<code>0</code>&nbsp;变为&nbsp;<code>1</code>。例如，二进制数&nbsp;<code>&quot;101&quot;</code>&nbsp;的二进制反码为&nbsp;<code>&quot;010&quot;</code>。</p>
<p>给你一个十进制数&nbsp;<code>N</code>，请你返回其二进制表示的反码所对应的十进制整数。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>5
<strong>输出：</strong>2
<strong>解释：</strong>5 的二进制表示为 &quot;101&quot;，其二进制反码为 &quot;010&quot;，也就是十进制中的 2 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>7
<strong>输出：</strong>0
<strong>解释：</strong>7 的二进制表示为 &quot;111&quot;，其二进制反码为 &quot;000&quot;，也就是十进制中的 0 。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>10
<strong>输出：</strong>5
<strong>解释：</strong>10 的二进制表示为 &quot;1010&quot;，其二进制反码为 &quot;0101&quot;，也就是十进制中的 5 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>0 &lt;= N &lt; 10^9</code></li>
	<li>本题与 476：<a href="https://leetcode-cn.com/problems/number-complement/">https://leetcode-cn.com/problems/number-complement/</a> 相同</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int bitwiseComplement(int N) {
        int ans = 0;
        int index = -1;
        if (N == 0) return 1;
        if (N == 1) return 0;
        while (N / 2 != 0) {
            index++;
            int temp = N % 2 == 0 ? 1 : 0;
            if (temp == 1) {
                ans += Math.pow(2, index);
            }
            N /= 2;
        }
        return ans;
    }
}
```

# [1010. 总持续时间可被 60 整除的歌曲](https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60)
## 题目描述

<p>在歌曲列表中，第 <code>i</code> 首歌曲的持续时间为 <code>time[i]</code> 秒。</p>
<p>返回其总持续时间（以秒为单位）可被 <code>60</code> 整除的歌曲对的数量。形式上，我们希望索引的数字&nbsp;&nbsp;<code>i &lt; j</code> 且有&nbsp;<code>(time[i] + time[j]) % 60 == 0</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[30,20,150,100,40]
<strong>输出：</strong>3
<strong>解释：</strong>这三对的总持续时间可被 60 整数：
(time[0] = 30, time[2] = 150): 总持续时间 180
(time[1] = 20, time[3] = 100): 总持续时间 120
(time[1] = 20, time[4] = 40): 总持续时间 60
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[60,60,60]
<strong>输出：</strong>3
<strong>解释：</strong>所有三对的总持续时间都是 120，可以被 60 整数。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= time.length &lt;= 60000</code></li>
	<li><code>1 &lt;= time[i] &lt;= 500</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Arrays.sort(time);
        int ans = 0;
        for (int i = 0; i < time.length - 1; i++) {
            int num = (time[i] + time[time.length - 1]) / 60;
            while (num > 0) {
                int key = num * 60;
                int index = Arrays.binarySearch(time, i + 1, time.length, key - time[i]);
                if (index >= 0) {
                    int temp = index;
                    ans++;
                    while (++temp < time.length && time[temp] == time[index]) {
                        ans++;
                    }
                    temp = index;
                    while (--temp > i && time[temp] == time[index]) {
                        ans++;
                    }
                }
                num--;
            }
        }
        return ans;
    }
}
```

## 十进制的反码
### 问题描述
每个非负整数 `N` 都有其二进制表示。例如， `5` 可以被表示为二进制 `"101"`，`11` 可以用二进制 `"1011"` 表示，依此类推。注意，除 `N = 0` 外，任何二进制表示中都不含前导零。
二进制的反码表示是将每个 `1` 改为 `0` 且每个 `0` 变为 `1`。例如，二进制数 `"101"` 的二进制反码为 `"010"`。
给定十进制数 N，返回其二进制表示的反码所对应的十进制整数。
**示例 1:**
```
输入：5
输出：2
解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
```
**示例 2:**
```
输入：7
输出：0
解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
```
**示例 3:**
```
输入：10
输出：5
解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
```
**提示:**
1. `0 <= N < 10^9`
#
## 解法
求余数，取反（`0 -> 1`, `1 -> 0`），累加结果。
注意 `N = 0` 的特殊情况。
```java
class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int res = 0;
        int exp = 0;
        while (N != 0) {
            int bit = N % 2 == 0 ? 1 : 0;
            res += Math.pow(2, exp) * bit;
            ++exp;
            N >>= 1;
        }
        return res;
    }
}
```

# [1017. 负二进制转换](https://leetcode-cn.com/problems/convert-to-base-2)
## 题目描述

<p>给出数字&nbsp;<code>N</code>，返回由若干&nbsp;<code>&quot;0&quot;</code>&nbsp;和&nbsp;<code>&quot;1&quot;</code>组成的字符串，该字符串为 <code>N</code>&nbsp;的<strong>负二进制（<code>base -2</code>）</strong>表示。</p>
<p>除非字符串就是&nbsp;<code>&quot;0&quot;</code>，否则返回的字符串中不能含有前导零。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>2
<strong>输出：</strong>&quot;110&quot;
<strong>解释：</strong>(-2) ^ 2 + (-2) ^ 1 = 2
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>3
<strong>输出：</strong>&quot;111&quot;
<strong>解释：</strong>(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>4
<strong>输出：</strong>&quot;100&quot;
<strong>解释：</strong>(-2) ^ 2 = 4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>0 &lt;= N &lt;= 10^9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.reverse().toString();
    }
}
```

# [1019. 链表中的下一个更大节点](https://leetcode-cn.com/problems/next-greater-node-in-linked-list)
## 题目描述

<p>给出一个以头节点&nbsp;<code>head</code>&nbsp;作为第一个节点的链表。链表中的节点分别编号为：<code>node_1, node_2, node_3, ...</code> 。</p>
<p>每个节点都可能有下一个更大值（<em>next larger</em> <strong>value</strong>）：对于&nbsp;<code>node_i</code>，如果其&nbsp;<code>next_larger(node_i)</code>&nbsp;是&nbsp;<code>node_j.val</code>，那么就有&nbsp;<code>j &gt; i</code>&nbsp;且&nbsp;&nbsp;<code>node_j.val &gt; node_i.val</code>，而&nbsp;<code>j</code>&nbsp;是可能的选项中最小的那个。如果不存在这样的&nbsp;<code>j</code>，那么下一个更大值为&nbsp;<code>0</code>&nbsp;。</p>
<p>返回整数答案数组&nbsp;<code>answer</code>，其中&nbsp;<code>answer[i] = next_larger(node_{i+1})</code>&nbsp;。</p>
<p><strong><em>注意：</em></strong>在下面的示例中，诸如 <code>[2,1,5]</code> 这样的<strong>输入</strong>（不是输出）是链表的序列化表示，其头节点的值为&nbsp;2，第二个节点值为 1，第三个节点值为&nbsp;5 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[2,1,5]
<strong>输出：</strong>[5,5,0]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[2,7,4,3,5]
<strong>输出：</strong>[7,0,5,5,0]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[1,7,5,1,9,2,5,1]
<strong>输出：</strong>[7,9,9,9,0,5,0,0]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>对于链表中的每个节点，<code>1 &lt;= node.val&nbsp;&lt;= 10^9</code></li>
	<li>给定列表的长度在 <code>[0, 10000]</code>&nbsp;范围内</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
```

# [1021. 删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses)
## 题目描述

<p>有效括号字符串为空&nbsp;<code>(&quot;&quot;)</code>、<code>&quot;(&quot; + A + &quot;)&quot;</code>&nbsp;或&nbsp;<code>A + B</code>，其中&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;都是有效的括号字符串，<code>+</code>&nbsp;代表字符串的连接。例如，<code>&quot;&quot;</code>，<code>&quot;()&quot;</code>，<code>&quot;(())()&quot;</code>&nbsp;和&nbsp;<code>&quot;(()(()))&quot;</code>&nbsp;都是有效的括号字符串。</p>
<p>如果有效字符串&nbsp;<code>S</code>&nbsp;非空，且不存在将其拆分为&nbsp;<code>S = A+B</code>&nbsp;的方法，我们称其为<strong>原语（primitive）</strong>，其中&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;都是非空有效括号字符串。</p>
<p>给出一个非空有效字符串&nbsp;<code>S</code>，考虑将其进行原语化分解，使得：<code>S = P_1 + P_2 + ... + P_k</code>，其中&nbsp;<code>P_i</code>&nbsp;是有效括号字符串原语。</p>
<p>对&nbsp;<code>S</code>&nbsp;进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 <code>S</code>&nbsp;。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>&quot;(()())(())&quot;
<strong>输出：</strong>&quot;()()()&quot;
<strong>解释：
</strong>输入字符串为 &quot;(()())(())&quot;，原语化分解得到 &quot;(()())&quot; + &quot;(())&quot;，
删除每个部分中的最外层括号后得到 &quot;()()&quot; + &quot;()&quot; = &quot;()()()&quot;。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>&quot;(()())(())(()(()))&quot;
<strong>输出：</strong>&quot;()()()()(())&quot;
<strong>解释：</strong>
输入字符串为 &quot;(()())(())(()(()))&quot;，原语化分解得到 &quot;(()())&quot; + &quot;(())&quot; + &quot;(()(()))&quot;，
删除每隔部分中的最外层括号后得到 &quot;()()&quot; + &quot;()&quot; + &quot;()(())&quot; = &quot;()()()()(())&quot;。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>&quot;()()&quot;
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>
输入字符串为 &quot;()()&quot;，原语化分解得到 &quot;()&quot; + &quot;()&quot;，
删除每个部分中的最外层括号后得到 &quot;&quot; + &quot;&quot; = &quot;&quot;。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>S.length &lt;= 10000</code></li>
	<li><code>S[i]</code> 为&nbsp;<code>&quot;(&quot;</code> 或&nbsp;<code>&quot;)&quot;</code></li>
	<li><code>S</code> 是一个有效括号字符串</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (++cnt > 1) {
                    res.append('(');
                }
            } else {
                if (--cnt > 0) {
                    res.append(')');
                }
            }
        }
        return res.toString();
    }
}
```

# [1022. 从根到叶的二进制数之和](https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers)
## 题目描述

<p>给出一棵二叉树，其上每个结点的值都是&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code>&nbsp;。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为&nbsp;<code>0 -&gt; 1 -&gt; 1 -&gt; 0 -&gt; 1</code>，那么它表示二进制数&nbsp;<code>01101</code>，也就是&nbsp;<code>13</code>&nbsp;。</p>
<p>对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。</p>
<p>以<strong>&nbsp;<code>10^9 + 7</code></strong>&nbsp;为<strong>模</strong>，返回这些数字之和。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000720312.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[1,0,1,0,1,0,1]
<strong>输出：</strong>22
<strong>解释：</strong>(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树中的结点数介于 <code>1</code> 和 <code>1000</code> 之间。</li>
	<li>node.val 为&nbsp;<code>0</code> 或&nbsp;<code>1</code>&nbsp;。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        s = s << 1 | root.val;
        if (root.left == null && root.right == null) {
            return s;
        }
        return dfs(root.left, s) + dfs(root.right, s);
    }
}
```

# [1025. 除数博弈](https://leetcode-cn.com/problems/divisor-game)
## 题目描述

<p>爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。</p>
<p>最初，黑板上有一个数字&nbsp;<code>N</code>&nbsp;。在每个玩家的回合，玩家需要执行以下操作：</p>
<ul>
	<li>选出任一&nbsp;<code>x</code>，满足&nbsp;<code>0 &lt; x &lt; N</code> 且&nbsp;<code>N % x == 0</code>&nbsp;。</li>
	<li>用 <code>N - x</code>&nbsp;替换黑板上的数字 <code>N</code> 。</li>
</ul>
<p>如果玩家无法执行这些操作，就会输掉游戏。</p>
<p>只有在爱丽丝在游戏中取得胜利时才返回&nbsp;<code>True</code>，否则返回 <code>false</code>。假设两个玩家都以最佳状态参与游戏。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>2
<strong>输出：</strong>true
<strong>解释：</strong>爱丽丝选择 1，鲍勃无法进行操作。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>3
<strong>输出：</strong>false
<strong>解释：</strong>爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= N &lt;= 1000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
```

# [1026. 节点与其祖先之间的最大差值](https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor)
## 题目描述

<p>给定二叉树的根节点&nbsp;<code>root</code>，找出存在于不同节点&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;之间的最大值 <code>V</code>，其中&nbsp;<code>V = |A.val - B.val|</code>，且&nbsp;<code>A</code>&nbsp;是&nbsp;<code>B</code>&nbsp;的祖先。</p>
<p>（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000739962.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[8,3,10,1,6,null,14,null,null,4,7,13]
<strong>输出：</strong>7
<strong>解释： </strong>
我们有大量的节点与其祖先的差值，其中一些如下：
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树中的节点数在&nbsp;<code>2</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;之间。</li>
	<li>每个节点的值介于&nbsp;<code>0</code>&nbsp;到&nbsp;<code>100000</code>&nbsp;之间。</li>
</ol>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int bfs(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        int res = Math.max(max - root.val, root.val - min);
        int mx = Math.max(root.val, max);
        int mn = Math.min(root.val, min);
        res = Math.max(res, bfs(root.left, mx, mn));
        res = Math.max(res, bfs(root.right, mx, mn));
        return res;
    }
    public int maxAncestorDiff(TreeNode root) {
        return bfs(root, root.val, root.val);
    }
}
```

# [1029. 两地调度](https://leetcode-cn.com/problems/two-city-scheduling)
## 题目描述

<p>公司计划面试 <code>2N</code> 人。第 <code>i</code> 人飞往 <code>A</code> 市的费用为 <code>costs[i][0]</code>，飞往 <code>B</code> 市的费用为 <code>costs[i][1]</code>。</p>
<p>返回将每个人都飞到某座城市的最低费用，要求每个城市都有 <code>N</code> 人抵达<strong>。</strong></p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[[10,20],[30,200],[400,50],[30,20]]
<strong>输出：</strong>110
<strong>解释：</strong>
第一个人去 A 市，费用为 10。
第二个人去 A 市，费用为 30。
第三个人去 B 市，费用为 50。
第四个人去 B 市，费用为 20。
最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= costs.length &lt;= 100</code></li>
	<li><code>costs.length</code> 为偶数</li>
	<li><code>1 &lt;= costs[i][0], costs[i][1] &lt;= 1000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
        public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            return a[0] - a[1] - (b[0] - b[1]);
        });
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }
        return sum;
    }
}
```

# [1030. 距离顺序排列矩阵单元格](https://leetcode-cn.com/problems/matrix-cells-in-distance-order)
## 题目描述

<p>给出 <code>R</code> 行 <code>C</code> 列的矩阵，其中的单元格的整数坐标为 <code>(r, c)</code>，满足 <code>0 &lt;= r &lt; R</code> 且 <code>0 &lt;= c &lt; C</code>。</p>
<p>另外，我们在该矩阵中给出了一个坐标为&nbsp;<code>(r0, c0)</code> 的单元格。</p>
<p>返回矩阵中的所有单元格的坐标，并按到 <code>(r0, c0)</code> 的距离从最小到最大的顺序排，其中，两单元格<code>(r1, c1)</code> 和 <code>(r2, c2)</code> 之间的距离是曼哈顿距离，<code>|r1 - r2| + |c1 - c2|</code>。（你可以按任何满足此条件的顺序返回答案。）</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>R = 1, C = 2, r0 = 0, c0 = 0
<strong>输出：</strong>[[0,0],[0,1]]
<strong>解释</strong>：从 (r0, c0) 到其他单元格的距离为：[0,1]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>R = 2, C = 2, r0 = 0, c0 = 1
<strong>输出：</strong>[[0,1],[0,0],[1,1],[1,0]]
<strong>解释</strong>：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>R = 2, C = 3, r0 = 1, c0 = 2
<strong>输出：</strong>[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
<strong>解释</strong>：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= R &lt;= 100</code></li>
	<li><code>1 &lt;= C &lt;= 100</code></li>
	<li><code>0 &lt;= r0 &lt; R</code></li>
	<li><code>0 &lt;= c0 &lt; C</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int[][] flag = new int[R][C];
        int index = 0;
        ans[index][0] = r0;
        ans[index][1] = c0;
        index++;
        flag[r0][c0] = 1;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(r0, c0));
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            // up
            if (node.r - 1 >= 0 && flag[node.r - 1][node.c] != 1) {
                queue.add(new Node(node.r - 1, node.c));
                flag[node.r - 1][node.c] = 1;
                ans[index][0] = node.r - 1;
                ans[index][1] = node.c;
                index++;
            }
            // down
            if (node.r + 1 < R && flag[node.r + 1][node.c] != 1) {
                queue.add(new Node(node.r + 1, node.c));
                flag[node.r + 1][node.c] = 1;
                ans[index][0] = node.r + 1;
                ans[index][1] = node.c;
                index++;
            }
            // left
            if (node.c - 1 >= 0 && flag[node.r][node.c - 1] != 1) {
                queue.add(new Node(node.r, node.c - 1));
                flag[node.r][node.c - 1] = 1;
                ans[index][0] = node.r;
                ans[index][1] = node.c - 1;
                index++;
            }
            // right
            if (node.c + 1 < C && flag[node.r][node.c + 1] != 1) {
                queue.add(new Node(node.r, node.c + 1));
                flag[node.r][node.c + 1] = 1;
                ans[index][0] = node.r;
                ans[index][1] = node.c + 1;
                index++;
            }
        }
        return ans;
    }
}
```

# [1033. 移动石子直到连续](https://leetcode-cn.com/problems/moving-stones-until-consecutive)
## 题目描述

<p>三枚石子放置在数轴上，位置分别为 <code>a</code>，<code>b</code>，<code>c</code>。</p>
<p>每一回合，我们假设这三枚石子当前分别位于位置 <code>x, y, z</code> 且 <code>x &lt; y &lt; z</code>。从位置 <code>x</code> 或者是位置 <code>z</code> 拿起一枚石子，并将该石子移动到某一整数位置 <code>k</code> 处，其中 <code>x &lt; k &lt; z</code> 且 <code>k != y</code>。</p>
<p>当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。</p>
<p>要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：<code>answer = [minimum_moves, maximum_moves]</code></p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>a = 1, b = 2, c = 5
<strong>输出：</strong>[1, 2]
<strong>解释：</strong>将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>a = 4, b = 3, c = 2
<strong>输出：</strong>[0, 0]
<strong>解释：</strong>我们无法进行任何移动。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= a &lt;= 100</code></li>
	<li><code>1 &lt;= b &lt;= 100</code></li>
	<li><code>1 &lt;= c &lt;= 100</code></li>
	<li><code>a != b, b != c, c != a</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;
        int max = z - x - 2;
        int min = y - x == 1 && z - y == 1 ? 0 : y - x <= 2 || z - y <= 2 ? 1 : 2;
        return new int[]{min, max};
    }
}
```

# [1034. 边框着色](https://leetcode-cn.com/problems/coloring-a-border)
## 题目描述

<p>给出一个二维整数网格&nbsp;<code>grid</code>，网格中的每个值表示该位置处的网格块的颜色。</p>
<p>只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一<strong>连通分量</strong>。</p>
<p>连通分量的<strong>边界</strong>是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。</p>
<p>给出位于&nbsp;<code>(r0, c0)</code>&nbsp;的网格块和颜色&nbsp;<code>color</code>，使用指定颜色&nbsp;<code>color</code>&nbsp;为所给网格块的连通分量的边界进行着色，并返回最终的网格&nbsp;<code>grid</code> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
<strong>输出：</strong>[[3, 3], [3, 2]]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
<strong>输出：</strong>[[1, 3, 3], [2, 3, 3]]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
<strong>输出：</strong>[[2, 2, 2], [2, 1, 2], [2, 2, 2]]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= grid.length &lt;= 50</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 1000</code></li>
	<li><code>0 &lt;= r0 &lt; grid.length</code></li>
	<li><code>0 &lt;= c0 &lt; grid[0].length</code></li>
	<li><code>1 &lt;= color &lt;= 1000</code></li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    private int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, color, vis);
        return grid;
    }
    private void dfs(int[][] grid, int i, int j, int color, boolean[][] vis) {
        vis[i][j] = true;
        int oldColor = grid[i][j];
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (!vis[x][y]) {
                    if (grid[x][y] == oldColor) {
                        dfs(grid, x, y, color, vis);
                    } else {
                        grid[i][j] = color;
                    }
                }
            } else {
                grid[i][j] = color;
            }
        }
    }
}
```


# [1037. 有效的回旋镖](https://leetcode-cn.com/problems/valid-boomerang)
## 题目描述

<p>回旋镖定义为一组三个点，这些点各不相同且<strong>不</strong>在一条直线上。</p>
<p>给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[[1,1],[2,3],[3,2]]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[[1,1],[2,2],[3,3]]
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>points.length == 3</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>0 &lt;= points[i][j] &lt;= 100</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean isBoomerang(int[][] points) {
        double temp1;
        double temp2;
        double temp3;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        if (points[0][0] == points[1][0]) {
            if (points[0][1] == points[1][1])
                return false;
            temp1 = 1;
        } else {
            temp1 = (points[0][1] - points[1][1]) * 1.0 / (points[0][0] - points[1][0]);
        }
        if (points[1][0] == points[2][0]) {
            if (points[1][1] == points[2][1])
                return false;
            temp2 = 1;
        } else {
            temp2 = (points[1][1] - points[2][1]) * 1.0 / (points[1][0] - points[2][0]);
        }
        if (points[0][0] == points[2][0]) {
            if (points[0][1] == points[2][1])
                return false;
            temp3 = 1;
        } else {
            temp3 = (points[0][1] - points[2][1]) * 1.0 / (points[0][0] - points[2][0]);
        }
        if (temp1 == temp2 && temp1 == temp3 && temp2 == temp3) {
            return false;
        } else {
            return true;
        }
    }
}
```

# [1038. 从二叉搜索树到更大和树](https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree)
## 题目描述

<p>给出二叉<strong> 搜索 </strong>树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 <code>node</code>&nbsp;的新值等于原树中大于或等于&nbsp;<code>node.val</code>&nbsp;的值之和。</p>
<p>提醒一下，二叉搜索树满足下列约束条件：</p>
<ul>
	<li>节点的左子树仅包含键<strong> 小于 </strong>节点键的节点。</li>
	<li>节点的右子树仅包含键<strong> 大于</strong> 节点键的节点。</li>
	<li>左右子树也必须是二叉搜索树。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022500084163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
<strong>输出：</strong>[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树中的节点数介于 <code>1</code> 和 <code>100</code> 之间。</li>
	<li>每个节点的值介于&nbsp;<code>0</code> 和&nbsp;<code>100</code>&nbsp;之间。</li>
	<li>给定的树为二叉搜索树。</li>
</ol>
<p>&nbsp;</p>
<p><strong>注意：</strong>该题目与 538:&nbsp;<a href="https://leetcode-cn.com/problems/convert-bst-to-greater-tree/">https://leetcode-cn.com/problems/convert-bst-to-greater-tree/&nbsp; </a>相同</p>

## 解法

### **Java**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int max = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return new TreeNode(0);
        int temp = bstToGst(root.right).val;
        root.val += (temp > max ? temp : max);
        max = root.val > max ? root.val : max;
        if (root.left != null) {
            int temp2 = bstToGst(root.left.right).val;
            root.left.val += max > temp2 ? max : temp2;
            max = max > root.left.val ? max : root.left.val;
            bstToGst(root.left.left);
        }
        return root;
    }
}
```

# [1041. 困于环中的机器人](https://leetcode-cn.com/problems/robot-bounded-in-circle)
## 题目描述

<p>在无限的平面上，机器人最初位于&nbsp;<code>(0, 0)</code>&nbsp;处，面朝北方。机器人可以接受下列三条指令之一：</p>
<ul>
	<li><code>&quot;G&quot;</code>：直走 1 个单位</li>
	<li><code>&quot;L&quot;</code>：左转 90 度</li>
	<li><code>&quot;R&quot;</code>：右转 90 度</li>
</ul>
<p>机器人按顺序执行指令&nbsp;<code>instructions</code>，并一直重复它们。</p>
<p>只有在平面中存在环使得机器人永远无法离开时，返回&nbsp;<code>true</code>。否则，返回 <code>false</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>&quot;GGLLGG&quot;
<strong>输出：</strong>true
<strong>解释：</strong>
机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>&quot;GG&quot;
<strong>输出：</strong>false
<strong>解释：</strong>
机器人无限向北移动。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>&quot;GL&quot;
<strong>输出：</strong>true
<strong>解释：</strong>
机器人按 (0, 0) -&gt; (0, 1) -&gt; (-1, 1) -&gt; (-1, 0) -&gt; (0, 0) -&gt; ... 进行移动。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= instructions.length &lt;= 100</code></li>
	<li><code>instructions[i]</code> 在&nbsp;<code>{&#39;G&#39;, &#39;L&#39;, &#39;R&#39;}</code>&nbsp;中</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean isRobotBounded(String instructions) {
        int col = 0;
        int row = 0;
        char[] orders = instructions.toCharArray();
        int order = 0;
        for (int i = 0; i < 4; i++) {
            for (char ch : orders) {
                if (ch == 'L') {
                    order--;
                    if (order == -3) {
                        order = 1;
                    }
                } else if (ch == 'R') {
                    order++;
                    if (order == 2) {
                        order = -2;
                    }
                } else {
                    switch (order) {
                        case 0:
                            row++;
                            break;
                        case 1:
                            col++;
                            break;
                        case -1:
                            col--;
                            break;
                        case -2:
                            row--;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (col == 0 && row == 0) {
                return true;
            }
        }
        return false;
    }
}
```

# [1043. 分隔数组以得到最大和](https://leetcode-cn.com/problems/partition-array-for-maximum-sum)
## 题目描述

<p>给出整数数组&nbsp;<code>A</code>，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。</p>
<p>返回给定数组完成分隔后的最大和。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>A = [1,15,7,9,2,5,10], K = 3
<strong>输出：</strong>84
<strong>解释：</strong>A 变为 [15,15,15,9,10,10,10]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= K &lt;= A.length&nbsp;&lt;= 500</code></li>
	<li><code>0 &lt;= A[i] &lt;= 10^6</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = 0;
            for (int k = 0; k < K && i - k >= 0; k++) {
                max = Math.max(max, A[i - k]);
                dp[i] = Math.max(dp[i], (i - 1 >= k ? dp[i - k - 1] : 0) + max * (k + 1));
            }
        }
        return dp[A.length - 1];
    }
}
```

# [1046. 最后一块石头的重量](https://leetcode-cn.com/problems/last-stone-weight)
## 题目描述

<p>有一堆石头，每块石头的重量都是正整数。</p>
<p>每一回合，从中选出两块<strong>最重的</strong>石头，然后将它们一起粉碎。假设石头的重量分别为&nbsp;<code>x</code> 和&nbsp;<code>y</code>，且&nbsp;<code>x &lt;= y</code>。那么粉碎的可能结果如下：</p>
<ul>
	<li>如果&nbsp;<code>x == y</code>，那么两块石头都会被完全粉碎；</li>
	<li>如果&nbsp;<code>x != y</code>，那么重量为&nbsp;<code>x</code>&nbsp;的石头将会完全粉碎，而重量为&nbsp;<code>y</code>&nbsp;的石头新重量为&nbsp;<code>y-x</code>。</li>
</ul>
<p>最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 <code>0</code>。</p>
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= stones.length &lt;= 30</code></li>
	<li><code>1 &lt;= stones[i] &lt;= 1000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                queue.offer(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
```

# [1047. 删除字符串中的所有相邻重复项](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string)
## 题目描述

<p>给出由小写字母组成的字符串&nbsp;<code>S</code>，<strong>重复项删除操作</strong>会选择两个相邻且相同的字母，并删除它们。</p>
<p>在 S 上反复执行重复项删除操作，直到无法继续删除。</p>
<p>在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>&quot;abbaca&quot;
<strong>输出：</strong>&quot;ca&quot;
<strong>解释：</strong>
例如，在 &quot;abbaca&quot; 中，我们可以删除 &quot;bb&quot; 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 &quot;aaca&quot;，其中又只有 &quot;aa&quot; 可以执行重复项删除操作，所以最后的字符串为 &quot;ca&quot;。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= S.length &lt;= 20000</code></li>
	<li><code>S</code> 仅由小写英文字母组成。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String removeDuplicates(String S) {
        char[] cs = new char[S.length()];
        int top = -1;
        for (char c : S.toCharArray()) {
            if (top >= 0 && c == cs[top]) {
                --top;
            } else {
                cs[++top] = c;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}
```

# [1048. 最长字符串链](https://leetcode-cn.com/problems/longest-string-chain)
## 题目描述

<p>给出一个单词列表，其中每个单词都由小写英文字母组成。</p>
<p>如果我们可以在&nbsp;<code>word1</code>&nbsp;的任何地方添加一个字母使其变成&nbsp;<code>word2</code>，那么我们认为&nbsp;<code>word1</code>&nbsp;是&nbsp;<code>word2</code>&nbsp;的前身。例如，<code>&quot;abc&quot;</code>&nbsp;是&nbsp;<code>&quot;abac&quot;</code>&nbsp;的前身。</p>
<p><strong>词链</strong>是单词&nbsp;<code>[word_1, word_2, ..., word_k]</code>&nbsp;组成的序列，<code>k &gt;= 1</code>，其中&nbsp;<code>word_1</code>&nbsp;是&nbsp;<code>word_2</code>&nbsp;的前身，<code>word_2</code>&nbsp;是&nbsp;<code>word_3</code>&nbsp;的前身，依此类推。</p>
<p>从给定单词列表 <code>words</code> 中选择单词组成词链，返回词链的最长可能长度。<br>
&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[&quot;a&quot;,&quot;b&quot;,&quot;ba&quot;,&quot;bca&quot;,&quot;bda&quot;,&quot;bdca&quot;]
<strong>输出：</strong>4
<strong>解释：</strong>最长单词链之一为 &quot;a&quot;,&quot;ba&quot;,&quot;bda&quot;,&quot;bdca&quot;。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 16</code></li>
	<li><code>words[i]</code>&nbsp;仅由小写英文字母组成。</li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int x = 1;
            for (int i = 0; i < word.length(); ++i) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                x = Math.max(x, map.getOrDefault(pre, 0) + 1);
            }
            map.put(word, x);
            res = Math.max(res, x);
        }
        return res;
    }
}
```

# [1051. 高度检查器](https://leetcode-cn.com/problems/height-checker)
## 题目描述

<p>学校在拍年度纪念照时，一般要求学生按照 <strong>非递减</strong> 的高度顺序排列。</p>
<p>请你返回能让所有学生以 <strong>非递减</strong> 高度排列的最小必要移动人数。</p>
<p>注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>heights =&nbsp;[1,1,4,2,1,3]
<strong>输出：</strong>3 
<strong>解释：</strong>
当前数组：[1,1,4,2,1,3]
目标数组：[1,1,1,2,3,4]
在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>heights = [5,1,2,3,4]
<strong>输出：</strong>5
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>heights = [1,2,3,4,5]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= heights.length &lt;= 100</code></li>
	<li><code>1 &lt;= heights[i] &lt;= 100</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != copy[i]) {
                ++res;
            }
        }
        return res;
    }
}
```

# [1052. 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner)
## 题目描述

<p>今天，书店老板有一家店打算试营业&nbsp;<code>customers.length</code>&nbsp;分钟。每分钟都有一些顾客（<code>customers[i]</code>）会进入书店，所有这些顾客都会在那一分钟结束后离开。</p>
<p>在某些时候，书店老板会生气。 如果书店老板在第 <code>i</code> 分钟生气，那么 <code>grumpy[i] = 1</code>，否则 <code>grumpy[i] = 0</code>。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。</p>
<p>书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续&nbsp;<code>X</code> 分钟不生气，但却只能使用一次。</p>
<p>请你返回这一天营业下来，最多有多少客户能够感到满意的数量。<br>
&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
<strong>输出：</strong>16
<strong>解释：
</strong>书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= X &lt;=&nbsp;customers.length ==&nbsp;grumpy.length &lt;= 20000</code></li>
	<li><code>0 &lt;=&nbsp;customers[i] &lt;= 1000</code></li>
	<li><code>0 &lt;=&nbsp;grumpy[i] &lt;= 1</code></li>
</ul>

## 解法
- 用 `s` 累计不使用秘密技巧时，满意的顾客数；
- 用 `t` 计算大小为 `X` 的滑动窗口最多增加的满意的顾客数；
- 结果即为 `s+t`。

### **Java**
```java
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 用s累计不使用秘密技巧时，满意的顾客数
        // 用t计算大小为X的滑动窗口最多增加的满意的顾客数
        // 结果即为s+t
        int s = 0, t = 0;
        for (int i = 0, win = 0, n = customers.length; i < n; ++i) {
            if (grumpy[i] == 0) {
                s += customers[i];
            } else {
                win += customers[i];
            }
            if (i >= X && grumpy[i - X] == 1) {
                win -= customers[i - X];
            }
            // 求滑动窗口的最大值
            t = Math.max(t, win);
        }
        return s + t;
    }
}
```

# [1053. 交换一次的先前排列](https://leetcode-cn.com/problems/previous-permutation-with-one-swap)
## 题目描述

<p>给你一个正整数的数组 <code>A</code>（其中的元素不一定完全不同），请你返回可在&nbsp;<strong>一次交换</strong>（交换两数字 <code>A[i]</code> 和 <code>A[j]</code> 的位置）后得到的、按字典序排列小于 <code>A</code> 的最大可能排列。</p>
<p>如果无法这么操作，就请返回原数组。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[3,2,1]
<strong>输出：</strong>[3,1,2]
<strong>解释：</strong>
交换 2 和 1
</pre>

<p>&nbsp;</p>
<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[1,1,5]
<strong>输出：</strong>[1,1,5]
<strong>解释： </strong>
这已经是最小排列
</pre>

<p>&nbsp;</p>
<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[1,9,4,6,7]
<strong>输出：</strong>[1,7,4,6,9]
<strong>解释：</strong>
交换 9 和 7
</pre>

<p>&nbsp;</p>
<p><strong>示例&nbsp;4：</strong></p>
<pre><strong>输入：</strong>[3,1,1,3]
<strong>输出：</strong>[1,3,1,3]
<strong>解释：
</strong>交换 1 和 3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 10000</code></li>
	<li><code>1 &lt;= A[i] &lt;= 10000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i >= 0; --i) {
            if (A[i] > A[i + 1]) {
                int k = i + 1;
                for (int j = k + 1; j < A.length; ++j) {
                    if (A[j] < A[i] && A[j] > A[k]) {
                        k = j;
                    }
                }
                int t = A[i];
                A[i] = A[k];
                A[k] = t;
                return A;
            }
        }
        return A;
    }
}
```

# [1054. 距离相等的条形码](https://leetcode-cn.com/problems/distant-barcodes)
## 题目描述

<p>在一个仓库里，有一排条形码，其中第 <code>i</code> 个条形码为&nbsp;<code>barcodes[i]</code>。</p>
<p>请你重新排列这些条形码，使其中两个相邻的条形码 <strong>不能</strong> 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,1,1,2,2,2]
<strong>输出：</strong>[2,1,2,1,2,1]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[1,1,1,1,2,2,3,3]
<strong>输出：</strong>[1,3,1,3,2,1,2,1]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= barcodes.length &lt;= 10000</code></li>
	<li><code>1 &lt;= barcodes[i] &lt;= 10000</code></li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : barcodes) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Data[] ds = new Data[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ds[i++] = new Data(entry.getKey(), entry.getValue());
        }
        Arrays.sort(ds);
        i = 0;
        for (Data d : ds) {
            while (d.cnt-- > 0) {
                barcodes[i] = d.x;
                i += 2;
                if (i >= barcodes.length) {
                    i = 1;
                }
            }
        }
        return barcodes;
    }
    class Data implements Comparable<Data> {
        int x, cnt;
        public Data(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Data o) {
            return Integer.compare(o.cnt, cnt);
        }
    }
}
```

# [1071. 字符串的最大公因子](https://leetcode-cn.com/problems/greatest-common-divisor-of-strings)
## 题目描述

<p>对于字符串&nbsp;<code>S</code> 和&nbsp;<code>T</code>，只有在 <code>S = T + ... + T</code>（<code>T</code>&nbsp;与自身连接 1 次或多次）时，我们才认定&nbsp;&ldquo;<code>T</code> 能除尽 <code>S</code>&rdquo;。</p>
<p>返回最长字符串&nbsp;<code>X</code>，要求满足&nbsp;<code>X</code> 能除尽 <code>str1</code> 且&nbsp;<code>X</code> 能除尽 <code>str2</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>str1 = &quot;ABCABC&quot;, str2 = &quot;ABC&quot;
<strong>输出：</strong>&quot;ABC&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>str1 = &quot;ABABAB&quot;, str2 = &quot;ABAB&quot;
<strong>输出：</strong>&quot;AB&quot;
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>str1 = &quot;LEET&quot;, str2 = &quot;CODE&quot;
<strong>输出：</strong>&quot;&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= str1.length &lt;= 1000</code></li>
	<li><code>1 &lt;= str2.length &lt;= 1000</code></li>
	<li><code>str1[i]</code> 和&nbsp;<code>str2[i]</code> 为大写英文字母</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len = gcd(str1.length(), str2.length());
        return str1.substring(0, len);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

# [1072. 按列翻转得到最大值等行数](https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows)
## 题目描述

<p>给定由若干 0 和 1 组成的矩阵&nbsp;<code>matrix</code>，从中选出任意数量的列并翻转其上的&nbsp;<strong>每个&nbsp;</strong>单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。</p>
<p>返回经过一些翻转后，行上所有值都相等的最大行数。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[[0,1],[1,1]]
<strong>输出：</strong>1
<strong>解释：</strong>不进行翻转，有 1 行所有值都相等。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[[0,1],[1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>翻转第一列的值之后，这两行都由相等的值组成。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[[0,0,0],[0,0,1],[1,1,0]]
<strong>输出：</strong>2
<strong>解释：</strong>翻转前两列的值之后，后两行由相等的值组成。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= matrix.length &lt;= 300</code></li>
	<li><code>1 &lt;= matrix[i].length &lt;= 300</code></li>
	<li>所有 <code>matrix[i].length</code>&nbsp;都相等</li>
	<li><code>matrix[i][j]</code> 为&nbsp;<code>0</code> 或&nbsp;<code>1</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            if (row[0] == 1) {
                for (int i = 0; i < row.length; ++i) {
                    row[i] ^= 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int x : row) {
                sb.append(x);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.values().stream().max(Integer::compareTo).get();
    }
}
```

# [1073. 负二进制数相加](https://leetcode-cn.com/problems/adding-two-negabinary-numbers)
## 题目描述

<p>给出基数为 <strong>-2</strong>&nbsp;的两个数&nbsp;<code>arr1</code> 和&nbsp;<code>arr2</code>，返回两数相加的结果。</p>
<p>数字以&nbsp;<strong>数组形式&nbsp;</strong>给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，<code>arr&nbsp;= [1,1,0,1]</code>&nbsp;表示数字&nbsp;<code>(-2)^3&nbsp;+ (-2)^2 + (-2)^0 = -3</code>。<strong>数组形式&nbsp;</strong>的数字也同样不含前导零：以 <code>arr</code> 为例，这意味着要么&nbsp;<code>arr == [0]</code>，要么&nbsp;<code>arr[0] == 1</code>。</p>
<p>返回相同表示形式的 <code>arr1</code> 和 <code>arr2</code> 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>arr1 = [1,1,1,1,1], arr2 = [1,0,1]
<strong>输出：</strong>[1,0,0,0,0]
<strong>解释：</strong>arr1 表示 11，arr2 表示 5，输出表示 16 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= arr1.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr2.length &lt;= 1000</code></li>
	<li><code>arr1</code> 和&nbsp;<code>arr2</code>&nbsp;都不含前导零</li>
	<li><code>arr1[i]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
	<li><code>arr2[i]</code>&nbsp;为&nbsp;<code>0</code> 或&nbsp;<code>1</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for (int i = arr1.length - 1, j = arr2.length - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            carry += (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
            list.add(carry & 1);
            carry = -(carry >> 1);
        }
        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(x -> x).toArray();
    }
}
```


# [1079. 活字印刷](https://leetcode-cn.com/problems/letter-tile-possibilities)
## 题目描述

<p>你有一套活字字模&nbsp;<code>tiles</code>，其中每个字模上都刻有一个字母&nbsp;<code>tiles[i]</code>。返回你可以印出的非空字母序列的数目。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>&quot;AAB&quot;
<strong>输出：</strong>8
<strong>解释：</strong>可能的序列为 &quot;A&quot;, &quot;B&quot;, &quot;AA&quot;, &quot;AB&quot;, &quot;BA&quot;, &quot;AAB&quot;, &quot;ABA&quot;, &quot;BAA&quot;。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>&quot;AAABBC&quot;
<strong>输出：</strong>188
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= tiles.length &lt;= 7</code></li>
	<li><code>tiles</code> 由大写英文字母组成</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }
    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++res;
                --cnt[i];
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }
}
```

# [1080. 根到叶路径上的不足节点](https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths)
## 题目描述

<p>给定一棵二叉树的根 <code>root</code>，请你考虑它所有&nbsp;<strong>从根到叶的路径</strong>：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）</p>
<p>假如通过节点 <code>node</code> 的每种可能的 &ldquo;根-叶&rdquo; 路径上值的总和全都小于给定的 <code>limit</code>，则该节点被称之为「不足节点」，需要被删除。</p>
<p>请你删除所有不足节点，并返回生成的二叉树的根。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000904885.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>
输入：</strong>root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022500092150.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre>
<strong>
输出：</strong>[1,2,3,4,null,null,7,8,9,null,14]
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000935299.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>
输入：</strong>root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000951821.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>
输出：</strong>[5,4,8,11,null,17,4,7,null,null,null,5]</pre>

<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001008639.png)
<pre><strong>
输入：</strong>root = [5,-6,-6], limit = 0<strong>
输出：</strong>[]</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>给定的树有&nbsp;<code>1</code>&nbsp;到&nbsp;<code>5000</code>&nbsp;个节点</li>
	<li><code>-10^5&nbsp;&lt;= node.val &lt;= 10^5</code></li>
	<li><code>-10^9 &lt;= limit&nbsp;&lt;= 10^9</code></li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);
        return root.left == null && root.right == null ? null : root;
    }
}
```

# [1081. 不同字符的最小子序列](https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters)
## 题目描述

<p>返回字符串 <code>text</code>&nbsp;中按字典序排列最小的子序列，该子序列包含&nbsp;<code>text</code>&nbsp;中所有不同字符一次。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>&quot;cdadabcc&quot;
<strong>输出：</strong>&quot;adbc&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>&quot;abcd&quot;
<strong>输出：</strong>&quot;abcd&quot;
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>&quot;ecbacba&quot;
<strong>输出：</strong>&quot;eacb&quot;
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>&quot;leetcode&quot;
<strong>输出：</strong>&quot;letcod&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= text.length &lt;= 1000</code></li>
	<li><code>text</code>&nbsp;由小写英文字母组成</li>
</ol>
<p>&nbsp;</p>
<p><strong>注意：</strong>本题目与 316 <a href="https://leetcode-cn.com/problems/remove-duplicate-letters/">https://leetcode-cn.com/problems/remove-duplicate-letters/</a> 相同</p>

## 解法

### **Java**
```java
class Solution {
    public String smallestSubsequence(String text) {
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            ++cnt[c - 'a'];
        }
        boolean[] vis = new boolean[26];
        char[] cs = new char[text.length()];
        int top = -1;
        for (char c : text.toCharArray()) {
            --cnt[c - 'a'];
            if (!vis[c - 'a']) {
                while (top >= 0 && c < cs[top] && cnt[cs[top] - 'a'] > 0) {
                    vis[cs[top--] - 'a'] = false;
                }
                cs[++top] = c;
                vis[c - 'a'] = true;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}
```

# [1089. 复写零](https://leetcode-cn.com/problems/duplicate-zeros)
## 题目描述

<p>给你一个长度固定的整数数组&nbsp;<code>arr</code>，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。</p>
<p>注意：请不要在超过该数组长度的位置写入元素。</p>
<p>要求：请对输入的数组&nbsp;<strong>就地&nbsp;</strong>进行上述修改，不要从函数返回任何东西。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[1,0,2,3,0,4,5,0]
<strong>输出：</strong>null
<strong>解释：</strong>调用函数后，<strong>输入</strong>的数组将被修改为：[1,0,0,2,3,0,0,4]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[1,2,3]
<strong>输出：</strong>null
<strong>解释：</strong>调用函数后，<strong>输入</strong>的数组将被修改为：[1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= arr.length &lt;= 10000</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) ++j;
            ++i;
            ++j;
        }
        --i;    // i 回到最后一次合法的位置
        --j;    // j 同理，但 j 仍可能等于 n（例如输入 [0]）
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0) arr[--j] = arr[i];
            --i;
            --j;
        }
    }
}
```

# [1090. 受标签影响的最大值](https://leetcode-cn.com/problems/largest-values-from-labels)
## 题目描述

<p>我们有一个项的集合，其中第&nbsp;<code>i</code>&nbsp;项的值为&nbsp;<code>values[i]</code>，标签为&nbsp;<code>labels[i]</code>。</p>
<p>我们从这些项中选出一个子集&nbsp;<code>S</code>，这样一来：</p>
<ul>
	<li><code>|S| &lt;= num_wanted</code></li>
	<li>对于任意的标签 <code>L</code>，子集 <code>S</code> 中标签为 <code>L</code>&nbsp;的项的数目总满足&nbsp;<code>&lt;= use_limit</code>。</li>
</ul>
<p>返回子集&nbsp;<code>S</code>&nbsp;的最大可能的&nbsp;<strong>和</strong>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>values = [5,4,3,2,1], labels = [1,1,2,2,3], <code>num_wanted </code>= 3, use_limit = 1
<strong>输出：</strong>9
<strong>解释：</strong>选出的子集是第一项，第三项和第五项。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>values = [5,4,3,2,1], labels = [1,3,3,3,2], <code>num_wanted </code>= 3, use_limit = 2
<strong>输出：</strong>12
<strong>解释：</strong>选出的子集是第一项，第二项和第三项。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>values = [9,8,8,7,6], labels = [0,0,0,1,1], <code>num_wanted </code>= 3, use_limit = 1
<strong>输出：</strong>16
<strong>解释：</strong>选出的子集是第一项和第四项。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>values = [9,8,8,7,6], labels = [0,0,0,1,1], <code>num_wanted </code>= 3, use_limit = 2
<strong>输出：</strong>24
<strong>解释：</strong>选出的子集是第一项，第二项和第四项。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= values.length == labels.length &lt;= 20000</code></li>
	<li><code>0 &lt;= values[i], labels[i]&nbsp;&lt;= 20000</code></li>
	<li><code>1 &lt;= num_wanted, use_limit&nbsp;&lt;= values.length</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        class Data implements Comparable<Data> {
            int value, label;
            public Data(int value, int label) {
                this.value = value;
                this.label = label;
            }
            @Override
            public int compareTo(Data o) {
                return Integer.compare(o.value, this.value);
            }
        }
        int n = values.length;
        Data[] ds = new Data[n];
        for (int i = 0; i < n; ++i) {
            ds[i] = new Data(values[i], labels[i]);
        }
        Arrays.sort(ds);
        int[] map = new int[20001];
        int res = 0;
        for (int i = 0; i < n && num_wanted != 0; ++i) {
            if (++map[ds[i].label] <= use_limit) {
                res += ds[i].value;
                --num_wanted;
            }
        }
        return res;
    }
}
```

# [1091. 二进制矩阵中的最短路径](https://leetcode-cn.com/problems/shortest-path-in-binary-matrix)
## 题目描述

<p>在一个&nbsp;N &times;&nbsp;N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。</p>
<p>一条从左上角到右下角、长度为 <code>k</code> 的畅通路径，由满足下述条件的单元格&nbsp;<code>C_1, C_2, ..., C_k</code>&nbsp;组成：</p>
<ul>
	<li>相邻单元格&nbsp;<code>C_i</code> 和&nbsp;<code>C_{i+1}</code>&nbsp;在八个方向之一上连通（此时，<code>C_i</code> 和&nbsp;<code>C_{i+1}</code>&nbsp;不同且共享边或角）</li>
	<li><code>C_1</code> 位于&nbsp;<code>(0, 0)</code>（即，值为&nbsp;<code>grid[0][0]</code>）</li>
	<li><code>C_k</code>&nbsp;位于&nbsp;<code>(N-1, N-1)</code>（即，值为&nbsp;<code>grid[N-1][N-1]</code>）</li>
	<li>如果 <code>C_i</code> 位于&nbsp;<code>(r, c)</code>，则 <code>grid[r][c]</code>&nbsp;为空（即，<code>grid[r][c] ==&nbsp;0</code>）</li>
</ul>
<p>返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[[0,1],[1,0]]</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001039526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输出：</strong>2</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001052248.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[[0,0,0],[1,1,0],[1,1,0]]</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001114954.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输出：</strong>4</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001209381.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= grid.length == grid[0].length &lt;= 100</code></li>
	<li><code>grid[i][j]</code> 为&nbsp;<code>0</code> 或&nbsp;<code>1</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int[][] dirs = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 0) {
                        vis[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            ++res;
        }
        return -1;
    }
}
```

# [1093. 大样本统计](https://leetcode-cn.com/problems/statistics-from-a-large-sample)
## 题目描述

<p>我们对&nbsp;<code>0</code>&nbsp;到&nbsp;<code>255</code>&nbsp;之间的整数进行采样，并将结果存储在数组&nbsp;<code>count</code>&nbsp;中：<code>count[k]</code>&nbsp;就是整数&nbsp;<code>k</code> 的采样个数。</p>
<p>我们以&nbsp;<strong>浮点数&nbsp;</strong>数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。</p>
<p>我们先来回顾一下中位数的知识：</p>
<ul>
	<li>如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；</li>
	<li>如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
<strong>输出：</strong>[1.00000,3.00000,2.37500,2.50000,3.00000]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
<strong>输出：</strong>[1.00000,4.00000,2.18182,2.00000,1.00000]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>count.length == 256</code></li>
	<li><code>1 &lt;= sum(count) &lt;= 10^9</code></li>
	<li>计数表示的众数是唯一的</li>
	<li>答案与真实值误差在&nbsp;<code>10^-5</code>&nbsp;以内就会被视为正确答案</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public double[] sampleStats(int[] count) {
        int n = count.length;
        int mode = 0, modeMax = 0;
        int min = -1, max = -1;
        double avg = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (count[i] > modeMax) {
                modeMax = count[i];
                mode = i;
            }
            if (count[i] != 0) {
                cnt += count[i];
                avg += count[i] * i;
                if (min == -1) min = i;
                max = i;
            }
        }
        avg /= cnt;
        // 求中位数
        double mid = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += count[i];
            if (sum << 1 > cnt) {
                mid = i;
                break;
            } else if (sum << 1 == cnt) {
                for (int j = i + 1; j < n; ++j) {
                    if (count[j] != 0) {
                        mid = (i + j) / 2.0;
                        break;
                    }
                }
                break;
            }
        }
        return new double[]{min, max, avg, mid, mode};
    }
}
```

# [1094. 拼车](https://leetcode-cn.com/problems/car-pooling)
## 题目描述

<p>假设你是一位顺风车司机，车上最初有&nbsp;<code>capacity</code>&nbsp;个空座位可以用来载客。由于道路的限制，车&nbsp;<strong>只能&nbsp;</strong>向一个方向行驶（也就是说，<strong>不允许掉头或改变方向</strong>，你可以将其想象为一个向量）。</p>
<p>这儿有一份行程计划表&nbsp;<code>trips[][]</code>，其中&nbsp;<code>trips[i] = [num_passengers, start_location, end_location]</code>&nbsp;包含了你的第 <code>i</code>&nbsp;次行程信息：</p>
<ul>
	<li>必须接送的乘客数量；</li>
	<li>乘客的上车地点；</li>
	<li>以及乘客的下车地点。</li>
</ul>
<p>这些给出的地点位置是从你的&nbsp;<strong>初始&nbsp;</strong>出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。</p>
<p>请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所用乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回&nbsp;<code>true</code>，否则请返回 <code>false</code>）。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 4
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 5
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>trips = [[2,1,5],[3,5,7]], capacity = 3
<strong>输出：</strong>true
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>你可以假设乘客会自觉遵守 &ldquo;<strong>先下后上</strong>&rdquo; 的良好素质</li>
	<li><code>trips.length &lt;= 1000</code></li>
	<li><code>trips[i].length == 3</code></li>
	<li><code>1 &lt;= trips[i][0] &lt;= 100</code></li>
	<li><code>0 &lt;= trips[i][1] &lt; trips[i][2] &lt;= 1000</code></li>
	<li><code>1 &lt;=&nbsp;capacity &lt;= 100000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cnt = new int[1001];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }
        if (cnt[0] > capacity) return false;
        for (int i = 1; i < 1001; ++i) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
```


# [1103. 分糖果 II](https://leetcode-cn.com/problems/distribute-candies-to-people)
## 题目描述

<p>排排坐，分糖果。</p>
<p>我们买了一些糖果 <code>candies</code>，打算把它们分给排好队的 <strong><code>n = num_people</code></strong> 个小朋友。</p>
<p>给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 <code>n</code>&nbsp;颗糖果。</p>
<p>然后，我们再回到队伍的起点，给第一个小朋友 <code>n&nbsp;+ 1</code> 颗糖果，第二个小朋友 <code>n&nbsp;+ 2</code> 颗，依此类推，直到给最后一个小朋友 <code>2 * n</code>&nbsp;颗糖果。</p>
<p>重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。</p>
<p>返回一个长度为 <code>num_people</code>、元素之和为 <code>candies</code> 的数组，以表示糖果的最终分发情况（即 <code>ans[i]</code> 表示第 <code>i</code> 个小朋友分到的糖果数）。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>candies = 7, num_people = 4
<strong>输出：</strong>[1,2,3,1]
<strong>解释：</strong>
第一次，ans[0] += 1，数组变为 [1,0,0,0]。
第二次，ans[1] += 2，数组变为 [1,2,0,0]。
第三次，ans[2] += 3，数组变为 [1,2,3,0]。
第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>candies = 10, num_people = 3
<strong>输出：</strong>[5,2,3]
<strong>解释：</strong>
第一次，ans[0] += 1，数组变为 [1,0,0]。
第二次，ans[1] += 2，数组变为 [1,2,0]。
第三次，ans[2] += 3，数组变为 [1,2,3]。
第四次，ans[0] += 4，最终数组变为 [5,2,3]。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= candies &lt;= 10^9</code></li>
	<li><code>1 &lt;= num_people &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 0, cur = 1; candies > 0; ++i, ++cur) {
            if (i == num_people) {
                i = 0;
            }
            if (candies >= cur) {
                res[i] += cur;
                candies -= cur;
            } else {
                res[i] += candies;
                candies = 0;
            }
        }
        return res;
    }
}
```

# [1104. 二叉树寻路](https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree)
## 题目描述

<p>在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 <strong>逐行</strong> 依次按&nbsp;&ldquo;之&rdquo; 字形进行标记。</p>
<p>如下图所示，在奇数行（即，第一行、第三行、第五行&hellip;&hellip;）中，按从左到右的顺序进行标记；</p>
<p>而偶数行（即，第二行、第四行、第六行&hellip;&hellip;）中，按从右到左的顺序进行标记。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001256443.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>给你树上某一个节点的标号 <code>label</code>，请你返回从根节点到该标号为 <code>label</code> 节点的路径，该路径是由途经的节点标号所组成的。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>label = 14
<strong>输出：</strong>[1,3,4,14]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>label = 26
<strong>输出：</strong>[1,2,6,10,26]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= label &lt;= 10^6</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int n = Integer.highestOneBit(label);
        while (label > 0) {
            res.add(label);
            int pos = ((n << 1) - 1 - label) >> 1;
            label = (n >> 1) + pos;
            n >>= 1;
        }
        Collections.reverse(res);
        return res;
    }
}
```

# [1108. IP 地址无效化](https://leetcode-cn.com/problems/defanging-an-ip-address)
## 题目描述

<p>给你一个有效的 <a href="https://baike.baidu.com/item/IPv4" target="_blank">IPv4</a> 地址&nbsp;<code>address</code>，返回这个 IP 地址的无效化版本。</p>
<p>所谓无效化&nbsp;IP 地址，其实就是用&nbsp;<code>&quot;[.]&quot;</code>&nbsp;代替了每个 <code>&quot;.&quot;</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>address = &quot;1.1.1.1&quot;
<strong>输出：</strong>&quot;1[.]1[.]1[.]1&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>address = &quot;255.100.50.0&quot;
<strong>输出：</strong>&quot;255[.]100[.]50[.]0&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给出的&nbsp;<code>address</code>&nbsp;是一个有效的 IPv4 地址</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
```

# [1109. 航班预订统计](https://leetcode-cn.com/problems/corporate-flight-bookings)
## 题目描述

<p>这里有&nbsp;<code>n</code>&nbsp;个航班，它们分别从 <code>1</code> 到 <code>n</code> 进行编号。</p>
<p>我们这儿有一份航班预订表，表中第&nbsp;<code>i</code>&nbsp;条预订记录&nbsp;<code>bookings[i] = [i, j, k]</code>&nbsp;意味着我们在从&nbsp;<code>i</code>&nbsp;到&nbsp;<code>j</code>&nbsp;的每个航班上预订了 <code>k</code> 个座位。</p>
<p>请你返回一个长度为 <code>n</code> 的数组&nbsp;<code>answer</code>，按航班编号顺序返回每个航班上预订的座位数。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
<strong>输出：</strong>[10,55,45,25,25]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= bookings.length &lt;= 20000</code></li>
	<li><code>1 &lt;= bookings[i][0] &lt;= bookings[i][1] &lt;= n &lt;= 20000</code></li>
	<li><code>1 &lt;= bookings[i][2] &lt;= 10000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int b = booking[0] - 1, e = booking[1], k = booking[2];
            res[b] += k;
            if (e < n) {
                res[e] -= k;
            }
        }
        for (int i = 1; i < n; ++i) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
```

# [1110. 删点成林](https://leetcode-cn.com/problems/delete-nodes-and-return-forest)
## 题目描述

<p>给出二叉树的根节点&nbsp;<code>root</code>，树上每个节点都有一个不同的值。</p>
<p>如果节点值在&nbsp;<code>to_delete</code>&nbsp;中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。</p>
<p>返回森林中的每棵树。你可以按任意顺序组织答案。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001325655.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>root = [1,2,3,4,5,6,7], to_delete = [3,5]
<strong>输出：</strong>[[1,2,null,4],[6],[7]]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>树中的节点数最大为&nbsp;<code>1000</code>。</li>
	<li>每个节点都有一个介于&nbsp;<code>1</code> 到&nbsp;<code>1000</code>&nbsp;之间的值，且各不相同。</li>
	<li><code>to_delete.length &lt;= 1000</code></li>
	<li><code>to_delete</code> 包含一些从&nbsp;<code>1</code> 到&nbsp;<code>1000</code>、各不相同的值。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] del = new boolean[1001];
        for (int d : to_delete) {
            del[d] = true;
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(root, true, del, res);
        return res;
    }
    private TreeNode dfs(TreeNode root, boolean isRoot, boolean[] del, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        boolean flag = del[root.val];
        if (!flag && isRoot) {
            res.add(root);
        }
        root.left = dfs(root.left, flag, del, res);
        root.right = dfs(root.right, flag, del, res);
        return flag ? null : root;
    }
}
```

# [1111. 有效括号的嵌套深度](https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings)
## 题目描述

<p><strong>有效括号字符串</strong> 仅由&nbsp;<code>&quot;(&quot;</code> 和&nbsp;<code>&quot;)&quot;</code>&nbsp;构成，并符合下述几个条件之一：</p>
<ul>
	<li>空字符串</li>
	<li>连接，可以记作&nbsp;<code>AB</code>（<code>A</code> 与 <code>B</code> 连接），其中&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;都是有效括号字符串</li>
	<li>嵌套，可以记作&nbsp;<code>(A)</code>，其中&nbsp;<code>A</code>&nbsp;是有效括号字符串</li>
</ul>
<p>类似地，我们可以定义任意有效括号字符串 <code>s</code> 的 <strong>嵌套深度</strong>&nbsp;<code>depth(S)</code>：</p>
<ul>
	<li><code>s</code> 为空时，<code>depth(&quot;&quot;) = 0</code></li>
	<li><code>s</code> 为 <code>A</code> 与 <code>B</code> 连接时，<code>depth(A + B) = max(depth(A), depth(B))</code>，其中&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;都是有效括号字符串</li>
	<li><code>s</code> 为嵌套情况，<code>depth(&quot;(&quot; + A + &quot;)&quot;) = 1 + depth(A)</code>，其中 A 是有效括号字符串</li>
</ul>
<p>例如：<code>&quot;&quot;</code>，<code>&quot;()()&quot;</code>，和&nbsp;<code>&quot;()(()())&quot;</code>&nbsp;都是有效括号字符串，嵌套深度分别为 0，1，2，而&nbsp;<code>&quot;)(&quot;</code> 和&nbsp;<code>&quot;(()&quot;</code>&nbsp;都不是有效括号字符串。</p>
<p>&nbsp;</p>
<p>给你一个有效括号字符串 <code>seq</code>，将其分成两个不相交的子序列&nbsp;<code>A</code> 和&nbsp;<code>B</code>，且&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;满足有效括号字符串的定义（注意：<code>A.length + B.length = seq.length</code>）。</p>
<p>现在，你需要从中选出 <strong>任意</strong>&nbsp;一组有效括号字符串&nbsp;<code>A</code> 和&nbsp;<code>B</code>，使&nbsp;<code>max(depth(A), depth(B))</code>&nbsp;的可能取值最小。</p>
<p>返回长度为&nbsp;<code>seq.length</code> 答案数组&nbsp;<code>answer</code>&nbsp;，选择&nbsp;<code>A</code>&nbsp;还是&nbsp;<code>B</code>&nbsp;的编码规则是：如果&nbsp;<code>seq[i]</code>&nbsp;是&nbsp;<code>A</code>&nbsp;的一部分，那么&nbsp;<code>answer[i] = 0</code>。否则，<code>answer[i] = 1</code>。即便有多个满足要求的答案存在，你也只需返回&nbsp;<strong>一个</strong>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>seq = &quot;(()())&quot;
<strong>输出：</strong>[0,1,1,1,1,0]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>seq = &quot;()(())()&quot;
<strong>输出：</strong>[0,0,0,1,1,0,1,1]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= text.size &lt;= 10000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        for (int i = 0, cnt = 0; i < res.length; ++i) {
            if (seq.charAt(i) == '(') {
                res[i] = cnt++ & 1;
            } else {
                res[i] = --cnt & 1;
            }
        }
        return res;
    }
}
```

# [1114. 按序打印](https://leetcode-cn.com/problems/print-in-order)
## 题目描述

<p>我们提供了一个类：</p>
<pre>
public class Foo {
&nbsp; public void one() { print(&quot;one&quot;); }
&nbsp; public void two() { print(&quot;two&quot;); }
&nbsp; public void three() { print(&quot;three&quot;); }
}
</pre>

<p>三个不同的线程将会共用一个&nbsp;<code>Foo</code>&nbsp;实例。</p>
<ul>
	<li>线程 A 将会调用 <code>one()</code> 方法</li>
	<li>线程 B 将会调用&nbsp;<code>two()</code> 方法</li>
	<li>线程 C 将会调用 <code>three()</code> 方法</li>
</ul>
<p>请设计修改程序，以确保 <code>two()</code> 方法在 <code>one()</code> 方法之后被执行，<code>three()</code> 方法在 <code>two()</code> 方法之后被执行。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> [1,2,3]
<strong>输出:</strong> &quot;onetwothree&quot;
<strong>解释:</strong> 
有三个线程会被异步启动。
输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
正确的输出是 &quot;onetwothree&quot;。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> [1,3,2]
<strong>输出:</strong> &quot;onetwothree&quot;
<strong>解释:</strong> 
输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
正确的输出是 &quot;onetwothree&quot;。</pre>

<p>&nbsp;</p>
<p><strong>注意:</strong></p>
<p>尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。</p>
<p>你看到的输入格式主要是为了确保测试的全面性。</p>

## 解法

### **Java**
```java
import java.util.concurrent.Semaphore;
class Foo {
    private Semaphore twoS = new Semaphore(0);
    private Semaphore threeS = new Semaphore(0);
    
    public Foo() {
        
    }
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        twoS.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
        twoS.acquire();
        printSecond.run();
        threeS.release();
    }
    public void third(Runnable printThird) throws InterruptedException {
        threeS.acquire();
        printThird.run();
    }
}
```

# [1115. 交替打印 FooBar](https://leetcode-cn.com/problems/print-foobar-alternately)
## 题目描述

<p>我们提供一个类：</p>
<pre>
class FooBar {
  public void foo() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print(&quot;foo&quot;);
&nbsp;   }
  }
  public void bar() {
&nbsp; &nbsp; for (int i = 0; i &lt; n; i++) {
&nbsp; &nbsp; &nbsp; print(&quot;bar&quot;);
&nbsp; &nbsp; }
  }
}
</pre>

<p>两个不同的线程将会共用一个 <code>FooBar</code>&nbsp;实例。其中一个线程将会调用&nbsp;<code>foo()</code>&nbsp;方法，另一个线程将会调用&nbsp;<code>bar()</code>&nbsp;方法。</p>
<p>请设计修改程序，以确保 &quot;foobar&quot; 被输出 n 次。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> n = 1
<strong>输出:</strong> &quot;foobar&quot;
<strong>解释:</strong> 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，&quot;foobar&quot; 将被输出一次。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> n = 2
<strong>输出:</strong> &quot;foobarfoobar&quot;
<strong>解释:</strong> &quot;foobar&quot; 将被输出两次。
</pre>


## 解法

### **Java**
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class FooBar {
    private int n;
    private Lock lock;
    private volatile Boolean flag;
    public FooBar(int n) {
        this.n = n;
        this.flag = true;
        this.lock = new ReentrantLock(true);
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n;) {
            lock.lock();
            if (flag) {
                printFoo.run();
                flag = false;
                i++;
            }
            lock.unlock();
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n;) {
            lock.lock();
            if (!flag) {
                printBar.run();
                flag = true;
                i++;
            }
            lock.unlock();
        }
    }
}
```

# [1116. 打印零与奇偶数](https://leetcode-cn.com/problems/print-zero-even-odd)
## 题目描述

<p>假设有这么一个类：</p>
<pre>class ZeroEvenOdd {
&nbsp; public ZeroEvenOdd(int n) { ... }&nbsp;     // 构造函数
  public void zero(printNumber) { ... }  // 仅打印出 0
  public void even(printNumber) { ... }  // 仅打印出 偶数
  public void odd(printNumber) { ... }   // 仅打印出 奇数
}
</pre>

<p>相同的一个&nbsp;<code>ZeroEvenOdd</code>&nbsp;类实例将会传递给三个不同的线程：</p>
<ol>
	<li>线程 A 将调用&nbsp;<code>zero()</code>，它只输出 0 。</li>
	<li>线程 B 将调用&nbsp;<code>even()</code>，它只输出偶数。</li>
	<li>线程 C 将调用&nbsp;<code>odd()</code>，它只输出奇数。</li>
</ol>
<p>每个线程都有一个&nbsp;<code>printNumber</code> 方法来输出一个整数。请修改给出的代码以输出整数序列&nbsp;<code>010203040506</code>... ，其中序列的长度必须为 2<em>n</em>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 2
<strong>输出：</strong>&quot;0102&quot;
<strong>说明：</strong>三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 &quot;0102&quot;。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 5
<strong>输出：</strong>&quot;0102030405&quot;
</pre>


## 解法

### **Java**
```java
class ZeroEvenOdd {
    private Semaphore zero_S;
    private Semaphore odd_S;
    private Semaphore even_S;
    private int n;
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zero_S = new Semaphore(1);
        this.odd_S = new Semaphore(0);
        this.even_S = new Semaphore(0);
    }
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i ++) {
            zero_S.acquire(1);
            printNumber.accept(0);
            if ((i & 1) == 0) {
                odd_S.release(1);
            } else {
                even_S.release(1);
            }
        }
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even_S.acquire(1);
            printNumber.accept(i);
            zero_S.release(1);
        }
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd_S.acquire(1);
            printNumber.accept(i);
            zero_S.release(1);
        }
    }
}
```

# [1117. H2O 生成](https://leetcode-cn.com/problems/building-h2o)
## 题目描述

<p>现在有两种线程，氢 <code>oxygen</code> 和氧 <code>hydrogen</code>，你的目标是组织这两种线程来产生水分子。</p>
<p>存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。</p>
<p>氢和氧线程会被分别给予 <code>releaseHydrogen</code> 和 <code>releaseOxygen</code> 方法来允许它们突破屏障。</p>
<p>这些线程应该三三成组突破屏障并能立即组合产生一个水分子。</p>
<p>你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。</p>
<p>换句话说:</p>
<ul>
	<li>如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。</li>
	<li>如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。</li>
</ul>
<p>书写满足这些限制条件的氢、氧线程同步代码。</p>
<p>&nbsp;</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入: </strong>&quot;HOH&quot;
<strong>输出: </strong>&quot;HHO&quot;
<strong>解释:</strong> &quot;HOH&quot; 和 &quot;OHH&quot; 依然都是有效解。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入: </strong>&quot;OOHHHH&quot;
<strong>输出: </strong>&quot;HHOHHO&quot;
<strong>解释:</strong> &quot;HOHHHO&quot;, &quot;OHHHHO&quot;, &quot;HHOHOH&quot;, &quot;HOHHOH&quot;, &quot;OHHHOH&quot;, &quot;HHOOHH&quot;, &quot;HOHOHH&quot; 和 &quot;OHHOHH&quot; 依然都是有效解。
</pre>

<p>&nbsp;</p>
<p><strong>限制条件:</strong></p>
<ul>
	<li>输入字符串的总长将会是 3<em>n</em>, 1 &le;&nbsp;<em>n</em>&nbsp;&le; 50；</li>
	<li>输入字符串中的 &ldquo;H&rdquo; 总数将会是 2n；</li>
	<li>输入字符串中的 &ldquo;O&rdquo; 总数将会是 n。</li>
</ul>

## 解法

### **Java**
```java
class H2O {
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);
    public H2O() {
    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}
```

# [1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array)
## 题目描述

<p>给你两个数组，<code>arr1</code> 和&nbsp;<code>arr2</code>，</p>
<ul>
	<li><code>arr2</code>&nbsp;中的元素各不相同</li>
	<li><code>arr2</code> 中的每个元素都出现在&nbsp;<code>arr1</code>&nbsp;中</li>
</ul>
<p>对 <code>arr1</code>&nbsp;中的元素进行排序，使 <code>arr1</code> 中项的相对顺序和&nbsp;<code>arr2</code>&nbsp;中的相对顺序相同。未在&nbsp;<code>arr2</code>&nbsp;中出现过的元素需要按照升序放在&nbsp;<code>arr1</code>&nbsp;的末尾。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>输出：</strong>[2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>arr1.length, arr2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li>
	<li><code>arr2</code>&nbsp;中的元素&nbsp;<code>arr2[i]</code>&nbsp;各不相同</li>
	<li><code>arr2</code> 中的每个元素&nbsp;<code>arr2[i]</code>&nbsp;都出现在&nbsp;<code>arr1</code>&nbsp;中</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for (int x : arr1) {
            ++map[x];
        }
        int i = 0;
        for (int x : arr2) {
            while (map[x]-- > 0) {
                arr1[i++] = x;
            }
        }
        for (int j = 0; j < map.length; ++j) {
            while (map[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}
```

# [1123. 最深叶节点的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves)
## 题目描述

<p>给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。</p>
<p>回想一下：</p>
<ul>
	<li><strong>叶节点</strong> 是二叉树中没有子节点的节点</li>
	<li>树的根节点的&nbsp;<strong>深度&nbsp;</strong>为&nbsp;<code>0</code>，如果某一节点的深度为&nbsp;<code>d</code>，那它的子节点的深度就是&nbsp;<code>d+1</code></li>
	<li>如果我们假定 <code>A</code> 是一组节点&nbsp;<code>S</code>&nbsp;的 <strong>最近公共祖先</strong>，<code>S</code>&nbsp;中的每个节点都在以 <code>A</code> 为根节点的子树中，且 <code>A</code>&nbsp;的深度达到此条件下可能的最大值。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>root = [1,2,3]
<strong>输出：</strong>[1,2,3]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>root = [1,2,3,4]
<strong>输出：</strong>[4]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>root = [1,2,3,4,5]
<strong>输出：</strong>[2,4,5]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给你的树中将有&nbsp;1 到 1000 个节点。</li>
	<li>树中每个节点的值都在 1 到 1000 之间。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Data data = dfs(root);
        return data.root;
    }
    private Data dfs(TreeNode root) {
        if (root == null) {
            return new Data(null, 0);
        }
        Data left = dfs(root.left);
        Data right = dfs(root.right);
        if (left.d > right.d) return new Data(left.root, 1 + left.d);
        if (left.d < right.d) return new Data(right.root, 1 + right.d);
        return new Data(root, 1 + left.d);
    }
    class Data {
        TreeNode root;
        int d;
        public Data(TreeNode root, int d) {
            this.root = root;
            this.d = d;
        }
    }
}
```

# [1124. 表现良好的最长时间段](https://leetcode-cn.com/problems/longest-well-performing-interval)
## 题目描述

<p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>
<p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>
<p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>
<p>请你返回「表现良好时间段」的最大长度。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>hours = [9,9,6,0,6,6,9]
<strong>输出：</strong>3
<strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= hours.length &lt;= 10000</code></li>
	<li><code>0 &lt;= hours[i] &lt;= 16</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int longestWPI(int[] hours) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        for (int i = 0; i < hours.length; ++i) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = i + 1;
            } else {
                int b = map.getOrDefault(s - 1, -1);
                if (b != -1) {
                    res = Math.max(res, i - b);
                }
            }
            map.putIfAbsent(s, i);
        }
        return res;
    }
}
```

# [1128. 等价多米诺骨牌对的数量](https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs)
## 题目描述

<p>给你一个由一些多米诺骨牌组成的列表&nbsp;<code>dominoes</code>。</p>
<p>如果其中某一张多米诺骨牌可以通过旋转 <code>0</code>&nbsp;度或 <code>180</code> 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。</p>
<p>形式上，<code>dominoes[i] = [a, b]</code>&nbsp;和&nbsp;<code>dominoes[j] = [c, d]</code>&nbsp;等价的前提是&nbsp;<code>a==c</code>&nbsp;且&nbsp;<code>b==d</code>，或是&nbsp;<code>a==d</code> 且&nbsp;<code>b==c</code>。</p>
<p>在&nbsp;<code>0 &lt;= i &lt; j &lt; dominoes.length</code>&nbsp;的前提下，找出满足&nbsp;<code>dominoes[i]</code> 和&nbsp;<code>dominoes[j]</code>&nbsp;等价的骨牌对 <code>(i, j)</code> 的数量。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>dominoes = [[1,2],[2,1],[3,4],[5,6]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= dominoes.length &lt;= 40000</code></li>
	<li><code>1 &lt;= dominoes[i][j] &lt;= 9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            int x = d[0] < d[1] ? d[0] * 10 + d[1] : d[1] * 10 + d[0];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (int v : map.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}
```

# [1137. 第 N 个泰波那契数](https://leetcode-cn.com/problems/n-th-tribonacci-number)
## 题目描述

<p>泰波那契序列&nbsp;T<sub>n</sub>&nbsp;定义如下：&nbsp;</p>
<p>T<sub>0</sub> = 0, T<sub>1</sub> = 1, T<sub>2</sub> = 1, 且在 n &gt;= 0&nbsp;的条件下 T<sub>n+3</sub> = T<sub>n</sub> + T<sub>n+1</sub> + T<sub>n+2</sub></p>
<p>给你整数&nbsp;<code>n</code>，请返回第 n 个泰波那契数&nbsp;T<sub>n </sub>的值。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 4
<strong>输出：</strong>4
<strong>解释：</strong>
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 25
<strong>输出：</strong>1389537
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>0 &lt;= n &lt;= 37</code></li>
	<li>答案保证是一个 32 位整数，即&nbsp;<code>answer &lt;= 2^31 - 1</code>。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int tribonacci(int n) {
        int[] f = new int[]{0, 1, 1, 2};
        for (int i = 4; i <= n; ++i) {
            f[i % 4] = f[(i - 1) % 4] + f[(i - 2) % 4] + f[(i - 3) % 4];
        }
        return f[n % 4];
    }
}
```

# [1138. 字母板上的路径](https://leetcode-cn.com/problems/alphabet-board-path)
## 题目描述

<p>我们从一块字母板上的位置&nbsp;<code>(0, 0)</code>&nbsp;出发，该坐标对应的字符为&nbsp;<code>board[0][0]</code>。</p>
<p>在本题里，字母板为<code>board = [&quot;abcde&quot;, &quot;fghij&quot;, &quot;klmno&quot;, &quot;pqrst&quot;, &quot;uvwxy&quot;, &quot;z&quot;]</code>.</p>
<p>我们可以按下面的指令规则行动：</p>
<ul>
	<li>如果方格存在，<code>&#39;U&#39;</code>&nbsp;意味着将我们的位置上移一行；</li>
	<li>如果方格存在，<code>&#39;D&#39;</code>&nbsp;意味着将我们的位置下移一行；</li>
	<li>如果方格存在，<code>&#39;L&#39;</code>&nbsp;意味着将我们的位置左移一列；</li>
	<li>如果方格存在，<code>&#39;R&#39;</code>&nbsp;意味着将我们的位置右移一列；</li>
	<li><code>&#39;!&#39;</code>&nbsp;会把在我们当前位置 <code>(r, c)</code> 的字符&nbsp;<code>board[r][c]</code>&nbsp;添加到答案中。</li>
</ul>
<p>返回指令序列，用最小的行动次数让答案和目标&nbsp;<code>target</code>&nbsp;相同。你可以返回任何达成目标的路径。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>target = &quot;leet&quot;
<strong>输出：</strong>&quot;DDR!UURRR!!DDD!&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>target = &quot;code&quot;
<strong>输出：</strong>&quot;RR!DDRR!UUL!R!&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= target.length &lt;= 100</code></li>
	<li><code>target</code>&nbsp;仅含有小写英文字母。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int dx = (c - 'a') / 5;
            int dy = (c - 'a') % 5;
            if (dy < y) {
                int n = y - dy;
                while (n-- > 0) {
                    sb.append('L');
                }
            }
            if (dx > x) {
                int n = dx - x;
                while (n-- > 0) {
                    sb.append('D');
                }
            }
            if (dx < x) {
                int n = x - dx;
                while (n-- > 0) {
                    sb.append('U');
                }
            }
            if (dy > y) {
                int n = dy - y;
                while (n-- > 0) {
                    sb.append('R');
                }
            }
            sb.append('!');
            x = dx;
            y = dy;
        }
        return sb.toString();
    }
}
```

# [1139. 最大的以 1 为边界的正方形](https://leetcode-cn.com/problems/largest-1-bordered-square)
## 题目描述

<p>给你一个由若干 <code>0</code> 和 <code>1</code> 组成的二维网格&nbsp;<code>grid</code>，请你找出边界全部由 <code>1</code> 组成的最大 <strong>正方形</strong> 子网格，并返回该子网格中的元素数量。如果不存在，则返回 <code>0</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>grid = [[1,1,1],[1,0,1],[1,1,1]]
<strong>输出：</strong>9
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>grid = [[1,1,0,0]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= grid.length &lt;= 100</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 100</code></li>
	<li><code>grid[i][j]</code> 为&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    down[i][j] += i + 1 < m ? down[i + 1][j] + 1 : 1;
                    right[i][j] += j + 1 < n ? right[i][j + 1] + 1 : 1;
                }
            }
        }
        for (int len = Math.min(m, n); len > 0; --len) {
            for (int i = 0; i <= m - len; ++i) {
                for (int j = 0; j <= n - len; ++j) {
                    if (down[i][j] >= len && right[i][j] >= len && right[i + len - 1][j] >= len && down[i][j + len - 1] >= len) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
}
```

# [1140. 石子游戏 II](https://leetcode-cn.com/problems/stone-game-ii)
## 题目描述

<p>亚历克斯和李继续他们的石子游戏。许多堆石子&nbsp;<strong>排成一行</strong>，每堆都有正整数颗石子&nbsp;<code>piles[i]</code>。游戏以谁手中的石子最多来决出胜负。</p>
<p>亚历克斯和李轮流进行，亚历克斯先开始。最初，<code>M = 1</code>。</p>
<p>在每个玩家的回合中，该玩家可以拿走剩下的&nbsp;<strong>前</strong>&nbsp;<code>X</code>&nbsp;堆的所有石子，其中&nbsp;<code>1 &lt;= X &lt;= 2M</code>。然后，令&nbsp;<code>M = max(M, X)</code>。</p>
<p>游戏一直持续到所有石子都被拿走。</p>
<p>假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>piles = [2,7,9,4,4]
<strong>输出：</strong>10
<strong>解释：
</strong>如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。 
如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
所以我们返回更大的 10。 
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= piles.length &lt;= 100</code></li>
	<li><code>1 &lt;= piles[i]&nbsp;&lt;= 10 ^ 4</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int stoneGameII(int[] piles) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = Arrays.stream(piles).sum();
        return (total + dfs(0, 1, piles, map)) >> 1;
    }
    private int dfs(int s, int M, int[] piles, Map<Integer, Integer> map) {
        if (s >= piles.length) {
            return 0;
        }
        int key = s << 8 | M;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (s + 2 * M >= piles.length) {
            int res = 0;
            for (int i = s; i < piles.length; ++i) {
                res += piles[i];
            }
            return res;
        }
        int best = Integer.MIN_VALUE;
        int cur = 0;
        for (int x = 1; x <= 2 * M && s + x - 1 < piles.length; ++x) {
            cur += piles[s + x - 1];
            best = Math.max(best, cur - dfs(s + x, Math.max(x, M), piles, map));
        }
        map.put(key, best);
        return best;
    }
}
```

# [1144. 递减元素使数组呈锯齿状](https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag)
## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code>，每次 <strong>操作</strong>&nbsp;会从中选择一个元素并 <strong>将该元素的值减少&nbsp;1</strong>。</p>
<p>如果符合下列情况之一，则数组&nbsp;<code>A</code>&nbsp;就是 <strong>锯齿数组</strong>：</p>
<ul>
	<li>每个偶数索引对应的元素都大于相邻的元素，即&nbsp;<code>A[0] &gt; A[1] &lt; A[2] &gt; A[3] &lt; A[4] &gt; ...</code></li>
	<li>或者，每个奇数索引对应的元素都大于相邻的元素，即&nbsp;<code>A[0] &lt; A[1] &gt; A[2] &lt; A[3] &gt; A[4] &lt; ...</code></li>
</ul>
<p>返回将数组&nbsp;<code>nums</code>&nbsp;转换为锯齿数组所需的最小操作次数。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>2
<strong>解释：</strong>我们可以把 2 递减到 0，或把 3 递减到 1。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>nums = [9,6,1,6,2]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int[] res = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i + 1 < n ? nums[i + 1] : Integer.MAX_VALUE;
            res[i & 1] += Math.max(0, nums[i] - (Math.min(left, right) - 1));
        }
        return Math.min(res[0], res[1]);
    }
}
```


# [1155. 掷骰子的 N 种方法](https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum)
## 题目描述

<p>这里有&nbsp;<code>d</code>&nbsp;个一样的骰子，每个骰子上都有&nbsp;<code>f</code>&nbsp;个面，分别标号为&nbsp;<code>1, 2, ..., f</code>。</p>
<p>我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。</p>
<p>如果需要掷出的总点数为&nbsp;<code>target</code>，请你计算出有多少种不同的组合情况（所有的组合情况总共有 <code>f^d</code> 种），<strong>模&nbsp;<code>10^9 + 7</code></strong>&nbsp;后返回。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>d = 1, f = 6, target = 3
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>d = 2, f = 6, target = 7
<strong>输出：</strong>6
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>d = 2, f = 5, target = 10
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>d = 1, f = 2, target = 3
<strong>输出：</strong>0
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>d = 30, f = 30, target = 500
<strong>输出：</strong>222616187</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= d, f &lt;= 30</code></li>
	<li><code>1 &lt;= target &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; ++i) {
            for (int j = 1; j <= target; ++j) {
                // j 大于当前所有骰子的最大和，不可能满足条件
                if (j > i * f) {
                    break;
                }
                for (int k = 1; k <= f && k <= j; ++k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
                }
            }
        }
        return dp[d][target];
    }
}
```

# [1171. 从链表中删去总和值为零的连续节点](https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list)
## 题目描述

<p>给你一个链表的头节点&nbsp;<code>head</code>，请你编写代码，反复删去链表中由 <strong>总和</strong>&nbsp;值为 <code>0</code> 的连续节点组成的序列，直到不存在这样的序列为止。</p>
<p>删除完毕后，请你返回最终结果链表的头节点。</p>
<p>&nbsp;</p>
<p>你可以返回任何满足题目要求的答案。</p>
<p>（注意，下面示例中的所有序列，都是对&nbsp;<code>ListNode</code>&nbsp;对象序列化的表示。）</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>head = [1,2,-3,3,1]
<strong>输出：</strong>[3,1]
<strong>提示：</strong>答案 [1,2,1] 也是正确的。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>head = [1,2,3,-3,4]
<strong>输出：</strong>[1,2,4]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>head = [1,2,3,-3,-2]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给你的链表中可能有 <code>1</code> 到&nbsp;<code>1000</code>&nbsp;个节点。</li>
	<li>对于链表中的每个节点，节点的值：<code>-1000 &lt;= node.val &lt;= 1000</code>.</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        boolean isZeroSum = true; 
        
        while (isZeroSum) {
        	isZeroSum = false;
        	int sum = 0;
        	ListNode temp = head;
        	
        	while (temp != null) {
        		sum += temp.val;
        		
        		if (sum == 0) {
        			head = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		} else if (map.containsKey(sum)) {
        			map.get(sum).next = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		}
        		
        		map.put(sum, temp);
        		temp = temp.next;
        	}
        }
        
        return head;
    }
}
```

# [1184. 公交站间的距离](https://leetcode-cn.com/problems/distance-between-bus-stops)
## 题目描述

<p>环形公交路线上有&nbsp;<code>n</code>&nbsp;个站，按次序从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;进行编号。我们已知每一对相邻公交站之间的距离，<code>distance[i]</code>&nbsp;表示编号为&nbsp;<code>i</code>&nbsp;的车站和编号为&nbsp;<code>(i + 1) % n</code>&nbsp;的车站之间的距离。</p>
<p>环线上的公交车都可以按顺时针和逆时针的方向行驶。</p>
<p>返回乘客从出发点&nbsp;<code>start</code>&nbsp;到目的地&nbsp;<code>destination</code>&nbsp;之间的最短距离。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001441508.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 1
<strong>输出：</strong>1
<strong>解释：</strong>公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。</pre>

<p>&nbsp;</p>
<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001458651.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 2
<strong>输出：</strong>3
<strong>解释：</strong>公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
</pre>

<p>&nbsp;</p>
<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001519685.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 3
<strong>输出：</strong>4
<strong>解释：</strong>公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= n&nbsp;&lt;= 10^4</code></li>
	<li><code>distance.length == n</code></li>
	<li><code>0 &lt;= start, destination &lt; n</code></li>
	<li><code>0 &lt;= distance[i] &lt;= 10^4</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int length = 0;
        for (int i : distance) {
            length += i;
        }
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        int length2 = 0;
        for (int i = min; i < max; i++) {
            length2 += distance[i];
        }
        return Math.min(length - length2, length2);
    }
}
```

# [1185. 一周中的第几天](https://leetcode-cn.com/problems/day-of-the-week)
## 题目描述

<p>给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。</p>
<p>输入为三个整数：<code>day</code>、<code>month</code> 和&nbsp;<code>year</code>，分别表示日、月、年。</p>
<p>您返回的结果必须是这几个值中的一个&nbsp;<code>{&quot;Sunday&quot;, &quot;Monday&quot;, &quot;Tuesday&quot;, &quot;Wednesday&quot;, &quot;Thursday&quot;, &quot;Friday&quot;, &quot;Saturday&quot;}</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>day = 31, month = 8, year = 2019
<strong>输出：</strong>&quot;Saturday&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>day = 18, month = 7, year = 1999
<strong>输出：</strong>&quot;Sunday&quot;
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>day = 15, month = 8, year = 1993
<strong>输出：</strong>&quot;Sunday&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>给出的日期一定是在&nbsp;<code>1971</code> 到&nbsp;<code>2100</code>&nbsp;年之间的有效日期。</li>
</ul>

## 解法

### **Java**
```java
import java.util.Calendar;
class Solution {
    private static final String[] WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return WEEK[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
```

# [1195. 交替打印字符串](https://leetcode-cn.com/problems/fizz-buzz-multithreaded)
## 题目描述

<p>编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：</p>
<ul>
	<li>如果这个数字可以被 3 整除，输出 &quot;fizz&quot;。</li>
	<li>如果这个数字可以被 5 整除，输出&nbsp;&quot;buzz&quot;。</li>
	<li>如果这个数字可以同时被 3 和 5 整除，输出 &quot;fizzbuzz&quot;。</li>
</ul>
<p>例如，当&nbsp;<code>n = 15</code>，输出：&nbsp;<code>1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz</code>。</p>
<p>假设有这么一个类：</p>
<pre>class FizzBuzz {
&nbsp; public FizzBuzz(int n) { ... }&nbsp;              // constructor
  public void fizz(printFizz) { ... }          // only output &quot;fizz&quot;
  public void buzz(printBuzz) { ... }          // only output &quot;buzz&quot;
  public void fizzbuzz(printFizzBuzz) { ... }  // only output &quot;fizzbuzz&quot;
  public void number(printNumber) { ... }      // only output the numbers
}</pre>

<p>请你实现一个有四个线程的多线程版&nbsp;&nbsp;<code>FizzBuzz</code>，&nbsp;同一个&nbsp;<code>FizzBuzz</code>&nbsp;实例会被如下四个线程使用：</p>
<ol>
	<li>线程A将调用&nbsp;<code>fizz()</code>&nbsp;来判断是否能被 3 整除，如果可以，则输出&nbsp;<code>fizz</code>。</li>
	<li>线程B将调用&nbsp;<code>buzz()</code>&nbsp;来判断是否能被 5 整除，如果可以，则输出&nbsp;<code>buzz</code>。</li>
	<li>线程C将调用&nbsp;<code>fizzbuzz()</code>&nbsp;来判断是否同时能被 3 和 5 整除，如果可以，则输出&nbsp;<code>fizzbuzz</code>。</li>
	<li>线程D将调用&nbsp;<code>number()</code>&nbsp;来实现输出既不能被 3 整除也不能被 5 整除的数字。</li>
</ol>

## 解法

### **Java**
```java
class FizzBuzz {
    private int n;
    public FizzBuzz(int n) {
        this.n = n;
    }
    private Semaphore fSema = new Semaphore(0);
    private Semaphore bSema = new Semaphore(0);
    private Semaphore fbSema = new Semaphore(0);
    private Semaphore nSema = new Semaphore(1);
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i = i + 3) {
            if (i % 5 != 0) {
                fSema.acquire();
                printFizz.run();
                nSema.release();
            }
        }
    }
    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i = i + 5) {
            if (i % 3 != 0) {
                bSema.acquire();
                printBuzz.run();
                nSema.release();
            }
        }
    }
    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            fbSema.acquire();
            printFizzBuzz.run();
            nSema.release();
        }
    }
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            nSema.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fbSema.release();
            } else if (i % 3 == 0) {
                fSema.release();
            } else if (i % 5 == 0) {
                bSema.release();
            } else {
                printNumber.accept(i);
                nSema.release();
            }
        }
    }
}
```
# [1287. 有序数组中出现次数超过 25%的元素](https://leetcode-cn.com/problems/element-appearing-more-than-25-in-sorted-array)
## 题目描述

<p>给你一个非递减的&nbsp;<strong>有序&nbsp;</strong>整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。</p>
<p>请你找到并返回这个整数</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre>
<strong>输入：</strong>arr = [1,2,2,6,6,6,6,7,10]
<strong>输出：</strong>6
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= arr.length &lt;= 10^4</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10^5</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int total = arr.length;
        for (int i = 0; i < total; ++i) {
            if (arr[i] == arr[i + (total >> 2)]) {
                return arr[i];
            }
        }
        return 0;
    }
}
```

# [1290. 二进制链表转整数](https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer)
## 题目描述

<p>给你一个单链表的引用结点&nbsp;<code>head</code>。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。</p>
<p>请你返回该链表所表示数字的 <strong>十进制值</strong> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001558649.png)
<pre><strong>输入：</strong>head = [1,0,1]
<strong>输出：</strong>5
<strong>解释：</strong>二进制数 (101) 转化为十进制数 (5)
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>head = [0]
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>head = [1]
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
<strong>输出：</strong>18880
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>head = [0,0]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>链表不为空。</li>
	<li>链表的结点总数不超过&nbsp;<code>30</code>。</li>
	<li>每个结点的值不是&nbsp;<code>0</code> 就是 <code>1</code>。</li>
</ul>

## 解法

### **Java**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        StringBuilder sb = new StringBuilder("0");
        while (head != null) {
            sum += head.val;
            if (sum != 0) {
                sb.append(head.val);
            }
            head = head.next;
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}
```

# [1295. 统计位数为偶数的数字](https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits)
## 题目描述

<p>给你一个整数数组&nbsp;<code>nums</code>，请你返回其中位数为&nbsp;<strong>偶数</strong>&nbsp;的数字的个数。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>nums = [12,345,2,6,7896]
<strong>输出：</strong>2
<strong>解释：
</strong>12 是 2 位数字（位数为偶数）&nbsp;
345 是 3 位数字（位数为奇数）&nbsp;&nbsp;
2 是 1 位数字（位数为奇数）&nbsp;
6 是 1 位数字 位数为奇数）&nbsp;
7896 是 4 位数字（位数为偶数）&nbsp;&nbsp;
因此只有 12 和 7896 是位数为偶数的数字
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>nums = [555,901,482,1771]
<strong>输出：</strong>1 
<strong>解释： </strong>
只有 1771 是位数为偶数的数字。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
</ul>

## 解法
首先将数组元素转换为字符串,判断字符串长度是否为偶数即可。

### **Java**
```java
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += (String.valueOf(num).length() & 1) == 0 ? 1 : 0;
        }
        return res;
    }
}
```

# [1346. 检查整数及其两倍数是否存在](https://leetcode-cn.com/problems/check-if-n-and-its-double-exist)
## 题目描述

<p>给你一个整数数组&nbsp;<code>arr</code>，请你检查是否存在两个整数&nbsp;<code>N</code> 和 <code>M</code>，满足&nbsp;<code>N</code>&nbsp;是&nbsp;<code>M</code>&nbsp;的两倍（即，<code>N = 2 * M</code>）。</p>
<p>更正式地，检查是否存在两个下标&nbsp;<code>i</code> 和 <code>j</code> 满足：</p>
<ul>
	<li><code>i != j</code></li>
	<li><code>0 &lt;= i, j &lt; arr.length</code></li>
	<li><code>arr[i] == 2 * arr[j]</code></li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>arr = [10,2,5,3]
<strong>输出：</strong>true
<strong>解释：</strong>N<code> = 10</code> 是 M<code> = 5 的两倍</code>，即 <code>10 = 2 * 5 。</code>
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [7,1,14,11]
<strong>输出：</strong>true
<strong>解释：</strong>N<code> = 14</code> 是 M<code> = 7 的两倍</code>，即 <code>14 = 2 * 7 </code>。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>arr = [3,1,7,11]
<strong>输出：</strong>false
<strong>解释：</strong>在该情况下不存在 N 和 M 满足 N = 2 * M 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>2 &lt;= arr.length &lt;= 500</code></li>
	<li><code>-10^3 &lt;= arr[i] &lt;= 10^3</code></li>
</ul>

## 解法

### **Java**
```java
import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) && i != map.get(arr[i] * 2))
                return true;
        }
        return false;
    }
}
```

# [1347. 制造字母异位词的最小步骤数](https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram)
## 题目描述

<p>给你两个长度相等的字符串&nbsp;<code>s</code> 和 <code>t</code>。每一个步骤中，你可以选择将&nbsp;<code>t</code>&nbsp;中的 <strong>任一字符</strong> 替换为 <strong>另一个字符</strong>。</p>
<p>返回使&nbsp;<code>t</code>&nbsp;成为&nbsp;<code>s</code>&nbsp;的字母异位词的最小步骤数。</p>
<p><strong>字母异位词</strong> 指字母相同，但排列不同的字符串。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输出：</strong>s = &quot;bab&quot;, t = &quot;aba&quot;
<strong>输出：</strong>1
<strong>提示：</strong>用 &#39;b&#39; 替换 t 中的第一个 &#39;a&#39;，t = &quot;bba&quot; 是 s 的一个字母异位词。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输出：</strong>s = &quot;leetcode&quot;, t = &quot;practice&quot;
<strong>输出：</strong>5
<strong>提示：</strong>用合适的字符替换 t 中的 &#39;p&#39;, &#39;r&#39;, &#39;a&#39;, &#39;i&#39; 和 &#39;c&#39;，使 t 变成 s 的字母异位词。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输出：</strong>s = &quot;anagram&quot;, t = &quot;mangaar&quot;
<strong>输出：</strong>0
<strong>提示：</strong>&quot;anagram&quot; 和 &quot;mangaar&quot; 本身就是一组字母异位词。 
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输出：</strong>s = &quot;xxyyzz&quot;, t = &quot;xxyyzz&quot;
<strong>输出：</strong>0
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输出：</strong>s = &quot;friend&quot;, t = &quot;family&quot;
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= s.length &lt;= 50000</code></li>
	<li><code>s.length == t.length</code></li>
	<li><code>s</code> 和 <code>t</code>&nbsp;只包含小写英文字母</li>
</ul>

## 解法

### **Java**
```java
import java.util.*;
class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 1);
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else res ++;
        }
        return res;
    }
}
```

# [1380. 矩阵中的幸运数](https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix)
## 题目描述

<p>给你一个 <code>m * n</code> 的矩阵，矩阵中的数字 <strong>各不相同</strong> 。请你按 <strong>任意</strong> 顺序返回矩阵中的所有幸运数。</p>
<p>幸运数是指矩阵中满足同时下列两个条件的元素：</p>
<ul>
	<li>在同一行的所有元素中最小</li>
	<li>在同一列的所有元素中最大</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>matrix = [[3,7,8],[9,11,13],[15,16,17]]
<strong>输出：</strong>[15]
<strong>解释：</strong>15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
<strong>输出：</strong>[12]
<strong>解释：</strong>12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>matrix = [[7,8],[1,2]]
<strong>输出：</strong>[7]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= n, m &lt;= 50</code></li>
	<li><code>1 &lt;=&nbsp;matrix[i][j]&nbsp;&lt;= 10^5</code></li>
	<li>矩阵中的所有元素都是不同的</li>
</ul>

## 解法
取行最小值与列最大值的交集即可。

### **Java**
```java
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rowMin = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin.add(min);
        }
        for (int j = 0; j < n; ++j) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; ++i) {
                max = Math.max(max, matrix[i][j]);
            }
            if (rowMin.contains(max)) {
                res.add(max);
            }
        }
        return res;
    }
}
```

# [1476. 子矩形查询](https://leetcode-cn.com/problems/subrectangle-queries)
## 题目描述

<p>请你实现一个类&nbsp;<code>SubrectangleQueries</code>&nbsp;，它的构造函数的参数是一个 <code>rows x cols</code>&nbsp;的矩形（这里用整数矩阵表示），并支持以下两种操作：</p>
<p>1.<code>&nbsp;updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)</code></p>
<ul>
	<li>用&nbsp;<code>newValue</code>&nbsp;更新以&nbsp;<code>(row1,col1)</code>&nbsp;为左上角且以&nbsp;<code>(row2,col2)</code>&nbsp;为右下角的子矩形。</li>
</ul>
<p>2.<code>&nbsp;getValue(int row, int col)</code></p>
<ul>
	<li>返回矩形中坐标 <code>(row,col)</code> 的当前值。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>
[&quot;SubrectangleQueries&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
<strong>输出：</strong>
[null,1,null,5,5,null,10,5]
<strong>解释：</strong>
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);  
// 初始的 (4x3) 矩形如下：
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // 返回 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// 此次更新后矩形变为：
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5 
subrectangleQueries.getValue(0, 2); // 返回 5
subrectangleQueries.getValue(3, 1); // 返回 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// 此次更新后矩形变为：
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10 
subrectangleQueries.getValue(3, 1); // 返回 10
subrectangleQueries.getValue(0, 2); // 返回 5
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>
[&quot;SubrectangleQueries&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;]
[[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
<strong>输出：</strong>
[null,1,null,100,100,null,20]
<strong>解释：</strong>
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
subrectangleQueries.getValue(0, 0); // 返回 1
subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
subrectangleQueries.getValue(0, 0); // 返回 100
subrectangleQueries.getValue(2, 2); // 返回 100
subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
subrectangleQueries.getValue(2, 2); // 返回 20
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li>最多有&nbsp;<code>500</code>&nbsp;次<code>updateSubrectangle</code> 和&nbsp;<code>getValue</code>&nbsp;操作。</li>
	<li><code>1 &lt;= rows, cols &lt;= 100</code></li>
	<li><code>rows ==&nbsp;rectangle.length</code></li>
	<li><code>cols == rectangle[i].length</code></li>
	<li><code>0 &lt;= row1 &lt;= row2 &lt; rows</code></li>
	<li><code>0 &lt;= col1 &lt;= col2 &lt; cols</code></li>
	<li><code>1 &lt;= newValue, rectangle[i][j] &lt;= 10^9</code></li>
	<li><code>0 &lt;= row &lt; rows</code></li>
	<li><code>0 &lt;= col &lt; cols</code></li>
</ul>

## 解法

### **Java**
```java
class SubrectangleQueries {
    int[][] matrix;
    public SubrectangleQueries(int[][] rectangle) {
        matrix = new int[rectangle.length][rectangle[0].length];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                matrix[i][j] = rectangle[i][j];
            }
        }
    }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        if (row1 > row2 || col1 > col2) {
            return;
        }
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                matrix[i][j] = newValue;
            }
        }
    }
    public int getValue(int row, int col) {
        return matrix[row][col];
    }
}
/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
```

# [1535. 找出数组游戏的赢家](https://leetcode-cn.com/problems/find-the-winner-of-an-array-game)
## 题目描述

<p>给你一个由 <strong>不同</strong> 整数组成的整数数组 <code>arr</code> 和一个整数 <code>k</code> 。</p>
<p>每回合游戏都在数组的前两个元素（即 <code>arr[0]</code> 和 <code>arr[1]</code> ）之间进行。比较 <code>arr[0]</code> 与 <code>arr[1]</code> 的大小，较大的整数将会取得这一回合的胜利并保留在位置 <code>0</code> ，较小的整数移至数组的末尾。当一个整数赢得 <code>k</code> 个连续回合时，游戏结束，该整数就是比赛的 <strong>赢家</strong> 。</p>
<p>返回赢得比赛的整数。</p>
<p>题目数据 <strong>保证</strong> 游戏存在赢家。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<p>
<pre><strong>输入：</strong>arr = [2,1,3,5,4,6,7], k = 2
<strong>输出：</strong>5
<strong>解释：</strong>
一起看一下本场游戏每回合的情况：
![这里插入图片描述](https://img-blog.csdnimg.cn/20210225001641409.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [3,2,1], k = 10
<strong>输出：</strong>3
<strong>解释：</strong>3 将会在前 10 个回合中连续获胜。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>arr = [1,9,8,2,3,7,6,4,5], k = 7
<strong>输出：</strong>9
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
<strong>输出：</strong>99
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>2 &lt;= arr.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10^6</code></li>
	<li><code>arr</code> 所含的整数 <strong>各不相同</strong> 。</li>
	<li><code>1 &lt;= k &lt;= 10^9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int getWinner(int[] arr, int k) {
        int time = 0, max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                time++;
            } else {
                time = 1;
                max = arr[i];
            }
            if (time >= k) {
                return max;
            }
        }
        return max;
    }
}
```


# [1541. 平衡括号字符串的最少插入次数](https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string)
## 题目描述

<p>给你一个括号字符串&nbsp;<code>s</code>&nbsp;，它只包含字符&nbsp;<code>&#39;(&#39;</code> 和&nbsp;<code>&#39;)&#39;</code>&nbsp;。一个括号字符串被称为平衡的当它满足：</p>
<ul>
	<li>任何左括号&nbsp;<code>&#39;(&#39;</code>&nbsp;必须对应两个连续的右括号&nbsp;<code>&#39;))&#39;</code>&nbsp;。</li>
	<li>左括号&nbsp;<code>&#39;(&#39;</code>&nbsp;必须在对应的连续两个右括号&nbsp;<code>&#39;))&#39;</code>&nbsp;之前。</li>
</ul>
<p>比方说&nbsp;<code>&quot;())&quot;</code>，&nbsp;<code>&quot;())(())))&quot;</code> 和&nbsp;<code>&quot;(())())))&quot;</code>&nbsp;都是平衡的，&nbsp;<code>&quot;)()&quot;</code>，&nbsp;<code>&quot;()))&quot;</code> 和&nbsp;<code>&quot;(()))&quot;</code>&nbsp;都是不平衡的。</p>
<p>你可以在任意位置插入字符 &#39;(&#39; 和 &#39;)&#39; 使字符串平衡。</p>
<p>请你返回让 <code>s</code>&nbsp;平衡的最少插入次数。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>s = &quot;(()))&quot;
<strong>输出：</strong>1
<strong>解释：</strong>第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 &#39;)&#39; 使字符串变成平衡字符串 &quot;(())))&quot; 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>s = &quot;())&quot;
<strong>输出：</strong>0
<strong>解释：</strong>字符串已经平衡了。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>s = &quot;))())(&quot;
<strong>输出：</strong>3
<strong>解释：</strong>添加 &#39;(&#39; 去匹配最开头的 &#39;))&#39; ，然后添加 &#39;))&#39; 去匹配最后一个 &#39;(&#39; 。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>s = &quot;((((((&quot;
<strong>输出：</strong>12
<strong>解释：</strong>添加 12 个 &#39;)&#39; 得到平衡字符串。
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>s = &quot;)))))))&quot;
<strong>输出：</strong>5
<strong>解释：</strong>在字符串开头添加 4 个 &#39;(&#39; 并在结尾添加 1 个 &#39;)&#39; ，字符串变成平衡字符串 &quot;(((())))))))&quot; 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= s.length &lt;= 10^5</code></li>
	<li><code>s</code>&nbsp;只包含&nbsp;<code>&#39;(&#39;</code> 和&nbsp;<code>&#39;)&#39;</code>&nbsp;。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
     public int minInsertions(String s) {
        int left = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if (chars[i] == '(') {
                left++;
                i++;
            } else {
                // 连续2个 )
                if (i < chars.length - 1 && chars[i + 1] == ')') {
                    if (left > 0) {
                        left--;
                    } else {
                        res++;
                    }
                    i += 2;
                } else {
                    if (left > 0) {
                        left--;
                        res++;
                    } else {
                        res += 2;
                    }
                    i++;
                }
            }
        }
        if (left > 0) {
            res += 2 * left;
        }
        return res;
    }
}
```

# [1544. 整理字符串](https://leetcode-cn.com/problems/make-the-string-great)
## 题目描述

<p>给你一个由大小写英文字母组成的字符串 <code>s</code> 。</p>
<p>一个整理好的字符串中，<strong>两个相邻字符</strong> <code>s[i]</code> 和 <code>s[i + 1]</code> 不会同时满足下述条件：</p>
<ul>
	<li><code>0 &lt;= i &lt;= s.length - 2</code></li>
	<li><code>s[i]</code> 是小写字符，但 <code>s[i + 1]</code> 是相同的大写字符；<strong>反之亦然</strong> 。</li>
</ul>
<p>请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 <strong>两个相邻</strong> 字符并删除，直到字符串整理好为止。</p>
<p>请返回整理好的 <strong>字符串</strong> 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。</p>
<p><strong>注意：</strong>空字符串也属于整理好的字符串，尽管其中没有任何字符。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>s = &quot;leEeetcode&quot;
<strong>输出：</strong>&quot;leetcode&quot;
<strong>解释：</strong>无论你第一次选的是 i = 1 还是 i = 2，都会使 &quot;leEeetcode&quot; 缩减为 &quot;leetcode&quot; 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>s = &quot;abBAcC&quot;
<strong>输出：</strong>&quot;&quot;
<strong>解释：</strong>存在多种不同情况，但所有的情况都会导致相同的结果。例如：
&quot;abBAcC&quot; --&gt; &quot;aAcC&quot; --&gt; &quot;cC&quot; --&gt; &quot;&quot;
&quot;abBAcC&quot; --&gt; &quot;abBA&quot; --&gt; &quot;aA&quot; --&gt; &quot;&quot;
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>s = &quot;s&quot;
<strong>输出：</strong>&quot;s&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> 只包含小写和大写英文字母</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public String makeGood(String s) {
        return help(s);
    }
    private String help(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (Math.abs(chars[i] - chars[i - 1]) == Math.abs('A' - 'a')) {
                return help(newString(chars, i));
            }
        }
        return s;
    }
    private String newString(char[] chars, int i) {
        StringBuilder tmp = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            if (j != i && j != i - 1) {
                tmp.append(chars[j]);
            }
        }
        return tmp.toString();
    }
}
```

# [1545. 找出第 N 个二进制字符串中的第 K 位](https://leetcode-cn.com/problems/find-kth-bit-in-nth-binary-string)
## 题目描述

<p>给你两个正整数 <code>n</code> 和 <code>k</code>，二进制字符串&nbsp; <code>S<sub>n</sub></code> 的形成规则如下：</p>
<ul>
	<li><code>S<sub>1</sub>&nbsp;= &quot;0&quot;</code></li>
	<li>当 <code>i &gt; 1</code> 时，<code>S<sub>i</sub>&nbsp;=&nbsp;S<sub>i-1</sub>&nbsp;+ &quot;1&quot; + reverse(invert(S<sub>i-1</sub>))</code></li>
</ul>
<p>其中 <code>+</code> 表示串联操作，<code>reverse(x)</code> 返回反转 <code>x</code> 后得到的字符串，而 <code>invert(x)</code> 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）</p>
<p>例如，符合上述描述的序列的前 4 个字符串依次是：</p>
<ul>
	<li><code>S<sub>1&nbsp;</sub>= &quot;0&quot;</code></li>
	<li><code>S<sub>2&nbsp;</sub>= &quot;0<strong>1</strong>1&quot;</code></li>
	<li><code>S<sub>3&nbsp;</sub>= &quot;011<strong>1</strong>001&quot;</code></li>
	<li><code>S<sub>4</sub> = &quot;0111001<strong>1</strong>0110001&quot;</code></li>
</ul>
<p>请你返回&nbsp; <code>S<sub>n</sub></code> 的 <strong>第 <code>k</code> 位字符</strong> ，题目数据保证 <code>k</code> 一定在 <code>S<sub>n</sub></code> 长度范围以内。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 3, k = 1
<strong>输出：</strong>&quot;0&quot;
<strong>解释：</strong>S<sub>3</sub> 为 &quot;<strong>0</strong>111001&quot;，其第 1 位为 &quot;0&quot; 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 4, k = 11
<strong>输出：</strong>&quot;1&quot;
<strong>解释：</strong>S<sub>4</sub> 为 &quot;0111001101<strong>1</strong>0001&quot;，其第 11 位为 &quot;1&quot; 。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>n = 1, k = 1
<strong>输出：</strong>&quot;0&quot;
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>n = 2, k = 3
<strong>输出：</strong>&quot;1&quot;
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>1 &lt;= k &lt;= 2<sup>n</sup> - 1</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
      public char findKthBit(int n, int k) {
        if (k == 1 || n == 1) {
            return '0';
        }
        Set<Integer> set = new HashSet<>();
        int len = calcLength(n, set);
        if (set.contains(k)) {
            return '1';
        }
        // 中间，返回1
        if (k < len / 2) {
            return findKthBit(n - 1, k);
        } else {
            if (set.contains(len - k)) {
                return '1';
            }
            return r(findKthBit(n - 1, len - k + 1));
        }
    }
    private char r(char b) {
        if (b == '0') {
            return '1';
        }
        return '0';
    }
    private int calcLength(int n, Set<Integer> set) {
        if (n == 1) {
            return 1;
        }
        int ans = 2 * calcLength(n - 1, set) + 1;
        set.add(ans + 1);
        return ans;
    }
}
```

# [1546. 和为目标值的最大数目不重叠非空子数组数目](https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target)
## 题目描述

<p>给你一个数组&nbsp;<code>nums</code>&nbsp;和一个整数&nbsp;<code>target</code>&nbsp;。</p>
<p>请你返回&nbsp;<strong>非空不重叠</strong>&nbsp;子数组的最大数目，且每个子数组中数字和都为 <code>target</code>&nbsp;。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>nums = [1,1,1,1,1], target = 2
<strong>输出：</strong>2
<strong>解释：</strong>总共有 2 个不重叠子数组（加粗数字表示） [<strong>1,1</strong>,1,<strong>1,1</strong>] ，它们的和为目标值 2 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>nums = [-1,3,5,1,4,2,-9], target = 6
<strong>输出：</strong>2
<strong>解释：</strong>总共有 3 个子数组和为 6 。
([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>nums = [-2,6,6,3,5,4,1,2,8], target = 10
<strong>输出：</strong>3
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>nums = [0,0,0], target = 0
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;=&nbsp;10^5</code></li>
	<li><code>-10^4 &lt;= nums[i] &lt;=&nbsp;10^4</code></li>
	<li><code>0 &lt;= target &lt;= 10^6</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                ans++;
                set.clear();
                sum = 0;
            }
            set.add(sum);
        }
        return ans;
    }
}
```

# [1550. 存在连续三个奇数的数组](https://leetcode-cn.com/problems/three-consecutive-odds)
## 题目描述

<p>给你一个整数数组 <code>arr</code>，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>arr = [2,6,4,1]
<strong>输出：</strong>false
<strong>解释：</strong>不存在连续三个元素都是奇数的情况。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [1,2,34,3,4,5,7,23,12]
<strong>输出：</strong>true
<strong>解释：</strong>存在连续三个元素都是奇数的情况，即 [5,7,23] 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

# [1551. 使数组中所有元素相等的最小操作数](https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal)
## 题目描述

<p>存在一个长度为 <code>n</code> 的数组 <code>arr</code> ，其中 <code>arr[i] = (2 * i) + 1</code> （ <code>0 &lt;= i &lt; n</code> ）。</p>
<p>一次操作中，你可以选出两个下标，记作 <code>x</code> 和 <code>y</code> （ <code>0 &lt;= x, y &lt; n</code> ）并使 <code>arr[x]</code> 减去 <code>1</code> 、<code>arr[y]</code> 加上 <code>1</code> （即 <code>arr[x] -=1 </code>且 <code>arr[y] += 1</code> ）。最终的目标是使数组中的所有元素都 <strong>相等</strong> 。题目测试用例将会 <strong>保证</strong> ：在执行若干步操作后，数组中的所有元素最终可以全部相等。</p>
<p>给你一个整数 <code>n</code>，即数组的长度。请你返回使数组 <code>arr</code> 中所有元素相等所需的 <strong>最小操作数</strong> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 3
<strong>输出：</strong>2
<strong>解释：</strong>arr = [1, 3, 5]
第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 6
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= n &lt;= 10^4</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int curr = 2 * i + 1;
            ans += Math.abs(n - curr);
        }
        return ans;
    }
}
```

# [1552. 两球之间的磁力](https://leetcode-cn.com/problems/magnetic-force-between-two-balls)
## 题目描述

<p>在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有&nbsp;<code>n</code>&nbsp;个空的篮子，第&nbsp;<code>i</code>&nbsp;个篮子的位置在&nbsp;<code>position[i]</code>&nbsp;，Morty&nbsp;想把&nbsp;<code>m</code>&nbsp;个球放到这些篮子里，使得任意两球间&nbsp;<strong>最小磁力</strong>&nbsp;最大。</p>
<p>已知两个球如果分别位于&nbsp;<code>x</code>&nbsp;和&nbsp;<code>y</code>&nbsp;，那么它们之间的磁力为&nbsp;<code>|x - y|</code>&nbsp;。</p>
<p>给你一个整数数组&nbsp;<code>position</code>&nbsp;和一个整数&nbsp;<code>m</code>&nbsp;，请你返回最大化的最小磁力。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001731238.jpg)
<pre><strong>输入：</strong>position = [1,2,3,4,7], m = 3
<strong>输出：</strong>3
<strong>解释：</strong>将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>position = [5,4,3,2,1,1000000000], m = 2
<strong>输出：</strong>999999999
<strong>解释：</strong>我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>n == position.length</code></li>
	<li><code>2 &lt;= n &lt;= 10^5</code></li>
	<li><code>1 &lt;= position[i] &lt;= 10^9</code></li>
	<li>所有&nbsp;<code>position</code>&nbsp;中的整数 <strong>互不相同</strong>&nbsp;。</li>
	<li><code>2 &lt;= m &lt;= position.length</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        // 最小磁力的可能最小值
        int min = 1;
        // 最小磁力的可能最大值
        int max = (position[position.length - 1] - position[0]) / (m - 1);
        int ans = -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (checkDistance(mid, position, m)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }
    private boolean checkDistance(int mid, int[] position, int m) {
        int count = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= mid) {
                count++;
                if (count >= m) {
                    return true;
                }
                pre = position[i];
            }
        }
        return false;
    }
}
```


# [1560. 圆形赛道上经过次数最多的扇区](https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track)
## 题目描述

<p>给你一个整数 <code>n</code> 和一个整数数组 <code>rounds</code> 。有一条圆形赛道由 <code>n</code> 个扇区组成，扇区编号从 <code>1</code> 到 <code>n</code> 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 <code>m</code> 个阶段组成。其中，第 <code>i</code> 个阶段将会从扇区 <code>rounds[i - 1]</code> 开始，到扇区 <code>rounds[i]</code> 结束。举例来说，第 <code>1</code> 阶段从&nbsp;<code>rounds[0]</code>&nbsp;开始，到&nbsp;<code>rounds[1]</code>&nbsp;结束。</p>
<p>请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 <strong>升序</strong> 排列。</p>
<p>注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001752781.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>n = 4, rounds = [1,3,1,2]
<strong>输出：</strong>[1,2]
<strong>解释：</strong>本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
1 --&gt; 2 --&gt; 3（阶段 1 结束）--&gt; 4 --&gt; 1（阶段 2 结束）--&gt; 2（阶段 3 结束，即本场马拉松结束）
其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 2, rounds = [2,1,2,1,2,1,2,1,2]
<strong>输出：</strong>[2]
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>n = 7, rounds = [1,3,5,7]
<strong>输出：</strong>[1,2,3,4,5,6,7]
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>2 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= m &lt;= 100</code></li>
	<li><code>rounds.length == m + 1</code></li>
	<li><code>1 &lt;= rounds[i] &lt;= n</code></li>
	<li><code>rounds[i] != rounds[i + 1]</code> ，其中 <code>0 &lt;= i &lt; m</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] ans = new int[n];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i]--;
        }
        ans[rounds[0]]++;
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (end <= start) {
                end += n;
            }
            for (int j = start + 1; j <= end; j++) {
                ans[j % n]++;
            }
        }
        int max = Arrays.stream(ans).max().orElse(-1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == max) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
```

# [1561. 你可以获得的最大硬币数目](https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get)
## 题目描述

<p>有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：</p>
<ul>
	<li>每一轮中，你将会选出 <strong>任意</strong> 3 堆硬币（不一定连续）。</li>
	<li>Alice 将会取走硬币数量最多的那一堆。</li>
	<li>你将会取走硬币数量第二多的那一堆。</li>
	<li>Bob 将会取走最后一堆。</li>
	<li>重复这个过程，直到没有更多硬币。</li>
</ul>
<p>给你一个整数数组 <code>piles</code> ，其中 <code>piles[i]</code> 是第 <code>i</code> 堆中硬币的数目。</p>
<p>返回你可以获得的最大硬币数目。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>piles = [2,4,1,2,7,8]
<strong>输出：</strong>9
<strong>解释：</strong>选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 <strong>7</strong> 枚硬币的那堆，Bob 取走最后一堆。
选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 <strong>2</strong> 枚硬币的那堆，Bob 取走最后一堆。
你可以获得的最大硬币数目：7 + 2 = 9.
考虑另外一种情况，如果选出的是 (1, <strong>2</strong>, 8) 和 (2, <strong>4</strong>, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>piles = [2,4,5]
<strong>输出：</strong>4
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>piles = [9,8,7,6,5,1,2,3,4]
<strong>输出：</strong>18
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>3 &lt;= piles.length &lt;= 10^5</code></li>
	<li><code>piles.length % 3 == 0</code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10^4</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int start = 0, end = piles.length - 1, ans = 0;
        while (start < end) {
            ans += piles[end - 1];
            start++;
            end -= 2;
        }
        return ans;
    }
}
```

# [1562. 查找大小为 M 的最新分组](https://leetcode-cn.com/problems/find-latest-group-of-size-m)
## 题目描述

<p>给你一个数组 <code>arr</code> ，该数组表示一个从 <code>1</code> 到 <code>n</code> 的数字排列。有一个长度为 <code>n</code> 的二进制字符串，该字符串上的所有位最初都设置为 <code>0</code> 。</p>
<p>在从 <code>1</code> 到 <code>n</code> 的每个步骤 <code>i</code> 中（假设二进制字符串和 <code>arr</code> 都是从 <code>1</code> 开始索引的情况下），二进制字符串上位于位置 <code>arr[i]</code> 的位将会设为 <code>1</code> 。</p>
<p>给你一个整数 <code>m</code> ，请你找出二进制字符串上存在长度为 <code>m</code> 的一组 <code>1</code> 的最后步骤。一组 <code>1</code> 是一个连续的、由 <code>1</code> 组成的子串，且左右两边不再有可以延伸的 <code>1</code> 。</p>
<p>返回存在长度 <strong>恰好</strong> 为 <code>m</code> 的 <strong>一组 <code>1</code>&nbsp;</strong> 的最后步骤。如果不存在这样的步骤，请返回 <code>-1</code> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>arr = [3,5,1,2,4], m = 1
<strong>输出：</strong>4
<strong>解释：
</strong>步骤 1：&quot;00<strong>1</strong>00&quot;，由 1 构成的组：[&quot;1&quot;]
步骤 2：&quot;0010<strong>1</strong>&quot;，由 1 构成的组：[&quot;1&quot;, &quot;1&quot;]
步骤 3：&quot;<strong>1</strong>0101&quot;，由 1 构成的组：[&quot;1&quot;, &quot;1&quot;, &quot;1&quot;]
步骤 4：&quot;1<strong>1</strong>101&quot;，由 1 构成的组：[&quot;111&quot;, &quot;1&quot;]
步骤 5：&quot;111<strong>1</strong>1&quot;，由 1 构成的组：[&quot;11111&quot;]
存在长度为 1 的一组 1 的最后步骤是步骤 4 。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [3,1,5,4,2], m = 2
<strong>输出：</strong>-1
<strong>解释：
</strong>步骤 1：&quot;00<strong>1</strong>00&quot;，由 1 构成的组：[&quot;1&quot;]
步骤 2：&quot;<strong>1</strong>0100&quot;，由 1 构成的组：[&quot;1&quot;, &quot;1&quot;]
步骤 3：&quot;1010<strong>1</strong>&quot;，由 1 构成的组：[&quot;1&quot;, &quot;1&quot;, &quot;1&quot;]
步骤 4：&quot;101<strong>1</strong>1&quot;，由 1 构成的组：[&quot;1&quot;, &quot;111&quot;]
步骤 5：&quot;1<strong>1</strong>111&quot;，由 1 构成的组：[&quot;11111&quot;]
不管是哪一步骤都无法形成长度为 2 的一组 1 。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>arr = [1], m = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>arr = [2,1], m = 2
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>n == arr.length</code></li>
	<li><code>1 &lt;= n &lt;= 10^5</code></li>
	<li><code>1 &lt;= arr[i] &lt;= n</code></li>
	<li><code>arr</code> 中的所有整数 <strong>互不相同</strong></li>
	<li><code>1 &lt;= m&nbsp;&lt;= arr.length</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int findLatestStep(int[] arr, int m) {
        // 倒序遍历 arr，转换为第一次出现 m 个的步骤
        if (arr.length == m) {
            return m;
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(arr.length + 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = arr[i];
            int l = set.lower(index);
            int h = set.higher(index);
            if (index - l - 1 == m || h - index - 1 == m) {
                return i;
            }
            set.add(index);
        }
        return -1;
    }
}
```

# [1566. 重复至少 K 次且长度为 M 的模式](https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times)
## 题目描述

<p>给你一个正整数数组 <code>arr</code>，请你找出一个长度为 <code>m</code> 且在数组中至少重复 <code>k</code> 次的模式。</p>
<p><strong>模式</strong> 是由一个或多个值组成的子数组（连续的子序列），<strong>连续</strong> 重复多次但 <strong>不重叠</strong> 。 模式由其长度和重复次数定义。</p>
<p>如果数组中存在至少重复 <code>k</code> 次且长度为 <code>m</code> 的模式，则返回 <code>true</code> ，否则返回&nbsp; <code>false</code> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>arr = [1,2,4,4,4,4], m = 1, k = 3
<strong>输出：</strong>true
<strong>解释：</strong>模式 <strong>(4)</strong> 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
<strong>输出：</strong>true
<strong>解释：</strong>模式 <strong>(1,2)</strong> 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 <strong>(2,1) </strong>，同样重复 2 次。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>arr = [1,2,1,2,1,3], m = 2, k = 3
<strong>输出：</strong>false
<strong>解释：</strong>模式 <strong>(1,2)</strong> 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>arr = [1,2,3,1,2], m = 2, k = 2
<strong>输出：</strong>false
<strong>解释：</strong>模式 <strong>(1,2)</strong> 出现 2 次但并不连续，所以不能算作连续重复 2 次。
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>arr = [2,2,2,2], m = 2, k = 3
<strong>输出：</strong>false
<strong>解释：</strong>长度为 2 的模式只有 <strong>(2,2)</strong> ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>2 &lt;= arr.length &lt;= 100</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 100</code></li>
	<li><code>1 &lt;= m&nbsp;&lt;= 100</code></li>
	<li><code>2 &lt;= k&nbsp;&lt;= 100</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) {
            return false;
        }
        for (int i = 0; i <= arr.length - m * k; i++) {
            boolean match = true;
            for (int j = i + m; j < i + m * k; j++) {
                if (arr[j] != arr[j - m]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
```

# [1567. 乘积为正数的最长子数组长度](https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product)
## 题目描述

<p>给你一个整数数组 <code>nums</code>&nbsp;，请你求出乘积为正数的最长子数组的长度。</p>
<p>一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。</p>
<p>请你返回乘积为正数的最长子数组长度。</p>
<p>&nbsp;</p>
<p><strong>示例&nbsp; 1：</strong></p>
<pre><strong>输入：</strong>nums = [1,-2,-3,4]
<strong>输出：</strong>4
<strong>解释：</strong>数组本身乘积就是正数，值为 24 。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>nums = [0,1,-2,-3,-4]
<strong>输出：</strong>3
<strong>解释：</strong>最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>nums = [-1,-2,-3,0,1]
<strong>输出：</strong>2
<strong>解释：</strong>乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>nums = [-1,2]
<strong>输出：</strong>1
</pre>

<p><strong>示例 5：</strong></p>
<pre><strong>输入：</strong>nums = [1,2,3,5,-6,4,0,10]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;= 10^5</code></li>
	<li><code>-10^9 &lt;= nums[i]&nbsp;&lt;= 10^9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
     public int getMaxLen(int[] nums) {
        // p[i] = n[i-1] + 1, nums[i] < 0
        // p[i] = p[i-1] + 1, nums[i] > 0
        // p[i] = 0, nums[i] = 0
        // n[i] = p[i-1] + 1, nums[i] < 0
        // n[i] = n[i-1] + 1, nums[i] > 0
        // n[i] = 0, nums[i] = 0
        int[] p = new int[nums.length];
        int[] n = new int[nums.length];
        p[0] = nums[0] > 0 ? 1 : 0;
        n[0] = nums[0] < 0 ? 1 : 0;
        int res = Math.max(p[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                p[i] = p[i - 1] + 1;
                n[i] = n[i - 1] == 0 ? 0 : n[i - 1] + 1;
            } else if (nums[i] == 0) {
                p[i] = 0;
                n[i] = 0;
            } else {
                p[i] = n[i - 1] == 0 ? 0 : n[i - 1] + 1;
                n[i] = p[i - 1] + 1;
            }
            res = Math.max(res, p[i]);
        }
        return res;
    }
}
```


# [1572. 矩阵对角线元素的和](https://leetcode-cn.com/problems/matrix-diagonal-sum)
## 题目描述

<p>给你一个正方形矩阵 <code>mat</code>，请你返回矩阵对角线元素的和。</p>
<p>请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。</p>
<p>&nbsp;</p>
<p><strong>示例&nbsp; 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022500201929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre>
<strong>输入：</strong>mat = [[<strong>1</strong>,2,<strong>3</strong>],
&nbsp;           [4,<strong>5</strong>,6],
&nbsp;           [<strong>7</strong>,8,<strong>9</strong>]]
<strong>输出：</strong>25
<strong>解释：</strong>对角线的和为：1 + 5 + 9 + 3 + 7 = 25
请注意，元素 mat[1][1] = 5 只会被计算一次。
</pre>

<p><strong>示例&nbsp; 2：</strong></p>
<pre>
<strong>输入：</strong>mat = [[<strong>1</strong>,1,1,<strong>1</strong>],
&nbsp;           [1,<strong>1</strong>,<strong>1</strong>,1],
&nbsp;           [1,<strong>1</strong>,<strong>1</strong>,1],
&nbsp;           [<strong>1</strong>,1,1,<strong>1</strong>]]
<strong>输出：</strong>8
</pre>

<p><strong>示例 3：</strong></p>
<pre>
<strong>输入：</strong>mat = [[<strong>5</strong>]]
<strong>输出：</strong>5
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>n == mat.length == mat[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= mat[i][j] &lt;= 100</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0, n = mat.length, mid = n >> 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += (mat[i][i] + mat[i][j]);
        }
        return n % 2 == 0 ? sum : sum - mat[mid][mid];
    }
}
```

# [1573. 分割字符串的方案数](https://leetcode-cn.com/problems/number-of-ways-to-split-a-string)
## 题目描述

<p>给你一个二进制串&nbsp;<code>s</code>&nbsp; （一个只包含 0 和 1 的字符串），我们可以将 <code>s</code>&nbsp;分割成 3 个 <strong>非空</strong>&nbsp;字符串 s1, s2, s3 （s1 + s2 + s3 = s）。</p>
<p>请你返回分割&nbsp;<code>s</code>&nbsp;的方案数，满足 s1，s2 和 s3 中字符 &#39;1&#39; 的数目相同。</p>
<p>由于答案可能很大，请将它对 10^9 + 7 取余后返回。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>s = &quot;10101&quot;
<strong>输出：</strong>4
<strong>解释：</strong>总共有 4 种方法将 s 分割成含有 &#39;1&#39; 数目相同的三个子字符串。
&quot;1|010|1&quot;
&quot;1|01|01&quot;
&quot;10|10|1&quot;
&quot;10|1|01&quot;
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>s = &quot;1001&quot;
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>s = &quot;0000&quot;
<strong>输出：</strong>3
<strong>解释：</strong>总共有 3 种分割 s 的方法。
&quot;0|0|00&quot;
&quot;0|00|0&quot;
&quot;00|0|0&quot;
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>s = &quot;100100010100110&quot;
<strong>输出：</strong>12
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>s[i] == &#39;0&#39;</code>&nbsp;或者&nbsp;<code>s[i] == &#39;1&#39;</code></li>
	<li><code>3 &lt;= s.length &lt;= 10^5</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numWays(String s) {
        char[] chars = s.toCharArray();
        List<Long> p = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                p.add((long) i);
            }
        }
        int l = p.size();
        if (l % 3 != 0) {
            return 0;
        }
        int MOD = (int) (1e9 + 7);
        if (l == 0) {
            return (int) (((long) (s.length() - 1) * (s.length() - 2) / 2) % MOD);
        }
        // 每 n/3 的地方为分界线
        return (int) ((p.get(l / 3) - p.get(l / 3 - 1)) * (p.get(2 * l / 3) - p.get(2 * l / 3 - 1))
                % MOD);
    }
}
```

# [1578. 避免重复字母的最小删除成本](https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters)
## 题目描述

<p>给你一个字符串 <code>s</code> 和一个整数数组 <code>cost</code> ，其中 <code>cost[i]</code> 是从 <code>s</code> 中删除字符 <code>i</code> 的代价。</p>
<p>返回使字符串任意相邻两个字母不相同的最小删除成本。</p>
<p>请注意，删除一个字符后，删除其他字符的成本不会改变。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre>
<strong>输入：</strong>s = &quot;abaac&quot;, cost = [1,2,3,4,5]
<strong>输出：</strong>3
<strong>解释：</strong>删除字母 &quot;a&quot; 的成本为 3，然后得到 &quot;abac&quot;（字符串中相邻两个字母不相同）。
</pre>

<p><strong>示例 2：</strong></p>
<pre>
<strong>输入：</strong>s = &quot;abc&quot;, cost = [1,2,3]
<strong>输出：</strong>0
<strong>解释：</strong>无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
</pre>

<p><strong>示例 3：</strong></p>
<pre>
<strong>输入：</strong>s = &quot;aabaa&quot;, cost = [1,2,3,4,1]
<strong>输出：</strong>2
<strong>解释：</strong>删除第一个和最后一个字母，得到字符串 (&quot;aba&quot;) 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>s.length == cost.length</code></li>
	<li><code>1 &lt;= s.length, cost.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= cost[i] &lt;=&nbsp;10^4</code></li>
	<li><code>s</code> 中只含有小写英文字母</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0;
        char[] word = s.toCharArray();
        for(int i = 0;i < word.length;i++){
            char c = word[i];
            int max = cost[i];
            int sum = max;
            while(i + 1 < word.length && word[i + 1] == c){
                sum += cost[++i];
                max = Math.max(max,cost[i]);
            }
            if(sum != max){
                res += sum - max;
            }
        }
        return res;
    }
}
```


# [1582. 二进制矩阵中的特殊位置](https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix)
## 题目描述

<p>给你一个大小为 <code>rows x cols</code> 的矩阵 <code>mat</code>，其中 <code>mat[i][j]</code> 是 <code>0</code> 或 <code>1</code>，请返回 <strong>矩阵&nbsp;<em><code>mat</code></em> 中特殊位置的数目</strong> 。</p>
<p><strong>特殊位置</strong> 定义：如果 <code>mat[i][j] == 1</code> 并且第 <code>i</code> 行和第 <code>j</code> 列中的所有其他元素均为 <code>0</code>（行和列的下标均 <strong>从 0 开始</strong> ），则位置 <code>(i, j)</code> 被称为特殊位置。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>mat = [[1,0,0],
&nbsp;           [0,0,<strong>1</strong>],
&nbsp;           [1,0,0]]
<strong>输出：</strong>1
<strong>解释：</strong>(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>mat = [[<strong>1</strong>,0,0],
&nbsp;           [0,<strong>1</strong>,0],
&nbsp;           [0,0,<strong>1</strong>]]
<strong>输出：</strong>3
<strong>解释：</strong>(0,0), (1,1) 和 (2,2) 都是特殊位置
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>mat = [[0,0,0,<strong>1</strong>],
&nbsp;           [<strong>1</strong>,0,0,0],
&nbsp;           [0,1,1,0],
&nbsp;           [0,0,0,0]]
<strong>输出：</strong>2
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>mat = [[0,0,0,0,0],
&nbsp;           [<strong>1</strong>,0,0,0,0],
&nbsp;           [0,<strong>1</strong>,0,0,0],
&nbsp;           [0,0,<strong>1</strong>,0,0],
&nbsp;           [0,0,0,1,1]]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>rows == mat.length</code></li>
	<li><code>cols == mat[i].length</code></li>
	<li><code>1 &lt;= rows, cols &lt;= 100</code></li>
	<li><code>mat[i][j]</code> 是 <code>0</code> 或 <code>1</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[] rows1 = new int[rows];
        int[] cols1 = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rows1[i]++;
                    cols1[j]++;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rows1[i] == 1 && cols1[j] == 1) {
                    ans ++;
                } 
            }
        }
        
        return ans;
    }
}
```

# [1583. 统计不开心的朋友](https://leetcode-cn.com/problems/count-unhappy-friends)
## 题目描述

<p>给你一份 <code>n</code> 位朋友的亲近程度列表，其中 <code>n</code> 总是 <strong>偶数</strong> 。</p>
<p>对每位朋友 <code>i</code>，<code>preferences[i]</code> 包含一份 <strong>按亲近程度从高</strong><strong>到低排列</strong> 的朋友列表。换句话说，排在列表前面的朋友与 <code>i</code> 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 <code>0</code> 到 <code>n-1</code> 之间的整数表示。</p>
<p>所有的朋友被分成几对，配对情况以列表 <code>pairs</code> 给出，其中 <code>pairs[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> 表示 <code>x<sub>i</sub></code> 与 <code>y<sub>i</sub></code> 配对，且 <code>y<sub>i</sub></code> 与 <code>x<sub>i</sub></code> 配对。</p>
<p>但是，这样的配对情况可能会是其中部分朋友感到不开心。在 <code>x</code> 与 <code>y</code> 配对且 <code>u</code> 与 <code>v</code> 配对的情况下，如果同时满足下述两个条件，<code>x</code> 就会不开心：</p>
<ul>
	<li><code>x</code> 与 <code>u</code> 的亲近程度胜过 <code>x</code> 与 <code>y</code>，且</li>
	<li><code>u</code> 与 <code>x</code> 的亲近程度胜过 <code>u</code> 与 <code>v</code></li>
</ul>
<p>返回 <strong>不开心的朋友的数目</strong> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
<strong>输出：</strong>2
<strong>解释：</strong>
朋友 1 不开心，因为：
- <strong>1 与 0 </strong>配对，但 <strong>1 与 3</strong> 的亲近程度比 <strong>1 与 0</strong> 高，且
- <strong>3 与 1</strong> 的亲近程度比 <strong>3 与 2</strong> 高。
朋友 3 不开心，因为：
- 3 与 2 配对，但 <strong>3 与 1</strong> 的亲近程度比 <strong>3 与 2</strong> 高，且
- <strong>1 与 3</strong> 的亲近程度比 <strong>1 与 0</strong> 高。
朋友 0 和 2 都是开心的。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
<strong>输出：</strong>0
<strong>解释：</strong>朋友 0 和 1 都开心。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>2 &lt;= n &lt;= 500</code></li>
	<li><code>n</code> 是偶数</li>
	<li><code>preferences.length&nbsp;== n</code></li>
	<li><code>preferences[i].length&nbsp;== n - 1</code></li>
	<li><code>0 &lt;= preferences[i][j] &lt;= n - 1</code></li>
	<li><code>preferences[i]</code> 不包含 <code>i</code></li>
	<li><code>preferences[i]</code> 中的所有值都是独一无二的</li>
	<li><code>pairs.length&nbsp;== n/2</code></li>
	<li><code>pairs[i].length&nbsp;== 2</code></li>
	<li><code>x<sub>i</sub> != y<sub>i</sub></code></li>
	<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub>&nbsp;&lt;= n - 1</code></li>
	<li>每位朋友都 <strong>恰好</strong> 被包含在一对中</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            calcBetter(preferences[pair[0]], map, pair[0], pair[1]);
            calcBetter(preferences[pair[1]], map, pair[1], pair[0]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                if (unhappy(pairs[i][0], pairs[j][0], map)) {
                    set.add(pairs[i][0]);
                    set.add(pairs[j][0]);
                }
                if (unhappy(pairs[i][1], pairs[j][0], map)) {
                    set.add(pairs[i][1]);
                    set.add(pairs[j][0]);
                }
                if (unhappy(pairs[i][0], pairs[j][1], map)) {
                    set.add(pairs[i][0]);
                    set.add(pairs[j][1]);
                }
                if (unhappy(pairs[i][1], pairs[j][1], map)) {
                    set.add(pairs[i][1]);
                    set.add(pairs[j][1]);
                }
            }
        }
        return set.size();
    }
    private void calcBetter(int[] preference, Map<Integer, Set<Integer>> map, int from, int to) {
        Set<Integer> betterSet = new HashSet<>();
        for (int i : preference) {
            if (i == to) {
                break;
            }
            betterSet.add(i);
        }
        map.put(from, betterSet);
    }
    private boolean unhappy(int x, int y, Map<Integer, Set<Integer>> map) {
        return map.get(x).contains(y) && map.get(y).contains(x);
    }
}
```

# [1584. 连接所有点的最小费用](https://leetcode-cn.com/problems/min-cost-to-connect-all-points)
## 题目描述

<p>给你一个<code>points</code>&nbsp;数组，表示 2D 平面上的一些点，其中&nbsp;<code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>&nbsp;。</p>
<p>连接点&nbsp;<code>[x<sub>i</sub>, y<sub>i</sub>]</code> 和点&nbsp;<code>[x<sub>j</sub>, y<sub>j</sub>]</code>&nbsp;的费用为它们之间的 <strong>曼哈顿距离</strong>&nbsp;：<code>|x<sub>i</sub> - x<sub>j</sub>| + |y<sub>i</sub> - y<sub>j</sub>|</code>&nbsp;，其中&nbsp;<code>|val|</code>&nbsp;表示&nbsp;<code>val</code>&nbsp;的绝对值。</p>
<p>请你返回将所有点连接的最小总费用。只有任意两点之间 <strong>有且仅有</strong>&nbsp;一条简单路径时，才认为所有点都已连接。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225002228167.png)
<pre>
<strong>输入：</strong>points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
<strong>输出：</strong>20
<strong>解释：
</strong>
我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
注意到任意两个点之间只有唯一一条路径互相到达。
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225002246970.png)
<p><strong>示例 2：</strong></p>
<pre>
<strong>输入：</strong>points = [[3,12],[-2,5],[-4,1]]
<strong>输出：</strong>18
</pre>

<p><strong>示例 3：</strong></p>
<pre>
<strong>输入：</strong>points = [[0,0],[1,1],[1,0],[-1,1]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 4：</strong></p>
<pre>
<strong>输入：</strong>points = [[-1000000,-1000000],[1000000,1000000]]
<strong>输出：</strong>4000000
</pre>

<p><strong>示例 5：</strong></p>
<pre>
<strong>输入：</strong>points = [[0,0]]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= points.length &lt;= 1000</code></li>
	<li><code>-10<sup>6</sup>&nbsp;&lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
	<li>所有点&nbsp;<code>(x<sub>i</sub>, y<sub>i</sub>)</code>&nbsp;两两不同。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    static class Edge {
        int x;
        int y;
        int len;
        Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> heap = new PriorityQueue<>(Comparator.comparingInt((Edge e) -> e.len));
        boolean[] marked = new boolean[points.length];
        marked[0] = true;
        addVertex(points, marked, 0, heap);
        int count = 1;
        int res = 0;
        while (!heap.isEmpty()) {
            Edge edge = heap.poll();
            if (!marked[edge.y]) {
                res += edge.len;
                marked[edge.y] = true;
                addVertex(points, marked, edge.y, heap);
                count++;
                if (count == points.length) {
                    break;
                }
            }
        }
        return res;
    }
    public void addVertex(int[][] points, boolean[] marked, int x, Queue<Edge> heap) {
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                continue;
            }
            heap.add(new Edge(x, i,
                    Math.abs(points[x][0] - points[i][0]) + Math.abs(points[x][1] - points[i][1])));
        }
    }
}
```

# [1588. 所有奇数长度子数组的和](https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays)
****## 题目描述

<p>给你一个正整数数组&nbsp;<code>arr</code>&nbsp;，请你计算所有可能的奇数长度子数组的和。</p>
<p><strong>子数组</strong> 定义为原数组中的一个连续子序列。</p>
<p>请你返回 <code>arr</code>&nbsp;中 <strong>所有奇数长度子数组的和</strong> 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>arr = [1,4,2,5,3]
<strong>输出：</strong>58
<strong>解释：</strong>所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>arr = [1,2]
<strong>输出：</strong>3
<strong>解释：</strong>总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>arr = [10,11,12]
<strong>输出：</strong>66
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= arr.length &lt;= 100</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum[i] = (i != 0 ? sum[i - 1] : 0) + arr[i];
        }
        int ans = 0;
        // sum[b] - sum[a] 为 (a,b] 的和
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            for (int j = i + 2; j < arr.length; j += 2) {
                // [i, j]
                ans += sum[j] - sum[i] + arr[i];
            }
        }
        return ans;
    }
}
```

