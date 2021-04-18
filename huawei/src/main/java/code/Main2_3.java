package main.java.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2_3 {
    /*
     1/N 2/Y 3/N 4/Y
     1/Y 2/Y 3/Y 4/Y
     1/N 2/N 3/N 4/N
     6/N 2/Y 3/N 4/Y 8/N
     6/N 2/Y 3/N 4/Y 8/N 10/N
     6/N 2/Y 3/N 4/Y 8/N 10/N 16/Y
     6/N 2/Y 3/N 4/Y 8/N 10/N 16/Y 1/N 18/N 22/N 23/N
     1/N 2/N 3/N 4/Y
     1 2
     3 4
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] s = input.split(" ");
        int[] a = new int[s.length];
        int[] b = new int[s.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            try {
                //0代表N,1代表Y
                a[i] = s[i].split("/")[1].equals("N") ? 0 : 1;
                b[i] = Integer.parseInt(s[i].split("/")[0]);
            } catch (Exception e) {
                System.out.println("ERROR");
            }
            if (b[i] > 999 || b[i] <= 0 || list.contains(b[i])) {
                System.out.println("ERROR");
                return;
            }
            list.add(b[i]);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int flag = 1;
        for (int i = 0; i < b.length; i++) {
            if (flag == 1) {
                if (a[i] == 1) {
                    list1.add(b[i]);
                    flag = 1;
                } else {
                    list2.add(b[i]);
                    flag = 2;
                }
            } else {
                if (a[i] == 1) {
                    list2.add(b[i]);
                } else {
                    list1.add(b[i]);
                    flag = 1;
                }
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.size() == 0) {
            list1 = list2;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (i == list1.size() - 1) {
                System.out.print(list1.get(i));
            } else {
                System.out.print(list1.get(i) + " ");
            }
        }
        System.out.println();
        if (list2.size() > 0) {
            for (int i = 0; i < list2.size(); i++) {
                if (i == list2.size() - 1) {
                    System.out.print(list2.get(i));
                } else {
                    System.out.print(list2.get(i) + " ");
                }
            }
        } else {
            System.out.println();
        }
    }
}