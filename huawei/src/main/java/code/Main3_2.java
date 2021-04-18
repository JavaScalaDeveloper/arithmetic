
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