package solution._1012;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int res = 0;
        int exp = 0;
        while (N != 0) {
            int bit = N % 2 == 0 ? 1 : 0;
            res += Math.pow(2, exp) * bit;
            ++exp;
            N >>= 1;
        }
        return res;
    }
}