package solution._0268;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0, n = res; i < n; ++i) {
            res ^= (i ^ nums[i]);
        }
        return res;
    }
}