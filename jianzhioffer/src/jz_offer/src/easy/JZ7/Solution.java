package jz_offer.src.easy.JZ7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int f1 = fibonacci(10);
        int f2 = fibonacci2(10);
        System.out.println(f1);
        System.out.println(f2);
    }
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
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

    public static int fibonacci2(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci2(n-1)+fibonacci2(n-2);
    }
}
