package jz_offer.src.easy.JZ48;

public class Solution {
    public int Add(int num1, int num2) {
        int temp = 0;
        if (num2 == 0) return num1;
        while (num2 != 0) {
            temp = num1 ^ num2; //异或，计算无进位和
            num2 = (num1 & num2) << 1; //计算进位
            num1 = temp;
        }
        return temp;
    }
}
