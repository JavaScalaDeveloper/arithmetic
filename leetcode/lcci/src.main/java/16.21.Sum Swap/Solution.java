package src.main.java._1621;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int diff = sum(array1) - sum(array2);
        if ((diff & 1) == 1) {
            return new int[]{};
        }
        diff >>= 1;
        Set<Integer> s = Arrays.stream(array2).boxed().collect(Collectors.toSet());
        for (int e : array1) {
            if (s.contains((e - diff))) {
                return new int[]{e, e - diff};
            }
        }
        return new int[]{};
    }

    private int sum(int[] array) {
        int res = 0;
        for (int e : array) {
            res += e;
        }
        return res;
    }
}