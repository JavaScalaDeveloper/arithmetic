# [《程序员面试金典（第 6 版）》系列](https://leetcode-cn.com/problemset/lcci/)

本书是原谷歌资深面试官的经验之作，帮助了许多想要加入脸书、苹果、谷歌等 IT 名企的求职者拿到 Dream offer。本专题的 100+ 编程面试题是在原书基础上精心挑选出来的，帮助你轻松应战 IT 名企技术面试。

[English Version](/lcci/README_EN.md)

## Stack方法摘要
```aidl
boolean	empty()          测试堆栈是否为空。
E	peek()          查看堆栈顶部的对象，但不从堆栈中移除它。
E	pop()          移除堆栈顶部的对象，并作为此函数的值返回该对象。
E	push(E item)          把项压入堆栈顶部。
int	search(Object o)          返回对象在堆栈中的位置，以 1 为基数。
```

## Queue队列方法摘要
```aidl
boolean	add(E e)          将指定的元素插入此队列（如果立即可行且不会违反容量限制），在成功时返回 true，如果当前没有可用的空间，则抛出 IllegalStateException。
E	element()          获取，但是不移除此队列的头。
boolean	offer(E e)          将指定的元素插入此队列（如果立即可行且不会违反容量限制），当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
E	peek()          获取但不移除此队列的头；如果此队列为空，则返回 null。
E	poll()          获取并移除此队列的头，如果此队列为空，则返回 null。
E	remove()          获取并移除此队列的头。
```
# [面试题 01.01. 判定字符是否唯一](https://leetcode-cn.com/problems/is-unique-lcci)

