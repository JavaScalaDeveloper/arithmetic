package jz_offer.src.easy.JZ34;

import java.util.*;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
