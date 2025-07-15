package src.main.java._0501;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            N &= ~(1 << k);
        }
        return N ^ (M << i);
    }
}