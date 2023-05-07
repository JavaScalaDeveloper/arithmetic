package solution._0977;
import java.util.*;

public class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0, n = A.length; i < n; ++i) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}