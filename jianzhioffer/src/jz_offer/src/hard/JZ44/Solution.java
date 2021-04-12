package jz_offer.src.hard.JZ44;

public class Solution {
    public String ReverseSentence(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.trim().equals("")) return str;
        String[] strs = str.split(" ");
        for (int i = strs.length - 1; i > 0; i--) {
            sb.append(strs[i]).append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}
