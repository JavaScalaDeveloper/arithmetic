package jz_offer.src.easy.JZ48;

public class Solution {
    public static void main(String[] args) {
//        int result = new Solution().add(5, 6);
        int result2 = new Solution().add(5, 17);
//        System.out.println(result);
        System.out.println(result2);
    }

    /*

      @param num1=5
      @param num2=6
      第1次循环：无进位 101 ^ 110=011
                 进位  101 & 110 =100, 100<<1= 1000
       第2次循环：无进位 0011^1000 =1011
                 进位  0


       @param num1=5
       @param num2=17
      第1次循环：无进位 00101 ^ 10001=10100
                 进位  00101 & 10001 =00001, 00001<<1= 00010
       第2次循环：无进位 10100^00010 =10110
                 进位  10100 & 00010 =00000, 00000<<1= 00000
      @return
     */
    public int add(int num1, int num2) {
        int temp = 0;
        if (num2 == 0) return num1;
        while (num2 != 0) {
//            101 ^ 110=011
            temp = num1 ^ num2; //异或，和计算无进位
//            101 & 110 =100, 100<<1= 1000
            num2 = (num1 & num2) << 1; //计算进位
            num1 = temp;
        }
        return temp;
    }
}

