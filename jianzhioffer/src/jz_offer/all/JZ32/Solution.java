package jz_offer.all.JZ32;

import java.util.*;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int b = Integer.parseInt(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int number : numbers) {
            str.append(number);
        }
        return str.toString();
    }
}
