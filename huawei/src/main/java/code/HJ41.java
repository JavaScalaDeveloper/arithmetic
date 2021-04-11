package main.java.code;

import java.util.*;

public class HJ41 {
    /**
     * HJ41	称砝码
     * 称砝码
     * 题目描述
     * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
     * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
     * 注：
     * 称重重量包括0
     * 输入描述:
     * 输入包含多组测试数据。
     * 对于每组测试数据：
     * 第一行：n --- 砝码数(范围[1,10])
     * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
     * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
     * 输出描述:
     * 利用给定的砝码可以称出的不同的重量数
     * 示例1
     * 输入
     * 2
     * 1 2
     * 2 1
     * 输出
     * 5
     */

    public static class Main {
        /**
         * 修正：看别人的做法，是第一个砝码的多种重量放入set，然后是下一个砝码多种可能重量。
         * ！！！这里面比较重要的是根据的是 <目前已有的重量> ，用这些重量加上下一个砝码的所有可能的重量，
         * 以重量为根据，而不是以砝码的多种排列组合为依据.
         * 所以说这个三重循环，第一个是遍历到第几个砝码，第二个是当前的set里面的重量，第三个是当前砝码的所有可能重量
         */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                List<Integer> weightList = new ArrayList<>();
                List<Integer> numList = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                int num = sc.nextInt();
                for (int i = 0; i < num; i++) {
                    weightList.add(sc.nextInt());
                }
                for (int i = 0; i < num; i++) {
                    numList.add(sc.nextInt());
                }
                set.add(0);
                for (int i = 0; i < num; i++) {    //i循环是选择第几个砝码，依次放入set
                    List<Integer> currentList = new ArrayList<>(set);
                    for (Integer integer : currentList) {     //循环是当前set里面的重量，因为set无法用index遍历所以换成List
                        for (int k = 1; k <= numList.get(i); k++) {    //k循环是当前砝码的可能重量，全部加到set目前所有的数值上面
                            set.add(integer + weightList.get(i) * k);   //因为是要计算所有当前的set重量，所以用了无序的HashSet也没事
                        }
                    }
                }
                System.out.println(set.size());
            }
        }
    }
}
