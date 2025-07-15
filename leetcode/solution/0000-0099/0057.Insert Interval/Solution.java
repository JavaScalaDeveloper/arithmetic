/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
package solution._0057;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new LinkedList<>();
        int i = 0;
        while ((i < intervals.size()) && (intervals.get(i).end < newInterval.start)) list.add(intervals.get(i++));
        while ((i < intervals.size()) && (intervals.get(i).start <= newInterval.end)) {
            newInterval = new Interval(
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            i++;
        }
        list.add(newInterval);
        while (i < intervals.size()) list.add(intervals.get(i++));
        return list;
    }
     class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}