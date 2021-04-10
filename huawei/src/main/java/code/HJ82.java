package main.java.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ82	将真分数分解为埃及分数
 * 将真分数分解为埃及分数
 * 题目描述
 * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
 * 如有多个解，请输出任意一个。
 * 请注意本题含有多组样例输入！
 * 输入描述:
 * 输入一个真分数，String型
 * 输出描述:
 * 输出分解后的string
 * 示例1
 * 输入
 * 8/11
 * 2/4
 * 输出
 * 1/2+1/5+1/55+1/110
 * 1/3+1/6
 * 说明
 * 第二个样例直接输出1/2也是可以的
 */
public class HJ82 {
    /**
     * 真分数转埃及分数
     * 先化简
     * 步骤一： 用b除以a，得商数q1及余数r1,即b=a*q1+r1
     * 步骤二： a/b=1/(q1+1）+(a-r1)/b(q1+1）
     * 步骤三： 重复步骤2，直到分解完毕
     * 3/7=1/3+2/21=1/3+1/11+1/231
     * @author Admin
     * @date 2020-12-20
     */
    public static class Main {
        public static void main(String[] args){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            try {
                while((str = br.readLine())!= null){
                    String[] strArr = str.split("\\/");
                    int a = Integer.parseInt(strArr[0]);
                    int b = Integer.parseInt(strArr[1]);
                    String[] resArr = new String[1];
                    f(a, b, "", resArr);
                    System.out.println(resArr[0]);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void f(int a, int b, String resStr, String[] resArr){
            if(a==1 || b%a==0){
                int val = b/a;
                resStr += 1+"/"+val;
                resArr[0] = resStr;
            }
            else{
                int q1 = b/a;
                int r1 = b%a;
                int val1 = q1+1;
                resStr += 1+"/"+val1+"+";
                a = a - r1;
                b = b*(q1+1);
                f(a, b, resStr, resArr);
            }
        }
    }
}
