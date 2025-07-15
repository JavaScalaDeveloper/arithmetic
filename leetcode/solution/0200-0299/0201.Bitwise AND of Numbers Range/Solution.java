package solution._0201;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
