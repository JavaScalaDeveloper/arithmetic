package solution._0219;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (helper.containsKey(nums[i])) {
                int j = helper.get(nums[i]);
                if (i - j <= k) {
                    return true;
                }
            }
            helper.put(nums[i], i);
        }
        return false;
    }
}