package src.main.java._1713;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary.length);
        set.addAll(Arrays.asList(dictionary));

        int[] dp = new int[sentence.length() + 1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[sentence.length()];
    }
}