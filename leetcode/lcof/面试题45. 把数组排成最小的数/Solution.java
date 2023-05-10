package lcof.面试题45.把数组排成最小的数;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
                .reduce((s1, s2) -> s1 + s2).get();
    }
}