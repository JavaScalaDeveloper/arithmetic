package solution._1021;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (++cnt > 1) {
                    res.append('(');
                }
            } else {
                if (--cnt > 0) {
                    res.append(')');
                }
            }
        }
        return res.toString();
    }
}
