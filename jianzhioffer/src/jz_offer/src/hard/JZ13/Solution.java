package jz_offer.src.hard.JZ13;

public class Solution {
    public void reOrderArray(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;
        for (int j : array) {
            if (j % 2 != 0) {
                temp[index] = j;
                index++;
            }
        }
        for (int j : array) {
            if (j % 2 == 0) {
                temp[index] = j;
                index++;
            }
        }
        //等价于System.arraycopy(temp, 0, array, 0, temp.length);
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }
}
