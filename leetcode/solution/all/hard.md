# [4. 寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays)
## 题目描述

<p>给定两个大小为 m 和 n 的有序数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。</p>
<p>请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为&nbsp;O(log(m + n))。</p>
<p>你可以假设&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;不会同时为空。</p>
<p><strong>示例 1:</strong></p>
<pre>nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0
</pre>

<p><strong>示例 2:</strong></p>
<pre>nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
</pre>



## 解法

### **Java**
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }
        int min = 0;
        int max = len1;
        int m = (len1 + len2 + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = m - i;
            if (i > min && nums1[i - 1] > nums2[j]) {
                --max;
            } else if (i < max && nums2[j - 1] > nums1[i]) {
                ++min;
            } else {
                int maxLeft = i == 0 ? nums2[j - 1] : j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);
                if (((len1 + len2) & 1) == 1) {
                    return maxLeft;
                }
                int minRight = i == len1 ? nums2[j] : j == len2 ? nums1[i] : Math.min(nums2[j], nums1[i]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}
```
# [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching)
## 题目描述

<p>给你一个字符串&nbsp;<code>s</code>&nbsp;和一个字符规律&nbsp;<code>p</code>，请你来实现一个支持 <code>&#39;.&#39;</code>&nbsp;和&nbsp;<code>&#39;*&#39;</code>&nbsp;的正则表达式匹配。</p>
<pre>&#39;.&#39; 匹配任意单个字符
&#39;*&#39; 匹配零个或多个前面的那一个元素
</pre>

<p>所谓匹配，是要涵盖&nbsp;<strong>整个&nbsp;</strong>字符串&nbsp;<code>s</code>的，而不是部分字符串。</p>
<p><strong>说明:</strong></p>
<ul>
	<li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
	<li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母，以及字符&nbsp;<code>.</code>&nbsp;和&nbsp;<code>*</code>。</li>
</ul>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;a&quot;
<strong>输出:</strong> false
<strong>解释:</strong> &quot;a&quot; 无法匹配 &quot;aa&quot; 整个字符串。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;a*&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 &#39;*&#39; 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 &#39;a&#39;。因此，字符串 &quot;aa&quot; 可被视为 &#39;a&#39; 重复了一次。
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>
s = &quot;ab&quot;
p = &quot;.*&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;&quot;.*&quot; 表示可匹配零个或多个（&#39;*&#39;）任意字符（&#39;.&#39;）。
</pre>

<p><strong>示例 4:</strong></p>
<pre><strong>输入:</strong>
s = &quot;aab&quot;
p = &quot;c*a*b&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 &#39;*&#39; 表示零个或多个，这里 &#39;c&#39; 为 0 个, &#39;a&#39; 被重复一次。因此可以匹配字符串 &quot;aab&quot;。
</pre>

<p><strong>示例 5:</strong></p>
<pre><strong>输入:</strong>
s = &quot;mississippi&quot;
p = &quot;mis*is*p*.&quot;
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        match[s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                for (int j = s.length() - 1; j >= 0; j--) {
                    match[j] = match[j] || (match[j + 1] && (p.charAt(i - 1) == '.' ||
                            (p.charAt(i - 1) == s.charAt(j))));
                }
                i--;
            } else {
                for (int j = 0; j < s.length(); j++) {
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(j)));
                }
                match[s.length()] = false;
            }
        }
        return match[0];
    }
}
```
# [23. 合并 K 个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists)
## 题目描述

<p>合并&nbsp;<em>k&nbsp;</em>个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
[
&nbsp; 1-&gt;4-&gt;5,
&nbsp; 1-&gt;3-&gt;4,
&nbsp; 2-&gt;6
]
<strong>输出:</strong> 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6</pre>


## 解法
合并前后两个链表，结果放在后一个链表位置上，依次循环下去。

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
    public ListNode mergeKLists(ListNode[] lists) {
        int n;
        if (lists == null || (n = lists.length) == 0) {
            return null;
        }
        for (int i = 1; i < n; ++i) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[n - 1];
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
# [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group)
## 题目描述

<p>给你一个链表，每&nbsp;<em>k&nbsp;</em>个节点一组进行翻转，请你返回翻转后的链表。</p>
<p><em>k&nbsp;</em>是一个正整数，它的值小于或等于链表的长度。</p>
<p>如果节点总数不是&nbsp;<em>k&nbsp;</em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<p>给你这个链表：<code>1-&gt;2-&gt;3-&gt;4-&gt;5</code></p>
<p>当&nbsp;<em>k&nbsp;</em>= 2 时，应当返回: <code>2-&gt;1-&gt;4-&gt;3-&gt;5</code></p>
<p>当&nbsp;<em>k&nbsp;</em>= 3 时，应当返回: <code>3-&gt;2-&gt;1-&gt;4-&gt;5</code></p>
<p>&nbsp;</p>
<p><strong>说明：</strong></p>
<ul>
	<li>你的算法只能使用常数的额外空间。</li>
	<li><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际进行节点交换。</li>
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) {
            return head;
        }
        int num = 0;
        ListNode pNode = head;
        ListNode lastNode = new ListNode(0);
        ListNode reNode = lastNode;
        lastNode.next = head;
        while (pNode != null) {
            num++;
            if(num >= k) {
                num = 0;
                ListNode tempNode = pNode.next;
                reverse(lastNode.next, k);
				// k 个节点的尾节点指向下一组的头节点
                lastNode.next.next = tempNode;	
				// 上一组的尾节点指向当前 k 个节点的头节点				
                tempNode = lastNode.next;				
                lastNode.next = pNode;
				
                lastNode = tempNode;
                pNode = lastNode.next;
            }
            else {
                pNode = pNode.next;
            }
        }
        return reNode.next;
    }
    private ListNode reverse(ListNode node, int i) {
        if(i <= 1 || node.next == null) {
            return node;
        }
        ListNode lastNode = reverse(node.next, i - 1);
        lastNode.next = node; 
        return node;
    }
}
```
# [30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words)
## 题目描述

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

### **Java**
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
# [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses)
## 题目描述

<p>给定一个只包含 <code>&#39;(&#39;</code>&nbsp;和 <code>&#39;)&#39;</code>&nbsp;的字符串，找出最长的包含有效括号的子串的长度。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> &quot;(()&quot;
<strong>输出:</strong> 2
<strong>解释:</strong> 最长有效括号子串为 <code>&quot;()&quot;</code>
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> &quot;<code>)()())</code>&quot;
<strong>输出:</strong> 4
<strong>解释:</strong> 最长有效括号子串为 <code>&quot;()()&quot;</code>
</pre>


## 解法

### **Java**
```java
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[n];
        res[0] = 0;
        res[1] = chars[1] == ')' && chars[0] == '(' ? 2 : 0;
        
        int max = res[1];
        
        for (int i = 2; i < n; ++i) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    res[i] = res[i - 2] + 2;
                } else {
                    int index = i - res[i - 1] - 1;
                    if (index >= 0 && chars[index] == '(') {
                        // ()(())
                        res[i] = res[i - 1] + 2 + (index - 1 >= 0 ? res[index - 1] : 0);
                    }
                }
            }
            max = Math.max(max, res[i]);
        }
        
        return max;
        
    }
}
```
# [37. 解数独](https://leetcode-cn.com/problems/sudoku-solver)
## 题目描述

<p>编写一个程序，通过已填充的空格来解决数独问题。</p>
<p>一个数独的解法需<strong>遵循如下规则</strong>：</p>
<ol>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一行只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一列只能出现一次。</li>
	<li>数字&nbsp;<code>1-9</code>&nbsp;在每一个以粗实线分隔的&nbsp;<code>3x3</code>&nbsp;宫内只能出现一次。</li>
</ol>
<p>空白格用&nbsp;<code>&#39;.&#39;</code>&nbsp;表示。</p>
<p>

<img src="http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png"></p>

<p><small>一个数独。</small></p>
<p><img src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png"></p>
<p><small>答案被标成红色。</small></p>
<p><strong>Note:</strong></p>
<ul>
	<li>给定的数独序列只包含数字&nbsp;<code>1-9</code>&nbsp;和字符&nbsp;<code>&#39;.&#39;</code>&nbsp;。</li>
	<li>你可以假设给定的数独只有唯一解。</li>
	<li>给定数独永远是&nbsp;<code>9x9</code>&nbsp;形式的。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    private char[][] board;
    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] subBox;
    public void solveSudoku(char[][] board) {
        this.board = board;
        this.rows = new boolean[9][9];
        this.cols = new boolean[9][9];
        this.subBox = new boolean[9][9];
        int val;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    val = board[i][j] - '0';
                    rows[i][val - 1] = true;
                    cols[j][val - 1] = true;
                    subBox[(i / 3) * 3 + j / 3][val - 1] = true;
                }
            }
        }
        fillSudoku(0, 0);
    }
    private boolean fillSudoku(int i, int j) {
        if (i == 9) return true;
        int x = i, y = j;
        if (y == 8) {
            x++;
            y = 0;
        } else y++;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (!rows[i][k - 1] && !cols[j][k - 1] && !subBox[(i / 3) * 3 + j / 3][k - 1]) {
                    rows[i][k - 1] = true;
                    cols[j][k - 1] = true;
                    subBox[(i / 3) * 3 + j / 3][k - 1] = true;
                    if (fillSudoku(x, y)) {
                        board[i][j] = (char) (k + '0');
                        return true;
                    }
                    rows[i][k - 1] = false;
                    cols[j][k - 1] = false;
                    subBox[(i / 3) * 3 + j / 3][k - 1] = false;
                }
            }
            return false;
        } else return fillSudoku(x, y);
    }
}
```
# [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive)
## 题目描述

<p>给定一个未排序的整数数组，找出其中没有出现的最小的正整数。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre>输入: [1,2,0]
输出: 3
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre>输入: [3,4,-1,1]
输出: 2
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre>输入: [7,8,9,11,12]
输出: 1
</pre>

<p><strong>说明:</strong></p>
<p>你的算法的时间复杂度应为O(<em>n</em>)，并且只能使用常数级别的空间。</p>

## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    public int firstMissingPositive(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0 && num[i] < num.length && num[num[i] - 1] != num[i]) {
                swap(num, i, num[i] - 1);
                i--;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (i + 1 != num[i]) {
                return i + 1;
            }
        }
        
        return num.length + 1;
    }
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
```
# [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water)
## 题目描述

<p>给定&nbsp;<em>n</em> 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215357274.png)
<p><small>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。&nbsp;<strong>感谢 Marcos</strong> 贡献此图。</small></p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出:</strong> 6</pre>


## 解法

### **Java**
```java
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lx = 0, rx = height.length - 1, l = height[lx], r = height[rx], re = 0;
        while (lx < rx) {
            if (l < r) {
                lx++;
                if (height[lx] < l) re += l - height[lx];
                else l = height[lx];
            } else {
                rx--;
                if (height[rx] < r) re += r - height[rx];
                else r = height[rx];
            }
        }
        return re;
    }
}
```
# [44. 通配符匹配](https://leetcode-cn.com/problems/wildcard-matching)
## 题目描述

<p>给定一个字符串&nbsp;(<code>s</code>) 和一个字符模式&nbsp;(<code>p</code>) ，实现一个支持&nbsp;<code>&#39;?&#39;</code>&nbsp;和&nbsp;<code>&#39;*&#39;</code>&nbsp;的通配符匹配。</p>
<pre>&#39;?&#39; 可以匹配任何单个字符。
&#39;*&#39; 可以匹配任意字符串（包括空字符串）。
</pre>

<p>两个字符串<strong>完全匹配</strong>才算匹配成功。</p>
<p><strong>说明:</strong></p>
<ul>
	<li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li>
	<li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母，以及字符&nbsp;<code>?</code>&nbsp;和&nbsp;<code>*</code>。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;a&quot;
<strong>输出:</strong> false
<strong>解释:</strong> &quot;a&quot; 无法匹配 &quot;aa&quot; 整个字符串。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
s = &quot;aa&quot;
p = &quot;*&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;&#39;*&#39; 可以匹配任意字符串。
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>
s = &quot;cb&quot;
p = &quot;?a&quot;
<strong>输出:</strong> false
<strong>解释:</strong>&nbsp;&#39;?&#39; 可以匹配 &#39;c&#39;, 但第二个 &#39;a&#39; 无法匹配 &#39;b&#39;。
</pre>

<p><strong>示例&nbsp;4:</strong></p>
<pre><strong>输入:</strong>
s = &quot;adceb&quot;
p = &quot;*a*b&quot;
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;第一个 &#39;*&#39; 可以匹配空字符串, 第二个 &#39;*&#39; 可以匹配字符串 &quot;dce&quot;.
</pre>

<p><strong>示例&nbsp;5:</strong></p>
<pre><strong>输入:</strong>
s = &quot;acdcb&quot;
p = &quot;a*c?b&quot;
<strong>输入:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, is = -1, ip = -1;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        while (i < ss.length) {
            if (j < pp.length && (ss[i] == pp[j] || pp[j] == '?')) {
                i++;
                j++;
            } else if (j < pp.length && pp[j] == '*') {
                ip = j++;
                is = i;
            } else if (ip != -1) {
                j = ip + 1;
                i = ++is;
            } else return false;
        }
        while (j < pp.length && pp[j] == '*') j++;
        return j == p.length();
    }
}
```
# [51. N 皇后](https://leetcode-cn.com/problems/n-queens)
## 题目描述

<p><em>n&nbsp;</em>皇后问题研究的是如何将 <em>n</em>&nbsp;个皇后放置在 <em>n</em>&times;<em>n</em> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215428136.png)
<p><small>上图为 8 皇后问题的一种解法。</small></p>
<p>给定一个整数 <em>n</em>，返回所有不同的&nbsp;<em>n&nbsp;</em>皇后问题的解决方案。</p>
<p>每一种解法包含一个明确的&nbsp;<em>n</em> 皇后问题的棋子放置方案，该方案中 <code>&#39;Q&#39;</code> 和 <code>&#39;.&#39;</code> 分别代表了皇后和空位。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 4
<strong>输出:</strong> [
 [&quot;.Q..&quot;,  // 解法 1
  &quot;...Q&quot;,
  &quot;Q...&quot;,
  &quot;..Q.&quot;],
 [&quot;..Q.&quot;,  // 解法 2
  &quot;Q...&quot;,
  &quot;...Q&quot;,
  &quot;.Q..&quot;]
]
<strong>解释:</strong> 4 皇后问题存在两个不同的解法。
</pre>


## 解法

### **Java**
```java
class Solution {
    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(nQueens[i], '.');
        colUsed = new boolean[n];
        diagonals45Used = new boolean[(2 * n) - 1];
        diagonals135Used = new boolean[(2 * n) - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }
    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) list.add(new String(chars));
            solutions.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) continue;
            nQueens[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
            backtracking(row + 1);
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
            nQueens[row][col] = '.';
        }
    }
}
```
# [52. N 皇后 II](https://leetcode-cn.com/problems/n-queens-ii)
## 题目描述

