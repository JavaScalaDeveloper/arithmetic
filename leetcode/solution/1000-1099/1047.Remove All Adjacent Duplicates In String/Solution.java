package solution._1047;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String removeDuplicates(String S) {
        char[] cs = new char[S.length()];
        int top = -1;
        for (char c : S.toCharArray()) {
            if (top >= 0 && c == cs[top]) {
                --top;
            } else {
                cs[++top] = c;
            }
        }
        return String.valueOf(cs, 0, top + 1);
    }
}
