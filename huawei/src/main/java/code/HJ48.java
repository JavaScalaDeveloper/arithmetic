package main.java.code;
import java.io.*;
public class HJ48 {
    /**
     * HJ48	从单向链表中删除指定值的节点
     * 从单向链表中删除指定值的节点
     * 题目描述
     * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
     * 链表的值不能重复。
     * 构造过程，例如
     * 1 <- 2
     * 3 <- 2
     * 5 <- 1
     * 4 <- 5
     * 7 <- 2
     * 最后的链表的顺序为 2 7 3 1 5 4
     * 删除 结点 2
     * 则结果为 7 3 1 5 4
     * 链表长度不大于1000，每个节点的值不大于10000。
     * 本题含有多组样例。
     * 输入描述:
     * 1 输入链表结点个数
     * 2 输入头结点的值
     * 3 按照格式插入各个结点
     * 4 输入要删除的结点的值
     * 输出描述:
     * 输出删除结点后的序列，每个数后都要加空格
     * 示例1
     * 输入
     * 5
     * 2
     * 3 2
     * 4 3
     * 5 2
     * 1 4
     * 3
     * 输出
     * 2 5 4 1
     */
    public static class Main {
        //构建节点
        public static class Node {
            Node next;
            int val;
            Node(int val) {
                this.val = val;
                next = null;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            while ((str = br.readLine()) != null) {
                if (str.equals("")) continue;
                String[] params = str.split(" ");//str.split(" ")将字符串按空格分开并返回为字符串数组的形式
                int n = Integer.parseInt(params[0]);
                Node head = new Node(Integer.parseInt(params[1]));//将字符串数字默认转换为整型的十进制数，使用的是Integer类
                for (int i = 1; i < n; i++) {
                    int pre = Integer.parseInt(params[2*i+1]), nxt = Integer.parseInt(params[2*i]);
                    Node temp = head;
                    while (temp.val != pre) temp = temp.next;//遍历插入点的位置
                    Node node = new Node(nxt);
                    node.next = temp.next;
                    temp.next = node;
                }
                int del = Integer.parseInt(params[2*n]);
                StringBuilder ans = new StringBuilder();//StringBuilder类可以更改字符串，不会占用多余的空间，始终是一个数组
                Node temp = head;
                while (temp != null) {
                    if (temp.val != del) ans.append(temp.val).append(" ");//append为StringBuilder类中添加字符串的方法
                    temp = temp.next;
                }
                // 注意要求每个数后面都加空格
                System.out.println(ans.toString());//转换为字符串格式
            }
        }
    }
}
