import lombok.Data;

/*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(new TreeNode(null, null, 7), new TreeNode(null, null, 2), 11), null, 4),
                new TreeNode(new TreeNode(null, null, 13), new TreeNode(new TreeNode(null, null, 5), new TreeNode(null, null, 1), 4), 8), 5);
        int i = pathSum(root, 22);
        System.out.println(i);
    }

    static int ans = 0;

    public static int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return ans;
    }

    static void traverse(TreeNode root, int sum) {
        if (root == null) return;
        ans += dfs(root, sum, 0);
        traverse(root.left, sum);
        traverse(root.right, sum);
    }

    // check if sum of path is sum.
    static int dfs(TreeNode root, int sum, int cur) {
        if (root == null) return 0;
        cur += root.val;
        int res = 0;
        if (cur == sum) res++;
        res += dfs(root.left, sum, cur);
        res += dfs(root.right, sum, cur);
        return res;
    }
}

@Data
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}