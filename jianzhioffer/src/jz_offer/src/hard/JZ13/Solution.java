package jz_offer.src.hard.JZ13;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tools.listnode.ArrayUtils;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 2, 6, 4, 9, 12, 5, 8, 7, 10};
        solution.reOrderArray(arr);
        System.out.println(ArrayUtils.toList(arr));
    }
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
