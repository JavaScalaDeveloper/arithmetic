package jz_offer.src.medium.JZ21;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5,3,2,1};
        Solution solution = new Solution();
        boolean result = solution.isPopOrder(arr1, arr2);
        System.out.println(result);
    }
    public boolean isPopOrder(int[] pushA, int[] popA) {
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
