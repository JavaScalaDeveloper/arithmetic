package lcof._065;
import java.util.*;

public class Solution {
    public int add(int a, int b) {
        if (b == 0) return a;
        return add(a ^ b, (a & b) << 1);
    }
}