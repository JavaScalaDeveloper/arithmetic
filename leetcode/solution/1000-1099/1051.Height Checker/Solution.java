package solution._1051;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != copy[i]) {
                ++res;
            }
        }
        return res;
    }
}
