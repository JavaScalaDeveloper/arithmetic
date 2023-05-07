package solution._0252;

import java.util.Arrays;
import java.util.Comparator;

import java.util.*;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0, n = intervals.length; i < n - 1; ++i) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}