package lcof.面试题16.数值的整数次方;

public class Solution {
    public static void main(String[] args) {
        Solution m = new Solution();
        double result = m.myPow(10, 10);
        System.out.println(result);
    }
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }
}