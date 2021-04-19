# [510. 二叉搜索树中的中序后继 II](https://leetcode-cn.com/problems/inorder-successor-in-bst-ii)

[English Version](/solution/0500-0599/0510.Inorder%20Successor%20in%20BST%20II/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一棵二叉搜索树和其中的一个节点 <code>node</code> ，找到该节点在树中的中序后继。</p>

<p>如果节点没有中序后继，请返回 <code>null</code> 。</p>

<p>一个结点 <code>node</code> 的中序后继是键值比 <code>node.val</code>大所有的结点中键值最小的那个。</p>

<p>你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。节点定义如下：</p>

<pre>class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}</pre>

<p> </p>

<p><strong>进阶：</strong></p>

<p>你能否在不访问任何结点的值的情况下解决问题?</p>

<p> </p>

<p><strong>示例 1:</strong></p>

![](./images/285_example_1.png)

<pre><strong>输入: </strong>tree = [2,1,3], node = 1
<strong>输出: </strong>2
<strong>解析: </strong>1 的中序后继结点是 2 。注意节点和返回值都是 Node 类型的。
</pre>

<p><strong>示例 2:</strong></p>

![](./images/285_example_2.png)

<pre><strong>输入: </strong>tree = [5,3,6,2,4,null,null,1], node = 6
<strong>输出: </strong>null
<strong>解析: </strong>该结点没有中序后继，因此返回<code> null 。</code>
</pre>

<p><strong>示例 3:</strong></p>

![](./images/285_example_34.png)

<pre><strong>输入: </strong>tree = [15,6,18,3,7,17,20,2,4,null,13,null,null,null,null,null,null,null,null,9], node = 15
<strong>输出: </strong>17
</pre>

<p><strong>示例 4:</strong></p>

![](./images/285_example_34.png)

<pre><strong>输入: </strong>tree = [15,6,18,3,7,17,20,2,4,null,13,null,null,null,null,null,null,null,null,9], node = 13
<strong>输出: </strong>15
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>-10^5 <= Node.val <= 10^5</code></li>
	<li><code>1 <= Number of Nodes <= 10^4</code></li>
	<li>树中各结点的值均保证唯一。</li>
</ol>

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

```

### **...**

```

```

<!-- tabs:end -->
