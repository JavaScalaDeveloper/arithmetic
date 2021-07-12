package main.java;

public class Main {
    /**
     * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
     * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
     * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
     * 示例 1：
     * <p>
     * 输入：s = "loveleetcode", c = "e"
     * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
     * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
     * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
     * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 3 。
     * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
     * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
     * 示例 2：
     * <p>
     * 输入：s = "aaab", c = "b"
     * 输出：[3,2,1,0]
     *  
     * 提示：
     * 1 <= s.length <= 104
     * s[i] 和 c 均为小写英文字母
     * 题目数据保证 c 在 s 中至少出现一次
     */
    public static void main(String[] args) {
        /*
         * s = "loveleetcode", c = "e"
//         * [1,1,1,0,1,0,0,1,1,1,1,0]
         * [3,2,1,0,1,0,0,1,2,2,1,0]
         */
        String s = "loveleetcode", c = "e";
        func(s, c);
//        func("aaab","b");
    }

    private static void func(String s, String c) {
        int[] a = new int[s.length()];
        int index = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == c.charAt(0)) {
                a[i] = 0;
                //往左
                for (int i1 = i - 1; i1 >= index; i1--) {
                    if (s.charAt(i1) != c.charAt(0)) {
                        if ((i1 - index) <<2 <i-index) {
                            a[i1] = Math.abs(i - i1);
                        } else {
                            a[i1] = Math.abs(i1 - index);
                        }
                    } else {
                        break;
                    }
                }
                index = i;
            }
        }
        for (int i : a) {
            System.out.print(i + "  ");
        }
    }
}
