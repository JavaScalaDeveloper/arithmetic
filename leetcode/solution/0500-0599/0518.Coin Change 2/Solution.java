package solution._0518;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                f[i] += f[i - coin];
            }
        }
        return f[amount];
    }
}
