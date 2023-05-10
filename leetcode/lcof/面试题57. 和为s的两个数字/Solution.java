package lcof.面试题57.和为s的两个数字;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p = 0, q = nums.length - 1;
        while (p < q) {
            int s = nums[p] + nums[q];
            if (s == target) {
                return new int[] {nums[p], nums[q]};
            }
            if (s < target) {
                ++p;
            } else {
                --q;
            }
        }
        return new int[]{0};
    }
}