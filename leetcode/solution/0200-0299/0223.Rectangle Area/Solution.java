package solution._0223;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = (long) Math.min(C, G) - Math.max(A, E);
        long y = (long) Math.min(D, H) - Math.max(B, F);
        int intersection = x > 0 && y > 0 ? (int) (x * y) : 0;
        return (C - A) * (D - B) + (G - E) * (H - F) - intersection;
    }
}
