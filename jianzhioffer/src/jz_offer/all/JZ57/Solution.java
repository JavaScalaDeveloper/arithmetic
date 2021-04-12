package jz_offer.all.JZ57;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeLinkNode {
        int val = 0;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        //指向父亲结点的指针
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public List<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode node = pNode;
        while (node.next != null) {
            node = node.next;
        }
        inOrder(node);
        for (int i = 0; i < list.size() - 1; i++) {
            if (pNode == list.get(i)) return list.get(i + 1);
        }
        return null;
    }

    public void inOrder(TreeLinkNode node) {
        if (node != null) {
            inOrder(node.left);
            list.add(node);
            inOrder(node.right);
        }
    }
}
