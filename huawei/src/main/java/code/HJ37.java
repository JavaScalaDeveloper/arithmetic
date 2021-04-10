package main.java.code;

import java.io.*;

public class HJ37 {
    /**
     * HJ37	统计每个月兔子的总数
     * 统计每个月兔子的总数
     * 题目描述
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 本题有多组数据。
     * 输入描述:
     * 输入int型表示month
     * 输出描述:
     * 输出兔子总数int型
     * 示例1
     * 输入
     * 9
     * 输出
     * 34
     */
    public static class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while ((line = br.readLine()) != null) {
                int monthCount = Integer.parseInt(line);
                System.out.println(getTotalCount(monthCount));
            }
        }

        public static int getTotalCount(int monthCount) {
            int a = 1;
            int b = 1;
            int c = 1;
            for (int i = 2; i < monthCount; ++i) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
