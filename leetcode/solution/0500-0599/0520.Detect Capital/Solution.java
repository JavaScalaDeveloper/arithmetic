package solution._0520;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean detectCapitalUse(String word) {
        char[] cs = word.toCharArray();
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a') {
                lower++;
            } else {
                upper++;
            }
        }
        if (upper == cs.length) {
            return true;
        }
        if (lower == cs.length) {
            return true;
        }
        if (upper == 1 && cs[0] < 'a') {
            return true;
        }
        return false;
    }
}
