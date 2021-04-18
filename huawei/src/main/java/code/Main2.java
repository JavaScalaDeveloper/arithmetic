package main.java.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    /*
     1/N 2/Y 3/N 4/Y
     1 2
     3 4
     */
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        while ((input = br.readLine()) != null) {
        try {
            String[] s = input.split(" ");
            int[] a = new int[s.length];
            int[] b = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                //0代表N,1代表Y
                a[i] = s[i].charAt(2) == 78 ? 0 : 1;
                b[i] = Integer.parseInt(s[i].split("/")[0]);
            }
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            boolean c = true;
            for (int i = 0; i < b.length - 1; i++) {
                if (a[i + 1] == 1 && c) {
                    list1.add(b[i]);
                    list1.add(b[i + 1]);
                    c = false;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (!list1.contains(b[i])) {
                    list2.add(b[i]);
                }
            }
            Collections.sort(list1);
            Collections.sort(list2);
            for (int i = 0; i < list1.size(); i++) {
                if (i == list1.size() - 1) {
                    System.out.print(list1.get(i));
                } else {
                    System.out.print(list1.get(i) + " ");
                }
            }
            System.out.println();
            for (int i = 0; i < list2.size(); i++) {
                if (i == list2.size() - 1) {
                    System.out.print(list2.get(i));
                } else {
                    System.out.print(list2.get(i) + " ");
                }
            }
        } catch (Exception e) {
            System.out.println("ERROE");
        }
//        }
    }

}
//        while ((input = br.readLine()) != null) {
//            String[] s = input.split(" ");
//            int[] as = new int[s.length];
//            for (int i = 0; i < s.length; i++) {
//                //o代表n
//                as[i] = s[i].charAt(2) == 78 ? 0 : 1;
//            }
//            List<Integer> list1 = new ArrayList<>();
//            List<Integer> list2 = new ArrayList<>();
//            boolean b=true;
//            for (int i = 0; i < as.length-1; i++) {
//                if (as[i + 1] == 1&&b) {
//                    list1.add(i+1);
//                    list1.add(i + 2);
//                    b=false;
//                }
//            }
//            for (int a : as) {
//                if (!list1.contains(a)) {
//                    list2.add(a);
//                }
//            }
//            for (int i = 0; i < list1.size(); i++) {
//                if (i == list1.size() - 1) {
//                    System.out.print(list1.get(i));
//                } else {
//                    System.out.print(list1.get(i) + " ");
//                }
//            }
//            System.out.println();
//            for (int i = 0; i < list2.size(); i++) {
//                if (i == list2.size() - 1) {
//                    System.out.print(list2.get(i));
//                } else {
//                    System.out.print(list2.get(i) + " ");
//                }
//            }
//        }
