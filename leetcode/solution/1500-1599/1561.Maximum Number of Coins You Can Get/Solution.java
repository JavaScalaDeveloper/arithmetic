package solution._1561;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int start = 0, end = piles.length - 1, ans = 0;
        while (start < end) {
            ans += piles[end - 1];
            start++;
            end -= 2;
        }
        return ans;
    }
}