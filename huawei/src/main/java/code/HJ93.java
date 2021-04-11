package main.java.code;

import java.util.*;

public class HJ93 {
public static class Main {
    /**
     * HJ93	201301 JAVA题目0-1级
     * 数组分组
     * 题目描述
     * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
     * 本题含有多组样例输入。
     * 输入描述:
     * 第一行是数据个数，第二行是输入的数据
     * 输出描述:
     * 返回true或者false
     * 示例1
     * 输入
     * 4
     * 1 5 -5 1
     * 3
     * 3 5 8
     * 输出
     * true
     * 说明
     * 第一个样例：
     * 第一组：5 -5 1
     * 第二组：1
     * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
     */
    public static void main(String[] args) {
        /*
          思路：
          先把三和五的倍数都挑出来，算好两边的和sum3和sum5，所有数总和为sum，求出target = sum/2 - sum3，把剩余的数放在一起，转化成在一个list中找能不能凑出target
         */
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            //这里用不上sum5
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int cur = in.nextInt();
                if (cur % 3 == 0) sum3 += cur;
                else list.add(cur);
                sum += cur;
            }
            int target = sum / 2 - sum3;
            if (sum % 2 != 0) System.out.println("false");
            else System.out.println(helper(list, target));
        }
    }

    private static boolean helper(LinkedList<Integer> list, int target) {
        return helper(0, list, target);
    }

    private static boolean helper(int l, LinkedList<Integer> list, int target) {
        if (l == list.size()) return target == 0;
        return helper(l + 1, list, target - list.get(l)) || helper(l + 1, list, target);
    }
}
}
