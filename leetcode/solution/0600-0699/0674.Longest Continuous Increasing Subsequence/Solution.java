package solution._0674;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n;
        if ((n = nums.length) < 2) return n;
        int res = 1, f = 1;
        for (int i = 1; i < n; ++i) {
            f = 1 + (nums[i - 1] < nums[i] ? f : 0);
            res = Math.max(res, f);
        }
        return res;
    }
}