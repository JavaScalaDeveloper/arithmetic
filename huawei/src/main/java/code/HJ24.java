package main.java.code;

import java.io.*;

public class HJ24 {
    /**
     * HJ24	合唱队
     * 合唱队
     * 题目描述
     * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
     * 说明：
     * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
     * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
     * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
     * 注意不允许改变队列元素的先后顺序
     * 请注意处理多组输入输出！
     * 输入描述:
     * 整数N
     * 输出描述:
     * 最少需要几位同学出列
     * 示例1
     * 输入
     * 8
     * 186 186 150 200 160 130 197 200
     * 输出
     * 4
     */
    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = null;
            while ((str = br.readLine()) != null) {
                if (str.equals("")) continue;
                int n = Integer.parseInt(str);
                int[] heights = new int[n];
                String[] str_heights = br.readLine().split(" ");
                // 当仅有一个人时，其自己组成一个合唱队，出列0人
                if (n <= 1) System.out.println(0);
                else {
                    for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(str_heights[i]);
                    // 记录从左向右的最长递增子序列和从右向左的最长递增子序列
                    int[] seq = new int[n], rev_seq = new int[n];
                    int[] k = new int[n];  // 用于记录以i为终点的从左向右和从右向走的子序列元素个数
                    seq[0] = heights[0];  // 初始化从左向右子序列首元素为第一个元素
                    int index = 1; // 记录当前子序列的长度
                    for (int i = 1; i < n; i++) {
                        if (heights[i] > seq[index - 1]) {  // 当当前元素大于递增序列最后一个元素时
                            k[i] = index;  // 其左边元素个数
                            seq[index++] = heights[i];  // 更新递增序列
                        } else {  // 当当前元素位于目前维护递增序列之间时
                            // 使用二分搜索找到其所属位置
                            int l = 0, r = index - 1;
                            while (l < r) {
                                int mid = l + (r - l) / 2;
                                if (seq[mid] < heights[i]) l = mid + 1;
                                else r = mid;
                            }
                            seq[l] = heights[i];  // 将所属位置值进行替换
                            k[i] = l;  // 其左边元素个数
                        }
                    }
                    // 随后，再从右向左进行上述操作
                    rev_seq[0] = heights[n - 1];
                    index = 1;
                    for (int i = n - 2; i >= 0; i--) {
                        if (heights[i] > rev_seq[index - 1]) {
                            k[i] += index;
                            rev_seq[index++] = heights[i];
                        } else {
                            int l = 0, r = index - 1;
                            while (l < r) {
                                int mid = l + (r - l) / 2;
                                if (rev_seq[mid] < heights[i]) l = mid + 1;
                                else r = mid;
                            }
                            rev_seq[l] = heights[i];
                            k[i] += l;
                        }
                    }
                    int max = 1;
                    for (int num : k)
                        if (max < num) max = num;
                    // max+1为最大的k
                    System.out.println(n - max - 1);
                }
            }
        }
    }
}
