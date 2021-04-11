package main.java.code;

import java.util.Scanner;

public class HJ71_2 {
    /**
     * 实现通配符
     * ? 匹配一个字符  [0-9A-Za-z]{1}
     * * 匹配0个或以上的字符  [0-9A-Za-z]{0,}
     * （字符由英文字母和数字0-9组成，不区分大小写。下同）
     */
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String regx = scanner.nextLine();
                String string = scanner.nextLine();
                //做相应的替换
                regx = regx.replaceAll("\\?", "[0-9A-Za-z]{1}");
                regx = regx.replaceAll("\\*", "[0-9A-Za-z]{0,}");
                regx = regx.replaceAll("\\.", "\\\\.");
                //matches() 方法用于检测字符串是否匹配给定的正则表达式。
                boolean result = string.matches(regx);
                System.out.println(result);
            }
        }
    }

    /**
     * Java 递归
     */
    public static class Main2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                String s1 = in.nextLine();
                String s2 = in.nextLine();
                System.out.println(helper(s1, s2, 0, 0));
            }
        }

        private static boolean helper(String s1, String s2, int p1, int p2) {
            if (p1 == s1.length() && p2 == s2.length()) {
                return true;
            } else if (p1 == s1.length() || p2 == s2.length()) {
                return false;
            }
            //遇到'*'两种情况，要不就各跳过一个比较后面，要不就s2继续往后跳先不比较
            if (s1.charAt(p1) == '*') {
                return helper(s1, s2, p1, p2 + 1) || helper(s1, s2, p1 + 1, p2 + 1);
                //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
            } else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)) {
                return helper(s1, s2, p1 + 1, p2 + 1);
            } else {
                return false;
            }
        }
    }
}
