package solution._0454;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }
}
