package solution._0581;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = nums[i];
        }
        Arrays.sort(res);
        int p = 0;
        for (; p < n; ++p) {
            if (res[p] != nums[p]) {
                break;
            }
        }
        int q = n - 1;
        for (; q >= 0; --q) {
            if (res[q] != nums[q]) {
                break;
            }
        }
        return p == n ? 0 : q - p + 1 ;
    }
}