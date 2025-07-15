package org.example.tools.listnode;


import org.example.datastructure.TreeNode;

public class TreeNodeUtils {
    public static void printTree(TreeNode root) {
        printNode(root, "", false);
    }

    private static void printNode(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + (isLeft ? "├──" : "└──") + node.val);
        printNode(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printNode(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    /*
      构建一个二叉树
      @return TreeNode
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
     */
    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.parent = root;
//        root.right.parent = root;
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.left.left.parent = root.left;
//        root.left.right.parent = root.left;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        root.right.left.parent = root.right;
//        root.right.right.parent = root.right;
        return root;
    }
}
