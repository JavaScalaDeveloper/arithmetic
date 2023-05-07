package jz_offer.src.easy.JZ51;

import java.util.*;

public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            B[i] = 1;
            A[i] = 1;
            for (int k : A) {
                B[i] *= k;
            }
            A[i] = temp;
        }
        return B;
    }
}
