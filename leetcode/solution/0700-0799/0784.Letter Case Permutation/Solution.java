package solution._0784;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] cs = S.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(cs, 0, res);
        return res;
    }

    private void dfs(char[] cs, int i, List<String> res) {
        if (i == cs.length) {
            res.add(String.valueOf(cs));
            return;
        }
        dfs(cs, i + 1, res);
        if (cs[i] >= 'A') {
            cs[i] ^= 32;
            dfs(cs, i + 1, res);
        }
    }
}
