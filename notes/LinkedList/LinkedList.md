# [面试题 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
## 题目描述
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
**示例 1：**
```
输入：head = [1,3,2]
输出：[2,3,1]
```
**限制：**
- `0 <= 链表长度 <= 10000`
## 解法
栈实现。或者其它方式，见题解。
### **Java**
- 栈实现：
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
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            res[i++] = s.pop();
        }
        return res;
    }
}
```
- 先计算链表长度 n，然后创建一个长度为 n 的结果数组。最后遍历链表，依次将节点值存放在数组上（从后往前）。
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
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        // 计算链表长度n
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int[] res = new int[n];
        cur = head;
        while (cur != null) {
            res[--n] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
```
# [面试题 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)
## 题目描述
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
注意：此题对比[原题](/solution/0200-0299/0237.Delete%20Node%20in%20a%20Linked%20List/README.md)有改动。
**示例 1:**
```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```
**示例 2:**
```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```
**说明：**
- 题目保证链表中节点的值互不相同
- 若使用 C 或 C++ 语言，你不需要 `free` 或 `delete` 被删除的节点
## 解法
定义一个虚拟头节点 `dummy` 指向 `head`，`pre` 指针初始指向 `dummy`。
循环遍历链表，`pre` 往后移动。当指针 `pre.next` 指向的节点的值等于 `val` 时退出循环，将 `pre.next` 指向 `pre.next.next`，然后返回 `dummy.next`。
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
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val != val) {
            pre = pre.next;
        }
        pre.next = pre.next == null ? null : pre.next.next;
        return dummy.next;
    }
}
```
# [面试题 22. 链表中倒数第 k 个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
## 题目描述
输入一个链表，输出该链表中倒数第 k 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
**示例：**
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
## 解法
定义快慢指针 `slow`、`fast`，初始指向 `head`。
`fast` 先向前走 `k` 步，接着 `slow`、`fast` 同时向前走，当 `fast` 指向 `null` 时，`slow` 指向的节点即为链表的倒数第 `k` 个节点。
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
```
# [面试题 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)
## 题目描述
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
**示例:**
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```
**限制：**
- `0 <= 节点个数 <= 5000`
## 解法
定义指针 `pre`，`cur` 分别指向 null 和头节点。
遍历链表，将 `cur.next` 临时保存到 `t` 中，然后改变指针 `cur` 指向的节点的指向，将其指向 `pre` 指针指向的节点，即 `cur.next = pre`。然后 `pre` 指针指向 `cur`，`cur` 指针往前走。
当遍历结束后，返回 `pre` 指针即可。
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
}
```
# [面试题 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)
## 题目描述
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
**示例 1：**
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```
**限制：**
- `0 <= 链表长度 <= 1000`
## 解法
同时遍历两个链表，归并插入新链表中即可。
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
```
# [面试题 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)
## 题目描述
请实现 `copyRandomList` 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 `next` 指针指向下一个节点，还有一个 `random` 指针指向链表中的任意节点或者 `null`。
**示例 1：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719005831426.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```
**示例 2：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719005846979.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)

```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```
**示例 3：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719005903171.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)
```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```
**示例 4：**
```
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
```
**提示：**
- `-10000 <= Node.val <= 10000`
- `Node.random`  为空（null）或指向链表中的节点。
- 节点数目不超过 1000 。
## 解法
### **Java**
```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(-1);
        Node cur = copyHead, t = head;
        while (t != null) {
            Node node = new Node(t.val);
            map.put(t, node);
            cur.next = node;
            cur = node;
            t = t.next;
        }
        cur = copyHead.next;
        while (head != null) {
            cur.random = map.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        return copyHead.next;
    }
}
```
# [面试题 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)
## 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
为了让您更好地理解问题，以下面的二叉搜索树为例：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021071900594473.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719005954751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
**注意**：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
**注意**：此题对比原题有改动。
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
    Node head;
    Node pre;
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
# [面试题 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
## 题目描述
输入两个链表，找出它们的第一个公共节点。
如下面的两个链表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719010042630.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


在节点 c1 开始相交。
**示例 1：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719010057750.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```
**示例  2：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/202107190101105.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)


```
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
```
**示例  3：**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210719010121225.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjY1Njcz,size_16,color_FFFFFF,t_70)

```
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
```
**注意：**
- 如果两个链表没有交点，返回 `null`。
- 在返回结果后，两个链表仍须保持原有的结构。
- 可假定整个链表结构中没有循环。
- 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
## 解法
先求出两个链表的长度差 `len1-len2`，之后遍历链表，长的链表先走 `len1-len2` 步。
接着两个链表同时走，当出现相同的节点时，说明两个链表在此节点相交，返回此节点，否则返回 `null`。
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
        ListNode p = headA, q = headB;
        int len1 = len(p), len2 = len(q);
        if (len1 > len2) {
            ListNode t = headA;
            headA = headB;
            headB = t;
        }
        p = headA;
        q = headB;
        for (int i = 0; i < Math.abs(len1 - len2); ++i) {
            q = q.next;
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
    private int len(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            ++len;
        }
        return len;
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

