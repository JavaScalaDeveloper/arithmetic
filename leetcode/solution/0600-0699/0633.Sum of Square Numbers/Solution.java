package solution._0633;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int s = i * i + j * j;
            if (s < c) {
                ++i;
            } else if (s > c) {
                --j;
            } else {
                return true;
            }
        }
        return false;
    }
}
