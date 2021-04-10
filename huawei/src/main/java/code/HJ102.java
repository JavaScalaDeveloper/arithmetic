package main.java.code;

import java.io.*;

public class HJ102 {
    /**
     * 题目描述
     * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
     * 本题含有多组样例输入
     * 输入描述:
     * 一个只包含小写英文字母和数字的字符串。
     * 输出描述:
     * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
     * 示例1
     * 输入
     * aaddccdc
     * 1b1bbbbbbbbb
     * 输出
     * cda
     * b1
     * 说明
     * 第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
     */
public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = br.readLine()) != null) {
                char[] chArr = str.toCharArray();
                int[] temp = new int[150];
                for (char c : chArr) {
                    temp[c]++;
                }
                int max = 0;
                for (int i : temp) {
                    if (max < i) {
                        max = i;
                    }
                }
                StringBuilder sbf = new StringBuilder();
                while (max != 0) {
                    for (int j = 0; j < temp.length; j++) {
                        if (temp[j] == max) {
                            sbf.append((char) j);
                        }
                    }
                    max--;
                }
                System.out.println(sbf);
            }
        }
    }
}
