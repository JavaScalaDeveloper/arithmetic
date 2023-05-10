package solution._0191;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
