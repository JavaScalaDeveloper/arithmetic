package jz_offer.src.medium.JZ4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        TreeNode treeNode = new Solution().reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }

    @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        //val代表树的根结点的值
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

    }

    //pre 树的前序   in树的中序 根据递归还原出整个树
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0], null, null);
        for (int i = 0; i < in.length; i++) {
//            通过pre的头节点找到in的中间节点
            if (pre[0] == in[i]) {
                int[] newLeftPre = Arrays.copyOfRange(pre, 1, 1 + i);
                int[] newLeftIn = Arrays.copyOfRange(in, 0, i);

                int[] newRightPre = Arrays.copyOfRange(pre, i + 1, pre.length);
                int[] newRightIn = Arrays.copyOfRange(in, i + 1, in.length);
                System.out.println("i=" + i + ",newLeftPre:" + Arrays.toString(newLeftPre) + "\tnewLeftIn:" + Arrays.toString(newLeftIn)
                        + "\tnewRightPre:" + Arrays.toString(newRightPre) + "\tnewRightIn:" + Arrays.toString(newRightIn));
                //copyOfRange左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
