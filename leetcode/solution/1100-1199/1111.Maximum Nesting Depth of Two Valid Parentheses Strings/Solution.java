package solution._1111;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        for (int i = 0, cnt = 0; i < res.length; ++i) {
            if (seq.charAt(i) == '(') {
                res[i] = cnt++ & 1;
            } else {
                res[i] = --cnt & 1;
            }
        }
        return res;
    }
}
