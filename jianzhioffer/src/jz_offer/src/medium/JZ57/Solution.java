package jz_offer.src.medium.JZ57;

import datastructure.TreeLinkNode;
import tools.listnode.ListNodeUtils;

import tools.listnode.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeLinkNode> list = new ArrayList<>();

    public static void main(String[] args) {
        // 构建节点
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        // 构建树结构
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;

        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;

        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;

        Solution solution = new Solution();
//        TreeLinkNode result1 = solution.getNext(node1);
        TreeLinkNode result2 = solution.getNextNode(node1,node2);
        TreeNodeUtils.printTree(node1);
//        TreeLinkNodeUtils.printTree(result1);
        TreeNodeUtils.printTree(result2);
        System.out.println();
    }

//    public TreeLinkNode getNext(TreeLinkNode pNode) {
//        TreeLinkNode node = pNode;
//        while (node.parent != null) {
//            node = node.parent;
//        }
//        inOrder(node);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (pNode == list.get(i)) return list.get(i + 1);
//        }
//        return null;
//    }
//
//    public void inOrder(TreeLinkNode node) {
//        if (node != null) {
//            inOrder((TreeLinkNode) node.left);
//            list.add(node);
//            inOrder((TreeLinkNode) node.right);
//        }
//    }

    /**
     * 查找节点
     * @param root 根节点
     * @param node 要查找的节点
     * @return 中序遍历下一个节点
     */
    public TreeLinkNode getNextNode(TreeLinkNode root, TreeLinkNode node) {
        if (node == null || root == null) {
            return null;
        }

        if (node.right != null) { // 有右子树
            TreeLinkNode next =(TreeLinkNode) node.right;
            while (next.left != null) { // 找到右子树的最左侧节点
                next =(TreeLinkNode) next.left;
            }
            return next;
        } else if (node.parent != null && node == node.parent.left) { // 没有右子树且是父节点的左子节点
            return node.parent;
        } else { // 没有右子树且是父节点的右子节点
            TreeLinkNode parent = node.parent;
            while (parent != null && node == parent.right) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


}
