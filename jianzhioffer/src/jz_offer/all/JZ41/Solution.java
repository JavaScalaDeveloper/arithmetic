package jz_offer.all.JZ41;

import java.util.ArrayList;

import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int l = 1;
        int r = 2;
        list.add(l);
        list.add(r);
        while (l < (sum + 1) / 2) {
            int temp = cal(l, r);
            if (temp < sum) {
                r++;
                list.add(r);
            } else if (temp == sum) {
                //加入到ans中需要新生成一个对象，不然会随着引用list不断改变
                ans.add(new ArrayList<>(list));
                r++;
                list.add(r);
            } else {
                l++;
                list.remove(0);
            }
        }
        return ans;
    }

    public static int cal(int l, int r) {
        return (l + r) * (r - l + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(3));
    }
}
