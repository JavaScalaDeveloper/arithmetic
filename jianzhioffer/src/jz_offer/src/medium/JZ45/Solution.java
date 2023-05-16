package jz_offer.src.medium.JZ45;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 0, 0, 5};
        boolean result = solution.isContinuous(arr);
        System.out.println(result);
    }
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        TreeSet<Integer> set = new TreeSet<>();
        int num = 0;
        for (int number : numbers) {
            if (number == 0) num++;
            else set.add(number);
        }
        if ((set.size() + num) != 5) return false;
        return set.last() - set.first() < 5;
    }
}