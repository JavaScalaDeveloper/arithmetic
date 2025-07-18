package solution._0887;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int superEggDrop(int K, int N) {
        int[] res = new int[K];
        Arrays.fill(res, 1);
        while (res[K - 1] < N) {
            for (int i = K - 1; i >= 1; i--) {
                res[i] = res[i] + res[i - 1] + 1;
            }
            res[0]++;
        }
        return res[0];
    }
}