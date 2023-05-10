package solution._0275;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (citations[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }
} 
