package jz_offer.all.JZ10;

public class Solution {
    public int RectCover(int target) {
        if (target == 1 || target == 2)
            return target;
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 2; i < target; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
