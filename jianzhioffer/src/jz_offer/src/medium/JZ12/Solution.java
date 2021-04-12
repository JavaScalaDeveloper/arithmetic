package jz_offer.src.medium.JZ12;

public class Solution {
    public double Power1(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double Power2(double base, int exponent) {
        double pow = 1.00;
        if (base == 0 && exponent != 0) return 0.00;
        if (exponent == 0 && base != 0) return 1.00;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                pow *= base;
            }
        } else if (exponent < 0) {
            for (int i = 0; i < Math.abs(exponent); i++) {
                pow /= base;
            }
        }
        return pow;
    }
}
