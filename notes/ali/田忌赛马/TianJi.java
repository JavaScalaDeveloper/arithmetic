import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TianJi {
    public static void main(String[] args) {
        List<Integer> xiaotiantian = new ArrayList<Integer>();
        List<Integer> xiaoqiqi = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字数组，并用空格分隔(田忌的马)：");
        String a = sc.nextLine();
        String[] arr1 = a.split(" ");
        for (String s : arr1) {
            xiaotiantian.add(Integer.parseInt(s));
        }
        System.out.println("请输入一串数字数组，并用空格分隔(齐王的马)：");
        String b = sc.nextLine();
        String[] arr2 = b.split(" ");
        for (int i = 0; i < arr1.length; i++) {
            xiaoqiqi.add(Integer.parseInt(arr2[i]));
        }
        int n = xiaotiantian.size();
        boolean bLast = true;
        while (bLast) {
            if (n == 0) {
                break;
            }
            //处理数据
            Collections.sort(xiaotiantian);
            Collections.sort(xiaoqiqi);
            int i = 0, j = 0, x = n - 1, y = n - 1, cnt = 0;
            while (bLast) {
                //是否是最后一匹马
                if (x == i) {
                    bLast = false;
                }
                if (xiaotiantian.get(x) > xiaoqiqi.get(y)) {//如果田忌当前最好的马可以胜齐王最好的马，那么比一场
                    x--;
                    y--;
                    cnt++;
                } else if (xiaotiantian.get(i) > xiaoqiqi.get(j)) {//如果田忌当前最差的马可以胜齐王最差的马，那么比一场
                    i++;
                    j++;
                    cnt++;
                } else if (xiaotiantian.get(i) < xiaoqiqi.get(y)) {//否则，让田忌最差的马和齐王最好的好比一场
                    i++;
                    y--;
                }
            }
            System.out.println("田忌可以赢得的比赛场次是：" + cnt);
            xiaotiantian.clear();
            xiaoqiqi.clear();
        }
    }
}
