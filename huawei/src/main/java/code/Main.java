package main.java.code;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String a="adkjkdjg;ljgdflkjgdfljsiengkmfskjfklsjdfldsjfkdsjfiseejijdfsifjlsdjgkljsglskjgsldkjfdslkfjlskdjfsdlkjflsdjfkfet";
        char b='A';
        for (int i = 0; i < 30; i++) {
            System.out.println(b-i+"  "+(b+i)+"  "+(a.charAt(i)-'A'));
//            System.out.println(char(b));
        }
    }
}