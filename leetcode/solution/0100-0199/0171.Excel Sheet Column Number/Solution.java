package solution._0171;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int n = 0;
        int p = 1;
        for (int i = cs.length-1; i >= 0; i--) {
            n += (cs[i]-'A'+1)*p;
            p *= 26;
        }
        return n;
    }
}