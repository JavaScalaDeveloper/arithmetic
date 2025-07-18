package solution._0117;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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

    private class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        public TreeLinkNode(int val, TreeLinkNode left, TreeLinkNode right, TreeLinkNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}