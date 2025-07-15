package jz_offer.src.medium.JZ31;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.solve(13);
        int result2 = solution.solve2(13);
        System.out.println(result1);
        System.out.println(result2);
    }
    /**
     * 对于整数n，我们可以分别计算它的个位、十位、百位……中1出现的次数，最后将这些次数相加即可得到整个数中1出现的总次数。
     * <p>
     * 假设待计算的整数为n，它的某一位是d，那么：
     * <p>
     * 当d>1时，该位上1的个数为(digit+8)/10 * base + last，其中digit表示d之前的高位数字，base表示该位的基数（个位为1，十位为10，百位为100），last表示d之后的低位数字
     * 当d=1时，该位上1的个数为digit * base + last + 1
     * 当d=0时，该位上1的个数为digit * base
     */
    public int solve2(int n) {
        int count = 0;  // 记录1的个数
        int base = 1;   // 记录当前位数的基数
        while (n >= base) {
            int digit = n / base % 10;  // 获取当前位的数字
            int last = n % base;        // 获取当前位后面的数字
            count += digit * (base / 10) * (base > 10 ? 1 : 0) + (digit == 1 ? last + 1 : 0);
            base *= 10;
        }
        /*
        以上代码中，当当前位的基数大于10时，才需要加上(digit+8)/10 * base的部分，因为个位数上不能再进位。
        而在digit的计算中，需要特别处理当前位是最高位的情况，此时不需要加上(digit+8)/10 * base的部分。
         */
        return count;
    }

    /**
     * 暴力
     *
     * @param n n
     * @return 个数
     */
    public int solve(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 1) {
                    count++;
                    break;
                }
                j /= 10;
            }
        }
        return count;
    }
}
