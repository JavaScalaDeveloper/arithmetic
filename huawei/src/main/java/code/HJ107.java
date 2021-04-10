package main.java.code;

import java.io.*;

public class HJ107 {
    /**
     * HJ107	求解立方根
     * 求解立方根
     * 题目描述
     * 计算一个数字的立方根，不使用库函数。
     * 保留一位小数。
     * 输入描述:
     * 待求解参数，为double类型（一个实数）
     * 输出描述:
     * 输入参数的立方根。保留一位小数。
     * 示例1
     * 输入
     * 216
     * 输出
     * 6.0
     */

public static class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            double d = Double.parseDouble(str);
            System.out.println(getCubeRoot(d));
        }
    }

    public static double getCubeRoot(double num) {
        boolean f = false;
        boolean l = false;
        if (num < 0) {
            f = true;
            num = num * (-1);
        }
        if (num > 0 && num < 1) {
            l = true;
            num = 1 / num;
        }
        double start = 0.0;
        double end = num;
        double middel = start;
        while (start < end) {
            middel = (start + end) / 2;
            double r = middel * middel * middel;
            double diff = Math.abs(r - num);
            if (diff < 0.0001) {
                break;
            } else if (r > num) {
                end = middel;
            } else {
                start = middel;
            }
        }
        if (f) {
            middel = middel * -1;
        }
        if (l) {
            middel = 1 / middel;
        }
        //Math.round对正数四舍五入
        return Math.round(middel * 10.0) / 10.0;
    }
}
}
