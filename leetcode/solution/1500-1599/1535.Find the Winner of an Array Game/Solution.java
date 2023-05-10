package solution._1535;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int getWinner(int[] arr, int k) {
        int time = 0, max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max > arr[i]) {
                time++;
            } else {
                time = 1;
                max = arr[i];
            }
            if (time >= k) {
                return max;
            }
        }
        return max;
    }
}