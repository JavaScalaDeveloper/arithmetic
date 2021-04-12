package jz_offer.all.JZ47;

public class Soluition {
    public int Sum_Solution(int n) {
        //实际上这样做就是你投机取巧的方式
        //因为给定的等差数列的和
        //n/2+n方/2
        int sum = (int) Math.pow(n, 2) + n;
        //  右移一位除以2
        return sum >> 1;
    }
}