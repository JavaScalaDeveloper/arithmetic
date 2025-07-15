package jz_offer.src.easy.JZ50;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

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
