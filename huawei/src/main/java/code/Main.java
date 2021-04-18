package main.java.code;

import java.io.*;

import java.util.*;

public class Main {
    /**
     * 输入
     * 8
     * 123 124 125 121 119 122 126 123
     * 输出
     * 1 2 6 5 5 6 0 0
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            String[] h = br.readLine().split(" ");
            int[] hs = new int[n + 1];
            int[] res = new int[n + 1];
            if (n < 1) {
                return;
            }
            if (h.length >= n) {
                for (int i = 0; i < h.length; i++) {
                    hs[i] = Integer.parseInt(h[i]);
                    res[i] = 0;
                }
                for (int i = 0; i < hs.length; i++) {
                    for (int j = i + 1; j < hs.length; j++) {
                        if (hs[j] > hs[i]) {
                            res[i] = j;
                            break;
                        }
                    }
                }
                for (int i = 0; i < res.length - 1; i++) {
                    if (i == res.length - 2) {
                        System.out.print(res[i]);
                    } else {
                        System.out.print(res[i] + " ");
                    }
                }
            }
        }
    }
}
/**
 * Scanner scanner = new Scanner(System.in);
 * int n=scanner.nextInt();
 * String hights = scanner.nextLine();
 * String hights ;
 * while (hights=scanner.nextLine()!=null){
 * <p>
 * }
 * String[] h = hights.split(" ");
 * int[] hs=new  int[n + 1];
 * if (h.length >= n) {
 * for (int i = 0; i < h.length; i++) {
 * hs[i]=hs[i];
 * }
 * System.out.println(hs);
 * }
 */