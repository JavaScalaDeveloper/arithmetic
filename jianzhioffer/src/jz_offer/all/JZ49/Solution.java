package jz_offer.all.JZ49;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int StrToInt(String str) {
        int len = str.length();
        int index = 0;
        // 第一步，删除前面的空格
        while (index < len) {
            if (str.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }
        int flag = 0;
        long ans = 0; // 最终返回的结果
        while (index < len) {
            // "3-2"
            if (str.charAt(index) == '-' || str.charAt(index) == '+') {
                if (flag != 0) {
                    return 0; // "-123-3", 第二个-号是非法字符， 返回0
                }
                flag = str.charAt(index) == '-' ? -1 : 1;
            } else if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                ans = ans * 10 + str.charAt(index) - '0'; // "-123"
                if (judge(ans, flag)) { // 对ans是否溢出int类型做下判断
                    return 0;
                }
            } else {
                return 0; // 既不是数字，也不是正负号，那就是其他字符了，返回0
            }
            index++;
        }
        return flag == -1 ? (int) ans * (-1) : (int) ans;
    }

    private boolean judge(long ans, int flag) {
        if (flag == -1) {
            return ans * (-1) < Integer.MIN_VALUE;
        } else {
            return ans > Integer.MAX_VALUE;
        }
    }
}
