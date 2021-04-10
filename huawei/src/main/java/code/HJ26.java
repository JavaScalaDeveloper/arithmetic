package main.java.code;

import java.io.*;

public class HJ26 {
    /**
     * HJ26	字符串排序
     * 字符串排序
     * 题目描述
     * 编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
     * 输入描述:
     * 输入字符串
     * 输出描述:
     * 输出字符串
     * 示例1
     * 输入
     * A Famous Saying: Much Ado About Nothing (2012/8).
     * 输出
     * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
     */

    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                char[] ch = s.toCharArray();
                char[] chars = new char[ch.length];
                int flag = 65, j = 0;
                while (flag <= 90) {
                    for (char c : ch) {
                        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                            if (c == flag || c == flag + 32) {
                                chars[j] = c;
                                j++;
                            }
                        }
                    }
                    flag++;
                }
                j = 0;
                for (int i = 0; i < ch.length; i++) {
                    if ((ch[i] >= 65 && ch[i] <= 90) || (ch[i] >= 97 && ch[i] <= 122)) {
                        ch[i] = chars[j];
                        j++;
                    }
                }
                System.out.println(String.valueOf(ch));
            }
        }
    }
}
