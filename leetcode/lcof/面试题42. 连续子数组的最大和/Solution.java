package lcof._042;
import java.util.*;

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