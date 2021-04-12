package jz_offer.all.JZ52;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return new String(str).matches(new String(pattern));
    }
}
