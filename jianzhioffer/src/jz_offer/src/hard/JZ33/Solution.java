package jz_offer.src.hard.JZ33;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] a = new int[index];
        //第一个丑数是1
        a[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1; i < index; i++) {
            a[i] = Math.min(Math.min(a[index1] * 2, a[index2] * 3), a[index3] * 5);
            if (a[index1] * 2 == a[i]) index1++;
            if (a[index2] * 3 == a[i]) index2++;
            if (a[index3] * 5 == a[i]) index3++;
        }
        return a[index - 1];
    }
}