<p><em>n&nbsp;</em>皇后问题研究的是如何将 <em>n</em>&nbsp;个皇后放置在 <em>n</em>&times;<em>n</em> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215456854.png)
<p><small>上图为 8 皇后问题的一种解法。</small></p>
<p>给定一个整数 <em>n</em>，返回 <em>n</em> 皇后不同的解决方案的数量。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 4
<strong>输出:</strong> 2
<strong>解释:</strong> 4 皇后问题存在如下两个不同的解法。
[
&nbsp;[&quot;.Q..&quot;, &nbsp;// 解法 1
&nbsp; &quot;...Q&quot;,
&nbsp; &quot;Q...&quot;,
&nbsp; &quot;..Q.&quot;],
&nbsp;[&quot;..Q.&quot;, &nbsp;// 解法 2
&nbsp; &quot;Q...&quot;,
&nbsp; &quot;...Q&quot;,
&nbsp; &quot;.Q..&quot;]
]
</pre>


## 解法

### **Java**
```java
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] c = new int[n];
        search(0, n, c);
        return count;
    }
    public void search(int cur, int n, int[] c) {
        if (cur == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            c[cur] = i;
            for (int j = 0; j < cur; j++) {
                if ((c[cur] == c[j]) || ((c[cur] - cur) == (c[j] - j)) || ((c[cur] + cur) == (c[j] + j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) search(cur + 1, n, c);
        }
    }
}
```
# [60. 第 k 个排列](https://leetcode-cn.com/problems/permutation-sequence)
## 题目描述

<p>给出集合&nbsp;<code>[1,2,3,&hellip;,<em>n</em>]</code>，其所有元素共有&nbsp;<em>n</em>! 种排列。</p>
<p>按大小顺序列出所有排列情况，并一一标记，当&nbsp;<em>n </em>= 3 时, 所有排列如下：</p>
<ol>
	<li><code>&quot;123&quot;</code></li>
	<li><code>&quot;132&quot;</code></li>
	<li><code>&quot;213&quot;</code></li>
	<li><code>&quot;231&quot;</code></li>
	<li><code>&quot;312&quot;</code></li>
	<li><code>&quot;321&quot;</code></li>
</ol>
<p>给定&nbsp;<em>n</em> 和&nbsp;<em>k</em>，返回第&nbsp;<em>k</em>&nbsp;个排列。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>给定<em> n</em>&nbsp;的范围是 [1, 9]。</li>
	<li>给定 <em>k&nbsp;</em>的范围是[1, &nbsp;<em>n</em>!]。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> n = 3, k = 3
<strong>输出:</strong> &quot;213&quot;
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> n = 4, k = 9
<strong>输出:</strong> &quot;2314&quot;
</pre>


## 解法

### **Java**
```java
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        k--;
        for (int i = n; i >= 1; i--) {
            int j=k/fact[i-1];
            k=k%fact[i-1];
            s.append(list.get(j));
            list.remove(j);
        }
        return s.toString();
    }
}
```
# [65. 有效数字](https://leetcode-cn.com/problems/valid-number)
## 题目描述

<p>验证给定的字符串是否可以解释为十进制数字。</p>
<p>例如:</p>
<p><code>&quot;0&quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot; 0.1 &quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot;abc&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;1 a&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;2e10&quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot; -90e3&nbsp; &nbsp;&quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot; 1e&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;e3&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot; 6e-1&quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot; 99e2.5&nbsp;&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;53.5e93&quot;</code>&nbsp;=&gt;&nbsp;<code>true</code><br>
<code>&quot; --6 &quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;-+3&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code><br>
<code>&quot;95a54e53&quot;</code>&nbsp;=&gt;&nbsp;<code>false</code></p>
<p><strong>说明:</strong>&nbsp;我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：</p>
<ul>
	<li>数字 0-9</li>
	<li>指数 - &quot;e&quot;</li>
	<li>正/负号 - &quot;+&quot;/&quot;-&quot;</li>
	<li>小数点 - &quot;.&quot;</li>
</ul>
<p>当然，在输入中，这些字符的上下文也很重要。</p>
<p><strong>更新于 2015-02-10:</strong><br>
<code>C++</code>函数的形式已经更新了。如果你仍然看见你的函数接收&nbsp;<code>const char *</code> 类型的参数，请点击重载按钮重置你的代码。</p>

## 解法

### **Java**
```java
class Solution {
    public boolean isNumber(String s) {
        if(null==s || 0==s.length()) return false;
        int start=0,end=s.length()-1;
        char[] c=s.toCharArray();
        while(start<=end && ' '==c[start]) start++;
        while(end>=start && ' '==c[end] ) end--;
        if(start>end) return false;
        if('+'==c[start] || '-'==c[start]) start++;
        boolean hasNum=false;
        boolean hasDot=false;
        boolean hasE=false;
        while(start<=end){
            if(c[start]>='0' && c[start]<='9') hasNum = true;
            else if(c[start]=='e'){
                if(hasE || !hasNum) return false;
                hasE=true;
                hasNum=false;
            }
            else if(c[start]=='.'){
                if(hasDot || hasE) return false;
                hasDot=true;
            }
            else if('+'==c[start] || '-'==c[start]){
                if(c[start-1]!='e') return false;
            }else return false;
            start++;
        }
        return hasNum;
    }
}
```
# [68. 文本左右对齐](https://leetcode-cn.com/problems/text-justification)
## 题目描述

<p>给定一个单词数组和一个长度&nbsp;<em>maxWidth</em>，重新排版单词，使其成为每行恰好有&nbsp;<em>maxWidth</em>&nbsp;个字符，且左右两端对齐的文本。</p>
<p>你应该使用&ldquo;贪心算法&rdquo;来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格&nbsp;<code>&#39; &#39;</code>&nbsp;填充，使得每行恰好有 <em>maxWidth</em>&nbsp;个字符。</p>
<p>要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。</p>
<p>文本的最后一行应为左对齐，且单词之间不插入<strong>额外的</strong>空格。</p>
<p><strong>说明:</strong></p>
<ul>
	<li>单词是指由非空格字符组成的字符序列。</li>
	<li>每个单词的长度大于 0，小于等于&nbsp;<em>maxWidth</em>。</li>
	<li>输入单词数组 <code>words</code>&nbsp;至少包含一个单词。</li>
</ul>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
words = [&quot;This&quot;, &quot;is&quot;, &quot;an&quot;, &quot;example&quot;, &quot;of&quot;, &quot;text&quot;, &quot;justification.&quot;]
maxWidth = 16
<strong>输出:</strong>
[
&nbsp; &nbsp;&quot;This &nbsp; &nbsp;is &nbsp; &nbsp;an&quot;,
&nbsp; &nbsp;&quot;example &nbsp;of text&quot;,
&nbsp; &nbsp;&quot;justification. &nbsp;&quot;
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong>
words = [&quot;What&quot;,&quot;must&quot;,&quot;be&quot;,&quot;acknowledgment&quot;,&quot;shall&quot;,&quot;be&quot;]
maxWidth = 16
<strong>输出:</strong>
[
&nbsp; &quot;What &nbsp; must &nbsp; be&quot;,
&nbsp; &quot;acknowledgment &nbsp;&quot;,
&nbsp; &quot;shall be &nbsp; &nbsp; &nbsp; &nbsp;&quot;
]
<strong>解释: </strong>注意最后一行的格式应为 &quot;shall be    &quot; 而不是 &quot;shall     be&quot;,
&nbsp;    因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
</pre>

<p><strong>示例&nbsp;3:</strong></p>
<pre><strong>输入:</strong>
words = [&quot;Science&quot;,&quot;is&quot;,&quot;what&quot;,&quot;we&quot;,&quot;understand&quot;,&quot;well&quot;,&quot;enough&quot;,&quot;to&quot;,&quot;explain&quot;,
&nbsp;        &quot;to&quot;,&quot;a&quot;,&quot;computer.&quot;,&quot;Art&quot;,&quot;is&quot;,&quot;everything&quot;,&quot;else&quot;,&quot;we&quot;,&quot;do&quot;]
maxWidth = 20
<strong>输出:</strong>
[
&nbsp; &quot;Science &nbsp;is &nbsp;what we&quot;,
  &quot;understand &nbsp; &nbsp; &nbsp;well&quot;,
&nbsp; &quot;enough to explain to&quot;,
&nbsp; &quot;a &nbsp;computer. &nbsp;Art is&quot;,
&nbsp; &quot;everything &nbsp;else &nbsp;we&quot;,
&nbsp; &quot;do &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&quot;
]
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int count = 0, last = 0;
        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() + (i - last) > maxWidth) {
                int spaceNum = 0, extraNum = 0;
                if (i - last - 1 > 0) {
                    spaceNum = (maxWidth - count) / (i - last - 1);
                    extraNum = (maxWidth - count) % (i - last - 1);
                }
                StringBuilder str = new StringBuilder();
                for (int j = last; j < i; j++) {
                    str.append(words[j]);
                    if (j < i - 1) {
                        for (int k = 0; k < spaceNum; k++) str.append(" ");
                        if (extraNum > 0) str.append(" ");
                        extraNum--;
                    }
                }
                for (int j = str.length(); j < maxWidth; j++) str.append(" ");
                res.add(str.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }
        StringBuilder str = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            str.append(words[i]);
            if (str.length() < maxWidth) str.append(" ");
        }
        for (int i = str.length(); i < maxWidth; i++) str.append(" ");
        res.add(str.toString());
        return res;
    }
}
```
# [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance)
## 题目描述

<p>给定两个单词&nbsp;<em>word1</em> 和&nbsp;<em>word2</em>，计算出将&nbsp;<em>word1</em>&nbsp;转换成&nbsp;<em>word2 </em>所使用的最少操作数&nbsp;。</p>
<p>你可以对一个单词进行如下三种操作：</p>
<ol>
	<li>插入一个字符</li>
	<li>删除一个字符</li>
	<li>替换一个字符</li>
</ol>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
<strong>输出:</strong> 3
<strong>解释:</strong> 
horse -&gt; rorse (将 &#39;h&#39; 替换为 &#39;r&#39;)
rorse -&gt; rose (删除 &#39;r&#39;)
rose -&gt; ros (删除 &#39;e&#39;)
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
<strong>输出:</strong> 5
<strong>解释:</strong> 
intention -&gt; inention (删除 &#39;t&#39;)
inention -&gt; enention (将 &#39;i&#39; 替换为 &#39;e&#39;)
enention -&gt; exention (将 &#39;n&#39; 替换为 &#39;x&#39;)
exention -&gt; exection (将 &#39;n&#39; 替换为 &#39;c&#39;)
exection -&gt; execution (插入 &#39;u&#39;)
</pre>


## 解法

### **Java**
```java
class Solution {
    public int minDistance(String word1, String word2) {
        return edit(word1.length(),word2.length(),word1,word2,new int[word1.length()+1][word2.length()+1]);
    }
    private int edit(int l, int r, String w1, String w2, int[][] dp){
        if(l==0) return r;
        if(r==0) return l;
        if(dp[l][r]!=0) return dp[l][r];
        int min = (w1.charAt(l-1)!=w2.charAt(r-1)) ?
                Math.min(edit(l-1,r-1,w1,w2,dp)+1,Math.min(edit(l-1,r,w1,w2,dp)+1,edit(l,r-1,w1,w2,dp)+1))
                : edit(l - 1, r - 1, w1, w2, dp);
        dp[l][r] = min;
        return min;
    }
}
```
# [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring)
## 题目描述

<p>给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。</p>
<p><strong>示例：</strong></p>
<pre><strong>输入: S</strong> = &quot;ADOBECODEBANC&quot;, <strong>T</strong> = &quot;ABC&quot;
<strong>输出:</strong> &quot;BANC&quot;</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>如果 S 中不存这样的子串，则返回空字符串 <code>&quot;&quot;</code>。</li>
	<li>如果 S 中存在这样的子串，我们保证它是唯一的答案。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int['z' - 'A' + 1];
        int uniq = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (++count[t.charAt(i) - 'A'] == 1) uniq++;
        }
        int found = 0,i = 0,j = 0;
        int minLen = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;
        while (found < uniq) {
            while (i < s.length()) {
                if (found >= uniq) break;
                if (--count[s.charAt(i) - 'A'] == 0) found++;
                i++;
            }
            if (found < uniq) break;
            while (j < i && count[s.charAt(j) - 'A'] < 0) count[s.charAt(j++) - 'A']++;
            if (i - j < minLen) {
                minLen = i - j;
                minJ = j;
            }
            count[s.charAt(j++) - 'A']++;
            found--;
        }
        return minLen < Integer.MAX_VALUE ? s.substring(minJ, minJ + minLen) : "";
    }
}
```
# [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)
## 题目描述

<p>给定 <em>n</em> 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>
<p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215625224.png)
<p><small>以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为&nbsp;<code>[2,1,5,6,2,3]</code>。</small></p>
<p>&nbsp;</p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210224215647477.png)
<p><small>图中阴影部分为所能勾勒出的最大矩形面积，其面积为&nbsp;<code>10</code>&nbsp;个单位。</small></p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> [2,1,5,6,2,3]
<strong>输出:</strong> 10</pre>


## 解法

