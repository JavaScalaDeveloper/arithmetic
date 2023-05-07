package solution._0746;
import java.util.*;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, cur = 0;
        for (int i = 1, n = cost.length; i < n; ++i) {
            int t = Math.min(cost[i] + cur, cost[i - 1] + pre);
            pre = cur;
            cur = t;
        }
        return cur;
    }
}