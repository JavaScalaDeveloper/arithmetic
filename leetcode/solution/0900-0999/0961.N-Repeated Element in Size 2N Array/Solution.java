package solution._0961;
import java.util.*;

public class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            if (set.contains(e)) {
                return e;
            }
            set.add(e);
        }
        return 0;
    }
}