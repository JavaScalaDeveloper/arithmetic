package jz_offer.src.medium.JZ43;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str.length() < n) return "";
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
