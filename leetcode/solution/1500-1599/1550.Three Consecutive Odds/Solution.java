package solution._1550;
import java.util.*;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}