package solution._1572;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0, n = mat.length, mid = n >> 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += (mat[i][i] + mat[i][j]);
        }
        return n % 2 == 0 ? sum : sum - mat[mid][mid];
    }
}