package jz_offer.src.medium.JZ21;

import java.util.*;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int k : pushA) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
