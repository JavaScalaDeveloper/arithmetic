package main.java.code;

import java.io.*;

public class HJ104 {
    /**
     * HJ103	Redraiment的走法
     * Redraiment的走法
     * 题目描述
     * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
     * 本题含有多组样例输入
     * 输入描述:
     * 输入多行，先输入数组的个数，再输入相应个数的整数
     * 输出描述:
     * 输出结果
     * 示例1
     * 输入
     * 6
     * 2 5 1 5 4 5
     * 3
     * 3 2 1
     * 输出
     * 3
     * 1
     * 说明
     * 6个点的高度各为 2 5 1 5 4 5
     * 如从第1格开始走,最多为3步, 2 4 5
     * 从第2格开始走,最多只有1步,5
     * 而从第3格开始走最多有3步,1 4 5
     * 从第5格开始走最多有2步,4 5
     * 所以这个结果是3。
     */
public static class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = read.readLine()) != null) {
            int num = Integer.parseInt(input);
            String[] strs = read.readLine().split(" ");
            int[] nums = new int[num];
            int max = 0;
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] result = new int[num];
            for (int i = 0; i < nums.length; i++) {
                result[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        result[i] = Math.max(result[i], result[j] + 1);
                    }
                }
            }
            max = 1;
            for (int j : result) {
                if (j > max) {
                    max = j;
                }
            }
            System.out.println(max);
        }
    }
}
}
