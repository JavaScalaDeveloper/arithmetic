package main.java.code;

import java.io.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;
import java.util.stream.Collectors;

public class HJ18 {
    /**
     * HJ18	识别有效的IP地址和掩码并进行分类统计
     * 识别有效的IP地址和掩码并进行分类统计
     * 题目描述
     * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
     * 所有的IP地址划分为 A,B,C,D,E五类
     * A类地址1.0.0.0~126.255.255.255;
     * B类地址128.0.0.0~191.255.255.255;
     * C类地址192.0.0.0~223.255.255.255;
     * D类地址224.0.0.0~239.255.255.255；
     * E类地址240.0.0.0~255.255.255.255
     * 私网IP范围是：
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
     * 注意二进制下全是1或者全是0均为非法
     * 注意：
     * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
     * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
     * 输入描述:
     * 多行字符串。每行一个IP地址和掩码，用~隔开。
     * 输出描述:
     * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
     * 示例1
     * 输入
     * 10.70.44.68~255.254.255.0
     * 1.0.0.1~255.0.0.0
     * 192.168.0.2~255.255.255.0
     * 19..0.~255.255.255.0
     * 输出
     * 1 0 1 0 0 2 1
     */
public static class Main {
    /**
     * 该代码在牛客网上通过，在idea中无法运行
     * 先判断子网掩码是否正确，方法是将子网掩码转换成32位0/1组成的二进制字符串，那么怎样判断掩码合法呢，只需要判断该二进制中第一个0和最后一个1的位置即可，只要第一个0在的位置比最后一个1的位置较前则掩码非法，反则合法；然后如果掩码合法，接着判断IP是否合法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int isA = 0;
        int isB = 0;
        int isC = 0;
        int isD = 0;
        int isE = 0;
        int isEroor = 0;
        int isPrivate = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] ips = str.split("~");
            //判断掩码是否合法
            boolean isMask = false;
            String[] maskArr = ips[1].split("\\.");
            StringBuilder binaryMask = new StringBuilder();
            //形成掩码二进制字符串
            for (String s : maskArr) {
                StringBuilder binaryStr = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s)));
                //凑成4组8位二进制
                for (int j = 0; j < 8 - binaryStr.length(); j++) {
                    binaryStr.insert(0, "0");
                }
                binaryMask.append(binaryStr);
            }
            //比较二进制字符串中第一个0的位置和最后一个1的位置来判断掩码是否合法
            isMask = binaryMask.indexOf("0") >= binaryMask.lastIndexOf("1");
            //掩码合法后再来判断IP是否合法
            if (isMask) {
                String[] strArr = ips[0].split("\\.");
                if (strArr.length == 4) {
                    int[] ipArr = new int[4];
                    for (int i = 0; i < 4; i++) {
                        if (strArr[i].equals("")) {
                            ipArr[i] = -1;
                        } else {
                            ipArr[i] = Integer.parseInt(strArr[i]);
                        }
                    }
                    if ((0 <= ipArr[0] && ipArr[0] <= 255) && (0 <= ipArr[1] && ipArr[1] <= 255) && (0 <= ipArr[2] && ipArr[2] <= 255) && (0 <= ipArr[3] && ipArr[3] <= 255)) {
                        if (ipArr[0] >= 1 && ipArr[0] <= 126) {
                            isA++;
                            if (ipArr[0] == 10)
                                isPrivate++;
                        } else if (ipArr[0] >= 128 && ipArr[0] <= 191) {
                            isB++;
                            if (ipArr[0] == 172 && (ipArr[1] >= 16 && ipArr[1] <= 31))
                                isPrivate++;
                        } else if (ipArr[0] >= 192 && ipArr[0] <= 223) {
                            isC++;
                            if (ipArr[0] == 192 && ipArr[1] == 168)
                                isPrivate++;
                        } else if (ipArr[0] >= 224 && ipArr[0] <= 239) {
                            isD++;
                        } else if (ipArr[0] >= 240) {
                            isE++;
                        }
                    } else {
                        isEroor++;
                    }
                } else {
                    isEroor++;
                }
            } else {
                isEroor++;
            }
        }
        System.out.println(isA + " " + isB + " " + isC + " " + isD + " " + isE + " " + isEroor + " " + isPrivate);
        sc.close();
    }
}
}