[English Version](/lcci/01.01.Is%20Unique/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个算法，确定一个字符串 <code>s</code> 的所有字符是否全都不同。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> <code>s</code> = &quot;leetcode&quot;
<strong>输出:</strong> false 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> <code>s</code> = &quot;abc&quot;
<strong>输出:</strong> true
</pre>

<p><strong>限制：</strong></p>
<ul>
	<li><code>0 <= len(s) <= 100 </code></li>
	<li>如果你不使用额外的数据结构，会很加分。</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.02. 判定是否互为字符重排](https://leetcode-cn.com/problems/check-permutation-lcci)

[English Version](/lcci/01.02.Check%20Permutation/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个字符串 <code>s1</code> 和 <code>s2</code>，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bca&quot;
<strong>输出:</strong> true 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入:</strong> <code>s1</code> = &quot;abc&quot;, <code>s2</code> = &quot;bad&quot;
<strong>输出:</strong> false
</pre>

<p><strong>说明：</strong></p>

<ul>
	<li><code>0 &lt;= len(s1) &lt;= 100 </code></li>
	<li><code>0 &lt;= len(s2) &lt;= 100 </code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.03. URL 化](https://leetcode-cn.com/problems/string-to-url-lcci)

[English Version](/lcci/01.03.String%20to%20URL/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>URL化。编写一种方法，将字符串中的空格全部替换为<code>%20</code>。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的&ldquo;真实&rdquo;长度。（注：用<code>Java</code>实现的话，请使用字符数组实现，以便直接在数组上操作。）</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：&quot;Mr John Smith    &quot;, 13
<strong> 输出</strong>：&quot;Mr%20John%20Smith&quot;
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：&quot;               &quot;, 5
<strong> 输出</strong>：&quot;%20%20%20%20%20&quot;
</pre>

<p><strong>提示：</strong></p>

<ol>
	<li>字符串长度在[0, 500000]范围内。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] c = S.toCharArray();
        int j = c.length;
        for (int i = length - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[--j] = '0';
                c[--j] = '2';
                c[--j] = '%';
            } else {
                c[--j] = c[i];
            }
        }
        return new String(c, j, c.length - j);
    }
}
//拓展： 方法说明
//从数组下标为offset开始顺序取出数组codePoints[]中count个整数，并根据此uncode代码点所对应的字符创建一个string对象
public String(int[] codePoints, int offset, int count) {}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.04. 回文排列](https://leetcode-cn.com/problems/palindrome-permutation-lcci)

[English Version](/lcci/01.04.Palindrome%20Permutation/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。</p>

<p>回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。</p>

<p>回文串不一定是字典当中的单词。</p>

<p>&nbsp;</p>

<p><strong>示例1：</strong></p>

<pre><strong>输入：&quot;</strong>tactcoa&quot;
<strong>输出：</strong>true（排列有&quot;tacocat&quot;、&quot;atcocta&quot;，等等）
</pre>

<p>&nbsp;</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

用哈希表存储每个字符出现的次数。若次数为奇数的字符超过 1 个，则不是回文排列。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : chars) {
            counter.put(ch, counter.get(ch) == null ? 1 : counter.get(ch) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                ++cnt;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt <= 1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.05. 一次编辑](https://leetcode-cn.com/problems/one-away-lcci)

[English Version](/lcci/01.05.One%20Away/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre><strong>输入:</strong> 
first = &quot;pale&quot;
second = &quot;ple&quot;
<strong>输出:</strong> True</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> 
first = &quot;pales&quot;
second = &quot;pal&quot;
<strong>输出:</strong> False
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

遍历两个字符串，逐个字符比较判断。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean oneEditAway(String first, String second) {
        int n1 = first.length(), n2 = second.length();
        int differ = Math.abs(n1 - n2);
        if (differ > 1) {
            return false;
        }
        if (n1 + n2 <= 2) {
            return true;
        }
        if (first.charAt(0) != second.charAt(0)) {
            if (n1 == n2) {
                return first.substring(1).equals(second.substring(1));
            } else {
                return first.substring(1).equals(second) || second.substring(1).equals(first);
            }
        } else {
            return oneEditAway(first.substring(1), second.substring(1));
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.06. 字符串压缩](https://leetcode-cn.com/problems/compress-string-lcci)

[English Version](/lcci/01.06.Compress%20String/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串<code>aabcccccaaa</code>会变为<code>a2b1c5a3</code>。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>："aabcccccaaa"
<strong> 输出</strong>："a2b1c5a3"
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>："abbccd"
<strong> 输出</strong>："abbccd"
<strong> 解释</strong>："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
</pre>

<p><strong>提示：</strong></p>

<ol>
<li>字符串长度在[0, 50000]范围内。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

双指针遍历字符串求解。

<!-- tabs:start -->
### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String compressString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        char[] chars = S.toCharArray();
        int p = 0, q = 1, n = chars.length;
        StringBuilder sb = new StringBuilder();
        while (q < n) {
            if (chars[p] != chars[q]) {
                sb.append(chars[p]).append(q - p);
                p = q;
            }
            q += 1;
        }
        sb.append(chars[p]).append(q - p);
        String res = sb.toString();
        return res.length() < n ? res : S;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.07. 旋转矩阵](https://leetcode-cn.com/problems/rotate-matrix-lcci)

[English Version](/lcci/01.07.Rotate%20Matrix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。</p>

<p>不占用额外内存空间能否做到？</p>

<p>&nbsp;</p>

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

<!-- 这里可写通用的实现逻辑 -->

原地旋转，i 的范围是 `[0, n/2)`，j 的范围是 `[i, n-1-i)`。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = t;
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.08. 零矩阵](https://leetcode-cn.com/problems/zero-matrix-lcci)

[English Version](/lcci/01.08.Zero%20Matrix/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
<strong>输出：</strong>
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
<strong>输出：</strong>
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

用 set 记录需要清零的行 `zero_rows` 跟列 `zero_cols`，之后分别将需要清零的行、列上的所有元素清零。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // 行清零
        for (int row : zeroRows) {
            for (int j = 0; j < cols; ++j) {
                matrix[row][j] = 0;
            }
        }

        // 列清零
        for (int col : zeroCols) {
            for (int i = 0; i < rows; ++i) {
                matrix[i][col] = 0;
            }
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 01.09. 字符串轮转](https://leetcode-cn.com/problems/string-rotation-lcci)

[English Version](/lcci/01.09.String%20Rotation/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>字符串轮转。给定两个字符串<code>s1</code>和<code>s2</code>，请编写代码检查<code>s2</code>是否为<code>s1</code>旋转而成（比如，<code>waterbottle</code>是<code>erbottlewat</code>旋转后的字符串）。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：s1 = &quot;waterbottle&quot;, s2 = &quot;erbottlewat&quot;
<strong> 输出</strong>：True
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：s1 = &quot;aa&quot;, &quot;aba&quot;
<strong> 输出</strong>：False
</pre>

<ol>
</ol>

<p><strong>提示：</strong></p>

<ol>
	<li>字符串长度在[0, 100000]范围内。</li>
</ol>

<p><strong>说明:</strong></p>

<ol>
	<li>你能只调用一次检查子串的方法吗？</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

```python
class Solution:
    def isFlipedString(self, s1: str, s2: str) -> bool:
        return len(s1) == len(s2) and s1 in (s2 * 2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).indexOf(s1) != -1;
        //等价于 return s1.length() == s2.length() && (s2 + s2).contains(s1);        
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.01. 移除重复节点](https://leetcode-cn.com/problems/remove-duplicate-node-lcci)

[English Version](/lcci/02.01.Remove%20Duplicate%20Node/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：[1, 2, 3, 3, 2, 1]
<strong> 输出</strong>：[1, 2, 3]
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>：[1, 1, 1, 1, 2]
<strong> 输出</strong>：[1, 2]
</pre>

<p><strong>提示：</strong></p>

<ol>
<li>链表长度在[0, 20000]范围内。</li>
<li>链表元素在[0, 20000]范围内。</li>
</ol>

<p> <strong>进阶：</strong></p>

<p>如果不得使用临时缓冲区，该怎么解决？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> s = new HashSet<>();
        s.add(head.val);
        ListNode p = head.next, cur = head;
        while (p != null) {
            if (!s.contains(p.val)) {
                cur.next = p;
                cur = cur.next;
                s.add(p.val);
            }
            p = p.next;
        }
        cur.next = null;
        return head;

    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.02. 返回倒数第 k 个节点](https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci)

[English Version](/lcci/02.02.Kth%20Node%20From%20End%20of%20List/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。</p>

<p><strong>注意：</strong>本题相对原题稍作改动</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong> 1-&gt;2-&gt;3-&gt;4-&gt;5 和 <em>k</em> = 2
<strong>输出： </strong>4</pre>

<p><strong>说明：</strong></p>

<p>给定的 <em>k</em>&nbsp;保证是有效的。</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

定义 `p`、`q` 指针指向 `head`。

`p` 先向前走 `k` 步，接着 `p`、`q` 同时向前走，当 `p` 指向 `null` 时，`q` 指向的节点即为链表的倒数第 `k` 个节点。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public int kthToLast(ListNode head, int k) {
        ListNode p = head, q = head;
        while (k-- > 0) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        return p.val;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.03. 删除中间节点](https://leetcode-cn.com/problems/delete-middle-node-lcci)

[English Version](/lcci/02.03.Delete%20Middle%20Node/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>单向链表a->b->c->d->e->f中的节点c
<strong>结果：</strong>不返回任何数据，但该链表变为a->b->d->e->f
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

把 node 的下一个节点的值赋给 node，然后改变 node 的 next 指向。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.04. 分割链表](https://leetcode-cn.com/problems/partition-list-lcci)

[English Version](/lcci/02.04.Partition%20List/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于&ldquo;右半部分&rdquo;即可，其不需要被置于左右两部分之间。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> head = 3-&gt;5-&gt;8-&gt;5-&gt;10-&gt;2-&gt;1, <em>x</em> = 5
<strong>输出:</strong> 3-&gt;1-&gt;2-&gt;10-&gt;5-&gt;5-&gt;8
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

创建两个链表，一个存放小于 `x` 的节点，另一个存放大于等于 `x` 的节点，之后进行拼接即可。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode p = left, q = right;
        while (head != null) {
            ListNode t = head.next;
            head.next = null;
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = t;
        }
        p.next = right.next;
        return left.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.05. 链表求和](https://leetcode-cn.com/problems/sum-lists-lcci)

[English Version](/lcci/02.05.Sum%20Lists/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个用链表表示的整数，每个节点包含一个数位。</p>
<p>这些数位是反向存放的，也就是个位排在链表首部。</p>
<p>编写函数对这两个整数求和，并用链表形式返回结果。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>(7 -&gt; 1 -&gt; 6) + (5 -&gt; 9 -&gt; 2)，即617 + 295
<strong>输出：</strong>2 -&gt; 1 -&gt; 9，即912
</pre>

<p><strong>进阶：</strong>假设这些数位是正向存放的，请再做一遍。</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>(6 -&gt; 1 -&gt; 7) + (2 -&gt; 9 -&gt; 5)，即617 + 295
<strong>输出：</strong>9 -&gt; 1 -&gt; 2，即912
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

同时遍历两链表，求节点的和与进位。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        int carry = 0;
        ListNode t = p;
        while (l1 != null || l2 != null) {
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            t.next = new ListNode(s % 10);
            carry = s > 9 ? 1 : 0;
            t = t.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        t.next = carry == 0 ? null : new ListNode(carry);
        return p.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.06. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list-lcci)

[English Version](/lcci/02.06.Palindrome%20Linked%20List/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一个函数，检查输入的链表是否是回文的。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入： </strong>1-&gt;2
<strong>输出：</strong> false 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入： </strong>1-&gt;2-&gt;2-&gt;1
<strong>输出：</strong> true 
</pre>

<p>&nbsp;</p>

<p><strong>进阶：</strong><br>
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

先用快慢指针找到链表的中点，接着反转右半部分的链表。然后同时遍历前后两段链表，若前后两段链表节点对应的值不等，说明不是回文链表，否则说明是回文链表。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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

### **...**

```

```

<!-- tabs:end -->
# [面试题 02.08. 环路检测](https://leetcode-cn.com/problems/linked-list-cycle-lcci)

[English Version](/lcci/02.08.Linked%20List%20Cycle/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个有环链表，实现一个算法返回环路的开头节点。<br>有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。</p><br><p><strong>示例 1：</strong><pre><strong>输入：</strong>head = [3,2,0,-4], pos = 1<br><strong>输出：</strong>tail connects to node index 1<br><strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。</pre></p><br><p><strong>示例 2：</strong><pre><strong>输入：</strong>head = [1,2], pos = 0<br><strong>输出：</strong>tail connects to node index 0<br><strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。</pre></p><br><p><strong>示例 3：</strong><pre><strong>输入：</strong>head = [1], pos = -1<br><strong>输出：</strong>no cycle<br><strong>解释：</strong>链表中没有环。</pre></p><br><p><strong>进阶：</strong><br>你是否可以不用额外空间解决此题？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
         ListNode fast = head, slow = head;
         while (fast != null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
             if (fast == slow) break;
         }
         if (fast == null || fast.next == null) return null;
         ListNode p = head;
         while (p != slow) {
             p = p.next;
             slow = slow.next;
         }
         return p;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 03.01. 三合一](https://leetcode-cn.com/problems/three-in-one-lcci)

[English Version](/lcci/03.01.Three%20in%20One/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>三合一。描述如何只用一个数组来实现三个栈。</p>

<p>你应该实现<code>push(stackNum, value)</code>、<code>pop(stackNum)</code>、<code>isEmpty(stackNum)</code>、<code>peek(stackNum)</code>方法。<code>stackNum</code>表示栈下标，<code>value</code>表示压入的值。</p>

<p>构造函数会传入一个<code>stackSize</code>参数，代表每个栈的大小。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
<strong> 输出</strong>：
[null, null, null, 1, -1, -1, true]
<strong>说明</strong>：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：
[&quot;TripleInOne&quot;, &quot;push&quot;, &quot;push&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;peek&quot;]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
<strong> 输出</strong>：
[null, null, null, null, 2, 1, -1, -1]
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

二维数组解决；也可以使用一维数组，以下标 `0,3,6,..`、`1,4,7,..`、`2,5,8,..` 区分，一维数组最后三个元素记录每个栈的元素个数。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class TripleInOne {
    private int[] s;
    private int capacity;

    public TripleInOne(int stackSize) {
        s = new int[stackSize * 3 + 3];
        capacity = stackSize;
    }

    public void push(int stackNum, int value) {
        if (s[stackNum + 3 * capacity] < capacity) {
            s[s[stackNum + 3 * capacity] * 3 + stackNum] = value;
            ++s[stackNum + 3 * capacity];
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        --s[stackNum + 3 * capacity];
        return s[s[stackNum + 3 * capacity] * 3 + stackNum];
    }

    public int peek(int stackNum) {
        return isEmpty(stackNum) ? -1 : s[(s[stackNum + 3 * capacity] - 1) * 3 + stackNum];
    }

    public boolean isEmpty(int stackNum) {
        return s[stackNum + 3 * capacity] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 03.02. 栈的最小值](https://leetcode-cn.com/problems/min-stack-lcci)

[English Version](/lcci/03.02.Min%20Stack/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。</p><br><p><strong>示例：</strong><pre>MinStack minStack = new MinStack();<br>minStack.push(-2);<br>minStack.push(0);<br>minStack.push(-3);<br>minStack.getMin();   --> 返回 -3.<br>minStack.pop();<br>minStack.top();      --> 返回 0.<br>minStack.getMin();   --> 返回 -2.</pre></p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

利用辅助栈存放栈的最小元素。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MinStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        s2.push(s2.empty() || s2.peek() >= x ? x : s2.peek());
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.empty() ? -1 : s2.peek();
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

### **...**

```

```

<!-- tabs:end -->
# [面试题 03.04. 化栈为队](https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci)

[English Version](/lcci/03.04.Implement%20Queue%20using%20Stacks/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个MyQueue类，该类用两个栈来实现一个队列。</p><br><p><strong>示例：</strong><pre>MyQueue queue = new MyQueue();<br><br>queue.push(1);<br>queue.push(2);<br>queue.peek();  // 返回 1<br>queue.pop();   // 返回 1<br>queue.empty(); // 返回 false</pre></p><br><p><strong>说明：</strong><br><ul><li>你只能使用标准的栈操作 -- 也就是只有 <code>push to top</code>, <code>peek/pop from top</code>, <code>size</code> 和 <code>is empty</code> 操作是合法的。</li><li>你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。</li><li>假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。</li></ul></p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

- 每次压入元素时，放入第 1 个栈中；
- 第 2 个栈不为空时，不能倒入元素；
- 第 2 个栈为空时，必须将第 1 个栈的所有元素按顺序倒入第 2 个栈中。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
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

### **...**

```

```

<!-- tabs:end -->
# [面试题 03.05. 栈排序](https://leetcode-cn.com/problems/sort-of-stacks-lcci)

[English Version](/lcci/03.05.Sort%20of%20Stacks/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：<code>push</code>、<code>pop</code>、<code>peek</code> 和 <code>isEmpty</code>。当栈为空时，<code>peek</code>&nbsp;返回 -1。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;SortedStack&quot;, &quot;push&quot;, &quot;push&quot;, &quot;peek&quot;, &quot;pop&quot;, &quot;peek&quot;]
[[], [1], [2], [], [], []]
<strong> 输出</strong>：
[null,null,null,1,null,2]
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>： 
[&quot;SortedStack&quot;, &quot;pop&quot;, &quot;pop&quot;, &quot;push&quot;, &quot;pop&quot;, &quot;isEmpty&quot;]
[[], [], [], [1], [], []]
<strong> 输出</strong>：
[null,null,null,null,null,true]
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li>栈中的元素数目在[0, 5000]范围内。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

利用辅助栈实现 `push` 操作，其余操作不变。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class SortedStack {
    private Stack<Integer> s;
    public SortedStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        Stack<Integer> t = new Stack<>();
        while (!isEmpty() && s.peek() < val) {
            t.push(s.pop());
        }
        s.push(val);
        while (!t.isEmpty()) {
            s.push(t.pop());
        }
    }

    public void pop() {
        if (!isEmpty()) {
            s.pop();
        }
    }

    public int peek() {
        return isEmpty() ? -1 : s.peek();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 03.06. 动物收容所](https://leetcode-cn.com/problems/animal-shelter-lcci)

[English Version](/lcci/03.06.Animal%20Shelter/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>动物收容所。有家动物收容所只收容狗与猫，且严格遵守&ldquo;先进先出&rdquo;的原则。在收养该收容所的动物时，收养人只能收养所有动物中&ldquo;最老&rdquo;（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中&ldquo;最老&rdquo;的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如<code>enqueue</code>、<code>dequeueAny</code>、<code>dequeueDog</code>和<code>dequeueCat</code>。允许使用Java内置的LinkedList数据结构。</p>

<p><code>enqueue</code>方法有一个<code>animal</code>参数，<code>animal[0]</code>代表动物编号，<code>animal[1]</code>代表动物种类，其中 0 代表猫，1 代表狗。</p>

<p><code>dequeue*</code>方法返回一个列表<code>[动物编号, 动物种类]</code>，若没有可以收养的动物，则返回<code>[-1,-1]</code>。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueCat&quot;, &quot;dequeueDog&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [], [], []]
<strong> 输出</strong>：
[null,null,null,[0,0],[-1,-1],[1,0]]
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：
[&quot;AnimalShelf&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;enqueue&quot;, &quot;dequeueDog&quot;, &quot;dequeueCat&quot;, &quot;dequeueAny&quot;]
[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
<strong> 输出</strong>：
[null,null,null,null,[2,1],[0,0],[1,0]]
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li>收纳所的最大容量为20000</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

双队列存储。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class AnimalShelf {
    Queue<Integer> cats;
    Queue<Integer> dogs;
    public AnimalShelf() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cats.offer(animal[0]);
        } else {
            dogs.offer(animal[0]);
        }
    }

    public int[] dequeueAny() {
        return dogs.isEmpty() ? dequeueCat() : (cats.isEmpty() ? dequeueDog() : (dogs.peek() < cats.peek() ? dequeueDog() : dequeueCat()));
    }

    public int[] dequeueDog() {
        return dogs.isEmpty() ? new int[]{-1, -1} : new int[]{dogs.poll(), 1};
    }

    public int[] dequeueCat() {
        return cats.isEmpty() ? new int[]{-1, -1} : new int[]{cats.poll(), 0};
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 04.04. 检查平衡性](https://leetcode-cn.com/problems/check-balance-lcci)

[English Version](/lcci/04.04.Check%20Balance/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。</p><br><strong>示例 1:</strong><pre>给定二叉树 [3,9,20,null,null,15,7]<br>    3<br>   / &#92<br>  9  20<br>    /  &#92<br>   15   7<br>返回 true 。</pre><strong>示例 2:</strong><br><pre>给定二叉树 [1,2,2,3,3,null,null,4,4]<br>      1<br>     / &#92<br>    2   2<br>   / &#92<br>  3   3<br> / &#92<br>4   4<br>返回 false 。</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

递归法。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = height(root.left), r = height(root.right);
        return Math.abs(l - r) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 04.05. 合法二叉搜索树](https://leetcode-cn.com/problems/legal-binary-search-tree-lcci)

[English Version](/lcci/04.05.Legal%20Binary%20Search%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>实现一个函数，检查一棵二叉树是否为二叉搜索树。</p><strong>示例 1:</strong><pre><strong>输入:</strong><br>    2<br>   / &#92<br>  1   3<br><strong>输出:</strong> true<br></pre><strong>示例 2:</strong><pre><strong>输入:</strong><br>    5<br>   / &#92<br>  1   4<br>     / &#92<br>    3   6<br><strong>输出:</strong> false<br><strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。<br>     根节点的值为 5 ，但是其右子节点值为 4 。</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

一棵合法的二叉搜索树，其中序遍历的结果应该升序排列。

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    private boolean res = true;
    private Integer t = null;
    public boolean isValidBST(TreeNode root) {
        isValid(root);
        return res;
    }

    private void isValid(TreeNode root) {
        if (root == null) {
            return;
        }
        isValid(root.left);
        if (t == null || t < root.val) {
            t = root.val;
        } else {
            res = false;
            return;
        }
        isValid(root.right);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 04.08. 首个共同祖先](https://leetcode-cn.com/problems/first-common-ancestor-lcci)

[English Version](/lcci/04.08.First%20Common%20Ancestor/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。</p><p>例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]</p><pre>    3<br>   / &#92<br>  5   1<br> / &#92 / &#92<br>6  2 0  8<br>  / &#92<br> 7   4<br></pre><strong>示例 1:</strong><pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1<br><strong>输入:</strong> 3<br><strong>解释:</strong> 节点 5 和节点 1 的最近公共祖先是节点 3。</pre><strong>示例 2:</strong><pre><strong>输入:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4<br><strong>输出:</strong> 5<br><strong>解释:</strong> 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。</pre><strong>说明:</strong><pre>所有节点的值都是唯一的。<br>p、q 为不同节点且均存在于给定的二叉树中。</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 04.10. 检查子树](https://leetcode-cn.com/problems/check-subtree-lcci)

[English Version](/lcci/04.10.Check%20SubTree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。</p>

<p>如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。</p>

<p><strong>示例1:</strong></p>

<pre><strong> 输入</strong>：t1 = [1, 2, 3], t2 = [2]
<strong> 输出</strong>：true
</pre>

<p><strong>示例2:</strong></p>

<pre><strong> 输入</strong>：t1 = [1, null, 2, 4], t2 = [3, 2]
<strong> 输出</strong>：false
</pre>

<p><strong>提示：</strong></p>

<ol>
	<li>树的节点数目范围为[0, 20000]。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

先找 t1 中 t2 结点,找到后进行 DFS，确认子树和 t2 的子树完全相同，否则返回 FALSE。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        return isSubTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSubTree(TreeNode t1, TreeNode t2){
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return isSubTree(t1.left,t2.left) && isSubTree(t1.right,t2.right);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 04.12. 求和路径](https://leetcode-cn.com/problems/paths-with-sum-lcci)

[English Version](/lcci/04.12.Paths%20with%20Sum/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。</p>

<p><strong>示例:</strong><br>
给定如下二叉树，以及目标和&nbsp;<code>sum = 22</code>，</p>

<pre>              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
</pre>

<p>返回:</p>

<pre>3
<strong>解释：</strong>和为 22&nbsp;的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]</pre>

<p>提示：</p>

<ul>
	<li><code>节点总数 &lt;= 10000</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

DFS 深度优先搜索

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

采用递归的思想，每递归到某个节点时：

- 若`root.val-sum == 0`，结果加 1
- 考虑将此节点纳入或不纳入路径两种情况

特殊情况：若此节点的父节点在路径中，此节点必纳入路径（路径不能断）

```python
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def dfs(root, sum, flag):
            nonlocal ans
            if not root:
                return 0
            if sum-root.val == 0:
                ans += 1
            if flag == 0:
                dfs(root.left, sum, 0)
                dfs(root.right, sum, 0)
            dfs(root.left, sum-root.val, 1)
            dfs(root.right, sum-root.val, 1)

        if not root:
            return 0
        ans = 0
        dfs(root, sum, 0)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

使用到 2 个递归过程：

- BFS（深度优先）:(traverse)遍历每个树节点；
- DFS（广度优先）: 从每个树节点出发，节点求和，看是否能满足 sum。

需要注意，节点值有正有负，需要穷尽所有的可能路径。

```java
class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return ans;
    }

    void traverse(TreeNode root, int sum) {
        if (root == null) return;
        ans += dfs(root, sum, 0);
        traverse(root.left,  sum);
        traverse(root.right, sum);
    }

    // check if sum of path is sum.
    int dfs(TreeNode root, int sum, int cur) {
        if (root == null) return 0;
        cur += root.val;
        int res = 0;
        if (cur == sum) res++;
        res += dfs(root.left,  sum, cur);
        res += dfs(root.right, sum, cur);
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 05.01. 插入](https://leetcode-cn.com/problems/insert-into-bits-lcci)

[English Version](/lcci/05.01.Insert%20Into%20Bits/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>插入。给定两个32位的整数<code>N</code>与<code>M</code>，以及表示比特位置的<code>i</code>与<code>j</code>。编写一种方法，将<code>M</code>插入<code>N</code>，使得M从N的第j位开始，到第<code>i</code>位结束。假定从<code>j</code>位到<code>i</code>位足以容纳<code>M</code>，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：N = 10000000000, M = 10011, i = 2, j = 6
<strong> 输出</strong>：N = 10001001100
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>： N = 0, M = 11111, i = 0, j = 4
<strong> 输出</strong>：N = 11111
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            N &= ~(1 << k);
        }
        return N ^ (M << i);
    }
}
```

```aidl
延伸：
3.位异或运算（^）

运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。

比如：8^11.

8转为二进制是1000，11转为二进制是1011.从高位开始比较得到的是：0011.然后二进制转为十进制，就是Integer.parseInt("0011",2)=3;

4.位与运算符（&）

运算规则：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。

比如：129&128.

129转换成二进制就是10000001，128转换成二进制就是10000000。从高位开始比较得到，得到10000000，即128.

 

5.位或运算符（|）

运算规则：两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。

比如：129|128.

129转换成二进制就是10000001，128转换成二进制就是10000000。从高位开始比较得到，得到10000001，即129.

 

6.位非运算符（~）

运算规则：如果位为0，结果是1，如果位为1，结果是0.

比如：~37

在Java中，所有数据的表示方法都是以补码的形式表示，如果没有特殊说明，Java中的数据类型默认是int,int数据类型的长度是8位，一位是四个字节，就是32字节，32bit.

8转为二进制是100101.

补码后为： 00000000 00000000 00000000 00100101

取反为：    11111111 11111111 11111111 11011010

因为高位是1，所以原码为负数，负数的补码是其绝对值的原码取反，末尾再加1。

因此，我们可将这个二进制数的补码进行还原： 首先，末尾减1得反码：11111111 11111111 11111111 11011001 其次，将各位取反得原码：

00000000 00000000 00000000 00100110，此时二进制转原码为38

所以~37 = -38. 
```
### **...**

```

```

<!-- tabs:end -->
# [面试题 05.06. 整数转换](https://leetcode-cn.com/problems/convert-integer-lcci)

[English Version](/lcci/05.06.Convert%20Integer/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：A = 29 （或者0b11101）, B = 15（或者0b01111）
<strong> 输出</strong>：2
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>：A = 1，B = 2
<strong> 输出</strong>：2
</pre>

<p> <strong>提示:</strong></p>

<ol>
<li>A，B范围在[-2147483648, 2147483647]之间</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int convertInteger(int A, int B) {
    //bitCount实现的功能是计算一个（byte,short,char,int统一按照int方法计算）int,long类型的数值在二进制下“1”的数量。    
        return Integer.bitCount(A ^ B);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 05.07. 配对交换](https://leetcode-cn.com/problems/exchange-lcci)

[English Version](/lcci/05.07.Exchange/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：num = 2（或者0b10）
<strong> 输出</strong> 1 (或者 0b01)
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>：num = 3
<strong> 输出</strong>：3
</pre>

<p> <strong>提示:</strong></p>

<ol>
<li><code>num</code>的范围在[0, 2^30 - 1]之间，不会发生整数溢出。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int exchangeBits(int num) {
        int t1 = num >> 1;
    	int t2 = num << 1;
    	return t1 & 0x55555555 | t2 & 0xaaaaaaaa;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 08.01. 三步问题](https://leetcode-cn.com/problems/three-steps-problem-lcci)

[English Version](/lcci/08.01.Three%20Steps%20Problem/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：n = 3 
<strong> 输出</strong>：4
<strong> 说明</strong>: 有四种走法
</pre>

<p> <strong>示例2:</strong></p>

<pre>
<strong> 输入</strong>：n = 5
<strong> 输出</strong>：13
</pre>

<p> <strong>提示:</strong></p>

<ol>
<li>n范围在[1, 1000000]之间</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

递推法。`f(n)=f(n-1)+f(n-2)+f(n-3)`

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, c = 4;
        for (int i = 4; i <= n; ++i) {
            int t = a;
            a = b;
            b = c;
            c = ((a + b) % 1000000007 + t) % 1000000007;
        }
        return c;
    }
}
```

### **C++**

```cpp
class Solution {
public:
    int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, c = 4, i = 4;
        while (i++ <= n) {
            int t = ((a + b) % 1000000007 + c) % 1000000007;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }
};
```

<!-- tabs:end -->
# [面试题 08.09. 括号](https://leetcode-cn.com/problems/bracket-lcci)

[English Version](/lcci/08.09.Bracket/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。</p>

<p>说明：解集不能包含重复的子集。</p>

<p>例如，给出 n = 3，生成结果为：</p>

<pre>
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

递归求解。其中，`left` 表示剩余的 `(`，`right` 表示剩余的 `)`。

- 当 `left` > `right` 时，说明 state 中 `(` 少于 `)`，不是合法组合，直接剪枝；
- 当 `right` == 0 时，说明 state 组合完毕；
- 当 `left` > 0 时，此时可往 state 添加一个 `(`；
- 当 `right` > 0 时，此时可往 state 添加一个 `)`。

```python
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def generate(state, left, right):
            # 剩余的`(`多于`)`
            if left > right:
                return
            if right == 0:
                res.append(state)
                return
            if left > 0:
                generate(state + '(', left - 1, right)
            if right > 0:
                generate(state + ')', left, right - 1)
        generate('', n, n)
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate("", n, n);
        return res;
    }

    private void generate(String state, int left, int right) {
        if (left > right) {
            return;
        }
        if (right == 0) {
            res.add(state);
            return;
        }
        if (left > 0) {
            generate(state + "(", left - 1, right);
        }
        if (right > 0) {
            generate(state + ")", left, right - 1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 08.10. 颜色填充](https://leetcode-cn.com/problems/color-fill-lcci)

[English Version](/lcci/08.10.Color%20Fill/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>颜色填充。编写函数，实现许多图片编辑软件都支持的“颜色填充”功能。给定一个屏幕（以二维数组表示，元素为颜色值）、一个点和一个新的颜色值，将新颜色值填入这个点的周围区域，直到原来的颜色值全都改变。</p>

<p> <strong>示例1:</strong></p>

<pre>
<strong> 输入</strong>：
image = [[1,1,1],[1,1,0],[1,0,1]] 
sr = 1, sc = 1, newColor = 2
<strong> 输出</strong>：[[2,2,2],[2,2,0],[2,0,1]]
<strong> 解释</strong>: 
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。
</pre>

<p> <strong>说明：</strong></p>

<ol>
<li>image 和 image[0] 的长度在范围 [1, 50] 内。</li>
<li>给出的初始点将满足 0 &lt;= sr &lt; image.length 和 0 &lt;= sc &lt; image[0].length。</li>
<li>image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。</li>
</ol>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }

        int color = image[sr][sc];
        if (color != newColor && color == oldColor) {
            image[sr][sc] = newColor;
            // up down left right
            dfs(image, sr, sc + 1, oldColor, newColor);
            dfs(image, sr, sc - 1, oldColor, newColor);
            dfs(image, sr + 1, sc, oldColor, newColor);
            dfs(image, sr - 1, sc, oldColor, newColor);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 10.09. 排序矩阵查找](https://leetcode-cn.com/problems/sorted-matrix-search-lcci)

[English Version](/lcci/10.09.Sorted%20Matrix%20Search/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定M&times;N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。</p>

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

<!-- 这里可写通用的实现逻辑 -->

从左下角（或右上角）开始查找即可。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 16.01. 交换数字](https://leetcode-cn.com/problems/swap-numbers-lcci)

[English Version](/lcci/16.01.Swap%20Numbers/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>编写一个函数，不用临时变量，直接交换<code>numbers = [a, b]</code>中<code>a</code>与<code>b</code>的值。</p>
<p><strong>示例：</strong></p>
<pre><strong>输入:</strong> numbers = [1,2]
<strong>输出:</strong> [2,1]
</pre>
<p><strong>提示：</strong></p>
<ul>
<li><code>numbers.length == 2</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

异或运算。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1]; //3
        numbers[1] = numbers[0] ^ numbers[1]; //1
        numbers[0] = numbers[0] ^ numbers[1]; //2
        return numbers;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 16.06. 最小差](https://leetcode-cn.com/problems/smallest-difference-lcci)

[English Version](/lcci/16.06.Smallest%20Difference/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个整数数组<code>a</code>和<code>b</code>，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
<strong>输出：</strong> 3，即数值对(11, 8)
</pre>
<p><strong>提示：</strong></p>
<ul>
<li><code>1 <= a.length, b.length <= 100000</code></li>
<li><code>-2147483648 <= a[i], b[i] <= 2147483647</code></li>
<li>正确结果在区间[-2147483648, 2147483647]内</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        long res = Long.MAX_VALUE;
        while (i < m && j < n) {
            if (a[i] == b[j]) return 0;
            res = Math.min(res, Math.abs((long) a[i] - (long) b[j]));
            if (a[i] > b[j]) ++j;
            else ++i;
        }
        return (int) res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 16.10. 生存人数](https://leetcode-cn.com/problems/living-people-lcci)

[English Version](/lcci/16.10.Living%20People/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定N个人的出生年份和死亡年份，第<code>i</code>个人的出生年份为<code>birth[i]</code>，死亡年份为<code>death[i]</code>，实现一个方法以计算生存人数最多的年份。</p>
<p>你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。</p>
<p>如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>
birth = {1900, 1901, 1950}
death = {1948, 1951, 2000}
<strong>输出：</strong> 1901
</pre>
<p><strong>提示：</strong></p>
<ul>
<li><code>0 < birth.length == death.length <= 10000</code></li>
<li><code>birth[i] <= death[i]</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
# [面试题 16.11. 跳水板](https://leetcode-cn.com/problems/diving-board-lcci)

[English Version](/lcci/16.11.Diving%20Board/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为<code>shorter</code>，长度较长的木板长度为<code>longer</code>。你必须正好使用<code>k</code>块木板。编写一个方法，生成跳水板所有可能的长度。</p>
<p>返回的长度需要从小到大排列。</p>
<p><strong>示例：</strong></p>
<pre><strong>输入：</strong>
shorter = 1
longer = 2
k = 3
<strong>输出：</strong> {3,4,5,6}
</pre>
<p><strong>提示：</strong></p>
<ul>
<li>0 < shorter <= longer</li>
<li>0 <= k <= 100000</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (longer == shorter) {
            return new int[]{longer * k};
        }
        int[] ans = new int[k + 1];
        for (int i = 0;i <= k;i++) {
            ans[i] = longer * i + shorter * (k - i);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 16.21. 交换和](https://leetcode-cn.com/problems/sum-swap-lcci)

[English Version](/lcci/16.21.Sum%20Swap/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。</p>

<p>返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
<strong>输出:</strong> [1, 3]
</pre>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> array1 = <code>[1, 2, 3], array2 = [4, 5, 6]</code>
<strong>输出: </strong>[]</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= array1.length, array2.length &lt;= 100000</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

先计算两个数组的差值 `diff`，若 `diff` 为奇数，则说明无满足条件的数值，返回空数组。否则，将 `array2` 转为 `set`。然后遍历 `array1` 中的每个数 `e`，若值 `e - diff` 在 `set` 中，则说明找到满足条件的数值对。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int diff = sum(array1) - sum(array2);
        if ((diff & 1) == 1) {
            return new int[]{};
        }
        diff >>= 1;
        Set<Integer> s = Arrays.stream(array2).boxed().collect(Collectors.toSet());
        for (int e : array1) {
            if (s.contains((e - diff))) {
                return new int[]{e, e - diff};
            }
        }
        return new int[]{};
    }

    private int sum(int[] array) {
        int res = 0;
        for (int e : array) {
            res += e;
        }
        return res;
    }
}s
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.01. 不用加号的加法](https://leetcode-cn.com/problems/add-without-plus-lcci)

[English Version](/lcci/17.01.Add%20Without%20Plus/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> a = 1, b = 1
<strong>输出:</strong> 2</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>a</code>,&nbsp;<code>b</code>&nbsp;均可能是负数或 0</li>
	<li>结果不会溢出 32 位整数</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int add(int a, int b) {
        int sum = 0, carry = 0;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.04. 消失的数字](https://leetcode-cn.com/problems/missing-number-lcci)

[English Version](/lcci/17.04.Missing%20Number/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>数组<code>nums</code>包含从<code>0</code>到<code>n</code>的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？</p>

<p><strong>注意：</strong>本题相对书上原题稍作改动</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[3,0,1]
<strong>输出：</strong>2</pre>

<p>&nbsp;</p>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[9,6,4,2,3,5,7,0,1]
<strong>输出：</strong>8
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

利用异或的特性，`res = res ^ x ^ x`。对同一个值异或两次，结果等于它本身。最后异或的结果，就是只出现一次的数字，即数组中缺失的整数。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= n;
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.12. BiNode](https://leetcode-cn.com/problems/binode-lcci)

[English Version](/lcci/17.12.BiNode/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>二叉树数据结构<code>TreeNode</code>可用来表示单向链表（其中<code>left</code>置空，<code>right</code>为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。</p>

<p>返回转换后的单向链表的头节点。</p>

<p><strong>注意：</strong>本题相对原题稍作改动</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong> [4,2,5,1,3,null,6,0]
<strong>输出：</strong> [0,null,1,null,2,null,3,null,4,null,5,null,6]
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li>节点数量不会超过 100000。</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

递归将左子树、右子树转换为左、右链表 left 和 right。然后将左链表 left 的最后一个结点的 right 指针指向 root，root 的 right 指针指向右链表 right，并将 root 的 left 指针值为空。

同 [897. 递增顺序查找树](/solution/0800-0899/0897.Increasing%20Order%20Search%20Tree/README.md)。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

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
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) return null;
        TreeNode left = convertBiNode(root.left);
        TreeNode right = convertBiNode(root.right);
        if (left == null) {
            root.right = right;
            return root;
        }
        TreeNode res = left;
        while (left != null && left.right != null) {
            left = left.right;
        }
        left.right = root;
        root.right = right;
        root.left = null;
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.13. 恢复空格](https://leetcode-cn.com/problems/re-space-lcci)

[English Version](/lcci/17.13.Re-Space/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子<code>&quot;I reset the computer. It still didn&rsquo;t boot!&quot;</code>已经变成了<code>&quot;iresetthecomputeritstilldidntboot&quot;</code>。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典<code>dictionary</code>，不过，有些词没在词典里。假设文章用<code>sentence</code>表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。</p>

<p><strong>注意：</strong>本题相对原题稍作改动，只需返回未识别的字符数</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>
dictionary = [&quot;looked&quot;,&quot;just&quot;,&quot;like&quot;,&quot;her&quot;,&quot;brother&quot;]
sentence = &quot;jesslookedjustliketimherbrother&quot;
<strong>输出：</strong> 7
<strong>解释：</strong> 断句后为&quot;<strong>jess</strong> looked just like <strong>tim</strong> her brother&quot;，共7个未识别字符。
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= len(sentence) &lt;= 1000</code></li>
	<li><code>dictionary</code>中总字符数不超过 150000。</li>
	<li>你可以认为<code>dictionary</code>和<code>sentence</code>中只包含小写字母。</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->


### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary.length);
        set.addAll(Arrays.asList(dictionary));

        int[] dp = new int[sentence.length() + 1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0;j < i;j++) {
                if (set.contains(sentence.substring(j, i))) {
                     dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[sentence.length()];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.19. 消失的两个数字](https://leetcode-cn.com/problems/missing-two-lcci)

[English Version](/lcci/17.19.Missing%20Two/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？</p>

<p>以任意顺序返回这两个数字均可。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> <code>[1]</code>
<strong>输出: </strong>[2,3]</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> <code>[2,3]</code>
<strong>输出: </strong>[1,4]</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums.length &lt;=&nbsp;30000</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

异或运算。与[面试题 56 - I. 数组中数字出现的次数](/lcof/面试题56%20-%20I.%20数组中数字出现的次数/README.md) 类似。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] missingTwo(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            res ^= nums[i];
            res ^= (i + 1);
        }
        res ^= (n + 1);
        res ^= (n + 2);

        int pos = 0;
        while ((res & 1) == 0) {
            pos += 1;
            res >>= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            int t = num >> pos;
            if ((t & 1) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for (int i = 1; i <= n + 2; ++i) {
            int t = i >> pos;
            if ((t & 1) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
# [面试题 17.20. 连续中值](https://leetcode-cn.com/problems/continuous-median-lcci)

[English Version](/lcci/17.20.Continuous%20Median/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。</p>

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
findMedian() -&gt; 2
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

- 创建大根堆、小根堆，其中：大根堆存放较小的一半元素，小根堆存放较大的一半元素。
- 添加元素时，若两堆元素个数相等，放入小根堆（使得小根堆个数多 1）；若不等，放入大根堆（使得大小根堆元素个数相等）
- 取中位数时，若两堆元素个数相等，取两堆顶求平均值；若不等，取小根堆堆顶。

<!-- tabs:start -->

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        //PriorityQueue是基于优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。    
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```

### **...**

```

```

<!-- tabs:end -->



## 题解

以下所有题目均来源 [LeetCode 中国官网](https://leetcode-cn.com/problemset/lcci/)，题解由 [doocs/leetcode 贡献者](https://github.com/doocs/leetcode/graphs/contributors) 提供，正在完善中，欢迎贡献你的题解！

快速搜索题号、题解、标签等，请善用 <kbd>Control</kbd>+<kbd>F</kbd>（或者 <kbd>Command</kbd>+<kbd>F</kbd>）。

| 题号                                                                            | 题解                                                                             | 标签                                          | 难度 |
| ------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | --------------------------------------------- | ---- |
| [01.01](https://leetcode-cn.com/problems/is-unique-lcci)                        | [判定字符是否唯一](/lcci/01.01.Is%20Unique/README.md)                            | `数组`                                        | 简单 |
| [01.02](https://leetcode-cn.com/problems/check-permutation-lcci)                | [判定是否互为字符重排](/lcci/01.02.Check%20Permutation/README.md)                | `数组`,`字符串`                               | 简单 |
| [01.03](https://leetcode-cn.com/problems/string-to-url-lcci)                    | [URL 化](/lcci/01.03.String%20to%20URL/README.md)                                | `字符串`                                      | 简单 |
| [01.04](https://leetcode-cn.com/problems/palindrome-permutation-lcci)           | [回文排列](/lcci/01.04.Palindrome%20Permutation/README.md)                       | `哈希表`,`字符串`                             | 简单 |
| [01.05](https://leetcode-cn.com/problems/one-away-lcci)                         | [一次编辑](/lcci/01.05.One%20Away/README.md)                                     | `字符串`,`动态规划`                           | 中等 |
| [01.06](https://leetcode-cn.com/problems/compress-string-lcci)                  | [字符串压缩](/lcci/01.06.Compress%20String/README.md)                            | `字符串`                                      | 简单 |
| [01.07](https://leetcode-cn.com/problems/rotate-matrix-lcci)                    | [旋转矩阵](/lcci/01.07.Rotate%20Matrix/README.md)                                | `数组`                                        | 中等 |
| [01.08](https://leetcode-cn.com/problems/zero-matrix-lcci)                      | [零矩阵](/lcci/01.08.Zero%20Matrix/README.md)                                    | `数组`                                        | 中等 |
| [01.09](https://leetcode-cn.com/problems/string-rotation-lcci)                  | [字符串轮转](/lcci/01.09.String%20Rotation/README.md)                            | `字符串`                                      | 简单 |
| [02.01](https://leetcode-cn.com/problems/remove-duplicate-node-lcci)            | [移除重复节点](/lcci/02.01.Remove%20Duplicate%20Node/README.md)                  | `链表`                                        | 简单 |
| [02.02](https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci)        | [返回倒数第 k 个节点](/lcci/02.02.Kth%20Node%20From%20End%20of%20List/README.md) | `链表`,`双指针`                               | 简单 |
| [02.03](https://leetcode-cn.com/problems/delete-middle-node-lcci)               | [删除中间节点](/lcci/02.03.Delete%20Middle%20Node/README.md)                     | `链表`                                        | 简单 |
| [02.04](https://leetcode-cn.com/problems/partition-list-lcci)                   | [分割链表](/lcci/02.04.Partition%20List/README.md)                               | `链表`,`双指针`                               | 中等 |
| [02.05](https://leetcode-cn.com/problems/sum-lists-lcci)                        | [链表求和](/lcci/02.05.Sum%20Lists/README.md)                                    | `链表`,`数学`                                 | 中等 |
| [02.06](https://leetcode-cn.com/problems/palindrome-linked-list-lcci)           | [回文链表](/lcci/02.06.Palindrome%20Linked%20List/README.md)                     | `链表`                                        | 简单 |
| [02.07](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci) | [链表相交](/lcci/02.07.Intersection%20of%20Two%20Linked%20Lists/README.md)       | `链表`                                        | 简单 |
| [02.08](https://leetcode-cn.com/problems/linked-list-cycle-lcci)                | [环路检测](/lcci/02.08.Linked%20List%20Cycle/README.md)                          | `链表`                                        | 中等 |
| [03.01](https://leetcode-cn.com/problems/three-in-one-lcci)                     | [三合一](/lcci/03.01.Three%20in%20One/README.md)                                 | `设计`                                        | 简单 |
| [03.02](https://leetcode-cn.com/problems/min-stack-lcci)                        | [栈的最小值](/lcci/03.02.Min%20Stack/README.md)                                  | `栈`                                          | 简单 |
| [03.03](https://leetcode-cn.com/problems/stack-of-plates-lcci)                  | [堆盘子](/lcci/03.03.Stack%20of%20Plates/README.md)                              | `设计`                                        | 中等 |
| [03.04](https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci)     | [化栈为队](/lcci/03.04.Implement%20Queue%20using%20Stacks/README.md)             | `栈`                                          | 简单 |
| [03.05](https://leetcode-cn.com/problems/sort-of-stacks-lcci)                   | [栈排序](/lcci/03.05.Sort%20of%20Stacks/README.md)                               | `设计`                                        | 中等 |
| [03.06](https://leetcode-cn.com/problems/animal-shelter-lcci)                   | [动物收容所](/lcci/03.06.Animal%20Shelter/README.md)                             | `设计`                                        | 简单 |
| [04.01](https://leetcode-cn.com/problems/route-between-nodes-lcci)              | [节点间通路](/lcci/04.01.Route%20Between%20Nodes/README.md)                      | `图`                                          | 中等 |
| [04.02](https://leetcode-cn.com/problems/minimum-height-tree-lcci)              | [最小高度树](/lcci/04.02.Minimum%20Height%20Tree/README.md)                      | `树`,`深度优先搜索`                           | 简单 |
| [04.03](https://leetcode-cn.com/problems/list-of-depth-lcci)                    | [特定深度节点链表](/lcci/04.03.List%20of%20Depth/README.md)                      | `树`,`广度优先搜索`                           | 中等 |
| [04.04](https://leetcode-cn.com/problems/check-balance-lcci)                    | [检查平衡性](/lcci/04.04.Check%20Balance/README.md)                              | `树`,`深度优先搜索`                           | 简单 |
| [04.05](https://leetcode-cn.com/problems/legal-binary-search-tree-lcci)         | [合法二叉搜索树](/lcci/04.05.Legal%20Binary%20Search%20Tree/README.md)           | `树`,`深度优先搜索`                           | 中等 |
| [04.06](https://leetcode-cn.com/problems/successor-lcci)                        | [后继者](/lcci/04.06.Successor/README.md)                                        | `树`,`深度优先搜索`                           | 中等 |
| [04.08](https://leetcode-cn.com/problems/first-common-ancestor-lcci)            | [首个共同祖先](/lcci/04.08.First%20Common%20Ancestor/README.md)                  | `树`                                          | 中等 |
| [04.09](https://leetcode-cn.com/problems/bst-sequences-lcci)                    | [二叉搜索树序列](/lcci/04.09.BST%20Sequences/README.md)                          | `树`,`动态规划`                               | 困难 |
| [04.10](https://leetcode-cn.com/problems/check-subtree-lcci)                    | [检查子树](/lcci/04.10.Check%20SubTree/README.md)                                | `树`                                          | 中等 |
| [04.12](https://leetcode-cn.com/problems/paths-with-sum-lcci)                   | [求和路径](/lcci/04.12.Paths%20with%20Sum/README.md)                             | `树`,`深度优先搜索`                           | 中等 |
| [05.01](https://leetcode-cn.com/problems/insert-into-bits-lcci)                 | [插入](/lcci/05.01.Insert%20Into%20Bits/README.md)                               | `位运算`                                      | 简单 |
| [05.02](https://leetcode-cn.com/problems/bianry-number-to-string-lcci)          | [二进制数转字符串](/lcci/05.02.Bianry%20Number%20to%20String/README.md)          | `字符串`                                      | 中等 |
| [05.03](https://leetcode-cn.com/problems/reverse-bits-lcci)                     | [翻转数位](/lcci/05.03.Reverse%20Bits/README.md)                                 | `位运算`                                      | 简单 |
| [05.04](https://leetcode-cn.com/problems/closed-number-lcci)                    | [下一个数](/lcci/05.04.Closed%20Number/README.md)                                | `位运算`                                      | 中等 |
| [05.06](https://leetcode-cn.com/problems/convert-integer-lcci)                  | [整数转换](/lcci/05.06.Convert%20Integer/README.md)                              | `位运算`                                      | 简单 |
| [05.07](https://leetcode-cn.com/problems/exchange-lcci)                         | [配对交换](/lcci/05.07.Exchange/README.md)                                       | `位运算`                                      | 简单 |
| [05.08](https://leetcode-cn.com/problems/draw-line-lcci)                        | [绘制直线](/lcci/05.08.Draw%20Line/README.md)                                    | `数组`                                        | 中等 |
| [08.01](https://leetcode-cn.com/problems/three-steps-problem-lcci)              | [三步问题](/lcci/08.01.Three%20Steps%20Problem/README.md)                        | `动态规划`                                    | 简单 |
| [08.02](https://leetcode-cn.com/problems/robot-in-a-grid-lcci)                  | [迷路的机器人](/lcci/08.02.Robot%20in%20a%20Grid/README.md)                      | `动态规划`                                    | 中等 |
| [08.03](https://leetcode-cn.com/problems/magic-index-lcci)                      | [魔术索引](/lcci/08.03.Magic%20Index/README.md)                                  | `数组`,`二分查找`                             | 简单 |
| [08.04](https://leetcode-cn.com/problems/power-set-lcci)                        | [幂集](/lcci/08.04.Power%20Set/README.md)                                        | `位运算`,`数组`,`回溯算法`                    | 中等 |
| [08.05](https://leetcode-cn.com/problems/recursive-mulitply-lcci)               | [递归乘法](/lcci/08.05.Recursive%20Mulitply/README.md)                           | `递归`                                        | 中等 |
| [08.06](https://leetcode-cn.com/problems/hanota-lcci)                           | [汉诺塔问题](/lcci/08.06.Hanota/README.md)                                       | `递归`                                        | 简单 |
| [08.07](https://leetcode-cn.com/problems/permutation-i-lcci)                    | [无重复字符串的排列组合](/lcci/08.07.Permutation%20I/README.md)                  | `回溯算法`                                    | 中等 |
| [08.08](https://leetcode-cn.com/problems/permutation-ii-lcci)                   | [有重复字符串的排列组合](/lcci/08.08.Permutation%20II/README.md)                 | `回溯算法`                                    | 中等 |
| [08.09](https://leetcode-cn.com/problems/bracket-lcci)                          | [括号](/lcci/08.09.Bracket/README.md)                                            | `字符串`,`回溯算法`                           | 中等 |
| [08.10](https://leetcode-cn.com/problems/color-fill-lcci)                       | [颜色填充](/lcci/08.10.Color%20Fill/README.md)                                   | `深度优先搜索`                                | 简单 |
| [08.11](https://leetcode-cn.com/problems/coin-lcci)                             | [硬币](/lcci/08.11.Coin/README.md)                                               | `动态规划`                                    | 中等 |
| [08.12](https://leetcode-cn.com/problems/eight-queens-lcci)                     | [八皇后](/lcci/08.12.Eight%20Queens/README.md)                                   | `回溯算法`                                    | 困难 |
| [08.13](https://leetcode-cn.com/problems/pile-box-lcci)                         | [堆箱子](/lcci/08.13.Pile%20Box/README.md)                                       | `动态规划`,`回溯算法`                         | 困难 |
| [08.14](https://leetcode-cn.com/problems/boolean-evaluation-lcci)               | [布尔运算](/lcci/08.14.Boolean%20Evaluation/README.md)                           | `栈`,`字符串`                                 | 中等 |
| [10.01](https://leetcode-cn.com/problems/sorted-merge-lcci)                     | [合并排序的数组](/lcci/10.01.Sorted%20Merge/README.md)                           | `数组`,`双指针`                               | 简单 |
| [10.02](https://leetcode-cn.com/problems/group-anagrams-lcci)                   | [变位词组](/lcci/10.02.Group%20Anagrams/README.md)                               | `哈希表`,`字符串`                             | 中等 |
| [10.03](https://leetcode-cn.com/problems/search-rotate-array-lcci)              | [搜索旋转数组](/lcci/10.03.Search%20Rotate%20Array/README.md)                    | `数组`,`二分查找`                             | 中等 |
| [10.05](https://leetcode-cn.com/problems/sparse-array-search-lcci)              | [稀疏数组搜索](/lcci/10.05.Sparse%20Array%20Search/README.md)                    | `二分查找`                                    | 简单 |
| [10.09](https://leetcode-cn.com/problems/sorted-matrix-search-lcci)             | [排序矩阵查找](/lcci/10.09.Sorted%20Matrix%20Search/README.md)                   | `双指针`,`二分查找`,`分治算法`                | 中等 |
| [10.10](https://leetcode-cn.com/problems/rank-from-stream-lcci)                 | [数字流的秩](/lcci/10.10.Rank%20from%20Stream/README.md)                         |                                               | 中等 |
| [10.11](https://leetcode-cn.com/problems/peaks-and-valleys-lcci)                | [峰与谷](/lcci/10.11.Peaks%20and%20Valleys/README.md)                            |                                               | 中等 |
| [16.01](https://leetcode-cn.com/problems/swap-numbers-lcci)                     | [交换数字](/lcci/16.01.Swap%20Numbers/README.md)                                 | `位运算`,`数学`                               | 中等 |
| [16.02](https://leetcode-cn.com/problems/words-frequency-lcci)                  | [单词频率](/lcci/16.02.Words%20Frequency/README.md)                              | `设计`,`哈希表`                               | 中等 |
| [16.03](https://leetcode-cn.com/problems/intersection-lcci)                     | [交点](/lcci/16.03.Intersection/README.md)                                       | `几何`,`数学`                                 | 困难 |
| [16.04](https://leetcode-cn.com/problems/tic-tac-toe-lcci)                      | [井字游戏](/lcci/16.04.Tic-Tac-Toe/README.md)                                    | `数组`                                        | 中等 |
| [16.05](https://leetcode-cn.com/problems/factorial-zeros-lcci)                  | [阶乘尾数](/lcci/16.05.Factorial%20Zeros/README.md)                              | `数学`                                        | 简单 |
| [16.06](https://leetcode-cn.com/problems/smallest-difference-lcci)              | [最小差](/lcci/16.06.Smallest%20Difference/README.md)                            | `数组`,`双指针`                               | 中等 |
| [16.07](https://leetcode-cn.com/problems/maximum-lcci)                          | [最大数值](/lcci/16.07.Maximum/README.md)                                        | `位运算`,`数学`                               | 简单 |
| [16.08](https://leetcode-cn.com/problems/english-int-lcci)                      | [整数的英语表示](/lcci/16.08.English%20Int/README.md)                            | `数学`,`字符串`                               | 困难 |
| [16.09](https://leetcode-cn.com/problems/operations-lcci)                       | [运算](/lcci/16.09.Operations/README.md)                                         | `设计`                                        | 中等 |
| [16.10](https://leetcode-cn.com/problems/living-people-lcci)                    | [生存人数](/lcci/16.10.Living%20People/README.md)                                | `数组`                                        | 中等 |
| [16.11](https://leetcode-cn.com/problems/diving-board-lcci)                     | [跳水板](/lcci/16.11.Diving%20Board/README.md)                                   | `递归`,`记忆化`                               | 简单 |
| [16.13](https://leetcode-cn.com/problems/bisect-squares-lcci)                   | [平分正方形](/lcci/16.13.Bisect%20Squares/README.md)                             | `几何`                                        | 中等 |
| [16.14](https://leetcode-cn.com/problems/best-line-lcci)                        | [最佳直线](/lcci/16.14.Best%20Line/README.md)                                    | `几何`,`哈希表`                               | 中等 |
| [16.15](https://leetcode-cn.com/problems/master-mind-lcci)                      | [珠玑妙算](/lcci/16.15.Master%20Mind/README.md)                                  | `数组`                                        | 简单 |
| [16.16](https://leetcode-cn.com/problems/sub-sort-lcci)                         | [部分排序](/lcci/16.16.Sub%20Sort/README.md)                                     | `排序`,`数组`                                 | 中等 |
| [16.17](https://leetcode-cn.com/problems/contiguous-sequence-lcci)              | [连续数列](/lcci/16.17.Contiguous%20Sequence/README.md)                          | `数组`,`分治算法`,`动态规划`                  | 简单 |
| [16.18](https://leetcode-cn.com/problems/pattern-matching-lcci)                 | [模式匹配](/lcci/16.18.Pattern%20Matching/README.md)                             | `字符串`                                      | 中等 |
| [16.19](https://leetcode-cn.com/problems/pond-sizes-lcci)                       | [水域大小](/lcci/16.19.Pond%20Sizes/README.md)                                   | `深度优先搜索`,`广度优先搜索`                 | 中等 |
| [16.20](https://leetcode-cn.com/problems/t9-lcci)                               | [T9 键盘](/lcci/16.20.T9/README.md)                                              | `数组`                                        | 中等 |
| [16.21](https://leetcode-cn.com/problems/sum-swap-lcci)                         | [交换和](/lcci/16.21.Sum%20Swap/README.md)                                       | `排序`,`数组`                                 | 中等 |
| [16.22](https://leetcode-cn.com/problems/langtons-ant-lcci)                     | [兰顿蚂蚁](/lcci/16.22.Langtons%20Ant/README.md)                                 | `数组`                                        | 中等 |
| [16.24](https://leetcode-cn.com/problems/pairs-with-sum-lcci)                   | [数对和](/lcci/16.24.Pairs%20With%20Sum/README.md)                               | `数组`,`哈希表`                               | 中等 |
| [16.25](https://leetcode-cn.com/problems/lru-cache-lcci)                        | [LRU 缓存](/lcci/16.25.LRU%20Cache/README.md)                                    | `设计`                                        | 中等 |
| [16.26](https://leetcode-cn.com/problems/calculator-lcci)                       | [计算器](/lcci/16.26.Calculator/README.md)                                       | `字符串`                                      | 中等 |
| [17.01](https://leetcode-cn.com/problems/add-without-plus-lcci)                 | [不用加号的加法](/lcci/17.01.Add%20Without%20Plus/README.md)                     | `位运算`                                      | 简单 |
| [17.04](https://leetcode-cn.com/problems/missing-number-lcci)                   | [消失的数字](/lcci/17.04.Missing%20Number/README.md)                             | `位运算`,`数组`,`数学`                        | 简单 |
| [17.05](https://leetcode-cn.com/problems/find-longest-subarray-lcci)            | [ 字母与数字](/lcci/17.05.Find%20Longest%20Subarray/README.md)                   | `数组`                                        | 中等 |
| [17.06](https://leetcode-cn.com/problems/number-of-2s-in-range-lcci)            | [2 出现的次数](/lcci/17.06.Number%20Of%202s%20In%20Range/README.md)              | `数学`,`动态规划`                             | 中等 |
| [17.07](https://leetcode-cn.com/problems/baby-names-lcci)                       | [婴儿名字](/lcci/17.07.Baby%20Names/README.md)                                   | `深度优先搜索`,`广度优先搜索`,`并查集`        | 中等 |
| [17.08](https://leetcode-cn.com/problems/circus-tower-lcci)                     | [马戏团人塔](/lcci/17.08.Circus%20Tower/README.md)                               | `排序`,`二分查找`,`动态规划`                  | 中等 |
| [17.09](https://leetcode-cn.com/problems/get-kth-magic-number-lcci)             | [第 k 个数](/lcci/17.09.Get%20Kth%20Magic%20Number/README.md)                    | `堆`,`队列`,`数学`                            | 中等 |
| [17.10](https://leetcode-cn.com/problems/find-majority-element-lcci)            | [主要元素](/lcci/17.10.Find%20Majority%20Element/README.md)                      | `位运算`,`数组`,`分治算法`                    | 简单 |
| [17.11](https://leetcode-cn.com/problems/find-closest-lcci)                     | [单词距离](/lcci/17.11.Find%20Closest/README.md)                                 | `双指针`,`字符串`                             | 中等 |
| [17.12](https://leetcode-cn.com/problems/binode-lcci)                           | [BiNode](/lcci/17.12.BiNode/README.md)                                           | `树`,`二叉搜索树`,`递归`                      | 简单 |
| [17.13](https://leetcode-cn.com/problems/re-space-lcci)                         | [恢复空格](/lcci/17.13.Re-Space/README.md)                                       | `记忆化`,`字符串`                             | 中等 |
| [17.14](https://leetcode-cn.com/problems/smallest-k-lcci)                       | [最小 K 个数](/lcci/17.14.Smallest%20K/README.md)                                | `堆`,`排序`,`分治算法`                        | 中等 |
| [17.15](https://leetcode-cn.com/problems/longest-word-lcci)                     | [最长单词](/lcci/17.15.Longest%20Word/README.md)                                 | `字符串`                                      | 中等 |
| [17.16](https://leetcode-cn.com/problems/the-masseuse-lcci)                     | [按摩师](/lcci/17.16.The%20Masseuse/README.md)                                   | `动态规划`                                    | 简单 |
| [17.17](https://leetcode-cn.com/problems/multi-search-lcci)                     | [多次搜索](/lcci/17.17.Multi%20Search/README.md)                                 | `字典树`,`字符串`                             | 中等 |
| [17.18](https://leetcode-cn.com/problems/shortest-supersequence-lcci)           | [最短超串](/lcci/17.18.Shortest%20Supersequence/README.md)                       | `None`                                        | 中等 |
| [17.19](https://leetcode-cn.com/problems/missing-two-lcci)                      | [消失的两个数字](/lcci/17.19.Missing%20Two/README.md)                            | `数组`,`数学`                                 | 困难 |
| [17.20](https://leetcode-cn.com/problems/continuous-median-lcci)                | [连续中值](/lcci/17.20.Continuous%20Median/README.md)                            | `堆`                                          | 困难 |
| [17.21](https://leetcode-cn.com/problems/volume-of-histogram-lcci)              | [直方图的水量](/lcci/17.21.Volume%20of%20Histogram/README.md)                    | `栈`,`数组`,`双指针`                          | 困难 |
| [17.22](https://leetcode-cn.com/problems/word-transformer-lcci)                 | [单词转换](/lcci/17.22.Word%20Transformer/README.md)                             | `深度优先搜索`,`广度优先搜索`,`数组`,`字符串` | 中等 |
| [17.23](https://leetcode-cn.com/problems/max-black-square-lcci)                 | [最大黑方阵](/lcci/17.23.Max%20Black%20Square/README.md)                         | `动态规划`                                    | 中等 |
| [17.24](https://leetcode-cn.com/problems/max-submatrix-lcci)                    | [最大子矩阵](/lcci/17.24.Max%20Submatrix/README.md)                              | `动态规划`                                    | 困难 |
| [17.25](https://leetcode-cn.com/problems/word-rectangle-lcci)                   | [单词矩阵](/lcci/17.25.Word%20Rectangle/README.md)                               |                                               | 困难 |
| [17.26](https://leetcode-cn.com/problems/sparse-similarity-lcci)                | [稀疏相似度](/lcci/17.26.Sparse%20Similarity/README.md)                          | `哈希表`                                      | 困难 |

## 版权

著作权归 [GitHub 开源社区 Doocs](https://github.com/doocs) 所有，商业转载请联系 [@yanglbme](mailto:contact@yanglibin.info) 授权，非商业转载请注明出处。