### **Java**
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }
        // 创建一个新的数组，数组长度为 n + 1，最后一个元素值赋为 0
        // 确保在后面的遍历中，原数组最后一个元素值能得到计算
        int[] heightss = new int[n + 1];
        heightss[n] = 0;
        for (int i = 0; i < n; ++i) {
            heightss[i] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= n;) {
            if (stack.isEmpty() || heightss[i] > heightss[stack.peek()]) {
                stack.push(i++);
            } else {
                int index = stack.pop();
                max = Math.max(max, heightss[index] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}
```
# [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle)
## 题目描述

<p>给定一个仅包含&nbsp;0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>
[
  [&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;0&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;,&quot;<strong>1</strong>&quot;],
  [&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;]
]
<strong>输出:</strong> 6</pre>


## 解法

### **Java**
```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int result = 0;
        int[] row = new int[matrix[0].length];
        for(char[] line : matrix){
            update(line,row);
            result = Math.max(result, largestRectangleArea(row));
        }
        return result;
    }
    private int largestRectangleArea(int[] heights) {
        int[] stack = new int[1 << 10];
        int length = heights.length;
        int j, stackSize= 0, ma = 0, a;
        for (int i = 0; i <= length; i++) {
            while (stackSize > 0 &&( i==length || heights[i] < heights[stack[stackSize - 1]])) {
                j = stack[--stackSize];
                a = (i - (stackSize == 0 ? 0 : stack[stackSize - 1] + 1)) * (heights[j]);
                if (a > ma) ma = a;
            }
            stack[stackSize++] = i;
        }
        return ma;
    }
    private void update(char[] line, int[] row){
        for (int i = 0; i < row.length; i++) {
            if (line[i] == '0') row[i] = 0;
            else row[i]++;
        }
    }
}
```
# [87. 扰乱字符串](https://leetcode-cn.com/problems/scramble-string)
## 题目描述

<p>给定一个字符串&nbsp;<em>s1</em>，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。</p>
<p>下图是字符串&nbsp;<em>s1</em>&nbsp;=&nbsp;<code>&quot;great&quot;</code>&nbsp;的一种可能的表示形式。</p>
<pre>    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
</pre>

<p>在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。</p>
<p>例如，如果我们挑选非叶节点&nbsp;<code>&quot;gr&quot;</code>&nbsp;，交换它的两个子节点，将会产生扰乱字符串&nbsp;<code>&quot;rgeat&quot;</code>&nbsp;。</p>
<pre>    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
</pre>

<p>我们将&nbsp;<code>&quot;rgeat&rdquo;</code>&nbsp;称作&nbsp;<code>&quot;great&quot;</code>&nbsp;的一个扰乱字符串。</p>
<p>同样地，如果我们继续交换节点&nbsp;<code>&quot;eat&quot;</code>&nbsp;和&nbsp;<code>&quot;at&quot;</code>&nbsp;的子节点，将会产生另一个新的扰乱字符串&nbsp;<code>&quot;rgtae&quot;</code>&nbsp;。</p>
<pre>    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
</pre>

<p>我们将&nbsp;<code>&quot;rgtae&rdquo;</code>&nbsp;称作&nbsp;<code>&quot;great&quot;</code>&nbsp;的一个扰乱字符串。</p>
<p>给出两个长度相等的字符串 <em>s1 </em>和&nbsp;<em>s2</em>，判断&nbsp;<em>s2&nbsp;</em>是否是&nbsp;<em>s1&nbsp;</em>的扰乱字符串。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> s1 = &quot;great&quot;, s2 = &quot;rgeat&quot;
<strong>输出:</strong> true
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> s1 = &quot;abcde&quot;, s2 = &quot;caebd&quot;
<strong>输出:</strong> false</pre>


## 解法

### **Java**
```java
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length()!=s2.length()) return false;
        int len = s1.length();
        int[] count = new int[26];
        for(int i = 0; i < len; i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for(int item : count) if (item != 0) return false;
        for(int i = 1; i <= len - 1; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
```
# [115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences)
## 题目描述

<p>给定一个字符串&nbsp;<strong>S&nbsp;</strong>和一个字符串&nbsp;<strong>T</strong>，计算在 <strong>S</strong> 的子序列中 <strong>T</strong> 出现的个数。</p>
<p>一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，<code>&quot;ACE&quot;</code>&nbsp;是&nbsp;<code>&quot;ABCDE&quot;</code>&nbsp;的一个子序列，而&nbsp;<code>&quot;AEC&quot;</code>&nbsp;不是）</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong>S = <code>&quot;rabbbit&quot;</code>, T = <code>&quot;rabbit&quot;
<strong>输出:</strong>&nbsp;3
</code><strong>解释:
</strong>
如下图所示, 有 3 种可以从 S 中得到 <code>&quot;rabbit&quot; 的方案</code>。
(上箭头符号 ^ 表示选取的字母)
<code>rabbbit</code>
^^^^ ^^
<code>rabbbit</code>
^^ ^^^^
<code>rabbbit</code>
^^^ ^^^
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入: </strong>S = <code>&quot;babgbag&quot;</code>, T = <code>&quot;bag&quot;
<strong>输出:</strong>&nbsp;5
</code><strong>解释:
</strong>
如下图所示, 有 5 种可以从 S 中得到 <code>&quot;bag&quot; 的方案</code>。 
(上箭头符号 ^ 表示选取的字母)
<code>babgbag</code>
^^ ^
<code>babgbag</code>
^^    ^
<code>babgbag</code>
^    ^^
<code>babgbag</code>
  ^  ^^
<code>babgbag</code>
    ^^^</pre>


## 解法

### **Java**
```java
class Solution {
    public int numDistinct(String s, String t) {
        int[][] hash = new int[256][t.length() + 1];
        int[] cnt = new int[t.length() + 1];
        cnt[0] = 1;
        for (int i = 0; i < t.length();) {
            char c = t.charAt(i);
            hash[c][++hash[c][0]] = ++i;
        }
        for(char c : s.toCharArray()) {
            for(int i = hash[c][0]; i > 0; i--) {
                cnt[hash[c][i]] += cnt[hash[c][i] - 1];
            }
        }
        return cnt[t.length()];
    }
}
```
# [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii)
## 题目描述

<p>给定一个数组，它的第<em> i</em> 个元素是一支给定的股票在第 <em>i </em>天的价格。</p>
<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成&nbsp;<em>两笔&nbsp;</em>交易。</p>
<p><strong>注意:</strong>&nbsp;你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [3,3,5,0,0,3,1,4]
<strong>输出:</strong> 6
<strong>解释:</strong> 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
&nbsp;    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> 4
<strong>解释:</strong> 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。 &nbsp; 
&nbsp;    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。 &nbsp; 
&nbsp;    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> [7,6,4,3,1] 
<strong>输出:</strong> 0 
<strong>解释:</strong> 在这个情况下, 没有交易完成, 所以最大利润为 0。</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int m = 2 , n = prices.length;
        int[][] dp = new int[m+1][n];
        for (int i = 1; i <= m; i++) {
            int maxdiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                maxdiff = Math.max(maxdiff, dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxdiff);
            }
        }
        return dp[m][n-1];
    }
}
```
# [124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum)
## 题目描述

<p>给定一个<strong>非空</strong>二叉树，返回其最大路径和。</p>
<p>本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径<strong>至少包含一个</strong>节点，且不一定经过根节点。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [1,2,3]
       <strong>1</strong>
      <strong>/ \</strong>
     <strong>2</strong>   <strong>3</strong>
<strong>输出:</strong> 6
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [-10,9,20,null,null,15,7]
&nbsp;  -10
&nbsp; &nbsp;/ \
&nbsp; 9 &nbsp;<strong>20</strong>
&nbsp; &nbsp; <strong>/ &nbsp;\</strong>
&nbsp; &nbsp;<strong>15 &nbsp; 7</strong>
<strong>输出:</strong> 42</pre>


## 解法

### **Java**
```java
class Solution {
    private int val = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return val;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int val1 = root.val + left + right;
        int val2 = root.val + Math.max(0, Math.max(left, right));
        val = Math.max(val, val1);
        return val2;
    }
}
```
# [126. 单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii)
## 题目描述

<p>给定两个单词（<em>beginWord</em> 和 <em>endWord</em>）和一个字典 <em>wordList</em>，找出所有从 <em>beginWord </em>到 <em>endWord </em>的最短转换序列。转换需遵循如下规则：</p>
<ol>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典中的单词。</li>
</ol>
<p><strong>说明:</strong></p>
<ul>
	<li>如果不存在这样的转换序列，返回一个空列表。</li>
	<li>所有单词具有相同的长度。</li>
	<li>所有单词只由小写字母组成。</li>
	<li>字典中不存在重复的单词。</li>
	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
</ul>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;,
endWord = &quot;cog&quot;,
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
<strong>输出:</strong>
[
  [&quot;hit&quot;,&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;cog&quot;],
&nbsp; [&quot;hit&quot;,&quot;hot&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;
endWord = &quot;cog&quot;
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]
<strong>输出: </strong>[]
<strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以不存在符合要求的转换序列。</pre>


## 解法

### **Java**
```java
class Solution {
    private boolean isConnected = false;
    private Map<String, List<String>> hs;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        hs = new HashMap<>(16);
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord))
            return result;
        HashSet<String> dict = new HashSet<>(wordList);
        Set<String> fwd = new HashSet<>();
        fwd.add(beginWord);
        Set<String> bwd = new HashSet<>();
        bwd.add(endWord);
        bfs(fwd, bwd, dict, false);
        if(!isConnected) return result;
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        dfs(result, temp, beginWord, endWord);
        return result;
    }
    private void bfs(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap){
        if(forward.isEmpty() || backward.isEmpty()) return;
        if(forward.size() > backward.size()){
            bfs(backward, forward, dict, !swap);
            return;
        }
        dict.removeAll(forward);
        dict.removeAll(backward);
        Set<String> set3 = new HashSet<>();
        for(String str : forward)
            for (int i = 0; i < str.length(); i++) {
                char[] ary = str.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ary[i] = j;
                    String temp = new String(ary);
                    if (!backward.contains(temp) && !dict.contains(temp)) continue;
                    String key = !swap ? str : temp;
                    String val = !swap ? temp : str;
                    if (!hs.containsKey(key)) hs.put(key, new ArrayList<>());
                    if (backward.contains(temp)) {
                        hs.get(key).add(val);
                        isConnected = true;
                    }
                    if (!isConnected && dict.contains(temp)) {
                        hs.get(key).add(val);
                        set3.add(temp);
                    }
                }
            }
        if(!isConnected) bfs(set3, backward, dict, swap);
    }
    private void dfs(List<List<String>> result, List<String> temp, String start, String end){
        if(start.equals(end)){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(!hs.containsKey(start)) return;
        for(String s : hs.get(start)){
            temp.add(s);
            dfs(result, temp, s, end);
            temp.remove(temp.size()-1);
        }
    }
}
```
# [127. 单词接龙](https://leetcode-cn.com/problems/word-ladder)
## 题目描述

<p>给定两个单词（<em>beginWord&nbsp;</em>和 <em>endWord</em>）和一个字典，找到从&nbsp;<em>beginWord</em> 到&nbsp;<em>endWord</em> 的最短转换序列的长度。转换需遵循如下规则：</p>
<ol>
	<li>每次转换只能改变一个字母。</li>
	<li>转换过程中的中间单词必须是字典中的单词。</li>
</ol>
<p><strong>说明:</strong></p>
<ul>
	<li>如果不存在这样的转换序列，返回 0。</li>
	<li>所有单词具有相同的长度。</li>
	<li>所有单词只由小写字母组成。</li>
	<li>字典中不存在重复的单词。</li>
	<li>你可以假设 <em>beginWord</em> 和 <em>endWord </em>是非空的，且二者不相同。</li>
</ul>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;,
endWord = &quot;cog&quot;,
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;,&quot;cog&quot;]
<strong>输出: </strong>5
<strong>解释: </strong>一个最短转换序列是 &quot;hit&quot; -&gt; &quot;hot&quot; -&gt; &quot;dot&quot; -&gt; &quot;dog&quot; -&gt; &quot;cog&quot;,
     返回它的长度 5。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong>
beginWord = &quot;hit&quot;
endWord = &quot;cog&quot;
wordList = [&quot;hot&quot;,&quot;dot&quot;,&quot;dog&quot;,&quot;lot&quot;,&quot;log&quot;]
<strong>输出:</strong>&nbsp;0
<strong>解释:</strong>&nbsp;<em>endWord</em> &quot;cog&quot; 不在字典中，所以无法进行转换。</pre>


## 解法

### **Java**
```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        
        // 需要转hashSet
        Set<String> wordSet = new HashSet<>(wordList);
        queue.offer(beginWord);
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            --curNum;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                char ch = chars[i];
                for (char j = 'a'; j <= 'z'; ++j) {
                    chars[i] = j;
                    String tmp = new String(chars);
                    // 字典中包含生成的中间字符串
                    if (wordSet.contains(tmp)) {
                        // 中间字符串与 endWord 相等
                        if (endWord.equals(tmp)) {
                            return level + 1;
                        }
                        // 中间字符串不是 endWord，则入队
                        queue.offer(tmp);
                        ++nextNum;
                        // 确保之后不会再保存 tmp 字符串
                        wordSet.remove(tmp);
                    }
                }
                chars[i] = ch;
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                ++level;
            }
        }
        
        return 0;
    }
}
```
# [132. 分割回文串 II](https://leetcode-cn.com/problems/palindrome-partitioning-ii)
## 题目描述

<p>给定一个字符串 <em>s</em>，将 <em>s</em> 分割成一些子串，使每个子串都是回文串。</p>
<p>返回符合要求的最少分割次数。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong>&nbsp;&quot;aab&quot;
<strong>输出:</strong> 1
<strong>解释: </strong>进行一次分割就可将&nbsp;<em>s </em>分割成 [&quot;aa&quot;,&quot;b&quot;] 这样两个回文子串。
</pre>


## 解法

### **Java**
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
# [135. 分发糖果](https://leetcode-cn.com/problems/candy)
## 题目描述

<p>老师想给孩子们分发糖果，有 <em>N</em>&nbsp;个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。</p>
<p>你需要按照以下要求，帮助老师给这些孩子分发糖果：</p>
<ul>
	<li>每个孩子至少分配到 1 个糖果。</li>
	<li>相邻的孩子中，评分高的孩子必须获得更多的糖果。</li>
</ul>
<p>那么这样下来，老师至少需要准备多少颗糖果呢？</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [1,0,2]
<strong>输出:</strong> 5
<strong>解释:</strong> 你可以分别给这三个孩子分发 2、1、2 颗糖果。
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [1,2,2]
<strong>输出:</strong> 4
<strong>解释:</strong> 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。</pre>


## 解法

### **Java**
```java
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        else if (ratings.length == 1) return 1;
        int base = 1 ,cur = base ,sum = cur ,smallNum = 0 ,lastBigCur = cur;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                smallNum = 0;
                cur += base;
                lastBigCur = cur;
                sum += cur;
            } else if (ratings[i - 1] == ratings[i]) {
                smallNum = 0;
                cur = base;
                lastBigCur = cur;
                sum += base;
            } else {
                if (cur == base) {
                    smallNum++;
                    sum = sum + cur + smallNum;
                    if (lastBigCur - 1 == smallNum) {
                        lastBigCur += base;
                        sum += base;
                    }
                } else {
                    cur = base;
                    sum += cur;
                }
            }
        }
        return sum;
    }
}
```
# [140. 单词拆分 II](https://leetcode-cn.com/problems/word-break-ii)
## 题目描述

<p>给定一个<strong>非空</strong>字符串 <em>s</em> 和一个包含<strong>非空</strong>单词列表的字典 <em>wordDict</em>，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。</p>
<p><strong>说明：</strong></p>
<ul>
	<li>分隔时可以重复使用字典中的单词。</li>
	<li>你可以假设字典中没有重复的单词。</li>
</ul>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:
</strong>s = &quot;<code>catsanddog</code>&quot;
wordDict = <code>[&quot;cat&quot;, &quot;cats&quot;, &quot;and&quot;, &quot;sand&quot;, &quot;dog&quot;]</code>
<strong>输出:
</strong><code>[
&nbsp; &quot;cats and dog&quot;,
&nbsp; &quot;cat sand dog&quot;
]</code>
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入:
</strong>s = &quot;pineapplepenapple&quot;
wordDict = [&quot;apple&quot;, &quot;pen&quot;, &quot;applepen&quot;, &quot;pine&quot;, &quot;pineapple&quot;]
<strong>输出:
</strong>[
&nbsp; &quot;pine apple pen apple&quot;,
&nbsp; &quot;pineapple pen apple&quot;,
&nbsp; &quot;pine applepen apple&quot;
]
<strong>解释:</strong> 注意你可以重复使用字典中的单词。
</pre>

<p><strong>示例&nbsp;3：</strong></p>
<pre><strong>输入:
</strong>s = &quot;catsandog&quot;
wordDict = [&quot;cats&quot;, &quot;dog&quot;, &quot;sand&quot;, &quot;and&quot;, &quot;cat&quot;]
<strong>输出:
</strong>[]
</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,wordDict,new HashMap<>(16));
    }
    private List<String> wordBreak(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        List<String> list=new ArrayList<>();
        if(map.containsKey(s))  return map.get(s);
        if("".equals(s)){
            list.add("");
            return list;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> res=wordBreak(s.substring(word.length()),wordDict,map);
                for(String str:res){
                    list.add(word+("".equals(str) ?"":" ")+str);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}
```
# [149. 直线上最多的点数](https://leetcode-cn.com/problems/max-points-on-a-line)
## 题目描述

<p>给定一个二维平面，平面上有&nbsp;<em>n&nbsp;</em>个点，求最多有多少个点在同一条直线上。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [[1,1],[2,2],[3,3]]
<strong>输出:</strong> 3
<strong>解释:</strong>
^
|
| &nbsp; &nbsp; &nbsp; &nbsp;o
| &nbsp; &nbsp; o
| &nbsp;o &nbsp;
+-------------&gt;
0 &nbsp;1 &nbsp;2 &nbsp;3  4
</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
<strong>输出:</strong> 4
<strong>解释:</strong>
^
|
|  o
| &nbsp;&nbsp;&nbsp;&nbsp;o&nbsp;&nbsp;      o
| &nbsp;&nbsp;&nbsp;&nbsp;   o
| &nbsp;o &nbsp;      o
+-------------------&gt;
0 &nbsp;1 &nbsp;2 &nbsp;3 &nbsp;4 &nbsp;5 &nbsp;6</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxPoints(Point[] points) {
        if( points.length <= 2 ) return points.length;
        int max = 2 ;
        for( int i = 0 ; i < points.length ; i++ ){
            int samePosition = 0;
            int sameSlope = 1;
            for( int j = i + 1 ; j < points.length ; j++ ){
                long x1 = points[j].x - points[i].x;
                long y1 = points[j].y - points[i].y;
                if( x1 == 0 && y1 == 0 ){
                    samePosition++;
                } else {
                    sameSlope++;
                    for(int k = j + 1 ; k < points.length ; k++ ){
                        long x2 = points[k].x - points[i].x;
                        long y2 = points[k].y - points[i].y;
                        if ( x1 * y2 == x2 * y1 ) sameSlope++;
                    }
                }
                if(max < (samePosition + sameSlope)) max = samePosition + sameSlope;
                sameSlope = 1;
            }
        }
        return max;
    }
}
```
# [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii)
## 题目描述

<p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。</p>
<p>( 例如，数组&nbsp;<code>[0,1,2,4,5,6,7]</code> <strong> </strong>可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code>&nbsp;)。</p>
<p>请找出其中最小的元素。</p>
<p>注意数组中可能存在重复的元素。</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入:</strong> [1,3,5]
<strong>输出:</strong> 1</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入:</strong> [2,2,2,0,1]
<strong>输出:</strong> 0</pre>

<p><strong>说明：</strong></p>
<ul>
	<li>这道题是&nbsp;<a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/">寻找旋转排序数组中的最小值</a>&nbsp;的延伸题目。</li>
	<li>允许重复会影响算法的时间复杂度吗？会如何影响，为什么？</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                --r;
            }
        }
        return nums[l];
    }
}
```
# [164. 最大间距](https://leetcode-cn.com/problems/maximum-gap)
## 题目描述

<p>给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。</p>
<p>如果数组元素个数小于 2，则返回 0。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [3,6,9,1]
<strong>输出:</strong> 3
<strong>解释:</strong> 排序后的数组是 [1,3,6,9]<strong><em>, </em></strong>其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。</pre>

<p><strong>示例&nbsp;2:</strong></p>
<pre><strong>输入:</strong> [10]
<strong>输出:</strong> 0
<strong>解释:</strong> 数组元素个数小于 2，因此返回 0。</pre>

<p><strong>说明:</strong></p>
<ul>
	<li>你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。</li>
	<li>请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if(length <2) return 0;
        Arrays.sort(nums);
        int max=0;
        for(int i = 1; i< length; i++) max = Integer.max(nums[i] - nums[i - 1], max);
        return max;
    }
}
```
# [174. 地下城游戏](https://leetcode-cn.com/problems/dungeon-game)
## 题目描述

