package solution._0118;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        for (int i = 0; i < numRows; ++i) {
            // 每一行
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < i + 1; ++j) {
                boolean firstOrLast = j == 0 || j == i;
                // 设置每一行首尾元素为1，其它元素为0
                t.add(firstOrLast ? 1 : 0);
            }
            for (int j = 1; j < i; ++j) {
                int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                t.set(j, val);
            }
            res.add(t);
        }
        return res;
    }
}