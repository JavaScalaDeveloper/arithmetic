package solution._1004;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) --K;
            if (K < 0 && A[l++] == 0) ++K;
        }
        return r - l;
    }
}