<style>
table.dungeon, .dungeon th, .dungeon td {
  border:3px solid black;
}
 .dungeon th, .dungeon td {
    text-align: center;
    height: 70px;
    width: 70px;
}
</style>
<p>一些恶魔抓住了公主（<strong>P</strong>）并将她关在了地下城的右下角。地下城是由&nbsp;M x N 个房间组成的二维网格。我们英勇的骑士（<strong>K</strong>）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。</p>
<p>骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。</p>
<p>有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为<em>负整数</em>，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 <em>0</em>），要么包含增加骑士健康点数的魔法球（若房间里的值为<em>正整数</em>，则表示骑士将增加健康点数）。</p>
<p>为了尽快到达公主，骑士决定每次只向右或向下移动一步。</p>
<p>&nbsp;</p>
<p><strong>编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。</strong></p>
<p>例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 <code>右 -&gt; 右 -&gt; 下 -&gt; 下</code>，则骑士的初始健康点数至少为 <strong>7</strong>。</p>
<table class="dungeon">
<tr>
<td>-2 (K)</td>
<td>-3</td>
<td>3</td>
</tr>
<tr>
<td>-5</td>
<td>-10</td>
<td>1</td>
</tr>
<tr>
<td>10</td>
<td>30</td>
<td>-5 (P)</td>
</tr>
</table>
<!---2K   -3  3
-5   -10   1
10 30   5P-->
<p>&nbsp;</p>
<p><strong>说明:</strong></p>
<ul>
    <li>
    <p>骑士的健康点数没有上限。</p>
    </li>
    <li>任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
         int row = dungeon.length, column = dungeon[0].length;
         int[][] dp = new int[row + 1][column + 1];
         for (int i = 0;i <= row;i++) {
             Arrays.fill(dp[i], Integer.MAX_VALUE);
         }
         dp[row][column - 1] = dp[row - 1][column] = 1;
         for (int i = row - 1;i > -1;i--) {
             for (int j = column - 1;j > -1;j--) {
                 int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                 dp[i][j] = Math.max(min - dungeon[i][j], 1);
             }
         }
         return dp[0][0];
     }
 }
```
# [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv)
## 题目描述

<p>给定一个数组，它的第<em> i</em> 个元素是一支给定的股票在第 <em>i </em>天的价格。</p>
<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 <strong>k</strong> 笔交易。</p>
<p><strong>注意:</strong>&nbsp;你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入:</strong> [2,4,1], k = 2
<strong>输出:</strong> 2
<strong>解释:</strong> 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [3,2,6,5,0,3], k = 2
<strong>输出:</strong> 7
<strong>解释:</strong> 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
&nbsp;    随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
        
        if(k >= prices.length) return maxProfit(prices);
        
		int n = prices.length;
		int[] l = new int[k + 1];
		int[] g = new int[k + 1];
		for (int i = 1; i < n; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j >= 1; j--) {
				l[j] = Math.max(l[j], g[j - 1]) + diff;
				g[j] = Math.max(l[j], g[j]);
			}
		}
		return g[k];
    }
    
    public int maxProfit(int[] prices) {
        // 只要有利润就卖，就是最优解。
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
```
# [212. 单词搜索 II](https://leetcode-cn.com/problems/word-search-ii)
## 题目描述

<p>给定一个二维网格&nbsp;<strong>board&nbsp;</strong>和一个字典中的单词列表 <strong>words</strong>，找出所有同时在二维网格和字典中出现的单词。</p>
<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中&ldquo;相邻&rdquo;单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 
<strong>words</strong> = <code>[&quot;oath&quot;,&quot;pea&quot;,&quot;eat&quot;,&quot;rain&quot;]</code> and <strong>board </strong>=
[
  [&#39;<strong>o</strong>&#39;,&#39;<strong>a</strong>&#39;,&#39;a&#39;,&#39;n&#39;],
  [&#39;e&#39;,&#39;<strong>t</strong>&#39;,&#39;<strong>a</strong>&#39;,&#39;<strong>e</strong>&#39;],
  [&#39;i&#39;,&#39;<strong>h</strong>&#39;,&#39;k&#39;,&#39;r&#39;],
  [&#39;i&#39;,&#39;f&#39;,&#39;l&#39;,&#39;v&#39;]
]
<strong>输出:&nbsp;</strong><code>[&quot;eat&quot;,&quot;oath&quot;]</code></pre>

<p><strong>说明:</strong><br>
你可以假设所有输入都由小写字母 <code>a-z</code>&nbsp;组成。</p>
<p><strong>提示:</strong></p>
<ul>
	<li>你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？</li>
	<li>如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： <a href="/problems/implement-trie-prefix-tree/description/">实现Trie（前缀树）</a>。</li>
</ul>

## 解法

### **Java**
```java
```
# [214. 最短回文串](https://leetcode-cn.com/problems/shortest-palindrome)
## 题目描述

<p>给定一个字符串 <em><strong>s</strong></em>，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。</p>
<p><strong>示例&nbsp;1:</strong></p>
<pre><strong>输入: </strong><code>&quot;aacecaaa&quot;</code>
<strong>输出:</strong> <code>&quot;aaacecaaa&quot;</code>
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入: </strong><code>&quot;abcd&quot;</code>
<strong>输出:</strong> <code>&quot;dcbabcd&quot;</code></pre>


## 解法

### **Java**
```java
```
# [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator)
## 题目描述

<p>实现一个基本的计算器来计算一个简单的字符串表达式的值。</p>
<p>字符串表达式可以包含左括号&nbsp;<code>(</code>&nbsp;，右括号&nbsp;<code>)</code>，加号&nbsp;<code>+</code>&nbsp;，减号&nbsp;<code>-</code>，<strong>非负</strong>整数和空格&nbsp;<code>&nbsp;</code>。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;1 + 1&quot;
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> &quot; 2-1 + 2 &quot;
<strong>输出:</strong> 3</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> &quot;(1+(4+5+2)-3)+(6+8)&quot;
<strong>输出:</strong> 23</pre>

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
            if (cs[i] == '(' || cs[i] == '+' || cs[i] == '-') {
                op.push(cs[i]);
            } else if (cs[i] == ')') {
                op.pop();
                if (!op.isEmpty() && op.peek() != '(') {
                    calc(op, num);
                }
            } else if (Character.isDigit(cs[i])) {
                int j = i;
                int k = 0;
                while (j < cs.length && Character.isDigit(cs[j])) {
                    k = k * 10 + cs[j] - '0';
                    ++j;
                }
                num.push(k);
                i = j - 1;
                if (!op.isEmpty() && op.peek() != '(') {
                    calc(op, num);
                }
            }
        }
        return num.peek();
    }
    private void calc(Deque<Character> op, Deque<Integer> num) {
        int y = num.pop();
        int x = num.pop();
        if (op.pop() == '+') {
            num.push(x + y);
        } else {
            num.push(x - y);
        }
    }
}
```
# [233. 数字 1 的个数](https://leetcode-cn.com/problems/number-of-digit-one)
## 题目描述

<p>给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> 13
<strong>输出:</strong> 6 
<strong>解释: </strong>数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。</pre>


## 解法

### **Java**
```java
class Solution {
    public int countDigitOne(int n) {
        int index = 1;
        int count = 0;
        int high = n,cur = 0,low = 0;
        while(high > 0){
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            if(cur == 0) count += high * index;
            if(cur == 1) count += high * index + low + 1;
            if(cur > 1) count += (high+1) * index;
            index *= 10;
        }
        return count;
    }
}
```
# [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum)
## 题目描述

<p>给定一个数组 <em>nums</em>，有一个大小为&nbsp;<em>k&nbsp;</em>的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 <em>k</em>&nbsp;个数字。滑动窗口每次只向右移动一位。</p>
<p>返回滑动窗口中的最大值。</p>
<p>&nbsp;</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <em>nums</em> = <code>[1,3,-1,-3,5,3,6,7]</code>, 和 <em>k</em> = 3
<strong>输出: </strong><code>[3,3,5,5,6,7] 
<strong>解释: 
</strong></code>
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<p>你可以假设 <em>k </em>总是有效的，在输入数组不为空的情况下，1 &le; k &le;&nbsp;输入数组的大小。</p>
<p>&nbsp;</p>
<p><strong>进阶：</strong></p>
<p>你能在线性时间复杂度内解决此题吗？</p>

## 解法

### **Java**
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; ++i) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i - q.peekFirst() >= k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
```
# [273. 整数转换英文表示](https://leetcode-cn.com/problems/integer-to-english-words)
## 题目描述

<p>将非负整数转换为其对应的英文表示。可以保证给定输入小于&nbsp;2<sup>31</sup> - 1 。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> 123
<strong>输出:</strong> &quot;One Hundred Twenty Three&quot;
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> 12345
<strong>输出:</strong> &quot;Twelve Thousand Three Hundred Forty Five&quot;</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> 1234567
<strong>输出:</strong> &quot;One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven&quot;</pre>

<p><strong>示例 4:</strong></p>
<pre><strong>输入:</strong> 1234567891
<strong>输出:</strong> &quot;One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One&quot;</pre>


## 解法

### **Java**
```java
class Solution {
    private static Map<Integer, String> map;
    static {
        map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
    }
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1000000000; i >= 1000; i /= 1000) {
            if (num >= i) {
                sb.append(get3Digits(num / i)).append(' ').append(map.get(i));
                num %= i;
            }
        }
        if (num > 0) {
            sb.append(get3Digits(num));
        }
        return sb.substring(1);
    }
    private String get3Digits(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(' ').append(map.get(num / 100)).append(' ').append(map.get(100));
            num %= 100;
        }
        if (num > 0) {
            if (num < 20 || num % 10 == 0) {
                sb.append(' ').append(map.get(num));
            } else {
                sb.append(' ').append(map.get(num / 10 * 10)).append(' ').append(map.get(num % 10));
            }
        }
        return sb.toString();
    }
}
```
# [295. 数据流的中位数](https://leetcode-cn.com/problems/find-median-from-data-stream)
## 题目描述

<p>中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。</p>
<p>例如，</p>
<p>[2,3,4]&nbsp;的中位数是 3</p>
<p>[2,3] 的中位数是 (2 + 3) / 2 = 2.5</p>
<p>设计一个支持以下两种操作的数据结构：</p>
<ul>
	<li>void addNum(int num) - 从数据流中添加一个整数到数据结构中。</li>
	<li>double findMedian() - 返回目前所有元素的中位数。</li>
</ul>
<p><strong>示例：</strong></p>
<pre>addNum(1)
addNum(2)
findMedian() -&gt; 1.5
addNum(3) 
findMedian() -&gt; 2</pre>

<p><strong>进阶:</strong></p>
<ol>
	<li>如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？</li>
	<li>如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？</li>
</ol>

## 解法

### **Java**
```java
class MedianFinder {
    private PriorityQueue<Integer> bigRoot;
    private PriorityQueue<Integer> smallRoot;
    /** initialize your data structure here. */
    public MedianFinder() {
        bigRoot = new PriorityQueue<>(Comparator.reverseOrder());
        smallRoot = new PriorityQueue<>(Integer::compareTo);
    }
    public void addNum(int num) {
        if (bigRoot.isEmpty() || bigRoot.peek() > num) {
            bigRoot.offer(num);
        } else {
            smallRoot.offer(num);
        }
        int size1 = bigRoot.size();
        int size2 = smallRoot.size();
        if (size1 - size2 > 1) {
            smallRoot.offer(bigRoot.poll());
        } else if (size2 - size1 > 1) {
            bigRoot.offer(smallRoot.poll());
        }
    }
    public double findMedian() {
        int size1 = bigRoot.size();
        int size2 = smallRoot.size();
        return size1 == size2 ? (bigRoot.peek() + smallRoot.peek()) * 1.0 / 2
                : (size1 > size2 ? bigRoot.peek() : smallRoot.peek());
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); 
 * obj.addNum(num); 
 * double param_2 = obj.findMedian();
 */
```
# [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree)
## 题目描述

<p>序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。</p>
<p>请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>
<p><strong>示例:&nbsp;</strong></p>
<pre>你可以将以下二叉树：
    1
   / \
  2   3
     / \
    4   5
序列化为 <code>&quot;[1,2,3,null,null,4,5]&quot;</code></pre>

<p><strong>提示:&nbsp;</strong>这与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="/faq/#binary-tree">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>
<p><strong>说明:&nbsp;</strong>不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。</p>

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
        public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode p = deque.pop();
            if (p == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(p.val);
                deque.add(p.left);
                deque.add(p.right);
            }
        }
        return sb.toString().substring(1);
    }
    public TreeNode deserialize(String data) {
        if (data == null || Objects.equals(data, "")) {
            return null;
        }
        String[] s = data.split(",");
        TreeNode[] root = new TreeNode[s.length];
        for (int i = 0; i < root.length; i++) {
            if (!Objects.equals(s[i], "#")) {
                root[i] = new TreeNode(Integer.valueOf(s[i]));
            }
        }
        int parent = 0;
        for (int i = 0; parent * 2 + 2 < s.length; i++) {
            if (root[i] != null) {
                root[i].left = root[parent * 2 + 1];
                root[i].right = root[parent * 2 + 2];
                parent++;
            }
        }
        return root[0];
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
# [301. 删除无效的括号](https://leetcode-cn.com/problems/remove-invalid-parentheses)
## 题目描述

<p>删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。</p>
<p><strong>说明:</strong> 输入可能包含了除&nbsp;<code>(</code>&nbsp;和&nbsp;<code>)</code>&nbsp;以外的字符。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> &quot;()())()&quot;
<strong>输出:</strong> [&quot;()()()&quot;, &quot;(())()&quot;]
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> &quot;(a)())()&quot;
<strong>输出:</strong> [&quot;(a)()()&quot;, &quot;(a())()&quot;]
</pre>

