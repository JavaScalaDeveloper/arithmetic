package solution._0771;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray()) {
            set.add(ch);
        }
        int res = 0;
        for (char ch : S.toCharArray()) {
            res += (set.contains(ch) ? 1 : 0);
        }
        return res;
    }
}