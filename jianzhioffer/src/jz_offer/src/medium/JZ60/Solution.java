package jz_offer.src.medium.JZ60;

import datastructure.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tools.listnode.TreeNodeUtils;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree();
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.print(treeNode);
        System.out.println(result);
    }
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (pRoot == null) return totalList;
        ArrayList<Integer> partList;
        TreeNode node;
        //局部变量需要自己初始化，成员变量jvm会帮我们初始化
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            /*
            初始size=1，第一次循环size=3
             */
            size = queue.size();
            partList = new ArrayList<>();
            while (size > 0) {
                node = queue.poll();//size--
                partList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);//size++
                size--;
            }
            totalList.add(partList);
        }
        return totalList;
    }
}
