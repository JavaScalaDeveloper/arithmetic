package jz_offer.all.JZ7;

public class Solution {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int one = 0;
        int two = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
