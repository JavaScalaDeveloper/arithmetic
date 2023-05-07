package lcof._014;
import java.util.*;

public class Solution {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        if (n == 4) return res << 2;
        return res * n;
    }
}