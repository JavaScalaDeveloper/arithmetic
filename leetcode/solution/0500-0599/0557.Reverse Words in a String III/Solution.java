package solution._0557;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String reverseWords(String s) {
        String flag = " ";
        StringBuilder result = new StringBuilder();
        for (String temp : s.split(flag)) {
            for (int i = temp.length() - 1; i >= 0; i--) {
                result.append(temp.charAt(i));
            }
            result.append(flag);
        }
        return result.toString().substring(0, s.length());
    }
}