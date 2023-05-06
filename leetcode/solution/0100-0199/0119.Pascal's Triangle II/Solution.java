package solution._0119;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new LinkedList<>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            ret.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return ret;
    }
}