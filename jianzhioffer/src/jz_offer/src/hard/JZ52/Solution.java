package jz_offer.src.hard.JZ52;

import java.util.*;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        return new String(str).matches(new String(pattern));
    }
}
