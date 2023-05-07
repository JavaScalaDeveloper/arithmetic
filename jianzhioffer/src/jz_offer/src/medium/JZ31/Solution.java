package jz_offer.src.medium.JZ31;

import java.util.*;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 1) {
                    count++;
                    break;
                }
                j /= 10;
            }
        }
        return count;
    }
}
