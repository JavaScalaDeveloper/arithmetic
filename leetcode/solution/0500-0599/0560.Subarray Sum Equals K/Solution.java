package solution._0560;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            res += map.getOrDefault(s - k, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return res;
    }
}
