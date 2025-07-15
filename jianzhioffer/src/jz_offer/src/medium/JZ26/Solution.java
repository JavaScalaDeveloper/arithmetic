package jz_offer.src.medium.JZ26;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        Solution solution = new Solution();
        TreeNode result = solution.convert(treeNode);
        System.out.println(result.toString());
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

    }

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        List<TreeNode> list = new ArrayList<>();
        convert(pRootOfTree, list);
        return convert(list);
    }

    //中序遍历，将TreeNode存入list集合
    public void convert(TreeNode pRootOfTree, List<TreeNode> list) {
        if (pRootOfTree.left != null) convert(pRootOfTree.left, list);
        list.add(pRootOfTree);
        if (pRootOfTree.right != null) convert(pRootOfTree.right, list);
    }

    //添加节点间的指针关系即可，这样就得到双向链表
    public TreeNode convert(List<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }
}