<p><strong>示例 3:</strong></p>
<pre><strong>输入:</strong> &quot;)(&quot;
<strong>输出: </strong>[&quot;&quot;]</pre>


## 解法

### **Java**
```java
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // 最终结果去重
        HashSet<String> set = new HashSet<>();
        // 先遍历一遍，比对，找出需要删除的"（"和"）"的个数
        // 当前处理字符的位置
        int index = 0;
        // 需要删除"（"的个数
        int leftToDelete = 0;
        // 需要删除"）"的个数
        int rightToDelete = 0;
        // 剩余几个"（"没有匹配到"）"
        int leftCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                    leftToDelete++;
                    break;
                case ')':
                    if (leftToDelete > 0) {
                        // 抵消
                        leftToDelete--;
                    } else {
                        rightToDelete++;
                    }
                    break;
                default:
            }
        }
        dfs(s, index, leftCount, leftToDelete, rightToDelete, set, new StringBuilder());
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }
    private void dfs(String s, int index, int leftCount, int leftToDelete, int rightToDelete, HashSet<String> set, StringBuilder sb) {
        if (index == s.length()) {
            if (leftToDelete == 0 && rightToDelete == 0 && leftCount == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            // 如果是'(',那么要么删除,要么保留.
            // 如果删除
            if (leftToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete - 1, rightToDelete, set, tmp);
            }
            // 不删,或者没有可以删除的
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount + 1, leftToDelete, rightToDelete, set, tmp);
        } else if (c == ')') {
            // 删除
            if (rightToDelete > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                dfs(s, index + 1, leftCount, leftToDelete, rightToDelete - 1, set, tmp);
            }
            // 在前面有'('的时候保留.
            if (leftCount > 0) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(c);
                dfs(s, index + 1, leftCount - 1, leftToDelete, rightToDelete, set, tmp);
            } else {
                // "）"这个没有"（"和他对应，结束
                return;
            }
        } else {
            // 其他字符
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(c);
            dfs(s, index + 1, leftCount, leftToDelete, rightToDelete, set, tmp);
        }
    }
}
```
# [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons)
## 题目描述

<p>有 <code>n</code> 个气球，编号为<code>0</code> 到 <code>n-1</code>，每个气球上都标有一个数字，这些数字存在数组&nbsp;<code>nums</code>&nbsp;中。</p>
<p>现在要求你戳破所有的气球。每当你戳破一个气球 <code>i</code> 时，你可以获得&nbsp;<code>nums[left] * nums[i] * nums[right]</code>&nbsp;个硬币。&nbsp;这里的&nbsp;<code>left</code>&nbsp;和&nbsp;<code>right</code>&nbsp;代表和&nbsp;<code>i</code>&nbsp;相邻的两个气球的序号。注意当你戳破了气球 <code>i</code> 后，气球&nbsp;<code>left</code>&nbsp;和气球&nbsp;<code>right</code>&nbsp;就变成了相邻的气球。</p>
<p>求所能获得硬币的最大数量。</p>
<p><strong>说明:</strong></p>
<ul>
	<li>你可以假设&nbsp;<code>nums[-1] = nums[n] = 1</code>，但注意它们不是真实存在的所以并不能被戳破。</li>
	<li>0 &le; <code>n</code> &le; 500, 0 &le; <code>nums[i]</code> &le; 100</li>
</ul>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> <code>[3,1,5,8]</code>
<strong>输出:</strong> <code>167 
<strong>解释: </strong></code>nums = [3,1,5,8] --&gt; [3,5,8] --&gt;   [3,8]   --&gt;  [8]  --&gt; []
&nbsp;    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
</pre>


## 解法

### **Java**
```java
class Solution {
    
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] f = new int[n + 2][n + 2];
        for (int i= 0; i < n + 2; ++i) {
            for (int j = 0; j < n + 2; ++j) {
                f[i][j] = -1;
            }
        }
        int[] bak = new int[n + 2];
        bak[0] = bak[n + 1] = 1;
        for (int i = 1; i < n + 1; ++i) {
            bak[i] = nums[i - 1];
        }
        return dp(bak, f, 0, n + 1);
    }
    
    private int dp(int[] nums, int[][] f, int x, int y) {
        if (f[x][y] != -1) {
            return f[x][y];
        }
        
        f[x][y] = 0;
        
        //枚举最后一个戳破的气球的位置
        for (int i = x + 1; i < y; ++i) {
            f[x][y] = Math.max(f[x][y], nums[i] * nums[x] * nums[y] + dp(nums,f,  x, i) + dp(nums, f, i, y));
        }
        return f[x][y];
        
    }
    
    
}
```
# [329. 矩阵中的最长递增路径](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix)
## 题目描述

<p>给定一个整数矩阵，找出最长递增路径的长度。</p>
<p>对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入: </strong>nums = 
[
  [<strong>9</strong>,9,4],
  [<strong>6</strong>,6,8],
  [<strong>2</strong>,<strong>1</strong>,1]
] 
<strong>输出:</strong> 4 
<strong>解释:</strong> 最长递增路径为&nbsp;<code>[1, 2, 6, 9]</code>。</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> nums = 
[
  [<strong>3</strong>,<strong>4</strong>,<strong>5</strong>],
  [3,2,<strong>6</strong>],
  [2,2,1]
] 
<strong>输出: </strong>4 
<strong>解释: </strong>最长递增路径是&nbsp;<code>[3, 4, 5, 6]</code>。注意不允许在对角线方向上移动。
</pre>


## 解法

### **Java**
```java
import java.util.*;

public class Solution {
    
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int robot(int x, int y, int[][] m, int[][] cache) {
        if(cache[x][y] != 0) return cache[x][y];
        int max = 1;
        for(int[] dir : dirs) {
            int dx = dir[0], dy = dir[1];
            if(x + dx < 0 || x + dx >= m.length || y + dy < 0 || y + dy >= m[0].length || m[x][y] <= m[x + dx][y + dy]) {
                continue;
            }
            max = Math.max(max, robot(x + dx, y + dy, m, cache) + 1);
        }
        cache[x][y] = max;
        return max;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 1;
        // 枚举每一个点，计算每个点的最大升序
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, robot(i, j, matrix, cache));
            }
        }
        return ans;
    }
}
```
# [354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes)
## 题目描述

<p>给定一些标记了宽度和高度的信封，宽度和高度以整数对形式&nbsp;<code>(w, h)</code>&nbsp;出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>
<p>请计算最多能有多少个信封能组成一组&ldquo;俄罗斯套娃&rdquo;信封（即可以把一个信封放到另一个信封里面）。</p>
<p><strong>说明:</strong><br>
不允许旋转信封。</p>
<p><strong>示例:</strong></p>
<pre><strong>输入:</strong> envelopes = <code>[[5,4],[6,4],[6,7],[2,3]]</code>
<strong>输出:</strong> 3 
<strong>解释:</strong> 最多信封的个数为 <code>3, 组合为: </code>[2,3] =&gt; [5,4] =&gt; [6,7]。
</pre>


## 解法
排序 + [最长递增子序列](/solution/0300-0399/0300.Longest%20Increasing%20Subsequence/README.md)。
按 w 进行升序排序，若 w 相同则按 h 降序排序。然后问题转换为求 h 数组的最长递增子序列长度。

### **Java**
```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n;
        if (envelopes == null || (n = envelopes.length) == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```
# [381. O(1) 时间插入、删除和获取随机元素 - 允许重复](https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed)
## 题目描述

<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度&nbsp;<strong>O(1)&nbsp;</strong>下<strong>，&nbsp;</strong>执行以下操作的数据结构。</p>
<p><strong>注意: 允许出现重复元素。</strong></p>
<ol>
	<li><code>insert(val)</code>：向集合中插入元素 val。</li>
	<li><code>remove(val)</code>：当 val 存在时，从集合中移除一个 val。</li>
	<li><code>getRandom</code>：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。</li>
</ol>
<p><strong>示例:</strong></p>
<pre>// 初始化一个空的集合。
RandomizedCollection collection = new RandomizedCollection();
// 向集合中插入 1 。返回 true 表示集合不包含 1 。
collection.insert(1);
// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
collection.insert(1);
// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
collection.insert(2);
// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
collection.getRandom();
// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
collection.remove(1);
// getRandom 应有相同概率返回 1 和 2 。
collection.getRandom();
</pre>


## 解法

### **Java**
```java
class RandomizedCollection {
	private List<Integer> list;
	private Map<Integer, Set<Integer>> map;
	private Random random;
	/** Initialize your data structure here. */
	public RandomizedCollection() {
		list = new ArrayList<>();
		map = new HashMap<>();
		random = new Random();
	}
	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		boolean flag = false;
		if (!map.containsKey(val)) {
			flag = true;
			map.put(val, new HashSet<Integer>());
		}
		map.get(val).add(list.size());
		list.add(val);
		return flag;
	}
	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int removed = map.get(val).iterator().next();
		map.get(val).remove(removed);
		if (removed < list.size() - 1) {
			Integer tail = list.get(list.size() - 1);
			list.set(removed, tail);
			map.get(tail).remove(list.size() - 1);
			map.get(tail).add(removed);
		}
		list.remove(list.size() - 1);
		if (map.get(val).size() == 0) {
			map.remove(val);
		}
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
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

# [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum)
## 题目描述

<p>给定一个非负整数数组和一个整数&nbsp;<em>m</em>，你需要将这个数组分成&nbsp;<em>m&nbsp;</em>个非空的连续子数组。设计一个算法使得这&nbsp;<em>m&nbsp;</em>个子数组各自和的最大值最小。</p>
<p><strong>注意:</strong><br />
数组长度&nbsp;<em>n&nbsp;</em>满足以下条件:</p>
<ul>
	<li>1 &le; <em>n</em> &le; 1000</li>
	<li>1 &le; <em>m</em> &le; min(50, <em>n</em>)</li>
</ul>
<p><strong>示例: </strong></p>
<pre>
输入:
<strong>nums</strong> = [7,2,5,10,8]
<strong>m</strong> = 2
输出:
18
解释:
一共有四种方法将<strong>nums</strong>分割为2个子数组。
其中最好的方式是将其分为<strong>[7,2,5]</strong> 和 <strong>[10,8]</strong>，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
</pre>


## 解法

### **Java**
```java
class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int x : nums) {
            l = Math.max(l, x);
            r += x;
        }
        while (l < r) {
            long mid = l + r >>> 1;
            if (check(nums, m, mid)) r = mid;
            else l = mid + 1;
        }
        return (int) r;
    }
    private boolean check(int[] nums, int m, long cap) {
        int cnt = 1;
        long tot = 0;
        for (int x : nums) {
            tot += x;
            if (tot > cap) {
                ++cnt;
                tot = x;
            }
        }
        return cnt <= m;
    }
}
```
# [458. 可怜的小猪](https://leetcode-cn.com/problems/poor-pigs)
## 题目描述

<p>有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。</p>
<p>问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？</p>
<p>回答这个问题，并为下列的进阶问题编写一个通用算法。</p>
<p>&nbsp;</p>
<p><strong>进阶: </strong></p>
<p>假设有 <code>n</code> 只水桶，猪饮水中毒后会在 <code>m</code> 分钟内死亡，你需要多少猪（<code>x</code>）就能在 <code>p</code> 分钟内找出 &ldquo;<strong>有毒</strong>&rdquo; 水桶？这&nbsp;<code>n</code> 只水桶里有且仅有一只有毒的桶。</p>
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。</li>
	<li>小猪喝完水后，必须有 <em>m</em> 分钟的<strong>冷却时间</strong>。在这段时间里，只允许观察，而不允许继续饮水。</li>
	<li>任何给定的桶都可以无限次采样（无限数量的猪）。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int res = 0;
        int p = 1;
        while (p < buckets) {
            p *= base;
            ++res;
        }
        return res;
    }
}
```
# [502. IPO](https://leetcode-cn.com/problems/ipo)
## 题目描述

