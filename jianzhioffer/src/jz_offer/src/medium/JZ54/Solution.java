package jz_offer.src.medium.JZ54;

import java.util.*;

public class Solution {
    public Map<Character, Integer> map = new HashMap<>();
    public StringBuffer str = new StringBuffer();
    public int index = 0;

    public void Insert(char ch) {
        str.append(ch);
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce() {
        while (index < str.length()) {
            if (map.get(str.charAt(index)) == 1) return str.charAt(index);
            index++;
        }
        return '#';
    }
}
