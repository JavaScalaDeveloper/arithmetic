package jz_offer.src.medium.JZ53;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isNumeric2("12e");
        System.out.println(result);
    }
    public boolean isNumeric(char[] str) {
        String num = new String(str);
        if (num.endsWith("f") || num.endsWith("F") || num.endsWith("d") || num.endsWith("D"))
            return false;
        try {
            Double.parseDouble(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 分别构造正则表达式进行匹配：
     *
     * 小数点之前和之后都可以为空，因此整数和小数部分的正则表达式分别为："[+-]?\d*(.\d*)?" 和 "[+-]?\d*.\d+"
     * 如果字符串存在e（或E），则它左右两侧必须都是数字，同时指数部分可以有正负号，因此指数部分的正则表达式为："[eE][+-]?\d+"
     * 最终正则表达式为："[+-]?\d*(.\d*)?([eE][+-]?\d+)?"
     * @param s
     * @return
     */
    public boolean isNumeric2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉开头和结尾的空格
        s = s.trim();
        //判断是否可以有符号位
        boolean hasSign = (s.charAt(0) == '+' || s.charAt(0) == '-');
        int i = hasSign ? 1 : 0;
        //判断是否存在小数点、e和对应的数字
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasNumber = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if (c == '.') {
                if (hasE || hasPoint) {
                    return false;
                }
                hasPoint = true;
            } else if (c == 'e' || c == 'E') {
                if (!hasNumber || hasE) {
                    return false;
                }
                hasE = true;
                hasNumber = false; //指数部分不能有小数点，因此需要重新检测是否存在数字
            } else if (c == '+' || c == '-') {
                if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        //判断最后一个字符是否为数字
        char lastChar = s.charAt(s.length() - 1);
        return (lastChar >= '0' && lastChar <= '9') || lastChar == '.' || lastChar == 'e' || lastChar == 'E';
    }

}
