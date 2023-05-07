package solution._0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        List<int[]> res = new ArrayList<>(people.length);
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }
}
