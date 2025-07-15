package jz_offer.all.JZ4;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
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
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0],null,null);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                //copyOfRange左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + i), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
