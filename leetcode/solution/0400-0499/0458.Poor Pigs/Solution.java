package solution._0458;
import java.util.*;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int res = 0;
        int p = 1;
        while (p < buckets) {
            p *= base;
            ++res;
        }
        return res;
    }
}
