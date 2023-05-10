package jz_offer.src.medium.JZ42;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int a = array[l] + array[r];
            if (a < sum) {
                l++;
            } else if (a > sum) {
                r--;
            } else {
                //易证首尾指针，第一组遇到的是最小的，因此直接返回
                list.add(array[l]);
                list.add(array[r]);
                return list;
            }
        }
        return list;
    }
}