<p>假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 <strong>k</strong> 个不同的项目。帮助 力扣 设计完成最多 <strong>k</strong> 个不同项目后得到最大总资本的方式。</p>
<p>给定若干个项目。对于每个项目 <strong>i</strong>，它都有一个纯利润 <strong>P<sub>i</sub></strong>，并且需要最小的资本 <strong>C<sub>i</sub></strong> 来启动相应的项目。最初，你有 <strong>W</strong> 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。</p>
<p>总而言之，从给定项目中选择最多 <strong>k</strong> 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
<strong>输出:</strong> 4
<strong>解释:
</strong>由于你的初始资本为 0，你尽可以从 0 号项目开始。
在完成后，你将获得 1 的利润，你的总资本将变为 1。
此时你可以选择开始 1 号或 2 号项目。
由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
</pre>

<p>&nbsp;</p>
<p><strong>注意:</strong></p>
<ol>
	<li>假设所有输入数字都是非负整数。</li>
	<li>表示利润和资本的数组的长度不超过 50000。</li>
	<li>答案保证在 32 位有符号整数范围内。</li>
</ol>
<p>&nbsp;</p>

## 解法

### **Java**
```java
class Solution {
    /**
     * 贪心算法
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // 首先检查是否存在所有项目都可投资且初始资本 W >= max(Capital) 的情况。如果是，返回利润中前 k 个最大元素的和。
        boolean speedUp = true;
        for (int c : Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h : heap) W += h;
            return W;
        }
        int idx;
        int n = Profits.length;
        for (int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // 找到获取利润最多的项目
            for (int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // 找不到合适的项目
            if (idx == -1) break;
            // 累计当前项目的利润到总利润中，并把当前项目标记为"不可用"（设置成最大整数）
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return W;
    }
} 
```
# [664. 奇怪的打印机](https://leetcode-cn.com/problems/strange-printer)
## 题目描述

<p>有台奇怪的打印机有以下两个特殊要求：</p>
<ol>
	<li>打印机每次只能打印同一个字符序列。</li>
	<li>每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。</li>
</ol>
<p>给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。</p>
<p><strong>示例 1:</strong></p>
<pre>
<strong>输入:</strong> &quot;aaabbb&quot;
<strong>输出:</strong> 2
<strong>解释:</strong> 首先打印 &quot;aaa&quot; 然后打印 &quot;bbb&quot;。
</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入:</strong> &quot;aba&quot;
<strong>输出:</strong> 2
<strong>解释:</strong> 首先打印 &quot;aaa&quot; 然后在第二个位置打印 &quot;b&quot; 覆盖掉原来的字符 &#39;a&#39;。</pre>

<p><strong>提示</strong>: 输入字符串的长度不会超过 100。</p>

## 解法

### **Java**
```java
class Solution {
    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = 1 + f[i + 1][j];
                for (int k = i + 1; k <= j; ++k) {
                    if (s.charAt(i) == s.charAt(k)) {
                        f[i][j] = Math.min(f[i][j], f[i + 1][k] + f[k + 1][j]);
                    }
                }
            }
        }
        return f[0][n - 1];
    }
}
```
# [679. 24 点游戏](https://leetcode-cn.com/problems/24-game)
## 题目描述

<p>你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过&nbsp;<code>*</code>，<code>/</code>，<code>+</code>，<code>-</code>，<code>(</code>，<code>)</code>&nbsp;的运算得到 24。</p>
<p><strong>示例 1:</strong></p>
<pre><strong>输入:</strong> [4, 1, 8, 7]
<strong>输出:</strong> True
<strong>解释:</strong> (8-4) * (7-1) = 24
</pre>

<p><strong>示例 2:</strong></p>
<pre><strong>输入:</strong> [1, 2, 1, 2]
<strong>输出:</strong> False
</pre>

<p><strong>注意:</strong></p>
<ol>
	<li>除法运算符&nbsp;<code>/</code>&nbsp;表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。</li>
	<li>每个运算符对两个数进行运算。特别是我们不能用&nbsp;<code>-</code>&nbsp;作为一元运算符。例如，<code>[1, 1, 1, 1]</code>&nbsp;作为输入时，表达式&nbsp;<code>-1 - 1 - 1 - 1</code>&nbsp;是不允许的。</li>
	<li>你不能将数字连接在一起。例如，输入为&nbsp;<code>[1, 2, 1, 2]</code>&nbsp;时，不能写成 12 + 12 。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public boolean judgePoint24(int[] nums) {
        return dfs(Arrays.stream(nums).boxed().map(Double::new).collect(Collectors.toList()));
    }
    private boolean dfs(List<Double> numList) {
        if (numList.size() == 0) {
            return false;
        }
        if (numList.size() == 1) {
            return Math.abs(Math.abs(numList.get(0) - 24.0)) < 0.000001d;
        }
        for (int i = 0; i < numList.size(); i++) {
            for (int j = i + 1; j < numList.size(); j++) {
                boolean valid = dfs(getList(numList, i, j, 0)) || dfs(getList(numList, i, j, 1))
                        || dfs(getList(numList, i, j, 2)) || dfs(getList(numList, i, j, 3))
                        || dfs(getList(numList, i, j, 4)) || dfs(getList(numList, i, j, 5));
                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }
    private List<Double> getList(List<Double> numList, int i, int j, int operate) {
        List<Double> candidate = new ArrayList<>();
        for (int k = 0; k < numList.size(); k++) {
            if (k == i || k == j) {
                continue;
            }
            candidate.add(numList.get(k));
        }
        switch (operate) {
            // a + b
            case 0:
                candidate.add(numList.get(i) + numList.get(j));
                break;
            // a - b
            case 1:
                candidate.add(numList.get(i) - numList.get(j));
                break;
            // b - a
            case 2:
                candidate.add(numList.get(j) - numList.get(i));
                break;
            // a * b
            case 3:
                candidate.add(numList.get(i) * numList.get(j));
                break;
            // a / b
            case 4:
                if (numList.get(j) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(i) / numList.get(j));
                break;
            // b / a
            case 5:
                if (numList.get(i) == 0) {
                    return Collections.emptyList();
                }
                candidate.add(numList.get(j) / numList.get(i));
                break;
        }
        return candidate;
    }
}
```
# [829. 连续整数求和](https://leetcode-cn.com/problems/consecutive-numbers-sum)
## 题目描述

<p>给定一个正整数 <code>N</code>，试求有多少组连续正整数满足所有数字之和为 <code>N</code>?</p>
<p><strong>示</strong><strong>例 1:</strong></p>
<pre>
<strong>输入: </strong>5
<strong>输出: </strong>2
<strong>解释: </strong>5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。</pre>

<p><strong>示例 2:</strong></p>
<pre>
<strong>输入: </strong>9
<strong>输出: </strong>3
<strong>解释: </strong>9 = 9 = 4 + 5 = 2 + 3 + 4</pre>

<p><strong>示例 3:</strong></p>
<pre>
<strong>输入: </strong>15
<strong>输出: </strong>4
<strong>解释: </strong>15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5</pre>

<p><strong>说明:&nbsp;</strong><code>1 &lt;= N &lt;= 10 ^ 9</code></p>

## 解法

### **Java**
```java
class Solution {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; i * (i - 1) / 2 < N; ++i) {
            if ((N - i * (i - 1) / 2) % i == 0) {
                ++res;
            }
        }
        return res;
    }
}
```
# [857. 雇佣 K 名工人的最低成本](https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers)
## 题目描述

<p>有 <code>N</code>&nbsp;名工人。&nbsp;第&nbsp;<code>i</code>&nbsp;名工人的工作质量为&nbsp;<code>quality[i]</code>&nbsp;，其最低期望工资为&nbsp;<code>wage[i]</code>&nbsp;。</p>
<p>现在我们想雇佣&nbsp;<code>K</code>&nbsp;名工人组成一个<em>工资组。</em>在雇佣&nbsp;一组 K 名工人时，我们必须按照下述规则向他们支付工资：</p>
<ol>
	<li>对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。</li>
	<li>工资组中的每名工人至少应当得到他们的最低期望工资。</li>
</ol>
<p>返回组成一个满足上述条件的工资组至少需要多少钱。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入： </strong>quality = [10,20,5], wage = [70,50,30], K = 2
<strong>输出： </strong>105.00000
<strong>解释：</strong> 我们向 0 号工人支付 70，向 2 号工人支付 35。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入： </strong>quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
<strong>输出： </strong>30.66667
<strong>解释： </strong>我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= K &lt;= N &lt;= 10000</code>，其中&nbsp;<code>N = quality.length = wage.length</code></li>
	<li><code>1 &lt;= quality[i] &lt;= 10000</code></li>
	<li><code>1 &lt;= wage[i] &lt;= 10000</code></li>
	<li>与正确答案误差在&nbsp;<code>10^-5</code>&nbsp;之内的答案将被视为正确的。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; ++i) {
            workers[i] = new Worker((double) wage[i] / quality[i], quality[i]);
        }
        Arrays.sort(workers);
        double res = 1e9;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int s = 0;
        for (Worker worker : workers) {
            s += worker.quality;
            queue.offer(worker.quality);
            if (queue.size() > K) {
                s -= queue.poll();
            }
            if (queue.size() == K) {
                res = Math.min(res, s * worker.x);
            }
        }
        return res;
    }
    class Worker implements Comparable<Worker> {
        double x;
        int quality;
        public Worker(double x, int quality) {
            this.x = x;
            this.quality = quality;
        }
        @Override
        public int compareTo(Worker o) {
            return Double.compare(x, o.x);
        }
    }
}
```
# [862. 和至少为 K 的最短子数组](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k)
## 题目描述

