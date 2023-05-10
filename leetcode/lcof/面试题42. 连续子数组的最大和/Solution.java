package lcof.面试题42.连续子数组的最大和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], f = nums[0];
        for (int i = 1, n = nums.length; i < n; ++i) {
            f = nums[i] + Math.max(f, 0);
            res = Math.max(res, f);
        }
        return res;
    }
}