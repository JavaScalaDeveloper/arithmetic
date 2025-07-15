package jz_offer.src.medium.JZ43;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "abcDEFghiJKLMN";
        Solution solution = new Solution();
        String result = solution.leftRotateString(s, 5);
        System.out.println(result);
    }
    public String leftRotateString(String str, int n) {
        if (str.length() < n) return "";
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
