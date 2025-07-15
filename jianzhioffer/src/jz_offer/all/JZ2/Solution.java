package jz_offer.all.JZ2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
