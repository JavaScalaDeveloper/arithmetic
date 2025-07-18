package src.main.java._0801;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1, b = 2, c = 4;
        for (int i = 4; i <= n; ++i) {
            int t = a;
            a = b;
            b = c;
            c = ((a + b) % 1000000007 + t) % 1000000007;
        }
        return c;
    }
}