package jz_offer.all.JZ50;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                map.put(numbers[i], null);
            }
        }
        return false;
    }
}
