package solution._0231;
import java.util.*;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}