package src.main.java._0104;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : chars) {
            counter.put(ch, counter.get(ch) == null ? 1 : counter.get(ch) + 1);
        }
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                ++cnt;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt <= 1;
    }
}