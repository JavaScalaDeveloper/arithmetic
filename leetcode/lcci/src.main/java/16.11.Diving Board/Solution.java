package src.main.java._1611;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (longer == shorter) {
            return new int[]{longer * k};
        }
        int[] ans = new int[k + 1];
        for (int i = 0;i <= k;i++) {
            ans[i] = longer * i + shorter * (k - i);
        }
        return ans;
    }
}