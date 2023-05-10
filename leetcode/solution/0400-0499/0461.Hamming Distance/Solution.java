package solution._0461;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0, sum = x ^ y;
        while (sum != 0) {
            sum &= (sum - 1);
            count++;
        }
        return count;
    }
}