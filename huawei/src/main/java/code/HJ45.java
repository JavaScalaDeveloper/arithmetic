package main.java.code;

import java.io.*;
import java.util.*;

/**
 * HJ45	名字的漂亮度
 * 名字的漂亮度
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 本题含有多组数据。
 * 输入描述:
 * 整数N，后续N个名字
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 * 示例1
 * 输入
 * 2
 * zhangsan
 * lisi
 * 输出
 * 192
 * 101
 */
public class HJ45 {
public static class Main {
    /**
     * 题目理解为：
     * lisi=iils=26+26+25+24
     * zhangsan=aannzhgs=26+25+25+25+24+23+22+21
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String value;
        while ((value = bf.readLine()) != null) {
            int num = Integer.parseInt(value);
            for (int index = 0; index < num; index++) {
                String name = bf.readLine();
                char[] nameChars = name.toCharArray();
                int[] charMaxs = new int[150];
                for (char nameChar : nameChars) {
                    charMaxs[nameChar]++;
                }
                Arrays.sort(charMaxs);
                int max = 26;
                int total = 0;
                for (int indb = charMaxs.length - 1; indb >= 0; indb--) {
                    if (charMaxs[indb] == 0)
                        break;
                    total = total + charMaxs[indb] * max;
                    max--;
                }
                System.out.println(total);
            }
        }
    }
}
}
