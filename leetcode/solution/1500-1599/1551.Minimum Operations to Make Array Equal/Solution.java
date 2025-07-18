package solution._1551;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int curr = 2 * i + 1;
            ans += Math.abs(n - curr);
        }
        return ans;
    }
}