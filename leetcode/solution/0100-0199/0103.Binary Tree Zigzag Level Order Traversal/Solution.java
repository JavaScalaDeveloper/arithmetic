package solution._0103;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        lever(root, 0);
        for (int i = 1; i < list.size(); i = i + 2) {
            List<Integer> nList = list.get(i);
            List<Integer> nnl = new ArrayList<>();
            for (int j = nList.size() - 1; j >= 0; j--) nnl.add(nList.get(j));
            list.set(i, nnl);
        }
        return list;
    }
    private void lever(TreeNode root, int l) {
        if (root == null) return;
        while (l > list.size() - 1) list.add(new ArrayList<>());
        list.get(l++).add(root.val);
        lever(root.left, l);
        lever(root.right, l);
    }
     @Data
    @AllArgsConstructor
    @Builder
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}