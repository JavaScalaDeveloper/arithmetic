package jz_offer.all.JZ43;

import java.util.*;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str.length() < n) return "";
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
