package jz_offer.all.JZ46;

import java.util.LinkedList;
import java.util.List;

import java.util.*;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int p = 0;
        while (list.size() != 1) {
            p = (p + m - 1) % list.size();
            list.remove(p);
        }
        return list.get(0);
    }
}
