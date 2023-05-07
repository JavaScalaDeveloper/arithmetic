package jz_offer.all.JZ26;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree, list);
        return Convert(list);
    }

    //中序遍历，将TreeNode存入list集合
    public void Convert(TreeNode pRootOfTree, List<TreeNode> list) {
        if (pRootOfTree.left != null) Convert(pRootOfTree.left, list);
        list.add(pRootOfTree);
        if (pRootOfTree.right != null) Convert(pRootOfTree.right, list);
    }

    //添加节点间的指针关系即可，这样就得到双向链表
    public TreeNode Convert(List<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
}
