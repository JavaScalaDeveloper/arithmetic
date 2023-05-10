package jz_offer.src.medium.JZ53;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean isNumeric(char[] str) {
        String num = new String(str);
        if (num.endsWith("f") || num.endsWith("F") || num.endsWith("d") || num.endsWith("D"))
            return false;
        try {
            Double.parseDouble(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
