# [449. 序列化和反序列化二叉搜索树](https://leetcode-cn.com/problems/serialize-and-deserialize-bst)

[English Version](/solution/0400-0499/0449.Serialize%20and%20Deserialize%20BST/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。</p>

<p>设计一个算法来序列化和反序列化<strong>二叉搜索树</strong>。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。</p>

<p><strong>编码的字符串应尽可能紧凑。</strong></p>

<p><strong>注意</strong>：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。</p>

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

### **...**

```

```

<!-- tabs:end -->
