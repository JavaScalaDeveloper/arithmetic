package jz_offer.src.medium.JZ43;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str.length() < n) return "";
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
