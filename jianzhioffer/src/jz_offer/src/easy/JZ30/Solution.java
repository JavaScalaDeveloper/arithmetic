package jz_offer.src.easy.JZ30;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 2, -2, 5, 9, -3, 1};
        int result = findGreatestSumOfSubArray(arr);
        System.out.println(result);
    }

    public static int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
