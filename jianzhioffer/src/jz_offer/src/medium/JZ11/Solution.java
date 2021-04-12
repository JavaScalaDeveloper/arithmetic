package jz_offer.src.medium.JZ11;

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        if (n == 0) return 0;
        while (n != 0) {
            if (n < 0) ++count;
            n = (n << 1);
        }
        return count;
    }

    //另一种方法，返回整数的二进制数，然后进行判断
    //数值用==比较，字符串用equals比较，字符char用=='1'
    /*public int NumberOf1(int n) {
        String str=Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                ++count;
        }
        return count;
    }*/
}
