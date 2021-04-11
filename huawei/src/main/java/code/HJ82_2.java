package main.java.code;

import java.util.*;

public class HJ82_2 {

public static class Main {
    /**
     * 数学家斐波那契提出的一种求解***分数的贪心算法，准确的算法表述应该是这样的：
     * 设某个真分数的分子为a，分母为b;
     * 把c=(b/a+1)作为分解式中第一个***分数的分母；
     * 将a-b%a作为新的a；
     * 将b*c作为新的b；
     * 如果a等于1，则最后一个***分数为1/b,算法结束；
     * 如果a大于1但是a能整除b，则最后一个***分数为1/(b/a),算法结束；
     * 否则重复上面的步骤。
     **/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            StringBuilder res = new StringBuilder();
            String[] arr = in.nextLine().split("/");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            while (true) {
                int c = b / a + 1;
                res.append("1/");
                res.append(c);
                a = a - b % a;
                b = b * c;
                res.append("+");
                if (a == 1) {
                    res.append("1/");
                    res.append(b);
                    break;
                } else if (a > 1 && b % a == 0) {
                    res.append("1/");
                    res.append(b / a);
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
}
