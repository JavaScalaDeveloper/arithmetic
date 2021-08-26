package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * //评测题目: 无
 *
 * <1> 数组排序
 * 输入 [1,3,5,2,6]
 * 输出 [1,2,3,5,6]
 *
 * <2> 输出杨辉三角
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 1
 * 1   1
 * 1   2   1
 * 1   3   3   1
 * 1   4   6   4   1
 * 1   5   10  10  5   1
 * <p>
 * 样例
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * <3> 简单计算器 加减乘除
 * 编写一段代码能够解析，四则运算的字符串，并且输出计算结果，运算符包括(“+”,“-”,“*”,“/”)，不包括括号和空格，整数除法仅保留整数部分
 * <p>
 * 样例：
 * 输入 3+3*5 输出 18
 * 输入 3/2 输出 1
 * 输入 3+5/2 输出 5
 */
public class AliHankeOuter {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 6};
        System.out.println(Arrays.toString(solv1(arr)));
        System.out.println(solv2(5));
        System.out.println(solv3("3+5/2+0"));
//        System.out.println(3+5/2);
//        System.out.println(3+3*5);
    }

    private static int solv3(String s) {
        //不考虑除0的情况
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] != '*' && chars[i] != '/' || i == s.length() - 1) {
                if (res != 0) {
                    list.add(res);
                    res = 0;
                }
            }
            if (chars[i] == '+') {
                list.add(chars[i - 1] - 48);
            } else if (chars[i] == '-') {
                list.add(-chars[i - 1] - 48);
            } else if (chars[i] == '*') {
                res = (chars[i - 1] - 48) * (chars[i + 1] - 48);
            } else if (chars[i] == '/') {
                res = (chars[i - 1] - 48) / (chars[i + 1] - 48);
            }
        }
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private static List<List<Integer>> solv2(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                boolean b = j == i || j == 0;
                row.add(b ? 1 : 0);
            }
            for (int j = 1; j < i; j++) {
                int res = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                row.set(j, res);
            }
            list.add(row);
        }
        return list;
    }

    private static int[] solv1(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }


}
