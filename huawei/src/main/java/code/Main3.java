package main.java.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main3 {
    /*
    2222/22
    222222


    #2222/22
    ab
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        boolean flag = true;
        for (char a : chars) {
            if (flag) {
                if (a == '#') {
                    flag = false;
                    sb2.append(a);
                    solv1(sb1.toString());
                    sb1 = new StringBuffer();
                } else {
                    sb1.append(a);
                }
            } else {
                if (a == '#') {
                    flag = true;
                    sb1.append(a);
                    solv2(sb2.toString());
                    sb2 = new StringBuffer();
                } else {
                    sb2.append(a);
                }
            }
        }
        if (!input.contains("#")) {
            solv1(sb1.toString());
        }
    }

    private static void solv1(String sb1) {
        System.out.print(sb1.replace("/", ""));
    }

    private static void solv2(String s) {
        String s1 = ",.abcdefghijklmnopqrstuvwxyz";
        String s2 = "1122233344455566677778889999";
        char[] s1Char = s1.toCharArray();
        char[] chars = s.toCharArray();
        char tem = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != tem) {
                System.out.print(s1Char[i]);
                tem = chars[i];
            }
        }
    }
}

//
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Scanner;
//
//public class Main {
//    /*
//    2222/22
//    222222
//
//
//    #2222/22
//    ab
//     */
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        char[] chars = input.toCharArray();
//        StringBuffer sb1 = new StringBuffer();
//        StringBuffer sb2 = new StringBuffer();
//        for (char a : chars) {
//            if (a != '#') {
//                sb1.append(a);
//            } else sb1.append(a);
//        }
//        solv(sb1.toString(), sb2.toString());
//    }
//
//    private static void solv(String sb1, String sb2) {
//        System.out.print(sb1.replace("/", ""));
//    }
//}