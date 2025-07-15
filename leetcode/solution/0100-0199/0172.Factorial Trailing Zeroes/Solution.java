package solution._0172;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int trailingZeroes(int n) {
        int t = 0;
        while (n >= 5) {
            t += n / 5;
            n /= 5;
        }
        return t;
    }
}