package jz_offer.all.JZ13;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

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
