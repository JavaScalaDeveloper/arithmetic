package solution._0978;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int up = 1, down = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) {
                up = down + 1;
                down = 1;
                res = Math.max(res, up);
            } else if (A[i] < A[i - 1]) {
                down = up + 1;
                up = 1;
                res = Math.max(res, down);
            } else {
                up = 1;
                down = 1;
            }
        }
        return res;
    }
}
