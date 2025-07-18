package solution._0852;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (A[mid] > A[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
