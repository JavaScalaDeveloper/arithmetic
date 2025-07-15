package lcof.面试题50.第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        if ("".equals(s)) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.get(c) == null ? 1 : 1 + map.get(c));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}