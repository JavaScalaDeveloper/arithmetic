package jz_offer.src.hard.JZ64;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) return list;
        int low = 0;
        int high = size - 1;
        int len = num.length;
        int index = -1;
        int max = num[0];
        while (high < len) {
            if (index >= low && index <= high) {
                if (max < num[high]) {
                    max = num[high];
                    index = high;
                }
            } else {
                max = num[low];
                index = low;
                for (int i = low + 1; i <= high; i++) {
                    if (max < num[i]) {
                        max = num[i];
                        index = i;
                    }
                }
            }
            low++;
            high++;
            list.add(max);
        }
        return list;
    }
}
