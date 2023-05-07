package jz_offer.all.JZ45;

import java.util.TreeSet;

import java.util.*;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5)
            return false;
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


