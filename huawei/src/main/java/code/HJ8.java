package main.java.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ8 {
    /**
     *HJ8	合并表记录
     * 题目描述
     * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * 输出描述:
     * 输出合并后的键值对（多行）
     * 示例1
     * 输入
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出
     * 0 3
     * 1 2
     * 3 4
     */
public static class Main{
        public static void main(String[] args) throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String in;
            while((in=reader.readLine())!=null){
                int num = Integer.parseInt(in);
                int[] arr = new int[1000];
                for(int i = 0; i<num ; i++){
                    String input = reader.readLine();
                    int index = input.indexOf(' ');
                    int key =Integer.parseInt(input.substring(0,index));
                    int value = Integer.parseInt(input.substring(index+1));
                    arr[key]+=value;
                }
                StringBuilder out=new StringBuilder();
                for(int i=0;i<arr.length;i++){
                    if(arr[i]>0){
                        out.append(i).append(' ').append(arr[i]).append('\n');
                    }
                }
                System.out.println(out);
            }
        }
    }
}
