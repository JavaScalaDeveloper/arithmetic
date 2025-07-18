package solution._0198;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int t = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}