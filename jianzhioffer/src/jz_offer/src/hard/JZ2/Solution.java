package jz_offer.src.hard.JZ2;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') sb.append("%20");
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