<p>返回 <code>A</code> 的最短的非空连续子数组的<strong>长度</strong>，该子数组的和至少为 <code>K</code> 。</p>
<p>如果没有和至少为&nbsp;<code>K</code>&nbsp;的非空子数组，返回&nbsp;<code>-1</code>&nbsp;。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>A = [1], K = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>A = [1,2], K = 4
<strong>输出：</strong>-1
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>A = [2,-1,2], K = 3
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 50000</code></li>
	<li><code>-10 ^ 5&nbsp;&lt;= A[i] &lt;= 10 ^ 5</code></li>
	<li><code>1 &lt;= K &lt;= 10 ^ 9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + A[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i) {
            while (!deque.isEmpty() && s[i] - s[deque.peekFirst()] >= K) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && s[i] <= s[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}
```
# [878. 第 N 个神奇数字](https://leetcode-cn.com/problems/nth-magical-number)
## 题目描述

<p>如果正整数可以被 A 或 B 整除，那么它是神奇的。</p>
<p>返回第 N 个神奇数字。由于答案可能非常大，<strong>返回它模&nbsp;</strong><code>10^9 + 7</code>&nbsp;<strong>的结果</strong>。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>N = 1, A = 2, B = 3
<strong>输出：</strong>2
</pre>

<p><strong>示例&nbsp;2：</strong></p>
<pre><strong>输入：</strong>N = 4, A = 2, B = 3
<strong>输出：</strong>6
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>N = 5, A = 2, B = 4
<strong>输出：</strong>10
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>N = 3, A = 6, B = 4
<strong>输出：</strong>8
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= N&nbsp;&lt;= 10^9</code></li>
	<li><code>2 &lt;= A&nbsp;&lt;= 40000</code></li>
	<li><code>2 &lt;= B&nbsp;&lt;= 40000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        long l = 1, r = Long.MAX_VALUE;
        int lcm = A * B / gcd(A, B);
        while (l < r) {
            long mid = l + r >>> 1;
            if (mid / A + mid / B - mid / lcm >= N) r = mid;
            else l = mid + 1;
        }
        return (int) (r % 1000000007);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
# [887. 鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop)
## 题目描述

<p>你将获得&nbsp;<code>K</code>&nbsp;个鸡蛋，并可以使用一栋从&nbsp;<code>1</code>&nbsp;到&nbsp;<code>N</code>&nbsp;&nbsp;共有 <code>N</code>&nbsp;层楼的建筑。</p>
<p>每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。</p>
<p>你知道存在楼层&nbsp;<code>F</code> ，满足&nbsp;<code>0 &lt;= F &lt;= N</code> 任何从高于 <code>F</code>&nbsp;的楼层落下的鸡蛋都会碎，从&nbsp;<code>F</code>&nbsp;楼层或比它低的楼层落下的鸡蛋都不会破。</p>
<p>每次<em>移动</em>，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层&nbsp;<code>X</code>&nbsp;扔下（满足&nbsp;<code>1 &lt;= X &lt;= N</code>）。</p>
<p>你的目标是<strong>确切地</strong>知道 <code>F</code> 的值是多少。</p>
<p>无论 <code>F</code> 的初始值如何，你确定 <code>F</code> 的值的最小移动次数是多少？</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>K = 1, N = 2
<strong>输出：</strong>2
<strong>解释：</strong>
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>K = 2, N = 6
<strong>输出：</strong>3
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>K = 3, N = 14
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= K &lt;= 100</code></li>
	<li><code>1 &lt;= N &lt;= 10000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int superEggDrop(int K, int N) {
        int[] res = new int[K];
        Arrays.fill(res, 1);
        while (res[K - 1] < N) {
            for (int i = K - 1; i >= 1; i--) {
                res[i] = res[i] + res[i - 1] + 1;
            }
            res[0]++;
        }
        return res[0];
    }
}
```
# [891. 子序列宽度之和](https://leetcode-cn.com/problems/sum-of-subsequence-widths)
## 题目描述

<p>给定一个整数数组 <code>A</code> ，考虑 <code>A</code> 的所有非空子序列。</p>
<p>对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。</p>
<p>返回 A 的所有子序列的宽度之和。</p>
<p>由于答案可能非常大，请<strong>返回答案模 10^9+7</strong>。</p>
<p>&nbsp;</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>[2,1,3]
<strong>输出：</strong>6
<strong>解释：
</strong>子序列为 [1]，[2]，[3]，[2,1]，[2,3]，[1,3]，[2,1,3] 。
相应的宽度是 0，0，0，1，1，2，2 。
这些宽度之和是 6 。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
	<li><code>1 &lt;= A[i] &lt;= 20000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int sumSubseqWidths(int[] A) {
        final int MOD = (int) (1e9 + 7);
        Arrays.sort(A);
        int n = A.length;
        long res = 0;
        long p = 1;
        for (int i = 0; i < n; ++i) {
            res = (res + (A[i] - A[n - 1 - i]) * p) % MOD;
            p = (p << 1) % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}
```
# [952. 按公因数计算最大组件大小](https://leetcode-cn.com/problems/largest-component-size-by-common-factor)
## 题目描述

<p>给定一个由不同正整数的组成的非空数组 <code>A</code>，考虑下面的图：</p>
<ul>
	<li>有&nbsp;<code>A.length</code>&nbsp;个节点，按从&nbsp;<code>A[0]</code>&nbsp;到&nbsp;<code>A[A.length - 1]</code>&nbsp;标记；</li>
	<li>只有当 <code>A[i]</code> 和 <code>A[j]</code> 共用一个大于 1 的公因数时，<code>A[i]</code>&nbsp;和 <code>A[j]</code> 之间才有一条边。</li>
</ul>
<p>返回图中最大连通组件的大小。</p>
<p>&nbsp;</p>
<ol>
</ol>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>[4,6,15,35]
<strong>输出：</strong>4
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000159288.png)
<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>[20,50,9,63]
<strong>输出：</strong>2
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022500024411.png)
<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>[2,3,6,7,4,12,21,39]
<strong>输出：</strong>8
</pre>

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021022500025396.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>1 &lt;= A.length &lt;= 20000</code></li>
	<li><code>1 &lt;= A[i] &lt;= 100000</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int largestComponentSize(int[] A) {
        int n = A.length, num = 100000 + 1, max = 0;
        Set<Integer> primes = findPrime(num);
        int[] root = new int[n];
        int[] size = new int[n];
        int[] primeToNode = new int[num];
        // 一开始 prime 没有和数组 A 中的 node 连在一起
        Arrays.fill(primeToNode, -1);
        // 初始化 root 和 size array
        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int curr = A[i];
            // find all of its prime factors
            for (Integer prime: primes) {
                if (primes.contains(curr)) {
                    prime = curr;
                }
                if (curr % prime == 0) {
                    // 我们为 curr 找到一个质因数，则需要将该节点加入该 prime 已经连接到的根节点上
                    if (primeToNode[prime] != -1) {
                        // 该 prime 已经与数组 A 中 node 相连
                        union(size, root, primeToNode[prime], i);
                    }
                    primeToNode[prime] = find(root, i);
                    while (curr % prime == 0) {
                        // 将质因数 prime 全部剔除
                        curr = curr / prime;
                    }
                }
                if (curr == 1) {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(size[i], max);
        }
        return max;
    }
    
    public Set<Integer> findPrime(int num) {
        boolean[] isPrime = new boolean[num];
        Arrays.fill(isPrime, true);
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 0; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return primes;
    }
    
    public void union(int[] size, int[] root, int i, int j) {
        int rootI = find(root, i);
        int rootJ = find(root, j);
        if (rootI == rootJ) {
            // 它们已经属于同一个 root
            return;
        }
        if (size[rootI] > size[rootJ]) {
            root[rootJ] = rootI;
            size[rootI] += size[rootJ];
        } else {
            root[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }
    }
    
    public int find(int[] root, int i) {
        // 当某节点的根不是他自己时，则需要继续找到其 root
        List<Integer> records = new LinkedList<>();
        while (root[i] != i) {
            records.add(i);
            i = root[i];
        }
        // 将这些节点均指向其 root
        for (Integer record: records) {
            root[record] = i;
        }
        
        return i;
    }
}
```
# [987. 二叉树的垂序遍历](https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree)
## 题目描述

<p>给定二叉树，按<em>垂序</em>遍历返回其结点值。</p>
<p>对位于&nbsp;<code>(X, Y)</code>&nbsp;的每个结点而言，其左右子结点分别位于&nbsp;<code>(X-1, Y-1)</code>&nbsp;和&nbsp;<code>(X+1, Y-1)</code>。</p>
<p>把一条垂线从&nbsp;<code>X = -infinity</code>&nbsp;移动到&nbsp;<code>X = +infinity</code>&nbsp;，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ <code>Y</code>&nbsp;坐标递减）。</p>
<p>如果两个结点位置相同，则首先报告的结点值较小。</p>
<p>按&nbsp;<code>X</code>&nbsp;坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
![\[外链图片转存失败,源](https://img-blog.csdnimg.cn/20210225000402300.png)
<pre><strong>输入：</strong>[3,9,20,null,null,15,7]
<strong>输出：</strong>[[9],[3,15],[20],[7]]
<strong>解释： </strong>
在不丧失其普遍性的情况下，我们可以假设根结点位于 (0, 0)：
然后，值为 9 的结点出现在 (-1, -1)；
值为 3 和 15 的两个结点分别出现在 (0, 0) 和 (0, -2)；
值为 20 的结点出现在 (1, -1)；
值为 7 的结点出现在 (2, -2)。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225000424247.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
<pre><strong>输入：</strong>[1,2,3,4,5,6,7]
<strong>输出：</strong>[[4],[2],[1,5,6],[3],[7]]
<strong>解释：</strong>
根据给定的方案，值为 5 和 6 的两个结点出现在同一位置。
然而，在报告 &quot;[1,5,6]&quot; 中，结点值 5 排在前面，因为 5 小于 6。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li>树的结点数介于 <code>1</code>&nbsp;和&nbsp;<code>1000</code>&nbsp;之间。</li>
	<li>每个结点值介于&nbsp;<code>0</code>&nbsp;和&nbsp;<code>1000</code>&nbsp;之间。</li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                if (o1[1] != o2[1]) return Integer.compare(o2[1], o1[1]);
                return Integer.compare(o1[2], o2[2]);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int preX = 1;
        for (int[] cur : list) {
            if (preX != cur[0]) {
                res.add(new ArrayList<>());
                preX = cur[0];
            }
            res.get(res.size() - 1).add(cur[2]);
        }
        return res;
    }
    private void dfs(TreeNode root, int x, int y, List<int[]> list) {
        if (root == null) {
            return;
        }
        list.add(new int[]{x, y, root.val});
        dfs(root.left, x - 1, y - 1, list);
        dfs(root.right, x + 1, y - 1, list);
    }
}
```
# [1036. 逃离大迷宫](https://leetcode-cn.com/problems/escape-a-large-maze)
## 题目描述

<p>在一个 10^6 x 10^6 的网格中，每个网格块的坐标为&nbsp;<code>(x, y)</code>，其中&nbsp;<code>0 &lt;= x, y &lt; 10^6</code>。</p>
<p>我们从源方格&nbsp;<code>source</code>&nbsp;开始出发，意图赶往目标方格&nbsp;<code>target</code>。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表&nbsp;<code>blocked</code>&nbsp;上。</p>
<p>只有在可以通过一系列的移动到达目标方格时才返回&nbsp;<code>true</code>。否则，返回 <code>false</code>。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
<strong>输出：</strong>false
<strong>解释：</strong>
从源方格无法到达目标方格，因为我们无法在网格中移动。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>blocked = [], source = [0,0], target = [999999,999999]
<strong>输出：</strong>true
<strong>解释：</strong>
因为没有方格被封锁，所以一定可以到达目标方格。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>0 &lt;= blocked.length &lt;= 200</code></li>
	<li><code>blocked[i].length == 2</code></li>
	<li><code>0 &lt;= blocked[i][j] &lt; 10^6</code></li>
	<li><code>source.length == target.length == 2</code></li>
	<li><code>0 &lt;= source[i][j], target[i][j] &lt; 10^6</code></li>
	<li><code>source != target</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2) {
            return Boolean.TRUE;
        }
        return walk(blocked, source, target) && walk(blocked, target, source);
    }
    private Boolean walk(int[][] blocked, int[] source, int[] target) {
        int N = 1000000;
        Set<Pair<Integer, Integer>> visitSet = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> start = new Pair<>(source[0], source[1]);
        queue.add(start);
        visitSet.add(start);
        Set<Pair> blockedSet = Arrays.stream(blocked).map(item -> new Pair(item[0], item[1])).collect(Collectors.toSet());
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            Integer x = top.getKey();
            Integer y = top.getValue();
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                Pair<Integer, Integer> pair = new Pair<>(newX, newY);
                if (newX < 0 || newY < 0 || newX >= N || newY >= N || visitSet.contains(pair) || blockedSet.contains(pair)) {
                    continue;
                }
                queue.add(pair);
                visitSet.add(pair);
                if (queue.size() >= blocked.length || (newX == target[0] && newY == target[1])) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}
```
# [1074. 元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target)
## 题目描述

<p>给出矩阵&nbsp;<code>matrix</code>&nbsp;和目标值&nbsp;<code>target</code>，返回元素总和等于目标值的非空子矩阵的数量。</p>
<p>子矩阵&nbsp;<code>x1, y1, x2, y2</code>&nbsp;是满足 <code>x1 &lt;= x &lt;= x2</code>&nbsp;且&nbsp;<code>y1 &lt;= y &lt;= y2</code>&nbsp;的所有单元&nbsp;<code>matrix[x][y]</code>&nbsp;的集合。</p>
<p>如果&nbsp;<code>(x1, y1, x2, y2)</code> 和&nbsp;<code>(x1&#39;, y1&#39;, x2&#39;, y2&#39;)</code>&nbsp;两个子矩阵中部分坐标不同（如：<code>x1 != x1&#39;</code>），那么这两个子矩阵也不同。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
<strong>输出：</strong>4
<strong>解释：</strong>四个只含 0 的 1x1 子矩阵。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>matrix = [[1,-1],[-1,1]], target = 0
<strong>输出：</strong>5
<strong>解释：</strong>两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
</pre>

<p>&nbsp;</p>
<p><strong><strong>提示：</strong></strong></p>
<ol>
	<li><code>1 &lt;= matrix.length &lt;= 300</code></li>
	<li><code>1 &lt;= matrix[0].length &lt;= 300</code></li>
	<li><code>-1000 &lt;= matrix[i] &lt;= 1000</code></li>
	<li><code>-10^8 &lt;= target &lt;= 10^8</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int[][] sum = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sum[i][j] = matrix[i][j] + sum[i][j - 1];
                } else if (j == 0) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j];
                } else {
                    sum[i][j] = matrix[i][j] - sum[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1];
                }
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        int main = (k != 0 && l != 0) ? sum[k - 1][l - 1] : 0;
                        int left = k != 0 ? sum[k - 1][j] : 0;
                        int up = l != 0 ? sum[i][l - 1] : 0;
                        if (sum[i][j] - left - up + main == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
```

# [1095. 山脉数组中查找目标值](https://leetcode-cn.com/problems/find-in-mountain-array)
## 题目描述

<p>（这是一个 <strong>交互式问题&nbsp;</strong>）</p>
<p>给你一个 <strong>山脉数组</strong>&nbsp;<code>mountainArr</code>，请你返回能够使得&nbsp;<code>mountainArr.get(index)</code>&nbsp;<strong>等于</strong>&nbsp;<code>target</code>&nbsp;<strong>最小</strong>&nbsp;的下标 <code>index</code>&nbsp;值。</p>
<p>如果不存在这样的下标 <code>index</code>，就请返回&nbsp;<code>-1</code>。</p>
<p>&nbsp;</p>
<p>所谓山脉数组，即数组&nbsp;<code>A</code>&nbsp;假如是一个山脉数组的话，需要满足如下条件：</p>
<p><strong>首先</strong>，<code>A.length &gt;= 3</code></p>
<p><strong>其次</strong>，在&nbsp;<code>0 &lt; i&nbsp;&lt; A.length - 1</code>&nbsp;条件下，存在 <code>i</code> 使得：</p>
<ul>
	<li><code>A[0] &lt; A[1] &lt; ... A[i-1] &lt; A[i]</code></li>
	<li><code>A[i] &gt; A[i+1] &gt; ... &gt; A[A.length - 1]</code></li>
</ul>
<p>&nbsp;</p>
<p>你将&nbsp;<strong>不能直接访问该山脉数组</strong>，必须通过&nbsp;<code>MountainArray</code>&nbsp;接口来获取数据：</p>
<ul>
	<li><code>MountainArray.get(k)</code>&nbsp;- 会返回数组中索引为<code>k</code>&nbsp;的元素（下标从 0 开始）</li>
	<li><code>MountainArray.length()</code>&nbsp;- 会返回该数组的长度</li>
</ul>
<p>&nbsp;</p>
<p><strong>注意：</strong></p>
<p>对&nbsp;<code>MountainArray.get</code>&nbsp;发起超过 <code>100</code> 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。</p>
<p>为了帮助大家更好地理解交互式问题，我们准备了一个样例 &ldquo;<strong>答案</strong>&rdquo;：<a href="https://leetcode-cn.com/playground/RKhe3ave" target="_blank">https://leetcode-cn.com/playground/RKhe3ave</a>，请注意这 <strong>不是一个正确答案</strong>。</p>
<ol>
</ol>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>array = [1,2,3,4,5,3,1], target = 3
<strong>输出：</strong>2
<strong>解释：</strong>3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>array = [0,1,2,4,2,1], target = 3
<strong>输出：</strong>-1
<strong>解释：</strong>3 在数组中没有出现，返回 -1。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ol>
	<li><code>3 &lt;= mountain_arr.length() &lt;= 10000</code></li>
	<li><code>0 &lt;= target &lt;= 10^9</code></li>
	<li><code>0 &lt;= mountain_arr.get(index) &lt;=&nbsp;10^9</code></li>
</ol>

## 解法

### **Java**
```java
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int l = 0, r = length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) r = mid;
            else l = mid + 1;
        }
        int topIndex = r;
        int topValue = mountainArr.get(topIndex);
        if (target == topValue) return topIndex;
        if (target > topValue) return -1;
        l = 0;
        r = topIndex - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        if (mountainArr.get(r) == target) {
            return r;
        }
        l = topIndex + 1;
        r = length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (mountainArr.get(mid) <= target) r = mid;
            else l = mid + 1;
        }
        return mountainArr.get(r) == target ? r : -1;
    }
}
```
# [1147. 段式回文](https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition)
## 题目描述

<p>段式回文 其实与 一般回文 类似，只不过是最小的单位是 一段字符&nbsp;而不是 单个字母。</p>
<p>举个例子，对于一般回文 &quot;<code>abcba</code>&quot; 是回文，而 &quot;<code>volvo</code>&quot; 不是，但如果我们把&nbsp;&quot;<code>volvo</code>&quot; 分为 &quot;<code>vo</code>&quot;、&quot;<code>l</code>&quot;、&quot;<code>vo</code>&quot; 三段，则可以认为 &ldquo;<code>(vo)(l)(vo)</code>&rdquo; 是段式回文（分为 3 段）。</p>
<p>&nbsp;</p>
<p>给你一个字符串&nbsp;<code>text</code>，在确保它满足段式回文的前提下，请你返回 <strong>段</strong> 的&nbsp;<strong>最大数量</strong>&nbsp;<code>k</code>。</p>
<p>如果段的最大数量为&nbsp;<code>k</code>，那么存在满足以下条件的&nbsp;<code>a_1, a_2, ..., a_k</code>：</p>
<ul>
	<li>每个&nbsp;<code>a_i</code>&nbsp;都是一个非空字符串；</li>
	<li>将这些字符串首位相连的结果&nbsp;<code>a_1 + a_2 + ... + a_k</code>&nbsp;和原始字符串&nbsp;<code>text</code>&nbsp;相同；</li>
	<li>对于所有<code>1 &lt;= i &lt;= k</code>，都有&nbsp;<code>a_i = a_{k+1 - i}</code>。</li>
</ul>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>text = &quot;ghiabcdefhelloadamhelloabcdefghi&quot;
<strong>输出：</strong>7
<strong>解释：</strong>我们可以把字符串拆分成 &quot;(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)&quot;。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>text = &quot;merchant&quot;
<strong>输出：</strong>1
<strong>解释：</strong>我们可以把字符串拆分成 &quot;(merchant)&quot;。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>text = &quot;antaprezatepzapreanta&quot;
<strong>输出：</strong>11
<strong>解释：</strong>我们可以把字符串拆分成 &quot;(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)&quot;。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>text = &quot;aaa&quot;
<strong>输出：</strong>3
<strong>解释：</strong>我们可以把字符串拆分成 &quot;(a)(a)(a)&quot;。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>text</code>&nbsp;仅由小写英文字符组成。</li>
	<li><code>1 &lt;= text.length &lt;= 1000</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    public int longestDecomposition(String text) {
        char[] cs = text.toCharArray();
        int res = 0;
        for (int i = 0, j = cs.length - 1; i <= j; ) {
            boolean flag = true;
            for (int k = 1; i + k - 1 < j - k + 1; ++k) {
                if (check(cs, i, j - k + 1, k)) {
                    res += 2;
                    i += k;
                    j -= k;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ++res;
                break;
            }
        }
        return res;
    }
    private boolean check(char[] cs, int i, int j, int k) {
        while (k-- > 0) {
            if (cs[i++] != cs[j++]) {
                return false;
            }
        }
        return true;
    }
}
```
# [1537. 最大得分](https://leetcode-cn.com/problems/get-the-maximum-score)
## 题目描述

