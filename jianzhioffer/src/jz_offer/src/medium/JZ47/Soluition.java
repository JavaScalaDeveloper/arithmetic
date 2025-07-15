package jz_offer.src.medium.JZ47;

public class Soluition {
    public static void main(String[] args) {
        int n=10;
        Soluition soluition = new Soluition();
        int result1 = soluition.solve1(10);
        int result2 = soluition.solve2(10);
        System.out.println(result1);
        System.out.println(result2);
    }
    public int solve1(int n) {
        //实际上这样做就是你投机取巧的方式
        //因为给定的等差数列的和
        //n/2+n方/2
        int sum = (int) Math.pow(n, 2) + n;
        //  右移一位除以2
        return sum >> 1;
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int solve2(int n) {
        boolean flag = n > 0 && (n += solve2(n - 1)) > 0; // 利用逻辑运算符实现递归函数
        return n;
    }
}