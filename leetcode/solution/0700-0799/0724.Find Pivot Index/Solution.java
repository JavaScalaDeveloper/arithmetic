package solution._0724;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (s << 1 == sum - nums[i]) {
                return i;
            }
            s += nums[i];
        }
        return -1;
    }
}