<p>你有两个 <strong>有序</strong>&nbsp;且数组内元素互不相同的数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;。</p>
<p>一条&nbsp;<strong>合法路径</strong>&nbsp;定义如下：</p>
<ul>
	<li>选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。</li>
	<li>从左到右遍历当前数组。</li>
	<li>如果你遇到了 <code>nums1</code>&nbsp;和 <code>nums2</code>&nbsp;中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。</li>
</ul>
<p>得分定义为合法路径中不同数字的和。</p>
<p>请你返回所有可能合法路径中的最大得分。</p>
<p>由于答案可能很大，请你将它对 10^9 + 7 取余后返回。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001704792.png)
<pre><strong>输入：</strong>nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
<strong>输出：</strong>30
<strong>解释：</strong>合法路径包括：
[2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
[4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
最大得分为上图中的绿色路径 <strong>[2,4,6,8,10]</strong>&nbsp;。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>nums1 = [1,3,5,7,9], nums2 = [3,5,100]
<strong>输出：</strong>109
<strong>解释：</strong>最大得分由路径 <strong>[1,3,5,100]</strong> 得到。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
<strong>输出：</strong>40
<strong>解释：</strong>nums1 和 nums2 之间无相同数字。
最大得分由路径 <strong>[6,7,8,9,10]</strong> 得到。
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>nums1 = [1,4,5,8,9,11,19], nums2 = [2,3,4,11,12]
<strong>输出：</strong>61
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums1.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= nums2.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10^7</code></li>
	<li><code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;都是严格递增的数组。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    final int MOD = (int) (1e9 + 7);
    public int maxSum(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        if (set1.isEmpty()) {
            return (int) (Math.max(sum(nums1, 0, nums1.length - 1), sum(nums2, 0, nums2.length - 1))
                    % MOD);
        }
        long res = 0;
        List<Integer> list = set1.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int start1 = 0, start2 = 0, end1 = 0, end2 = 0;
        for (int common : list) {
            // 2 个数组同时到达 set
            while (nums1[end1] != common) {
                end1++;
            }
            while (nums2[end2] != common) {
                end2++;
            }
            // max
            res += Math.max(sum(nums1, start1, end1), sum(nums2, start2, end2));
            start1 = end1 + 1;
            start2 = end2 + 1;
        }
        res += Math.max(sum(nums1, end1 + 1, nums1.length - 1),
                sum(nums2, end2 + 1, nums2.length - 1));
        res %= MOD;
        return (int) res;
    }
    private long sum(int[] n, int l, int r) {
        long res = 0;
        while (l <= r) {
            res += n[l++];
        }
        return res;
    }
}
```
# [1553. 吃掉 N 个橘子的最少天数](https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges)
## 题目描述

<p>厨房里总共有 <code>n</code>&nbsp;个橘子，你决定每一天选择如下方式之一吃这些橘子：</p>
<ul>
	<li>吃掉一个橘子。</li>
	<li>如果剩余橘子数 <code>n</code>&nbsp;能被 2 整除，那么你可以吃掉 <code>n/2</code> 个橘子。</li>
	<li>如果剩余橘子数&nbsp;<code>n</code>&nbsp;能被 3 整除，那么你可以吃掉 <code>2*(n/3)</code> 个橘子。</li>
</ul>
<p>每天你只能从以上 3 种方案中选择一种方案。</p>
<p>请你返回吃掉所有 <code>n</code>&nbsp;个橘子的最少天数。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>
<pre><strong>输入：</strong>n = 10
<strong>输出：</strong>4
<strong>解释：</strong>你总共有 10 个橘子。
第 1 天：吃 1 个橘子，剩余橘子数 10 - 1 = 9。
第 2 天：吃 6 个橘子，剩余橘子数 9 - 2*(9/3) = 9 - 6 = 3。（9 可以被 3 整除）
第 3 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。
第 4 天：吃掉最后 1 个橘子，剩余橘子数 1 - 1 = 0。
你需要至少 4 天吃掉 10 个橘子。
</pre>

<p><strong>示例 2：</strong></p>
<pre><strong>输入：</strong>n = 6
<strong>输出：</strong>3
<strong>解释：</strong>你总共有 6 个橘子。
第 1 天：吃 3 个橘子，剩余橘子数 6 - 6/2 = 6 - 3 = 3。（6 可以被 2 整除）
第 2 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。（3 可以被 3 整除）
第 3 天：吃掉剩余 1 个橘子，剩余橘子数 1 - 1 = 0。
你至少需要 3 天吃掉 6 个橘子。
</pre>

<p><strong>示例 3：</strong></p>
<pre><strong>输入：</strong>n = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>
<pre><strong>输入：</strong>n = 56
<strong>输出：</strong>6
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= n &lt;= 2*10^9</code></li>
</ul>

## 解法

### **Java**
```java
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if (n < 2) {
            return n;
        }
        if (!map.containsKey(n)) {
            map.put(n, Math.min(minDays(n / 2) + 1 + n % 2, minDays(n / 3) + 1 + n % 3));
        }
        return map.get(n);
    }
}
```
# [1569. 将子数组重新排序得到同一个二叉查找树的方案数](https://leetcode-cn.com/problems/number-of-ways-to-reorder-array-to-get-same-bst)
## 题目描述

<p>给你一个数组 <code>nums</code>&nbsp;表示 <code>1</code>&nbsp;到 <code>n</code>&nbsp;的一个排列。我们按照元素在 <code>nums</code>&nbsp;中的顺序依次插入一个初始为空的二叉查找树（BST）。请你统计将 <code>nums</code>&nbsp;重新排序后，统计满足如下条件的方案数：重排后得到的二叉查找树与 <code>nums</code>&nbsp;原本数字顺序得到的二叉查找树相同。</p>
<p>比方说，给你&nbsp;<code>nums = [2,1,3]</code>，我们得到一棵 2 为根，1 为左孩子，3 为右孩子的树。数组&nbsp;<code>[2,3,1]</code>&nbsp;也能得到相同的 BST，但&nbsp;<code>[3,2,1]</code>&nbsp;会得到一棵不同的&nbsp;BST 。</p>
<p>请你返回重排 <code>nums</code>&nbsp;后，与原数组 <code>nums</code>&nbsp;得到相同二叉查找树的方案数。</p>
<p>由于答案可能会很大，请将结果对<strong>&nbsp;</strong><code>10^9 + 7</code>&nbsp;取余数。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001818792.png)
<pre><strong>输入：</strong>nums = [2,1,3]
<strong>输出：</strong>1
<strong>解释：</strong>我们将 nums 重排， [2,3,1] 能得到相同的 BST 。没有其他得到相同 BST 的方案了。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001903142.png)
<pre><strong>输入：</strong>nums = [3,4,5,1,2]
<strong>输出：</strong>5
<strong>解释：</strong>下面 5 个数组会得到相同的 BST：
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]
</pre>

<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001932672.png)
<pre><strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>0
<strong>解释：</strong>没有别的排列顺序能得到相同的 BST 。
</pre>

<p><strong>示例 4：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225001954387.png)
<pre><strong>输入：</strong>nums = [3,1,2,5,4,6]
<strong>输出：</strong>19
</pre>

<p><strong>示例&nbsp; 5：</strong></p>
<pre><strong>输入：</strong>nums = [9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18]
<strong>输出：</strong>216212978
<strong>解释：</strong>得到相同 BST 的方案数是 3216212999。将它对 10^9 + 7 取余后得到 216212978。
</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
	<li><code>nums</code>&nbsp;中所有数 <strong>互不相同</strong>&nbsp;。</li>
</ul>

## 解法

### **Java**
```java
class Solution {
     int mod = (int) 1e9 + 7;
    public int numOfWays(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return dfs(Arrays.stream(nums).boxed().collect(Collectors.toList()), calc(nums.length)) - 1;
    }
    private int dfs(List<Integer> list, int[][] c) {
        if (list.isEmpty()) {
            return 1;
        }
        List<Integer> left = list.stream().filter(n -> n < list.get(0))
                .collect(Collectors.toList());
        List<Integer> right = list.stream().filter(n -> n > list.get(0))
                .collect(Collectors.toList());
        return (int) ((long) c[list.size() - 1][left.size()] * dfs(left, c) % mod * dfs(right, c)
                % mod);
    }
    private int[][] calc(int n) {
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod;
                }
            }
        }
        return c;
    }
}
```
# [1579. 保证图可完全遍历](https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable)
## 题目描述

<p>Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3&nbsp; 种类型的边：</p>
<ul>
	<li>类型 1：只能由 Alice 遍历。</li>
	<li>类型 2：只能由 Bob 遍历。</li>
	<li>类型 3：Alice 和 Bob 都可以遍历。</li>
</ul>
<p>给你一个数组 <code>edges</code> ，其中 <code>edges[i] = [type<sub>i</sub>, u<sub>i</sub>, v<sub>i</sub>]</code>&nbsp;表示节点 <code>u<sub>i</sub></code> 和 <code>v<sub>i</sub></code> 之间存在类型为 <code>type<sub>i</sub></code> 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。</p>
<p>返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。</p>
<p>&nbsp;</p>
<p><strong>示例 1：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225002137499.png)
<pre><strong>输入：</strong>n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
<strong>输出：</strong>2
<strong>解释：</strong>如果删除<strong> </strong>[1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
</pre>

<p><strong>示例 2：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225002158518.png)
<pre><strong>输入：</strong>n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
<strong>输出：</strong>0
<strong>解释：</strong>注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
</pre>

<p><strong>示例 3：</strong></p>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210225002210872.png)
<pre><strong>输入：</strong>n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
<strong>输出：</strong>-1
<strong>解释：</strong>在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。</pre>

<p>&nbsp;</p>
<p><strong>提示：</strong></p>
<ul>
	<li><code>1 &lt;= n &lt;= 10^5</code></li>
	<li><code>1 &lt;= edges.length &lt;= min(10^5, 3 * n * (n-1) / 2)</code></li>
	<li><code>edges[i].length == 3</code></li>
	<li><code>1 &lt;= edges[i][0] &lt;= 3</code></li>
	<li><code>1 &lt;= edges[i][1] &lt; edges[i][2] &lt;= n</code></li>
	<li>所有元组 <code>(type<sub>i</sub>, u<sub>i</sub>, v<sub>i</sub>)</code> 互不相同</li>
</ul>

## 解法

### **Java**
```java
class Solution {
    // https://oi-wiki.org/ds/dsu/#_3
    private boolean[] used;
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        used = new boolean[edges.length];
        // type 为倒序，3, 2, 1
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        if (!unionFind(n, edges, 1)) return -1;
        if (!unionFind(n, edges, 2)) return -1;
        int result = 0;
        for (boolean u : used) {
            result += u ? 0 : 1;
        }
        return result;
    }
    private boolean unionFind(int n, int[][] edges, int excludedType) {
        int[] union = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            union[i] = i;
        }
        int cnt = 0;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (edge[0] == excludedType) continue;
            int rootA = findRoot(union, edge[1]);
            int rootB = findRoot(union, edge[2]);
            if (rootA != rootB) {
                cnt += 1;
                union[rootA] = rootB;
                used[i] = true;
            }
            if (cnt == n - 1) return true;
        }
        return false;
    }
    private int findRoot(int[] union, int idx) {
        if (union[idx] != idx) {
            int root = findRoot(union, union[idx]);
            union[idx] = root;
            return root;
        }
        return idx;
    }
}
```

