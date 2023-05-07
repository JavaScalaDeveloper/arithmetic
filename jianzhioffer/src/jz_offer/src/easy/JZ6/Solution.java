package jz_offer.src.easy.JZ6;

import java.util.*;

public class Solution {
    //暴力解法
    /*public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int ans = array[0];
        for (int i = 1; i < array.length; i++) {
            ans=Math.min(ans,array[i]);
        }
        return ans;
    }*/

    //通过二分的方法
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] > array[r]) l = mid + 1;
            else if (array[mid] < array[r]) r = mid;
            else r--;
        }
        return array[r];
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }
}
