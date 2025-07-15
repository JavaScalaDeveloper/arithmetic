package jz_offer.src.medium.JZ37;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    //暴力解法
    /*public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k)
                count++;
        }
        return count;
    }*/
    //二分查找法
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) return 0;
        int firstPositon = getFirstPositionOfK(array, k);
        int lastPositon = getLastPositionOfK(array, k);
        if (array[firstPositon] != k) return 0;
        return lastPositon - firstPositon + 1;
    }

    public int getFirstPositionOfK(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] < k) {
                l = mid + 1;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                if (mid - 1 >= 0 && array[mid - 1] == array[mid]) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return l;
    }

    public int getLastPositionOfK(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (array[mid] < k) {
                l = mid + 1;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                if (mid + 1 <= array.length && array[mid + 1] == array[mid]) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return l;
    }
}
