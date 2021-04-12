package jz_offer.all.JZ29;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length)
            return list;
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public int[] quickSort(int[] num, int lo, int hi) {
        if (lo > hi) return num;
        else {
            //将数列最左边第一个数字作为基准数
            int left = lo;
            int right = hi;
            int baseNum = num[lo];
            while (right > left) {
                //第二步：右边指针找到大于基准数的就停下
                while (num[right] >= baseNum && right > left) {
                    right--;
                }
                //第二步：左边指针找到小于基准数的就停下
                while (num[left] <= baseNum && right > left) {
                    left++;
                }
                //交换两个指针最终标记的数字
                if (right > left)
                    swap(num, left, right);
            }
            //当左右两边指针重合时，将基准数与指针指向数字交换
            swap(num, left, lo);
            //指针左半边递归，以进来的数组的左边为界，右边是左右指针相同时左边一个
            quickSort(num, lo, left - 1);
            //右边同理
            quickSort(num, left + 1, hi);
            return num;
        }
    }

    //swap方法：将数组中leftPos和rightPos上的两个数值进行交换
    public void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}
