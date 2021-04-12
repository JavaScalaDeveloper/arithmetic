package jz_offer.all.JZ8;

public class Solution {
    public int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
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
