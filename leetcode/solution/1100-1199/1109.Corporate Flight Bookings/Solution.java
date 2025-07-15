package solution._1109;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int b = booking[0] - 1, e = booking[1], k = booking[2];
            res[b] += k;
            if (e < n) {
                res[e] -= k;
            }
        }
        for (int i = 1; i < n; ++i) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
