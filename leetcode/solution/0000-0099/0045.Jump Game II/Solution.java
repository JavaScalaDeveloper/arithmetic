package solution._0045;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int jump(int[] nums) {
        int cnt = 0,last = 0, next = 1;
        for (;next < nums.length;cnt++){
            int i = last;
            last = next;
            for (; i < last; ++i) if (i + nums[i] >= next) next = i + nums[i] + 1;
        }
        return cnt;
    }
}