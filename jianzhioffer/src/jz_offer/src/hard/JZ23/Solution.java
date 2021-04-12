package jz_offer.src.hard.JZ23;

import java.util.*;

public class Solution {
    public boolean verify(ArrayList<Integer> list) {
        if (list.size() == 0 || list.size() == 1) return true;
        ArrayList<Integer> minList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        int endNumber = list.get(list.size() - 1);
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < endNumber) {
                if (minIndex == -1) minIndex = i;
                minList.add(list.get(i));
            }
            if (list.get(i) > endNumber) {
                if (maxIndex == -1) maxIndex = i;
                maxList.add(list.get(i));
            }
        }
        if (minIndex != -1 && maxIndex != -1) {
            if (minIndex > maxIndex) return false;
            for (int i = maxIndex; i < list.size(); i++) {
                if (list.get(i) < endNumber) return false;
            }
        }
        return verify(minList) && verify(maxList);
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        ArrayList<Integer> list = new ArrayList<>();
        if (sequence.length == 0) return false;
        for (int j : sequence) {
            list.add(j);
        }
        return verify(list);
    }
}
