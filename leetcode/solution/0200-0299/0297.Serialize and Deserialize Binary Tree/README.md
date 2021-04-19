# [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree)

[English Version](/solution/0200-0299/0297.Serialize%20and%20Deserialize%20Binary%20Tree/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
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

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

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

### **...**

```

```

<!-- tabs:end -->
