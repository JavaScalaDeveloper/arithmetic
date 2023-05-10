package jz_offer.src.easy.JZ9;

public class Solution {
    public static void main(String[] args) {
        int f1 = JumpFloorII(10);
        int f2 = JumpFloorIII(10);
        System.out.println(f1);
        System.out.println(f2);
    }

    public static int JumpFloorII(int target) {
        int sum = 1;
        if (target == 0 || target == 1) return 1;
        for (int i = 1; i < target; i++) {
            sum *= 2;
        }
        return sum;
    }

    public static int JumpFloorIII(int target) {
        if (target < 2) {
            return target;
        }
        return JumpFloorIII(target - 1) * 2;
    }

}
